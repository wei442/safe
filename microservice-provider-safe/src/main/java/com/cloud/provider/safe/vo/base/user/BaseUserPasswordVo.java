package com.cloud.provider.safe.vo.base.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.BaseUserPassword;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class BaseUserPasswordVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserPasswordId;

    private Integer baseUserId;

    private String password;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date lastPassTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param baseUserPassword
     * @return BaseUserPasswordVo
     */
    public BaseUserPasswordVo convertToBaseUserPasswordVo(BaseUserPassword baseUserPassword) {
    	BaseUserPasswordVoConvert convert = new BaseUserPasswordVoConvert();
    	return convert.doBackward(baseUserPassword);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<BaseUserPasswordVo>
     */
    public List<BaseUserPasswordVo> convertToBaseUserPasswordVoList(List<BaseUserPassword> list) {
    	BaseUserPasswordVoConvert convert = new BaseUserPasswordVoConvert();
    	List<BaseUserPasswordVo> baseUserPasswordVoList = null;
    	BaseUserPasswordVo baseUserPasswordVo = null;
    	if(list != null && !list.isEmpty()) {
    		baseUserPasswordVoList = new ArrayList<BaseUserPasswordVo>(list.size());
    		ListIterator<BaseUserPassword> it = list.listIterator();
    		while(it.hasNext()) {
    			BaseUserPassword baseUserPassword = it.next();
    			baseUserPasswordVo = convert.doBackward(baseUserPassword);
    			baseUserPasswordVoList.add(baseUserPasswordVo);
    		}
    	}
    	return baseUserPasswordVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class BaseUserPasswordVoConvert extends Converter<BaseUserPasswordVo, BaseUserPassword> {

    	@Override
    	protected BaseUserPassword doForward(BaseUserPasswordVo baseUserPasswordVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param baseUserPassword
    	 * @return BaseUserPasswordVo
    	 */
		@Override
		protected BaseUserPasswordVo doBackward(BaseUserPassword baseUserPassword) {
			BaseUserPasswordVo baseUserPasswordVo = new BaseUserPasswordVo();
			BeanUtils.copyProperties(baseUserPassword, baseUserPasswordVo);
			baseUserPasswordVo.setBaseUserPasswordId(baseUserPassword.getId());
			return baseUserPasswordVo;
		}

    }

}