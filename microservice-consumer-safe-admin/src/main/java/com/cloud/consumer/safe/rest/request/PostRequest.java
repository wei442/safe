package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class PostRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer postId;

    private Integer enterpriseId;

    private String postName;

    private Integer isSpecial;

    private String specialRemark;

    private String remark;

    private Integer sort;

}