package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseUserLoginLogVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long baseUserLoginLogId;

    private Integer baseUserId;

    private String baseUserAccount;

    private String baseUserName;

    private String baseUserNameEn;

    private Integer loginType;

    private Date loginTime;

    private String loginIp;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}