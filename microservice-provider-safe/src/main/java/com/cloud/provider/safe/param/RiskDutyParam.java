package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 风险责任请求 RiskDutyParam
 * @author wei.yong
 */
@Data
public class RiskDutyParam implements Serializable {

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