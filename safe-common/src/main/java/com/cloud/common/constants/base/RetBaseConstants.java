package com.cloud.common.constants.base;

import com.cloud.common.constants.RetConstants;

/**
 * base返回错误码-返回给app
 * @author wei.yong
 * @2017年04月24日
 */
public class RetBaseConstants extends RetConstants {

	//webtoken
	public static final String WEBTOKEN = "webtoken";

	//base
	public static final String BASE = "base";

	public static final String BASE_USER_ID = "baseUserId";
	public static final String USER_ACCOUNT = "userAccount";
	public static final String USER_NAME = "userName";

	/*--------------------------- 返回app错误码  -----------------------------*/
	/**
	 * 错误编码-服务不可用
	 */
	public static final String SYSTEM_ERROR = "0000001";
	/**
	 * 错误描述-服务不可用
	 */
	public static final String SYSTEM_ERROR_MSG = "当前系统繁忙，请稍后再试";
	/**
	 * lbp-内部业务简称
	 */
	public static final String LBP_SYSTEM_ERROR = "lbp.system.error";
	public static final String LBP_SYSTEM_ERROR_MSG = "当前系统繁忙，请稍后再试";

	/**
     * 错误编码-数据库操作失败编码
     * 数据库操作失败通用型编码，如果需要返回详细错误，请使用详细错误编码
     */
    public static final String DATABASE_ERROR = "00000002";
    public static final String DATABASE_FAIL = "database.error";
    public static final String DATABASE_ERROR_MSG = "操作失败";

	/**
	 * 错误编码-非法请求
	 */
	public static final String NETWORK_ERROR = "0000003";
	public static final String NETWORK_FAIL = "network.error";
	public static final String NETWORK_ERROR_MSG = "非法请求";

	/**
	 * 错误编码-参数错误
	 */
	public static final String PARAMETER_ERROR = "0000004";
	public static final String PARAMETER_NULL_ERROR_MSG = "参数为空";
	public static final String PARAMETER_ERROR_MSG = "参数错误";

	/**
	 * 错误编码-webtoken错误
	 */
	public static final String WEBTOKEN_ERROR = "0000005";
	public static final String WEBTOKEN_ERROR_MSG = "webtoken错误";
	public static final String WEBTOKEN_FAIL = "webtoken.error";
	public static final String WEBTOKEN_FAIL_MSG = "webtoken失败";
	public static final String WEBTOKEN_VERIFY_FAIL = "webtoken.verify.error";
	public static final String WEBTOKEN_VERIFY_FAIL_MSG = "webtoken失败";

	public static final String WEBTOKEN_NULL_ERROR = "webtoken.null";
	public static final String WEBTOKEN_NULL_ERROR_MSG = "webtoken为空";
	public static final String WEBTOKEN_EXPIRE = "webtoken.expire";
	public static final String WEBTOKEN_EXPIRE_MSG = "webtoken已过期";
	public static final String WEBTOKEN_JWT_ERROR = "webtoken.jwt.error";
	public static final String WEBTOKEN_JWT_ERROR_MSG = "webtoken格式错误";

	/**
	 * 错误编码-gtoken错误
	 */
	public static final String USER_ERROR = "0000006";
	public static final String USER_EXPIRE = "gtoken.expire";
	public static final String USER_EXPIRE_MSG = "gtoken已过期";

//	/**
//	 * 错误编码-timestampId错误
//	 */
//	public static final String TIMESTAMPID_ERROR = "0000007";
//	public static final String TIMESTAMPID_FAIL = "timestampId.error";
//	public static final String TIMESTAMPID_ERROR_MSG = "timestampId错误";
//
//	public static final String TIMESTAMPID_NULL_ERROR = "timestampId.null";
//	public static final String TIMESTAMPID_NULL_ERROR_MSG = "timestampId为空";

	/**
	 * 错误编码-基础用户错误
	 */
	public static final String BASE_USER_ERROR = "0000008";
	public static final String BASE_USER_ERROR_MSG = "用户错误";

	public static final String BASE_USER_FAIL_ERROR = "base.user.fail";
	public static final String BASE_USER_FAIL_ERROR_MSG = "用户账号或密码错误";

	public static final String BASE_USER_PASSWORD_ERROR = "base.user.password.error";
	public static final String BASE_USER_PASSWORD_ERROR_MSG = "用户密码错误";

	public static final String BASE_USER_FREEZE_ERROR = "base.user.freeze";
	public static final String BASE_USER_FREEZE_ERROR_MSG = "用户已冻结";
	public static final String BASE_USER_CANCEL_ERROR = "base.user.cancel";
	public static final String BASE_USER_CANCEL_ERROR_MSG = "用户已注销";


	public static final String BASE_USER_EXIST_ERROR = "base.user.exist";
	public static final String BASE_USER_EXIST_ERROR_MSG = "用户已存在";
	public static final String BASE_USER_NOTEXIST_ERROR = "base.user.notexist";
	public static final String BASE_USER_NOTEXIST_ERROR_MSG = "用户不存在";

	public static final String BASE_USER_ACCOUNT_EXIST_ERROR = "base.user.account.exist";
	public static final String BASE_USER_ACCOUNT_EXIST_ERROR_MSG = "用户账户已存在";

	public static final String BASE_USER_ROLE_EXIST_ERROR = "base.user.role.exist";
	public static final String BASE_USER_ROLE_EXIST_ERROR_MSG = "用户角色已存在";

	/**
	 * 错误编码-基础用户首次登录
	 */
	public static final String BASE_USER_FIRST_LOGIN_ERROR = "0000009";
	public static final String BASE_USER_FIRST_LOGIN_ERROR_MSG = "用户首次登录，请修改密码！";

	public static final String BASE_USER_FIRST_LOGIN = "base.user.first.login";


	/**
	 * 错误编码-角色错误
	 */
	public static final String BASE_ROLE_ERROR = "0000009";
	public static final String BASE_ROLE_ERROR_MSG = "角色错误";

	public static final String BASE_ROLE_EXIST_ERROR = "base.role.exist";
	public static final String BASE_ROLE_EXIST_ERROR_MSG = "角色已存在";
	public static final String BASE_ROLE_NOTEXIST_ERROR = "base.role.notexist";
	public static final String BASE_ROLE_NOTEXIST_ERROR_MSG = "角色不存在";

	public static final String BASE_ROLE_MENU_EXIST_ERROR = "base.role.menu.exist";
	public static final String BASE_ROLE_MENU_EXIST_ERROR_MSG = "角色菜单已存在";

	/**
	 * 错误编码-菜单错误
	 */
	public static final String BASE_MENU_ERROR = "0000010";
	public static final String BASE_MENU_ERROR_MSG = "菜单错误";

	public static final String BASE_MENU_EXIST_ERROR = "base.menu.exist";
	public static final String BASE_MENU_EXIST_ERROR_MSG = "菜单已存在";
	public static final String BASE_MENU_NOTEXIST_ERROR = "base.menu.notexist";
	public static final String BASE_MENU_NOTEXIST_ERROR_MSG = "菜单不存在";

	public static final String BASE_MENU_CODE_EXIST_ERROR = "base.menu.code.exist";
	public static final String BASE_MENU_CODE_EXIST_ERROR_MSG = "菜单编码已存在";

	public static final String BASE_MENU_LIST_EXIST_ERROR = "base.menu.list.exist";
	public static final String BASE_MENU_LIST_EXIST_ERROR_MSG = "菜单列表已存在";

	/**
	 * 错误编码-部门错误
	 */
	public static final String BASE_DEPT_ERROR = "0000010";
	public static final String BASE_DEPT_ERROR_MSG = "部门错误";

	public static final String BASE_DEPT_EXIST_ERROR = "base.dept.exist";
	public static final String BASE_DEPT_EXIST_ERROR_MSG = "部门已存在";
	public static final String BASE_DEPT_NOTEXIST_ERROR = "base.dept.notexist";
	public static final String BASE_DEPT_NOTEXIST_ERROR_MSG = "部门不存在";

	public static final String BASE_DEPT_CODE_EXIST_ERROR = "base.dept.code.exist";
	public static final String BASE_DEPT_CODE_EXIST_ERROR_MSG = "部门编码已存在";

	public static final String BASE_DEPT_USER_EXIST_ERROR = "base.dept.user.exist";
	public static final String BASE_DEPT_USER_EXIST_ERROR_MSG = "部门用户已存在";
	public static final String BASE_DEPT_LIST_EXIST_ERROR = "base.dept.list.exist";
	public static final String BASE_DEPT_LIST_EXIST_ERROR_MSG = "部门列表已存在";


	/*--------------------------- 返回app错误码  -----------------------------*/

	/*--------------------------- 第三方错误码  -----------------------------*/
	/*--------------------------- GoFun错误码  -----------------------------*/
	/**
	 * 错误编码-GoFun错误
	 */
	public static final String GOFUN_ERROR = "0100001";
	/**
	 * 错误描述-GoFun错误
	 */
	public static final String GOFUN_ERROR_MSG = "oFun错误";
	public static final String GOFUN_NULL_ERROR = "gofun.null.error";
	public static final String GOFUN_NULL_ERROR_MSG = "传入参数为空";
	/*--------------------------- GoFun错误码  -----------------------------*/
	/*--------------------------- 第三方错误码  -----------------------------*/

	/*--------------------------- base平台使用错误码  -----------------------------*/
	/*--------------------------- 基础用户错误码(101开头)  -----------------------------*/
	/**
     * 错误编码-用户不存在
     */
    public final static String BASE_BASE_USER_ENTITY_NOTEXIST = "101101";
    /**
     * 错误描述-用户不存在
     */
    public final static String BASE_BASE_USER_ENTITY_NOTEXIST_MSG = "用户不存在";

    /**
     * 错误编码-用户已存在
     */
    public final static String BASE_BASE_USER_ENTITY_EXIST = "1011002";
    /**
     * 错误描述-用户已存在
     */
    public final static String BASE_BASE_USER_ENTITY_EXIST_MSG = "用户已存在";

    /**
     * 错误编码-用户列表不存在
     */
    public final static String BASE_BASE_USER_LIST_NOTEXIST = "1011003";
    /**
     * 错误描述-用户列表不存在
     */
    public final static String BASE_BASE_USER_LIST_NOTEXIST_MSG = "用户列表不存在";

    /**
     * 错误编码-用户列表已存在
     */
    public final static String BASE_BASE_USER_LIST_EXIST = "1011004";
    /**
     * 错误描述-用户列表已存在
     */
    public final static String BASE_BASE_USER_LIST_EXIST_MSG = "用户列表已存在";

    /**
     * 错误编码-用户账户已存在
     */
    public final static String BASE_BASE_USER_ACCOUNT_ENTITY_EXIST = "1011005";
    /**
     * 错误描述-用户账户已存在
     */
    public final static String BASE_BASE_USER_ACCOUNT_ENTITY_EXIST_MSG = "用户账户已存在";

    /**
     * 错误编码-用户密码错误
     */
    public final static String BASE_BASE_USER_PASSWORD_ERROR = "1011006";
    /**
     * 错误描述-用户密码错误
     */
    public final static String BASE_BASE_USER_PASSWORD_ERROR_MSG = "用户密码错误";

    /**
     * 错误编码-两次密码不一致
     */
    public final static String BASE_BASE_USER_TWO_PASSWORD_NOTEQUAL = "1011007";
    /**
     * 错误描述-两次密码不一致
     */
    public final static String BASE_BASE_USER_TWO_PASSWORD_NOTEQUAL_MSG = "两次密码不一致";

    /**
     * 错误编码-老密码和新密码不一致
     */
    public final static String BASE_BASE_USER_OLD_NEW_PASSWORD_NOTEQUAL = "1011007";
    /**
     * 错误描述-老密码和新密码不一致
     */
    public final static String BASE_BASE_USER_OLD_NEW_PASSWORD_NOTEQUAL_MSG = "老密码和新密码不一致";

	/*--------------------------- 基础用户错误码(101开头)  -----------------------------*/


	/*--------------------------- 能量配置错误码(302开头)  -----------------------------*/
	/**
	 * 错误编码-参数为空
	 */
	public static final String DIAMOND_CONFIG_FIELD_EMPTY = "3020001";
	/**
	 * 错误描述-参数为空
	 */
	public static final String DIAMOND_CONFIG_FIELD_EMPTY_MSG = "参数为空";
	/**
	 * 错误编码-能量不存在错误
	 */
	public static final String DIAMOND_CONFIG_DATA_NOTEXIST = "3020002";
	/**
	 * 错误描述-能量不存在错误
	 */
	public static final String DIAMOND_CONFIG_DATA_NOTEXIST_MSG = "能量不存在";
	/**
	 * 错误编码-能量LIST不存在错误
	 */
	public static final String DIAMOND_CONFIG_LIST_NOTEXIST = "3020003";
	/**
	 * 错误描述-能量list不存在错误
	 */
	public static final String DIAMOND_CONFIG_LIST_NOTEXIST_MSG = "能量列表不存在";
	/**
	 * 错误编码-不是JSON数据错误
	 */
	public static final String DIAMOND_CONFIG_CONTENT_NOTJSON = "3020004";
	/**
	 * 错误描述-不是JSON数据错误
	 */
	public static final String DIAMOND_CONFIG_CONTENT_NOTJSON_MSG = "不是JSON数据";

	/*--------------------------- 能量配置密错误码(302开头)  -----------------------------*/
	/*--------------------------- wheel平台使用错误码  -----------------------------*/


}