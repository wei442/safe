package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserQualityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户资质附件id")
    @NotNull(message = "用户资质附件id不能为空", groups = {UpdateGroup.class})
	private Integer userQualityAttachmentId;

	@ApiModelProperty(value = "用户资质id")
    @NotNull(message = "用户资质id不能为空")
	private Integer userQualityId;

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

}