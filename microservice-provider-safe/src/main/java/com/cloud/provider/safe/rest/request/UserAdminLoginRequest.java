package com.cloud.provider.safe.rest.request;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAdminLoginRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminLoginId;

    private Integer userId;

    private Integer firstLogin;

    private Integer loginCount;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

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