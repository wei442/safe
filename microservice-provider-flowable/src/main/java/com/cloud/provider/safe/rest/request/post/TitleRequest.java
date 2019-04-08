package com.cloud.provider.safe.rest.request.post;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.Title;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.google.common.base.Converter;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TitleRequest implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "职务id")
	@NotNull(message = "职务id不能为空", groups = {ModifyGroup.class})
	private Integer titleId;

	@ApiModelProperty(value = "企业id")
	@NotNull(message = "企业id不能为空")
    private Integer enterpriseId;

	@ApiModelProperty(value = "职务名称")
	@NotBlank(message = "职务名称不能为空")
    private String titleName;

	@ApiModelProperty(value = "备注")
    private String remark;

	@ApiModelProperty(value = "排序")
    private Integer sort;

    /**
	 * 实体转换
	 * @return Title
	 */
	public Title convertToTitle() {
		TitleConvert convert = new TitleConvert();
		return convert.doForward(this);
	}

	/**
	 * req转换实体
	 * @author wei.yong
	 */
	private static class TitleConvert extends Converter<TitleRequest, Title> {

		@Override
		protected Title doForward(TitleRequest TitleRequest) {
			Title Title = new Title();
			BeanUtils.copyProperties(TitleRequest, Title);
			return Title;
		}

		@Override
		protected TitleRequest doBackward(Title b) {
			return null;
		}

	}

}