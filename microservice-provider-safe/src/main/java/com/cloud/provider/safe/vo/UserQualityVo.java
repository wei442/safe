package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.UserQuality;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserQualityVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userQualityId;

	private Integer enterpriseId;

    private Integer userId;

    private Integer qualityId;

    private Integer isDelete;

    private String remark;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param userQuality
     * @return UserQualityVo
     */
    public UserQualityVo convertToUserQualityVo(UserQuality userQuality) {
    	UserQualityVoConvert convert = new UserQualityVoConvert();
    	return convert.doBackward(userQuality);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserQualityVo>
     */
    public List<UserQualityVo> convertToUserQualityVoList(List<UserQuality> list) {
    	UserQualityVoConvert convert = new UserQualityVoConvert();
    	List<UserQualityVo> userQualityVoList = null;
    	UserQualityVo userQualityVo = null;
    	if(list != null && !list.isEmpty()) {
    		userQualityVoList = new ArrayList<UserQualityVo>(list.size());
    		ListIterator<UserQuality> it = list.listIterator();
    		while(it.hasNext()) {
    			UserQuality userQuality = it.next();
    			userQualityVo = convert.doBackward(userQuality);
    			userQualityVoList.add(userQualityVo);
    		}
    	}
    	return userQualityVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserQualityVoConvert extends Converter<UserQualityVo, UserQuality> {

    	@Override
    	protected UserQuality doForward(UserQualityVo userQualityVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userQuality
    	 * @return UserQualityVo
    	 */
		@Override
		protected UserQualityVo doBackward(UserQuality userQuality) {
			UserQualityVo userQualityVo = new UserQualityVo();
			BeanUtils.copyProperties(userQuality, userQualityVo);
			userQualityVo.setUserQualityId(userQuality.getId());
			return userQualityVo;
		}

    }

}