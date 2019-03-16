package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EnterpriseRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id", required = true)
    @NotNull(message = "企业id", groups = {UpdateGroup.class})
	private Integer enterpriseId;

	@ApiModelProperty(value = "企业名称", required = true)
	@NotBlank(message = "企业名称")
    private String enterpriseName;

	@ApiModelProperty(value = "企业类型")
    private Integer enterpriseType;

	@ApiModelProperty(value = "企业性质")
    private Integer enterpriseNature;

	@ApiModelProperty(value = "企业状态")
    private Integer enterpriseStatus;

	@ApiModelProperty(value = "企业别名")
    private String enterpriseAlias;

	@ApiModelProperty(value = "企业电话")
    private String enterpriseTelphone;

	@ApiModelProperty(value = "企业级别")
    private Integer enterpriseLevel;

	@ApiModelProperty(value = "企业传真")
    private String enterpriseFax;

	@ApiModelProperty(value = "企业邮件")
    private String enterpriseEmail;

	@ApiModelProperty(value = "企业邮编")
    private String enterprisePostCode;

	@ApiModelProperty(value = "企业地址")
    private String enterpriseAddr;

	@ApiModelProperty(value = "企网网站")
    private String enterpriseWebsite;

	@ApiModelProperty(value = "企业备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

}