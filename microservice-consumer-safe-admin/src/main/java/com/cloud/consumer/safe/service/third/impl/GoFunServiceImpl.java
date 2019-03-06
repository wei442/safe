package com.cloud.consumer.safe.service.third.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.consumer.safe.service.third.IGoFunService;

/**
 * gofun Service
 * @author wei.yong
 */
@Service
public class GoFunServiceImpl extends BaseGofunService implements IGoFunService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 验证App用户登陆状态接口-(获取用户基本信息)
	 * @param token
	 * @param portal
	 * @return JSONObject
	 */
	@Override
	public JSONObject validateUser(String token,String portal) {
		logger.info("(GoFunService-validateUser)-验证App用户登陆状态-传入参数, token:{}, portal:{}", token, portal);
		HttpHeaders headers = this.getGofunHeaders();
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		String url = this.gofunUrl+"/ele/validateUser?AUTHORIZATION="+token+"&portal="+portal;
		logger.info("(GoFunService-HttpHeaders)-验证App用户登陆状态-url, url:{}", url);
		ResponseEntity<JSONObject> responseEntity = this.simpleRestTemplate.exchange(url, HttpMethod.GET, httpEntity, JSONObject.class);
		JSONObject response = responseEntity.getBody();
        return response;
    }

	/**
	 * 查询用户当天是否成功用车
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserCar(Map<String, Object> params) {
		logger.info("(GoFunService-getUserCar)-查询用户当天是否成功用车-传入参数, params:{}", params);
		HttpHeaders headers = this.getGofunHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.simpleRestTemplate.postForObject(this.gofunUrl+"/business/getUserCar", httpEntity, JSONObject.class);
        return response;
    }


	/**
	 * 新用户查询所有算力任务完成情况
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserTask(Map<String, Object> params) {
		logger.info("(GoFunService-getUserTask)-新用户查询所有算力任务完成情况-传入参数, params:{}", params);
		HttpHeaders headers = this.getGofunHeaders();
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.simpleRestTemplate.postForObject(this.gofunUrl+"/business/getUserTask", httpEntity, JSONObject.class);
        return response;
    }

	/**
	 * APP用户登陆接口
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject appLogin(Map<String, Object> params) {
		logger.info("(GoFunService-appLogin)-APP用户登陆接口-传入参数, params:{}", params);
		HttpHeaders headers = this.getGofunHeaders();
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.simpleRestTemplate.postForObject(this.gofunUrl+"/ele/appLogin", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 发放优惠券接口
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject bindCouponToUser(Map<String, Object> params) {
		logger.info("(GoFunService-bindCouponToUser)-发放优惠券接口-传入参数, params:{}", params);
		HttpHeaders headers = this.getGofunHeaders();
		headers.setContentType(MediaType.parseMediaType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.simpleRestTemplate.postForObject(this.gofunUrl+"/business/bindCouponToUser", httpEntity, JSONObject.class);
		return response;
	}

}