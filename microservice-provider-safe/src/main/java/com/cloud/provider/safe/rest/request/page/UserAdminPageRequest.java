package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.UserAdmin;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserAdminPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminId;

    private Integer enterpriseId;

    private Integer userId;

    private String adminName;

    private Integer adminType;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
	 * 实体转换
	 * @return UserAdmin
	 */
	public UserAdmin convertToUserAdmin() {
		UserAdminConvert convert = new UserAdminConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserAdminConvert extends Converter<UserAdminPageRequest, UserAdmin> {

		@Override
		protected UserAdmin doForward(UserAdminPageRequest userAdminRequest) {
			UserAdmin userAdmin = new UserAdmin();
			BeanUtils.copyProperties(userAdminRequest, userAdmin);
			return userAdmin;
		}

		@Override
		protected UserAdminPageRequest doBackward(UserAdmin b) {
			return null;
		}

	}

}