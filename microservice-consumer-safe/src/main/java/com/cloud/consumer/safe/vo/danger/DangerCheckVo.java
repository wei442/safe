package com.cloud.consumer.safe.vo.danger;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;

import lombok.Data;

@Data
public class DangerCheckVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dangerCheckId;

    private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private Integer dangerId;

    private String title;

    private Date checkTime;

    private Integer checkUserId;

    private String checkUserAccount;

    private String checkUserName;

    private Integer isDelete;

    private String remark;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

}