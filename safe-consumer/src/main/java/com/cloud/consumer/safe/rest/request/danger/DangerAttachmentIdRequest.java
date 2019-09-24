package com.cloud.consumer.safe.rest.request.danger;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DangerAttachmentIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构资质附件id")
    @NotNull(message = "机构资质附件id不能为空", groups = {UpdateGroup.class})
    private Integer dangerAttachmentId;

}