package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.DictItem;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class DictItemRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dictItemId;

    private Integer enterpriseId;

    private Integer dictId;

    private String itemName;

    private String itemAlias;

    private Integer itemLevel;

    private Integer itemStatus;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    /**
	 * 实体转换
	 * @return DictItem
	 */
	public DictItem convertToDictItem() {
		DictItemConvert convert = new DictItemConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class DictItemConvert extends Converter<DictItemRequest, DictItem> {

		@Override
		protected DictItem doForward(DictItemRequest dictItemRequest) {
			DictItem dictItem = new DictItem();
			BeanUtils.copyProperties(dictItemRequest, dictItem);
			return dictItem;
		}

		@Override
		protected DictItemRequest doBackward(DictItem b) {
			return null;
		}

	}

}