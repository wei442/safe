package com.ochain.provider.wheel.boot;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.BootConstants;

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
		this.put(BootConstants.BOOT_CODE, BootConstants.OK);
		this.put(BootConstants.BOOT_MSG, BootConstants.OK_MSG);
	}

	public BootRestMapResponse(String code,String msg) {
		this.put(BootConstants.BOOT_CODE, code);
		this.put(BootConstants.BOOT_MSG, msg);
	}

}