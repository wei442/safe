package com.cloud.provider.safe.rest.request.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserQuality;
import com.cloud.provider.safe.po.UserQualityAttachment;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserQualityRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户资质id")
    @NotNull(message = "用户资质id不能为空", groups = {ModifyGroup.class})
	private Integer userQualityId;

	@ApiModelProperty(value = "企业id")
    @NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "用户id")
    @NotNull(message = "用户id不能为空")
    private Integer userId;

	@ApiModelProperty(value = "用户名称")
    @NotNull(message = "用户名称不能为空")
	private String userName;

    @ApiModelProperty(value = "资质名称")
    @NotBlank(message = "资质名称不能为空")
    private String qualityName;

    @ApiModelProperty(value = "用户资质附件ids")
    private List<Integer> userQualityAttachmentIds;

    @ApiModelProperty(value = "新用户资质附件列表")
    private List<UserQualityAttachmentRequest> userQualityAttachmentList;

    /**
	 * 实体转换
	 * @return UserQuality
	 */
	public UserQuality convertToUserQuality() {
		UserQualityConvert convert = new UserQualityConvert();
		return convert.doForward(this);
	}

    /**
     * 实体列表转换
     * @return List<UserQualityAttachment>
     */
    public List<UserQualityAttachment> convertToUserQualityAttachmentList() {
    	UserQualityAttachmentConvert convert = new UserQualityAttachmentConvert();
    	List<UserQualityAttachment> userQualityAttachmentListNew = null;
    	if(userQualityAttachmentList != null && !userQualityAttachmentList.isEmpty()) {
    		userQualityAttachmentListNew = new ArrayList<UserQualityAttachment>(userQualityAttachmentList.size());
    		ListIterator<UserQualityAttachmentRequest> it = userQualityAttachmentList.listIterator();
    		while(it.hasNext()) {
    			UserQualityAttachmentRequest userQualityAttachmentRequest = it.next();
    			userQualityAttachmentListNew.add(convert.doForward(userQualityAttachmentRequest));
    		}
    	}
    	return userQualityAttachmentListNew;
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

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class UserQualityAttachmentConvert extends Converter<UserQualityAttachmentRequest, UserQualityAttachment> {

		@Override
		protected UserQualityAttachment doForward(UserQualityAttachmentRequest userQualityAttachmentRequest) {
			UserQualityAttachment userQualityAttachment = new UserQualityAttachment();
			BeanUtils.copyProperties(userQualityAttachmentRequest, userQualityAttachment);
			return userQualityAttachment;
		}

		@Override
		protected UserQualityAttachmentRequest doBackward(UserQualityAttachment b) {
			return null;
		}

	}

}