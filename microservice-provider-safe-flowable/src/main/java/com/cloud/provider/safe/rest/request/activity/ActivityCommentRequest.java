package com.cloud.provider.safe.rest.request.activity;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.ActivityComment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class ActivityCommentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer activityCommentId;

	private Integer activityId;

    private String comments;

    private Integer score;

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