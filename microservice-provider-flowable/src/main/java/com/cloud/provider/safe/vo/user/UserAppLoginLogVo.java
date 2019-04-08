package com.cloud.provider.safe.vo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.UserAppLoginLog;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAppLoginLogVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userAppLoginLogId;

    private Integer userId;

    private String userAccount;

    private String userName;

    private String userNameEn;

    private Integer loginType;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date loginTime;

    private Integer logType;

    private String loginIp;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param userAppLoginLog
     * @return UserAppLoginLogVo
     */
    public UserAppLoginLogVo convertToUserAppLoginLogVo(UserAppLoginLog userAppLoginLog) {
    	UserAppLoginLogVoConvert convert = new UserAppLoginLogVoConvert();
    	return convert.doBackward(userAppLoginLog);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserAppLoginLogVo>
     */
    public List<UserAppLoginLogVo> convertToUserAppLoginLogVoList(List<UserAppLoginLog> list) {
    	UserAppLoginLogVoConvert convert = new UserAppLoginLogVoConvert();
    	List<UserAppLoginLogVo> userAppLoginLogVoList = null;
    	UserAppLoginLogVo userAppLoginLogVo = null;
    	if(list != null && !list.isEmpty()) {
    		userAppLoginLogVoList = new ArrayList<UserAppLoginLogVo>(list.size());
    		ListIterator<UserAppLoginLog> it = list.listIterator();
    		while(it.hasNext()) {
    			UserAppLoginLog userAppLoginLog = it.next();
    			userAppLoginLogVo = convert.doBackward(userAppLoginLog);
    			userAppLoginLogVoList.add(userAppLoginLogVo);
    		}
    	}
    	return userAppLoginLogVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserAppLoginLogVoConvert extends Converter<UserAppLoginLogVo, UserAppLoginLog> {

    	@Override
    	protected UserAppLoginLog doForward(UserAppLoginLogVo userAppLoginLogVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userAppLoginLog
    	 * @return UserAppLoginLogVo
    	 */
		@Override
		protected UserAppLoginLogVo doBackward(UserAppLoginLog userAppLoginLog) {
			UserAppLoginLogVo userAppLoginLogVo = new UserAppLoginLogVo();
			BeanUtils.copyProperties(userAppLoginLog, userAppLoginLogVo);
			userAppLoginLogVo.setUserAppLoginLogId(userAppLoginLog.getId());
			return userAppLoginLogVo;
		}

    }

}