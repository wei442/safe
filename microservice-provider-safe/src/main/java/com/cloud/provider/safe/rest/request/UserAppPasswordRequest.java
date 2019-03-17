package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAppPassword;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAppPasswordRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAppPasswordId;

    private Integer userId;

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