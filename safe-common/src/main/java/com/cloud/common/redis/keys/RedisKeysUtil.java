package com.cloud.common.redis.keys;


/**
 *
 * @ClassName: RedisKeysUtil
 * @Description: Redis 队列&缓存 KEY工具
 * @author wei.yong
 * @date 2016年5月4日 下午5:36:50
 *
 * 名称规则：名称字段以“:”分隔，第一个字段为固定字段: 缓存-“cn”(cache name), 队列-“qn”(queue name);
 * 		     第二个字段为项目名称或系统名称(名称长的使用简写)；
 * 		     第三个字段为具体业务名称，有需要可以追加第五个字段；
 * 		     若缓存key需要拼接参数的，则需已“:”结尾，用以分隔参数
 *
 */
public final class RedisKeysUtil {

	//////////////////////////// 缓存key START //////////////////////////////////////

	/*----------------------------------------- 应用公共key -----------------------------------------*/
	/*----------------------------------------- 安全管理平台 -----------------------------------------*/
	/**
	 * @Title   project：microservice-consumer-safe-admin
	 * @Description keyName：安全（safe）admin 安全管理后台-登录 token
	 */
	public static final String CN_CLOUD_SAFE_ADMIN_LOGIN_TOKEN = "cn:cloud:safe:admin:login:token:";
	/**
	 * @Title   project：microservice-consumer-safe-admin
	 * @Description keyName：安全（safe）admin 安全管理后台-首次登录修改密码 accesstoken
	 */
	public static final String CN_CLOUD_SAFE_ADMIN_FIRSTLOGIN_ACCESSTOKEN_USERID = "cn:cloud:safe:admin:firstlogin:accesstoken:userId:";

	/*----------------------------------------- 安全管理平台 -----------------------------------------*/

	/*----------------------------------------- 安全管理员平台 -----------------------------------------*/
	/**
	 * @Title   project：microservice-consumer-safe-manage
	 * @Description keyName：安全（safe）manage 安全管理员后台登录 token
	 */
	public static final String CN_CLOUD_SAFE_MANAGE_LOGIN_TOKEN = "cn:cloud:safe:manage:login:token:";
	/*----------------------------------------- 安全管理员平台 -----------------------------------------*/
	/*----------------------------------------- 应用公共key -----------------------------------------*/


	////////////////////////////队列key START //////////////////////////////////////
	/**
	 * @Title   project：microservice-consumer-safe-admin
	 * @Description keyName：附件日志队列-队列key
	 */
	public static final String QN_CLOUD_SAFE_USER_LOGIN_ATTACHMENT_LOG = "qn:cloud:safe:attachment:log";
	/**
	 * @Title   project：microservice-consumer-safe-admin
	 * @Description keyName：用户管理日志队列-队列key
	 */
	public static final String QN_CLOUD_SAFE_USER_ADMIN_LOGIN_LOG = "qn:cloud:safe:user:admin:login:log";
	/**
	 * @Title   project：microservice-consumer-safe-admin
	 * @Description keyName：用户app日志队列-队列key
	 */
	public static final String QN_CLOUD_SAFE_USER_APP_LOGIN_LOG = "qn:cloud:safe:user:app:login:log";
	/**
	 * @Title   project：microservice-consumer-safe-admin
	 * @Description keyName：基础用户登录日志队列-队列key
	 */
	public static final String QN_CLOUD_SAFE_BASE_USER_LOGIN_LOG = "qn:cloud:safe:base:user:login:log";
	////////////////////////////队列key END //////////////////////////////////////


}