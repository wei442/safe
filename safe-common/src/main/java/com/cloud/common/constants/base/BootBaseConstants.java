package com.cloud.common.constants.base;

import com.cloud.common.constants.BootConstants;

/**
 * boot方向盘返回错误码 BootBaseConstants
 * @author wei.yong
 * @2017年03月02日
 */
public class BootBaseConstants extends BootConstants {

	/*--------------------------------------- boot系统统一错误编码 --------------------------------------------*/
    /*----------------------------- 用户boot错误编码(10010开头) -----------------------------*/
    /**
     * 错误编码-传入参数为空
     */
	public final static String BASE_FIELD_EMPTY = "10010001";
    /**
     * 只是显示
     */
    public final static String BASE_FIELD_EMPTY_MSG = "传入参数为空";
    /**
	 * 错误编码-不是JSON格式
	 */
	public final static String BASE_CONTENT_NOTJSON = "10010002";
	/**
	 * 错误描述-不是JSON格式
	 */
	public final static String BASE_CONTENT_NOTJSON_MSG = "不是JSON格式";
    /*----------------------------- 方向盘信息boot错误编码(10010开头) -----------------------------*/

    /*----------------------------- 基础信息-基础用户信息boot错误编码(10011开头) -----------------------------*/
    /**
     * 错误编码-用户不存在
     */
    public final static String BASE_BASE_USER_ENTITY_NOTEXIST = "10011001";
    /**
     * 错误描述-用户不存在
     */
    public final static String BASE_BASE_USER_ENTITY_NOTEXIST_MSG = "用户不存在";
    /**
     * 错误编码-用户已存在
     */
    public final static String BASE_BASE_USER_ENTITY_EXIST = "10011002";
    /**
     * 错误描述-用户已存在
     */
    public final static String BASE_BASE_USER_ENTITY_EXIST_MSG = "用户已存在";

    /**
     * 错误编码-用户列表不存在
     */
    public final static String BASE_BASE_USER_LIST_NOTEXIST = "10011003";
    /**
     * 错误描述-用户列表不存在
     */
    public final static String BASE_BASE_USER_LIST_NOTEXIST_MSG = "用户列表不存在";
    /**
     * 错误编码-用户列表已存在
     */
    public final static String BASE_BASE_USER_LIST_EXIST = "10011004";
    /**
     * 错误描述-用户列表已存在
     */
    public final static String BASE_BASE_USER_LIST_EXIST_MSG = "用户列表已存在";

    /**
     * 错误编码-用户账户已存在
     */
    public final static String BASE_BASE_USER_ACCOUNT_ENTITY_EXIST = "10011005";
    /**
     * 错误描述-用户账户已存在
     */
    public final static String BASE_BASE_USER_ACCOUNT_ENTITY_EXIST_MSG = "用户账户已存在";

    /**
     * 错误编码-用户密码错误
     */
    public final static String BASE_BASE_USER_PASSWORD_ERROR = "10011006";
    /**
     * 错误描述-用户密码错误
     */
    public final static String BASE_BASE_USER_PASSWORD_ERROR_MSG = "用户密码错误";

    /**
     * 错误编码-两次密码不一致
     */
    public final static String BASE_BASE_USER_TWO_PASSWORD_NOTEQUAL = "10011007";
    /**
     * 错误描述-两次密码不一致
     */
    public final static String BASE_BASE_USER_TWO_PASSWORD_NOTEQUAL_MSG = "两次密码不一致";

    /**
     * 错误编码-老密码和新密码不一致
     */
    public final static String BASE_BASE_USER_OLD_NEW_PASSWORD_NOTEQUAL = "10011007";
    /**
     * 错误描述-老密码和新密码不一致
     */
    public final static String BASE_BASE_USER_OLD_NEW_PASSWORD_NOTEQUAL_MSG = "老密码和新密码不一致";
    /*----------------------------- 基础信息-基础用户信息boot错误编码(10011开头) -----------------------------*/

    /*----------------------------- 基础信息-基础角色信息boot错误编码(10012开头) -----------------------------*/
    /**
     * 错误编码-角色不存在
     */
    public final static String BASE_BASE_ROLE_ENTITY_NOTEXIST = "10012001";
    /**
     * 错误描述-角色不存在
     */
    public final static String BASE_BASE_ROLE_ENTITY_NOTEXIST_MSG = "角色不存在";
    /**
     * 错误编码-角色已存在
     */
    public final static String BASE_BASE_ROLE_ENTITY_EXIST = "10012002";
    /**
     * 错误描述-角色已存在
     */
    public final static String BASE_BASE_ROLE_ENTITY_EXIST_MSG = "用户已存在";

    /**
     * 错误编码-角色列表不存在
     */
    public final static String BASE_BASE_ROLE_LIST_NOTEXIST = "10012003";
    /**
     * 错误描述-角色列表不存在
     */
    public final static String BASE_BASE_ROLE_LIST_NOTEXIST_MSG = "角色列表不存在";
    /**
     * 错误编码-角色列表已存在
     */
    public final static String BASE_BASE_ROLE_LIST_EXIST = "10012004";
    /**
     * 错误描述-角色列表已存在
     */
    public final static String BASE_BASE_ROLE_LIST_EXIST_MSG = "角色列表已存在";
    /*----------------------------- 基础信息-基础角色信息boot错误编码(10012开头) -----------------------------*/

    /*----------------------------- 基础信息-基础菜单信息boot错误编码(10013开头) -----------------------------*/
    /**
     * 错误编码-菜单不存在
     */
    public final static String BASE_BASE_MENU_ENTITY_NOTEXIST = "10013001";
    /**
     * 错误描述-菜单不存在
     */
    public final static String BASE_BASE_MENU_ENTITY_NOTEXIST_MSG = "菜单不存在";
    /**
     * 错误编码-菜单已存在
     */
    public final static String BASE_BASE_MENU_ENTITY_EXIST = "10013002";
    /**
     * 错误描述-菜单已存在
     */
    public final static String BASE_BASE_MENU_ENTITY_EXIST_MSG = "菜单已存在";

    /**
     * 错误编码-菜单列表不存在
     */
    public final static String BASE_BASE_MENU_LIST_NOTEXIST = "10013003";
    /**
     * 错误描述-菜单列表不存在
     */
    public final static String BASE_BASE_MENU_LIST_NOTEXIST_MSG = "菜单列表不存在";
    /**
     * 错误编码-菜单列表已存在
     */
    public final static String BASE_BASE_MENU_LIST_EXIST = "10013004";
    /**
     * 错误描述-菜单列表已存在
     */
    public final static String BASE_BASE_MENU_LIST_EXIST_MSG = "菜单列表已存在";
    /*----------------------------- 基础信息-基础菜单信息boot错误编码(10013开头) -----------------------------*/

    /*----------------------------- 基础信息-基础用户角色信息boot错误编码(10014开头) -----------------------------*/
    /**
     * 错误编码-用户角色不存在
     */
    public final static String BASE_BASE_USER_ROLE_ENTITY_NOTEXIST = "10014001";
    /**
     * 错误描述-用户角色不存在
     */
    public final static String BASE_BASE_USER_ROLE_ENTITY_NOTEXIST_MSG = "用户角色不存在";
    /**
     * 错误编码-用户角色已存在
     */
    public final static String BASE_BASE_USER_ROLE_ENTITY_EXIST = "10014002";
    /**
     * 错误描述-用户角色已存在
     */
    public final static String BASE_BASE_USER_ROLE_ENTITY_EXIST_MSG = "用户角色已存在";

    /**
     * 错误编码-用户角色列表不存在
     */
    public final static String BASE_BASE_USER_ROLE_LIST_NOTEXIST = "10014003";
    /**
     * 错误描述-用户角色列表不存在
     */
    public final static String BASE_BASE_USER_ROLE_LIST_NOTEXIST_MSG = "用户角色列表不存在";
    /**
     * 错误编码-用户角色列表已存在
     */
    public final static String BASE_BASE_USER_ROLE_LIST_EXIST = "10014004";
    /**
     * 错误描述-用户角色列表已存在
     */
    public final static String BASE_BASE_USER_ROLE_LIST_EXIST_MSG = "用户角色列表已存在";
    /*----------------------------- 基础信息-基础用户角色信息boot错误编码(10014开头) -----------------------------*/

    /*----------------------------- 基础信息-基础角色菜单信息boot错误编码(10015开头) -----------------------------*/
    /**
     * 错误编码-角色菜单不存在
     */
    public final static String BASE_BASE_ROLE_MENU_ENTITY_NOTEXIST = "10015001";
    /**
     * 错误描述-角色菜单不存在
     */
    public final static String BASE_BASE_ROLE_MENU_ENTITY_NOTEXIST_MSG = "角色菜单不存在";
    /**
     * 错误编码-角色菜单已存在
     */
    public final static String BASE_BASE_ROLE_MENU_ENTITY_EXIST = "10015002";
    /**
     * 错误描述-角色菜单已存在
     */
    public final static String BASE_BASE_ROLE_MENU_ENTITY_EXIST_MSG = "角色菜单已存在";

    /**
     * 错误编码-角色菜单列表不存在
     */
    public final static String BASE_BASE_ROLE_MENU_LIST_NOTEXIST = "10015003";
    /**
     * 错误描述-角色菜单列表不存在
     */
    public final static String BASE_BASE_ROLE_MENU_LIST_NOTEXIST_MSG = "角色菜单列表不存在";
    /**
     * 错误编码-角色菜单列表已存在
     */
    public final static String BASE_BASE_ROLE_MENU_LIST_EXIST = "10015004";
    /**
     * 错误描述-角色菜单列表已存在
     */
    public final static String BASE_BASE_ROLE_MENU_LIST_EXIST_MSG = "角色菜单列表已存在";
    /*----------------------------- 基础信息-基础角色菜单信息boot错误编码(10015开头) -----------------------------*/

    /*----------------------------- 基础信息-基础部门信息boot错误编码(10016开头) -----------------------------*/
    /**
     * 错误编码-部门不存在
     */
    public final static String BASE_BASE_DEPT_ENTITY_NOTEXIST = "10016001";
    /**
     * 错误描述-部门不存在
     */
    public final static String BASE_BASE_DEPT_ENTITY_NOTEXIST_MSG = "部门不存在";
    /**
     * 错误编码-菜单已存在
     */
    public final static String BASE_BASE_DEPT_ENTITY_EXIST = "10016002";
    /**
     * 错误描述-部门已存在
     */
    public final static String BASE_BASE_DEPT_ENTITY_EXIST_MSG = "部门已存在";

    /**
     * 错误编码-部门列表不存在
     */
    public final static String BASE_BASE_DEPT_LIST_NOTEXIST = "10016003";
    /**
     * 错误描述-部门列表不存在
     */
    public final static String BASE_BASE_DEPT_LIST_NOTEXIST_MSG = "部门列表不存在";
    /**
     * 错误编码-部门列表已存在
     */
    public final static String BASE_BASE_DEPT_LIST_EXIST = "10016004";
    /**
     * 错误描述-部门列表已存在
     */
    public final static String BASE_BASE_DEPT_LIST_EXIST_MSG = "部门列表已存在";
    /*----------------------------- 基础信息-基础部门信息boot错误编码(10016开头) -----------------------------*/

    /*----------------------------- 基础信息-基础部门用户信息boot错误编码(10017开头) -----------------------------*/
    /**
     * 错误编码-部门用户不存在
     */
    public final static String BASE_BASE_DEPT_USER_ENTITY_NOTEXIST = "10017001";
    /**
     * 错误描述-部门用户不存在
     */
    public final static String BASE_BASE_DEPT_USER_ENTITY_NOTEXIST_MSG = "部门用户不存在";
    /**
     * 错误编码-部门用户已存在
     */
    public final static String BASE_BASE_DEPT_USER_ENTITY_EXIST = "10017002";
    /**
     * 错误描述-部门用户已存在
     */
    public final static String BASE_BASE_DEPT_USER_ENTITY_EXIST_MSG = "部门用户已存在";

    /**
     * 错误编码-部门用户列表不存在
     */
    public final static String BASE_BASE_DEPT_USER_LIST_NOTEXIST = "10017003";
    /**
     * 错误描述-部门用户列表不存在
     */
    public final static String BASE_BASE_DEPT_USER_LIST_NOTEXIST_MSG = "部门用户列表不存在";
    /**
     * 错误编码-部门用户列表已存在
     */
    public final static String BASE_BASE_DEPT_USER_LIST_EXIST = "10017004";
    /**
     * 错误描述-部门用户列表已存在
     */
    public final static String BASE_BASE_DEPT_USER_LIST_EXIST_MSG = "部门用户列表已存在";
    /*----------------------------- 基础信息-基础部门用户信息boot错误编码(10017开头) -----------------------------*/

    /*----------------------------- 基础信息-基础用户登录日志信息boot错误编码(10018开头) -----------------------------*/
    /**
     * 错误编码-用户登录日志不存在
     */
    public final static String BASE_BASE_USER_LOGIN_LOG_ENTITY_NOTEXIST = "10018001";
    /**
     * 错误描述-用户登录日志不存在
     */
    public final static String BASE_BASE_USER_LOGIN_LOG_ENTITY_NOTEXIST_MSG = "用户登录日志不存在";
    /**
     * 错误编码-用户登录日志已存在
     */
    public final static String BASE_BASE_USER_LOGIN_LOG_ENTITY_EXIST = "10018002";
    /**
     * 错误描述-用户登录日志已存在
     */
    public final static String BASE_BASE_USER_LOGIN_LOG_ENTITY_EXIST_MSG = "用户登录日志已存在";

    /**
     * 错误编码-用户登录日志列表不存在
     */
    public final static String BASE_BASE_USER_LOGIN_LOG_LIST_NOTEXIST = "10018003";
    /**
     * 错误描述-用户登录日志列表不存在
     */
    public final static String BASE_BASE_USER_LOGIN_LOG_LIST_NOTEXIST_MSG = "用户登录日志列表不存在";
    /**
     * 错误编码-用户登录日志列表已存在
     */
    public final static String BASE_BASE_USER_LOGIN_LOG_LIST_EXIST = "10018004";
    /**
     * 错误描述-用户登录日志列表已存在
     */
    public final static String BASE_BASE_USER_LOGIN_LOG_LIST_EXIST_MSG = "用户登录日志列表已存在";
    /*----------------------------- 基础信息-基础用户登录日志信息boot错误编码(10018开头) -----------------------------*/
    /*--------------------------------------- boot系统统一错误编码 --------------------------------------------*/

}