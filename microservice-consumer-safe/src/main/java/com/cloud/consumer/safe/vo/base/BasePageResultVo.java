package com.cloud.consumer.safe.vo.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.cloud.consumer.safe.page.PageVo;

import lombok.Data;

/**
 * 基础分页 Vo
 * @author wei.yong
 */
@Data
public class BasePageResultVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

//	private PageVo page = null;

//	private List<?> dataList = null;
	private PageVo page = new PageVo();
	private List<?> dataList = new ArrayList<>();

	public BasePageResultVo() {
	}

	public BasePageResultVo(PageVo page, List<?> dataList) {
		this.page = page;
		this.dataList = dataList;
	}

}