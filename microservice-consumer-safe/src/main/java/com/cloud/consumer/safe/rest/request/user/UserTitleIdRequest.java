package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserTitleIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户职务id", required = true)
    @NotNull(message = "用户职务id不能为空")
	private Integer userTitleId;

}