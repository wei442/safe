package com.cloud.provider.safe.vo.risk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Risk;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class RiskVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer riskId;

    private Integer enterpriseId;

    private String riskCode;

    private String riskWorkPlace;

    private String riskCategory;

    private String riskReason;

    private String riskLevel;

    private String controlReason;

    private String controlMethod;

    private Integer riskStatus;

    private Integer isDanger;

    private String frequency;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param risk
     * @return RiskVo
     */
    public RiskVo convertToRiskVo(Risk risk) {
    	RiskVoConvert convert = new RiskVoConvert();
    	return convert.doBackward(risk);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<RiskVo>
     */
    public List<RiskVo> convertToRiskVoList(List<Risk> list) {
    	RiskVoConvert convert = new RiskVoConvert();
    	List<RiskVo> riskVoList = null;
    	RiskVo riskVo = null;
    	if(list != null && !list.isEmpty()) {
    		riskVoList = new ArrayList<RiskVo>(list.size());
    		ListIterator<Risk> it = list.listIterator();
    		while(it.hasNext()) {
    			Risk risk = it.next();
    			riskVo = convert.doBackward(risk);
    			riskVoList.add(riskVo);
    		}
    	}
    	return riskVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class RiskVoConvert extends Converter<RiskVo, Risk> {

    	@Override
    	protected Risk doForward(RiskVo riskVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param risk
    	 * @return RiskVo
    	 */
		@Override
		protected RiskVo doBackward(Risk risk) {
			RiskVo riskVo = new RiskVo();
			BeanUtils.copyProperties(risk, riskVo);
			riskVo.setRiskId(risk.getId());
			return riskVo;
		}

    }
}