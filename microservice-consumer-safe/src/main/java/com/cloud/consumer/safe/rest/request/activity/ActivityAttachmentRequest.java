package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "活动附件id")
	@NotNull(message = "活动id不能为空", groups = {UpdateGroup.class})
	private Integer activityAttachmentId;

	@ApiModelProperty(value = "活动id")
	private Integer activityId;

	@ApiModelProperty(value = "附件名称")
    @NotNull(message = "附件名称不能为空")
    private String name;

    @ApiModelProperty(value = "附件url")
    @NotNull(message = "附件url不能为空")
    private String url;


}