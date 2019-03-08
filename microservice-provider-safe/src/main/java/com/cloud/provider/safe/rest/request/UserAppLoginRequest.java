package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAppLogin;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAppLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAppLoginId;

    private Integer userId;

    private Integer firstLogin;

    private Integer loginCount;

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