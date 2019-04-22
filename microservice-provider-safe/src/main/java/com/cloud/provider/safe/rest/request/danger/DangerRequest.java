package com.cloud.provider.safe.rest.request.danger;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Danger;
import com.cloud.provider.safe.po.DangerAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DangerRequest implements Serializable {

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

    /**
	 * 实体转换
	 * @return Danger
	 */
	public Danger convertToDanger() {
		DangerConvert convert = new DangerConvert();
		return convert.doForward(this);
	}

	/**
     * 实体列表转换
     * @return List<DangerAttachment>
     */
    public List<DangerAttachment> convertToDangerAttachmentList() {
    	DangerAttachmentConvert convert = new DangerAttachmentConvert();
    	List<DangerAttachment> dangerAttachmentListNew = null;
    	if(dangerAttachmentList != null && !dangerAttachmentList.isEmpty()) {
    		dangerAttachmentListNew = new ArrayList<DangerAttachment>(dangerAttachmentList.size());
    		ListIterator<DangerAttachmentRequest> it = dangerAttachmentList.listIterator();
    		while(it.hasNext()) {
    			DangerAttachmentRequest dangerAttachmentRequest = it.next();
    			dangerAttachmentListNew.add(convert.doForward(dangerAttachmentRequest));
    		}
    	}
    	return dangerAttachmentListNew;
    }

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class DangerConvert extends Converter<DangerRequest, Danger> {

		@Override
		protected Danger doForward(DangerRequest dangerRequest) {
			Danger danger = new Danger();
			BeanUtils.copyProperties(dangerRequest, danger);
			return danger;
		}

		@Override
		protected DangerRequest doBackward(Danger b) {
			return null;
		}

	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class DangerAttachmentConvert extends Converter<DangerAttachmentRequest, DangerAttachment> {

		@Override
		protected DangerAttachment doForward(DangerAttachmentRequest dangerAttachmentRequest) {
			DangerAttachment dangerAttachment = new DangerAttachment();
			BeanUtils.copyProperties(dangerAttachmentRequest, dangerAttachment);
			return dangerAttachment;
		}

		@Override
		protected DangerAttachmentRequest doBackward(DangerAttachment b) {
			return null;
		}

	}

}