package com.ochain.provider.wheel.vo.calculate;

import java.io.Serializable;

/**
 * 任务算力Vo
 * @author wei.yong
 */
public class CalculateTaskVo implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//周期 1-不限, 2-1次, 3-临时
	private Integer period;

	//奖励次数 0-不限
    private Integer times;

    //算力值
    private Integer calculate;

	public Integer getPeriod() {
		return this.period;
	}

	public void setPeriod(Integer period) {
		this.period = period;
	}

	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getCalculate() {
		return this.calculate;
	}

	public void setCalculate(Integer calculate) {
		this.calculate = calculate;
	}

	@Override
	public String toString() {
		return "CalculateTaskVo [period=" + period + ", times=" + times + ", calculate=" + calculate + "]";
	}

}