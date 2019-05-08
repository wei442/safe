package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserTitleIdsRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户职务ids")
	@NotEmpty(message = "用户职务ids不能为空")
	private List<Integer> userTitleIds;

}