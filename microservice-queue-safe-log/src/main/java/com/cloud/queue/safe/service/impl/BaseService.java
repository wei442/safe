package com.cloud.queue.safe.service.impl;

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

import com.cloud.common.redis.keys.RedisKeysUtil;
import com.cloud.queue.safe.service.IRedisService;

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

	//redis Service
	@Autowired
	protected IRedisService redisService;

	//方向盘提供者-访问用户名
	@Value("${provider.wheel.spring.security.user.name}")
	private String providerWheelUserName;
	//方向盘提供者-访问用户密码
	@Value("${provider.wheel.spring.security.user.password}")
	private String providerWheelUserPassword;

	//方向盘数据接收提供者-访问用户名
	@Value("${provider.wheel.data.receive.spring.security.user.name}")
	private String providerWheelDataReceiveUserName;
	//方向盘数据接收提供者-访问用户密码
	@Value("${provider.wheel.data.receive.spring.security.user.password}")
	private String providerWheelDataReceiveUserPassword;

	//登录用户算力实时排名key（存储用户id和用户账户）
	protected String loginCalculateRankRealKey = RedisKeysUtil.CN_OCHAIN_WHEEL_LOGIN_RANK_CALCULATE_REAL_TIME;
	//登录用户能量实时排名key（存储用户id和用户账户）
	protected String loginDiamondRankRealKey = RedisKeysUtil.CN_OCHAIN_WHEEL_LOGIN_RANK_DIAMOND_REAL_TIME;

	//登录用户算力实时排名key（存储用户账户）
	protected String calculateRankRealKey = RedisKeysUtil.CN_OCHAIN_WHEEL_RANK_CALCULATE_REAL_TIME;
	//登录用户能量实时排名key（存储用户账户）
	protected String diamondRankRealKey = RedisKeysUtil.CN_OCHAIN_WHEEL_RANK_DIAMOND_REAL_TIME;

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
	 * 方向盘数据接收提供者用户名密码，并进行HTTP Basic Base64 加密，放入入HttpHeaders里面
	 * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
	 * @return HttpHeaders
	 */
	protected HttpHeaders getProviderDataReceiveHeaders() {
		//格式: 用户名+英文冒号+密码
		String plainCredentials = providerWheelDataReceiveUserName+":"+providerWheelDataReceiveUserPassword;
		String base64Credentials = new String(Base64.encodeBase64(plainCredentials.getBytes(StandardCharsets.UTF_8)),StandardCharsets.UTF_8);

		HttpHeaders headers = new HttpHeaders();
		//格式: Authorization, Basic+空格+base64加密
		headers.add(AUTHORIZATION, BASIC+" "+base64Credentials);
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		return headers;
	}


}