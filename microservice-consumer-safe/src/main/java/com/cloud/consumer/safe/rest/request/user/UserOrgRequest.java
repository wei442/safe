package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserOrgRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户机构id")
    @NotNull(message = "用户机构id不能为空", groups = {UpdateGroup.class})
	private Integer userOrgId;

	private Integer enterpriseId;

	@ApiModelProperty(value = "机构id")
    @NotNull(message = "机构id不能为空")
    private Integer orgId;

	@ApiModelProperty(value = "工号")
	private String employeeNo;

	@ApiModelProperty(value = "排序号")
    private Integer sort;

	@ApiModelProperty(value = "手机号码")
	@NotBlank(message = "手机号码不能为空")
    private String userAccount;

    @ApiModelProperty(value = "用户名称")
	@NotBlank(message = "用户名称不能为空")
    private String userName;

}