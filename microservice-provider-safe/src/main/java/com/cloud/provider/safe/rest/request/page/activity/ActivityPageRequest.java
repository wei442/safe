package com.cloud.provider.safe.rest.request.page.activity;

import java.util.Date;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ActivityPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "企业id")
    private Integer enterpriseId;

	@ApiModelProperty(value = "机构id")
	private Integer orgId;

    @ApiModelProperty(value = "机构名称")
    private String orgName;

    @ApiModelProperty(value = "机构名称")
    private String activityName;

    @ApiModelProperty(value = "活动开始时间")
    private Date activityStartTime;

    @ApiModelProperty(value = "活动结束时间")
    private Date activityEndTime;

    @ApiModelProperty(value = "活动地点")
    private String activitySite;

    @ApiModelProperty(value = "活动内容")
    private String content;

    @ApiModelProperty(value = "活动经验")
    private String experience;

    @ApiModelProperty(value = "活动教训")
    private String lesson;

    @ApiModelProperty(value = "关键字")
    private String keyWord;

}