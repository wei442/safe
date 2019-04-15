package com.cloud.provider.safe.rest.request.user.login;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户登录第二步请求
 * @author wei.yong
 */
@Data
public class UserLoginSecondRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

}