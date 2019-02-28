package com.ochain.consumer.wheel.vo.gofun;

import java.io.Serializable;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 新用户查询所有算力任务完成情况 Vo
 * @author wei.yong
 */
public class UserTaskVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//押金  1已交或免交 0未交
	@JSONField(name="verifyDeposit")
	private String verifyDeposit;

	//用户信用分
	@JSONField(name="score")
	private Integer score;

	//驾驶证 1审核通过  0审核不通过
	@JSONField(name="verifyLicense")
	private String verifyLicense;

	//用户免密开关   1免密  0非免密
	@JSONField(name="freeSwitch")
	private String freeSwitch;

	//身份证 1 审核通过  0审核不通过
	@JSONField(name="verifyCard")
	private String verifyCard;

	//用户邀请完成非0公里用户数
	@JSONField(name="inviteUser")
	private Integer inviteUser;

	//用户订单数
	@JSONField(name="order")
	private Integer order;

	//商圈
	private List<AreaVo> area;

	public String getVerifyDeposit() {
		return this.verifyDeposit;
	}

	public void setVerifyDeposit(String verifyDeposit) {
		this.verifyDeposit = verifyDeposit;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getVerifyLicense() {
		return this.verifyLicense;
	}

	public void setVerifyLicense(String verifyLicense) {
		this.verifyLicense = verifyLicense;
	}

	public String getFreeSwitch() {
		return this.freeSwitch;
	}

	public void setFreeSwitch(String freeSwitch) {
		this.freeSwitch = freeSwitch;
	}

	public String getVerifyCard() {
		return this.verifyCard;
	}

	public void setVerifyCard(String verifyCard) {
		this.verifyCard = verifyCard;
	}

	public Integer getInviteUser() {
		return this.inviteUser;
	}

	public void setInviteUser(Integer inviteUser) {
		this.inviteUser = inviteUser;
	}

	public Integer getOrder() {
		return this.order;
	}

	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<AreaVo> getArea() {
		return this.area;
	}

	public void setArea(List<AreaVo> area) {
		this.area = area;
	}

	@Override
	public String toString() {
		return "UserTaskVo [verifyDeposit=" + verifyDeposit + ", score=" + score + ", verifyLicense=" + verifyLicense
				+ ", freeSwitch=" + freeSwitch + ", verifyCard=" + verifyCard + ", inviteUser=" + inviteUser
				+ ", order=" + order + ", area=" + area + "]";
	}

}