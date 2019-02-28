package com.cloud.common.constants.base;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础url超类 BaseUrlConstants(boot的url)
 * @author wei.yong
 */
public class BaseUrlConstants {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户
	public final static String wheel_base_user = "/boot/base/user";
	//角色
	public final static String wheel_base_role = "/boot/base/role";
	//菜单
	public final static String wheel_base_menu = "/boot/base/menu";
	//部门
	public final static String wheel_base_dept = "/boot/base/dept";
	//用户角色
	public final static String wheel_base_user_role = "/boot/base/userRole";
	//角色菜单
	public final static String wheel_base_role_menu = "/boot/base/roleMenu";
	//部门用户
	public final static String wheel_base_dept_user = "/boot/base/deptUser";
	//用户登录日志
	public final static String wheel_base_user_loginLog = "/boot/base/user/loginLog";

}