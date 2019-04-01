package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.AttachmentLog;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AttachmentLogRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "附件id", required = true)
    @NotNull(message = "附件id不能为空", groups = {ModifyGroup.class})
	private Long attachmentLogId;

	@ApiModelProperty(value = "附件id", required = true)
    @NotNull(message = "附件id不能为空")
    private Integer attachmentId;

	@ApiModelProperty(value = "附件内容", required = true)
    @NotNull(message = "附件内容不能为空")
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