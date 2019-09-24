package com.cloud.consumer.safe.rest.request.page.enterprise;

import com.cloud.consumer.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrgPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private Integer enterpriseId;

    @ApiModelProperty(value = "机构名称")
    private String orgName;

}