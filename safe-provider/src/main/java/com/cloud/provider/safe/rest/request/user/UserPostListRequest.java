package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.cloud.provider.safe.po.UserPost;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserPostListRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户岗位列表")
	@NotEmpty(message = "用户岗位列表不能为空")
    private List<UserPost> userPostList;

}