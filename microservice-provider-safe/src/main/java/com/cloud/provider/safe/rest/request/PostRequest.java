package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Post;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "岗位id")
	@NotNull(message = "岗位id", groups = {ModifyGroup.class})
	private Integer postId;

	@ApiModelProperty(value = "企业id")
	@NotNull(message = "企业id")
    private Integer enterpriseId;

	@ApiModelProperty(value = "岗位名称")
	@NotEmpty(message = "岗位名称")
    private String postName;

	@ApiModelProperty(value = "是否特殊岗位 0-否, 1-是")
    private Integer isSpecial;

	@ApiModelProperty(value = "特殊岗位备注")
    private String specialRemark;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

    /**
	 * 实体转换
	 * @return Post
	 */
	public Post convertToPost() {
		PostConvert convert = new PostConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class PostConvert extends Converter<PostRequest, Post> {

		@Override
		protected Post doForward(PostRequest postRequest) {
			Post post = new Post();
			BeanUtils.copyProperties(postRequest, post);
			return post;
		}

		@Override
		protected PostRequest doBackward(Post b) {
			return null;
		}

	}

}