package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户账户", required = true)
	@NotBlank(message = "用户账户不能为空")
    private String userAccount;

    @ApiModelProperty(value = "用户名称", required = true)
	@NotBlank(message = "用户名称不能为空")
    private String userName;

    @ApiModelProperty(value = "用户英文名称")
    private String userNameEn;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "企业id", required = true)
    private Integer enterpriseId;

	@ApiModelProperty(value = "企业名称", required = true)
	@NotBlank(message = "企业名称")
    private String enterpriseName;

	@ApiModelProperty(value = "企业类型")
    private Integer enterpriseType;


}