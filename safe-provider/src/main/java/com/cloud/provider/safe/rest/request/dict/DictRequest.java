package com.cloud.provider.safe.rest.request.dict;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Dict;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典id")
    @NotNull(message = "字典id不能为空", groups = {ModifyGroup.class})
	private Integer dictId;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "字典编码")
	@NotBlank(message = "字典编码不能为空")
	private String dictCode;

	@ApiModelProperty(value = "字典名称")
	@NotBlank(message = "字典名称不能为空")
    private String dictName;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

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