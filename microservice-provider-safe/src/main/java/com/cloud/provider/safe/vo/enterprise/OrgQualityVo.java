package com.cloud.provider.safe.vo.enterprise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.OrgQuality;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class OrgQualityVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer orgQualityId;

	private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private Integer attachmentId;

    private String attachmentUrl;

    private String qualityName;

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
     * @param enterpriseQuality
     * @return OrgQualityVo
     */
    public OrgQualityVo convertToOrgQualityVo(OrgQuality enterpriseQuality) {
    	OrgQualityVoConvert convert = new OrgQualityVoConvert();
    	return convert.doBackward(enterpriseQuality);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<OrgQualityVo>
     */
    public List<OrgQualityVo> convertToOrgQualityVoList(List<OrgQuality> list) {
    	OrgQualityVoConvert convert = new OrgQualityVoConvert();
    	List<OrgQualityVo> enterpriseQualityVoList = null;
    	OrgQualityVo enterpriseQualityVo = null;
    	if(list != null && !list.isEmpty()) {
    		enterpriseQualityVoList = new ArrayList<OrgQualityVo>(list.size());
    		ListIterator<OrgQuality> it = list.listIterator();
    		while(it.hasNext()) {
    			OrgQuality enterpriseQuality = it.next();
    			enterpriseQualityVo = convert.doBackward(enterpriseQuality);
    			enterpriseQualityVoList.add(enterpriseQualityVo);
    		}
    	}
    	return enterpriseQualityVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class OrgQualityVoConvert extends Converter<OrgQualityVo, OrgQuality> {

    	@Override
    	protected OrgQuality doForward(OrgQualityVo enterpriseQualityVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param enterpriseQuality
    	 * @return OrgQualityVo
    	 */
		@Override
		protected OrgQualityVo doBackward(OrgQuality enterpriseQuality) {
			OrgQualityVo enterpriseQualityVo = new OrgQualityVo();
			BeanUtils.copyProperties(enterpriseQuality, enterpriseQualityVo);
			enterpriseQualityVo.setOrgQualityId(enterpriseQuality.getId());
			return enterpriseQualityVo;
		}

    }

}