package com.cloud.common.constants;

/**
 * http微服务变量 RetHttpUrlConstants
 * @author wei.yong
 * 2017/11/20
 */
public class RetHttpUrlConstants {

	/*--------------------------- provider(提供者) http url  -----------------------------*/
	/*--------------------------- 基础服务 -----------------------------*/
	//sms 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_SMS = "http://microservice-provider-sms";
	//ipfs 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_IPFS = "http://microservice-provider-ipfs";
	//redis 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_REDIS = "http://microservice-provider-redis";
	//mail 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_MAIL = "http://microservice-provider-mail";
	//base 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_BASE = "http://microservice-provider-base";
	/*--------------------------- 基础服务 -----------------------------*/

	/*--------------------------- 方向盘服务 -----------------------------*/
	//方向盘 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_WHEEL = "http://microservice-provider-wheel";
	//方向盘数据接收 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_WHEEL_DATA_RECEIVE = "http://microservice-provider-wheel-data-receive";
	//方向盘短信 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_WHEEL_SMS = "http://microservice-provider-wheel-sms";
	//方向盘-中心bank 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_WHEEL_CENTER_BANK = "http://microservice-provider-wheel-bank";
	//方向盘非法处理 提供者url
	public static final String HTTP_MICROSERVICE_PROVIDER_WHEEL_ILLEGAL = "http://microservice-provider-wheel-illegal";
	/*--------------------------- 方向盘服务 -----------------------------*/
	/*--------------------------- provider(提供者) http url  -----------------------------*/

	/*--------------------------- consumer(消费者) http url  -----------------------------*/
	/*--------------------------- 基础服务 -----------------------------*/
	//ipfs 消费者url
	public static final String HTTP_MICROSERVICE_CONSUMER_IPFS = "http://microservice-consumer-ipfs";
	//redis 消费者url
	public static final String HTTP_MICROSERVICE_CONSUMER_REDIS = "http://microservice-consumer-redis";
	/*--------------------------- 基础服务 -----------------------------*/
	/*--------------------------- 方向盘服务 -----------------------------*/
	//方向盘 消费者url
	public static final String HTTP_MICROSERVICE_CONSUMER_WHEEL = "http://microservice-consumer-wheel";
	//方向盘数据接收 消费者url
	public static final String HTTP_MICROSERVICE_CONSUMER_WHEEL_DATA_RECEIVE = "http://microservice-consumer-wheel-data-receive";
	//方向盘任务 消费者url
	public static final String HTTP_MICROSERVICE_CONSUMER_WHEEL_TASK = "http://microservice-consumer-wheel-task";
	//方向盘管理后台 消费者url
	public static final String HTTP_MICROSERVICE_CONSUMER_WHEEL_MANAGE = "http://microservice-consumer-wheel-manage";
	/*--------------------------- 方向盘服务 -----------------------------*/
	/*--------------------------- consumer(消费者) http url  -----------------------------*/

}