package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUser;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class BaseUserVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserId;

    private String userAccount;

    private String userName;

    private String userNameEn;

    private String userPassword;

    private Integer userType;

    private Integer userStatus;

    private String userEmail;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
     * 实体转换
     * @param baseUser
     * @return BaseUserVo
     */
    public BaseUserVo convertToBaseUserVo(BaseUser baseUser) {
    	BaseUserVoConvert convert = new BaseUserVoConvert();
    	return convert.doBackward(baseUser);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<BaseUserVo>
     */
    public List<BaseUserVo> convertToBaseUserVoList(List<BaseUser> list) {
    	BaseUserVoConvert convert = new BaseUserVoConvert();
    	List<BaseUserVo> baseUserVoList = null;
    	BaseUserVo baseUserVo = null;
    	if(list != null && !list.isEmpty()) {
    		baseUserVoList = new ArrayList<BaseUserVo>(list.size());
    		ListIterator<BaseUser> it = list.listIterator();
    		while(it.hasNext()) {
    			BaseUser baseUser = it.next();
    			baseUserVo = convert.doBackward(baseUser);
    			baseUserVoList.add(baseUserVo);
    		}
    	}
    	return baseUserVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class BaseUserVoConvert extends Converter<BaseUserVo, BaseUser> {

    	@Override
    	protected BaseUser doForward(BaseUserVo baseUserVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param baseUser
    	 * @return BaseUserVo
    	 */
		@Override
		protected BaseUserVo doBackward(BaseUser baseUser) {
			BaseUserVo baseUserVo = new BaseUserVo();
			BeanUtils.copyProperties(baseUser, baseUserVo);
			baseUserVo.setBaseUserId(baseUser.getId());
			return baseUserVo;
		}

    }

}