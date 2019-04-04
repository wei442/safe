package com.cloud.provider.safe.rest.request.page.base.user;

import javax.validation.constraints.NotBlank;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseUserInfoPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户账户")
    private String userAccount;

    @ApiModelProperty(value = "用户名称")
	@NotBlank(message = "用户名称")
    private String userName;

}