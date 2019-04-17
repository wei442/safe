package com.cloud.provider.safe.vo.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Title;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class TitleVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer titleId;

    private Integer enterpriseId;

    private String titleName;

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
     * @param title
     * @return TitleVo
     */
    public TitleVo convertToTitleVo(Title title) {
    	TitleVoConvert convert = new TitleVoConvert();
    	return convert.doBackward(title);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<TitleVo>
     */
    public List<TitleVo> convertToTitleVoList(List<Title> list) {
    	TitleVoConvert convert = new TitleVoConvert();
    	List<TitleVo> titleVoList = null;
    	TitleVo titleVo = null;
    	if(list != null && !list.isEmpty()) {
    		titleVoList = new ArrayList<TitleVo>(list.size());
    		ListIterator<Title> it = list.listIterator();
    		while(it.hasNext()) {
    			Title title = it.next();
    			titleVo = convert.doBackward(title);
    			titleVoList.add(titleVo);
    		}
    	}
    	return titleVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class TitleVoConvert extends Converter<TitleVo, Title> {

    	@Override
    	protected Title doForward(TitleVo titleVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param title
    	 * @return TitleVo
    	 */
		@Override
		protected TitleVo doBackward(Title title) {
			TitleVo titleVo = new TitleVo();
			BeanUtils.copyProperties(title, titleVo);
			titleVo.setTitleId(title.getId());
			return titleVo;
		}

    }

}