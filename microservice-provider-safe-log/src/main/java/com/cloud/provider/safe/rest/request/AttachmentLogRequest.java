package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.AttachmentLog;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttachmentLogRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "附件名称")
	@NotBlank(message = "附件id不能为空")
	private String attachmentName;

	@ApiModelProperty(value = "附件rul")
	@NotBlank(message = "附件url不能为空")
    private String attachmentUrl;

	@ApiModelProperty(value = "附件类型")
	@NotNull(message = "附件类型不能为空")
    private Integer attachmentType;

	@ApiModelProperty(value = "附件内容")
    private String content;

    /**
	 * 实体转换
	 * @return AttachmentLog
	 */
	public AttachmentLog convertToAttachmentLog() {
		AttachmentLogConvert convert = new AttachmentLogConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class AttachmentLogConvert extends Converter<AttachmentLogRequest, AttachmentLog> {

		@Override
		protected AttachmentLog doForward(AttachmentLogRequest attachmentLogRequest) {
			AttachmentLog attachmentLog = new AttachmentLog();
			BeanUtils.copyProperties(attachmentLogRequest, attachmentLog);
			return attachmentLog;
		}

		@Override
		protected AttachmentLogRequest doBackward(AttachmentLog b) {
			return null;
		}

	}

}