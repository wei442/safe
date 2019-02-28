package com.ochain.consumer.wheel.service.third;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;

public interface IGoFunService {

	/**
	 * 验证App用户登陆状态接口-(获取用户基本信息)
	 * @param token
	 * @param portal
	 * @return JSONObject
	 */
	public JSONObject validateUser(String token,String portal);

	/**
	 * 查询用户当天是否成功用车
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserCar(Map<String, Object> params);


	/**
	 * 新用户查询所有算力任务完成情况
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject getUserTask(Map<String, Object> params);

	/**
	 * APP用户登陆接口
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject appLogin(Map<String, Object> params);

	/**
	 * 发放优惠券接口
	 * @param params
	 * @return JSONObject
	 */
	public JSONObject bindCouponToUser(Map<String, Object> params);

}