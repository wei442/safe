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

	@ApiModelProperty(value = "当前页默认值：1")
	//当前页
	private int pageNum = 1;

	@ApiModelProperty(value = "每页显示条数默认值：10")
	//每页的数量
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