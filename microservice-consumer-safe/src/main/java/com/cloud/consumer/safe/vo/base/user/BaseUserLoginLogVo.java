package com.cloud.consumer.safe.vo.base.user;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;

import lombok.Data;

@Data
public class BaseUserLoginLogVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long baseUserLoginLogId;

    private Integer baseUserId;

    private String baseUserAccount;

    private String baseUserName;

    private String baseUserNameEn;

    private Integer loginType;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date loginTime;

    private String loginIp;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;
}