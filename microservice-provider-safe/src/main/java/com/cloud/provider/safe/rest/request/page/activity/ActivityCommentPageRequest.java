package com.cloud.provider.safe.rest.request.page.activity;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityCommentPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "活动id")
	private Integer activityId;

	@ApiModelProperty(value = "活动评论")
    private String comments;

	@ApiModelProperty(value = "活动打分")
    private Integer score;

	@ApiModelProperty(value = "活动点击量")
    private Integer views;

}