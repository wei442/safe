package com.cloud.provider.safe.rest.request.page;

import javax.validation.constraints.NotNull;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrgTreeRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构id")
	private Integer orgId;

	@ApiModelProperty(value = "企业id")
	@NotNull(message = "企业id")
    private Integer enterpriseId;

//    @ApiModelProperty(value = "机构父id")
//    private Integer parentOrgId;

}