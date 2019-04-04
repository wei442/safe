package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

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

    private String remark;

}