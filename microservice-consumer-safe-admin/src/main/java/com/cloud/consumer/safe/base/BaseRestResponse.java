package com.cloud.consumer.safe.base;

import java.io.Serializable;

import com.ochain.common.constants.RetConstants;

/**
 * 基础返回
 * @author wei.yong
 */
public class BaseRestResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 响应码
     */
	protected String retCode;

    /**
     * 响应信息
     */
	protected String retMsg;

	public BaseRestResponse() {
		this.retCode = RetConstants.OK;
		this.retMsg = RetConstants.OK_MSG;
	}

	public BaseRestResponse(String code,String info) {
		this.retCode = code;
		this.retMsg = info;
	}

	public String getRetCode() {
		return this.retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return this.retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	@Override
	public String toString() {
		return "BaseRestResponse [retCode=" + retCode + ", retMsg=" + retMsg + "]";
	}

}