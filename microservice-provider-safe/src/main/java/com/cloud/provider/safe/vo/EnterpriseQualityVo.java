package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.EnterpriseQuality;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class EnterpriseQualityVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseQualityId;

    private Integer enterpriseId;

    private Integer qualityId;

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
     * @return EnterpriseQualityVo
     */
    public EnterpriseQualityVo convertToEnterpriseQualityVo(EnterpriseQuality enterpriseQuality) {
    	EnterpriseQualityVoConvert convert = new EnterpriseQualityVoConvert();
    	return convert.doBackward(enterpriseQuality);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<EnterpriseQualityVo>
     */
    public List<EnterpriseQualityVo> convertToEnterpriseQualityVoList(List<EnterpriseQuality> list) {
    	EnterpriseQualityVoConvert convert = new EnterpriseQualityVoConvert();
    	List<EnterpriseQualityVo> enterpriseQualityVoList = null;
    	EnterpriseQualityVo enterpriseQualityVo = null;
    	if(list != null && !list.isEmpty()) {
    		enterpriseQualityVoList = new ArrayList<EnterpriseQualityVo>(list.size());
    		ListIterator<EnterpriseQuality> it = list.listIterator();
    		while(it.hasNext()) {
    			EnterpriseQuality enterpriseQuality = it.next();
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
    private class EnterpriseQualityVoConvert extends Converter<EnterpriseQualityVo, EnterpriseQuality> {

    	@Override
    	protected EnterpriseQuality doForward(EnterpriseQualityVo enterpriseQualityVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param enterpriseQuality
    	 * @return EnterpriseQualityVo
    	 */
		@Override
		protected EnterpriseQualityVo doBackward(EnterpriseQuality enterpriseQuality) {
			EnterpriseQualityVo enterpriseQualityVo = new EnterpriseQualityVo();
			BeanUtils.copyProperties(enterpriseQuality, enterpriseQualityVo);
			enterpriseQualityVo.setEnterpriseQualityId(enterpriseQuality.getId());
			return enterpriseQualityVo;
		}

    }

}