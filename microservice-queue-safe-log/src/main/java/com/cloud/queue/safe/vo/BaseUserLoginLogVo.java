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

	private Integer baseUserId;

    private String baseUserAccount;

    private String baseUserName;

    private String baseUserNameEn;

    private Integer loginType;

    private Date loginTime;

    private String loginMode;

    private String loginIp;

}