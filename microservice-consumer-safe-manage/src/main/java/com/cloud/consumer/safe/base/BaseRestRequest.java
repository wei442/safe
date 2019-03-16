package com.cloud.consumer.safe.base;

import java.io.Serializable;

/**
 * 基础分页请求
 * @author wei.yong
 */
public class BaseRestRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	//当前页
    private int pageNum = 1;

    //每页的数量
    private int pageSize = 10;

    //企业id
    private Integer enterpriseId;

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

	public Integer getEnterpriseId() {
		return this.enterpriseId;
	}

	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	@Override
	public String toString() {
		return "BaseRestRequest [pageNum=" + pageNum + ", pageSize=" + pageSize + ", enterpriseId=" + enterpriseId
				+ "]";
	}

}