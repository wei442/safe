package com.ochain.provider.wheel.vo.calculate;

import java.io.Serializable;

/**
 * 文明分算力Vo
 * @author wei.yong
 */
public class CalculateCivilizeVo implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//系数
	private Double ratio;

	public Double getRatio() {
		return this.ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	@Override
	public String toString() {
		return "CalculateCivilizeVo [ratio=" + ratio + "]";
	}

}