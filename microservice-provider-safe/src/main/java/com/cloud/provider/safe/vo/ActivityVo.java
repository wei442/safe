package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Activity;
import com.google.common.base.Converter;

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

    /**
     * 实体转换
     * @param activity
     * @return ActivityVo
     */
    public ActivityVo convertToActivityVo(Activity activity) {
    	ActivityVoConvert convert = new ActivityVoConvert();
    	return convert.doBackward(activity);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<ActivityVo>
     */
    public List<ActivityVo> convertToActivityVoList(List<Activity> list) {
    	ActivityVoConvert convert = new ActivityVoConvert();
    	List<ActivityVo> activityVoList = null;
    	ActivityVo activityVo = null;
    	if(list != null && !list.isEmpty()) {
    		activityVoList = new ArrayList<ActivityVo>(list.size());
    		ListIterator<Activity> it = list.listIterator();
    		while(it.hasNext()) {
    			Activity activity = it.next();
    			activityVo = convert.doBackward(activity);
    			activityVoList.add(activityVo);
    		}
    	}
    	return activityVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class ActivityVoConvert extends Converter<ActivityVo, Activity> {

    	@Override
    	protected Activity doForward(ActivityVo activityVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param activity
    	 * @return ActivityVo
    	 */
		@Override
		protected ActivityVo doBackward(Activity activity) {
			ActivityVo activityVo = new ActivityVo();
			BeanUtils.copyProperties(activity, activityVo);
			activityVo.setActivityId(activity.getId());
			return activityVo;
		}

    }

}