package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.QualityAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class QualityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer qualityAttachmentId;

    private Integer qualityId;

    private Integer attachmentId;

    private Integer isDelete;

    private String remark;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

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