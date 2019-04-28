package com.cloud.provider.safe.vo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.UserAdmin;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserAdminVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userAdminId;

    private Integer enterpriseId;

    private Integer userId;

    private String adminName;

    private Integer adminType;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    private String userAccount;

    private String userName;

    /**
     * 实体转换
     * @param userAdmin
     * @return UserAdminVo
     */
    public UserAdminVo convertToUserAdminVo(UserAdmin userAdmin) {
    	UserAdminVoConvert convert = new UserAdminVoConvert();
    	return convert.doBackward(userAdmin);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserAdminVo>
     */
    public List<UserAdminVo> convertToUserAdminVoList(List<UserAdmin> list) {
    	UserAdminVoConvert convert = new UserAdminVoConvert();
    	List<UserAdminVo> userAdminVoList = null;
    	UserAdminVo userAdminVo = null;
    	if(list != null && !list.isEmpty()) {
    		userAdminVoList = new ArrayList<UserAdminVo>(list.size());
    		ListIterator<UserAdmin> it = list.listIterator();
    		while(it.hasNext()) {
    			UserAdmin userAdmin = it.next();
    			userAdminVo = convert.doBackward(userAdmin);
    			userAdminVoList.add(userAdminVo);
    		}
    	}
    	return userAdminVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserAdminVoConvert extends Converter<UserAdminVo, UserAdmin> {

    	@Override
    	protected UserAdmin doForward(UserAdminVo userAdminVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userAdmin
    	 * @return UserAdminVo
    	 */
		@Override
		protected UserAdminVo doBackward(UserAdmin userAdmin) {
			UserAdminVo userAdminVo = new UserAdminVo();
			BeanUtils.copyProperties(userAdmin, userAdminVo);
			userAdminVo.setUserAdminId(userAdmin.getId());
			return userAdminVo;
		}

    }

}