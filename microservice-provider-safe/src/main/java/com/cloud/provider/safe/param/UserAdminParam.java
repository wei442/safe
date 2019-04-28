package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户管理请求 UserAdminParam
 * @author wei.yong
 */
@Data
public class UserAdminParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer enterpriseId;

    //排序
    private String orderByClause;

}