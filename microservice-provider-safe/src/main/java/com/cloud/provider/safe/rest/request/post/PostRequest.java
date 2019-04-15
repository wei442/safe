package com.cloud.provider.safe.rest.request.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Post;
import com.cloud.provider.safe.po.PostAttachment;
import com.cloud.provider.safe.validator.FlagValidator;
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
	@NotNull(message = "岗位id不能为空", groups = {ModifyGroup.class})
	private Integer postId;

	@ApiModelProperty(value = "企业id")
	@NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "岗位名称")
	@NotBlank(message = "岗位名称不能为空")
    private String postName;

	@ApiModelProperty(value = "是否特殊岗位 0-否, 1-是")
	@FlagValidator(value = { "0", "1" }, message = "是否特殊岗位不正确")
    private Integer isSpecial;

	@ApiModelProperty(value = "特殊岗位备注")
    private String specialRemark;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "岗位附件列表")
    private List<PostAttachmentRequest> postAttachmentList;

    /**
	 * 实体转换
	 * @return Post
	 */
	public Post convertToPost() {
		PostConvert convert = new PostConvert();
		return convert.doForward(this);
	}

    /**
     * 实体列表转换
     * @return List<PostAttachment>
     */
    public List<PostAttachment> convertToPostAttachmentList() {
    	PostAttachmentConvert convert = new PostAttachmentConvert();
    	List<PostAttachment> postAttachmentListNew = null;
    	if(postAttachmentList != null && !postAttachmentList.isEmpty()) {
    		postAttachmentListNew = new ArrayList<PostAttachment>(postAttachmentList.size());
    		ListIterator<PostAttachmentRequest> it = postAttachmentList.listIterator();
    		while(it.hasNext()) {
    			PostAttachmentRequest postAttachmentRequest = it.next();
    			postAttachmentListNew.add(convert.doForward(postAttachmentRequest));
    		}
    	}
    	return postAttachmentListNew;
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