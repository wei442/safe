package com.cloud.provider.safe.boot;

import java.io.Serializable;

/**
 * boot基础请求
 * @author wei.yong
 */
public class BootRestRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//当前页
	private int pageNum = 1;

	//每页的数量
	private int pageSize = 10;

	//登录ip
    private String loginIp;

	public int getPageNum() {
		return this.pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getLoginIp() {
		return this.loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	@Override
	public String toString() {
		return "BootRestRequest [pageNum=" + pageNum + ", pageSize=" + pageSize + ", loginIp=" + loginIp + "]";
	}

}