package com.cloud.consumer.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.safe.SafeUrlConstants;
import com.cloud.consumer.safe.service.IPostAttachmentService;

/**
 * 岗位附件 PostService (microservice-provider-safe)
 * @author wei.yong
 */
@Service
public class PostAttachmentServiceImpl extends BaseService implements IPostAttachmentService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 分页获取岗位附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getListByPage(Object params) {
		logger.info("(PostService-getListByPage)-分页获取岗位附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.post_attachment+"/selectListByPage", params, JSONObject.class);
		return response;
	}

	/**
	 * 获取岗位附件列表
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject getList(Object params) {
		logger.info("(PostService-getList)-获取岗位附件列表-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.post_attachment+"/selectList", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id获取岗位附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject getById(Integer id) {
		logger.info("(PostService-getById)-根据id获取岗位附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.post_attachment+"/selectById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 新增岗位附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject add(Object params) {
		logger.info("(PostService-add)-新增岗位附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.post_attachment+"/insert", params, JSONObject.class);
		return response;
	}

	/**
	 * 根据id删除岗位附件
	 * @param id
	 * @return JSONObject
	 */
	@Override
	public JSONObject deleteById(Integer id) {
		logger.info("(PostService-deleteById)-根据id获取岗位附件-传入参数, id:{}", id);
		JSONObject response = this.safePostForObject(SafeUrlConstants.post_attachment+"/deleteById/"+id, null, JSONObject.class);
		return response;
	}

	/**
	 * 修改岗位附件
	 * @param params
	 * @return JSONObject
	 */
	@Override
	public JSONObject update(Object params) {
		logger.info("(PostService-update)-修改岗位附件-传入参数, params:{}", params);
		JSONObject response = this.safePostForObject(SafeUrlConstants.post_attachment+"/modify", params, JSONObject.class);
		return response;
	}

}