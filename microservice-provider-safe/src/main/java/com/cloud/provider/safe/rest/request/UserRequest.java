package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserInfo;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id", groups = {ModifyGroup.class})
	private Integer userId;

	@ApiModelProperty(value = "企业id", required = true)
    @NotNull(message = "企业id", groups = {ModifyGroup.class})
    private Integer enterpriseId;

    @ApiModelProperty(value = "用户账户", required = true)
	@NotBlank(message = "用户账户", groups = {ModifyGroup.class})
    private String userAccount;

    @ApiModelProperty(value = "用户名称", required = true)
	@NotBlank(message = "用户名称")
    private String userName;

    @ApiModelProperty(value = "用户英文名称")
    private String userNameEn;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "用户邮箱")
    private String userEmail;

    @ApiModelProperty(value = "用户头像")
    private String headImage;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

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
	private static class UserInfoConvert extends Converter<UserRequest, UserInfo> {

		@Override
		protected UserInfo doForward(UserRequest userInfoRequest) {
			UserInfo userInfo = new UserInfo();
			BeanUtils.copyProperties(userInfoRequest, userInfo);
			return userInfo;
		}

		@Override
		protected UserRequest doBackward(UserInfo b) {
			return null;
		}

	}

}