package com.cloud.provider.safe.vo.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.PostAttachment;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class PostAttachmentVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer postAttachmentId;

	private Integer postId;

    private String name;

    private String url;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param postAttachment
     * @return PostAttachmentVo
     */
    public PostAttachmentVo convertToPostAttachmentVo(PostAttachment postAttachment) {
    	PostAttachmentVoConvert convert = new PostAttachmentVoConvert();
    	return convert.doBackward(postAttachment);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<PostAttachmentVo>
     */
    public List<PostAttachmentVo> convertToPostAttachmentVoList(List<PostAttachment> list) {
    	PostAttachmentVoConvert convert = new PostAttachmentVoConvert();
    	List<PostAttachmentVo> postAttachmentVoList = null;
    	PostAttachmentVo postAttachmentVo = null;
    	if(list != null && !list.isEmpty()) {
    		postAttachmentVoList = new ArrayList<PostAttachmentVo>(list.size());
    		ListIterator<PostAttachment> it = list.listIterator();
    		while(it.hasNext()) {
    			PostAttachment postAttachment = it.next();
    			postAttachmentVo = convert.doBackward(postAttachment);
    			postAttachmentVoList.add(postAttachmentVo);
    		}
    	}
    	return postAttachmentVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class PostAttachmentVoConvert extends Converter<PostAttachmentVo, PostAttachment> {

    	@Override
    	protected PostAttachment doForward(PostAttachmentVo postAttachmentVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param postAttachment
    	 * @return PostAttachmentVo
    	 */
		@Override
		protected PostAttachmentVo doBackward(PostAttachment postAttachment) {
			PostAttachmentVo postAttachmentVo = new PostAttachmentVo();
			BeanUtils.copyProperties(postAttachment, postAttachmentVo);
			postAttachmentVo.setPostAttachmentId(postAttachment.getId());
			return postAttachmentVo;
		}

    }

}