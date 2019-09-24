package com.cloud.consumer.safe.rest.request.page.danger;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DangerAttachmentPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "隐患id")
    @NotNull(message = "隐患id不能为空")
	private Integer dangerId;

}