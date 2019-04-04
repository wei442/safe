package com.cloud.consumer.safe.vo.user;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;

import lombok.Data;

@Data
public class UserInfoOrgVo implements Serializable {

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

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    private Integer userOrgId;


}