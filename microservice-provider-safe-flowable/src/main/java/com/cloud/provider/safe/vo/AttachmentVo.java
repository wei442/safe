package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Attachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class AttachmentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer attachmentId;

    private String attachmentUrl;

    private Integer attachmentType;

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
     * @param attachment
     * @return AttachmentVo
     */
    public AttachmentVo convertToAttachmentVo(Attachment attachment) {
    	AttachmentVoConvert convert = new AttachmentVoConvert();
    	return convert.doBackward(attachment);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<AttachmentVo>
     */
    public List<AttachmentVo> convertToAttachmentVoList(List<Attachment> list) {
    	AttachmentVoConvert convert = new AttachmentVoConvert();
    	List<AttachmentVo> attachmentVoList = null;
    	AttachmentVo attachmentVo = null;
    	if(list != null && !list.isEmpty()) {
    		attachmentVoList = new ArrayList<AttachmentVo>(list.size());
    		ListIterator<Attachment> it = list.listIterator();
    		while(it.hasNext()) {
    			Attachment attachment = it.next();
    			attachmentVo = convert.doBackward(attachment);
    			attachmentVoList.add(attachmentVo);
    		}
    	}
    	return attachmentVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class AttachmentVoConvert extends Converter<AttachmentVo, Attachment> {

    	@Override
    	protected Attachment doForward(AttachmentVo attachmentVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param attachment
    	 * @return AttachmentVo
    	 */
		@Override
		protected AttachmentVo doBackward(Attachment attachment) {
			AttachmentVo attachmentVo = new AttachmentVo();
			BeanUtils.copyProperties(attachment, attachmentVo);
			attachmentVo.setAttachmentId(attachment.getId());
			return attachmentVo;
		}

    }

}