package com.cloud.queue.safe.vo.gofun;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 员工邀请好友信息
 * @author wei.yong
 */
public class InviteFriendVo implements Serializable {

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

	//被邀请人完成非0公里首单的人数
	@JSONField(name="finishTimes")
	private Integer finishTimes;

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

	public Integer getFinishTimes() {
		return this.finishTimes;
	}

	public void setFinishTimes(Integer finishTimes) {
		this.finishTimes = finishTimes;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "InviteFriendVo [gId=" + gId + ", userAccount=" + userAccount + ", finishTimes=" + finishTimes
				+ ", date=" + date + "]";
	}

}