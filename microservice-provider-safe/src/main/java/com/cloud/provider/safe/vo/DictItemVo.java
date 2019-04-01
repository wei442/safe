package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.DictItem;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class DictItemVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dictItemId;

	private Integer dictId;

    private String itemName;

    private Integer itemType;

    private Integer itemStatus;

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
     * @param dictItem
     * @return DictItemVo
     */
    public DictItemVo convertToDictItemVo(DictItem dictItem) {
    	DictItemVoConvert convert = new DictItemVoConvert();
    	return convert.doBackward(dictItem);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<DictItemVo>
     */
    public List<DictItemVo> convertToDictItemVoList(List<DictItem> list) {
    	DictItemVoConvert convert = new DictItemVoConvert();
    	List<DictItemVo> dictItemVoList = null;
    	DictItemVo dictItemVo = null;
    	if(list != null && !list.isEmpty()) {
    		dictItemVoList = new ArrayList<DictItemVo>(list.size());
    		ListIterator<DictItem> it = list.listIterator();
    		while(it.hasNext()) {
    			DictItem dictItem = it.next();
    			dictItemVo = convert.doBackward(dictItem);
    			dictItemVoList.add(dictItemVo);
    		}
    	}
    	return dictItemVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class DictItemVoConvert extends Converter<DictItemVo, DictItem> {

    	@Override
    	protected DictItem doForward(DictItemVo dictItemVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param dictItem
    	 * @return DictItemVo
    	 */
		@Override
		protected DictItemVo doBackward(DictItem dictItem) {
			DictItemVo dictItemVo = new DictItemVo();
			BeanUtils.copyProperties(dictItem, dictItemVo);
			dictItemVo.setDictItemId(dictItem.getId());
			return dictItemVo;
		}

    }

}