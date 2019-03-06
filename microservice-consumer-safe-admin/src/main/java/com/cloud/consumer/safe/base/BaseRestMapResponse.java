package com.cloud.consumer.safe.base;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.RetConstants;

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
		this.put(RetConstants.RET_CODE, RetConstants.OK);
		this.put(RetConstants.RET_MSG, RetConstants.OK_MSG);
	}

	/**
	 * 二位错误码返回
	 * @param code
	 * @param info
	 */
	public BaseRestMapResponse(String code,String info) {
		this.put(RetConstants.RET_CODE, code);
		this.put(RetConstants.RET_MSG, info);
		logger.info("(BaseRestMapResponse-retCode)-主错误编码信息返回, toJSONString:{}", JSONObject.toJSONString(this));
	}

	/**
	 * 四位错误码返回
	 * @param code
	 * @param info
	 * @param subCode
	 * @param subMsg
	 */
	public BaseRestMapResponse(String code,String info,String subCode,String subMsg) {
		this.put(RetConstants.RET_CODE, code);
		this.put(RetConstants.RET_MSG, info);
		this.put(RetConstants.SUB_CODE, subCode);
		this.put(RetConstants.SUB_MSG, subMsg);
		logger.info("(BaseRestMapResponse-subCode)-子错误编码信息返回, toJSONString:{}", JSONObject.toJSONString(this));
	}

}