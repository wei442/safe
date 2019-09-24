package com.cloud.consumer.safe.rest.request.activity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "活动id")
	@NotNull(message = "活动id不能为空", groups = {UpdateGroup.class})
	private Integer activityId;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "机构id")
	@NotNull(message = "机构id不能为空")
	private Integer orgId;

    @ApiModelProperty(value = "机构名称")
    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    @ApiModelProperty(value = "活动名称")
    @NotBlank(message = "活动名称不能为空")
    private String activityName;

    @ApiModelProperty(value = "活动开始时间")
	@NotNull(message = "活动开始时间不能为空")
    private Date activityStartTime;

    @ApiModelProperty(value = "活动结束时间")
	@NotNull(message = "活动结束时间不能为空")
    private Date activityEndTime;

    @ApiModelProperty(value = "活动地点")
    @NotBlank(message = "活动地点不能为空")
    private String activitySite;

    @ApiModelProperty(value = "活动内容")
    @NotBlank(message = "活动内容不能为空")
    private String content;

    @ApiModelProperty(value = "活动经验")
    @NotBlank(message = "活动经验不能为空")
    private String experience;

    @ApiModelProperty(value = "活动教训")
    @NotBlank(message = "活动教训不能为空")
    private String lesson;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "活动附件ids")
    private List<Integer> activityAttachmentIds;

    @ApiModelProperty(value = "新活动附件列表")
    private List<ActivityAttachmentRequest> activityAttachmentList;

}