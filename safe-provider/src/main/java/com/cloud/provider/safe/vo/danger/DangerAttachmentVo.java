package com.cloud.provider.safe.vo.danger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.DangerAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class DangerAttachmentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dangerAttachmentId;

    private Integer dangerId;

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
     * @param dangerAttachment
     * @return DangerAttachmentVo
     */
    public DangerAttachmentVo convertToDangerAttachmentVo(DangerAttachment dangerAttachment) {
    	DangerAttachmentVoConvert convert = new DangerAttachmentVoConvert();
    	return convert.doBackward(dangerAttachment);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<DangerAttachmentVo>
     */
    public List<DangerAttachmentVo> convertToDangerAttachmentVoList(List<DangerAttachment> list) {
    	DangerAttachmentVoConvert convert = new DangerAttachmentVoConvert();
    	List<DangerAttachmentVo> dangerAttachmentVoList = null;
    	DangerAttachmentVo dangerAttachmentVo = null;
    	if(list != null && !list.isEmpty()) {
    		dangerAttachmentVoList = new ArrayList<DangerAttachmentVo>(list.size());
    		ListIterator<DangerAttachment> it = list.listIterator();
    		while(it.hasNext()) {
    			DangerAttachment dangerAttachment = it.next();
    			dangerAttachmentVo = convert.doBackward(dangerAttachment);
    			dangerAttachmentVoList.add(dangerAttachmentVo);
    		}
    	}
    	return dangerAttachmentVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class DangerAttachmentVoConvert extends Converter<DangerAttachmentVo, DangerAttachment> {

    	@Override
    	protected DangerAttachment doForward(DangerAttachmentVo dangerAttachmentVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param dangerAttachment
    	 * @return DangerAttachmentVo
    	 */
		@Override
		protected DangerAttachmentVo doBackward(DangerAttachment dangerAttachment) {
			DangerAttachmentVo dangerAttachmentVo = new DangerAttachmentVo();
			BeanUtils.copyProperties(dangerAttachment, dangerAttachmentVo);
			dangerAttachmentVo.setDangerAttachmentId(dangerAttachment.getId());
			return dangerAttachmentVo;
		}

    }

}