package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.BaseUserLogin;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseUserLoginPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserLoginId;

    private Integer baseUserId;

    private Integer loginCount;

    private Date lastPassTime;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

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
	private static class BaseUserLoginConvert extends Converter<BaseUserLoginPageRequest, BaseUserLogin> {

		@Override
		protected BaseUserLogin doForward(BaseUserLoginPageRequest baseUserLoginRequest) {
			BaseUserLogin baseUserLogin = new BaseUserLogin();
			BeanUtils.copyProperties(baseUserLoginRequest, baseUserLogin);
			return baseUserLogin;
		}

		@Override
		protected BaseUserLoginPageRequest doBackward(BaseUserLogin b) {
			return null;
		}

	}

}