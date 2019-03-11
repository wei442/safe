package com.cloud.consumer.safe.base;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

/**
 * 基础 map返回
 * @author wei.yong
 */
public class BaseRestMapResponse extends JSONObject implements Serializable {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BaseRestMapResponse() {
		this.put(CommConstants.RET_CODE, CommConstants.OK);
		this.put(CommConstants.RET_MSG, CommConstants.OK_MSG);
//		logger.info("(BaseRestMapResponse-retCode)-错误编码信息返回, toJSONString:{}", JSONObject.toJSONString(this));
	}

	public BaseRestMapResponse(String code,String msg) {
		this.put(CommConstants.RET_CODE, code);
		this.put(CommConstants.RET_MSG, msg);
//		logger.info("(BaseRestMapResponse-retCode)-错误编码信息返回, toJSONString:{}", JSONObject.toJSONString(this));
	}

	public BaseRestMapResponse(ResultEnum enums) {
		this.put(CommConstants.RET_CODE, enums.getCode());
		this.put(CommConstants.RET_MSG, enums.getMsg());
//		logger.info("(BaseRestMapResponse-retCode)-错误编码信息返回, toJSONString:{}", JSONObject.toJSONString(this));
	}

}