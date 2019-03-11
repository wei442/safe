package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAppLoginLog;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAppLoginLogRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userAppLoginLogId;

    private Integer userId;

    private String userAccount;

    private String userName;

    private String userNameEn;

    private Integer loginType;

    private Date loginTime;

    private Integer logType;

    private String loginIp;

    /**
	 * 实体转换
	 * @return UserAppLoginLog
	 */
	public UserAppLoginLog convertToUserAppLoginLog() {
		UserAppLoginLogConvert convert = new UserAppLoginLogConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserAppLoginLogConvert extends Converter<UserAppLoginLogRequest, UserAppLoginLog> {

		@Override
		protected UserAppLoginLog doForward(UserAppLoginLogRequest userAppLoginLogRequest) {
			UserAppLoginLog userAppLoginLog = new UserAppLoginLog();
			BeanUtils.copyProperties(userAppLoginLogRequest, userAppLoginLog);
			return userAppLoginLog;
		}

		@Override
		protected UserAppLoginLogRequest doBackward(UserAppLoginLog b) {
			return null;
		}

	}

}