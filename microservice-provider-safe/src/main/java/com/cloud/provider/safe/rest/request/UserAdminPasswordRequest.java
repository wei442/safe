package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAdminPassword;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAdminPasswordRequest implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminPasswordId;

    private Integer userId;

    private String password;

    private Date createTime;

    private Date updateTime;

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