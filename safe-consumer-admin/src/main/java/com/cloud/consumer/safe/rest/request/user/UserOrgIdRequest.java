package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserOrgIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户机构id")
    @NotNull(message = "用户机构id不能为空")
	private Integer userOrgId;

}