package com.cloud.consumer.safe.vo.user;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * 用户登录 Vo
 * @author wei.yong
 */
@Data
public class UserLoginVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


	private Integer enterpriseId;

	private Integer userId;

	private String userAccount;

	private String userName;

	private String token;

}