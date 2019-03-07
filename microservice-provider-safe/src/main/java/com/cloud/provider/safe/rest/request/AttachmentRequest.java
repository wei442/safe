package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Attachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class AttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer attachmentId;

    private String attachmentUrl;

    private Integer attachmentType;

    private Integer isDelete;

    private String remark;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

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