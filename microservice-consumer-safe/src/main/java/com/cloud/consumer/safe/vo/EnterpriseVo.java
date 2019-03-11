package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;

import com.cloud.consumer.safe.base.BaseResult;

import lombok.Data;

@Data
public class EnterpriseVo extends BaseResult implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseId;

    private String enterpriseName;

    private Integer enterpriseType;

    private Integer enterpriseNature;

    private Integer enterpriseStatus;

    private String enterpriseAlias;

    private String enterpriseTelphone;

    private Integer enterpriseLevel;

    private String enterpriseFax;

    private String enterpriseEmail;

    private String enterprisePostCode;

    private String enterpriseAddr;

    private String enterpriseWebsite;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

}