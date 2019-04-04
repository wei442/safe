package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ActivityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer activityId;

    private Integer enterpriseId;

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

    private String remark;

}