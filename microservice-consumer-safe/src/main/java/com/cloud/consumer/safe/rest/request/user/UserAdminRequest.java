package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;

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

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

}