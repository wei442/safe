package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RuleAttachmentIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "规范文件附件id")
    @NotNull(message = "规范文件附件id不能为空")
	private Integer ruleAttachmentId;

}