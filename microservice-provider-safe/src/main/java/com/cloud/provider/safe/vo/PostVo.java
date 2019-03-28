package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.alibaba.fastjson.annotation.JSONField;
import com.cloud.common.dateformat.DateFormatConstants;
import com.cloud.provider.safe.po.Post;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class PostVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer postId;

    private Integer enterpriseId;

    private String postName;

    private Integer isSpecial;

    private String specialRemark;

    private Integer isDelete;

    private String remark;

    private Integer sort;

    private String created;

    private String updated;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date createTime;

    @JSONField(format=DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)
    private Date updateTime;

    /**
     * 实体转换
     * @param post
     * @return PostVo
     */
    public PostVo convertToPostVo(Post post) {
    	PostVoConvert convert = new PostVoConvert();
    	return convert.doBackward(post);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<PostVo>
     */
    public List<PostVo> convertToPostVoList(List<Post> list) {
    	PostVoConvert convert = new PostVoConvert();
    	List<PostVo> postVoList = null;
    	PostVo postVo = null;
    	if(list != null && !list.isEmpty()) {
    		postVoList = new ArrayList<PostVo>(list.size());
    		ListIterator<Post> it = list.listIterator();
    		while(it.hasNext()) {
    			Post post = it.next();
    			postVo = convert.doBackward(post);
    			postVoList.add(postVo);
    		}
    	}
    	return postVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class PostVoConvert extends Converter<PostVo, Post> {

    	@Override
    	protected Post doForward(PostVo postVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param post
    	 * @return PostVo
    	 */
		@Override
		protected PostVo doBackward(Post post) {
			PostVo postVo = new PostVo();
			BeanUtils.copyProperties(post, postVo);
			postVo.setPostId(post.getId());
			return postVo;
		}

    }

}