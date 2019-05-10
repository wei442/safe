package com.cloud.consumer.safe.rest.request.page.enterprise;

import com.cloud.consumer.safe.base.BaseRestRequest;

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

	private Integer enterpriseId;

	@ApiModelProperty(value = "机构id")
	private Integer orgId;

}