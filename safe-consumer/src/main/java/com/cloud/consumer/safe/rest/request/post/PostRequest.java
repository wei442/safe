package com.cloud.consumer.safe.rest.request.post;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.cloud.consumer.safe.rest.request.activity.RuleAttachmentRequest;
import com.cloud.consumer.safe.validator.group.UpdateGroup;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PostRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "岗位id")
	@NotNull(message = "岗位id不能为空", groups = {UpdateGroup.class})
	private Integer postId;

    private Integer enterpriseId;

	@ApiModelProperty(value = "岗位名称")
	@NotBlank(message = "岗位名称不能为空")
    private String postName;

	@ApiModelProperty(value = "是否特殊岗位 0-否, 1-是")
    private Integer isSpecial;

	@ApiModelProperty(value = "特殊岗位备注")
    private String specialRemark;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "规范文件附件列表")
    private List<RuleAttachmentRequest> ruleAttachmentList;

}