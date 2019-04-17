package com.cloud.provider.safe.rest.request.activity;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.ActivityAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class ActivityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer activityAttachmentId;

	private Integer activityId;

    private Integer attachmentId;

    private String attachmentUrl;

    /**
	 * 实体转换
	 * @return ActivityAttachment
	 */
	public ActivityAttachment convertToActivityAttachment() {
		ActivityAttachmentConvert convert = new ActivityAttachmentConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class ActivityAttachmentConvert extends Converter<ActivityAttachmentRequest, ActivityAttachment> {

		@Override
		protected ActivityAttachment doForward(ActivityAttachmentRequest activityAttachmentRequest) {
			ActivityAttachment activityAttachment = new ActivityAttachment();
			BeanUtils.copyProperties(activityAttachmentRequest, activityAttachment);
			return activityAttachment;
		}

		@Override
		protected ActivityAttachmentRequest doBackward(ActivityAttachment b) {
			return null;
		}

	}

}