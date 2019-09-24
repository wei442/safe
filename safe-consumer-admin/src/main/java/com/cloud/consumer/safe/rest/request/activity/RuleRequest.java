package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RuleRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "规范id")
	@NotNull(message = "规范id不能为空", groups = {UpdateGroup.class})
	private Integer ruleId;

	@ApiModelProperty(value = "企业id")
    private Integer enterpriseId;

	@ApiModelProperty(value = "机构id")
	@NotNull(message = "机构id不能为空")
	private Integer orgId;

    @ApiModelProperty(value = "机构名称")
    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    @ApiModelProperty(value = "名称")
    @NotBlank(message = "名称不能为空")
    private String ruleName;

    @ApiModelProperty(value = "法规标号")
    @NotBlank(message = "法规标号不能为空")
    private String ruleNo;

    @ApiModelProperty(value = "关键字")
    @NotNull(message = "关键字不能为空")
    private String keyWord;

    @ApiModelProperty(value = "规范类别")
    @NotNull(message = "规范类别不能为空")
    private Integer ruleCategory;

    @ApiModelProperty(value = "规范类型")
    @NotNull(message = "规范类型不能为空")
    private Integer ruleType;

    @ApiModelProperty(value = "发布部门id")
    private Integer publishOrgId;

    @ApiModelProperty(value = "发布部门名称")
    private String publishOrgName;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "规范附件ids")
    private List<Integer> ruleAttachmentIds;

    @ApiModelProperty(value = "新规范文件附件列表")
    private List<RuleAttachmentRequest> ruleAttachmentList;

}