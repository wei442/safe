package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserPassword;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseUserPasswordRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典子项id", required = true)
    @NotNull(message = "字典子项id不能为空", groups = {ModifyGroup.class})
	private Integer baseUserPasswordId;

	@ApiModelProperty(value = "基础用户id不能为空", required = true)
    @NotNull(message = "基础用户id不能为空")
    private Integer baseUserId;

	@ApiModelProperty(value = "密码", required = true)
	@NotBlank(message = "密码不能为空")
    private String password;

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