package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class DictRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dictId;

    private Integer enterpriseId;

    private String dictName;

    private Integer dictType;

    private Integer dictStatus;

    private String remark;

    private Integer sort;

}