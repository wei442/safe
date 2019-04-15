package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserTitleRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户职务id")
    @NotNull(message = "用户职务id不能为空", groups = {UpdateGroup.class})
	private Integer userTitleId;

	private Integer enterpriseId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "职务id")
    @NotNull(message = "职务id不能为空")
	private Integer titleId;

}