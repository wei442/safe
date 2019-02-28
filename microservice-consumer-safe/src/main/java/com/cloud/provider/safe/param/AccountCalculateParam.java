package com.ochain.provider.wheel.param;

import java.io.Serializable;

import com.ochain.pagehepler.mybatis.Page;

/**
 * 账户算力请求 Param
 * @author wei.yong
 */
public class AccountCalculateParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

  	//排序
  	private String orderByClause;

  	//分页
  	private Page<?> page;

	public String getOrderByClause() {
		return this.orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public Page<?> getPage() {
		return this.page;
	}

	public void setPage(Page<?> page) {
		this.page = page;
	}

	@Override
	public String toString() {
		return "AccountCalculateParam [orderByClause=" + orderByClause + ", page=" + page + "]";
	}

}