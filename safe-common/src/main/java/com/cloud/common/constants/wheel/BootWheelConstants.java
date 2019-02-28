package com.cloud.common.constants.wheel;

import com.cloud.common.constants.BootConstants;

/**
 * boot方向盘返回错误码 BootWheelConstants
 * @author wei.yong
 * @2017年03月02日
 */
public class BootWheelConstants extends BootConstants {

    /*----------------------------- 方向盘信息boot错误编码(1001开头) -----------------------------*/
    /*----------------------------- 用户boot错误编码(10010开头) -----------------------------*/
    /**
     * 错误编码-传入参数为空
     */
	public static final String WHEEL_FIELD_EMPTY = "10010001";
    /**
     * 只是显示
     */
    public static final String WHEEL_FIELD_EMPTY_MSG = "传入参数为空";
    /**
	 * 错误编码-不是JSON格式
	 */
	public static final String WHEEL_CONTENT_NOTJSON = "10010002";
	/**
	 * 错误描述-不是JSON格式
	 */
	public static final String WHEEL_CONTENT_NOTJSON_MSG = "不是JSON格式";
    /*----------------------------- 方向盘信息boot错误编码(10010开头) -----------------------------*/

    /*----------------------------- 方向盘-用户信息boot错误编码(10011开头) -----------------------------*/
    /**
     * 错误编码-用户不存在
     */
    public static final String WHEEL_USER_ENTITY_NOTEXIST = "10011001";
    /**
     * 错误描述-用户不存在
     */
    public static final String WHEEL_USER_ENTITY_NOTEXIST_MSG = "用户不存在";

    /**
     * 错误编码-用户已存在
     */
    public static final String WHEEL_USER_ENTITY_EXIST = "10011002";
    /**
     * 错误描述-用户已存在
     */
    public static final String WHEEL_USER_ENTITY_EXIST_MSG = "用户已存在";

    /**
     * 错误编码-用户列表不存在
     */
    public static final String WHEEL_USER_LIST_NOTEXIST = "10011003";
    /**
     * 错误描述-用户列表不存在
     */
    public static final String WHEEL_USER_LIST_NOTEXIST_MSG = "用户列表不存在";
    /**
     * 错误编码-用户列表已存在
     */
    public static final String WHEEL_USER_LIST_EXIST = "10011004";
    /**
     * 错误描述-用户列表已存在
     */
    public static final String WHEEL_USER_LIST_EXIST_MSG = "用户列表已存在";

    /**
     * 错误编码-用户签到不存在
     */
    public static final String WHEEL_USER_SIGN_ENTITY_NOTEXIST = "10011005";
    /**
     * 错误描述-用户签到不存在
     */
    public static final String WHEEL_USER_SIGN_ENTITY_NOTEXIST_MSG = "用户签到不存在";
    /**
     * 错误编码-用户签到已存在
     */
    public static final String WHEEL_USER_SIGN_ENTITY_EXIST = "10011006";
    /**
     * 错误描述-用户签到已存在
     */
    public static final String WHEEL_USER_SIGN_ENTITY_EXIST_MSG = "用户签到已存在";

    /**
     * 错误编码-用户算力配置不存在
     */
    public static final String WHEEL_USER_CALCULATE_CONFIG_ENTITY_NOTEXIST = "10011007";
    /**
     * 错误描述-用户算力配置不存在
     */
    public static final String WHEEL_USER_CALCULATE_CONFIG_ENTITY_NOTEXIST_MSG = "用户算力配置不存在";

    /**
     * 错误编码-用户算力配置已存在
     */
    public static final String WHEEL_USER_CALCULATE_CONFIG_ENTITY_EXIST = "10011008";
    /**
     * 错误描述-用户算力配置已存在
     */
    public static final String WHEEL_USER_CALCULATE_CONFIG_ENTITY_EXIST_MSG = "用户算力配置已存在";

    /**
     * 错误编码-用户算力配置列表不存在
     */
    public static final String WHEEL_USER_CALCULATE_CONFIG_LIST_NOTEXIST = "10011009";
    /**
     * 错误描述-用户算力配置列表不存在
     */
    public static final String WHEEL_USER_CALCULATE_CONFIG_LIST_NOTEXIST_MSG = "用户算力配置列表不存在";
    /**
     * 错误编码-用户算力配置列表已存在
     */
    public static final String WHEEL_USER_CALCULATE_CONFIG_LIST_EXIST = "10011010";
    /**
     * 错误描述-用户算力配置列表已存在
     */
    public static final String WHEEL_USER_CALCULATE_CONFIG_LIST_EXIST_MSG = "用户算力配置列表已存在";
    /*----------------------------- 方向盘-用户信息boot错误编码(10011开头) -----------------------------*/

    /*----------------------------- 方向盘-账户boot错误编码(10012开头) -----------------------------*/
    /**
     * 错误编码-账户不存在
     */
    public static final String WHEEL_ACCOUNT_ENTITY_NOTEXIST = "10012001";
    /**
     * 错误描述-账户不存在
     */
    public static final String WHEEL_ACCOUNT_ENTITY_NOTEXIST_MSG = "账户不存在";
	/**
	 * 错误编码-账户已存在
	 */
	public static final String WHEEL_ACCOUNT_ENTITY_EXIST = "10012002";
	/**
	 * 错误描述-账户已存在
	 */
	public static final String WHEEL_ACCOUNT_ENTITY_EXIST_MSG = "账户已存在";

	 /**
     * 错误编码-账户列表不存在
     */
    public static final String WHEEL_ACCOUNT_LIST_NOTEXIST = "10012003";
    /**
     * 错误描述-账户列表不存在
     */
    public static final String WHEEL_ACCOUNT_LIST_NOTEXIST_MSG = "账户列表不存在";
    /**
     * 错误编码-账户列表已存在
     */
    public static final String WHEE_ACCOUNT_LIST_EXIST = "10012004";
    /**
     * 错误描述-账户列表已存在
     */
    public static final String WHEEL_ACCOUNT_LIST_EXIST_MSG = "账户列表已存在";

	/**
	 * 错误编码-账户算力实体不存在
	 */
	public static final String WHEEL_ACCOUNT_CALCULATE_ENTITY_NOTEXIST = "10012005";
	/**
	 * 错误描述-账户算力实体不存在
	 */
	public static final String WHEEL_ACCOUNT_CALCULATE_ENTITY_NOTEXIST_MSG = "账户算力实体不存在";
	/**
	 * 错误编码-账户算力实体已存在
	 */
	public static final String WHEEL_ACCOUNT_CALCULATE_ENTITY_EXIST = "10012006";
	/**
	 * 错误描述-账户算力实体已存在
	 */
	public static final String WHEEL_ACCOUNT_CALCULATE_ENTITY_EXIST_MSG = "账户算力实体已存在";


	/**
     * 错误编码-账户算力列表不存在
     */
    public static final String WHEEL_ACCOUNT_CALCULATE_LIST_NOTEXIST = "10012007";
    /**
     * 错误描述-账户算力列表不存在
     */
    public static final String WHEEL_ACCOUNT_CALCULATE_LIST_NOTEXIST_MSG = "账户算力列表不存在";
    /**
     * 错误编码-账户算力列表已存在
     */
    public static final String WHEE_ACCOUNT_CALCULATE_LIST_EXIST = "10012008";
    /**
     * 错误描述-账户算力列表已存在
     */
    public static final String WHEEL_ACCOUNT_CALCULATE_LIST_EXIST_MSG = "账户算力列表已存在";

	/**
     * 错误编码-账户日志列表不存在
     */
    public static final String WHEEL_ACCOUNT_LOG_LIST_NOTEXIST = "10012009";
    /**
     * 错误描述-账户日志列表不存在
     */
    public static final String WHEEL_ACCOUNT_LOG_LIST_NOTEXIST_MSG = "账户日志户列表不存在";
    /**
     * 错误编码-账户日志列表已存在
     */
    public static final String WHEEL_ACCOUNT_LOG_LIST_EXIST = "10012010";
    /**
     * 错误描述-账户日志列表已存在
     */
    public static final String WHEEL_ACCOUNT_LOG_LIST_EXIST_MSG = "账户日志列表已存在";

    /**
     * 错误编码-账户算力日志列表不存在
     */
    public static final String WHEEL_ACCOUNT_CALCULATE_LOG_LIST_NOTEXIST = "10012011";
    /**
     * 错误描述-账户算力日志列表不存在
     */
    public static final String WHEEL_ACCOUNT_CALCULATE_LOG_LIST_NOTEXIST_MSG = "账户算力日志列表不存在";
    /**
     * 错误编码-账户算力日志列表已存在
     */
    public static final String WHEEL_ACCOUNT_CALCULATE_LOG_LIST_EXIST = "10012012";
    /**
     * 错误描述-账户算力日志列表已存在
     */
    public static final String WHEEL_ACCOUNT_CALCULATE_LOG_LIST_EXIST_MSG = "账户算力日志列表已存在";
	/*----------------------------- 方向盘-账户boot错误编码(10012开头) -----------------------------*/

	/*----------------------------- 方向盘-能量boot错误编码(10013开头) -----------------------------*/
	/**
	 * 错误编码-能量配置不存在
	 */
	public static final String WHEEL_DIAMOND_CONFIG_ENTITY_NOTEXIST = "10013001";
	/**
	 * 错误描述-能量配置不存在
	 */
	public static final String WHEEL_DIAMOND_CONFIG_ENTITY_NOTEXIST_MSG = "能量配置不存在";
	/**
	 * 错误编码-能量配置已存在
	 */
	public static final String WHEEL_DIAMOND_CONFIG_ENTITY_EXIST = "10013002";
	/**
	 * 错误描述-能量配置已存在
	 */
	public static final String WHEEL_DIAMOND_CONFIG_ENTITY_EXIST_MSG = "能量配置已存在";

	/**
	 * 错误编码-能量配置列表不存在
	 */
	public static final String WHEEL_DIAMOND_CONFIG_LIST_NOTEXIST = "10013003";
	/**
	 * 错误描述-能量配置列表不存在
	 */
	public static final String WHEEL_DIAMOND_CONFIG_LIST_NOTEXIST_MSG = "能量配置列表不存在";
	/**
	 * 错误编码-能量配置列表已存在
	 */
	public static final String WHEEL_DIAMOND_CONFIG_LIST_EXIST = "10013004";
	/**
	 * 错误描述-能量配置列表已存在
	 */
	public static final String WHEEL_DIAMOND_CONFIG_LIST_EXIST_MSG = "能量配置列表已存在";

	/**
	 * 错误编码-能量排名不存在
	 */
	public static final String WHEEL_DIAMOND_RANK_ENTITY_NOTEXIST = "10013005";
	/**
	 * 错误描述-能量排名不存在
	 */
	public static final String WHEEL_DIAMOND_RANK_ENTITY_NOTEXIST_MSG = "能量排名不存在";
	/**
	 * 错误编码-能量排名已存在
	 */
	public static final String WHEEL_DIAMOND_RANK_ENTITY_EXIST = "10013006";
	/**
	 * 错误描述-能量排名已存在
	 */
	public static final String WHEEL_DIAMOND_RANK_ENTITY_EXIST_MSG = "能量排名已存在";

	/**
	 * 错误编码-能量排名列表不存在
	 */
	public static final String WHEEL_DIAMOND_RANK_LIST_NOTEXIST = "10013007";
	/**
	 * 错误描述-能量排名列表不存在
	 */
	public static final String WHEEL_DIAMOND_RANK_LIST_NOTEXIST_MSG = "能量排名列表不存在";
	/**
	 * 错误编码-能量排名列表已存在
	 */
	public static final String WHEEL_DIAMOND_RANK_LIST_EXIST = "10013008";
	/**
	 * 错误描述-能量排名列表已存在
	 */
	public static final String WHEEL_DIAMOND_RANK_LIST_EXIST_MSG = "能量排名列表已存在";

	/**
	 * 错误编码-能量记录不存在
	 */
	public static final String WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST = "10013009";
	/**
	 * 错误描述-能量记录不存在
	 */
	public static final String WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST_MSG = "能量记录不存在";
	/**
	 * 错误编码-能量记录已存在
	 */
	public static final String WHEEL_DIAMOND_RECORD_ENTITY_EXIST = "10013010";
	/**
	 * 错误描述-能量记录已存在
	 */
	public static final String WHEEL_DIAMOND_RECORD_ENTITY_EXIST_MSG = "能量记录已存在";

	/**
	 * 错误编码-能量记录列表不存在
	 */
	public static final String WHEEL_DIAMOND_RECORD_LIST_NOTEXIST = "10013011";
	/**
	 * 错误描述-能量记录列表不存在
	 */
	public static final String WHEEL_DIAMOND_RECORD_LIST_NOTEXIST_MSG = "能量记录列表不存在";
	/**
	 * 错误编码-能量记录列表已存在
	 */
	public static final String WHEEL_DIAMOND_RECORD_LIST_EXIST = "10013012";
	/**
	 * 错误描述-能量记录列表已存在
	 */
	public static final String WHEEL_DIAMOND_RECORD_LIST_EXIST_MSG = "能量记录列表已存在";

	/**
	 * 错误编码-能量领取失败
	 */
	public static final String WHEEL_DIAMOND_RECORD_DRAW_HAS = "10013013";
	/**
	 * 错误描述-能量领取失败
	 */
	public static final String WHEEL_DIAMOND_RECORD_DRAW_HAS_MSG = "能量方块已领取";

	/**
	 * 错误编码-能量领取失败
	 */
	public static final String WHEEL_DIAMOND_RECORD_DRAW_FAIL = "10013014";
	/**
	 * 错误描述-能量领取失败
	 */
	public static final String WHEEL_DIAMOND_RECORD_DRAW_FAIL_MSG = "能量领取失败";

	/*----------------------------- 方向盘-能量boot错误编码(10013开头) -----------------------------*/

	/*----------------------------- 方向盘-算力boot错误编码(10014开头) -----------------------------*/
	/**
	 * 错误编码-算力配置不存在
	 */
	public static final String WHEEL_CALCULATE_CONFIG_ENTITY_NOTEXIST = "10014001";
	/**
	 * 错误描述-算力配置不存在
	 */
	public static final String WHEEL_CALCULATE_CONFIG_ENTITY_NOTEXIST_MSG = "算力配置不存在";
	/**
	 * 错误编码-算力配置已存在
	 */
	public static final String WHEEL_CALCULATE_CONFIG_ENTITY_EXIST = "10014002";
	/**
	 * 错误描述-算力配置已存在
	 */
	public static final String WHEEL_CALCULATE_CONFIG_ENTITY_EXIST_MSG = "算力配置已存在";

	/**
	 * 错误编码-算力配置列表不存在
	 */
	public static final String WHEEL_CALCULATE_CONFIG_LIST_NOTEXIST = "10014003";
	/**
	 * 错误描述-算力配置列表不存在
	 */
	public static final String WHEEL_CALCULATE_CONFIG_LIST_NOTEXIST_MSG = "算力配置列表不存在";
	/**
	 * 错误编码-算力配置列表已存在
	 */
	public static final String WHEEL_CALCULATE_CONFIG_LIST_EXIST = "10014004";
	/**
	 * 错误描述-算力配置列表已存在
	 */
	public static final String WHEEL_CALCULATE_CONFIG_LIST_EXIST_MSG = "算力配置列表已存在";

	/**
	 * 错误编码-算力排名不存在
	 */
	public static final String WHEEL_CALCULATE_RANK_ENTITY_NOTEXIST = "10014005";
	/**
	 * 错误描述-算力排名不存在
	 */
	public static final String WHEEL_CALCULATE_RANK_ENTITY_NOTEXIST_MSG = "算力排名不存在";
	/**
	 * 错误编码-算力排名已存在
	 */
	public static final String WHEEL_CALCULATE_RANK_ENTITY_EXIST = "10014006";
	/**
	 * 错误描述-算力排名已存在
	 */
	public static final String WHEEL_CALCULATE_RANK_ENTITY_EXIST_MSG = "算力配置已存在";

	/**
	 * 错误编码-算力排名列表不存在
	 */
	public static final String WHEEL_CALCULATE_RANK_LIST_NOTEXIST = "10014007";
	/**
	 * 错误描述-算力排名列表不存在
	 */
	public static final String WHEEL_CALCULATE_RANK_LIST_NOTEXIST_MSG = "算力排名列表不存在";
	/**
	 * 错误编码-算力排名列表已存在
	 */
	public static final String WHEEL_CALCULATE_RANK_LIST_EXIST = "10014008";
	/**
	 * 错误描述-算力排名列表已存在
	 */
	public static final String WHEEL_CALCULATE_RANK_LIST_EXIST_MSG = "算力排名列表已存在";

	/**
	 * 错误编码-算力记录不存在
	 */
	public static final String WHEEL_CALCULATE_RECORD_ENTITY_NOTEXIST = "10014009";
	/**
	 * 错误描述-算力记录不存在
	 */
	public static final String WHEEL_CALCULATE_RECORD_ENTITY_NOTEXIST_MSG = "算力记录不存在";
	/**
	 * 错误编码-算力记录已存在
	 */
	public static final String WHEEL_CALCULATE_RECORD_ENTITY_EXIST = "10014010";
	/**
	 * 错误描述-算力记录已存在
	 */
	public static final String WHEEL_CALCULATE_RECORD_ENTITY_EXIST_MSG = "算力记录已存在";

	/**
	 * 错误编码-算力记录列表不存在
	 */
	public static final String WHEEL_CALCULATE_RECORD_LIST_NOTEXIST = "10014011";
	/**
	 * 错误描述-算力记录列表不存在
	 */
	public static final String WHEEL_CALCULATE_RECORD_LIST_NOTEXIST_MSG = "算力记录列表不存在";
	/**
	 * 错误编码-算力记录列表已存在
	 */
	public static final String WHEEL_CALCULATE_RECORD_LIST_EXIST = "10014012";
	/**
	 * 错误描述-算力记录列表已存在
	 */
	public static final String WHEEL_CALCULATE_RECORD_LIST_EXIST_MSG = "算力记录列表已存在";
	/**
	 * 错误编码-gCode不存在
	 */
	public static final String WHEEL_CALCULATE_GOFUN_CODE_NOTEXIST = "10014013";
	/**
	 * 错误描述-gCode不存在
	 */
	public static final String WHEEL_CALCULATE_GOFUN_CODE_NOTEXIST_MSG = "GOFUN编码不存在";
	/**
	 * 错误编码-gCode已存在
	 */
	public static final String WHEEL_CALCULATE_GOFUN_CODE_EXIST = "10014014";
	/**
	 * 错误描述-gCode已存在
	 */
	public static final String WHEEL_CALCULATE_GOFUN_CODE_EXIST_MSG = "GOFUN编码已存在";
	/*----------------------------- 方向盘-算力boot错误编码(10014开头) -----------------------------*/
	/*----------------------------- 方向盘-优惠券boot错误编码(10015开头) -----------------------------*/
	/**
	 * 错误编码-优惠券不存在
	 */
	public static final String WHEEL_COUPON_ENTITY_NOTEXIST = "10015001";
	/**
	 * 错误描述-优惠券不存在
	 */
	public static final String WHEEL_COUPON_ENTITY_NOTEXIST_MSG = "优惠券不存在";
	/**
	 * 错误编码-优惠券已存在
	 */
	public static final String WHEEL_COUPON_ENTITY_EXIST = "10015002";
	/**
	 * 错误描述-优惠券已存在
	 */
	public static final String WHEEL_COUPON_ENTITY_EXIST_MSG = "优惠券已存在";

	/**
	 * 错误编码-优惠券列表不存在
	 */
	public static final String WHEEL_COUPON_LIST_NOTEXIST = "10015003";
	/**
	 * 错误描述-优惠券列表不存在
	 */
	public static final String WHEEL_COUPON_LIST_NOTEXIST_MSG = "优惠券列表不存在";
	/**
	 * 错误编码-优惠券列表已存在
	 */
	public static final String WHEEL_COUPON_LIST_EXIST = "10015004";
	/**
	 * 错误描述-优惠券列表已存在
	 */
	public static final String WHEEL_COUPON_LIST_EXIST_MSG = "优惠券列表已存在";

	/**
	 * 错误编码-优惠券不存在
	 */
	public static final String WHEEL_COUPON_LOG_ENTITY_NOTEXIST = "10015005";
	/**
	 * 错误描述-优惠券不存在
	 */
	public static final String WHEEL_COUPON_LOG_ENTITY_NOTEXIST_MSG = "优惠券不存在";

	/**
	 * 错误编码-优惠券列表不存在
	 */
	public static final String WHEEL_COUPON_LOG_LIST_NOTEXIST = "10015006";
	/**
	 * 错误描述-优惠券列表不存在
	 */
	public static final String WHEEL_COUPON_LOG_LIST_NOTEXIST_MSG = "优惠券日志列表不存在";

	/**
	 * 错误编码-gofun优惠券不存在
	 */
	public static final String WHEEL_GCOUPON_ENTITY_NOTEXIST = "10015007";
	/**
	 * 错误描述-gofun优惠券不存在
	 */
	public static final String WHEEL_GCOUPON_ENTITY_NOTEXIST_MSG = "gofun优惠券不存在";
	/**
	 * 错误编码-gofun优惠券已存在
	 */
	public static final String WHEEL_GCOUPON_ENTITY_EXIST = "10015008";
	/**
	 * 错误描述-gofun优惠券已存在
	 */
	public static final String WHEEL_GCOUPON_ENTITY_EXIST_MSG = "gofun优惠券已存在";

	/**
	 * 错误编码-gofun优惠券列表不存在
	 */
	public static final String WHEEL_GCOUPON_LIST_NOTEXIST = "10015009";
	/**
	 * 错误描述-gofun优惠券列表不存在
	 */
	public static final String WHEEL_GCOUPON_LIST_NOTEXIST_MSG = "gofun优惠券列表不存在";
	/**
	 * 错误编码-gofun优惠券列表已存在
	 */
	public static final String WHEEL_GCOUPON_LIST_EXIST = "10015010";
	/**
	 * 错误描述-gofun优惠券列表已存在
	 */
	public static final String WHEEL_GCOUPON_LIST_EXIST_MSG = "gofun优惠券列表已存在";

	/**
	 * 错误编码-优惠券关联不存在
	 */
	public static final String WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST = "10015011";
	/**
	 * 错误描述-优惠券关联不存在
	 */
	public static final String WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST_MSG = "优惠券关联不存在";
	/**
	 * 错误编码-优惠券关联已存在
	 */
	public static final String WHEEL_COUPON_GCOUPON_ENTITY_EXIST = "10015012";
	/**
	 * 错误描述-优惠券关联已存在
	 */
	public static final String WHEEL_COUPON_GCOUPON_ENTITY_EXIST_MSG = "优惠券关联已存在";

	/**
	 * 错误编码-优惠券关联列表不存在
	 */
	public static final String WHEEL_COUPON_GCOUPON_LIST_NOTEXIST = "10015013";
	/**
	 * 错误描述-优惠券关联列表不存在
	 */
	public static final String WHEEL_COUPON_GCOUPON_LIST_NOTEXIST_MSG = "优惠券关联列表不存在";
	/**
	 * 错误编码-优惠券关联列表已存在
	 */
	public static final String WHEEL_COUPON_GCOUPON_LIST_EXIST = "10015014";
	/**
	 * 错误描述-优惠券关联列表已存在
	 */
	public static final String WHEEL_COUPON_GCOUPON_LIST_EXIST_MSG = "优惠券关联列表已存在";

	/*----------------------------- 方向盘-优惠券boot错误编码(10015开头) -----------------------------*/

	/*----------------------------- 方向盘-排名boot错误编码(10016开头) -----------------------------*/
	/**
	 * 错误编码-排名不存在
	 */
	public static final String WHEEL_RANK_ENTITY_NOTEXIST = "10016001";
	/**
	 * 错误描述-排名不存在
	 */
	public static final String WHEEL_RANK_ENTITY_NOTEXIST_MSG = "排名不存在";
	/**
	 * 错误编码-排名已存在
	 */
	public static final String WHEEL_RANK_ENTITY_EXIST = "10016002";
	/**
	 * 错误描述-排名已存在
	 */
	public static final String WHEEL_RANK_ENTITY_EXIST_MSG = "排名已存在";

	/**
	 * 错误编码-排名列表不存在
	 */
	public static final String WHEEL_RANK_LIST_NOTEXIST = "10016003";
	/**
	 * 错误描述-排名列表不存在
	 */
	public static final String WHEEL_RANK_LIST_NOTEXIST_MSG = "排名列表不存在";
	/**
	 * 错误编码-排名列表已存在
	 */
	public static final String WHEEL_RANK_LIST_EXIST = "10016004";
	/**
	 * 错误描述-排名列表已存在
	 */
	public static final String WHEEL_RANK_LIST_EXIST_MSG = "排名列表已存在";

	/*----------------------------- 方向盘-排名boot错误编码(10016开头) -----------------------------*/

	/*----------------------------- 方向盘-数据推送boot错误编码(10017开头) -----------------------------*/
	/**
	 * 错误编码-数据推送不存在
	 */
	public static final String WHEEL_DATA_PUSH_ENTITY_NOTEXIST = "10017001";
	/**
	 * 错误描述-数据推送不存在
	 */
	public static final String WHEEL_DATA_PUSH_ENTITY_NOTEXIST_MSG = "数据推送不存在";
	/**
	 * 错误编码-数据推送已存在
	 */
	public static final String WHEEL_DATA_PUSH_ENTITY_EXIST = "10017002";
	/**
	 * 错误描述-数据推送已存在
	 */
	public static final String WHEEL_DATA_PUSH_ENTITY_EXIST_MSG = "数据推送已存在";

	/**
	 * 错误编码-数据推送列表不存在
	 */
	public static final String WHEEL_DATA_PUSH_LIST_NOTEXIST = "10017003";
	/**
	 * 错误描述-数据推送列表不存在
	 */
	public static final String WHEEL_DATA_PUSH_LIST_NOTEXIST_MSG = "数据推送列表不存在";
	/**
	 * 错误编码-数据推送列表已存在
	 */
	public static final String WHEEL_DATA_PUSH_LIST_EXIST = "10017004";
	/**
	 * 错误描述-数据推送列表已存在
	 */
	public static final String WHEEL_CDATA_PUSH_LIST_EXIST_MSG = "数据推送列表已存在";

	/*----------------------------- 方向盘-数据推送boot错误编码(10017开头) -----------------------------*/

	/*----------------------------- 方向盘-手续费配置boot错误编码(10018开头) -----------------------------*/
	/**
	 * 错误编码-手续费配置不存在
	 */
	public static final String WHEEL_FEE_CONFIG_ENTITY_NOTEXIST = "10018001";
	/**
	 * 错误描述-手续费配置不存在
	 */
	public static final String WHEEL_FEE_CONFIG_ENTITY_NOTEXIST_MSG = "手续费配置不存在";
	/**
	 * 错误编码-手续费配置已存在
	 */
	public static final String WHEEL_FEE_CONFIG_ENTITY_EXIST = "10018002";
	/**
	 * 错误描述-手续费配置已存在
	 */
	public static final String WHEEL_FEE_CONFIG_ENTITY_EXIST_MSG = "手续费配置已存在";

	/**
	 * 错误编码-手续费配置列表不存在
	 */
	public static final String WHEEL_FEE_CONFIG_LIST_NOTEXIST = "10018003";
	/**
	 * 错误描述-手续费配置列表不存在
	 */
	public static final String WHEEL_FEE_CONFIG_LIST_NOTEXIST_MSG = "手续费配置列表不存在";
	/**
	 * 错误编码-手续费配置列表已存在
	 */
	public static final String WHEEL_FEE_CONFIG_LIST_EXIST = "10018004";
	/**
	 * 错误描述-手续费配置列表已存在
	 */
	public static final String WHEEL_FEE_CONFIG_LIST_EXIST_MSG = "手续费配置列表已存在";

	/*----------------------------- 方向盘-手续费配置boot错误编码(10018开头) -----------------------------*/

	/*----------------------------- 方向盘-充币订单boot错误编码(10019开头) -----------------------------*/
	/**
	 * 错误编码-充币订单不存在
	 */
	public static final String WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST = "10019001";
	/**
	 * 错误描述-充币订单不存在
	 */
	public static final String WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST_MSG = "充币订单不存在";
	/**
	 * 错误编码-充币订单已存在
	 */
	public static final String WHEEL_ORDER_RECHARGECOIN_ENTITY_EXIST = "10019002";
	/**
	 * 错误描述-充币订单已存在
	 */
	public static final String WHEEL_ORDER_RECHARGECOIN_ENTITY_EXIST_MSG = "充币订单已存在";

	/**
	 * 错误编码-充币订单列表不存在
	 */
	public static final String WHEEL_ORDER_RECHARGECOIN_LIST_NOTEXIST = "10019003";
	/**
	 * 错误描述-充币订单列表不存在
	 */
	public static final String WHEEL_ORDER_RECHARGECOIN_LIST_NOTEXIST_MSG = "充币订单列表不存在";
	/**
	 * 错误编码-充币订单列表已存在
	 */
	public static final String WHEEL_ORDER_RECHARGECOIN_LIST_EXIST = "10019004";
	/**
	 * 错误描述-充币订单列表已存在
	 */
	public static final String WHEEL_ORDER_RECHARGECOIN_LIST_EXIST_MSG = "充币订单列表已存在";

	/*----------------------------- 方向盘-充币订单boot错误编码(10019开头) -----------------------------*/

	/*----------------------------- 方向盘-提币订单boot错误编码(10020开头) -----------------------------*/
	/**
	 * 错误编码-提币订单不存在
	 */
	public static final String WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST = "10020001";
	/**
	 * 错误描述-提币订单不存在
	 */
	public static final String WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST_MSG = "提币订单不存在";
	/**
	 * 错误编码-提币订单已存在
	 */
	public static final String WHEEL_ORDER_DRAWCOIN_ENTITY_EXIST = "10020002";
	/**
	 * 错误描述-提币订单已存在
	 */
	public static final String WHEEL_ORDER_DRAWCOIN_ENTITY_EXIST_MSG = "提币订单已存在";

	/**
	 * 错误编码-提币订单列表不存在
	 */
	public static final String WHEEL_ORDER_DRAWCOIN_LIST_NOTEXIST = "10020003";
	/**
	 * 错误描述-提币订单列表不存在
	 */
	public static final String WHEEL_ORDER_DRAWCOIN_LIST_NOTEXIST_MSG = "提币订单列表不存在";
	/**
	 * 错误编码-提币订单列表已存在
	 */
	public static final String WHEEL_ORDER_DRAWCOIN_LIST_EXIST = "10020004";
	/**
	 * 错误描述-提币订单列表已存在
	 */
	public static final String WHEEL_ORDER_DRAWCOIN_LIST_EXIST_MSG = "提币订单列表已存在";

	/*----------------------------- 方向盘-提币订单boot错误编码(10020开头) -----------------------------*/

	/*----------------------------- 方向盘-用户交易密码boot错误编码(10021开头) -----------------------------*/
	/**
	 * 错误编码-用户交易密码不存在
	 */
	public static final String WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_NOTEXIST = "10021001";
	/**
	 * 错误描述-用户交易密码不存在
	 */
	public static final String WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_NOTEXIST_MSG = "用户交易密码不存在";
	/**
	 * 错误编码-用户交易密码已存在
	 */
	public static final String WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_EXIST = "10021002";
	/**
	 * 错误描述-用户交易密码已存在
	 */
	public static final String WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_EXIST_MSG = "用户交易密码已存在";

	/**
	 * 错误编码-用户交易密码列表不存在
	 */
	public static final String WHEEL_USER_TRANSACTION_PASSWORD_LIST_NOTEXIST = "10021003";
	/**
	 * 错误描述-用户交易密码列表不存在
	 */
	public static final String WHEEL_USER_TRANSACTION_PASSWORD_LIST_NOTEXIST_MSG = "用户交易密码列表不存在";
	/**
	 * 错误编码-用户交易密码列表已存在
	 */
	public static final String WHEEL_USER_TRANSACTION_PASSWORD_LIST_EXIST = "10021004";
	/**
	 * 错误描述-用户交易密码列表已存在
	 */
	public static final String WHEEL_USER_TRANSACTION_PASSWORD_LIST_EXIST_MSG = "用户交易密码列表已存在";

	/*----------------------------- 方向盘-用户交易密码boot错误编码(10021开头) -----------------------------*/

	/*----------------------------- 方向盘-用户货币地址boot错误编码(10022开头) -----------------------------*/
	/**
	 * 错误编码-用户货币地址不存在
	 */
	public static final String WHEEL_USER_COINADDR_ENTITY_NOTEXIST = "10022001";
	/**
	 * 错误描述-用户货币地址不存在
	 */
	public static final String WHEEL_USER_COINADDR_ENTITY_NOTEXIST_MSG = "用户货币地址不存在";
	/**
	 * 错误编码-用户货币地址已存在
	 */
	public static final String WHEEL_USER_COINADDR_ENTITY_EXIST = "10022002";
	/**
	 * 错误描述-用户货币地址已存在
	 */
	public static final String WHEEL_USER_COINADDR_ENTITY_EXIST_MSG = "用户货币地址已存在";

	/**
	 * 错误编码-用户货币地址列表不存在
	 */
	public static final String WHEEL_USER_COINADDR_LIST_NOTEXIST = "10022003";
	/**
	 * 错误描述-用户货币地址列表不存在
	 */
	public static final String WHEEL_USER_COINADDR_LIST_NOTEXIST_MSG = "用户货币地址列表不存在";
	/**
	 * 错误编码-用户货币地址列表已存在
	 */
	public static final String WHEEL_USER_COINADDR_LIST_EXIST = "10022004";
	/**
	 * 错误描述-用户货币地址列表已存在
	 */
	public static final String WHEEL_USER_COINADDR_LIST_EXIST_MSG = "用户货币地址列表已存在";
	/*----------------------------- 方向盘-用户货币地址boot错误编码(10022开头) -----------------------------*/

	/*----------------------------- 方向盘-充提币bank服务boot错误编码(10023开头) -----------------------------*/
	// 具体错误码、错误信息参考microservice-provider-wheel-bank工程中的“com.ochain.wheel.bank.provider.eunms.ResultEnum”
	/*----------------------------- 方向盘-充提币bank服务boot错误编码(10023开头) -----------------------------*/
	/*----------------------------- 方向盘-验证码sms服务boot错误编码(10024开头) -----------------------------*/
	/**
	 * 错误编码-验证码不存在
	 */
	public static final String WHEEL_SMS_ENTITY_NOTEXIST = "10024001";
	/**
	 * 错误描述-验证码不存在
	 */
	public static final String WHEEL_SMS_ENTITY_NOTEXIST_MSG = "验证码不存在";
	/**
	 * 错误编码-验证码列表不存在
	 */
	public static final String WHEEL_SMS_LIST_NOTEXIST = "10024002";
	/**
	 * 错误描述-验证码列表不存在
	 */
	public static final String WHEEL_SMS_LIST_NOTEXIST_MSG = "验证码列表不存在";
	/*----------------------------- 方向盘-验证码sms服务boot错误编码(10024开头) -----------------------------*/

    /*----------------------------- boot系统统一错误编码 -----------------------------*/


}