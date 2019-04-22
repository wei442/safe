package com.cloud.provider.safe.vo.danger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Danger;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class DangerVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dangerId;

    private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private String dangerSite;

    private Integer dangerLevel;

    private String dangerCategory;

    private String dangerSubCategory;

    private Date dangerTime;

    private String dangerDesc;

    private Integer dangerUserId;

    private String dangeUserAccount;

    private String dangeUserName;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param danger
     * @return DangerVo
     */
    public DangerVo convertToDangerVo(Danger danger) {
    	DangerVoConvert convert = new DangerVoConvert();
    	return convert.doBackward(danger);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<DangerVo>
     */
    public List<DangerVo> convertToDangerVoList(List<Danger> list) {
    	DangerVoConvert convert = new DangerVoConvert();
    	List<DangerVo> dangerVoList = null;
    	DangerVo dangerVo = null;
    	if(list != null && !list.isEmpty()) {
    		dangerVoList = new ArrayList<DangerVo>(list.size());
    		ListIterator<Danger> it = list.listIterator();
    		while(it.hasNext()) {
    			Danger danger = it.next();
    			dangerVo = convert.doBackward(danger);
    			dangerVoList.add(dangerVo);
    		}
    	}
    	return dangerVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class DangerVoConvert extends Converter<DangerVo, Danger> {

    	@Override
    	protected Danger doForward(DangerVo dangerVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param danger
    	 * @return DangerVo
    	 */
		@Override
		protected DangerVo doBackward(Danger danger) {
			DangerVo dangerVo = new DangerVo();
			BeanUtils.copyProperties(danger, dangerVo);
			dangerVo.setDangerId(danger.getId());
			return dangerVo;
		}

    }

}