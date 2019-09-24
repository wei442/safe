package com.cloud.provider.safe.vo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.UserMenu;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserMenuVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userMenuId;

	private Integer enterpriseId;

    private Integer userId;

    private String menuCode;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param userMenu
     * @return UserMenuVo
     */
    public UserMenuVo convertToUserMenuVo(UserMenu userMenu) {
    	UserMenuVoConvert convert = new UserMenuVoConvert();
    	return convert.doBackward(userMenu);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserMenuVo>
     */
    public List<UserMenuVo> convertToUserMenuVoList(List<UserMenu> list) {
    	UserMenuVoConvert convert = new UserMenuVoConvert();
    	List<UserMenuVo> userMenuVoList = null;
    	UserMenuVo userMenuVo = null;
    	if(list != null && !list.isEmpty()) {
    		userMenuVoList = new ArrayList<UserMenuVo>(list.size());
    		ListIterator<UserMenu> it = list.listIterator();
    		while(it.hasNext()) {
    			UserMenu userMenu = it.next();
    			userMenuVo = convert.doBackward(userMenu);
    			userMenuVoList.add(userMenuVo);
    		}
    	}
    	return userMenuVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserMenuVoConvert extends Converter<UserMenuVo, UserMenu> {

    	@Override
    	protected UserMenu doForward(UserMenuVo userMenuVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userMenu
    	 * @return UserMenuVo
    	 */
		@Override
		protected UserMenuVo doBackward(UserMenu userMenu) {
			UserMenuVo userMenuVo = new UserMenuVo();
			BeanUtils.copyProperties(userMenu, userMenuVo);
			userMenuVo.setUserMenuId(userMenu.getId());
			return userMenuVo;
		}

    }

}