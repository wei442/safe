package com.cloud.common.constants.safe;

import com.cloud.common.constants.HttpUrlConstants;

/**
 * 基础url超类 BaseUrlService(boot的url)
 * @author wei.yong
 */
public class SafeUrlConstants {

	//用户管理
	public static final String safe_userAdmin = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE + "/boot/userAdmin";
	//用户管理登录
	public static final String safe_userAdminLogin = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE + "/boot/userAdminLogin";
	//用户应用登录
	public static final String safe_userAppLogin = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE + "/boot/userAppLogin";
	//用户信息
	public static final String safe_userInfo = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE + "/boot/userInfo";
	//用户机构
	public static final String safe_userOrg = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE + "/boot/userOrg";
	//用户岗位
	public static final String safe_userPost = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE + "/boot/userPost";
	//用户资质
	public static final String safe_userQuality = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE + "/boot/userQuality";
	//用户职务
	public static final String safe_userTitle = HttpUrlConstants.HTTP_MICROSERVICE_PROVIDER_SAFE + "/boot/userTitle";


}