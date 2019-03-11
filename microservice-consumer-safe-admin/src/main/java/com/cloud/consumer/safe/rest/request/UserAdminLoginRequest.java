package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserAdminLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminLoginId;

    private Integer userId;

    private Integer firstLogin;

    private Integer loginCount;

}