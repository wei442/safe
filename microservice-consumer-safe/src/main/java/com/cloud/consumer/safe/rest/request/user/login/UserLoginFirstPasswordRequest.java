package com.cloud.consumer.safe.rest.request.user.login;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户登录请求
 * @author wei.yong
 */
@Data
public class UserLoginFirstPasswordRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

//	@ApiModelProperty(value = "用户账户")
//	@NotBlank(message = "用户账户不能为空")
//	private String userAccount;

//	@ApiModelProperty(value = "用户密码")
//	@NotBlank(message = "用户密码不能为空")
//	private String userPassword;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "密码")
	@NotBlank(message = "密码不能为空")
	private String password;

	@ApiModelProperty(value = "确认密码")
	@NotBlank(message = "确认密码不能为空")
	private String confirmPassword;

}