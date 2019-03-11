package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class UserAdminVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminId;

    private Integer enterpriseId;

    private Integer userId;

    private String adminName;

    private Integer adminType;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}