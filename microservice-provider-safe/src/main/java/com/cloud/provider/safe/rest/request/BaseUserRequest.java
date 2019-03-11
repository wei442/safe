package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUser;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseUserRequest implements Serializable {

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

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

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
	private static class BaseUserConvert extends Converter<BaseUserRequest, BaseUser> {

		@Override
		protected BaseUser doForward(BaseUserRequest baseUserRequest) {
			BaseUser baseUser = new BaseUser();
			BeanUtils.copyProperties(baseUserRequest, baseUser);
			return baseUser;
		}

		@Override
		protected BaseUserRequest doBackward(BaseUser b) {
			return null;
		}

	}

}