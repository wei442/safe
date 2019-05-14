package com.cloud.queue.safe.service.impl;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.exception.SafeException;
import com.cloud.queue.safe.service.IRedisService;

/**
 * 基础超类 Service，其他Service需要继承
 * @author wei.yong
 */
@Service
public class BaseService extends BaseUrlService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//rest模板
	@Autowired
	protected RestTemplate restTemplate;

	//redis Service
	@Autowired
	protected IRedisService redisService;

	//安全提供者-访问用户名
	@Value("${provider.safe.log.spring.security.user.name}")
	private String providerSafeLogUserName;
	//安全提供者-访问用户密码
	@Value("${provider.safe.log.spring.security.user.password}")
	private String providerSafeLogUserPassword;

	//redis-访问用户名
	@Value("${provider.redis.spring.security.user.name}")
	private String providerRedisUserName;
	//redis-访问用户密码
	@Value("${provider.redis.spring.security.user.password}")
	private String providerRedisUserPassword;

	/**
	 * 获取方向盘提供者用户名密码，并进行HTTP Basic Base64 加密，放入入HttpHeaders里面
     * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
	 * @return HttpHeaders
	 */
	protected HttpHeaders getProviderSafeHeaders() {
    	HttpHeaders headers = new HttpHeaders();
    	//Basic Authentication
    	headers.setBasicAuth(providerSafeLogUserName, providerSafeLogUserPassword, StandardCharsets.UTF_8);
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		return headers;
    }

	/**
	 * redis提供者用户名密码，并进行HTTP Basic Base64 加密，放入入HttpHeaders里面
	 * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
	 * @return HttpHeaders
	 */
	protected HttpHeaders getProviderRedisHeaders() {
		HttpHeaders headers = new HttpHeaders();
		//Basic Authentication
		headers.setBasicAuth(providerRedisUserName, providerRedisUserPassword, StandardCharsets.UTF_8);
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		return headers;
	}

	/**
	 * 参数校验
	 *
	 * @Title verifyResponseParameters
	 * @param postForObject
	 *            void
	 * @author yueli
	 * @date Mar 4, 2019 4:35:13 PM
	 */
	protected <T> void verifyResponse(T t) {
		if (null == t) {
			logger.error("remote http response null --> {}", t);
			throw new SafeException("0000001", "请求响应结果为空");
		}
		if (t instanceof JSONObject) {
			JSONObject response = (JSONObject) t;
			String retCode = Objects.toString(response.get(CommConstants.RET_CODE));
			String retMsg = Objects.toString(response.get(CommConstants.RET_MSG));
			if(!StringUtils.equals(CommConstants.OK, retCode)) {
				throw new SafeException(retCode, retMsg);
			}
		}
	}

	/**
	 * safe封装post方法
	 * @param url
	 * @param request
	 * @param responseType
	 * @param uriVariables
	 * @return T
	 */
	protected <T> T safeLogPostForObject(String url, Object request, Class<T> responseType, Object... uriVariables) {
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Object> httpEntity = new HttpEntity<>(request, headers);
		T t = this.restTemplate.postForObject(url, httpEntity, responseType, uriVariables);
		this.verifyResponse(t);
		return t;
	}


}