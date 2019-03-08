package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Org;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class OrgRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer orgId;

    private Integer enterpriseId;

    private Integer parentOrgId;

    private String parentOrgName;

    private String parentOrgNameEn;

    private String orgName;

    private String orgNameEn;

    private String orgAlias;

    private String orgTelphone;

    private Integer orgType;

    private Integer orgStatus;

    private Integer orgLevel;

    private String orgFax;

    private String orgEmail;

    private String orgPostCode;

    private String orgAddr;

    private String orgWebside;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

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