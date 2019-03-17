package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserQuality;
import com.cloud.provider.safe.rest.request.page.UserQualityPageRequest;
import com.github.pagehelper.Page;

public interface IUserQualityService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserQuality>
	 */
	public List<UserQuality> selectUserQualityListByPage(Page<?> page, UserQualityPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserQuality>
	 */
	public List<UserQuality> selectUserQualityList(UserQualityPageRequest param);

    /**
     * 根据id查询用户资质
     * @param id
     * @return UserQuality
     */
	public UserQuality selectUserQualityById(Integer id);

	/**
	 * 根据userId查询用户资质
	 * @param userId
	 * @return UserQuality
	 */
	public UserQuality selectUserQualityByUserId(Integer userId);

    /**
     * 插入用户资质
     * @param userQuality
     * @return Integer
     */
	public Integer insertUserQuality(UserQuality userQuality);

 	/**
  	 * 根据id删除用户资质
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserQualityById(Integer id);

    /**
     * 修改用户资质
     * @param userQuality
     * @return Integer
     */
	public Integer modifyUserQuality(UserQuality userQuality);

}