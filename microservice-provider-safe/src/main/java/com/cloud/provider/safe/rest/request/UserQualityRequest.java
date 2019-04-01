package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserQuality;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户资质id", required = true)
    @NotNull(message = "用户资质id不能为空", groups = {ModifyGroup.class})
	private Integer userQualityId;

	@ApiModelProperty(value = "企业id", required = true)
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "资质id", required = true)
    @NotNull(message = "资质id不能为空")
    private Integer qualityId;

	@ApiModelProperty(value = "备注")
    private String remark;

    /**
	 * 实体转换
	 * @return UserQuality
	 */
	public UserQuality convertToUserQuality() {
		UserQualityConvert convert = new UserQualityConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserQualityConvert extends Converter<UserQualityRequest, UserQuality> {

		@Override
		protected UserQuality doForward(UserQualityRequest userQualityRequest) {
			UserQuality userQuality = new UserQuality();
			BeanUtils.copyProperties(userQualityRequest, userQuality);
			return userQuality;
		}

		@Override
		protected UserQualityRequest doBackward(UserQuality b) {
			return null;
		}

	}

}