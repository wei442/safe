package com.cloud.consumer.safe.vo.risk;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;

import lombok.Data;

@Data
public class RiskVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer riskId;

    private Integer enterpriseId;

    private String riskCode;

    private String riskWorkPlace;

    private String riskCategory;

    private String riskReason;

    private String riskLevel;

    private String controlReason;

    private String controlMethod;

    private Integer riskStatus;

    private Integer isDanger;

    private String frequency;

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