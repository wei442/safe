package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserMenu;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserMenuRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户菜单id")
    @NotNull(message = "用户菜单id不能为空", groups = {ModifyGroup.class})
	private Integer userMenuId;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "菜单编码")
    @NotNull(message = "菜单编码不能为空")
	private Integer menuCode;

	@ApiModelProperty(value = "菜单编码列表")
	@NotEmpty(message = "菜单编码列表不能为空")
    private List<Integer> menuCodeList;

    /**
	 * 实体转换
	 * @return UserMenu
	 */
	public UserMenu convertToUserMenu() {
		UserMenuConvert convert = new UserMenuConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserMenuConvert extends Converter<UserMenuRequest, UserMenu> {

		@Override
		protected UserMenu doForward(UserMenuRequest userMenuRequest) {
			UserMenu userMenu = new UserMenu();
			BeanUtils.copyProperties(userMenuRequest, userMenu);
			return userMenu;
		}

		@Override
		protected UserMenuRequest doBackward(UserMenu b) {
			return null;
		}

	}

}