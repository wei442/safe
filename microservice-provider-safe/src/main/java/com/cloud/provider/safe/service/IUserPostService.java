package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserPost;
import com.cloud.provider.safe.rest.request.page.UserPostPageRequest;
import com.cloud.provider.safe.vo.UserPostVo;
import com.github.pagehelper.Page;

public interface IUserPostService {
    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserPostVo>
	 */
	public List<UserPostVo> selectListByPage(Page<?> page, UserPostPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserPostVo>
	 */
	public List<UserPostVo> selectList(UserPostPageRequest param);

    /**
     * 根据id查询用户岗位
     * @param id
     * @return UserPost
     */
	public UserPost selectById(Integer id);

	/**
	 * 根据userId查询用户岗位
	 * @param userId
	 * @return UserPost
	 */
	public UserPost selectByUserId(Integer userId);

    /**
     * 插入用户岗位
     * @param userPost
     * @return Integer
     */
	public Integer insert(UserPost userPost);

 	/**
  	 * 根据id删除用户岗位
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

	/**
  	 * 根据ids删除用户岗位
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改用户岗位
     * @param userPost
     * @return Integer
     */
	public Integer modify(UserPost userPost);

}