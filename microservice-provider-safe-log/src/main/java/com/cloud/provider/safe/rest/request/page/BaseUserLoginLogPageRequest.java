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
public class BaseUserLoginLogPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "手机号码")
    private String baseUserAccount;

	@ApiModelProperty(value = "基础用户名称")
    private String baseUserName;

    @ApiModelProperty(value = "基础用户英文名称")
    private String baseUserNameEn;

	@ApiModelProperty(value = "登录类型")
    private Integer loginType;

	@ApiModelProperty(value = "日志类型")
    private Integer logType;
	
	@ApiModelProperty(value = "登录方式")
	private String loginMode;

}