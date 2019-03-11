package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class TitleRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer titleId;

    private Integer enterpriseId;

    private String titleName;

    private String remark;

    private Integer sort;

}