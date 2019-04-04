package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Activity;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ActivityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer activityId;

	@ApiModelProperty(value = "企业id", required = true)
    @NotNull(message = "企业id不能为空")
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

    private Integer isDelete;

    private String remark;

    /**
	 * 实体转换
	 * @return Activity
	 */
	public Activity convertToActivity() {
		ActivityConvert convert = new ActivityConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class ActivityConvert extends Converter<ActivityRequest, Activity> {

		@Override
		protected Activity doForward(ActivityRequest activityRequest) {
			Activity activity = new Activity();
			BeanUtils.copyProperties(activityRequest, activity);
			return activity;
		}

		@Override
		protected ActivityRequest doBackward(Activity b) {
			return null;
		}

	}

}