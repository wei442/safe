package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 风险排查请求 RiskCheckParam
 * @author wei.yong
 */
@Data
public class RiskCheckParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer enterpriseId;

    //分组
    private String groupByClause;

    //排序
    private String orderByClause;

}