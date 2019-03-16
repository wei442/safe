package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAdminPassword;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAdminPasswordVo implements Serializable {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminPasswordId;

    private Integer userId;

    private String password;

    private Date createTime;

    private Date updateTime;

    /**
     * 实体转换
     * @param userAdminPassword
     * @return UserAdminPasswordVo
     */
    public UserAdminPasswordVo convertToUserAdminPasswordVo(UserAdminPassword userAdminPassword) {
    	UserAdminPasswordVoConvert convert = new UserAdminPasswordVoConvert();
    	return convert.doBackward(userAdminPassword);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserAdminPasswordVo>
     */
    public List<UserAdminPasswordVo> convertToUserAdminPasswordVoList(List<UserAdminPassword> list) {
    	UserAdminPasswordVoConvert convert = new UserAdminPasswordVoConvert();
    	List<UserAdminPasswordVo> userAdminPasswordVoList = null;
    	UserAdminPasswordVo userAdminPasswordVo = null;
    	if(list != null && !list.isEmpty()) {
    		userAdminPasswordVoList = new ArrayList<UserAdminPasswordVo>(list.size());
    		ListIterator<UserAdminPassword> it = list.listIterator();
    		while(it.hasNext()) {
    			UserAdminPassword userAdminPassword = it.next();
    			userAdminPasswordVo = convert.doBackward(userAdminPassword);
    			userAdminPasswordVoList.add(userAdminPasswordVo);
    		}
    	}
    	return userAdminPasswordVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserAdminPasswordVoConvert extends Converter<UserAdminPasswordVo, UserAdminPassword> {

    	@Override
    	protected UserAdminPassword doForward(UserAdminPasswordVo userAdminPasswordVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userAdminPassword
    	 * @return UserAdminPasswordVo
    	 */
		@Override
		protected UserAdminPasswordVo doBackward(UserAdminPassword userAdminPassword) {
			UserAdminPasswordVo userAdminPasswordVo = new UserAdminPasswordVo();
			BeanUtils.copyProperties(userAdminPassword, userAdminPasswordVo);
			userAdminPasswordVo.setUserAdminPasswordId(userAdminPassword.getId());
			return userAdminPasswordVo;
		}

    }

}