package com.cloud.provider.safe.rest.request.enterprise;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.OrgQuality;
import com.cloud.provider.safe.po.OrgQualityAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构资质id", required = true)
    @NotNull(message = "机构资质id不能为空", groups = {ModifyGroup.class})
	private Integer orgQualityId;

	@ApiModelProperty(value = "企业id", required = true)
    @NotNull(message = "企业id不能为空")
	private Integer enterpriseId;

	@ApiModelProperty(value = "机构id", required = true)
    @NotNull(message = "机构id不能为空")
    private Integer orgId;

	@ApiModelProperty(value = "机构名称", required = true)
    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    @ApiModelProperty(value = "附件id", required = true)
    @NotNull(message = "附件id不能为空")
    private Integer attachmentId;

    @ApiModelProperty(value = "附件url", required = true)
    @NotBlank(message = "附件url不能为空")
    private String attachmentUrl;

    @ApiModelProperty(value = "资质名称", required = true)
    @NotBlank(message = "资质名称不能为空")
    private String qualityName;

    private List<OrgQualityAttachment> orgQualityAttachments;

    /**
	 * 实体转换
	 * @return OrgQuality
	 */
	public OrgQuality convertToOrgQuality() {
		OrgQualityConvert convert = new OrgQualityConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class OrgQualityConvert extends Converter<OrgQualityRequest, OrgQuality> {

		@Override
		protected OrgQuality doForward(OrgQualityRequest orgQualityRequest) {
			OrgQuality orgQuality = new OrgQuality();
			BeanUtils.copyProperties(orgQualityRequest, orgQuality);
			return orgQuality;
		}

		@Override
		protected OrgQualityRequest doBackward(OrgQuality b) {
			return null;
		}

	}

}