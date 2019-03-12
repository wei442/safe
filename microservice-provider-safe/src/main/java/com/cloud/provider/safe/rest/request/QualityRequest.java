package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

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

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id", groups = {ModifyGroup.class})
	private Integer qualityId;

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