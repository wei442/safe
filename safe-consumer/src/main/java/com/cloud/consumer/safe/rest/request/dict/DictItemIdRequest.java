package com.cloud.consumer.safe.rest.request.dict;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DictItemIdRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "字典子项id")
    @NotNull(message = "字典子项id不能为空")
	private Integer dictItemId;

}