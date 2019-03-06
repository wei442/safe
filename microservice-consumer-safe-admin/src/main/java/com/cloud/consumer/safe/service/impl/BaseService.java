package com.cloud.consumer.safe.service.impl;

import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 基础超类 Service，其他Service需要继承
 * @author wei.yong
 */
@Service
public class BaseService extends BaseUrlService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//Basic加密中间有空格
	private static final String BASIC = "Basic";

	private static final String AUTHORIZATION = "Authorization";

	//rest模板
	@Autowired
	protected RestTemplate restTemplate;

	//方向盘提供者-访问用户名
	@Value("${provider.wheel.spring.security.user.name}")
	private String providerWheelUserName;
	//方向盘提供者-访问用户密码
	@Value("${provider.wheel.spring.security.user.password}")
	private String providerWheelUserPassword;

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
	protected HttpHeaders getProviderWheelHeaders() {
		//格式: 用户名+英文冒号+密码
    	String plainCredentials = providerWheelUserName+":"+providerWheelUserPassword;
    	String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes(StandardCharsets.UTF_8)),StandardCharsets.UTF_8);

    	HttpHeaders headers = new HttpHeaders();
    	//格式: Authorization, Basic+空格+base64加密
    	headers.add(AUTHORIZATION, BASIC+" "+base64Credentials);
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		return headers;
    }

	/**
	 * redis提供者用户名密码，并进行HTTP Basic Base64 加密，放入入HttpHeaders里面
	 * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
	 * @return HttpHeaders
	 */
	protected HttpHeaders getProviderRedisHeaders() {
		//格式: 用户名+英文冒号+密码
		String plainCredentials = providerRedisUserName+":"+providerRedisUserPassword;
		String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes(StandardCharsets.UTF_8)),StandardCharsets.UTF_8);

		HttpHeaders headers = new HttpHeaders();
		//格式: Authorization, Basic+空格+base64加密
		headers.add(AUTHORIZATION, BASIC+" "+base64Credentials);
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		return headers;
	}

}