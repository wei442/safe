package com.cloud.consumer.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构资质id", required = true)
    @NotNull(message = "机构资质id不能为空", groups = {UpdateGroup.class})
	private Integer orgQualityId;

	private Integer enterpriseId;

	@ApiModelProperty(value = "机构id", required = true)
    @NotNull(message = "机构id不能为空")
    private Integer orgId;

	@ApiModelProperty(value = "机构名称", required = true)
    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    @ApiModelProperty(value = "资质名称", required = true)
    @NotBlank(message = "资质名称不能为空")
    private String qualityName;

}