package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserAppPasswordVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAppPasswordId;

    private Integer userId;

    private String password;

    private Date lastPassTime;

    private Date createTime;

    private Date updateTime;

}