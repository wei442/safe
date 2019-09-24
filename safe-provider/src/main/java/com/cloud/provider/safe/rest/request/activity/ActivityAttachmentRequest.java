package com.cloud.provider.safe.rest.request.activity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.ActivityAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "活动附件id")
	@NotNull(message = "活动id不能为空", groups = {ModifyGroup.class})
	private Integer activityAttachmentId;

	@ApiModelProperty(value = "活动id")
	@NotNull(message = "活动id不能为空")
	private Integer activityId;

	@ApiModelProperty(value = "附件名称")
    @NotNull(message = "附件名称不能为空")
    private String name;

    @ApiModelProperty(value = "附件url")
    @NotNull(message = "附件url不能为空")
    private String url;

    @ApiModelProperty(value = "创建人")
    private String created;

    @ApiModelProperty(value = "修改人")
    private String updated;

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