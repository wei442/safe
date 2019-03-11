package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class PostVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer postId;

    private Integer enterpriseId;

    private String postName;

    private Integer isSpecial;

    private String specialRemark;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}