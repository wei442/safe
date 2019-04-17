package com.cloud.provider.safe.rest.request.base.user;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserLogin;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseUserLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "基础用户登录id")
    @NotNull(message = "基础用户登录id", groups = {ModifyGroup.class})
	private Integer baseUserLoginId;

	@ApiModelProperty(value = "基础用户id")
    @NotNull(message = "基础用户id")
    private Integer baseUserId;

	@ApiModelProperty(value = "登录次数")
    private Integer loginCount;

	@ApiModelProperty(value = "过期时间")
    private Date lastPassTime;

    /**
	 * 实体转换
	 * @return BaseUserLogin
	 */
	public BaseUserLogin convertToBaseUserLogin() {
		BaseUserLoginConvert convert = new BaseUserLoginConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class BaseUserLoginConvert extends Converter<BaseUserLoginRequest, BaseUserLogin> {

		@Override
		protected BaseUserLogin doForward(BaseUserLoginRequest baseUserLoginRequest) {
			BaseUserLogin baseUserLogin = new BaseUserLogin();
			BeanUtils.copyProperties(baseUserLoginRequest, baseUserLogin);
			return baseUserLogin;
		}

		@Override
		protected BaseUserLoginRequest doBackward(BaseUserLogin b) {
			return null;
		}

	}

}