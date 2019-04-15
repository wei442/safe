package com.cloud.consumer.safe.rest.request.page.activity;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RulePageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private String ruleName;

    private String ruleNo;

    private String keyWord;

    private Integer ruleCategory;

    private Integer ruleType;

}