package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.UserQuality;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserQualityPageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userQualityId;

    private Integer userId;

    private Integer qualityId;

    private Integer isDelete;

    private String remark;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
	 * 实体转换
	 * @return UserQuality
	 */
	public UserQuality convertToUserQuality() {
		UserQualityConvert convert = new UserQualityConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserQualityConvert extends Converter<UserQualityPageRequest, UserQuality> {

		@Override
		protected UserQuality doForward(UserQualityPageRequest userQualityRequest) {
			UserQuality userQuality = new UserQuality();
			BeanUtils.copyProperties(userQualityRequest, userQuality);
			return userQuality;
		}

		@Override
		protected UserQualityPageRequest doBackward(UserQuality b) {
			return null;
		}

	}

}