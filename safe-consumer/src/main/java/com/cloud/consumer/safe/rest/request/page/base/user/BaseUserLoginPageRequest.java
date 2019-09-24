package com.cloud.consumer.safe.rest.request.page.base.user;

import java.util.Date;

import com.cloud.consumer.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseUserLoginPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserLoginId;

    private Integer baseUserId;

    private Integer loginCount;

    private Date lastPassTime;

}