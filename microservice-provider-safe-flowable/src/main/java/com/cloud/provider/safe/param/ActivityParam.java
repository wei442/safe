package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 安全活动请求 ActivityParam
 * @author wei.yong
 */
@Data
public class ActivityParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer orgId;

    private String orgName;

    //排序
    private String orderByClause;

}