package com.cloud.consumer.safe.rest.request.user;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户资质id")
    @NotNull(message = "用户资质id不能为空", groups = {UpdateGroup.class})
	private Integer userQualityId;

	private Integer enterpriseId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "用户名称")
    @NotNull(message = "用户名称不能为空")
	private String userName;

    @ApiModelProperty(value = "资质名称")
    @NotBlank(message = "资质名称不能为空")
    private String qualityName;

    @ApiModelProperty(value = "用户资质附件ids")
    private List<Integer> userQualityAttachmentIds;

    @ApiModelProperty(value = "新用户资质附件列表")
    private List<UserQualityAttachmentRequest> userQualityAttachmentList;

}