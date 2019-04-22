package com.cloud.provider.safe.vo.risk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.RiskDuty;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class RiskDutyVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer riskDutyId;

    private Integer riskId;

    private Integer dutyUserId;

    private String dutyUserAccount;

    private String dutyUserName;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param riskDuty
     * @return RiskDutyVo
     */
    public RiskDutyVo convertToRiskDutyVo(RiskDuty riskDuty) {
    	RiskDutyVoConvert convert = new RiskDutyVoConvert();
    	return convert.doBackward(riskDuty);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<RiskDutyVo>
     */
    public List<RiskDutyVo> convertToRiskDutyVoList(List<RiskDuty> list) {
    	RiskDutyVoConvert convert = new RiskDutyVoConvert();
    	List<RiskDutyVo> riskDutyVoList = null;
    	RiskDutyVo riskDutyVo = null;
    	if(list != null && !list.isEmpty()) {
    		riskDutyVoList = new ArrayList<RiskDutyVo>(list.size());
    		ListIterator<RiskDuty> it = list.listIterator();
    		while(it.hasNext()) {
    			RiskDuty riskDuty = it.next();
    			riskDutyVo = convert.doBackward(riskDuty);
    			riskDutyVoList.add(riskDutyVo);
    		}
    	}
    	return riskDutyVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class RiskDutyVoConvert extends Converter<RiskDutyVo, RiskDuty> {

    	@Override
    	protected RiskDuty doForward(RiskDutyVo riskDutyVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param riskDuty
    	 * @return RiskDutyVo
    	 */
		@Override
		protected RiskDutyVo doBackward(RiskDuty riskDuty) {
			RiskDutyVo riskDutyVo = new RiskDutyVo();
			BeanUtils.copyProperties(riskDuty, riskDutyVo);
			riskDutyVo.setRiskDutyId(riskDuty.getId());
			return riskDutyVo;
		}

    }

}