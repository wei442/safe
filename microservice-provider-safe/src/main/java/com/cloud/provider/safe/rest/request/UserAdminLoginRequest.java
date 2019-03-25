package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAdminLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id", groups = {ModifyGroup.class})
	private Integer userAdminLoginId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id")
    private Integer userId;

	@ApiModelProperty(value = "登录次数")
    private Integer loginCount;

    /**
	 * 实体转换
	 * @return UserAdminLogin
	 */
	public UserAdminLogin convertToUserAdminLogin() {
		UserAdminLoginConvert convert = new UserAdminLoginConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserAdminLoginConvert extends Converter<UserAdminLoginRequest, UserAdminLogin> {

		@Override
		protected UserAdminLogin doForward(UserAdminLoginRequest userAdminLoginRequest) {
			UserAdminLogin userAdminLogin = new UserAdminLogin();
			BeanUtils.copyProperties(userAdminLoginRequest, userAdminLogin);
			return userAdminLogin;
		}

		@Override
		protected UserAdminLoginRequest doBackward(UserAdminLogin b) {
			return null;
		}

	}

}