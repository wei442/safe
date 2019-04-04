package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAppPassword;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAppPasswordRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户应用密码id", required = true)
    @NotNull(message = "用户应用密码id不能为空", groups = {ModifyGroup.class})
	private Integer userAppPasswordId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "密码", required = true)
	@NotBlank(message = "密码不能为空")
    private String password;

    /**
	 * 实体转换
	 * @return UserAppPassword
	 */
	public UserAppPassword convertToUserAppPassword() {
		UserAppPasswordConvert convert = new UserAppPasswordConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserAppPasswordConvert extends Converter<UserAppPasswordRequest, UserAppPassword> {

		@Override
		protected UserAppPassword doForward(UserAppPasswordRequest userAppPasswordRequest) {
			UserAppPassword userAppPassword = new UserAppPassword();
			BeanUtils.copyProperties(userAppPasswordRequest, userAppPassword);
			return userAppPassword;
		}

		@Override
		protected UserAppPasswordRequest doBackward(UserAppPassword b) {
			return null;
		}

	}

}