package com.cloud.provider.safe.vo.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.RuleAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class RuleAttachmentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer ruleAttachmentId;

    private Integer ruleId;

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
     * @param ruleAttachment
     * @return RuleAttachmentVo
     */
    public RuleAttachmentVo convertToRuleAttachmentVo(RuleAttachment ruleAttachment) {
    	RuleAttachmentVoConvert convert = new RuleAttachmentVoConvert();
    	return convert.doBackward(ruleAttachment);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<RuleAttachmentVo>
     */
    public List<RuleAttachmentVo> convertToRuleAttachmentVoList(List<RuleAttachment> list) {
    	RuleAttachmentVoConvert convert = new RuleAttachmentVoConvert();
    	List<RuleAttachmentVo> ruleAttachmentVoList = null;
    	RuleAttachmentVo ruleAttachmentVo = null;
    	if(list != null && !list.isEmpty()) {
    		ruleAttachmentVoList = new ArrayList<RuleAttachmentVo>(list.size());
    		ListIterator<RuleAttachment> it = list.listIterator();
    		while(it.hasNext()) {
    			RuleAttachment ruleAttachment = it.next();
    			ruleAttachmentVo = convert.doBackward(ruleAttachment);
    			ruleAttachmentVoList.add(ruleAttachmentVo);
    		}
    	}
    	return ruleAttachmentVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class RuleAttachmentVoConvert extends Converter<RuleAttachmentVo, RuleAttachment> {

    	@Override
    	protected RuleAttachment doForward(RuleAttachmentVo ruleAttachmentVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param ruleAttachment
    	 * @return RuleAttachmentVo
    	 */
		@Override
		protected RuleAttachmentVo doBackward(RuleAttachment ruleAttachment) {
			RuleAttachmentVo ruleAttachmentVo = new RuleAttachmentVo();
			BeanUtils.copyProperties(ruleAttachment, ruleAttachmentVo);
			ruleAttachmentVo.setRuleAttachmentId(ruleAttachment.getId());
			return ruleAttachmentVo;
		}

    }

}