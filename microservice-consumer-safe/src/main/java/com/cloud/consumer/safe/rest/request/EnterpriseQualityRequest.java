package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class EnterpriseQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id不能为空", groups = {UpdateGroup.class})
	private Integer enterpriseQualityId;

    private Integer enterpriseId;

	@ApiModelProperty(value = "附件id", required = true)
    @NotNull(message = "附件id不能为空")
    private Integer qualityId;

	@ApiModelProperty(value = "备注")
    private String remark;

}