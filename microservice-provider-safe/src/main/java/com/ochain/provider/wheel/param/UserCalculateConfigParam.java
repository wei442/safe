package com.ochain.provider.wheel.param;

import java.io.Serializable;

/**
 * 用户配置请求 UserCalculateConfigParam
 * @author wei.yong
 */
public class UserCalculateConfigParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer calculateType;

    //排序
  	private String orderByClause;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getCalculateType() {
		return this.calculateType;
	}

	public void setCalculateType(Integer calculateType) {
		this.calculateType = calculateType;
	}

	public String getOrderByClause() {
		return this.orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	@Override
	public String toString() {
		return "UserCalculateConfigParam [userId=" + userId + ", calculateType=" + calculateType + ", orderByClause="
				+ orderByClause + "]";
	}

}