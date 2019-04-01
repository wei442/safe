package com.cloud.consumer.safe.rest.request;

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

	@ApiModelProperty(value = "用户机构id", required = true)
    @NotNull(message = "用户机构id不能为空", groups = {UpdateGroup.class})
	private Integer userOrgId;

	private Integer enterpriseId;

//	@ApiModelProperty(value = "用户id", required = true)
//    @NotNull(message = "用户id不能为空")
//    private Integer userId;

	@ApiModelProperty(value = "机构id", required = true)
    @NotNull(message = "机构id不能为空")
    private Integer orgId;

	@ApiModelProperty(value = "手机号码", required = true)
	@NotBlank(message = "手机号码不能为空")
    private String userAccount;

    @ApiModelProperty(value = "用户名称", required = true)
	@NotBlank(message = "用户名称不能为空")
    private String userName;

}