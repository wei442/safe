package com.cloud.consumer.safe.rest.request.enterprise;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgQualityIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构资质id", required = true)
    @NotNull(message = "机构资质id不能为空")
	private Integer orgQualityId;

}