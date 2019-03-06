package com.cloud.provider.safe.rest.request;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.UserAdminLoginLog;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAdminLoginLogRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userAdminLoginLogId;

    private Integer userId;

    private String userAccount;

    private String userName;

    private String userNameEn;

    private Integer loginType;

    private Date loginTime;

    private Integer logType;

    private String loginIp;

    private Date createTime;

    private Date updateTime;

    /**
	 * 实体转换
	 * @return UserAdminLoginLog
	 */
	public UserAdminLoginLog convertToUserAdminLoginLog() {
		UserAdminLoginLogConvert convert = new UserAdminLoginLogConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserAdminLoginLogConvert extends Converter<UserAdminLoginLogRequest, UserAdminLoginLog> {

		@Override
		protected UserAdminLoginLog doForward(UserAdminLoginLogRequest userAdminLoginLogRequest) {
			UserAdminLoginLog userAdminLoginLog = new UserAdminLoginLog();
			BeanUtils.copyProperties(userAdminLoginLogRequest, userAdminLoginLog);
			return userAdminLoginLog;
		}

		@Override
		protected UserAdminLoginLogRequest doBackward(UserAdminLoginLog b) {
			return null;
		}

	}

}