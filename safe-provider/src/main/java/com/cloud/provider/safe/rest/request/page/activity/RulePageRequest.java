package com.cloud.provider.safe.rest.request.page.activity;

import javax.validation.constraints.NotNull;

import com.cloud.provider.safe.base.BaseRestRequest;

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

	@ApiModelProperty(value = "机构id")
	private Integer orgId;

    @ApiModelProperty(value = "机构名称")
    private String orgName;

    @ApiModelProperty(value = "名称")
    private String ruleName;

    @ApiModelProperty(value = "法规标号")
    private String ruleNo;

    @ApiModelProperty(value = "关键字")
    private String keyWord;

    @ApiModelProperty(value = "规范类别")
    private Integer ruleCategory;

    @ApiModelProperty(value = "规范类型")
    private Integer ruleType;

    @ApiModelProperty(value = "发布部门id")
    private Integer publishOrgId;

    @ApiModelProperty(value = "发布部门名称")
    private String publishOrgName;

    @ApiModelProperty(value = "备注")
    private String remark;

}