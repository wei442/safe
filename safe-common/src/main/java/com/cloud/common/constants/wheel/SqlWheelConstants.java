package com.cloud.common.constants.wheel;

/**
 * (wheel)数据库常量类 SqlWheelConstants
 * @author wei.yong
 * @2017年3月13日 @上午10:22:37
 */
public class SqlWheelConstants {

    /**********************************  用户常量  **********************************/
	/**********************************  用户信息常量  **********************************/
    //用户状态 1-正常, 2-冻结, 3-注销
    public static final Integer SQL_USER_STATUS_NORMAL = 1;
    public static final Integer SQL_USER_STATUS_FREEZE = 2;
    public static final Integer SQL_USER_STATUS_CANCEL = 3;

    //用户类型, 1-手机, 2-账户
    public static final Integer SQL_USER_TYPE_MOBILE = 1;
    public static final Integer SQL_USER_TYPE_ACCOUNT = 2;

    //删除标识 0-未删除，1-已删除
    public static final Integer SQL_USER_IS_DELETE_NO = 0;
    public static final Integer SQL_USER_IS_DELETE_YES = 1;
    /**********************************  用户信息常量  **********************************/

    /**********************************  用户登录日志常量  **********************************/
    //登录类型 1-登录
    public static final Integer SQL_USER_LOGIN_LOG_TYPE_LOGIN = 1;

    //日志类型 1-h5
    public static final Integer SQL_USER_LOGIN_LOG_TYPE_H5 = 1;
    /**********************************  用户登录日志常量  **********************************/


    /**********************************  用户算力配置常量  **********************************/
    //是否完成（身份认证、驾驶证认证、每日签到、邀请好友、缴纳押金、免密支付、每日用车）  0-未完成, 1-已完成
    public static final Integer SQL_USER_CALCULATE_CONFIG_TYPE_COMPLETE_NO = 0;
    public static final Integer SQL_USER_CALCULATE_CONFIG_TYPE_COMPLETE_YES = 1;

    //是否添加任务算力 0- 未添加, 1-已添加
    public static final Integer SQL_USER_CALCULATE_CONFIG_TYPE_IS_ADD_NO = 0;
    public static final Integer SQL_USER_CALCULATE_CONFIG_TYPE_IS_ADD_YES = 1;
    /**********************************  用户算力配置常量  **********************************/

    /**********************************  用户交易密码常量  **********************************/
    //用户交易密码状态 1-正常, 2-废弃
    public static final Integer SQL_USER_TRANSACTION_PASSWORD_STATUS_NORMAL = 1;
    public static final Integer SQL_USER_TRANSACTION_PASSWORD_STATUS_DISCARD = 2;
    /**********************************  用户交易密码常量  **********************************/

    /**********************************  用户货币地址常量  **********************************/
    //状态 1-正常
    public static final Integer SQL_USER_COIN_ADDR_STATUS_NORMAL = 1;

    //类型 1-充币,  2-提币
    public static final Integer SQL_USER_COIN_ADDR_TYPE_RECHARGE = 1;
    public static final Integer SQL_USER_COIN_ADDR_TYPE_DRAW = 2;
    /**********************************  用户货币地址常量  **********************************/
    /**********************************  用户常量  **********************************/

    /**********************************  账户常量  **********************************/
    /**********************************  账户日志常量  **********************************/
    //类型 1- 充值, 2-消费, 3-退款, 4-日常领取, 5-兑换优惠券, 6-赠送, 7-提取
    public static final Integer SQL_ACCOUNT_LOG_TYPE_RECHARGE = 1;
    public static final Integer SQL_ACCOUNT_LOG_TYPE_EXPEND = 2;
    public static final Integer SQL_ACCOUNT_LOG_TYPE_REFUND = 3;
    public static final Integer SQL_ACCOUNT_LOG_TYPE_DRAW = 4;
    public static final Integer SQL_ACCOUNT_LOG_TYPE_EXCHANGE = 5;
    public static final Integer SQL_ACCOUNT_LOG_TYPE_GIFT = 6;
    public static final Integer SQL_ACCOUNT_LOG_TYPE_WITHDRAW = 7;

    //状态 0-失败, 1-成功
    public static final Integer SQL_ACCOUNT_LOG_STATUS_FAIL = 0;
    public static final Integer SQL_ACCOUNT_LOG_STATUS_SUCESS = 1;
    /**********************************  账户日志常量  **********************************/

    /**********************************  账户算力日志常量  **********************************/
    //算力类型 1-文明分算力, 2-任务算力, 3-临时任务算力
    public static final Integer SQL_ACCOUNT_CALCULATE_LOG_TYPE_CIVILIZE = 1;
    public static final Integer SQL_ACCOUNT_CALCULATE_LOG_TYPE_TASK = 2;
    public static final Integer SQL_ACCOUNT_CALCULATE_LOG_TYPE_TEMP_TASK = 3;

    //状态 0-失败, 1-成功
    public static final Integer SQL_ACCOUNT_CALCULATE_LOG_STATUS_FAIL = 0;
    public static final Integer SQL_ACCOUNT_CALCULATE_LOG_STATUS_SUCESS = 1;
    /**********************************  账户算力日志常量  **********************************/
    /**********************************  账户常量  **********************************/

    /**********************************  算力常量  **********************************/
    /**********************************  算力配置常量  **********************************/
    //算力类型 1-文明分, 2-任务
    public static final Integer SQL_CALCULATE_CONFIG_TYPE_CIVILIZE = 1;
    public static final Integer SQL_CALCULATE_CONFIG_TYPE_TASK = 2;

    //是否启用 0-不启用, 1-启用
    public static final Integer SQL_CALCULATE_CONFIG_IS_USE_NO = 0;
    public static final Integer SQL_CALCULATE_CONFIG_IS_USE_YES = 1;

    //是否跳转 0-不跳转，1-跳转
    public static final Integer SQL_CALCULATE_CONFIG_IS_SKIP_NO = 0;
    public static final Integer SQL_CALCULATE_CONFIG_IS_SKIP_YES = 1;

    //删除标识 0-未删除, 1-已删除
    public static final Integer SQL_CALCULATE_CONFIG_IS_DELETE_NO = 0;
    public static final Integer SQL_CALCULATE_CONFIG_IS_DELETE_YES = 1;

    /**********************************  算力配置任务常量  **********************************/
    //周期 周期 1-不限, 2-每天, 3-1次, 4-临时
    public static final Integer SQL_CALCULATE_CONFIG_TASK_PERIOD_UNLIMIT = 1;
    public static final Integer SQL_CALCULATE_CONFIG_TASK_PERIOD_DAY = 2;
    public static final Integer SQL_CALCULATE_CONFIG_TASK_PERIOD_ONCE = 3;
    public static final Integer SQL_CALCULATE_CONFIG_TASK_PERIOD_TEMP = 4;

    //奖励次数 0-不限
    public static final Integer SQL_CALCULATE_CONFIG_TASK_TIMES_UNLIMIT = 0;

    //是否启用 0-不启用, 1-启用
    public static final Integer SQL_CALCULATE_CONFIG_TASK_IS_USE_NO = 0;
    public static final Integer SQL_CALCULATE_CONFIG_TASK_IS_USE_YES = 1;
    /**********************************  算力配置任务常量  **********************************/
    /**********************************  算力配置常量  **********************************/

    /**********************************  算力记录常量  **********************************/
    //算力类型 1-文明分, 2-任务
    public static final Integer SQL_CALCULATE_RECORD_TYPE_CIVILIZE = 1;
    public static final Integer SQL_CALCULATE_RECORD_TYPE_TASK = 2;

    //算力状态 0-失败, 1-成功
    public static final Integer SQL_CALCULATE_RECORD_STATUS_FAIL = 0;
    public static final Integer SQL_CALCULATE_RECORD_STATUS_SUCCESS = 1;
    /**********************************  算力记录常量  **********************************/
    /**********************************  算力常量  **********************************/

    /**********************************  能量常量  **********************************/
    /**********************************  能量配置常量  **********************************/
    //能量类型 1-日常领取
    public static final Integer SQL_DIAMOND_CONFIG_TYPE_COMMON = 1;

    //是否固定发放能量 0-否, 1-是
    public static final Integer SQL_DIAMOND_CONFIG_FIX_NO = 0;
    public static final Integer SQL_DIAMOND_CONFIG_FIX_YES = 1;

    //删除标识 0-未删除, 1-已删除
    public static final Integer SQL_DIAMOND_CONFIG_IS_DELETE_NO = 0;
    public static final Integer SQL_DIAMOND_CONFIG_IS_DELETE_YES = 1;
    /**********************************  能量配置常量  **********************************/

    /**********************************  能量领取记录常量  **********************************/
    //领取类型 1-日常领取, 2-新用户注册, 3-优惠券, 4-充值, 5-提现, 6-退款, 7-提取退回
    public static final Integer SQL_DIAMOND_RECORD_TYPE_COMMON = 1;
    public static final Integer SQL_DIAMOND_RECORD_TYPE_NEW_USER = 2;
    public static final Integer SQL_DIAMOND_RECORD_TYPE_COUPON = 3;
    public static final Integer SQL_DIAMOND_RECORD_TYPE_RECHARGE = 4;
    public static final Integer SQL_DIAMOND_RECORD_TYPE_WITHDRAW = 5;
    public static final Integer SQL_DIAMOND_RECORD_TYPE_REFUND = 6;
    public static final Integer SQL_DIAMOND_RECORD_TYPE_WITHDRAW_RETURN = 7;

    //是否领取 0-未领取, 1-已领取, 2-领取失败
    public static final Integer SQL_DIAMOND_RECORD_IS_USE_NO = 0;
    public static final Integer SQL_DIAMOND_RECORD_IS_USE_YES = 1;
    public static final Integer SQL_DIAMOND_RECORD_IS_USE_FAIL = 2;

    //能量状态 0-失败, 1-成功
    public static final Integer SQL_DIAMOND_RECORD_STATUS_FAIL = 0;
    public static final Integer SQL_DIAMOND_RECORD_STATUS_SUCCESS = 1;
    /**********************************  能量领取记录常量  **********************************/
    /**********************************  能量常量  **********************************/

    /**********************************  优惠券常量  **********************************/
    /**********************************  优惠券常量  **********************************/
    //优惠券类型 1-代金券
    public static final Integer SQL_COUPON_TYPE_CASH = 1;

    //是否启用 0-不启用, 1-启用
    public static final Integer SQL_COUPON_IS_USE_NO = 0;
    public static final Integer SQL_COUPON_IS_USE_YES = 1;

    //删除标识 0-未删除, 1-已删除
    public static final Integer SQL_COUPON_IS_DELETE_NO = 0;
    public static final Integer SQL_COUPON_IS_DELETE_YES = 1;
    /**********************************  优惠券常量  **********************************/
    /**********************************  优惠券日志常量  **********************************/
    //状态 0-失败, 1-成功
    public static final Integer SQL_COUPON_LOG_STATUS_FAIL = 0;
    public static final Integer SQL_COUPON_LOG_STATUS_SUCCESS = 1;
    /**********************************  优惠券日志常量  **********************************/
    /**********************************  优惠券常量  **********************************/

    /**********************************  用车订单常量  **********************************/
    //用车订单状态 0-失败, 1-成功
    public static final Integer SQL_CAR_ORDER_STATUS_FAIL = 0;
    public static final Integer SQL_CAR_ORDER_STATUS_SUCCESS = 1;
    /**********************************  用车订单常量  **********************************/

    /**********************************  数据推送常量  **********************************/
    //推送处理状态 0-失败，1-成功
    public static final Integer SQL_DATA_PUSH_STATUS_FAIL = 0;
    public static final Integer SQL_DATA_PUSH_STATUS_SUCCESS = 1;

    //数据推送类型 1-员工基本信息, 2-员工文明用车分数, 3-员工邀请好友, 4-员工用车订单, 5-员工基本状态
    public static final Integer SQL_DATA_PUSH_TYPE_BASIC = 1;
    public static final Integer SQL_DATA_PUSH_TYPE_SCORE = 2;
    public static final Integer SQL_DATA_PUSH_TYPE_FRIEND = 3;
    public static final Integer SQL_DATA_PUSH_TYPE_CARORDER = 4;
    public static final Integer SQL_DATA_PUSH_TYPE_BASIC_STATUS = 5;
    /**********************************  数据推送常量  **********************************/

    /**********************************  短信发送常量  **********************************/
    //状态 0-失败; 1-成功
    public static final Integer SQL_SMS_STATUS_FAIL = 0;
    public static final Integer SQL_SMS_STATUS_SUCCESS = 1;

    //短信发送类型 1-单发
    public static final Integer SQL_SMS_TYPE = 1;
    /**********************************  短信发送常量  **********************************/

    /**********************************  订单常量  **********************************/
    /**********************************  充币订单常量  **********************************/
    //订单状态 0-未充币, 1-充币成功, 2-充币失败
    public static final Integer SQL_ORDER_RECHARGE_COIN_STATUS_NO = 0;
    public static final Integer SQL_ORDER_RECHARGE_COIN_STATUS_SUCESS = 1;
    public static final Integer SQL_ORDER_RECHARGE_COIN_STATUS_FAIL = 2;
    /**********************************  充币订单常量  **********************************/

    /**********************************  提币订单常量  **********************************/
    //订单状态 0-未提币, 1-提币成功, 2-提币失败
    public static final Integer SQL_ORDER_DRAW_COIN_STATUS_NO = 0;
    public static final Integer SQL_ORDER_DRAW_COIN_STATUS_SUCESS = 1;
    public static final Integer SQL_ORDER_DRAW_COIN_STATUS_FAIL = 2;
    /**********************************  提币订单常量  **********************************/
    /**********************************  订单常量  **********************************/

}