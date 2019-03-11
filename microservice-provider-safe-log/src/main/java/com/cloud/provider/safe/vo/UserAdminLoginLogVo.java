package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAdminLoginLog;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAdminLoginLogVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Long userAdminLoginLogId;

    private Integer userId;

    private String userAccount;

    private String userName;

    private String userNameEn;

    private Integer loginType;

    private Date loginTime;

    private Integer logType;

    private String loginIp;

    private Date createTime;

    private Date updateTime;

    /**
     * 实体转换
     * @param userAdminLoginLog
     * @return UserAdminLoginLogVo
     */
    public UserAdminLoginLogVo convertToUserAdminLoginLogVo(UserAdminLoginLog userAdminLoginLog) {
    	UserAdminLoginLogVoConvert convert = new UserAdminLoginLogVoConvert();
    	return convert.doBackward(userAdminLoginLog);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserAdminLoginLogVo>
     */
    public List<UserAdminLoginLogVo> convertToUserAdminLoginLogVoList(List<UserAdminLoginLog> list) {
    	UserAdminLoginLogVoConvert convert = new UserAdminLoginLogVoConvert();
    	List<UserAdminLoginLogVo> userAdminLoginLogVoList = null;
    	UserAdminLoginLogVo userAdminLoginLogVo = null;
    	if(list != null && !list.isEmpty()) {
    		userAdminLoginLogVoList = new ArrayList<UserAdminLoginLogVo>(list.size());
    		ListIterator<UserAdminLoginLog> it = list.listIterator();
    		while(it.hasNext()) {
    			UserAdminLoginLog userAdminLoginLog = it.next();
    			userAdminLoginLogVo = convert.doBackward(userAdminLoginLog);
    			userAdminLoginLogVoList.add(userAdminLoginLogVo);
    		}
    	}
    	return userAdminLoginLogVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserAdminLoginLogVoConvert extends Converter<UserAdminLoginLogVo, UserAdminLoginLog> {

    	@Override
    	protected UserAdminLoginLog doForward(UserAdminLoginLogVo userAdminLoginLogVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userAdminLoginLog
    	 * @return UserAdminLoginLogVo
    	 */
		@Override
		protected UserAdminLoginLogVo doBackward(UserAdminLoginLog userAdminLoginLog) {
			UserAdminLoginLogVo userAdminLoginLogVo = new UserAdminLoginLogVo();
			BeanUtils.copyProperties(userAdminLoginLog, userAdminLoginLogVo);
			userAdminLoginLogVo.setUserAdminLoginLogId(userAdminLoginLog.getId());
			return userAdminLoginLogVo;
		}

    }

}