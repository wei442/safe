package com.cloud.consumer.safe.rest.request.post;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostAttachmentIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "岗位附件id")
	@NotNull(message = "岗位附件id不能为空")
	private Integer postAttachmentId;

}