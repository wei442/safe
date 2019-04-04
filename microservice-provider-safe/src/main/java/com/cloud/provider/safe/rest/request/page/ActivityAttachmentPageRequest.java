package com.cloud.provider.safe.rest.request.page;

import javax.validation.constraints.NotNull;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityAttachmentPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id", required = true)
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "职务id", required = true)
    @NotNull(message = "职务id不能为空")
	private Integer titleId;

}