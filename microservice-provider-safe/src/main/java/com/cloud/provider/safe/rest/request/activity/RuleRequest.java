package com.cloud.provider.safe.rest.request.activity;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Rule;
import com.cloud.provider.safe.po.RuleAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RuleRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "规范id")
	@NotNull(message = "规范id不能为空", groups = {ModifyGroup.class})
	private Integer ruleId;

	@ApiModelProperty(value = "企业id")
	@NotNull(message = "企业id不能为空")
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
    @NotBlank(message = "关键字不能为空")
    private String keyWord;

    @ApiModelProperty(value = "规范类别")
    @NotNull(message = "规范类别不能为空")
    private Integer ruleCategory;

    @ApiModelProperty(value = "规范类型")
    @NotNull(message = "规范类型不能为空")
    private Integer ruleType;

    @ApiModelProperty(value = "发布部门id")
    @NotNull(message = "发布部门id不能为空")
    private Integer publishOrgId;

    @ApiModelProperty(value = "发布部门名称")
    @NotBlank(message = "发布部门名称不能为空")
    private String publishOrgName;

    @ApiModelProperty(value = "备注")
    private String remark;

    private List<RuleAttachment> ruleAttachments;

    /**
	 * 实体转换
	 * @return Rule
	 */
	public Rule convertToRule() {
		RuleConvert convert = new RuleConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class RuleConvert extends Converter<RuleRequest, Rule> {

		@Override
		protected Rule doForward(RuleRequest ruleRequest) {
			Rule rule = new Rule();
			BeanUtils.copyProperties(ruleRequest, rule);
			return rule;
		}

		@Override
		protected RuleRequest doBackward(Rule b) {
			return null;
		}

	}

}