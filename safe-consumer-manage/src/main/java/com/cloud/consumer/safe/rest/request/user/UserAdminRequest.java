package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAdminRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户管理id")
	@NotNull(message = "用户管理id不能为空", groups = {UpdateGroup.class})
	private Integer userAdminId;

    private Integer enterpriseId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "管理名称")
    private String adminName;

	@ApiModelProperty(value = "管理类型")
    private Integer adminType;

	private String UserMenus;

//	@ApiModelProperty(value = "用户菜单列表")
//	@NotEmpty(message = "用户菜单列表不能为空")
	private List<UserMenuRequest> userMenuList;

}