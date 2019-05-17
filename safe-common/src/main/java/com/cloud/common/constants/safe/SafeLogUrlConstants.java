package com.cloud.common.constants.safe;

import com.cloud.common.constants.HttpUrlConstants;

/**
 * url日志变量 SafeLogUrlConstants
 * @author wei.yong
 */
public class SafeLogUrlConstants {

	//附件日志
	public static final String attachment_log = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE_LOG + "/attachment/log";
	//用户管理登录日志
	public static final String user_admin_login_log = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE_LOG + "/user/admin/login/log";
	//用户app登录日志
	public static final String user_app_login_log = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE_LOG + "/user/app/login/log";
	//基础用户登录日志
	public static final String base_user_login_log = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE_LOG + "/base/user/login/log";

}