package com.cloud.provider.safe.rest.request.page.enterprise;

import javax.validation.constraints.NotNull;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrgQualityPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

    @ApiModelProperty(value = "资质名称")
    private String qualityName;

}