package com.ochain.provider.wheel.vo.account;

import java.io.Serializable;

public class AccountCalculateVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private Long totalCalculate;

    private Long totalCivilizeCalculate;

    private Long totalTaskCalculate;

	public Long getTotalCalculate() {
		return this.totalCalculate;
	}

	public void setTotalCalculate(Long totalCalculate) {
		this.totalCalculate = totalCalculate;
	}

	public Long getTotalCivilizeCalculate() {
		return this.totalCivilizeCalculate;
	}

	public void setTotalCivilizeCalculate(Long totalCivilizeCalculate) {
		this.totalCivilizeCalculate = totalCivilizeCalculate;
	}

	public Long getTotalTaskCalculate() {
		return this.totalTaskCalculate;
	}

	public void setTotalTaskCalculate(Long totalTaskCalculate) {
		this.totalTaskCalculate = totalTaskCalculate;
	}

	@Override
	public String toString() {
		return "AccountCalculateVo [totalCalculate=" + totalCalculate + ", totalCivilizeCalculate="
				+ totalCivilizeCalculate + ", totalTaskCalculate=" + totalTaskCalculate + "]";
	}


}