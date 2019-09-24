package com.cloud.provider.safe.rest.request.post;

import java.io.Serializable;

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

	@ApiModelProperty(value = "岗位id")
	@NotNull(message = "岗位id不能为空")
    private Integer postId;

	@ApiModelProperty(value = "附件名称")
    @NotNull(message = "附件名称不能为空")
    private String name;

    @ApiModelProperty(value = "附件url")
    @NotNull(message = "附件url不能为空")
    private String url;

    @ApiModelProperty(value = "创建人")
    private String created;

    @ApiModelProperty(value = "修改人")
    private String updated;

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