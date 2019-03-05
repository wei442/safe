package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.BaseUserLogin;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class BaseUserLoginVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer baseUserLoginId;

    private Integer baseUserId;

    private Integer loginCount;

    private Date lastPassTime;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
     * 实体转换
     * @param baseUserLogin
     * @return BaseUserLoginVo
     */
    public BaseUserLoginVo convertToBaseUserLoginVo(BaseUserLogin baseUserLogin) {
    	BaseUserLoginVoConvert convert = new BaseUserLoginVoConvert();
    	return convert.doBackward(baseUserLogin);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<BaseUserLoginVo>
     */
    public List<BaseUserLoginVo> convertToBaseUserLoginVoList(List<BaseUserLogin> list) {
    	BaseUserLoginVoConvert convert = new BaseUserLoginVoConvert();
    	List<BaseUserLoginVo> baseUserLoginVoList = null;
    	BaseUserLoginVo baseUserLoginVo = null;
    	if(list != null && !list.isEmpty()) {
    		baseUserLoginVoList = new ArrayList<BaseUserLoginVo>(list.size());
    		ListIterator<BaseUserLogin> it = list.listIterator();
    		while(it.hasNext()) {
    			BaseUserLogin baseUserLogin = it.next();
    			baseUserLoginVo = convert.doBackward(baseUserLogin);
    			baseUserLoginVoList.add(baseUserLoginVo);
    		}
    	}
    	return baseUserLoginVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class BaseUserLoginVoConvert extends Converter<BaseUserLoginVo, BaseUserLogin> {

    	@Override
    	protected BaseUserLogin doForward(BaseUserLoginVo baseUserLoginVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param baseUserLogin
    	 * @return BaseUserLoginVo
    	 */
		@Override
		protected BaseUserLoginVo doBackward(BaseUserLogin baseUserLogin) {
			BaseUserLoginVo baseUserLoginVo = new BaseUserLoginVo();
			BeanUtils.copyProperties(baseUserLogin, baseUserLoginVo);
			baseUserLoginVo.setBaseUserLoginId(baseUserLogin.getId());
			return baseUserLoginVo;
		}

    }

}