package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户岗位请求 UserPostParam
 * @author wei.yong
 */
@Data
public class UserPostParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer enterpriseId;

    private Integer postId;

    //排序
    private String orderByClause;

}