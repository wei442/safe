package com.cloud.provider.safe.base;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;

/**
 * base基础请求
 * @author wei.yong
 */
public class BaseRestRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//当前页
	@ApiModelProperty(value = "当前页默认值：1")
	private int pageNum = 1;

	//每页的数量
	@ApiModelProperty(value = "每页显示条数默认值：10")
	private int pageSize = 10;

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

	@Override
	public String toString() {
		return "BaseRestRequest [pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}

}