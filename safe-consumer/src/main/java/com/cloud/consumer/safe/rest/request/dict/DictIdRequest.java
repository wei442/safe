package com.cloud.consumer.safe.rest.request.dict;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典id")
    @NotNull(message = "字典id不能为空")
	private Integer dictId;

}