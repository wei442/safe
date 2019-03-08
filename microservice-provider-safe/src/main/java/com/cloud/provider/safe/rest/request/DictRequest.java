package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Dict;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class DictRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dictId;

    private Integer enterpriseId;

    private String dictName;

    private Integer dictType;

    private Integer dictStatus;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    /**
	 * 实体转换
	 * @return Dict
	 */
	public Dict convertToDict() {
		DictConvert convert = new DictConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class DictConvert extends Converter<DictRequest, Dict> {

		@Override
		protected Dict doForward(DictRequest dictRequest) {
			Dict dict = new Dict();
			BeanUtils.copyProperties(dictRequest, dict);
			return dict;
		}

		@Override
		protected DictRequest doBackward(Dict b) {
			return null;
		}

	}

}