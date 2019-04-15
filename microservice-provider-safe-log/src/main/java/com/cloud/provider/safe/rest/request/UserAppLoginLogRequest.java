package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAppLoginLog;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAppLoginLogRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户应用登录日志id")
    @NotNull(message = "用户应用登录日志id不能为空", groups = {ModifyGroup.class})
	private Long userAppLoginLogId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "手机号码")
    @NotBlank(message = "手机号码不能为空")
    private String userAccount;

	@ApiModelProperty(value = "用户名称")
    @NotBlank(message = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户英文名称")
    private String userNameEn;

	@ApiModelProperty(value = "登录类型")
    private Integer loginType;

	@ApiModelProperty(value = "登录时间")
    private Date loginTime;

	@ApiModelProperty(value = "日志类型")
    private Integer logType;
	
	@ApiModelProperty(value = "登录方式")
	private String loginMode;

	@ApiModelProperty(value = "用户名称")
    private String loginIp;

    /**
	 * 实体转换
	 * @return UserAppLoginLog
	 */
	public UserAppLoginLog convertToUserAppLoginLog() {
		UserAppLoginLogConvert convert = new UserAppLoginLogConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserAppLoginLogConvert extends Converter<UserAppLoginLogRequest, UserAppLoginLog> {

		@Override
		protected UserAppLoginLog doForward(UserAppLoginLogRequest userAppLoginLogRequest) {
			UserAppLoginLog userAppLoginLog = new UserAppLoginLog();
			BeanUtils.copyProperties(userAppLoginLogRequest, userAppLoginLog);
			return userAppLoginLog;
		}

		@Override
		protected UserAppLoginLogRequest doBackward(UserAppLoginLog b) {
			return null;
		}

	}

}