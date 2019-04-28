package com.cloud.queue.safe.vo.gofun;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 员工文明用车分数
 * @author wei.yong
 */
public class ScoreVo implements Serializable {

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

	//用户文明用车分数
	@JSONField(name="score")
	private Integer score;

    //时间
    @JSONField(name="date")
    private String date;

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

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ScoreVo [gId=" + gId + ", userAccount=" + userAccount + ", score=" + score + ", date=" + date + "]";
	}

}