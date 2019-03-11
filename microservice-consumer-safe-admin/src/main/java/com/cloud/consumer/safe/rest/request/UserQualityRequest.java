package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userQualityId;

    private Integer userId;

    private Integer qualityId;

    private Integer isDelete;

    private String remark;

}