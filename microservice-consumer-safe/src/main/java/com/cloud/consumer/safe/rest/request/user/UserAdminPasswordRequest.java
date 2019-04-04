package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAdminPasswordRequest implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户管理密码id", required = true)
    @NotNull(message = "用户管理密码id不能为空", groups = {UpdateGroup.class})
	private Integer userAdminPasswordId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "密码", required = true)
	@NotBlank(message = "密码不能为空")
    private String password;

}