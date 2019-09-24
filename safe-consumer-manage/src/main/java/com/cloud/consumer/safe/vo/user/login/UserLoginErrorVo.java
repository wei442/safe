package com.cloud.consumer.safe.vo.user.login;

import java.io.Serializable;

import lombok.Data;

/**
 *
 * 用户登录错误 Vo
 * @author wei.yong
 */
@Data
public class UserLoginErrorVo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseId;

	private Integer userId;

}