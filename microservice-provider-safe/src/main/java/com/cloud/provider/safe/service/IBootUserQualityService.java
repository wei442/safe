package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserQuality;
import com.github.pagehelper.Page;

public interface IBootUserQualityService {

	 /**
	 * 分页查询
	 * @param page
	 * @param userQuality
	 * @return List<UserQuality>
	 */
	public List<UserQuality> selectUserQualityListByPage(Page<?> page, UserQuality userQuality);

	/**
	 * 不分页查询
	 * @param userQuality
	 * @return List<UserQuality>
	 */
	public List<UserQuality> selectUserQualityList(UserQuality userQuality);

    /**
     * 根据id查询用户资质
     * @param id
     * @return UserQuality
     */
	public UserQuality selectUserQualityById(Integer id);

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