package com.cloud.provider.safe.rest.request.post;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.PostAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "岗位附件id")
	@NotNull(message = "岗位附件id不能为空", groups = {ModifyGroup.class})
	private Integer postAttachmentId;

	@ApiModelProperty(value = "岗位id", required = true)
	@NotNull(message = "岗位id不能为空")
    private Integer postId;

    @ApiModelProperty(value = "附件url", required = true)
	@NotBlank(message = "附件url不能为空")
    private String attachmentUrl;

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