package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.validator.group.ModifyGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAppLoginLogPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;


	@ApiModelProperty(value = "用户id")
    private Integer userId;

	@ApiModelProperty(value = "手机号码")
    private String userAccount;

	@ApiModelProperty(value = "用户名称")
    @NotBlank(message = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户英文名称")
    private String userNameEn;

	@ApiModelProperty(value = "登录类型")
    private Integer loginType;

	@ApiModelProperty(value = "日志类型")
    private Integer logType;
	
	@ApiModelProperty(value = "登录ip")
	private String loginMode;

}