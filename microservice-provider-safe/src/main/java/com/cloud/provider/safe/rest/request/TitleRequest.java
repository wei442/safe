package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Title;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class TitleRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer titleId;

    private Integer enterpriseId;

    private String titleName;

    private String remark;

    private Integer sort;

    /**
	 * 实体转换
	 * @return Title
	 */
	public Title convertToTitle() {
		TitleConvert convert = new TitleConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class TitleConvert extends Converter<TitleRequest, Title> {

		@Override
		protected Title doForward(TitleRequest TitleRequest) {
			Title Title = new Title();
			BeanUtils.copyProperties(TitleRequest, Title);
			return Title;
		}

		@Override
		protected TitleRequest doBackward(Title b) {
			return null;
		}

	}

}