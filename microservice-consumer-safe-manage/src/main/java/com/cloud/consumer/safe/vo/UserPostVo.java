package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserPostVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userPostId;

    private Integer userId;

    private Integer postId;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}