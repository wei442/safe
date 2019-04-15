package com.cloud.provider.safe.rest.request.enterprise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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

	@ApiModelProperty(value = "机构资质id")
    @NotNull(message = "机构资质id不能为空", groups = {ModifyGroup.class})
	private Integer orgQualityId;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
	private Integer enterpriseId;

	@ApiModelProperty(value = "机构id")
    @NotNull(message = "机构id不能为空")
    private Integer orgId;

	@ApiModelProperty(value = "机构名称")
    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    @ApiModelProperty(value = "资质名称")
    @NotBlank(message = "资质名称不能为空")
    private String qualityName;

    @ApiModelProperty(value = "机构资质附件列表")
    private List<OrgQualityAttachmentRequest> orgQualityAttachmentList;

    /**
	 * 实体转换
	 * @return OrgQuality
	 */
	public OrgQuality convertToOrgQuality() {
		OrgQualityConvert convert = new OrgQualityConvert();
		return convert.doForward(this);
	}

	/**
     * 实体列表转换
     * @return List<OrgQualityAttachment>
     */
    public List<OrgQualityAttachment> convertToOrgQualityAttachmentList() {
    	OrgQualityAttachmentConvert convert = new OrgQualityAttachmentConvert();
    	List<OrgQualityAttachment> orgQualityAttachmentListNew = null;
    	if(orgQualityAttachmentList != null && !orgQualityAttachmentList.isEmpty()) {
    		orgQualityAttachmentListNew = new ArrayList<OrgQualityAttachment>(orgQualityAttachmentList.size());
    		ListIterator<OrgQualityAttachmentRequest> it = orgQualityAttachmentList.listIterator();
    		while(it.hasNext()) {
    			OrgQualityAttachmentRequest orgQualityAttachmentRequest = it.next();
    			orgQualityAttachmentListNew.add(convert.doForward(orgQualityAttachmentRequest));
    		}
    	}
    	return orgQualityAttachmentListNew;
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