package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class EnterpriseQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseQualityId;

    private Integer enterpriseId;

    private Integer qualityId;

    private String remark;

}