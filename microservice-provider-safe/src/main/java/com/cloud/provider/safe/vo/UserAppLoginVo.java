package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserAppLogin;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAppLoginVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAppLoginId;

    private Integer userId;

    private Integer firstLogin;

    private Integer loginCount;

    private Date lastPassTime;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
     * 实体转换
     * @param userAppLogin
     * @return UserAppLoginVo
     */
    public UserAppLoginVo convertToUserAppLoginVo(UserAppLogin userAppLogin) {
    	UserAppLoginVoConvert convert = new UserAppLoginVoConvert();
    	return convert.doBackward(userAppLogin);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserAppLoginVo>
     */
    public List<UserAppLoginVo> convertToUserAppLoginVoList(List<UserAppLogin> list) {
    	UserAppLoginVoConvert convert = new UserAppLoginVoConvert();
    	List<UserAppLoginVo> userAppLoginVoList = null;
    	UserAppLoginVo userAppLoginVo = null;
    	if(list != null && !list.isEmpty()) {
    		userAppLoginVoList = new ArrayList<UserAppLoginVo>(list.size());
    		ListIterator<UserAppLogin> it = list.listIterator();
    		while(it.hasNext()) {
    			UserAppLogin userAppLogin = it.next();
    			userAppLoginVo = convert.doBackward(userAppLogin);
    			userAppLoginVoList.add(userAppLoginVo);
    		}
    	}
    	return userAppLoginVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserAppLoginVoConvert extends Converter<UserAppLoginVo, UserAppLogin> {

    	@Override
    	protected UserAppLogin doForward(UserAppLoginVo userAppLoginVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userAppLogin
    	 * @return UserAppLoginVo
    	 */
		@Override
		protected UserAppLoginVo doBackward(UserAppLogin userAppLogin) {
			UserAppLoginVo userAppLoginVo = new UserAppLoginVo();
			BeanUtils.copyProperties(userAppLogin, userAppLoginVo);
			userAppLoginVo.setUserAppLoginId(userAppLogin.getId());
			return userAppLoginVo;
		}

    }

}