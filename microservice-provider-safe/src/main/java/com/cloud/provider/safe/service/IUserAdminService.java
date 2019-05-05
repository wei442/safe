package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserMenu;
import com.cloud.provider.safe.rest.request.page.user.UserAdminPageRequest;
import com.cloud.provider.safe.vo.user.UserAdminVo;
import com.github.pagehelper.Page;

public interface IUserAdminService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<UserAdmin>
	 */
	public List<UserAdminVo> selectListByPage(Page<?> page, UserAdminPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<UserAdmin>
	 */
	public List<UserAdminVo> selectList(UserAdminPageRequest param);

	/**
	 * 根据userId查询用户管理
	 * @param userId
	 * @return UserAdmin
	 */
	public UserAdmin selectByUserId(Integer userId);

	/**
	 * 根据enterpriseId和userId查询用户管理
	 * @param enterpriseId
	 * @param userId
	 * @return UserAdmin
	 */
	public UserAdmin selectByEnterpriseIdUserId(Integer enterpriseId,Integer userId);

	/**
	 * 根据enterpriseId和adminType查询用户管理
	 * @param enterpriseId
	 * @param adminType
	 * @return UserAdmin
	 */
	public UserAdmin selectByEnterpriseIdAdminType(Integer enterpriseId,Integer adminType);

	/**
	 * 根据userId和adminType查询用户管理
	 * @param userId
	 * @param adminType
	 * @return UserAdmin
	 */
	public UserAdmin selectByUserIdAdminType(Integer userId,Integer adminType);

    /**
     * 根据id查询用户管理
     * @param id
     * @return UserAdmin
     */
	public UserAdmin selectById(Integer id);

    /**
     * 插入用户管理
     * @param userAdmin
     * @param userMenuList
     * @return Integer
     */
	public Integer insert(UserAdmin userAdmin,List<UserMenu> userMenuList);

 	/**
  	 * 根据id删除用户管理
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改用户管理
     * @param userAdmin
     * @param userMenuList
     * @return Integer
     */
	public Integer modify(UserAdmin userAdmin,List<UserMenu> userMenuList);

	/**
	 * 更改主管理员
	 * @param oldUserAdmin
	 * @param newUserAdmin
	 * @return Integer
	 */
	public Integer changeAdminMaster(UserAdmin oldUserAdmin,UserAdmin newUserAdmin);

//    /**
//     * 插入子管理员
//     * @param userAdmin
//     * @param userMenuList
//     * @return Integer
//     */
//	public Integer insertAdminSlave(UserAdmin userAdmin,List<UserMenu> userMenuList);
//
//    /**
//     * 修改子管理员
//     * @param userAdmin
//     * @param userMenuList
//     * @return Integer
//     */
//	public Integer modifyAdminSlave(UserAdmin userAdmin,List<UserMenu> userMenuList);

}