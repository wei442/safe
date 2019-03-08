package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.EnterpriseQuality;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class EnterpriseQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseQualityId;

    private Integer enterpriseId;

    private Integer qualityId;

    private Integer isDelete;

    private String remark;

    private String created;

    private String updated;

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