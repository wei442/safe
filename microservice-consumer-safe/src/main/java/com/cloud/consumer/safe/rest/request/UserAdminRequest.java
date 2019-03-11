package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class UserAdminRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminId;

    private Integer enterpriseId;

    private Integer userId;

    private String adminName;

    private Integer adminType;

    private String remark;

    private Integer sort;

}