package com.cloud.provider.safe.rest.request.dict;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.DictItem;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictItemRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典子项id", required = true)
    @NotNull(message = "字典子项id不能为空", groups = {ModifyGroup.class})
	private Integer dictItemId;

	@ApiModelProperty(value = "字典id", required = true)
    @NotNull(message = "字典id不能为空")
    private Integer dictId;

	@ApiModelProperty(value = "字典子项名称d", required = true)
	@NotBlank(message = "字典子项名称不能为空")
    private String itemName;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

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