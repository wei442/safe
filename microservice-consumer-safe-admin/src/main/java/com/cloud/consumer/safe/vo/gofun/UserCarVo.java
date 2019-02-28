package com.ochain.consumer.wheel.vo.gofun;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 查询用户当天是否成功用车 Vo
 * @author wei.yong
 */
public class UserCarVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//订单数
	@JSONField(name="count")
	private Integer count;

	//是否成功用车 1成功用车  0未成用车
	@JSONField(name="useCarType")
	private String useCarType;

	//查询时间：yyyy-mm-dd
	@JSONField(name="date")
	private Date date;

	public Integer getCount() {
		return this.count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getUseCarType() {
		return this.useCarType;
	}

	public void setUseCarType(String useCarType) {
		this.useCarType = useCarType;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "UserCarVo [count=" + count + ", useCarType=" + useCarType + ", date=" + date + "]";
	}

}