package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TitleRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "职务id")
	@NotNull(message = "职务id", groups = {UpdateGroup.class})
	private Integer titleId;

	@ApiModelProperty(value = "企业id")
	@NotNull(message = "企业id")
    private Integer enterpriseId;

	@ApiModelProperty(value = "职务名称")
	@NotBlank(message = "职务名称")
    private String titleName;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

}