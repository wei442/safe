package com.cloud.consumer.safe.rest.request.enterprise;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构id")
	@NotNull(message = "机构id不能为空")
	private Integer orgId;

}