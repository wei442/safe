package com.cloud.provider.safe.vo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.UserQualityAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserQualityAttachmentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userQualityAttachmentId;

	private Integer userQualityId;

    private String attachmentUrl;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param userQualityAttachment
     * @return UserQualityAttachment
     */
    public UserQualityAttachmentVo convertToUserQualityAttachment(UserQualityAttachment userQualityAttachment) {
    	UserQualityAttachmentConvert convert = new UserQualityAttachmentConvert();
    	return convert.doBackward(userQualityAttachment);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserQualityAttachment>
     */
    public List<UserQualityAttachmentVo> convertToUserQualityAttachmentList(List<UserQualityAttachment> list) {
    	UserQualityAttachmentConvert convert = new UserQualityAttachmentConvert();
    	List<UserQualityAttachmentVo> userQualityAttachmentVoList = null;
    	UserQualityAttachmentVo userQualityAttachmentVo = null;
    	if(list != null && !list.isEmpty()) {
    		userQualityAttachmentVoList = new ArrayList<UserQualityAttachmentVo>(list.size());
    		ListIterator<UserQualityAttachment> it = list.listIterator();
    		while(it.hasNext()) {
    			UserQualityAttachment userQualityAttachment = it.next();
    			userQualityAttachmentVo = convert.doBackward(userQualityAttachment);
    			userQualityAttachmentVoList.add(userQualityAttachmentVo);
    		}
    	}
    	return userQualityAttachmentVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserQualityAttachmentConvert extends Converter<UserQualityAttachmentVo, UserQualityAttachment> {

    	@Override
    	protected UserQualityAttachment doForward(UserQualityAttachmentVo userQualityAttachmentVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userQualityAttachment
    	 * @return UserQualityAttachment
    	 */
		@Override
		protected UserQualityAttachmentVo doBackward(UserQualityAttachment userQualityAttachment) {
			UserQualityAttachmentVo userQualityAttachmentVo = new UserQualityAttachmentVo();
			BeanUtils.copyProperties(userQualityAttachment, userQualityAttachmentVo);
			userQualityAttachmentVo.setUserQualityAttachmentId(userQualityAttachment.getId());
			return userQualityAttachmentVo;
		}

    }

}