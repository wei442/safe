package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserPostRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id", groups = {UpdateGroup.class})
	private Integer userPostId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id")
    private Integer userId;

	@ApiModelProperty(value = "岗位id", required = true)
    @NotNull(message = "岗位id")
    private Integer postId;

}