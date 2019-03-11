package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserAppLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAppLoginId;

    private Integer userId;

    private Integer firstLogin;

    private Integer loginCount;

    private Date lastPassTime;

}