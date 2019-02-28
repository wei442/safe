package com.cloud.common.constants.base;

/**
 * (base)数据库常量类 SqlBaseConstants
 * @author wei.yong
 * @2017年3月13日 @上午10:22:37
 */
public class SqlBaseConstants {

    /**********************************  基础常量  **********************************/
	/**********************************  基础用户常量  **********************************/
    //用户状态 1-正常, 2-冻结, 3-注销
    public static final Integer SQL_BASE_USER_STATUS_NORMAL = 1;
    public static final Integer SQL_BASE_USER_STATUS_FREEZE = 2;
    public static final Integer SQL_BASE_USER_STATUS_CANCEL = 3;

    //删除标识 0-未删除，1-已删除
    public static final Integer SQL_BASE_USER_IS_DELETE_NO = 0;
    public static final Integer SQL_BASE_USER_IS_DELETE_YES = 1;

    //是否首次登录 0-未登录, 1-已登录
    public static final Integer SQL_BASE_USER_IS_FIRST_LOGIN_NO = 0;
    public static final Integer SQL_BASE_USER_IS_FIRST_LOGIN_YES = 1;
    /**********************************  基础用户常量  **********************************/

    /**********************************  基础角色常量  **********************************/
    //删除标识 0-未删除，1-已删除
    public static final Integer SQL_BASE_ROLE_IS_DELETE_NO = 0;
    public static final Integer SQL_BASE_ROLE_IS_DELETE_YES = 1;
    /**********************************  基础角色常量  **********************************/

    /**********************************  基础菜单常量  **********************************/
    //删除标识 0-未删除，1-已删除
    public static final Integer SQL_BASE_MENU_IS_DELETE_NO = 0;
    public static final Integer SQL_BASE_MENU_IS_DELETE_YES = 1;
    /**********************************  基础菜单常量  **********************************/

    /**********************************  基础用户登录日志常量  **********************************/
    //登录类型 1-登录, 2-退出
    public static final Integer SQL_BASE_USER_LOGIN_LOG_TYPE_LOGIN = 1;
    public static final Integer SQL_BASE_USER_LOGIN_LOG_TYPE_LOGOUT = 2;
    /**********************************  基础用户登录日志常量  **********************************/
    /**********************************  基础常量  **********************************/

}