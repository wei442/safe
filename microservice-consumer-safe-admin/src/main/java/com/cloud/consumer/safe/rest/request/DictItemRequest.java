package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class DictItemRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dictItemId;

    private Integer enterpriseId;

    private Integer dictId;

    private String itemName;

    private String itemAlias;

    private Integer itemLevel;

    private Integer itemStatus;

    private String remark;

    private Integer sort;

}