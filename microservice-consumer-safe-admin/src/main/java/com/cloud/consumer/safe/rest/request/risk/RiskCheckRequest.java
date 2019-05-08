package com.cloud.consumer.safe.rest.request.risk;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RiskCheckRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空", groups = {UpdateGroup.class})
	private Integer riskCheckId;

	@ApiModelProperty(value = "企业名称")
	@NotBlank(message = "企业名称不能为空")
    private String riskCheckName;

	@ApiModelProperty(value = "企业类型")
    private Integer riskCheckType;

	@ApiModelProperty(value = "企业性质")
    private Integer riskCheckNature;

	@ApiModelProperty(value = "企业状态")
    private Integer riskCheckStatus;

	@ApiModelProperty(value = "企业别名")
    private String riskCheckAlias;

	@ApiModelProperty(value = "企业电话")
    private String riskCheckTelphone;

	@ApiModelProperty(value = "企业级别")
    private Integer riskCheckLevel;

	@ApiModelProperty(value = "企业传真")
    private String riskCheckFax;

	@ApiModelProperty(value = "企业邮件")
    private String riskCheckEmail;

	@ApiModelProperty(value = "企业邮编")
    private String riskCheckPostCode;

	@ApiModelProperty(value = "企业地址")
    private String riskCheckAddr;

	@ApiModelProperty(value = "企网网站")
    private String riskCheckWebsite;

	@ApiModelProperty(value = "企业备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

}