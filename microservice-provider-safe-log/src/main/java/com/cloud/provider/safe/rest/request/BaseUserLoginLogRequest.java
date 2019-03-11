package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserLoginLog;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class BaseUserLoginLogRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long baseUserLoginLogId;

    private Integer baseUserId;

    private String baseUserAccount;

    private String baseUserName;

    private String baseUserNameEn;

    private Integer loginType;

    private Date loginTime;

    private String loginIp;

    /**
	 * 实体转换
	 * @return BaseUserLoginLog
	 */
	public BaseUserLoginLog convertToBaseUserLoginLog() {
		BaseUserLoginLogConvert convert = new BaseUserLoginLogConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class BaseUserLoginLogConvert extends Converter<BaseUserLoginLogRequest, BaseUserLoginLog> {

		@Override
		protected BaseUserLoginLog doForward(BaseUserLoginLogRequest baseUserLoginLogRequest) {
			BaseUserLoginLog baseUserLoginLog = new BaseUserLoginLog();
			BeanUtils.copyProperties(baseUserLoginLogRequest, baseUserLoginLog);
			return baseUserLoginLog;
		}

		@Override
		protected BaseUserLoginLogRequest doBackward(BaseUserLoginLog b) {
			return null;
		}

	}

}