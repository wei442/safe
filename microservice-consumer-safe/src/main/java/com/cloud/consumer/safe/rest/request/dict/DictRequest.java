package com.cloud.consumer.safe.rest.request.dict;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典id")
    @NotNull(message = "字典id不能为空", groups = {UpdateGroup.class})
	private Integer dictId;

    private Integer enterpriseId;

	@ApiModelProperty(value = "字典名称")
	@NotBlank(message = "字典名称不能为空")
    private String dictName;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

}