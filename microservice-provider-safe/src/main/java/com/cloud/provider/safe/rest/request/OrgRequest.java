package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构id")
	@NotNull(message = "机构id", groups = {ModifyGroup.class})
	private Integer orgId;

	@ApiModelProperty(value = "企业id")
	@NotNull(message = "企业id")
    private Integer enterpriseId;

    @ApiModelProperty(value = "机构父id")
    @NotNull(message = "机构父id")
    private Integer parentOrgId;

    @ApiModelProperty(value = "机构父名称")
    @NotBlank(message = "机构父名称")
    private String parentOrgName;

    @ApiModelProperty(value = "机构父英文名称")
    private String parentOrgNameEn;

    @ApiModelProperty(value = "机构名称")
    @NotBlank(message = "机构名称")
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

    /**
	 * 实体转换
	 * @return Org
	 */
	public Org convertToOrg() {
		OrgConvert convert = new OrgConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class OrgConvert extends Converter<OrgRequest, Org> {

		@Override
		protected Org doForward(OrgRequest orgRequest) {
			Org org = new Org();
			BeanUtils.copyProperties(orgRequest, org);
			return org;
		}

		@Override
		protected OrgRequest doBackward(Org b) {
			return null;
		}

	}

}