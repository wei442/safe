package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAdminPasswordIdRequest implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户管理密码id", required = true)
    @NotNull(message = "用户管理密码id不能为空")
	private Integer userAdminPasswordId;

}