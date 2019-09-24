package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserTitleListRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "职务id")
    @NotNull(message = "职务id不能为空")
    private Integer titleId;

	@ApiModelProperty(value = "用户列表")
	@NotEmpty(message = "用户列表不能为空")
	private List<UserInfoIdRequest> userList;

	private List<UserTitleRequest> userTitleList;

}