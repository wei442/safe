package com.cloud.provider.safe.vo.dict;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Dict;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class DictVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dictId;

    private Integer enterpriseId;

    private String dictCode;

    private String dictName;

    private Integer dictType;

    private Integer dictStatus;

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
     * @param dict
     * @return DictVo
     */
    public DictVo convertToDictVo(Dict dict) {
    	DictVoConvert convert = new DictVoConvert();
    	return convert.doBackward(dict);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<DictVo>
     */
    public List<DictVo> convertToDictVoList(List<Dict> list) {
    	DictVoConvert convert = new DictVoConvert();
    	List<DictVo> dictVoList = null;
    	DictVo dictVo = null;
    	if(list != null && !list.isEmpty()) {
    		dictVoList = new ArrayList<DictVo>(list.size());
    		ListIterator<Dict> it = list.listIterator();
    		while(it.hasNext()) {
    			Dict dict = it.next();
    			dictVo = convert.doBackward(dict);
    			dictVoList.add(dictVo);
    		}
    	}
    	return dictVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class DictVoConvert extends Converter<DictVo, Dict> {

    	@Override
    	protected Dict doForward(DictVo dictVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param dict
    	 * @return DictVo
    	 */
		@Override
		protected DictVo doBackward(Dict dict) {
			DictVo dictVo = new DictVo();
			BeanUtils.copyProperties(dict, dictVo);
			dictVo.setDictId(dict.getId());
			return dictVo;
		}

    }

}