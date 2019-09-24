package com.cloud.provider.safe.vo.danger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.DangerCheck;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class DangerCheckVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dangerCheckId;

    private Integer enterpriseId;

    private Integer orgId;

    private String orgName;

    private Integer dangerId;

    private String title;

    private Date checkTime;

    private Integer checkUserId;

    private String checkUserAccount;

    private String checkUserName;

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
     * @param dangerCheck
     * @return DangerCheckVo
     */
    public DangerCheckVo convertToDangerCheckVo(DangerCheck dangerCheck) {
    	DangerCheckVoConvert convert = new DangerCheckVoConvert();
    	return convert.doBackward(dangerCheck);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<DangerCheckVo>
     */
    public List<DangerCheckVo> convertToDangerCheckVoList(List<DangerCheck> list) {
    	DangerCheckVoConvert convert = new DangerCheckVoConvert();
    	List<DangerCheckVo> dangerCheckVoList = null;
    	DangerCheckVo dangerCheckVo = null;
    	if(list != null && !list.isEmpty()) {
    		dangerCheckVoList = new ArrayList<DangerCheckVo>(list.size());
    		ListIterator<DangerCheck> it = list.listIterator();
    		while(it.hasNext()) {
    			DangerCheck dangerCheck = it.next();
    			dangerCheckVo = convert.doBackward(dangerCheck);
    			dangerCheckVoList.add(dangerCheckVo);
    		}
    	}
    	return dangerCheckVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class DangerCheckVoConvert extends Converter<DangerCheckVo, DangerCheck> {

    	@Override
    	protected DangerCheck doForward(DangerCheckVo dangerCheckVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param dangerCheck
    	 * @return DangerCheckVo
    	 */
		@Override
		protected DangerCheckVo doBackward(DangerCheck dangerCheck) {
			DangerCheckVo dangerCheckVo = new DangerCheckVo();
			BeanUtils.copyProperties(dangerCheck, dangerCheckVo);
			dangerCheckVo.setDangerCheckId(dangerCheck.getId());
			return dangerCheckVo;
		}

    }

}