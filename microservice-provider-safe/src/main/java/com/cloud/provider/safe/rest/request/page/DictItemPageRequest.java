package com.cloud.provider.safe.rest.request.page;

import javax.validation.constraints.NotNull;

import com.cloud.provider.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DictItemPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典id", required = true)
	@NotNull(message = "字典id不能为空")
    private Integer dictId;

	@ApiModelProperty(value = "字典子项名称")
    private String itemName;

}