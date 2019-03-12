package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUser;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseUserRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "基础用户id", required = true)
    @NotNull(message = "基础用户id", groups = {ModifyGroup.class})
	private Integer baseUserId;

	@ApiModelProperty(value = "用户账户", required = true)
	@NotBlank(message = "用户账户", groups = {ModifyGroup.class})
    private String userAccount;

    @ApiModelProperty(value = "用户密码", required = true)
	@NotBlank(message = "用户密码", groups = {ModifyGroup.class})
    private String userPassword;

    @ApiModelProperty(value = "用户名称", required = true)
	@NotBlank(message = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户英文名称")
    private String userNameEn;

    @ApiModelProperty(value = "用户邮箱")
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