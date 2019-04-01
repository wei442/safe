package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Quality;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "资质id", required = true)
    @NotNull(message = "资质id不能为空", groups = {ModifyGroup.class})
	private Integer qualityId;

	@ApiModelProperty(value = "企业id", required = true)
	@NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "资质名称")
	@NotBlank(message = "资质名称不能为空")
    private String qualityName;

	@ApiModelProperty(value = "备注")
    private String remark;

    /**
	 * 实体转换
	 * @return Quality
	 */
	public Quality convertToQuality() {
		QualityConvert convert = new QualityConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class QualityConvert extends Converter<QualityRequest, Quality> {

		@Override
		protected Quality doForward(QualityRequest qualityRequest) {
			Quality quality = new Quality();
			BeanUtils.copyProperties(qualityRequest, quality);
			return quality;
		}

		@Override
		protected QualityRequest doBackward(Quality b) {
			return null;
		}

	}

}