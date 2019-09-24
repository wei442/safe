package com.cloud.provider.safe.rest.request.danger;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.DangerCheck;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class DangerCheckRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构资质id")
    @NotNull(message = "机构资质id不能为空", groups = {ModifyGroup.class})
	private Integer dangerCheckId;

	@ApiModelProperty(value = "机构id")
    @NotNull(message = "机构id不能为空")
    private Integer orgId;

	@ApiModelProperty(value = "机构名称")
    @NotBlank(message = "机构名称不能为空")
    private String orgName;

    private Integer dangerId;

    private String title;

    private Date checkTime;

    private Integer checkUserId;

    private String checkUserAccount;

    private String checkUserName;

    /**
	 * 实体转换
	 * @return DangerCheck
	 */
	public DangerCheck convertToDangerCheck() {
		DangerCheckConvert convert = new DangerCheckConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class DangerCheckConvert extends Converter<DangerCheckRequest, DangerCheck> {

		@Override
		protected DangerCheck doForward(DangerCheckRequest dangerCheckRequest) {
			DangerCheck dangerCheck = new DangerCheck();
			BeanUtils.copyProperties(dangerCheckRequest, dangerCheck);
			return dangerCheck;
		}

		@Override
		protected DangerCheckRequest doBackward(DangerCheck b) {
			return null;
		}

	}

}