package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.Enterprise;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EnterprisePageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer enterpriseId;

    private String enterpriseName;

    private Integer enterpriseType;

    private Integer enterpriseNature;

    private Integer enterpriseStatus;

    private String enterpriseAlias;

    private String enterpriseTelphone;

    private Integer enterpriseLevel;

    private String enterpriseFax;

    private String enterpriseEmail;

    private String enterprisePostCode;

    private String enterpriseAddr;

    private String enterpriseWebside;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
	 * 实体转换
	 * @return Enterprise
	 */
	public Enterprise convertToEnterprise() {
		EnterpriseConvert convert = new EnterpriseConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class EnterpriseConvert extends Converter<EnterprisePageRequest, Enterprise> {

		@Override
		protected Enterprise doForward(EnterprisePageRequest enterpriseRequest) {
			Enterprise enterprise = new Enterprise();
			BeanUtils.copyProperties(enterpriseRequest, enterprise);
			return enterprise;
		}

		@Override
		protected EnterprisePageRequest doBackward(Enterprise b) {
			return null;
		}

	}

}