package com.cloud.provider.safe.rest.request.danger;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.provider.safe.validator.group.ModifyGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DangerAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构资质附件id")
    @NotNull(message = "机构资质附件id不能为空", groups = {ModifyGroup.class})
    private Integer dangerAttachmentId;

    @ApiModelProperty(value = "机构资质id")
    @NotNull(message = "机构资质id不能为空")
	private Integer dangerId;

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