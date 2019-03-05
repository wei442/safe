package com.cloud.provider.safe.rest.request;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.boot.BootRestRequest;
import com.cloud.provider.safe.po.UserInfo;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserInfoRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private Integer enterpriseId;

    private String userAccount;

    private String userPassword;

    private String userName;

    private String userNameEn;

    private String nickName;

    private Integer userType;

    private Integer gender;

    private Integer userStatus;

    private String userEmail;

    private String headImage;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
	 * 实体转换
	 * @return UserInfo
	 */
	public UserInfo convertToUserInfo() {
		UserInfoConvert convert = new UserInfoConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserInfoConvert extends Converter<UserInfoRequest, UserInfo> {

		@Override
		protected UserInfo doForward(UserInfoRequest userInfoRequest) {
			UserInfo userInfo = new UserInfo();
			BeanUtils.copyProperties(userInfoRequest, userInfo);
			return userInfo;
		}

		@Override
		protected UserInfoRequest doBackward(UserInfo b) {
			return null;
		}

	}

}