package com.ochain.provider.wheel.boot;

import java.io.Serializable;

import com.ochain.common.constants.BootConstants;

/**
 * boot返回
 * @author wei.yong
 */
public class BootRestResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 响应码
     */
	protected String bootCode;

    /**
     * 响应信息
     */
	protected String bootMsg;

	public BootRestResponse() {
		this.bootCode = BootConstants.OK;
		this.bootMsg = BootConstants.OK_MSG;
	}

	public BootRestResponse(String code,String msg) {
		this.bootCode = code;
		this.bootMsg = msg;
	}

	public String getBootCode() {
		return this.bootCode;
	}

	public void setBootCode(String bootCode) {
		this.bootCode = bootCode;
	}

	public String getBootMsg() {
		return this.bootMsg;
	}

	public void setBootMsg(String bootMsg) {
		this.bootMsg = bootMsg;
	}

	@Override
	public String toString() {
		return "BootRestResponse [bootCode=" + bootCode + ", bootMsg=" + bootMsg + "]";
	}

}