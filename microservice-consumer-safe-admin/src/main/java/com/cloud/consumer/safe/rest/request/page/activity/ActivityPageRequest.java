package com.cloud.consumer.safe.rest.request.page.activity;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "职务id")
    @NotNull(message = "职务id不能为空")
	private Integer titleId;

}