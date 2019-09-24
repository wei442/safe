package com.cloud.provider.safe.vo.activity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Rule;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class RuleVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer ruleId;

	private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private String ruleName;

    private String ruleNo;

    private String keyWord;

    private Integer ruleCategory;

    private Integer ruleType;

    private Integer publishOrgId;

    private String publishOrgName;

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
     * @param rule
     * @return RuleVo
     */
    public RuleVo convertToRuleVo(Rule rule) {
    	RuleVoConvert convert = new RuleVoConvert();
    	return convert.doBackward(rule);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<RuleVo>
     */
    public List<RuleVo> convertToRuleVoList(List<Rule> list) {
    	RuleVoConvert convert = new RuleVoConvert();
    	List<RuleVo> ruleVoList = null;
    	RuleVo ruleVo = null;
    	if(list != null && !list.isEmpty()) {
    		ruleVoList = new ArrayList<RuleVo>(list.size());
    		ListIterator<Rule> it = list.listIterator();
    		while(it.hasNext()) {
    			Rule rule = it.next();
    			ruleVo = convert.doBackward(rule);
    			ruleVoList.add(ruleVo);
    		}
    	}
    	return ruleVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class RuleVoConvert extends Converter<RuleVo, Rule> {

    	@Override
    	protected Rule doForward(RuleVo ruleVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param rule
    	 * @return RuleVo
    	 */
		@Override
		protected RuleVo doBackward(Rule rule) {
			RuleVo ruleVo = new RuleVo();
			BeanUtils.copyProperties(rule, ruleVo);
			ruleVo.setRuleId(rule.getId());
			return ruleVo;
		}

    }

}