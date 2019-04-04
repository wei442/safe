package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 机构资质请求 OrgQualityParam
 * @author wei.yong
 */
@Data
public class OrgQualityParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer orgId;

    private String orgName;

    //排序
    private String orderByClause;

}