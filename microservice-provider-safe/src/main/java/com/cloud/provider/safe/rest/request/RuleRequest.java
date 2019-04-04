package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Rule;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class RuleRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer ruleId;

	private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private String ruleName;

    private String ruleNo;

    private String keyWord;

    private Integer ruleCategory;

    private Integer ruleType;

    private Integer isDelete;

    private String remark;

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