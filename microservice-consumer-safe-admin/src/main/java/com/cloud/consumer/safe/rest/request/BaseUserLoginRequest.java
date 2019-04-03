package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseUserLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "基础用户登录id", required = true)
    @NotNull(message = "基础用户登录id不能为空", groups = {UpdateGroup.class})
	private Integer baseUserLoginId;

	@ApiModelProperty(value = "基础用户id", required = true)
    @NotNull(message = "基础用户id不能为空")
    private Integer baseUserId;

	@ApiModelProperty(value = "登录次数")
    private Integer loginCount;

	@ApiModelProperty(value = "过期时间")
    private Date lastPassTime;

}