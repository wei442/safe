package com.cloud.consumer.safe.controller;

import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.redis.keys.RedisKeysUtil;
import com.cloud.common.security.KeyFactoryUtil;
import com.cloud.common.util.IpUtil;
import com.cloud.consumer.safe.service.IRedisLockService;
import com.cloud.consumer.safe.service.IRedisService;
import com.cloud.consumer.safe.util.TokenUtil;

import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 控制基类 BaseController
 * @author wei.yong
 */
@RestController
public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	//redis Service
	@Autowired
	protected IRedisService redisService;

	//redis lock Service
	@Autowired
	protected IRedisLockService redisLockService;

	//开发和线上环境配置
	@Value("${spring.profiles.active}")
	protected String springProfilesActive;

	//token的rsa的私钥
	@Value("${token.rsa.privateKey}")
	protected String rsaPrivateKeyStr;

	//实时排名100名，因为redis存储的下标是从0开始，所以是99
	protected final Integer realRank = 99;
	//昨日排名100名，因为redis存储的下标是从0开始，所以是99
	protected final Integer yesterdayRank = 99;

	//排名10000个
	protected final Integer sortRank = 10000;

	/**
	 * 设置token 在response header里面
	 * @param response
	 * @param token (proxyAddr作为token)
	 */
	protected void setResponseHeader(String token) {
		logger.info("(BaseController-setResponseHeader)-传入参数, token:{}", token);
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
		response.setHeader(CommConstants.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.setHeader(CommConstants.TOKEN, token);
		logger.info("(BaseController-setResponseHeader)-response设置header里token, token:{}", token);
	}

	/**
	 * 获取跨域header
	 * @param response
	 */
	protected void setCrossOriginHeader(HttpServletResponse response) {
		// 指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        //是否发送cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods", RequestMethod.POST.toString());
        // 响应头设置
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
	}

	/**
	 * 设置token,过期时间为7*24小时
	 * @param enterpriseId
	 * @param userId
	 * @param userAccount
	 * @return String
	 */
	protected String setToken(Integer enterpriseId,Integer userId,String userAccount) {
		logger.info("(BaseController-setToken)-redis设置token-传入参数, enterpriseId:{}, userId:{}, userAccount:{}", enterpriseId, userId, userAccount);
		if(null == enterpriseId ||null == userId || StringUtils.isBlank(userAccount)) {
			return null;
		}

		String tokenkey = RedisKeysUtil.CN_CLOUD_SAFE_ADMIN_LOGIN_TOKEN + userId;

		PrivateKey privateKey = KeyFactoryUtil.INSTANCE.generateRSAPrivateKey(rsaPrivateKeyStr);
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS512;

		String issuer = CommConstants.CLOUD;
		String audience = CommConstants.CLOUD;
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(CommConstants.ENTERPRISE_ID, enterpriseId);
		claims.put(CommConstants.USER_ID, userId);
		claims.put(CommConstants.USER_ACCOUNT, userAccount);
		logger.info("(BaseController-setToken)-声明(claims), claims:{}", claims);

		String token = TokenUtil.INSTANCE.createJWT(privateKey, signatureAlgorithm, claims, issuer, audience);
		String tokenResult = redisService.setex(tokenkey, CommConstants.TWENTY_FOUR_HOUR_SECONDS_TIME, token);
		logger.info("(BaseController-setToken)-redis设置token-返回信息, tokenkey:{}, tokenResult:{}", tokenkey, tokenResult);
		return token;
	}

	/**
	 * 清除token
	 * @param userId
	 */
	protected void clearToken(Integer userId) {
		logger.info("(BaseController-clearToken)-清除token-传入参数, userId:{}", userId);
		if(null == userId) {
			return ;
		}

		String tokenkey = RedisKeysUtil.CN_CLOUD_SAFE_ADMIN_LOGIN_TOKEN + userId;
		if(redisService.exists(tokenkey)) {
			long l = redisService.del(tokenkey);
			logger.info("(BaseController-clearToken)-清除token-返回信息, tokenkey:{}, l:{}", tokenkey, l);
		}
	}


	/**
	 * 获取请求ip
	 * @return String
	 */
	protected String getRequestIp() {
		String ip = IpUtil.getIpAddr(request);
		return ip;
	}

	/**
	 * 获取请求加点URI参数为空，如：user.register.parameter.empty
	 * @return String
	 */
	protected String getRequestParameterEmpty() {
		String requestURI = request.getRequestURI();
		requestURI = StringUtils.substringAfter(requestURI, "/");
		requestURI = StringUtils.replace(requestURI, "/", ".");
		requestURI = Objects.toString(requestURI, "") + ".parameter.empty";
		return requestURI;
	}

	/**
	 * 获取请求加点URI参数错误，如：user.register.parameter.error
	 * @return String
	 */
	protected String getRequestParameterError() {
		String requestURI = request.getRequestURI();
		requestURI = StringUtils.substringAfter(requestURI, "/");
		requestURI = StringUtils.replace(requestURI, "/", ".");
		requestURI = Objects.toString(requestURI, "") + ".parameter.error";
		return requestURI;
	}

	/**
	 * 获取token(payload)
	 * @return JSONObject
	 */
	protected JSONObject getTokenPayload() {
		String token = request.getHeader(CommConstants.TOKEN);
		logger.info("(BaseController-getTokenPayload)-获取token, token:{}", token);
		if(StringUtils.isBlank(token)) {
			return null;
		}

		String[] datas = StringUtils.split(token, ".");
//		String header = null;
		String payload = null;
//		String signature = null;
		try {
//			header = datas[0];
			payload = datas[1];
//			signature = datas[2];
			logger.info("(BaseController-getTokenPayload)-获取payload, payload:{}", payload);
		} catch (Exception e) {
			logger.error("(BaseController-getTokenPayload)-jwt(token)数组转换异常, Exception = {}, message = {}", e, e.getMessage());
		}
		String payloadStr = new String(Base64.decodeBase64(payload), StandardCharsets.UTF_8);
		JSONObject payloadJSON = JSONObject.parseObject(payloadStr);
		return payloadJSON;
	}

	/**
	 * 获取token(enterpriseId)
	 * @return Integer
	 */
	protected Integer getTokenEnterpriseId() {
		JSONObject payloadJSON = this.getTokenPayload();
		Integer enterpriseId = new Integer(Objects.toString(payloadJSON.get(CommConstants.ENTERPRISE_ID)));
		logger.info("(BaseController-getTokenEnterpriseId)-返回信息, enterpriseId:{}", enterpriseId);
		return enterpriseId;
	}

	/**
	 * 获取token(userId)
	 * @return Integer
	 */
	protected Integer getTokenUserId() {
		JSONObject payloadJSON = this.getTokenPayload();
		Integer userId = new Integer(Objects.toString(payloadJSON.get(CommConstants.USER_ID)));
		logger.info("(BaseController-getTokenUserId)-返回信息, userId:{}", userId);
		return userId;
	}

	/**
	 * 获取token(userAccount)
	 * @return String
	 */
	protected String getTokenUserAccount() {
		JSONObject payloadJSON = this.getTokenPayload();
		String userAccount = Objects.toString(payloadJSON.get(CommConstants.USER_ACCOUNT));
		logger.info("(BaseController-getTokenUserAccount)-返回信息, userAccount:{}", userAccount);
		return userAccount;
	}

	/**
	 * 校验参数
	 * @param bindingResult
	 */
//	protected void bindingResult(BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//        	logger.info(">>>>>> {}.{}() valid params is error msg = {}", this.getClass().getSimpleName(), this.getRequestMethodName(), bindingResult.getFieldError().getDefaultMessage());
//        	throw new SafeException(RetSafeAdminResultEnum.PARAMETER_NULL.getCode(), bindingResult.getFieldError().getDefaultMessage());
//        }
//    }

	/**
	 * 获取请求加点URI参数为空，如：user.register.parameter.empty
	 * @return String
	 */
	protected String getRequestMethodName() {
		String requestURI = request.getRequestURI();
		requestURI = StringUtils.substringAfter(requestURI, "/");
		requestURI = StringUtils.replace(requestURI, "/", ".");
		return requestURI;
	}

}