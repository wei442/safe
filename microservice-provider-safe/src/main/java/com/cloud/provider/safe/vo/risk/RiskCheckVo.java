package com.cloud.provider.safe.vo.risk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.RiskCheck;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class RiskCheckVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer riskCheckId;

	private Integer riskId;

    private String effect;

    private Integer checkUserId;

    private String checkUserAccount;

    private String checkUserName;

    private Date checkTime;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param riskCheck
     * @return RiskCheckVo
     */
    public RiskCheckVo convertToRiskCheckVo(RiskCheck riskCheck) {
    	RiskCheckVoConvert convert = new RiskCheckVoConvert();
    	return convert.doBackward(riskCheck);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<RiskCheckVo>
     */
    public List<RiskCheckVo> convertToRiskCheckVoList(List<RiskCheck> list) {
    	RiskCheckVoConvert convert = new RiskCheckVoConvert();
    	List<RiskCheckVo> riskCheckVoList = null;
    	RiskCheckVo riskCheckVo = null;
    	if(list != null && !list.isEmpty()) {
    		riskCheckVoList = new ArrayList<RiskCheckVo>(list.size());
    		ListIterator<RiskCheck> it = list.listIterator();
    		while(it.hasNext()) {
    			RiskCheck riskCheck = it.next();
    			riskCheckVo = convert.doBackward(riskCheck);
    			riskCheckVoList.add(riskCheckVo);
    		}
    	}
    	return riskCheckVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class RiskCheckVoConvert extends Converter<RiskCheckVo, RiskCheck> {

    	@Override
    	protected RiskCheck doForward(RiskCheckVo riskCheckVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param riskCheck
    	 * @return RiskCheckVo
    	 */
		@Override
		protected RiskCheckVo doBackward(RiskCheck riskCheck) {
			RiskCheckVo riskCheckVo = new RiskCheckVo();
			BeanUtils.copyProperties(riskCheck, riskCheckVo);
			riskCheckVo.setRiskCheckId(riskCheck.getId());
			return riskCheckVo;
		}

    }

}