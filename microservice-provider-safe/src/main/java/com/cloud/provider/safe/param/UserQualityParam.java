package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户资质请求 UserQualityParam
 * @author wei.yong
 */
@Data
public class UserQualityParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer enterpriseId;

    private Integer userId;

    private String userName;

    //排序
    private String orderByClause;

}