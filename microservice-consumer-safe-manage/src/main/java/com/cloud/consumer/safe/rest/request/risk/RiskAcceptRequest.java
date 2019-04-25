package com.cloud.consumer.safe.rest.request.risk;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RiskAcceptRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空", groups = {UpdateGroup.class})
	private Integer riskAcceptId;

	@ApiModelProperty(value = "企业名称")
	@NotBlank(message = "企业名称不能为空")
    private String riskAcceptName;

	@ApiModelProperty(value = "企业类型")
    private Integer riskAcceptType;

	@ApiModelProperty(value = "企业性质")
    private Integer riskAcceptNature;

	@ApiModelProperty(value = "企业状态")
    private Integer riskAcceptStatus;

	@ApiModelProperty(value = "企业别名")
    private String riskAcceptAlias;

	@ApiModelProperty(value = "企业电话")
    private String riskAcceptTelphone;

	@ApiModelProperty(value = "企业级别")
    private Integer riskAcceptLevel;

	@ApiModelProperty(value = "企业传真")
    private String riskAcceptFax;

	@ApiModelProperty(value = "企业邮件")
    private String riskAcceptEmail;

	@ApiModelProperty(value = "企业邮编")
    private String riskAcceptPostCode;

	@ApiModelProperty(value = "企业地址")
    private String riskAcceptAddr;

	@ApiModelProperty(value = "企网网站")
    private String riskAcceptWebsite;

	@ApiModelProperty(value = "企业备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

}