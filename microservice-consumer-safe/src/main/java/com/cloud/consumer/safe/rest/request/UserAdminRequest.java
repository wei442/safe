package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
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
	@NotNull(message = "用户管理id", groups = {UpdateGroup.class})
	private Integer userAdminId;

	@ApiModelProperty(value = "企业id", required = true)
	@NotNull(message = "企业id")
    private Integer enterpriseId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id")
    private Integer userId;

	@ApiModelProperty(value = "管理名称")
	@NotBlank(message = "管理名称")
    private String adminName;

	@ApiModelProperty(value = "管理类型")
	@NotNull(message = "管理类型")
    private Integer adminType;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

}