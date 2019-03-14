package com.cloud.provider.safe.param;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户请求 Param
 * @author wei.yong
 */
@Data
public class UserParam implements Serializable {

	/**
     *
     */
    private static final long serialVersionUID = 1L;

    private Integer orgId;

	private Integer enterpriseId;

}