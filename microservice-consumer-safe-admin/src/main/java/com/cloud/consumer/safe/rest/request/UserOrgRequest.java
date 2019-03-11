package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserOrgRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userOrgId;

    private Integer userId;

    private Integer orgId;

}