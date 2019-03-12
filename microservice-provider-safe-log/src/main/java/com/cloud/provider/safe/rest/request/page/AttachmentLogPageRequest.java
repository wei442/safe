package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import com.cloud.provider.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AttachmentLogPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long attachmentLogId;

    private Integer attachmentId;

    private String content;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}