package com.cloud.provider.safe.rest.request.page.activity;

import com.cloud.provider.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RuleAttachmentPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    private Integer ruleId;

    private String attachmentUrl;

}