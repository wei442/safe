package com.cloud.provider.safe.rest.request.page.user;

import java.util.Date;

import com.cloud.provider.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAppLoginPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAppLoginId;

    private Integer userId;

    private Integer firstLogin;

    private Integer loginCount;

    private Date lastPassTime;

}