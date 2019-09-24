package com.cloud.provider.safe.vo.base;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class BaseResultVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private List<?> dataList;

	public BaseResultVo() {
	}

	public BaseResultVo(List<?> dataList) {
		this.dataList = dataList;
	}

}