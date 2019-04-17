package com.cloud.provider.safe.vo.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.UserTitle;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserTitleVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userTitleId;

	private Integer enterpriseId;

    private Integer userId;

    private Integer titleId;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    private String userName;

    private Integer orgId;

    private String orgName;

    /**
     * 实体转换
     * @param userTitle
     * @return UserTitleVo
     */
    public UserTitleVo convertToUserTitleVo(UserTitle userTitle) {
    	UserTitleVoConvert convert = new UserTitleVoConvert();
    	return convert.doBackward(userTitle);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserTitleVo>
     */
    public List<UserTitleVo> convertToUserTitleVoList(List<UserTitle> list) {
    	UserTitleVoConvert convert = new UserTitleVoConvert();
    	List<UserTitleVo> userTitleVoList = null;
    	UserTitleVo userTitleVo = null;
    	if(list != null && !list.isEmpty()) {
    		userTitleVoList = new ArrayList<UserTitleVo>(list.size());
    		ListIterator<UserTitle> it = list.listIterator();
    		while(it.hasNext()) {
    			UserTitle userTitle = it.next();
    			userTitleVo = convert.doBackward(userTitle);
    			userTitleVoList.add(userTitleVo);
    		}
    	}
    	return userTitleVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserTitleVoConvert extends Converter<UserTitleVo, UserTitle> {

    	@Override
    	protected UserTitle doForward(UserTitleVo userTitleVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userTitle
    	 * @return UserTitleVo
    	 */
		@Override
		protected UserTitleVo doBackward(UserTitle userTitle) {
			UserTitleVo userTitleVo = new UserTitleVo();
			BeanUtils.copyProperties(userTitle, userTitleVo);
			userTitleVo.setUserTitleId(userTitle.getId());
			return userTitleVo;
		}

    }

}