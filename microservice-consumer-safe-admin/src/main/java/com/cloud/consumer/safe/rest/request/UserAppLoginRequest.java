package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserAppLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户应用登录id", required = true)
    @NotNull(message = "用户应用登录id", groups = {UpdateGroup.class})
	private Integer userAppLoginId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id")
    private Integer userId;

	@ApiModelProperty(value = "登录次数")
    private Integer loginCount;

	@ApiModelProperty(value = "过期时间")
    private Date lastPassTime;

}