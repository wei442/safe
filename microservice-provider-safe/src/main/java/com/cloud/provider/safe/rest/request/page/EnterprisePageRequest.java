package com.cloud.provider.safe.rest.request.page;

import com.cloud.provider.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EnterprisePageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseId;

    private String enterpriseName;

    private Integer enterpriseType;

    private Integer enterpriseNature;

    private Integer enterpriseStatus;

    private String enterpriseAlias;

    private String enterpriseTelphone;

    private Integer enterpriseLevel;

    private String enterpriseFax;

    private String enterpriseEmail;

    private String enterprisePostCode;

    private String enterpriseAddr;

    private String enterpriseWebside;

}