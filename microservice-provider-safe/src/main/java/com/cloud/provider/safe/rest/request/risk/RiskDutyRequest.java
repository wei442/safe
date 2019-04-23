package com.cloud.provider.safe.rest.request.risk;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.RiskDuty;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RiskDutyRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空", groups = {ModifyGroup.class})
	private Integer riskDutyId;

	@ApiModelProperty(value = "企业名称")
	@NotBlank(message = "企业名称不能为空")
    private String riskDutyName;

	@ApiModelProperty(value = "企业类型")
    private Integer riskDutyType;

	@ApiModelProperty(value = "企业性质")
    private Integer riskDutyNature;

	@ApiModelProperty(value = "企业状态")
    private Integer riskDutyStatus;

	@ApiModelProperty(value = "企业别名")
    private String riskDutyAlias;

	@ApiModelProperty(value = "企业电话")
    private String riskDutyTelphone;

	@ApiModelProperty(value = "企业级别")
    private Integer riskDutyLevel;

	@ApiModelProperty(value = "企业传真")
    private String riskDutyFax;

	@ApiModelProperty(value = "企业邮件")
    private String riskDutyEmail;

	@ApiModelProperty(value = "企业邮编")
    private String riskDutyPostCode;

	@ApiModelProperty(value = "企业地址")
    private String riskDutyAddr;

	@ApiModelProperty(value = "企网网站")
    private String riskDutyWebsite;

	@ApiModelProperty(value = "企业备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

    /**
	 * 实体转换
	 * @return RiskDuty
	 */
	public RiskDuty convertToRiskDuty() {
		RiskDutyConvert convert = new RiskDutyConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class RiskDutyConvert extends Converter<RiskDutyRequest, RiskDuty> {

		@Override
		protected RiskDuty doForward(RiskDutyRequest riskDutyRequest) {
			RiskDuty riskDuty = new RiskDuty();
			BeanUtils.copyProperties(riskDutyRequest, riskDuty);
			return riskDuty;
		}

		@Override
		protected RiskDutyRequest doBackward(RiskDuty b) {
			return null;
		}

	}

}