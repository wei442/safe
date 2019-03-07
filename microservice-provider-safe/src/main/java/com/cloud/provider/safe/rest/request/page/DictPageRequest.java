package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.Dict;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DictPageRequest extends BaseRestRequest {

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

    private Date createTime;

    private Date updateTime;

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
	private static class DictConvert extends Converter<DictPageRequest, Dict> {

		@Override
		protected Dict doForward(DictPageRequest dictRequest) {
			Dict dict = new Dict();
			BeanUtils.copyProperties(dictRequest, dict);
			return dict;
		}

		@Override
		protected DictPageRequest doBackward(Dict b) {
			return null;
		}

	}

}