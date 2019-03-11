package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import lombok.Data;

@Data
public class QualityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer qualityAttachmentId;

    private Integer qualityId;

    private Integer attachmentId;

    private String remark;

}