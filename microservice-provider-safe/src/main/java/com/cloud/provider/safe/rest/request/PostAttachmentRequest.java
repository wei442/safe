package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.PostAttachment;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer postAttachmentId;

    private Integer postId;

    private Integer attachmentId;

	@ApiModelProperty(value = "备注")
    private String remark;

    /**
	 * 实体转换
	 * @return PostAttachment
	 */
	public PostAttachment convertToPostAttachment() {
		PostAttachmentConvert convert = new PostAttachmentConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class PostAttachmentConvert extends Converter<PostAttachmentRequest, PostAttachment> {

		@Override
		protected PostAttachment doForward(PostAttachmentRequest postAttachmentRequest) {
			PostAttachment postAttachment = new PostAttachment();
			BeanUtils.copyProperties(postAttachmentRequest, postAttachment);
			return postAttachment;
		}

		@Override
		protected PostAttachmentRequest doBackward(PostAttachment b) {
			return null;
		}

	}

}