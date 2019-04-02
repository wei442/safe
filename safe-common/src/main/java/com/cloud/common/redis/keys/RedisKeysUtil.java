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

	/*----------------------------------------- 安全管理平台 -----------------------------------------*/
	/*----------------------------------------- 应用公共key -----------------------------------------*/
	/**
	 * @Title   project：microservice-consumer-safe
	 * @Description keyName：安全（safe）admin 管理后台登录 token
	 */
	public static final String CN_CLOUD_SAFE_ADMIN_LOGIN_TOKEN = "cn:cloud:safe:admin:login:token:";
	/*----------------------------------------- 安全管理平台 -----------------------------------------*/
	/*----------------------------------------- 应用公共key -----------------------------------------*/



    /*--------------------------- ochain平台  -----------------------------*/
	/*--------------------------- 应用公共key  -----------------------------*/
	/*--------------------------- 方向盘  -----------------------------*/
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）gofun app h5 登录 token
	 */
	public static final String CN_OCHAIN_WHEEL_APP_H5_LOGIN_TOKEN = "cn:ochain:wheel:gofun:app:h5:login:token:";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）gofun app h5 登录 timestampId
	 */
	public static final String CN_OCHAIN_WHEEL_APP_H5_LOGIN_TIMESTAMPID = "cn:ochain:wheel:gofun:app:h5:login:timestampId:";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）gofun app h5 登录 用户任务 时间
	 */
	public static final String CN_OCHAIN_WHEEL_APP_H5_LOGIN_USERTASK_USERID_TIME = "cn:ochain:wheel:gofun:app:h5:login:usertask:";

	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）排名时间总数
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_ALL_TIME = "cn:ochain:wheel:rank:all:";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）用户能量排名时间
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_DIAMOND_TIME = "cn:ochain:wheel:rank:diamond:";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）用户算力排名时间
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_CALCULATE_TIME = "cn:ochain:wheel:rank:calculate:";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：用户签到
	 */
	public static final String CN_OCHAIN_WHEEL_USER_SIGN_USERID = "cn:ochain:wheel:user:sign:userId:";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：用户签到是否已增减签到天数时间
	 */
	public static final String CN_OCHAIN_WHEEL_USER_SIGN_TIME_USERID = "cn:ochain:wheel:user:sign:time:userId:";

	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）算力配置编码
	 */
	public static final String CN_OCHAIN_WHEEL_CALCULATE_CONFIG_CODE = "cn:ochain:wheel:calculate:config:code:";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）能量配置编码
	 */
	public static final String CN_OCHAIN_WHEEL_DIAMOND_CONFIG_CODE = "cn:ochain:wheel:diamond:config:code:";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）用户订单记录时间
	 */
	public static final String CN_OCHAIN_WHEEL_CAR_ORDER_RECORDE_TIME = "cn:ochain:wheel:car:order:record:orderTime:";

	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）算力实时排名时间（存储用户账户）
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_CALCULATE_REAL_TIME = "cn:ochain:wheel:rank:calculate:real:time:useraccount";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）能量实时排名时间（存储用户账户）
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_DIAMOND_REAL_TIME = "cn:ochain:wheel:rank:diamond:real:time:useraccount";

	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）登录用户算力实时排名时间（存储用户id和用户账户）
	 */
	public static final String CN_OCHAIN_WHEEL_LOGIN_RANK_CALCULATE_REAL_TIME = "cn:ochain:wheel:login:rank:calculate:real:time";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）登录用户能量实时排名时间（存储用户id和用户账户
	 */
	public static final String CN_OCHAIN_WHEEL_LOGIN_RANK_DIAMOND_REAL_TIME = "cn:ochain:wheel:login:rank:diamond:real:time";

	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）算力昨日排名时间
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_CALCULATE_YESTERDAY_TIME = "cn:ochain:wheel:rank:calculate:yesterday:time:";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）能量昨日排名时间
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_DIAMOND_YESTERDAY_TIME = "cn:ochain:wheel:rank:diamond:yesterday:time:";

	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）算力昨日排名
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_CALCULATE_YESTERDAY = "cn:ochain:wheel:rank:calculate:yesterday";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）能量昨日排名
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_DIAMOND_YESTERDAY = "cn:ochain:wheel:rank:diamond:yesterday";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）算力昨日排名账户
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_CALCULATE_YESTERDAY_USERID = "cn:ochain:wheel:rank:calculate:yesterday:userid";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）能量昨日排名账户
	 */
	public static final String CN_OCHAIN_WHEEL_RANK_DIAMOND_YESTERDAY_USERID = "cn:ochain:wheel:rank:diamond:yesterday:userid";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）用户头像
	 */
	public static final String CN_OCHAIN_WHEEL_USER_HEADIMAGE_USERID = "cn:ochain:wheel:user:headimage:userid:";

	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘（wheel）领取能量方块
	 */
	public static final String CN_OCHAIN_WHEEL_DRAW_DIAMOND_RECORD_TIME = "cn:ochain:wheel:draw:diamond:record:time:";
	/*--------------------------- 方向盘  -----------------------------*/

	/*--------------------------- 方向盘管理后台  -----------------------------*/
	/**
	 * @Title   project：microservice-consumer-wheel-manage
	 * @Description keyName：方向盘管理后台（wheel manage）webtoken
	 */
	public static final String CN_OCHAIN_WHEEL_MANAGE_LOGIN_WEBTOKEN = "cn:ochain:wheel:manage:login:webtoken:";
	/*--------------------------- 方向盘管理后台  -----------------------------*/
	/*--------------------------- 应用公共key  -----------------------------*/

	/*------------------------------- 方向盘数据接收  -----------------------------------*/
	/**
	 * @Title	project：microservice-consumer-wheel-data-receive
	 * @Description	keyName：方向盘（wheel）数据接收消费者 记录编号
	 */
	public static final String CN_OCHAIN_WHEEL_DATA_RECEIVE_REGISTRYNO = "cn:ochain:wheel:data:receive:registryno";
	/*------------------------------- 方向盘数据接收  -----------------------------------*/

	/*--------------------------- 方向盘-区块链钱包  -----------------------------*/

	/**
	 * @Title   project：microservice-consumer-wheel-chainwallet
	 * @Description keyName：方向盘-区块链钱包（wheel-chainwallet）gofun 区块链钱包 accesstoken
	 */
	public static final String CN_OCHAIN_WHEEL_CHAIN_WALLET_ACCESSTOKEN = "cn:ochain:wheel:chain:wallet:gofun:accesstoken:";

	/**
	 * @Title   project：microservice-consumer-wheel-chainwallet
	 * @Description keyName：方向盘-区块链钱包（wheel）短信验证码-交易提取密码
	 */
	public static final String CN_OCHAIN_WHEEL_CHAIN_WALLET_VERIFYCODE_SMS_DRAW = "cn:ochain:wheel:chain:wallet:verifycode:sms:draw:";
	/**
	 * @Title   project：microservice-consumer-wheel-chainwallet
	 * @Description keyName：方向盘-区块链钱包（wheel）短信验证码-重设交易提取密码
	 */
	public static final String CN_OCHAIN_WHEEL_CHAIN_WALLET_VERIFYCODE_SMS_RESETDRAW = "cn:ochain:wheel:chain:wallet:verifycode:sms:resetdraw:";

	/**
	 * @Title   project：microservice-consumer-wheel-chainwallet
	 * @Description keyName：方向盘-区块链钱包（wheel）交易提取访问密码
	 */
	public static final String CN_OCHAIN_WHEEL_CHAIN_WALLET_ACCESS_PASSWORD_DRAW = "cn:ochain:wheel:chain:wallet:access:password:draw:";
	/**
	 * @Title   project：microservice-consumer-wheel-chainwallet
	 * @Description keyName：方向盘-区块链钱包（wheel）重设交易提取访问密码
	 */
	public static final String CN_OCHAIN_WHEEL_CHAIN_WALLET_ACCESS_PASSWORD_RESETDRAW = "cn:ochain:wheel:chain:wallet:access:password:resetdraw:";

	/**
	 * @Title	project：microservice-consumer-wheel-chainwallet
	 * @Description	keyName：方向盘-区块链钱包（wheel）区块链钱包消费者 充币订单编号
	 */
	public static final String CN_OCHAIN_WHEEL_CHAIN_WALLET_RECHARGE_COIN_ORDERNO = "cn:ochain:wheel:chain:wallet:recharge:coin:orderno";
	/**
	 * @Title	project：microservice-consumer-wheel-chainwallet
	 * @Description	keyName：方向盘-区块链钱包（wheel）区块链钱包消费者 提币订单编号
	 */
	public static final String CN_OCHAIN_WHEEL_CHAIN_WALLET_DRAW_COIN_ORDERNO = "cn:ochain:wheel:chain:wallet:draw:coin:orderno";
	/*--------------------------- 方向盘-区块链钱包  -----------------------------*/

	/**
	 * @Title   project：microservice-provider-wheel-bank
	 * @Description keyName：提币from地址缓存key
	 */
	public static final String CN_OCHAIN_WHEEL_BANK_DRAWING_FROMADDR = "cn:ochain:wheel:bank:drawing:fromaddr";
	/**
	  * @Title   project：microservice-provider-wheel-bank
	  * @Description keyName：充币to地址缓存key
	  */
	 public static final String CN_OCHAIN_WHEEL_BANK_STORE_TOADDR = "cn:ochain:wheel:bank:store:toaddr";

	//////////////////////////// 缓存key END //////////////////////////////////////

	//////////////////////////// 队列key START //////////////////////////////////////
	/*--------------------------- 方向盘  -----------------------------*/
	/**
	 * @Title   project：microservice-consumer-wheel-data-receive
	 * @Description keyName：GoFun数据推送-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_DATA_PUSH_GOFUN = "qn:ochain:wheel:data:push:gofun";
	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：账户任务算力-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_ACCOUNT_CALCULATE_TASK = "qn:ochain:wheel:account:calculate:task";
	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：账户文明分算力-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_ACCOUNT_CALCULATE_CIVILIZE = "qn:ochain:wheel:account:calculate:civilize";
	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：用户用车订单记录-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_CAR_ORDER = "qn:ochain:wheel:car:order:record";
	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：GoFun能量记录-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_DIAMOND_RECORD = "qn:ochain:wheel:diamond:record";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：方向盘领取-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_DIAMOND_DRAW = "qn:ochain:wheel:diamond:draw";
	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：用户算力配置-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_USER_CALCULATE_CONFIG = "qn:ochain:wheel:user:calculate:config";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：优惠券兑换-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_COUPON_EXCHANGE = "qn:ochain:wheel:coupon:exchange";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：新用户登录-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_NEW_USER_LOGIN = "qn:ochain:wheel:new:user:login";
	/**
	 * @Title   project：microservice-consumer-wheel
	 * @Description keyName：用户登录日志队列-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_USER_LOGIN_LOG = "qn:ochain:user:login:log";

	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：账户算力排名-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_ACCOUNT_CALCULATE_RANK = "qn:ochain:wheel:account:calculate:rank";

	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：账户能量排名-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_ACCOUNT_DIAMOND_RANK = "qn:ochain:wheel:account:diamond:rank";

	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：账户能量余额-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_ACCOUNT_DIAMOND_BALANCE = "qn:ochain:wheel:account:diamond:balance";

	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：账户算力余额-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_ACCOUNT_CALCULATE_BALANCE = "qn:ochain:wheel:account:calculate:balance";

	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：账户文明分算力余额-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_ACCOUNT_CALCULATE_CIVILIZE_BALANCE = "qn:ochain:wheel:account:calculate:civilize:balance";

	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：用户状态-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_USER_STATUS = "qn:ochain:wheel:user:status";
	/*--------------------------- 方向盘-区块链钱包  -----------------------------*/

	/*--------------------------- 方向盘-短信  -----------------------------*/
	/**
	 * @Title   project：microservice-thread-wheel
	 * @Description keyName：发送短信-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_SEND_SMS = "qn:ochain:wheel:send:sms";
	/*--------------------------- 方向盘-短信  -----------------------------*/

	/*--------------------------- 方向盘-区块链钱包  -----------------------------*/
	/**
	  * @Title   project：microservice-provider-wheel-bank
	  * @Description keyName：充币结果回调-队列key
	  */
	 public static final String QN_OCHAIN_WHEEL_BANK_STORE_CALLBACK = "qn:ochain:wheel:bank:store:callback";
	/**
	 * @Title   project：microservice-provider-wheel-bank
	 * @Description keyName：提币结果回调-队列key
	 */
	public static final String QN_OCHAIN_WHEEL_BANK_DRAWING_CALLBACK = "qn:ochain:wheel:bank:drawing:callback";
	/*--------------------------- 方向盘-区块链钱包  -----------------------------*/
	//////////////////////////// 队列key END //////////////////////////////////////

	////////////////////////////锁(lock) start /////////////////////////////////
	/**
	* @Title	project：microservice-ochain-thread
	* @Description	keyName：锁（lock）账户-能量余额
	*/
	public static final String LOCK_OCHAIN_ACCOUNT_DIAMOND = "lock:ochain:account:diamond:";

	/**
	 * @Title	project：microservice-ochain-thread
	 * @Description	keyName：锁（lock）账户算力-算力余额
	 */
	public static final String LOCK_OCHAIN_ACCOUNT_CALCULATE = "lock:ochain:account:calculate:calculate:";

	/**
	 * @Title	project：microservice-consumer-wheel-data-receive
	 * @Description	keyName：锁（lock）方向盘（wheel）数据接收消费者 记录编号
	 */
	public static final String LOCK_OCHAIN_WHEEL_DATA_RECEIVE_REGISTRYNO = "lock:ochain:wheel:data:receive:registryno";

	/**
	 * @Title	project：microservice-consumer-wheel-data-receive
	 * @Description	keyName：锁（lock）方向盘（wheel）LTS 定时任务 能量记录 记录编号
	 */
	public static final String LOCK_OCHAIN_WHEEL_LTS_TASK_DIAMOND_RECORD_REGISTRYNO = "lock:ochain:wheel:lts:task:diamond:record:registryno";

	/**
	 * @Title	project：microservice-consumer-wheel-data-receive
	 * @Description	keyName：锁（lock）方向盘（wheel）区块链钱包-充提币 订单编号
	 */
	public static final String LOCK_OCHAIN_WHEEL_CHAIN_WALLET_RECHARGE_COIN_ORDERNO = "lock:ochain:wheel:chain:wallet:recharge:coin:orderno";

	/**
	 * @Title	project：microservice-consumer-wheel-data-receive
	 * @Description	keyName：锁（lock）方向盘（wheel）区块链钱包-充提币 订单编号
	 */
	public static final String LOCK_OCHAIN_WHEEL_CHAIN_WALLET_DRAW_COIN_ORDERNO = "lock:ochain:wheel:chain:wallet:draw:coin:orderno";
	////////////////////////////锁(lock) end /////////////////////////////////
	/*--------------------------- ochain  -----------------------------*/


	/*--------------------------- base管理后台 -----------------------------*/
	/**
	 * @Title   project：microservice-consumer-base
	 * @Description keyName：base管理后台（base manage）webtoken
	 */
	public static final String CN_OCHAIN_BASE_MANAGE_WEBTOKEN = "cn:ochain:base:manage:webtoken:";
	/*--------------------------- base管理后台 -----------------------------*/

}