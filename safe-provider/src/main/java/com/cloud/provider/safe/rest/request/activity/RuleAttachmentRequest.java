package com.cloud.provider.safe.rest.request.activity;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.RuleAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class RuleAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "规范文件附件id")
	@NotNull(message = "规范文件附件id不能为空", groups = {ModifyGroup.class})
	private Integer ruleAttachmentId;

	@ApiModelProperty(value = "规范文件id")
    @NotNull(message = "规范文件id不能为空")
    private Integer ruleId;

	@ApiModelProperty(value = "附件名称")
    @NotNull(message = "附件名称不能为空")
    private String name;

    @ApiModelProperty(value = "附件url")
    @NotNull(message = "附件url不能为空")
    private String url;

    /**
	 * 实体转换
	 * @return RuleAttachment
	 */
	public RuleAttachment convertToRuleAttachment() {
		RuleAttachmentConvert convert = new RuleAttachmentConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class RuleAttachmentConvert extends Converter<RuleAttachmentRequest, RuleAttachment> {

		@Override
		protected RuleAttachment doForward(RuleAttachmentRequest ruleAttachmentRequest) {
			RuleAttachment ruleAttachment = new RuleAttachment();
			BeanUtils.copyProperties(ruleAttachmentRequest, ruleAttachment);
			return ruleAttachment;
		}

		@Override
		protected RuleAttachmentRequest doBackward(RuleAttachment b) {
			return null;
		}

	}

}