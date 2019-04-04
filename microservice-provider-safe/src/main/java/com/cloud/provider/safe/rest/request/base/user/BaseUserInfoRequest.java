package com.cloud.provider.safe.rest.request.base.user;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserInfo;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseUserInfoRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "基础用户id", required = true)
    @NotNull(message = "基础用户id不能为空", groups = {ModifyGroup.class})
	private Integer baseUserInfoId;

	@ApiModelProperty(value = "用户账户", required = true)
	@NotBlank(message = "用户账户不能为空", groups = {ModifyGroup.class})
    private String userAccount;

    @ApiModelProperty(value = "用户名称", required = true)
	@NotBlank(message = "用户名称不能为空")
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
	 * @return BaseUserInfo
	 */
	public BaseUserInfo convertToBaseUserInfo() {
		BaseUserInfoConvert convert = new BaseUserInfoConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class BaseUserInfoConvert extends Converter<BaseUserInfoRequest, BaseUserInfo> {

		@Override
		protected BaseUserInfo doForward(BaseUserInfoRequest baseUserInfoRequest) {
			BaseUserInfo baseUserInfo = new BaseUserInfo();
			BeanUtils.copyProperties(baseUserInfoRequest, baseUserInfo);
			return baseUserInfo;
		}

		@Override
		protected BaseUserInfoRequest doBackward(BaseUserInfo b) {
			return null;
		}

	}

}