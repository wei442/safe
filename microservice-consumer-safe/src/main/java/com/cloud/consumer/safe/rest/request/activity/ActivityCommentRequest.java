package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ActivityCommentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer activityCommentId;

	private Integer activityId;

    private String comments;

    private Integer score;

    private Integer views;

}