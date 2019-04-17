package com.cloud.provider.safe.vo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAdminLoginVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminLoginId;

    private Integer userId;

    private Integer firstLogin;

    private Integer loginCount;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;
    
    /**
     * 实体转换
     * @param userAdminLogin
     * @return UserAdminLoginVo
     */
    public UserAdminLoginVo convertToUserAdminLoginVo(UserAdminLogin userAdminLogin) {
    	UserAdminLoginVoConvert convert = new UserAdminLoginVoConvert();
    	return convert.doBackward(userAdminLogin);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserAdminLoginVo>
     */
    public List<UserAdminLoginVo> convertToUserAdminLoginVoList(List<UserAdminLogin> list) {
    	UserAdminLoginVoConvert convert = new UserAdminLoginVoConvert();
    	List<UserAdminLoginVo> userAdminLoginVoList = null;
    	UserAdminLoginVo userAdminLoginVo = null;
    	if(list != null && !list.isEmpty()) {
    		userAdminLoginVoList = new ArrayList<UserAdminLoginVo>(list.size());
    		ListIterator<UserAdminLogin> it = list.listIterator();
    		while(it.hasNext()) {
    			UserAdminLogin userAdminLogin = it.next();
    			userAdminLoginVo = convert.doBackward(userAdminLogin);
    			userAdminLoginVoList.add(userAdminLoginVo);
    		}
    	}
    	return userAdminLoginVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserAdminLoginVoConvert extends Converter<UserAdminLoginVo, UserAdminLogin> {

    	@Override
    	protected UserAdminLogin doForward(UserAdminLoginVo userAdminLoginVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userAdminLogin
    	 * @return UserAdminLoginVo
    	 */
		@Override
		protected UserAdminLoginVo doBackward(UserAdminLogin userAdminLogin) {
			UserAdminLoginVo userAdminLoginVo = new UserAdminLoginVo();
			BeanUtils.copyProperties(userAdminLogin, userAdminLoginVo);
			userAdminLoginVo.setUserAdminLoginId(userAdminLogin.getId());
			return userAdminLoginVo;
		}

    }

}