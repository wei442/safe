package com.cloud.queue.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserAdminLoginLogVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userAdminLoginLogId;

	private Integer userId;

    private String userAccount;

    private String userName;

    private Integer loginType;

    private Date loginTime;

    private Integer logType;

    private String loginMode;

    private String loginIp;

}