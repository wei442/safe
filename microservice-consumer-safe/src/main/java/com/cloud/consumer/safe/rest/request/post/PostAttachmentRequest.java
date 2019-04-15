package com.cloud.consumer.safe.rest.request.post;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "岗位附件id")
	@NotNull(message = "岗位附件id不能为空", groups = {UpdateGroup.class})
	private Integer postAttachmentId;

	@ApiModelProperty(value = "岗位id")
	@NotNull(message = "岗位id不能为空")
    private Integer postId;

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