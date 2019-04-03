package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QualityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "岗位id")
	@NotNull(message = "岗位id不能为空", groups = {UpdateGroup.class})
	private Integer qualityAttachmentId;

	@ApiModelProperty(value = "资质id", required = true)
    @NotNull(message = "资质id不能为空")
    private Integer qualityId;

	@ApiModelProperty(value = "附件id", required = true)
    @NotNull(message = "附件id不能为空")
    private Integer attachmentId;

	@ApiModelProperty(value = "附件url", required = true)
	@NotBlank(message = "附件url不能为空")
    private String attachmentUrl;

	@ApiModelProperty(value = "备注")
    private String remark;

}