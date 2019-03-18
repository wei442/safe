package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseUserPasswordVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserPasswordId;

    private Integer baseUserId;

    private String password;

    private Date createTime;

    private Date updateTime;

}