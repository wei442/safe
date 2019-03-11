package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class BaseUserLoginRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserLoginId;

    private Integer baseUserId;

    private Integer loginCount;

    private Date lastPassTime;

}