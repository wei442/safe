package com.cloud.consumer.safe.rest.request.page.user;

import java.util.Date;

import com.cloud.consumer.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAdminLoginLogPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userAdminLoginLogId;

    private Integer userId;

    private String userAccount;

    private String userName;

    private String userNameEn;

    private Integer loginType;

    private Date loginTime;

    private Integer logType;

    private String loginIp;

}