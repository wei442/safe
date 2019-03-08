package com.cloud.provider.safe.rest.request;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Enterprise;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class EnterpriseRequest implements Serializable {

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

    private String remark;

    private Integer sort;

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
	private static class EnterpriseConvert extends Converter<EnterpriseRequest, Enterprise> {

		@Override
		protected Enterprise doForward(EnterpriseRequest enterpriseRequest) {
			Enterprise enterprise = new Enterprise();
			BeanUtils.copyProperties(enterpriseRequest, enterprise);
			return enterprise;
		}

		@Override
		protected EnterpriseRequest doBackward(Enterprise b) {
			return null;
		}

	}

}