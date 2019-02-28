package com.ochain.consumer.wheel.rest.request.diamond;

import java.io.Serializable;

import com.ochain.consumer.wheel.base.BaseRestRequest;

/**
 * 能量请求
 * @author wei.yong
 */
public class DiamondRequest extends BaseRestRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//能量方块记录id
	private Long diamondRecordId;

	public Long getDiamondRecordId() {
		return diamondRecordId;
	}

	public void setDiamondRecordId(Long diamondRecordId) {
		this.diamondRecordId = diamondRecordId;
	}

	@Override
	public String toString() {
		return "DiamondRequest [diamondRecordId=" + diamondRecordId + "]";
	}

}