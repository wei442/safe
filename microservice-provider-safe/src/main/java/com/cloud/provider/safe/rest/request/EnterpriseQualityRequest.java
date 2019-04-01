package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.EnterpriseQuality;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EnterpriseQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空", groups = {ModifyGroup.class})
	private Integer enterpriseQualityId;

	@ApiModelProperty(value = "企业id", required = true)
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "附件id", required = true)
    @NotNull(message = "附件id不能为空")
    private Integer qualityId;

	@ApiModelProperty(value = "备注")
    private String remark;

    /**
	 * 实体转换
	 * @return EnterpriseQuality
	 */
	public EnterpriseQuality convertToEnterpriseQuality() {
		EnterpriseQualityConvert convert = new EnterpriseQualityConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class EnterpriseQualityConvert extends Converter<EnterpriseQualityRequest, EnterpriseQuality> {

		@Override
		protected EnterpriseQuality doForward(EnterpriseQualityRequest enterpriseQualityRequest) {
			EnterpriseQuality enterpriseQuality = new EnterpriseQuality();
			BeanUtils.copyProperties(enterpriseQualityRequest, enterpriseQuality);
			return enterpriseQuality;
		}

		@Override
		protected EnterpriseQualityRequest doBackward(EnterpriseQuality b) {
			return null;
		}

	}

}