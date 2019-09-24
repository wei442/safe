package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.cloud.provider.safe.po.UserTitle;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserTitleListRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户职务列表")
	@NotEmpty(message = "用户职务列表不能为空")
    private List<UserTitle> userTitleList;

}