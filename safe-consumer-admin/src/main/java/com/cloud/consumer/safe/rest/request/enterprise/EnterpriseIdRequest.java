package com.cloud.consumer.safe.rest.request.enterprise;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EnterpriseIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
	private Integer enterpriseId;


}