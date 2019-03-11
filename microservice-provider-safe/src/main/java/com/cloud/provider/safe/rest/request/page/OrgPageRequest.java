package com.cloud.provider.safe.rest.request.page;

import com.cloud.provider.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrgPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer orgId;

    private Integer enterpriseId;

    private Integer parentOrgId;

    private String parentOrgName;

    private String parentOrgNameEn;

    private String orgName;

    private String orgNameEn;

    private String orgAlias;

    private String orgTelphone;

    private Integer orgType;

    private Integer orgStatus;

    private Integer orgLevel;

    private String orgFax;

    private String orgEmail;

    private String orgPostCode;

    private String orgAddr;

    private String orgWebsite;

}