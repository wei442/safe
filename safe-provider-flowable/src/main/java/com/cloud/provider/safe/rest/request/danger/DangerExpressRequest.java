package com.cloud.provider.safe.rest.request.danger;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.provider.safe.validator.group.ModifyGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DangerExpressRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构资质id")
    @NotNull(message = "机构资质id不能为空", groups = {ModifyGroup.class})
	private Integer dangerId;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
	private Integer enterpriseId;

	@ApiModelProperty(value = "机构id")
    @NotNull(message = "机构id不能为空")
    private Integer orgId;

	@ApiModelProperty(value = "机构名称")
    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    private String dangerSite;

    private Integer dangerLevel;

    private String dangerCategory;

    private String dangerSubCategory;

    private Date dangerTime;

    private String dangerDesc;

    private Integer dangerUserId;

    private String dangeUserAccount;

    private String dangeUserName;

    @ApiModelProperty(value = "机构资质ids")
    private List<Integer> dangerAttachmentIds;

    @ApiModelProperty(value = "新机构资质附件列表")
    private List<DangerAttachmentRequest> dangerAttachmentList;

}