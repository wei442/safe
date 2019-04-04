package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;

import lombok.Data;

@Data
public class ActivityVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer activityId;

	private Integer orgId;

    private String orgName;

    private String activityName;

    private Date activityStartTime;

    private Date activityEndTime;

    private String activitySite;

    private String content;

    private String experience;

    private String lesson;

    private String keyWord;

    private Integer isDelete;

    private String remark;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

}