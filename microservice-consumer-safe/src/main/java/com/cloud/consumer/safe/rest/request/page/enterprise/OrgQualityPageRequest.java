package com.cloud.consumer.safe.rest.request.page.enterprise;

import com.cloud.consumer.safe.base.BaseRestRequest;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrgQualityPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseQualityId;

    private Integer enterpriseId;

    private Integer qualityId;

}