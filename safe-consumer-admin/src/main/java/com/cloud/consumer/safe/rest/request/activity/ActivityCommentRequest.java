package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityCommentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "活动评论id")
	@NotNull(message = "活动评论id不能为空", groups = {UpdateGroup.class})
	private Integer activityCommentId;

	@ApiModelProperty(value = "活动id")
	@NotNull(message = "活动id不能为空")
	private Integer activityId;

	@ApiModelProperty(value = "活动评论")
	 @NotBlank(message = "活动评论不能为空")
    private String comments;

	@ApiModelProperty(value = "活动打分")
	@NotNull(message = "活动打分不能为空")
    private Integer score;

	@ApiModelProperty(value = "活动点击量")
    private Integer views;

}