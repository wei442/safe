package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseUserLoginVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserLoginId;

    private Integer baseUserId;

    private Integer loginCount;

    private Date lastPassTime;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}