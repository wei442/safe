package com.cloud.consumer.safe.vo.danger;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;

import lombok.Data;

@Data
public class DangerVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dangerId;

	private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private String dangerSite;

    private Integer dangerLevel;

    private String dangerCategory;

    private String dangerSubCategory;

    private Date dangerTime;

    private String dangerDesc;

    private Integer dangerUserId;

    private String dangerUserAccount;

    private String dangerUserName;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

}