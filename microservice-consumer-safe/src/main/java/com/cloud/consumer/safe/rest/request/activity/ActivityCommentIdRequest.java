package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityCommentIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "活动评论id")
	@NotNull(message = "活动评论id不能为空")
	private Integer activityCommentId;

}