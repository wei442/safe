package com.cloud.consumer.safe.interceptor;

import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.ZuulConstants;
import com.cloud.common.enums.ResultEnum;
import com.cloud.common.enums.safe.RetSafeAdminResultEnum;
import com.cloud.common.jjwt.JJWTUtil;
import com.cloud.common.redis.keys.RedisKeysUtil;
import com.cloud.common.security.KeyFactoryUtil;
import com.cloud.common.util.AjaxUtil;
import com.cloud.common.util.IpUtil;
import com.cloud.consumer.safe.service.IRedisService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

/**
 * token拦截器 TokenInterceptor
 * @author wei.yong
 */
@Component
public class TokenInterceptor extends HandlerInterceptorAdapter {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//redis Service
	@Autowired
	private IRedisService redisService;

	private PublicKey publicKey = null;

	//token的rsa的公钥
	@Value("${token.rsa.publicKey}")
	private String rsaPublicKeyStr;

	 /**
     * preHandle方法是进行处理器拦截用的，顾名思义，该方法将在Controller处理之前进行调用，SpringMVC中的Interceptor拦截器是链式的，可以同时存在
     * 多个Interceptor，然后SpringMVC会根据声明的前后顺序一个接一个的执行，而且所有的Interceptor中的preHandle方法都会在
     * Controller方法调用之前调用。SpringMVC的这种Interceptor链式结构也是可以进行中断的，这种中断方式是令preHandle的返
     * 回值为false，当preHandle的返回值为false的时候整个请求就结束了。
     */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		init();
		String requestUrl = request.getServletPath();
		String ip = IpUtil.getIpAddr(request);
		logger.info("【Token拦截器】(TokenInterceptor-preHandle)-请求url, 请求ip:{}, requestUrl:{}", ip, requestUrl);

		String apiGateway = request.getHeader(ZuulConstants.API_GATEWAY);
		logger.info("【Token拦截器】(TokenInterceptor-preHandle)-请求网关, 请求网关:{}", apiGateway);
		if(!StringUtils.equals(apiGateway, ZuulConstants.API_GATEWAY_SAFE_ADMIN)) {
			String respStr = this.addRetMsg(RetSafeAdminResultEnum.NETWORK_ERROR);
			logger.info("【Token拦截器】(TokenInterceptor-preHandle)-非法请求, respStr:{}", respStr);
			AjaxUtil.printByWriter(response, respStr);
			return false;
		}

		String token = request.getHeader(CommConstants.TOKEN);
		logger.info("【Token拦截器】(TokenInterceptor-preHandle)-获取header(token)数据, token:{}", token);
		if(StringUtils.isBlank(token)) {
			String respStr = this.addRetMsg(RetSafeAdminResultEnum.TOKEN_NULL_ERROR);
			logger.info("【Token拦截器】(TokenInterceptor-preHandle)-token为空, respStr:{}", respStr);
			AjaxUtil.printByWriter(response, respStr);
			return false;
		}

		Claims claims = null;
		try {
			claims = JJWTUtil.INSTANCE.parseJWT(this.publicKey, token);
		} catch (MalformedJwtException e) {
			//not a valid JWS
			logger.error("【Token拦截器】(TokenInterceptor-preHandle)-token格式错误, Exception = {}, message = {}", e, e.getMessage());
        	String respStr = this.addRetMsg(RetSafeAdminResultEnum.TOKEN_JWT_ERROR);
	    	logger.info("【Token拦截器】(TokenInterceptor-preHandle)-token格式错误, respStr:{}", respStr);
			AjaxUtil.printByWriter(response, respStr);
			return false;
        } catch (SignatureException e) {
        	//JWT signature validation fails
        	logger.error("【Token拦截器】(TokenInterceptor-preHandle)-token签名错误, Exception = {}, message = {}", e, e.getMessage());
        	String respStr = this.addRetMsg(RetSafeAdminResultEnum.TOKEN_VERIFY_FAIL_ERROR);
	    	logger.info("【Token拦截器】(TokenInterceptor-preHandle)-token签名错误, respStr:{}", respStr);
	    	AjaxUtil.printByWriter(response, respStr);
			return false;
        }
		String issuer = claims.getIssuer();
		String userId = Objects.toString(claims.get(CommConstants.USER_ID), "");

		//校验失败
		if(!StringUtils.equals(issuer, CommConstants.CLOUD)) {
			String respStr = this.addRetMsg(RetSafeAdminResultEnum.TOKEN_ERROR);
	    	logger.info("【Token拦截器】(TokenInterceptor-preHandle)-发行者(issuer)错误, respStr:{}", respStr);
	    	AjaxUtil.printByWriter(response, respStr);
			return false;
		}

		String tokenkey = RedisKeysUtil.CN_CLOUD_SAFE_ADMIN_LOGIN_TOKEN + userId;
		String redisToken = redisService.get(tokenkey);
		logger.info("【Token拦截器】(TokenInterceptor-preHandle)-获取redis里token, tokenkey:{}, redisToken:{}", tokenkey, redisToken);
		if(StringUtils.isBlank(redisToken)) {
			String respStr = this.addRetMsg(RetSafeAdminResultEnum.TOKEN_EXPIRE);
			logger.info("【Token拦截器】(TokenInterceptor-preHandle)-token已过期 , respStr:{}", respStr);
			AjaxUtil.printByWriter(response, respStr);
			return false;
		} else if(!StringUtils.equals(token, redisToken)) {
			String respStr = this.addRetMsg(RetSafeAdminResultEnum.TOKEN_ERROR);
			logger.info("【Token拦截器】(TokenInterceptor-preHandle)-token错误, respStr:{}", respStr);
			AjaxUtil.printByWriter(response, respStr);
			return false;
		}

		return true;
	}

	/**
     * 这个方法只会在当前这个Interceptor的preHandle方法返回值为true的时候才会执行。postHandle是进行处理器拦截用的，它的执行时间是在处理器进行处理之
     * 后，也就是在Controller的方法调用之后执行，但是它会在DispatcherServlet进行视图的渲染之前执行，也就是说在这个方法中你可以对ModelAndView进行操
     * 作。这个方法的链式结构跟正常访问的方向是相反的，也就是说先声明的Interceptor拦截器该方法反而会后调用，这跟Struts2里面的拦截器的执行过程有点像，
     * 只是Struts2里面的intercept方法中要手动的调用ActionInvocation的invoke方法，Struts2中调用ActionInvocation的invoke方法就是调用下一个Interceptor
     * 或者是调用action，然后要在Interceptor之前调用的内容都写在调用invoke之前，要在Interceptor之后调用的内容都写在调用invoke方法之后。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行。该方法将在整个请求完成之后，也就是DispatcherServlet渲染了视图执行，
     * 这个方法的主要作用是用于清理资源的，当然这个方法也只能在当前这个Interceptor的preHandle方法的返回值为true时才会执行。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    	Integer userId = this.getTokenUserId(request);
    	String tokenkey = RedisKeysUtil.CN_CLOUD_SAFE_ADMIN_LOGIN_TOKEN + userId;
		long l = 0;
		if(redisService.exists(tokenkey)) {
			//redis延续token过期时间
			l = redisService.expire(tokenkey, CommConstants.TWENTY_FOUR_HOUR_SECONDS_TIME);
		}
		logger.info("【Token拦截器】(TokenInterceptor-afterCompletion)-延续token过期时间-返回信息, tokenkey:{}, l:{}", tokenkey, l);
		super.afterCompletion(request, response, handler, ex);
    }

	/**
	 *初始化
	 */
	public void init() {
		if(publicKey == null) {
			this.publicKey = KeyFactoryUtil.INSTANCE.generateRSAPublicKey(rsaPublicKeyStr);
		}
	}

    /**
     * 设置返回信息（编码/编码信息）
     * @param retCode
     * @param retMsg
     * @return String
     */
    public String addRetMsg(ResultEnum enums) {
		JSONObject json = new JSONObject();
    	json.put(CommConstants.RET_CODE, enums.getCode());
    	json.put(CommConstants.RET_MSG, enums.getMsg());
    	return json.toJSONString();
    }

	/**
	 * 获取token(userId)
	 * @return Integer
	 */
	protected Integer getTokenUserId(HttpServletRequest request) {
		String token = request.getHeader(CommConstants.TOKEN);
		if(StringUtils.isBlank(token)) {
			return null;
		}

		String[] datas = StringUtils.split(token, ".");
		String payload = null;
		try {
			payload = datas[1];
		} catch (Exception e) {
			logger.error("【Token拦截器】(TokenInterceptor-getTokenUserId)-jwt(token)数组转换异常, Exception = {}, message = {}", e, e.getMessage());
		}
		String payloadStr = new String(Base64.decodeBase64(payload), StandardCharsets.UTF_8);
		JSONObject payloadJSON = JSONObject.parseObject(payloadStr);

		Integer userId = new Integer(Objects.toString(payloadJSON.get(CommConstants.USER_ID)));
		logger.info("【Token拦截器】(TokenInterceptor-getTokenUserId)-返回信息, userId:{}", userId);
		return userId;
	}

	/**
	 * 清除token
	 * @param token
	 * @return boolean
	 */
    public boolean clearToken(String userId) {
		logger.info("【Token拦截器】(TokenInterceptor-clearToken)-清除token-传入参数, userId:{}", userId);
		boolean flag = false;
		if(StringUtils.isBlank(userId)) {
          return flag;
		}

		String tokenkey = RedisKeysUtil.CN_CLOUD_SAFE_ADMIN_LOGIN_TOKEN + userId;
		long l = redisService.del(tokenkey);
		logger.info("【Token拦截器】(TokenInterceptor-clearToken)-清除token-返回信息, tokenkey:{}, l:{}", tokenkey, l);
		if(l >0) {
			flag = true;
		}
		return flag;
	}

}