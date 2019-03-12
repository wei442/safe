package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.QualityAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QualityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "岗位id")
	@NotNull(message = "岗位id", groups = {ModifyGroup.class})
	private Integer qualityAttachmentId;

    private Integer qualityId;

    private Integer attachmentId;

    private String attachmentUrl;

	@ApiModelProperty(value = "备注")
    private String remark;

    /**
	 * 实体转换
	 * @return QualityAttachment
	 */
	public QualityAttachment convertToQualityAttachment() {
		QualityAttachmentConvert convert = new QualityAttachmentConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class QualityAttachmentConvert extends Converter<QualityAttachmentRequest, QualityAttachment> {

		@Override
		protected QualityAttachment doForward(QualityAttachmentRequest qualityAttachmentRequest) {
			QualityAttachment qualityAttachment = new QualityAttachment();
			BeanUtils.copyProperties(qualityAttachmentRequest, qualityAttachment);
			return qualityAttachment;
		}

		@Override
		protected QualityAttachmentRequest doBackward(QualityAttachment b) {
			return null;
		}

	}

}