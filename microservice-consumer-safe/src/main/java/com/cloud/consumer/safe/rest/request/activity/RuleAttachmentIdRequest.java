package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;

import lombok.Data;

@Data
public class RuleAttachmentIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer ruleAttachmentId;

}