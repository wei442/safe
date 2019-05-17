package com.cloud.queue.safe.vo;

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

    private String userAccount;

    private String userName;

    private Integer loginType;

    private Date loginTime;

    private String loginMode;

    private String loginIp;

}