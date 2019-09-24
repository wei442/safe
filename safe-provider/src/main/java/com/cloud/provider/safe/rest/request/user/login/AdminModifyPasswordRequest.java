package com.cloud.provider.safe.rest.request.user.login;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户管理修改密码请求
 * @author wei.yong
 */
@Data
public class AdminModifyPasswordRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "密码")
	@NotBlank(message = "密码不能为空")
    private String password;

}