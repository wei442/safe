package com.cloud.provider.safe.rest.request.page;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAdminLoginLogPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id")
    private Integer userId;

	@ApiModelProperty(value = "手机号码")
    private String userAccount;

	@ApiModelProperty(value = "用户名称")
    private String userName;

	@ApiModelProperty(value = "用户英文名称")
    private String userNameEn;

	@ApiModelProperty(value = "登录类型")
    private Integer loginType;

	@ApiModelProperty(value = "日志类型")
    private Integer logType;

	@ApiModelProperty(value = "登录方式")
	private String loginMode;

	@ApiModelProperty(value = "登录ip")
	private String loginIp;

}