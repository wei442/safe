package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Attachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "附件id", required = true)
    @NotNull(message = "附件id不能为空", groups = {ModifyGroup.class})
	private Integer attachmentId;

	@ApiModelProperty(value = "附件url", required = true)
	@NotBlank(message = "附件url不能为空")
    private String attachmentUrl;

	@ApiModelProperty(value = "附件类型", required = true)
    @NotNull(message = "附件类型不能为空")
    private Integer attachmentType;

	@ApiModelProperty(value = "备注")
    private String remark;

    /**
	 * 实体转换
	 * @return Attachment
	 */
	public Attachment convertToAttachment() {
		AttachmentConvert convert = new AttachmentConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class AttachmentConvert extends Converter<AttachmentRequest, Attachment> {

		@Override
		protected Attachment doForward(AttachmentRequest attachmentRequest) {
			Attachment attachment = new Attachment();
			BeanUtils.copyProperties(attachmentRequest, attachment);
			return attachment;
		}

		@Override
		protected AttachmentRequest doBackward(Attachment b) {
			return null;
		}

	}

}