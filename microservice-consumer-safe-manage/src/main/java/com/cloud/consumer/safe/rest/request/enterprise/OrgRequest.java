package com.cloud.consumer.safe.rest.request.enterprise;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构id")
	@NotNull(message = "机构id不能为空", groups = {UpdateGroup.class})
	private Integer orgId;

    private Integer enterpriseId;

    @ApiModelProperty(value = "机构父id")
    @NotNull(message = "机构父id不能为空")
    private Integer parentOrgId;

    @ApiModelProperty(value = "机构父名称")
    @NotBlank(message = "机构父名称不能为空")
    private String parentOrgName;

    @ApiModelProperty(value = "机构父英文名称")
    private String parentOrgNameEn;

    @ApiModelProperty(value = "机构名称")
    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    @ApiModelProperty(value = "机构英文名称")
    private String orgNameEn;

    @ApiModelProperty(value = "机构别名")
    private String orgAlias;

    @ApiModelProperty(value = "机构电话")
    private String orgTelphone;

    @ApiModelProperty(value = "机构传真")
    private String orgFax;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

}