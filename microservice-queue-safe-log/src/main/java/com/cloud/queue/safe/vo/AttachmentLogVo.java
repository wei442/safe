package com.cloud.queue.safe.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class AttachmentLogVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String attachmentName;

    private String attachmentUrl;

    private Integer attachmentType;

    private String content;

}