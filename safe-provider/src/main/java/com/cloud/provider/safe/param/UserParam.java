package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户请求 UserParam
 * @author wei.yong
 */
@Data
public class UserParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer enterpriseId;

    private Integer orgId;

    //排序
    private String orderByClause;

}