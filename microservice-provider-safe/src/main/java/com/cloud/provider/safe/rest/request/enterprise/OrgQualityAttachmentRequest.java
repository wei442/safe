package com.cloud.provider.safe.rest.request.enterprise;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.OrgQualityAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgQualityAttachmentRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构资质附件id", required = true)
    @NotNull(message = "机构资质附件id不能为空", groups = {ModifyGroup.class})
    private Integer orgQualityAttachmentId;

    @ApiModelProperty(value = "机构资质id", required = true)
    @NotNull(message = "机构资质id不能为空")
	private Integer orgQualityId;

	@ApiModelProperty(value = "附件url", required = true)
    @NotNull(message = "附件url不能为空")
    private String attachmentUrl;

    /**
	 * 实体转换
	 * @return OrgQualityAttachment
	 */
	public OrgQualityAttachment convertToOrgQualityAttachment() {
		OrgQualityAttachmentConvert convert = new OrgQualityAttachmentConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class OrgQualityAttachmentConvert extends Converter<OrgQualityAttachmentRequest, OrgQualityAttachment> {

		@Override
		protected OrgQualityAttachment doForward(OrgQualityAttachmentRequest orgQualityAttachmentRequest) {
			OrgQualityAttachment orgQualityAttachment = new OrgQualityAttachment();
			BeanUtils.copyProperties(orgQualityAttachmentRequest, orgQualityAttachment);
			return orgQualityAttachment;
		}

		@Override
		protected OrgQualityAttachmentRequest doBackward(OrgQualityAttachment b) {
			return null;
		}

	}

}