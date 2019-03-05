package com.cloud.provider.safe.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.BeanUtils;

import com.cloud.provider.safe.po.UserPost;
import com.google.common.base.Converter;

import lombok.Data;

@Data
public class UserPostVo implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Integer userPostId;

    private Integer userId;

    private Integer postId;

    private String created;

    private String updated;

    private Date createTime;

    private Date updateTime;

    /**
     * 实体转换
     * @param userPost
     * @return UserPostVo
     */
    public UserPostVo convertToUserPostVo(UserPost userPost) {
    	UserPostVoConvert convert = new UserPostVoConvert();
    	return convert.doBackward(userPost);
	}

    /**
     * 实体列表转换
     * @param list
     * @return List<UserPostVo>
     */
    public List<UserPostVo> convertToUserPostVoList(List<UserPost> list) {
    	UserPostVoConvert convert = new UserPostVoConvert();
    	List<UserPostVo> userPostVoList = null;
    	UserPostVo userPostVo = null;
    	if(list != null && !list.isEmpty()) {
    		userPostVoList = new ArrayList<UserPostVo>(list.size());
    		ListIterator<UserPost> it = list.listIterator();
    		while(it.hasNext()) {
    			UserPost userPost = it.next();
    			userPostVo = convert.doBackward(userPost);
    			userPostVoList.add(userPostVo);
    		}
    	}
    	return userPostVoList;
    }

	/**
	 * 实体转换
	 * @author wei.yong
	 */
    private class UserPostVoConvert extends Converter<UserPostVo, UserPost> {

    	@Override
    	protected UserPost doForward(UserPostVo userPostVo) {
    		return null;
    	}

    	/**
    	 * 实体转换vo
    	 * @param userPost
    	 * @return UserPostVo
    	 */
		@Override
		protected UserPostVo doBackward(UserPost userPost) {
			UserPostVo userPostVo = new UserPostVo();
			BeanUtils.copyProperties(userPost, userPostVo);
			userPostVo.setUserPostId(userPost.getId());
			return userPostVo;
		}

    }

}