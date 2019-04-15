package com.cloud.provider.safe.vo.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.ActivityAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class ActivityAttachmentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer activityAttachmentId;

	private Integer activityId;

    private String name;

    private String url;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param activityAttachment
     * @return ActivityAttachmentVo
     */
    public ActivityAttachmentVo convertToActivityAttachmentVo(ActivityAttachment activityAttachment) {
    	ActivityAttachmentVoConvert convert = new ActivityAttachmentVoConvert();
    	return convert.doBackward(activityAttachment);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<ActivityAttachmentVo>
     */
    public List<ActivityAttachmentVo> convertToActivityAttachmentVoList(List<ActivityAttachment> list) {
    	ActivityAttachmentVoConvert convert = new ActivityAttachmentVoConvert();
    	List<ActivityAttachmentVo> activityAttachmentVoList = null;
    	ActivityAttachmentVo activityAttachmentVo = null;
    	if(list != null && !list.isEmpty()) {
    		activityAttachmentVoList = new ArrayList<ActivityAttachmentVo>(list.size());
    		ListIterator<ActivityAttachment> it = list.listIterator();
    		while(it.hasNext()) {
    			ActivityAttachment activityAttachment = it.next();
    			activityAttachmentVo = convert.doBackward(activityAttachment);
    			activityAttachmentVoList.add(activityAttachmentVo);
    		}
    	}
    	return activityAttachmentVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class ActivityAttachmentVoConvert extends Converter<ActivityAttachmentVo, ActivityAttachment> {

    	@Override
    	protected ActivityAttachment doForward(ActivityAttachmentVo activityAttachmentVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param activityAttachment
    	 * @return ActivityAttachmentVo
    	 */
		@Override
		protected ActivityAttachmentVo doBackward(ActivityAttachment activityAttachment) {
			ActivityAttachmentVo activityAttachmentVo = new ActivityAttachmentVo();
			BeanUtils.copyProperties(activityAttachment, activityAttachmentVo);
			activityAttachmentVo.setActivityAttachmentId(activityAttachment.getId());
			return activityAttachmentVo;
		}

    }

}