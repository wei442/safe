package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.Attachment;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AttachmentPageRequest extends BaseRestRequest {

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
	private static class AttachmentConvert extends Converter<AttachmentPageRequest, Attachment> {

		@Override
		protected Attachment doForward(AttachmentPageRequest attachmentRequest) {
			Attachment attachment = new Attachment();
			BeanUtils.copyProperties(attachmentRequest, attachment);
			return attachment;
		}

		@Override
		protected AttachmentPageRequest doBackward(Attachment b) {
			return null;
		}

	}

}