package com.cloud.provider.safe.rest.request;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.boot.BootRestRequest;
import com.cloud.provider.safe.po.Quality;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class QualityRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer qualityId;

    private String qualityName;

    private Integer isDelete;

    private String remark;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

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