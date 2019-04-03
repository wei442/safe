package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "资质id", required = true)
    @NotNull(message = "资质id不能为空", groups = {UpdateGroup.class})
	private Integer qualityId;

	private Integer enterpriseId;

	@ApiModelProperty(value = "资质名称")
	@NotBlank(message = "资质名称不能为空")
    private String qualityName;

	@ApiModelProperty(value = "备注")
    private String remark;

}