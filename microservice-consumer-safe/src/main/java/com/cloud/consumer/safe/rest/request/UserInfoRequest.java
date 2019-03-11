package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserInfoRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private Integer enterpriseId;

    private String userAccount;

    private String userPassword;

    private String userName;

    private String userNameEn;

    private String nickName;

    private Integer userType;

    private Integer gender;

    private Integer userStatus;

    private String userEmail;

    private String headImage;

    private String remark;

    private Integer sort;

}