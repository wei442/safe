package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserPassword;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class BaseUserPasswordRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserPasswordId;

    private Integer baseUserId;

    private String password;

    private Date createTime;

    private Date updateTime;

    /**
	 * 实体转换
	 * @return BaseUserPassword
	 */
	public BaseUserPassword convertToBaseUserPassword() {
		BaseUserPasswordConvert convert = new BaseUserPasswordConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class BaseUserPasswordConvert extends Converter<BaseUserPasswordRequest, BaseUserPassword> {

		@Override
		protected BaseUserPassword doForward(BaseUserPasswordRequest baseUserPasswordRequest) {
			BaseUserPassword baseUserPassword = new BaseUserPassword();
			BeanUtils.copyProperties(baseUserPasswordRequest, baseUserPassword);
			return baseUserPassword;
		}

		@Override
		protected BaseUserPasswordRequest doBackward(BaseUserPassword b) {
			return null;
		}

	}

}