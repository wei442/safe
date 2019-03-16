package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserInfo;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class BaseUserInfoVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserInfoId;

    private String userAccount;

    private String userName;

    private String userNameEn;

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
     * @param baseUserInfo
     * @return BaseUserInfoVo
     */
    public BaseUserInfoVo convertToBaseUserInfoVo(BaseUserInfo baseUserInfo) {
    	BaseUserInfoVoConvert convert = new BaseUserInfoVoConvert();
    	return convert.doBackward(baseUserInfo);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<BaseUserInfoVo>
     */
    public List<BaseUserInfoVo> convertToBaseUserInfoVoList(List<BaseUserInfo> list) {
    	BaseUserInfoVoConvert convert = new BaseUserInfoVoConvert();
    	List<BaseUserInfoVo> baseUserInfoVoList = null;
    	BaseUserInfoVo baseUserInfoVo = null;
    	if(list != null && !list.isEmpty()) {
    		baseUserInfoVoList = new ArrayList<BaseUserInfoVo>(list.size());
    		ListIterator<BaseUserInfo> it = list.listIterator();
    		while(it.hasNext()) {
    			BaseUserInfo baseUserInfo = it.next();
    			baseUserInfoVo = convert.doBackward(baseUserInfo);
    			baseUserInfoVoList.add(baseUserInfoVo);
    		}
    	}
    	return baseUserInfoVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class BaseUserInfoVoConvert extends Converter<BaseUserInfoVo, BaseUserInfo> {

    	@Override
    	protected BaseUserInfo doForward(BaseUserInfoVo baseUserInfoVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param baseUserInfo
    	 * @return BaseUserInfoVo
    	 */
		@Override
		protected BaseUserInfoVo doBackward(BaseUserInfo baseUserInfo) {
			BaseUserInfoVo baseUserInfoVo = new BaseUserInfoVo();
			BeanUtils.copyProperties(baseUserInfo, baseUserInfoVo);
			baseUserInfoVo.setBaseUserInfoId(baseUserInfo.getId());
			return baseUserInfoVo;
		}

    }

}