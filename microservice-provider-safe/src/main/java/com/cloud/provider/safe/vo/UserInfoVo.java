package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserInfo;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserInfoVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;

    private Integer enterpriseId;

    private String userAccount;

    private String userPassword;

    private String userName;

    private String userNameEn;

    private String nickName;

    private Integer userType;

    private Integer gender;

    private Integer userStatus;

    private String userEmail;

    private String headImage;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
     * 实体转换
     * @param userInfo
     * @return UserInfoVo
     */
    public UserInfoVo convertToUserInfoVo(UserInfo userInfo) {
    	UserInfoVoConvert convert = new UserInfoVoConvert();
    	return convert.doBackward(userInfo);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserInfoVo>
     */
    public List<UserInfoVo> convertToUserInfoVoList(List<UserInfo> list) {
    	UserInfoVoConvert convert = new UserInfoVoConvert();
    	List<UserInfoVo> userInfoVoList = null;
    	UserInfoVo userInfoVo = null;
    	if(list != null && !list.isEmpty()) {
    		userInfoVoList = new ArrayList<UserInfoVo>(list.size());
    		ListIterator<UserInfo> it = list.listIterator();
    		while(it.hasNext()) {
    			UserInfo userInfo = it.next();
    			userInfoVo = convert.doBackward(userInfo);
    			userInfoVoList.add(userInfoVo);
    		}
    	}
    	return userInfoVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserInfoVoConvert extends Converter<UserInfoVo, UserInfo> {

    	@Override
    	protected UserInfo doForward(UserInfoVo userInfoVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userInfo
    	 * @return UserInfoVo
    	 */
		@Override
		protected UserInfoVo doBackward(UserInfo userInfo) {
			UserInfoVo userInfoVo = new UserInfoVo();
			BeanUtils.copyProperties(userInfo, userInfoVo);
			userInfoVo.setUserId(userInfo.getId());
			return userInfoVo;
		}

    }

}