package com.cloud.provider.safe.vo.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.ActivityComment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class ActivityCommentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer activityCommentId;

	private Integer activityId;

    private String comments;

    private Integer score;

    private Integer views;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param activityComment
     * @return ActivityCommentVo
     */
    public ActivityCommentVo convertToActivityCommentVo(ActivityComment activityComment) {
    	ActivityCommentVoConvert convert = new ActivityCommentVoConvert();
    	return convert.doBackward(activityComment);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<ActivityCommentVo>
     */
    public List<ActivityCommentVo> convertToActivityCommentVoList(List<ActivityComment> list) {
    	ActivityCommentVoConvert convert = new ActivityCommentVoConvert();
    	List<ActivityCommentVo> activityCommentVoList = null;
    	ActivityCommentVo activityCommentVo = null;
    	if(list != null && !list.isEmpty()) {
    		activityCommentVoList = new ArrayList<ActivityCommentVo>(list.size());
    		ListIterator<ActivityComment> it = list.listIterator();
    		while(it.hasNext()) {
    			ActivityComment activityComment = it.next();
    			activityCommentVo = convert.doBackward(activityComment);
    			activityCommentVoList.add(activityCommentVo);
    		}
    	}
    	return activityCommentVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class ActivityCommentVoConvert extends Converter<ActivityCommentVo, ActivityComment> {

    	@Override
    	protected ActivityComment doForward(ActivityCommentVo activityCommentVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param activityComment
    	 * @return ActivityCommentVo
    	 */
		@Override
		protected ActivityCommentVo doBackward(ActivityComment activityComment) {
			ActivityCommentVo activityCommentVo = new ActivityCommentVo();
			BeanUtils.copyProperties(activityComment, activityCommentVo);
			activityCommentVo.setActivityCommentId(activityComment.getId());
			return activityCommentVo;
		}

    }

}