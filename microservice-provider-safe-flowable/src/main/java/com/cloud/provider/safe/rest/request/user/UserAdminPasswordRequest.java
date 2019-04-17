package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAdminPassword;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAdminPasswordRequest implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户管理密码id")
    @NotNull(message = "用户管理密码id不能为空", groups = {ModifyGroup.class})
	private Integer userAdminPasswordId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "密码")
	@NotBlank(message = "密码不能为空")
    private String password;

	@ApiModelProperty(value = "确认密码")
	@NotBlank(message = "确认密码不能为空")
	private String confirPassword;

    /**
	 * 实体转换
	 * @return UserAdminPassword
	 */
	public UserAdminPassword convertToUserAdminPassword() {
		UserAdminPasswordConvert convert = new UserAdminPasswordConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserAdminPasswordConvert extends Converter<UserAdminPasswordRequest, UserAdminPassword> {

		@Override
		protected UserAdminPassword doForward(UserAdminPasswordRequest userAdminPasswordRequest) {
			UserAdminPassword userAdminPassword = new UserAdminPassword();
			BeanUtils.copyProperties(userAdminPasswordRequest, userAdminPassword);
			return userAdminPassword;
		}

		@Override
		protected UserAdminPasswordRequest doBackward(UserAdminPassword b) {
			return null;
		}

	}

}