package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.UserAppPassword;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAppPasswordVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAppPasswordId;

    private Integer userId;

    private String password;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date lastPassTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param userAppPassword
     * @return UserAppPasswordVo
     */
    public UserAppPasswordVo convertToUserAppPasswordVo(UserAppPassword userAppPassword) {
    	UserAppPasswordVoConvert convert = new UserAppPasswordVoConvert();
    	return convert.doBackward(userAppPassword);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserAppPasswordVo>
     */
    public List<UserAppPasswordVo> convertToUserAppPasswordVoList(List<UserAppPassword> list) {
    	UserAppPasswordVoConvert convert = new UserAppPasswordVoConvert();
    	List<UserAppPasswordVo> userAppPasswordVoList = null;
    	UserAppPasswordVo userAppPasswordVo = null;
    	if(list != null && !list.isEmpty()) {
    		userAppPasswordVoList = new ArrayList<UserAppPasswordVo>(list.size());
    		ListIterator<UserAppPassword> it = list.listIterator();
    		while(it.hasNext()) {
    			UserAppPassword userAppPassword = it.next();
    			userAppPasswordVo = convert.doBackward(userAppPassword);
    			userAppPasswordVoList.add(userAppPasswordVo);
    		}
    	}
    	return userAppPasswordVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserAppPasswordVoConvert extends Converter<UserAppPasswordVo, UserAppPassword> {

    	@Override
    	protected UserAppPassword doForward(UserAppPasswordVo userAppPasswordVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userAppPassword
    	 * @return UserAppPasswordVo
    	 */
		@Override
		protected UserAppPasswordVo doBackward(UserAppPassword userAppPassword) {
			UserAppPasswordVo userAppPasswordVo = new UserAppPasswordVo();
			BeanUtils.copyProperties(userAppPassword, userAppPasswordVo);
			userAppPasswordVo.setUserAppPasswordId(userAppPassword.getId());
			return userAppPasswordVo;
		}

    }

}