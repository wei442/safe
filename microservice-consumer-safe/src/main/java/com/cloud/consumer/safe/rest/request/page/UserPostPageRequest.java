package com.cloud.consumer.safe.rest.request.page;

import com.cloud.consumer.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserPostPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userPostId;

    private Integer userId;

    private Integer postId;

}