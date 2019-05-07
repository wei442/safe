package com.cloud.provider.safe.vo.risk;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.RiskAccept;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class RiskAcceptVo implements Serializable {

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

	private Integer riskAcceptId;

    private String effect;

    private Integer acceptUserId;

    private String acceptUserAccount;

    private String acceptUserName;

    private Date acceptTime;

    private Integer count;

    /**
     * 实体转换
     * @param riskAccept
     * @return RiskAcceptVo
     */
    public RiskAcceptVo convertToRiskAcceptVo(RiskAccept riskAccept) {
    	RiskAcceptVoConvert convert = new RiskAcceptVoConvert();
    	return convert.doBackward(riskAccept);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<RiskAcceptVo>
     */
    public List<RiskAcceptVo> convertToRiskAcceptVoList(List<RiskAccept> list) {
    	RiskAcceptVoConvert convert = new RiskAcceptVoConvert();
    	List<RiskAcceptVo> riskAcceptVoList = null;
    	RiskAcceptVo riskAcceptVo = null;
    	if(list != null && !list.isEmpty()) {
    		riskAcceptVoList = new ArrayList<RiskAcceptVo>(list.size());
    		ListIterator<RiskAccept> it = list.listIterator();
    		while(it.hasNext()) {
    			RiskAccept riskAccept = it.next();
    			riskAcceptVo = convert.doBackward(riskAccept);
    			riskAcceptVoList.add(riskAcceptVo);
    		}
    	}
    	return riskAcceptVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class RiskAcceptVoConvert extends Converter<RiskAcceptVo, RiskAccept> {

    	@Override
    	protected RiskAccept doForward(RiskAcceptVo riskAcceptVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param riskAccept
    	 * @return RiskAcceptVo
    	 */
		@Override
		protected RiskAcceptVo doBackward(RiskAccept riskAccept) {
			RiskAcceptVo riskAcceptVo = new RiskAcceptVo();
			BeanUtils.copyProperties(riskAccept, riskAcceptVo);
			riskAcceptVo.setRiskAcceptId(riskAccept.getId());
			return riskAcceptVo;
		}

    }

}