package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserAppLoginVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer Id;

    private Integer userId;

    private Integer firstLogin;

    private Integer loginCount;

    private Date lastPassTime;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}