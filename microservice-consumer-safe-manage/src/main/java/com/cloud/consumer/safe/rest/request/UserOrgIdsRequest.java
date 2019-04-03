package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserOrgIdsRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户机构ids", required = true)
	@NotEmpty(message = "用户机构ids不能为空")
	private List<Integer> userOrgIds;

}