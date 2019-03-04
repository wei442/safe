package com.cloud.provider.safe.param;

import java.io.Serializable;

/**
 * 用户订单请求 CarOrderParam
 * @author wei.yong
 */
public class CarOrderParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    //用户id
  	private Integer userId;

//    //订单时间字符串
//  	private String orderTimeStr;

  	//订单开始时间
  	private String orderTimeStartStr;

  	//订单结束时间
  	private String orderTimeEndStr;

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOrderTimeStartStr() {
		return this.orderTimeStartStr;
	}

	public void setOrderTimeStartStr(String orderTimeStartStr) {
		this.orderTimeStartStr = orderTimeStartStr;
	}

	public String getOrderTimeEndStr() {
		return this.orderTimeEndStr;
	}

	public void setOrderTimeEndStr(String orderTimeEndStr) {
		this.orderTimeEndStr = orderTimeEndStr;
	}

	@Override
	public String toString() {
		return "CarOrderParam [userId=" + userId + ", orderTimeStartStr=" + orderTimeStartStr + ", orderTimeEndStr="
				+ orderTimeEndStr + "]";
	}

}