package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.UserOrg;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserOrgVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userOrgId;

	private Integer enterpriseId;

    private Integer userId;

    private String userName;

    private Integer orgId;

    private String orgName;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    private String userAccount;

    private String userNameEn;

    private String nickName;

    /**
     * 实体转换
     * @param userOrg
     * @return UserOrgVo
     */
    public UserOrgVo convertToUserOrgVo(UserOrg userOrg) {
    	UserOrgVoConvert convert = new UserOrgVoConvert();
    	return convert.doBackward(userOrg);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserOrgVo>
     */
    public List<UserOrgVo> convertToUserOrgVoList(List<UserOrg> list) {
    	UserOrgVoConvert convert = new UserOrgVoConvert();
    	List<UserOrgVo> userOrgVoList = null;
    	UserOrgVo userOrgVo = null;
    	if(list != null && !list.isEmpty()) {
    		userOrgVoList = new ArrayList<UserOrgVo>(list.size());
    		ListIterator<UserOrg> it = list.listIterator();
    		while(it.hasNext()) {
    			UserOrg userOrg = it.next();
    			userOrgVo = convert.doBackward(userOrg);
    			userOrgVoList.add(userOrgVo);
    		}
    	}
    	return userOrgVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserOrgVoConvert extends Converter<UserOrgVo, UserOrg> {

    	@Override
    	protected UserOrg doForward(UserOrgVo userOrgVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userOrg
    	 * @return UserOrgVo
    	 */
		@Override
		protected UserOrgVo doBackward(UserOrg userOrg) {
			UserOrgVo userOrgVo = new UserOrgVo();
			BeanUtils.copyProperties(userOrg, userOrgVo);
			userOrgVo.setUserOrgId(userOrg.getId());
			return userOrgVo;
		}

    }

}