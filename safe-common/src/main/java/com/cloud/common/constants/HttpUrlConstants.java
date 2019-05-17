package com.cloud.common.constants;

/**
 * http微服务变量 HttpUrlConstants
 * @author wei.yong
 * 2017/11/20
 */
public class HttpUrlConstants {

	/*--------------------------- provider(提供者) http url  -----------------------------*/
	/*--------------------------- 基础服务 -----------------------------*/
	//redis 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_REDIS = "http://microservice-provider-redis";
	//sms 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_SMS = "http://microservice-provider-sms";
	//mail 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_MAIL = "http://microservice-provider-mail";
	/*--------------------------- 基础服务 -----------------------------*/

	/*--------------------------- 安全信息服务 -----------------------------*/
	//安全 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_SAFE = "http://microservice-provider-safe";
	//安全日志 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_SAFE_LOG = "http://microservice-provider-safe-log";
	/*--------------------------- 安全信息服务 -----------------------------*/
	/*--------------------------- provider(提供者) http url  -----------------------------*/

	/*--------------------------- consumer(消费者) http url  -----------------------------*/
	/*--------------------------- 基础服务 -----------------------------*/
	//redis 消费者url
	public static final String HTTP_MICROSERVICE_CONSUMER_REDIS = "http://microservice-consumer-redis";
	/*--------------------------- 基础服务 -----------------------------*/

	/*--------------------------- 安全服务 -----------------------------*/
	//安全 消费者url
	public static final String HTTP_MICROSERVICE_CONSUMER_SAFE = "http://microservice-consumer-safe";
	/*--------------------------- 安全服务 -----------------------------*/
	/*--------------------------- consumer(消费者) http url  -----------------------------*/

}