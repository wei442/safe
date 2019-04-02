package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 组织机构请求 OrgParam
 * @author wei.yong
 */
@Data
public class OrgParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

	private Integer orgId;

	private Integer enterpriseId;

    private Integer parentOrgId;

    //排序
    private String orderByClause;

}