package com.cloud.queue.safe.vo.gofun;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 员工用车订单信息
 * @author wei.yong
 */
public class CarOrderVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//用户ID
	@JSONField(name="userId")
	private String gId;

	//手机号码
	@JSONField(name="sim")
    private String userAccount;

	//今日完成非0公里订单数量
	@JSONField(name="order")
	private Integer order;

    //时间
    @JSONField(name="date")
    private String date;

	//商圈信息
	private List<AreaVo> area;

	public String getgId() {
		return this.gId;
	}

	public void setgId(String gId) {
		this.gId = gId;
	}

	public String getUserAccount() {
		return this.userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public List<AreaVo> getArea() {
		return this.area;
	}

	public void setArea(List<AreaVo> area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "CarOrderVo [gId=" + gId + ", userAccount=" + userAccount + ", order=" + order + ", date=" + date
				+ ", area=" + area + "]";
	}

}