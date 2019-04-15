package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttachmentIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "附件id")
    @NotNull(message = "附件id不能为空")
	private Integer attachmentId;

}