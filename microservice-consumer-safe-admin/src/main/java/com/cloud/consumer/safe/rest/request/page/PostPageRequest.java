package com.cloud.consumer.safe.rest.request.page;

import com.cloud.consumer.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PostPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer postId;

    private Integer enterpriseId;

    private String postName;

    private Integer isSpecial;

    private String specialRemark;

}