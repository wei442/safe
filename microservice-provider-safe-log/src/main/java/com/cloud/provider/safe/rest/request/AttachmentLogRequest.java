package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.AttachmentLog;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class AttachmentLogRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long attachmentLogId;

    private Integer attachmentId;

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