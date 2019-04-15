package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityAttachmentIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "活动附件id")
	@NotNull(message = "活动id不能为空")
	private Integer activityAttachmentId;

}