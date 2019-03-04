package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserPost;
import com.github.pagehelper.Page;

public interface IBootUserPostService {

    /**
	 * 分页查询
	 * @param page
	 * @param userPost
	 * @return List<UserPost>
	 */
	public List<UserPost> selectUserPostListByPage(Page<?> page, UserPost userPost);

	/**
	 * 不分页查询
	 * @param userPost
	 * @return List<UserPost>
	 */
	public List<UserPost> selectUserPostList(UserPost userPost);

    /**
     * 根据id查询用户岗位
     * @param id
     * @return UserPost
     */
	public UserPost selectUserPostById(Integer id);

    /**
     * 插入用户岗位
     * @param userPost
     * @return Integer
     */
	public Integer insertUserPost(UserPost userPost);

    /**
     * 修改用户岗位
     * @param userPost
     * @return Integer
     */
	public Integer modifyUserPost(UserPost userPost);

}