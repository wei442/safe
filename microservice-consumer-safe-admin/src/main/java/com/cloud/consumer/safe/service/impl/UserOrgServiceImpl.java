package com.cloud.consumer.safe.service.impl;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IUserOrgService;

/**
 * 用户机构 UserOrgService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class UserOrgServiceImpl extends BaseService implements IUserOrgService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取用户机构列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserOrgListByPage(Map<String, Object> params) {
		logger.info("(UserOrgService-getUserOrgListByPage)-分页获取用户机构列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/selectUserOrgListByPage", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 获取用户机构列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserOrgList(Map<String, Object> params) {
		logger.info("(UserOrgService-getUserOrgList)-获取用户机构列表-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/selectUserOrgList", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取用户机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getUserOrgById(Integer id) {
		logger.info("(UserOrgService-getUserOrgById)-根据id获取用户机构-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/selectUserOrgById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 新增用户机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject addUserOrg(Map<String, Object> params) {
		logger.info("(UserOrgService-addUserOrg)-新增用户机构-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/insertUserOrg", httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除用户机构
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteUserOrgById(Integer id) {
		logger.info("(UserOrgService-deleteUserOrgById)-根据id获取用户机构-传入参数, id:{}", id);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(null, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/deleteUserOrgById/"+id, httpEntity, JSONObject.class);
		return response;
	}

	/**
	 * 修改用户机构
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject updateUserOrg(Map<String, Object> params) {
		logger.info("(UserOrgService-updateUserOrg)-修改用户机构-传入参数, params:{}", params);
		HttpHeaders headers = this.getProviderSafeHeaders();
		HttpEntity<Map<String, Object>> httpEntity = new HttpEntity<Map<String, Object>>(params, headers);
		JSONObject response = this.restTemplate.postForObject(SafeUrlConstants.user_title+"/modifyUserOrg", httpEntity, JSONObject.class);
		return response;
	}

}