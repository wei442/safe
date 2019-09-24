package com.cloud.consumer.safe.rest.request.danger;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DangerCheckIdsRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "隐患排查ids")
	@NotEmpty(message = "隐患排查ids不能为空")
    private List<Integer> dangerCheckIds;

}