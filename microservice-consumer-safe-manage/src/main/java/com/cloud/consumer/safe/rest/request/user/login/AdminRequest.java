package com.cloud.consumer.safe.rest.request.user.login;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户注册请求
 * @author wei.yong
 */
@Data
public class AdminRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "手机号码")
	@NotBlank(message = "手机号码不能为空")
    private String userAccount;

    @ApiModelProperty(value = "用户名称")
	@NotBlank(message = "用户名称不能为空")
    private String userName;

    @ApiModelProperty(value = "企业名称")
	@NotBlank(message = "企业名称")
    private String enterpriseName;

}