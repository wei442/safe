package com.cloud.provider.safe.vo.enterprise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Enterprise;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class EnterpriseVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseId;

    private String enterpriseName;

    private Integer enterpriseType;

    private Integer enterpriseNature;

    private Integer enterpriseStatus;

    private String enterpriseAlias;

    private String enterpriseTelphone;

    private Integer enterpriseLevel;

    private String enterpriseFax;

    private String enterpriseEmail;

    private String enterprisePostCode;

    private String enterpriseAddr;

    private String enterpriseWebsite;

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
     * @param enterprise
     * @return EnterpriseVo
     */
    public EnterpriseVo convertToEnterpriseVo(Enterprise enterprise) {
    	EnterpriseVoConvert convert = new EnterpriseVoConvert();
    	return convert.doBackward(enterprise);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<EnterpriseVo>
     */
    public List<EnterpriseVo> convertToEnterpriseVoList(List<Enterprise> list) {
    	EnterpriseVoConvert convert = new EnterpriseVoConvert();
    	List<EnterpriseVo> enterpriseVoList = null;
    	EnterpriseVo enterpriseVo = null;
    	if(list != null && !list.isEmpty()) {
    		enterpriseVoList = new ArrayList<EnterpriseVo>(list.size());
    		ListIterator<Enterprise> it = list.listIterator();
    		while(it.hasNext()) {
    			Enterprise enterprise = it.next();
    			enterpriseVo = convert.doBackward(enterprise);
    			enterpriseVoList.add(enterpriseVo);
    		}
    	}
    	return enterpriseVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class EnterpriseVoConvert extends Converter<EnterpriseVo, Enterprise> {

    	@Override
    	protected Enterprise doForward(EnterpriseVo enterpriseVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param enterprise
    	 * @return EnterpriseVo
    	 */
		@Override
		protected EnterpriseVo doBackward(Enterprise enterprise) {
			EnterpriseVo enterpriseVo = new EnterpriseVo();
			BeanUtils.copyProperties(enterprise, enterpriseVo);
			enterpriseVo.setEnterpriseId(enterprise.getId());
			return enterpriseVo;
		}

    }

}