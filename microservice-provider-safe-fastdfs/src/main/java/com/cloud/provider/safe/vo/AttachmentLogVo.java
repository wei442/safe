package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.AttachmentLog;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class AttachmentLogVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long attachmentLogId;

    private Integer attachmentId;

    private String content;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
     * 实体转换
     * @param attachmentLog
     * @return AttachmentLogVo
     */
    public AttachmentLogVo convertToAttachmentLogVo(AttachmentLog attachmentLog) {
    	AttachmentLogVoConvert convert = new AttachmentLogVoConvert();
    	return convert.doBackward(attachmentLog);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<AttachmentLogVo>
     */
    public List<AttachmentLogVo> convertToAttachmentLogVoList(List<AttachmentLog> list) {
    	AttachmentLogVoConvert convert = new AttachmentLogVoConvert();
    	List<AttachmentLogVo> attachmentLogVoList = null;
    	AttachmentLogVo attachmentLogVo = null;
    	if(list != null && !list.isEmpty()) {
    		attachmentLogVoList = new ArrayList<AttachmentLogVo>(list.size());
    		ListIterator<AttachmentLog> it = list.listIterator();
    		while(it.hasNext()) {
    			AttachmentLog attachmentLog = it.next();
    			attachmentLogVo = convert.doBackward(attachmentLog);
    			attachmentLogVoList.add(attachmentLogVo);
    		}
    	}
    	return attachmentLogVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class AttachmentLogVoConvert extends Converter<AttachmentLogVo, AttachmentLog> {

    	@Override
    	protected AttachmentLog doForward(AttachmentLogVo attachmentLogVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param attachmentLog
    	 * @return AttachmentLogVo
    	 */
		@Override
		protected AttachmentLogVo doBackward(AttachmentLog attachmentLog) {
			AttachmentLogVo attachmentLogVo = new AttachmentLogVo();
			BeanUtils.copyProperties(attachmentLog, attachmentLogVo);
			attachmentLogVo.setAttachmentLogId(attachmentLog.getId());
			return attachmentLogVo;
		}

    }

}