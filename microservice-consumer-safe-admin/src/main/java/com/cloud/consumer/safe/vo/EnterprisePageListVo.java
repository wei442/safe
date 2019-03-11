package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.List;

import com.cloud.consumer.safe.base.BaseResult;
import com.cloud.consumer.safe.page.PageVo;

import lombok.Data;

@Data
public class EnterprisePageListVo<T> extends BaseResult implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private PageVo page;

	private List<T> dataList;

}