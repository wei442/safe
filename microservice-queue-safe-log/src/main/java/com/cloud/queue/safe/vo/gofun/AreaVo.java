package com.cloud.queue.safe.vo.gofun;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

public class AreaVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//权重
	@JSONField(name="weight")
	private String weight;

	//业务区域名字
	@JSONField(name="businessAreaName")
	private String businessAreaName;

	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBusinessAreaName() {
		return this.businessAreaName;
	}

	public void setBusinessAreaName(String businessAreaName) {
		this.businessAreaName = businessAreaName;
	}

	@Override
	public String toString() {
		return "AreaVo [weight=" + weight + ", businessAreaName=" + businessAreaName + "]";
	}

}