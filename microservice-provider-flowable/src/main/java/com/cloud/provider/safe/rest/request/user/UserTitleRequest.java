package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserTitle;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserTitleRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户职务id", required = true)
    @NotNull(message = "用户职务id不能为空", groups = {ModifyGroup.class})
	private Integer userTitleId;

	@ApiModelProperty(value = "企业id", required = true)
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "职务id", required = true)
    @NotNull(message = "职务id不能为空")
	private Integer titleId;

    /**
	 * 实体转换
	 * @return UserTitle
	 */
	public UserTitle convertToUserTitle() {
		UserTitleConvert convert = new UserTitleConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserTitleConvert extends Converter<UserTitleRequest, UserTitle> {

		@Override
		protected UserTitle doForward(UserTitleRequest userTitleRequest) {
			UserTitle userTitle = new UserTitle();
			BeanUtils.copyProperties(userTitleRequest, userTitle);
			return userTitle;
		}

		@Override
		protected UserTitleRequest doBackward(UserTitle b) {
			return null;
		}

	}

}