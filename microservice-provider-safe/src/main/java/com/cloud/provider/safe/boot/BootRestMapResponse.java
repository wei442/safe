package com.cloud.provider.safe.boot;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.RetConstants;
import com.cloud.common.enums.ResultEnum;

/**
 * boot map返回
 * @author wei.yong
 */
public class BootRestMapResponse extends JSONObject implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public BootRestMapResponse() {
		this.put(RetConstants.RET_CODE, RetConstants.OK);
		this.put(RetConstants.RET_MSG, RetConstants.OK_MSG);
	}

	public BootRestMapResponse(String code,String msg) {
		this.put(RetConstants.RET_CODE, code);
		this.put(RetConstants.RET_MSG, msg);
	}

	public BootRestMapResponse(ResultEnum enums) {
		this.put(RetConstants.RET_CODE, enums.getCode());
		this.put(RetConstants.RET_MSG, enums.getMsg());
	}

}