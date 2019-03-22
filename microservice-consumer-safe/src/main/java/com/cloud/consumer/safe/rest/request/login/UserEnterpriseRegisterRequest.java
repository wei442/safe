package com.cloud.consumer.safe.rest.request.login;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户企业注册请求
 * @author wei.yong
 */
@Data
public class UserEnterpriseRegisterRequest implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户账户", required = true)
	@NotBlank(message = "用户账户")
	private String userAccount;

    @ApiModelProperty(value = "企业名称", required = true)
	@NotBlank(message = "企业名称")
    private String enterpriseName;

}