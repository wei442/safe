package com.cloud.common.constants.safe;

/**
 * (safe)安全数据库常量类 SqlSafeConstants
 * @author wei.yong
 */
public class SqlSafeConstants {

	/**********************************安全数据库常量**********************************/

	/**********************************企业常量**********************************/
	//企业状态 1-正常, 2-冻结, 3-注销
	public static final Integer SQL_ENTERPRISE_STATUS_NORMAL = 1;
	public static final Integer SQL_ENTERPRISE_STATUS_FREEZE = 2;
	public static final Integer SQL_ENTERPRISE_STATUS_CANCEL = 3;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_ENTERPRISE_IS_DELETE_NO = 0;
	public static final Integer SQL_ENTERPRISE_IS_DELETE_YES = 1;
	/**********************************企业常量**********************************/

	/**********************************基础用户常量**********************************/
	//基础用户状态 1-正常, 2-冻结, 3-注销
	public static final Integer SQL_BASE_USER_STATUS_NORMAL = 1;
	public static final Integer SQL_BASE_USER_STATUS_FREEZE = 2;
	public static final Integer SQL_BASE_USER_STATUS_CANCEL = 3;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_BASE_USER_IS_DELETE_NO = 0;
	public static final Integer SQL_BASE_USER_IS_DELETE_YES = 1;
	/**********************************基础用户常量**********************************/

	/**********************************基础用户登录日志常量**********************************/
	//登录类型 1-登录, 2-退出
	public static final Integer SQL_BASE_USER_LOGIN_LOG_LOGIN = 1;
	public static final Integer SQL_BASE_USER_LOGIN_LOG_LOGOUT = 2;
	/**********************************基础用户登录日志常量**********************************/

	/**********************************组织机构常量**********************************/
	//字典状态 0-无效, 1-有效
	public static final Integer SQL_ORG_STATUS_VALID = 0;
	public static final Integer SQL_ORG_STATUS_INVALID = 1;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_ORG_IS_DELETE_NO = 0;
	public static final Integer SQL_ORG_IS_DELETE_YES = 1;
	/**********************************组织机构常量**********************************/

	/**********************************字典常量**********************************/
	//字典状态 0-无效, 1-有效
	public static final Integer SQL_DICT_STATUS_VALID = 0;
	public static final Integer SQL_DICT_STATUS_INVALID = 1;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_DICT_IS_DELETE_NO = 0;
	public static final Integer SQL_DICT_IS_DELETE_YES = 1;
	/**********************************字典常量**********************************/

	/**********************************字典子项常量**********************************/
	//字典状态 0-无效, 1-有效
	public static final Integer SQL_DICT_ITEM_STATUS_VALID = 0;
	public static final Integer SQL_DICT_ITEM_STATUS_INVALID = 1;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_DICT_ITEM_IS_DELETE_NO = 0;
	public static final Integer SQL_DICT_ITEM_IS_DELETE_YES = 1;
	/**********************************字典子项常量**********************************/

	/**********************************岗位常量**********************************/
	//是否特殊岗位 0-否, 1-是
	public static final Integer SQL_POST_IS_SPECIAL_NO = 0;
	public static final Integer SQL_POST_IS_SPECIAL_YES = 1;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_POST_IS_DELETE_NO = 0;
	public static final Integer SQL_POST_IS_DELETE_YES = 1;
	/**********************************岗位常量**********************************/

	/**********************************职务常量**********************************/
	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_TITLE_IS_DELETE_NO = 0;
	public static final Integer SQL_TITLE_IS_DELETE_YES = 1;
	/**********************************职务常量**********************************/

	/**********************************用户信息常量**********************************/
	//用户状态 1-正常, 2-冻结, 3-注销
	public static final Integer SQL_USER_STATUS_NORMAL = 1;
	public static final Integer SQL_USER_STATUS_FREEZE = 2;
	public static final Integer SQL_USER_STATUS_CANCEL = 3;

	//用户性别 0-未知, 1-男, 2-女
	public static final Integer SQL_USER_GENDER_UNKNOWN = 0;
	public static final Integer SQL_USER_GENDER_MAN = 1;
	public static final Integer SQL_USER_GENDER_WOMAN = 2;

	//用户类型, 1-手机, 2-账户
	public static final Integer SQL_USER_TYPE_MOBILE = 1;
	public static final Integer SQL_USER_TYPE_ACCOUNT = 2;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_USER_IS_DELETE_NO = 0;
	public static final Integer SQL_USER_IS_DELETE_YES = 1;
	/**********************************用户信息常量**********************************/

	/**********************************用户应用登录常量**********************************/
	//是否首次登录 0-否, 1-是
	public static final Integer SQL_USER_APP_LOGIN_FIRST_LOGIN_NO = 0;
	public static final Integer SQL_USER_APP_LOGIN_FIRST_LOGIN_YES = 1;
	/**********************************用户应用登录常量**********************************/

	/**********************************用户应用登录日志常量**********************************/
	//登录类型 1-登录, 2-退出
	public static final Integer SQL_USER_APP_LOGIN_LOG_LOGIN_TYPE_LOGIN = 1;
	public static final Integer SQL_USER_APP_LOGIN_LOG_LOGIN_TYPE_LOGOUT = 2;

	//日志类型 1-app, 2-微信公众号, 3-支付宝
	public static final Integer SQL_USER_APP_LOGIN_LOG_LOG_TYPE_APP = 1;
	public static final Integer SQL_USER_APP_LOGIN_LOG_LOG_TYPE_WX = 2;
	public static final Integer SQL_USER_APP_LOGIN_LOG_LOG_TYPE_ALIPAY = 3;
	/**********************************用户应用登录日志常量**********************************/

	/**********************************用户管理常量**********************************/
	//管理类型 1-主管理员, 2-子管理员
	public static final Integer SQL_USER_ADMIN_TYPE_MASTER = 1;
	public static final Integer SQL_USER_ADMIN_TYPE_SLAVE = 2;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_USER_ADMIN_IS_DELETE_NO = 0;
	public static final Integer SQL_USER_ADMIN_IS_DELETE_YES = 1;
	/**********************************用户管理常量**********************************/

	/**********************************用户管理登录常量**********************************/
	//是否首次登录 0-未登录, 1-已登录
	public static final Integer SQL_USER_ADMIN_LOGIN_FIRST_LOGIN_NO = 0;
	public static final Integer SQL_USER_ADMIN_LOGIN_FIRST_LOGIN_YES = 1;
	/**********************************用户管理登录常量**********************************/

	/**********************************用户应用登录日志常量**********************************/
	//登录类型 1-登录, 2-退出
	public static final Integer SQL_USER_ADMIN_LOGIN_LOG_LOGIN_TYPE_LOGIN = 1;
	public static final Integer SQL_USER_ADMIN_LOGIN_LOG_LOGIN_TYPE_LOGOUT = 2;

	//日志类型 1-pc, 2-app
	public static final Integer SQL_USER_ADMIN_LOGIN_LOG_LOG_TYPE_PC = 1;
	public static final Integer SQL_USER_ADMIN_LOGIN_LOG_LOG_TYPE_APP = 2;
	/**********************************用户应用登录日志常量**********************************/

	/**********************************资质常量**********************************/
	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_QUALITY_IS_DELETE_NO = 0;
	public static final Integer SQL_QUALITY_IS_DELETE_YES = 1;
	/**********************************资质常量**********************************/

	/**********************************机构资质常量**********************************/
	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_ORG_QUALITY_IS_DELETE_NO = 0;
	public static final Integer SQL_ORG_QUALITY_IS_DELETE_YES = 1;
	/**********************************机构资质常量**********************************/

	/**********************************用户资质常量**********************************/
	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_USER_QUALITY_IS_DELETE_NO = 0;
	public static final Integer SQL_USER_QUALITY_IS_DELETE_YES = 1;
	/**********************************用户资质常量**********************************/

	/**********************************安全活动常量**********************************/
	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_ACTIVITY_IS_DELETE_NO = 0;
	public static final Integer SQL_ACTIVIT_IS_DELETE_YES = 1;
	/**********************************安全活动质常量**********************************/

	/**********************************规范文件常量**********************************/
	//规范类别 1-法律, 2-法规, 3-部门规章, 4-地方性法规, 5-标准
	public static final Integer SQL_RULE_CATEOGORY_LAW = 1;
	public static final Integer SQL_RULE_CATEOGORY_RULE = 2;
	public static final Integer SQL_RULE_CATEOGORY_regulations = 3;
	public static final Integer SQL_RULE_CATEOGORY_LOCAL_RULE = 4;
	public static final Integer SQL_RULE_CATEOGORY_STANDARD = 5;

	//规范类型 1-法律法规制度, 2-安全生产管理制度, 3-安全操作规程
	public static final Integer SQL_RULE_TYPE_LAW_RULE = 1;
	public static final Integer SQL_RULE_TYPE_SAFET_PRODUCTION = 2;
	public static final Integer SQL_RULE_TYPE_SAFET_OPERATION = 3;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_RULE_IS_DELETE_NO = 0;
	public static final Integer SQL_RULE_IS_DELETE_YES = 1;
	/**********************************规范文件常量**********************************/


	/**********************************附件常量**********************************/
	//附件类型 1-图片, 2-文件
	public static final Integer SQL_ATTACHMENT_TYPE_PIC = 1;
	public static final Integer SQL_ATTACHMENT_TYPE_FILE = 2;
	/**********************************附件常量**********************************/

	/**********************************岗位附件常量**********************************/
	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_POST_ATTACHMENT_IS_DELETE_NO = 0;
	public static final Integer SQL_POST_ATTACHMENT_IS_DELETE_YES = 1;
	/**********************************岗位附件常量**********************************/

	/**********************************隐患常量**********************************/
	//隐患级别 1-一般隐患, 1-重大隐患
	public static final Integer SQL_DANGER_LEVLE_NORMAL = 1;
	public static final Integer SQL_DANGER_LEVLE_GREAT = 2;

	//'隐患类型 1-隐患快报, 2-隐患抽查
	public static final Integer SQL_DANGER_TYPE_EXPRESS = 3;
	public static final Integer SQL_DANGER_TYPE_CHECK = 2;

	//删除标识 0-未删除，1-已删除
	public static final Integer SQL_DANGER_IS_DELETE_NO = 0;
	public static final Integer SQL_DANGER_IS_DELETE_YES = 1;
	/**********************************隐患常量**********************************/











	/**********************************安全数据库常量**********************************/

}
