package com.cloud.provider.safe.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

/**
 * base map返回
 * @author wei.yong
 */
public class BaseRestMapResponse extends JSONObject implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BaseRestMapResponse() {
		this.put(CommConstants.RET_CODE, CommConstants.OK);
		this.put(CommConstants.RET_MSG, CommConstants.OK_MSG);
	}

	public BaseRestMapResponse(String code,String msg) {
		this.put(CommConstants.RET_CODE, code);
		this.put(CommConstants.RET_MSG, msg);
	}

	public BaseRestMapResponse(ResultEnum enums) {
		this.put(CommConstants.RET_CODE, enums.getCode());
		this.put(CommConstants.RET_MSG, enums.getMsg());
	}

}