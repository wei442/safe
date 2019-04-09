package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserQualityAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserQualityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户资质附件id", required = true)
    @NotNull(message = "用户资质附件id不能为空", groups = {ModifyGroup.class})
	private Integer userQualityAttachmentId;

	@ApiModelProperty(value = "用户资质id", required = true)
    @NotNull(message = "用户资质id不能为空")
	private Integer userQualityId;

	@ApiModelProperty(value = "附件url", required = true)
    @NotNull(message = "附件url不能为空")
    private String attachmentUrl;

	/**
	 * 实体转换
	 * @return UserQualityAttachment
	 */
	public UserQualityAttachment convertToUserQualityAttachment() {
		UserQualityAttachmentConvert convert = new UserQualityAttachmentConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserQualityAttachmentConvert extends Converter<UserQualityAttachmentRequest, UserQualityAttachment> {

		@Override
		protected UserQualityAttachment doForward(UserQualityAttachmentRequest userQualityAttachmentRequest) {
			UserQualityAttachment userQualityAttachment = new UserQualityAttachment();
			BeanUtils.copyProperties(userQualityAttachmentRequest, userQualityAttachment);
			return userQualityAttachment;
		}

		@Override
		protected UserQualityAttachmentRequest doBackward(UserQualityAttachment b) {
			return null;
		}

	}

}