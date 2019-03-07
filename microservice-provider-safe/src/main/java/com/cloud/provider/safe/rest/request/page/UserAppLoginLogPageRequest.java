package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.UserAppLoginLog;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAppLoginLogPageRequest extends BaseRestRequest {

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

    private Date createTime;

    private Date updateTime;

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
	private static class UserAppLoginLogConvert extends Converter<UserAppLoginLogPageRequest, UserAppLoginLog> {

		@Override
		protected UserAppLoginLog doForward(UserAppLoginLogPageRequest userAppLoginLogRequest) {
			UserAppLoginLog userAppLoginLog = new UserAppLoginLog();
			BeanUtils.copyProperties(userAppLoginLogRequest, userAppLoginLog);
			return userAppLoginLog;
		}

		@Override
		protected UserAppLoginLogPageRequest doBackward(UserAppLoginLog b) {
			return null;
		}

	}

}