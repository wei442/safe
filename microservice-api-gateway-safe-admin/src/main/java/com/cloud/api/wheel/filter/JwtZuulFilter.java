package com.cloud.api.wheel.filter;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.ProxyRequestHelper;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.RetConstants;
import com.cloud.common.util.IpUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.vianet.vport.common.sign.utils.SignUtils;

/**
 * jwtZuul请求过滤 JwtZuulFilter
 * @author wei.yong
 */
public class JwtZuulFilter extends ZuulFilter {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ProxyRequestHelper helper;

	//不需要拦截的url map
	private Map<String, Object> ignoreUriMap;

	//不做jwt拦截,需要做解析jwt的url map
	private Map<String, Object> jwtIgnoreUriMap;

	//不做拦截的url
	@Value("${security.ignore.uri}")
	private String ignoreUri;

	//不做jwt拦截,需要做解析jwt的url
	@Value("${jwt.ignore.uri}")
	private String jwtIgnoreUri;

	//第三方URI资源前缀
	@Value("${third.uri.prefix}")
	private String thirdUriPrefix;

	/**
	 * 是否执行该过滤器，此处为true，说明需要过滤
	 */
	@Override
	public boolean shouldFilter() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		String requestURI = helper.buildZuulRequestURI(request);
		String ip = IpUtil.getIpAddr(request);
		if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-shouldFilter)-请求uri, 请求ip:{}, requestURI:{}", ip, requestURI);
		//设置api网关请求到消费者(consumer)header里面
	    context.addZuulRequestHeader(ZuulConstants.VPORT_API_GATEWAY, ZuulConstants.VPORT_API_GATEWAY);
	    //如果是不需要校验jwt的URI资源，如果是以/third开头，不要过滤
		if(null != MapUtils.getObject(ignoreUriMap, requestURI) || StringUtils.startsWith(requestURI, thirdUriPrefix)) {
			return false;
		}
		return true;
	}

	/**
	 * 前置过滤器
	 */
	@Override
	public String filterType() {
		init();
		return "pre";
	}

	/**
	 *
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
    public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		JwtRequestWrapper wrapper = new JwtRequestWrapper(request);
		String requestURI = helper.buildZuulRequestURI(request);
		if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-jwt签名校验-请求URI, requestURI:{}", requestURI);

		if(null == MapUtils.getObject(jwtIgnoreUriMap, requestURI)) {
			String jwt = wrapper.getJwt();
			if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-获取jwt, jwt:{}", jwt);
			if(StringUtils.isBlank(jwt)) {
		    	String respStr = this.addRetInfo(RetConstants.JWT_ERROR, RetConstants.JWT_NULL_ERROR_MSG, RetConstants.JWT_NULL_ERROR, RetConstants.JWT_NULL_ERROR_MSG);
		    	if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-返回JWT为空, respStr:{}", respStr);
		    	context.setResponseBody(respStr);
		    	return null;
			}

			String header = null;
			String payload = null;
			String signature = null;
			try {
				String[] datas = StringUtils.split(jwt, ".");
				header = datas[0];
				payload = datas[1];
				signature = datas[2];
			} catch (Exception e) {
				logger.error("【jwtZuul请求过滤】(JwtZuulFilter-run)-jwt数组转换异常, Exception = {}, message = {}", e, e.getMessage());
			}

			if(StringUtils.isBlank(header)) {
		    	String respStr = this.addRetInfo(RetConstants.JWT_ERROR, RetConstants.JWT_HEADER_NULL_ERROR_MSG, RetConstants.JWT_HEADER_NULL_ERROR, RetConstants.JWT_HEADER_NULL_ERROR_MSG);
		    	if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-返回JWT的header为空, respStr:{}", respStr);
		    	context.setResponseBody(respStr);
		    	return null;
		    } else if(StringUtils.isBlank(payload)) {
		    	String respStr = this.addRetInfo(RetConstants.JWT_ERROR, RetConstants.JWT_PAYLOAD_NULL_ERROR_MSG, RetConstants.JWT_PAYLOAD_NULL_ERROR, RetConstants.JWT_PAYLOAD_NULL_ERROR_MSG);
		    	if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-返回JWT的payload为空, respStr:{}", respStr);
		    	context.setResponseBody(respStr);
		    	return null;
		    } else if(StringUtils.isBlank(signature)) {
		    	String respStr = this.addRetInfo(RetConstants.JWT_ERROR, RetConstants.JWT_SIGN_NULL_ERROR_MSG, RetConstants.JWT_SIGN_NULL_ERROR, RetConstants.JWT_SIGN_NULL_ERROR_MSG);
		    	if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-返回JWT的签名为空, respStr:{}", respStr);
		    	context.setResponseBody(respStr);
		    	return null;
		    }

			String payLoadStr = new String(Base64.decodeBase64(payload), StandardCharsets.UTF_8);
			if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-获取payLoad, payLoadStr:{}", payLoadStr);
			JSONObject payLoadJson = null;
			try {
				payLoadJson = JSONObject.parseObject(payLoadStr);
			} catch (Exception e) {
				logger.error("【jwtZuul请求过滤】(JwtZuulFilter-run)-payLoad参数非json格式, 解析异常, Exception = {}, message = {}", e, e.getMessage());
			}

			String vportId = "";
			String publicKey = "";
			String sequenceId = "";
			String userId = "";
			String loginId = "";
			if(payLoadJson != null) {
				vportId = Objects.toString(payLoadJson.get(RetConstants.BODY_VPORTID), "");
				publicKey = Objects.toString(payLoadJson.get(RetConstants.BODY_PUBLICKEY), "");
				sequenceId = Objects.toString(payLoadJson.get(RetConstants.BODY_SEQUENCEID), "");
				userId = Objects.toString(payLoadJson.get(RetConstants.BODY_USERID), "");
				loginId = Objects.toString(payLoadJson.get(RetConstants.BODY_LOGINID), "");
			}
			if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-获取payload用户vportId/publicKey/sequenceId, vportId:{}, publicKey:{}, sequenceId:{}", vportId, publicKey, sequenceId);
			if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-获取payload用户userId, userId:{}", userId);
			if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-获取payload用户loginId, loginId:{}", loginId);
			if(StringUtils.isBlank(vportId)) {
				String respStr = this.addRetInfo(RetConstants.JWT_ERROR, RetConstants.JWT_PAYLOAD_VPORTID_NULL_ERROR_MSG, RetConstants.JWT_PAYLOAD_VPORTID_NULL_ERROR, RetConstants.JWT_PAYLOAD_VPORTID_NULL_ERROR_MSG);
				if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-返回用户vportId为空, respStr:{}", respStr);
				context.setResponseBody(respStr);
				return null;
			}
			if(StringUtils.isBlank(publicKey)) {
				String respStr = this.addRetInfo(RetConstants.JWT_ERROR, RetConstants.JWT_PAYLOAD_PUBLICKEY_NULL_ERROR_MSG, RetConstants.JWT_PAYLOAD_PUBLICKEY_NULL_ERROR, RetConstants.JWT_PAYLOAD_PUBLICKEY_NULL_ERROR_MSG);
				if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-返回用户publicKey为空, respStr:{}", respStr);
				context.setResponseBody(respStr);
				return null;
			}
		    if(StringUtils.isBlank(sequenceId)) {
		    	String respStr = this.addRetInfo(RetConstants.SEQUENCEID_ERROR, RetConstants.SEQUENCEID_NULL_ERROR_MSG, RetConstants.SEQUENCEID_NULL_ERROR, RetConstants.SEQUENCEID_NULL_ERROR_MSG);
		    	if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-返回sequenceId为空, respStr:{}", respStr);
		    	context.setResponseBody(respStr);
		    	return null;
		    }

		    if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-验签结果, header:{}, payload:{}, signature:{}, publicKey:{}", header, payload, signature, publicKey);
		    Boolean verifySign = SignUtils.verifySignFromBase64(header+"."+payload, signature, publicKey);
			if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-验签结果, verifySign:{}", verifySign);
		    if(!verifySign) {
				String respStr = this.addRetInfo(RetConstants.JWT_ERROR, RetConstants.JWT_SIGN_ERROR_MSG, RetConstants.JWT_SIGN_ERROR, RetConstants.JWT_SIGN_ERROR_MSG);
				if(logger.isInfoEnabled())logger.info("【jwtZuul请求过滤】(JwtZuulFilter-run)-返回验签失败, respStr:{}", respStr);
		    	context.setResponseBody(respStr);
		    	return null;
		    }
		    //设置vportId/publicKey/publicKey到消费者(consumer)header里面
		    context.addZuulRequestHeader(ZuulConstants.VPORT_CONSUMER_HEADER_VPORTID, vportId);
		    context.addZuulRequestHeader(ZuulConstants.VPORT_CONSUMER_HEADER_PUBLICKEY, publicKey);
		    context.addZuulRequestHeader(ZuulConstants.VPORT_CONSUMER_HEADER_SEQUENCEID, sequenceId);
		    context.addZuulRequestHeader(ZuulConstants.VPORT_CONSUMER_HEADER_USERID, userId);
		    context.addZuulRequestHeader(ZuulConstants.VPORT_CONSUMER_HEADER_LOGINID, loginId);
		}

	    context.setRequest(wrapper);
		return null;
    }

	/**
	 *初始化
	 */
	public void init() {
		if(ignoreUriMap == null || ignoreUriMap.isEmpty()) {
			this.getIgnoreUriMap();
		}
		if(jwtIgnoreUriMap == null || jwtIgnoreUriMap.isEmpty()) {
			this.getJwtIgnoreUriMap();
		}
	}

    /**
     * 设置返回信息（主编码/主编码信息/子编码/子编码信息）
     * @param retCode
     * @param retInfo
     * @param subCode
     * @param subInfo
     * @return String
     */
    public String addRetInfo(String retCode, String retInfo, String subCode, String subInfo) {
		JSONObject json = new JSONObject();
    	json.put("retCode", retCode);
    	json.put("retInfo", retInfo);
    	json.put("subCode", subCode);
    	json.put("subInfo", subInfo);
    	return json.toJSONString();
    }

	/**
	 * 获得不需要拦截的url
	 */
	public void getIgnoreUriMap() {
		this.ignoreUriMap = new ConcurrentHashMap<String, Object>();
		String[] excludePaths = StringUtils.split(ignoreUri, ",");
		if(excludePaths != null && excludePaths.length >0) {
			for (String igUri : excludePaths) {
				if(StringUtils.isNotBlank(igUri)) {
					ignoreUriMap.put(igUri.trim(), igUri.trim());
				}
			}
		}
	}

	/**
	 * 获得不需要jwt过滤的uri,无需jwt校验
	 */
	public void getJwtIgnoreUriMap() {
		this.jwtIgnoreUriMap = new ConcurrentHashMap<String, Object>();
		String[] excludePaths = StringUtils.split(jwtIgnoreUri, ",");
		if(excludePaths != null && excludePaths.length >0) {
			for (String igUri : excludePaths) {
				if(StringUtils.isNotBlank(igUri)) {
					jwtIgnoreUriMap.put(igUri.trim(), igUri.trim());
				}
			}
		}
	}

}