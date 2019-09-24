package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAppLogin;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAppLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空", groups = {ModifyGroup.class})
	private Integer userAppLoginId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "登录次数")
    private Integer loginCount;

	@ApiModelProperty(value = "过期时间")
    private Date lastPassTime;

    /**
	 * 实体转换
	 * @return UserAppLogin
	 */
	public UserAppLogin convertToUserAppLogin() {
		UserAppLoginConvert convert = new UserAppLoginConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserAppLoginConvert extends Converter<UserAppLoginRequest, UserAppLogin> {

		@Override
		protected UserAppLogin doForward(UserAppLoginRequest userAppLoginRequest) {
			UserAppLogin userAppLogin = new UserAppLogin();
			BeanUtils.copyProperties(userAppLoginRequest, userAppLogin);
			return userAppLogin;
		}

		@Override
		protected UserAppLoginRequest doBackward(UserAppLogin b) {
			return null;
		}

	}

}