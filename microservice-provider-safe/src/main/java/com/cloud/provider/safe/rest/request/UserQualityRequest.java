package com.cloud.provider.safe.rest.request;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserQuality;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserQualityRequest implements Serializable {

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
	private static class UserQualityConvert extends Converter<UserQualityRequest, UserQuality> {

		@Override
		protected UserQuality doForward(UserQualityRequest userQualityRequest) {
			UserQuality userQuality = new UserQuality();
			BeanUtils.copyProperties(userQualityRequest, userQuality);
			return userQuality;
		}

		@Override
		protected UserQualityRequest doBackward(UserQuality b) {
			return null;
		}

	}

}