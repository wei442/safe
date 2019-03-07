package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.DictItem;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DictItemPageRequest extends BaseRestRequest {

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

    private Date createTime;

    private Date updateTime;

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
	private static class DictItemConvert extends Converter<DictItemPageRequest, DictItem> {

		@Override
		protected DictItem doForward(DictItemPageRequest dictItemRequest) {
			DictItem dictItem = new DictItem();
			BeanUtils.copyProperties(dictItemRequest, dictItem);
			return dictItem;
		}

		@Override
		protected DictItemPageRequest doBackward(DictItem b) {
			return null;
		}

	}

}