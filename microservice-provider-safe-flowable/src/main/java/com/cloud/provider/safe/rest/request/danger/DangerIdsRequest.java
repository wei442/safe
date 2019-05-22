package com.cloud.provider.safe.rest.request.danger;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DangerIdsRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "隐患ids")
	@NotEmpty(message = "隐患ids不能为空")
    private List<Integer> dangerIds;

}