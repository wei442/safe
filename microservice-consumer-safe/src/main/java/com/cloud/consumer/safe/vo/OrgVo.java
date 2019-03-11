package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class OrgVo implements Serializable {

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

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}