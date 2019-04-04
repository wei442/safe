package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ActivityAttachmentIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer activityAttachmentId;

	private Integer activityId;

    private Integer attachmentId;

    private String attachmentUrl;

}