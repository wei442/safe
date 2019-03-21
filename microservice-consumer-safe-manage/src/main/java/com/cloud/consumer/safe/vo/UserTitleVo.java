package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserTitleVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userTitleId;

	private Integer enterpriseId;

    private Integer userId;

    private Integer titleId;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;


}