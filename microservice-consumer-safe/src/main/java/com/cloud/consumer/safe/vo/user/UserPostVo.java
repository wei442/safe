package com.cloud.consumer.safe.vo.user;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;

import lombok.Data;

@Data
public class UserPostVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userPostId;

	private Integer enterpriseId;

    private Integer userId;

    private Integer postId;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    private String userName;

    private Integer orgId;

    private String orgName;

}