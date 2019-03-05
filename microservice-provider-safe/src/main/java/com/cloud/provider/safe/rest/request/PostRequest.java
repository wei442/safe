package com.cloud.provider.safe.rest.request;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.boot.BootRestRequest;
import com.cloud.provider.safe.po.Post;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PostRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer postId;

    private Integer enterpriseId;

    private String postName;

    private Integer isSpecial;

    private String specialRemark;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

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