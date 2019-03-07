package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.BaseUser;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BaseUserPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserId;

    private String userAccount;

    private String userName;

    private String userNameEn;

    private String userPassword;

    private Integer userType;

    private Integer userStatus;

    private String userEmail;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
	 * 实体转换
	 * @return BaseUser
	 */
	public BaseUser convertToBaseUser() {
		BaseUserConvert convert = new BaseUserConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class BaseUserConvert extends Converter<BaseUserPageRequest, BaseUser> {

		@Override
		protected BaseUser doForward(BaseUserPageRequest baseUserRequest) {
			BaseUser baseUser = new BaseUser();
			BeanUtils.copyProperties(baseUserRequest, baseUser);
			return baseUser;
		}

		@Override
		protected BaseUserPageRequest doBackward(BaseUser b) {
			return null;
		}

	}

}