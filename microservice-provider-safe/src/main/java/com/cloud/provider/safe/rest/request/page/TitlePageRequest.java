package com.cloud.provider.safe.rest.request.page;

import java.util.Date;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.base.BaseRestRequest;
import com.cloud.provider.safe.po.Title;
import com.google.common.base.Converter;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TitlePageRequest extends BaseRestRequest {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer titleId;

    private Integer enterpriseId;

    private String titleName;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

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
	private static class TitleConvert extends Converter<TitlePageRequest, Title> {

		@Override
		protected Title doForward(TitlePageRequest TitleRequest) {
			Title Title = new Title();
			BeanUtils.copyProperties(TitleRequest, Title);
			return Title;
		}

		@Override
		protected TitlePageRequest doBackward(Title b) {
			return null;
		}

	}

}