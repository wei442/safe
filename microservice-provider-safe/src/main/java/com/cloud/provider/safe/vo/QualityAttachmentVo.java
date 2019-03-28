package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.QualityAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class QualityAttachmentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer qualityAttachmentId;

    private Integer qualityId;

    private Integer attachmentId;

    private String attachmentUrl;

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
     * @param qualityAttachment
     * @return QualityAttachmentVo
     */
    public QualityAttachmentVo convertToQualityAttachmentVo(QualityAttachment qualityAttachment) {
    	QualityAttachmentVoConvert convert = new QualityAttachmentVoConvert();
    	return convert.doBackward(qualityAttachment);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<QualityAttachmentVo>
     */
    public List<QualityAttachmentVo> convertToQualityAttachmentVoList(List<QualityAttachment> list) {
    	QualityAttachmentVoConvert convert = new QualityAttachmentVoConvert();
    	List<QualityAttachmentVo> qualityAttachmentVoList = null;
    	QualityAttachmentVo qualityAttachmentVo = null;
    	if(list != null && !list.isEmpty()) {
    		qualityAttachmentVoList = new ArrayList<QualityAttachmentVo>(list.size());
    		ListIterator<QualityAttachment> it = list.listIterator();
    		while(it.hasNext()) {
    			QualityAttachment qualityAttachment = it.next();
    			qualityAttachmentVo = convert.doBackward(qualityAttachment);
    			qualityAttachmentVoList.add(qualityAttachmentVo);
    		}
    	}
    	return qualityAttachmentVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class QualityAttachmentVoConvert extends Converter<QualityAttachmentVo, QualityAttachment> {

    	@Override
    	protected QualityAttachment doForward(QualityAttachmentVo qualityAttachmentVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param qualityAttachment
    	 * @return QualityAttachmentVo
    	 */
		@Override
		protected QualityAttachmentVo doBackward(QualityAttachment qualityAttachment) {
			QualityAttachmentVo qualityAttachmentVo = new QualityAttachmentVo();
			BeanUtils.copyProperties(qualityAttachment, qualityAttachmentVo);
			qualityAttachmentVo.setQualityAttachmentId(qualityAttachment.getId());
			return qualityAttachmentVo;
		}

    }

}