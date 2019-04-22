package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserTitle;
import com.cloud.provider.safe.rest.request.page.user.UserTitlePageRequest;
import com.cloud.provider.safe.vo.user.UserTitleVo;
import com.github.pagehelper.Page;

public interface IDangerCheckService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserTitleVo>
	 */
	public List<UserTitleVo> selectListByPage(Page<?> page, UserTitlePageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserTitleVo>
	 */
	public List<UserTitleVo> selectList(UserTitlePageRequest param);

	/**
	 * 根据titleId查询用户职务列表
	 * @param userId
	 * @return List<UserTitle>
	 */
	public List<UserTitle> selectListByTitleId(Integer titleId);

    /**
     * 根据id查询用户职务
     * @param id
     * @return UserTitle
     */
	public UserTitle selectById(Integer id);

	/**
	 * 根据userId查询用户职务
	 * @param userId
	 * @return UserTitle
	 */
	public UserTitle selectByUserId(Integer userId);

    /**
     * 插入用户职务
     * @param userTitle
     * @return Integer
     */
	public Integer insert(UserTitle userTitle);

	/**
  	 * 根据id删除用户职务
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除用户职务
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改用户职务
     * @param userTitle
     * @return Integer
     */
	public Integer modify(UserTitle userTitle);

}