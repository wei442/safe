package com.cloud.consumer.safe.rest.request.page.user;

import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.base.BaseRestRequest;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserQualityAttachmentPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseId;

	@ApiModelProperty(value = "用户资质id")
    @NotNull(message = "用户资质id不能为空")
	private Integer userQualityId;

}