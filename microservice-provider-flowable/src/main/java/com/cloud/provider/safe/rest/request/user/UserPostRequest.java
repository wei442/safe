package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserPost;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserPostRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空", groups = {ModifyGroup.class})
	private Integer userPostId;

	@ApiModelProperty(value = "企业id", required = true)
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "岗位id", required = true)
    @NotNull(message = "岗位id不能为空")
    private Integer postId;

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