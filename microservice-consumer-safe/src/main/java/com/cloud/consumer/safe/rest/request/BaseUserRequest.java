package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseUserRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserId;

    private String userAccount;

    private String userName;

    private String userNameEn;

    private String userPassword;

    private Integer userType;

    private Integer userStatus;

    private String userEmail;

    private String remark;

    private Integer sort;

}