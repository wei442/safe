package com.cloud.consumer.safe.rest.request.base.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseUserInfoIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "基础用户id", required = true)
    @NotNull(message = "基础用户id不能为空")
	private Integer baseUserId;

}