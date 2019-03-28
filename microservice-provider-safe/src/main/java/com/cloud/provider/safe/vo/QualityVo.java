package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Quality;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class QualityVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer qualityId;

    private Integer enterpriseId;

    private String qualityName;

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
     * @param quality
     * @return QualityVo
     */
    public QualityVo convertToQualityVo(Quality quality) {
    	QualityVoConvert convert = new QualityVoConvert();
    	return convert.doBackward(quality);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<QualityVo>
     */
    public List<QualityVo> convertToQualityVoList(List<Quality> list) {
    	QualityVoConvert convert = new QualityVoConvert();
    	List<QualityVo> qualityVoList = null;
    	QualityVo qualityVo = null;
    	if(list != null && !list.isEmpty()) {
    		qualityVoList = new ArrayList<QualityVo>(list.size());
    		ListIterator<Quality> it = list.listIterator();
    		while(it.hasNext()) {
    			Quality quality = it.next();
    			qualityVo = convert.doBackward(quality);
    			qualityVoList.add(qualityVo);
    		}
    	}
    	return qualityVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class QualityVoConvert extends Converter<QualityVo, Quality> {

    	@Override
    	protected Quality doForward(QualityVo qualityVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param quality
    	 * @return QualityVo
    	 */
		@Override
		protected QualityVo doBackward(Quality quality) {
			QualityVo qualityVo = new QualityVo();
			BeanUtils.copyProperties(quality, qualityVo);
			qualityVo.setQualityId(quality.getId());
			return qualityVo;
		}

    }

}