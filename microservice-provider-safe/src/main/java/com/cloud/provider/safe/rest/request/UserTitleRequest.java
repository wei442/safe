package com.cloud.provider.safe.rest.request;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.boot.BootRestRequest;
import com.cloud.provider.safe.po.UserTitle;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserTitleRequest extends BootRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userTitleId;

    private Integer userId;

    private Integer postId;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
	 * 实体转换
	 * @return UserTitle
	 */
	public UserTitle convertToUserTitle() {
		UserTitleConvert convert = new UserTitleConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserTitleConvert extends Converter<UserTitleRequest, UserTitle> {

		@Override
		protected UserTitle doForward(UserTitleRequest userTitleRequest) {
			UserTitle userTitle = new UserTitle();
			BeanUtils.copyProperties(userTitleRequest, userTitle);
			return userTitle;
		}

		@Override
		protected UserTitleRequest doBackward(UserTitle b) {
			return null;
		}

	}

}