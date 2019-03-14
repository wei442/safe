package com.cloud.consumer.safe.vo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OrgUserVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer orgId;

	private Integer enterpriseId;

    private Integer parentOrgId;

    private String parentOrgName;

    private String orgName;

    private String orgAlias;

    private String orgTelphone;

    private Integer orgStatus;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    private Integer count;

    private List<UserInfoVo> userList;

}