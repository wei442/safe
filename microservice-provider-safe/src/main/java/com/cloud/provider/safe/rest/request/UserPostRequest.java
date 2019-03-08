package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserPost;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserPostRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userPostId;

    private Integer userId;

    private Integer postId;

    private String created;

    private String updated;

    /**
	 * 实体转换
	 * @return UserPost
	 */
	public UserPost convertToUserPost() {
		UserPostConvert convert = new UserPostConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserPostConvert extends Converter<UserPostRequest, UserPost> {

		@Override
		protected UserPost doForward(UserPostRequest userPostRequest) {
			UserPost userPost = new UserPost();
			BeanUtils.copyProperties(userPostRequest, userPost);
			return userPost;
		}

		@Override
		protected UserPostRequest doBackward(UserPost b) {
			return null;
		}

	}

}