package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.BaseUserLoginLog;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class BaseUserLoginLogVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long baseUserLoginLogId;

	private Integer baseUserId;

    private String baseUserAccount;

    private String baseUserName;

    private String baseUserNameEn;

    private Integer loginType;

    private Date loginTime;

    private String loginMode;

    private String loginIp;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param baseUserLoginLog
     * @return BaseUserLoginLogVo
     */
    public BaseUserLoginLogVo convertToBaseUserLoginLogVo(BaseUserLoginLog baseUserLoginLog) {
    	BaseUserLoginLogVoConvert convert = new BaseUserLoginLogVoConvert();
    	return convert.doBackward(baseUserLoginLog);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<BaseUserLoginLogVo>
     */
    public List<BaseUserLoginLogVo> convertToBaseUserLoginLogVoList(List<BaseUserLoginLog> list) {
    	BaseUserLoginLogVoConvert convert = new BaseUserLoginLogVoConvert();
    	List<BaseUserLoginLogVo> baseUserLoginLogVoList = null;
    	BaseUserLoginLogVo baseUserLoginLogVo = null;
    	if(list != null && !list.isEmpty()) {
    		baseUserLoginLogVoList = new ArrayList<BaseUserLoginLogVo>(list.size());
    		ListIterator<BaseUserLoginLog> it = list.listIterator();
    		while(it.hasNext()) {
    			BaseUserLoginLog baseUserLoginLog = it.next();
    			baseUserLoginLogVo = convert.doBackward(baseUserLoginLog);
    			baseUserLoginLogVoList.add(baseUserLoginLogVo);
    		}
    	}
    	return baseUserLoginLogVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class BaseUserLoginLogVoConvert extends Converter<BaseUserLoginLogVo, BaseUserLoginLog> {

    	@Override
    	protected BaseUserLoginLog doForward(BaseUserLoginLogVo baseUserLoginLogVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param baseUserLoginLog
    	 * @return BaseUserLoginLogVo
    	 */
		@Override
		protected BaseUserLoginLogVo doBackward(BaseUserLoginLog baseUserLoginLog) {
			BaseUserLoginLogVo baseUserLoginLogVo = new BaseUserLoginLogVo();
			BeanUtils.copyProperties(baseUserLoginLog, baseUserLoginLogVo);
			baseUserLoginLogVo.setBaseUserLoginLogId(baseUserLoginLog.getId());
			return baseUserLoginLogVo;
		}

    }

}