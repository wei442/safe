package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class AttachmentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer attachmentId;

    private String attachmentUrl;

    private Integer attachmentType;

    private Integer isDelete;

    private String remark;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}