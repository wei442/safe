package com.cloud.provider.safe.vo.enterprise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.OrgQualityAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class OrgQualityAttachmentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer orgQualityAttachmentId;

	private Integer orgQualityId;

    private String attachmentUrl;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param orgQualityAttachment
     * @return OrgQualityAttachmentVo
     */
    public OrgQualityAttachmentVo convertToOrgQualityAttachmentVo(OrgQualityAttachment orgQualityAttachment) {
    	OrgQualityAttachmentVoConvert convert = new OrgQualityAttachmentVoConvert();
    	return convert.doBackward(orgQualityAttachment);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<OrgQualityAttachmentVo>
     */
    public List<OrgQualityAttachmentVo> convertToOrgQualityAttachmentVoList(List<OrgQualityAttachment> list) {
    	OrgQualityAttachmentVoConvert convert = new OrgQualityAttachmentVoConvert();
    	List<OrgQualityAttachmentVo> orgQualityAttachmentVoList = null;
    	OrgQualityAttachmentVo orgQualityAttachmentVo = null;
    	if(list != null && !list.isEmpty()) {
    		orgQualityAttachmentVoList = new ArrayList<OrgQualityAttachmentVo>(list.size());
    		ListIterator<OrgQualityAttachment> it = list.listIterator();
    		while(it.hasNext()) {
    			OrgQualityAttachment orgQualityAttachment = it.next();
    			orgQualityAttachmentVo = convert.doBackward(orgQualityAttachment);
    			orgQualityAttachmentVoList.add(orgQualityAttachmentVo);
    		}
    	}
    	return orgQualityAttachmentVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class OrgQualityAttachmentVoConvert extends Converter<OrgQualityAttachmentVo, OrgQualityAttachment> {

    	@Override
    	protected OrgQualityAttachment doForward(OrgQualityAttachmentVo orgQualityAttachmentVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param orgQualityAttachment
    	 * @return OrgQualityAttachmentVo
    	 */
		@Override
		protected OrgQualityAttachmentVo doBackward(OrgQualityAttachment orgQualityAttachment) {
			OrgQualityAttachmentVo orgQualityAttachmentVo = new OrgQualityAttachmentVo();
			BeanUtils.copyProperties(orgQualityAttachment, orgQualityAttachmentVo);
			orgQualityAttachmentVo.setOrgQualityAttachmentId(orgQualityAttachment.getId());
			return orgQualityAttachmentVo;
		}

    }

}