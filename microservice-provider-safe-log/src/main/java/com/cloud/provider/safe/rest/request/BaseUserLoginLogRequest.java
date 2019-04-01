package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserLoginLog;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseUserLoginLogRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "基础用户id", required = true)
    @NotNull(message = "基础用户id不能为空", groups = {ModifyGroup.class})
	private Long baseUserLoginLogId;

	@ApiModelProperty(value = "基础用户id", required = true)
    @NotNull(message = "基础用户id不能为空")
	private Integer baseUserId;

	@ApiModelProperty(value = "手机号码", required = true)
    @NotBlank(message = "手机号码不能为空")
    private String baseUserAccount;

	@ApiModelProperty(value = "基础用户名称", required = true)
    @NotBlank(message = "基础用户名称")
    private String baseUserName;

    @ApiModelProperty(value = "基础用户英文名称")
    private String baseUserNameEn;

	@ApiModelProperty(value = "登录类型")
    private Integer loginType;

	@ApiModelProperty(value = "登录时间")
    private Date loginTime;

	@ApiModelProperty(value = "日志类型")
    private Integer logType;
	
	@ApiModelProperty(value = "登录方式")
	private String loginMode;

	@ApiModelProperty(value = "登录ip")
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