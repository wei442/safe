package com.cloud.provider.safe.rest.request.risk;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RiskCheckIdsRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "风险排查ids")
	@NotEmpty(message = "风险排查ids不能为空")
    private List<Integer> riskCheckIds;

}