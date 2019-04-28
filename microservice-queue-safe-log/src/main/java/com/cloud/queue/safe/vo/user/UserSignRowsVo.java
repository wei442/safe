package com.cloud.queue.safe.vo.user;

import java.io.Serializable;

public class UserSignRowsVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long rows;

	public Long getRows() {
		return this.rows;
	}

	public void setRows(Long rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "UserSignRowsVo [rows=" + rows + "]";
	}

}