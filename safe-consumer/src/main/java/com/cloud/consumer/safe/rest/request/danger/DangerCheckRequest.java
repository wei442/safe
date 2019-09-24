package com.cloud.consumer.safe.rest.request.danger;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DangerCheckRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构资质id")
    @NotNull(message = "机构资质id不能为空", groups = {UpdateGroup.class})
	private Integer dangerCheckId;

	@ApiModelProperty(value = "机构id")
    @NotNull(message = "机构id不能为空")
    private Integer orgId;

	@ApiModelProperty(value = "机构名称")
    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    private Integer dangerId;

    private String title;

    private Date checkTime;

    private Integer checkUserId;

    private String checkUserAccount;

    private String checkUserName;

}