package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserOrg;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserOrgRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userOrgId;

    private Integer userId;

    private Integer orgId;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
	 * 实体转换
	 * @return UserOrg
	 */
	public UserOrg convertToUserOrg() {
		UserOrgConvert convert = new UserOrgConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserOrgConvert extends Converter<UserOrgRequest, UserOrg> {

		@Override
		protected UserOrg doForward(UserOrgRequest userOrgRequest) {
			UserOrg userOrg = new UserOrg();
			BeanUtils.copyProperties(userOrgRequest, userOrg);
			return userOrg;
		}

		@Override
		protected UserOrgRequest doBackward(UserOrg b) {
			return null;
		}

	}

}