package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class OrgRequest implements Serializable {

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

    private String remark;

    private Integer sort;

}