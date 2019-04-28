package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAdminSlaveRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户管理id")
	@NotNull(message = "用户管理id不能为空", groups = {ModifyGroup.class})
	private Integer userAdminId;

	@ApiModelProperty(value = "企业id")
	@NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "管理名称")
    private String adminName;

	@ApiModelProperty(value = "管理类型")
    private Integer adminType;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

	/**
	 * 实体转换
	 * @return UserAdmin
	 */
	public UserAdmin convertToUserAdmin() {
		UserAdminSlaveConvert convert = new UserAdminSlaveConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserAdminSlaveConvert extends Converter<UserAdminSlaveRequest, UserAdmin> {

		@Override
		protected UserAdmin doForward(UserAdminSlaveRequest userAdminRequest) {
			UserAdmin userAdmin = new UserAdmin();
			BeanUtils.copyProperties(userAdminRequest, userAdmin);
			return userAdmin;
		}

		@Override
		protected UserAdminSlaveRequest doBackward(UserAdmin b) {
			return null;
		}

	}

}