package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
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
	@NotNull(message = "岗位id不能为空", groups = {ModifyGroup.class})
	private Integer qualityAttachmentId;

	@ApiModelProperty(value = "资质id", required = true)
    @NotNull(message = "资质id不能为空")
    private Integer qualityId;

	@ApiModelProperty(value = "附件id", required = true)
    @NotNull(message = "附件id不能为空")
    private Integer attachmentId;

	@ApiModelProperty(value = "附件url", required = true)
	@NotBlank(message = "附件url不能为空")
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