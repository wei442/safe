package com.cloud.consumer.safe.rest.request.page.user;

import com.cloud.consumer.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAdminPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminId;

    private Integer enterpriseId;

    private Integer userId;

    private String adminName;

    private Integer adminType;

}