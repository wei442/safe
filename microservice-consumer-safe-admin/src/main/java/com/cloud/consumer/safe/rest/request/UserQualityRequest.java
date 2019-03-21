package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户资质id", required = true)
    @NotNull(message = "用户资质id", groups = {UpdateGroup.class})
	private Integer userQualityId;

	@ApiModelProperty(value = "用户id", required = true)
    @NotNull(message = "用户id")
    private Integer userId;

	@ApiModelProperty(value = "资质id", required = true)
    @NotNull(message = "资质id")
    private Integer qualityId;

	@ApiModelProperty(value = "备注")
    private String remark;

}