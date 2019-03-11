package com.cloud.provider.safe.rest.request.page;

import com.cloud.provider.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TitlePageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer titleId;

    private Integer enterpriseId;

    private String titleName;

}