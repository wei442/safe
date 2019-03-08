package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserLogin;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class BaseUserLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserLoginId;

    private Integer baseUserId;

    private Integer loginCount;

    private Date lastPassTime;

    /**
	 * 实体转换
	 * @return BaseUserLogin
	 */
	public BaseUserLogin convertToBaseUserLogin() {
		BaseUserLoginConvert convert = new BaseUserLoginConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class BaseUserLoginConvert extends Converter<BaseUserLoginRequest, BaseUserLogin> {

		@Override
		protected BaseUserLogin doForward(BaseUserLoginRequest baseUserLoginRequest) {
			BaseUserLogin baseUserLogin = new BaseUserLogin();
			BeanUtils.copyProperties(baseUserLoginRequest, baseUserLogin);
			return baseUserLogin;
		}

		@Override
		protected BaseUserLoginRequest doBackward(BaseUserLogin b) {
			return null;
		}

	}

}