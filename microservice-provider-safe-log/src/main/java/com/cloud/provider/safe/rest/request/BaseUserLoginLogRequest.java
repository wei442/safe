package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserLoginLog;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseUserLoginLogRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "基础用户账户")
    @NotBlank(message = "基础用户账户不能为空")
    private String baseUserAccount;

	@ApiModelProperty(value = "基础用户名称")
    @NotBlank(message = "基础用户名称")
    private String baseUserName;

    @ApiModelProperty(value = "基础用户英文名称")
    private String baseUserNameEn;

	@ApiModelProperty(value = "登录类型")
	@NotNull(message = "登录类型不能为空")
    private Integer loginType;

	@ApiModelProperty(value = "登录时间")
	@NotNull(message = "登录时间不能为空")
    private Date loginTime;

	@ApiModelProperty(value = "日志类型")
	@NotNull(message = "日志类型不能为空")
    private Integer logType;

	@ApiModelProperty(value = "登录方式")
	@NotNull(message = "登录方式不能为空")
	private String loginMode;

	@ApiModelProperty(value = "登录ip")
	@NotNull(message = "登录ip不能为空")
    private String loginIp;

    /**
	 * 实体转换
	 * @return BaseUserLoginLog
	 */
	public BaseUserLoginLog convertToBaseUserLoginLog() {
		BaseUserLoginLogConvert convert = new BaseUserLoginLogConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class BaseUserLoginLogConvert extends Converter<BaseUserLoginLogRequest, BaseUserLoginLog> {

		@Override
		protected BaseUserLoginLog doForward(BaseUserLoginLogRequest baseUserLoginLogRequest) {
			BaseUserLoginLog baseUserLoginLog = new BaseUserLoginLog();
			BeanUtils.copyProperties(baseUserLoginLogRequest, baseUserLoginLog);
			return baseUserLoginLog;
		}

		@Override
		protected BaseUserLoginLogRequest doBackward(BaseUserLoginLog b) {
			return null;
		}

	}

}