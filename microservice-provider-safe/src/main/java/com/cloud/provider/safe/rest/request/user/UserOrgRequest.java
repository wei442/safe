package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserOrgRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户机构id")
    @NotNull(message = "用户机构id不能为空", groups = {ModifyGroup.class})
	private Integer userOrgId;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "机构id")
    @NotNull(message = "机构id不能为空")
    private Integer orgId;

	@ApiModelProperty(value = "手机号码")
	@NotBlank(message = "手机号码不能为空")
    private String userAccount;

    @ApiModelProperty(value = "用户名称")
	@NotBlank(message = "用户名称不能为空")
    private String userName;


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