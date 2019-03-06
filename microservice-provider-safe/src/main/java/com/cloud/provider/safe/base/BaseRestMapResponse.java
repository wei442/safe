package com.cloud.provider.safe.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.RetConstants;
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
		this.put(RetConstants.RET_CODE, RetConstants.OK);
		this.put(RetConstants.RET_MSG, RetConstants.OK_MSG);
	}

	public BaseRestMapResponse(String code,String msg) {
		this.put(RetConstants.RET_CODE, code);
		this.put(RetConstants.RET_MSG, msg);
	}

	public BaseRestMapResponse(ResultEnum enums) {
		this.put(RetConstants.RET_CODE, enums.getCode());
		this.put(RetConstants.RET_MSG, enums.getMsg());
	}

}