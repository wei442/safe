package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "附件id", required = true)
    @NotNull(message = "附件id不能为空", groups = {UpdateGroup.class})
	private Integer attachmentId;

	@ApiModelProperty(value = "附件url", required = true)
	@NotBlank(message = "附件url不能为空")
    private String attachmentUrl;

	@ApiModelProperty(value = "附件类型")
    @NotNull(message = "附件类型不能为空")
    private Integer attachmentType;

	@ApiModelProperty(value = "备注")
    private String remark;

}