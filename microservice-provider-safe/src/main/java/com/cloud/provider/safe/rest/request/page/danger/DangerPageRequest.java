package com.cloud.provider.safe.rest.request.page.danger;

import javax.validation.constraints.NotNull;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DangerPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "隐患id")
    @NotNull(message = "隐患id不能为空")
	private Integer dangerId;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

}