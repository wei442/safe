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
     * @param orgQuality
     * @return OrgQualityVo
     */
    public OrgQualityVo convertToOrgQualityVo(OrgQuality orgQuality) {
    	OrgQualityVoConvert convert = new OrgQualityVoConvert();
    	return convert.doBackward(orgQuality);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<OrgQualityVo>
     */
    public List<OrgQualityVo> convertToOrgQualityVoList(List<OrgQuality> list) {
    	OrgQualityVoConvert convert = new OrgQualityVoConvert();
    	List<OrgQualityVo> orgQualityVoList = null;
    	OrgQualityVo orgQualityVo = null;
    	if(list != null && !list.isEmpty()) {
    		orgQualityVoList = new ArrayList<OrgQualityVo>(list.size());
    		ListIterator<OrgQuality> it = list.listIterator();
    		while(it.hasNext()) {
    			OrgQuality orgQuality = it.next();
    			orgQualityVo = convert.doBackward(orgQuality);
    			orgQualityVoList.add(orgQualityVo);
    		}
    	}
    	return orgQualityVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class OrgQualityVoConvert extends Converter<OrgQualityVo, OrgQuality> {

    	@Override
    	protected OrgQuality doForward(OrgQualityVo orgQualityVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param orgQuality
    	 * @return OrgQualityVo
    	 */
		@Override
		protected OrgQualityVo doBackward(OrgQuality orgQuality) {
			OrgQualityVo orgQualityVo = new OrgQualityVo();
			BeanUtils.copyProperties(orgQuality, orgQualityVo);
			orgQualityVo.setOrgQualityId(orgQuality.getId());
			return orgQualityVo;
		}

    }

}