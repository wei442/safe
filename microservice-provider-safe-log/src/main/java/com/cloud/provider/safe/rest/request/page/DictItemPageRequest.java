package com.cloud.provider.safe.rest.request.page;

import com.cloud.provider.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class DictItemPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer dictItemId;

    private Integer enterpriseId;

    private Integer dictId;

    private String itemName;

    private String itemAlias;

    private Integer itemLevel;

    private Integer itemStatus;


}