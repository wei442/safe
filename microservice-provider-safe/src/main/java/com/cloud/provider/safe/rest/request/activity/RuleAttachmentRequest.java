package com.cloud.provider.safe.rest.request.activity;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.RuleAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class RuleAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer ruleAttachmentId;

    private Integer ruleId;

    private Long attachmentId;

    private String attachmentUrl;

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