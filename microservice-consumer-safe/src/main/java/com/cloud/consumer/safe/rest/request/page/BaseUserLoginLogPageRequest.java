package com.cloud.consumer.safe.rest.request.page;

import java.util.Date;

import com.cloud.consumer.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseUserLoginLogPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long baseUserLoginLogId;

    private Integer baseUserId;

    private String baseUserAccount;

    private String baseUserName;

    private String baseUserNameEn;

    private Integer loginType;

    private Date loginTime;

    private String loginIp;

}