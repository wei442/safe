package com.ochain.provider.wheel.vo.calculate;

import java.io.Serializable;

public class CalculateConfigMaxCodeVo implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private String maxCode;

	public String getMaxCode() {
		return maxCode;
	}

	public void setMaxCode(String maxCode) {
		this.maxCode = maxCode;
	}

	@Override
	public String toString() {
		return "CalculateConfigMaxCodeVo [maxCode=" + maxCode + "]";
	}

}