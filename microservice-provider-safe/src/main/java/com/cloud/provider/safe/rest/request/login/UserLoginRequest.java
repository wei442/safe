package com.cloud.provider.safe.rest.request.login;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户登录请求
 * @author wei.yong
 */
@Data
public class UserLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户账户")
    private String userAccount;

    @ApiModelProperty(value = "用户密码")
    private String userPassword;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "企业id")
    private Integer enterpriseId;

}