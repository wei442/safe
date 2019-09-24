package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserMenuRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户菜单id")
    @NotNull(message = "用户菜单id不能为空", groups = {UpdateGroup.class})
	private Integer userMenuId;

	private Integer enterpriseId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "菜单编码")
    @NotNull(message = "菜单编码不能为空")
	private Integer menuCode;


}