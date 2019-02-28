package com.ochain.provider.wheel.po;

import java.io.Serializable;
import java.util.Date;

public class UserSign implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userSignId;

    private Integer userId;

    private Date signTime;

    private Integer signDays;

    private Date createTime;

    private Date updateTime;

    public Long getUserSignId() {
        return userSignId;
    }

    public void setUserSignId(Long userSignId) {
        this.userSignId = userSignId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getSignTime() {
        return signTime;
    }

    public void setSignTime(Date signTime) {
        this.signTime = signTime;
    }

    public Integer getSignDays() {
        return signDays;
    }

    public void setSignDays(Integer signDays) {
        this.signDays = signDays;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "UserSign [userSignId=" + userSignId + ", userId=" + userId + ", signTime=" + signTime + ", signDays="
				+ signDays + ", createTime=" + createTime + ", updateTime=" + updateTime + "]";
	}


}