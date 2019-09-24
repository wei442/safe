package com.cloud.provider.safe.rest.request.activity;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.ActivityComment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityCommentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "活动评论id")
	@NotNull(message = "活动评论id不能为空", groups = {ModifyGroup.class})
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

    /**
	 * 实体转换
	 * @return ActivityComment
	 */
	public ActivityComment convertToActivityComment() {
		ActivityCommentConvert convert = new ActivityCommentConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class ActivityCommentConvert extends Converter<ActivityCommentRequest, ActivityComment> {

		@Override
		protected ActivityComment doForward(ActivityCommentRequest activityCommentRequest) {
			ActivityComment activityComment = new ActivityComment();
			BeanUtils.copyProperties(activityCommentRequest, activityComment);
			return activityComment;
		}

		@Override
		protected ActivityCommentRequest doBackward(ActivityComment b) {
			return null;
		}

	}

}