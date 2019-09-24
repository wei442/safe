package com.cloud.provider.safe.rest.request.page.user;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAdminPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id")
	private Integer enterpriseId;

	@ApiModelProperty(value = "企业名称")
    private String enterpriseName;

    @ApiModelProperty(value = "管理类型")
    private Integer adminType;

}