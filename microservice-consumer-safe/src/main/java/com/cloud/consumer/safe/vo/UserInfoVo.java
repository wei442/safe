package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserInfoVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private String userAccount;

    private String userName;

    private String userNameEn;

    private String nickName;

    private Integer userType;

    private Integer gender;

    private Integer userStatus;

    private String userEmail;

    private String headImage;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;


}