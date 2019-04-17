package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户职务请求 UserTitleParam
 * @author wei.yong
 */
@Data
public class UserTitleParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer enterpriseId;

    private Integer titleId;

    //排序
    private String orderByClause;

}