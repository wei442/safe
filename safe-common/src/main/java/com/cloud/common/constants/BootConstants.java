package com.cloud.common.constants;

/**
 * boot返回错误码 BootConstants
 * @author wei.yong
 * @2017年03月02日
 */
public class BootConstants {

	//boot编码和boot信息
    public static final String BOOT_CODE = "bootCode";
	public static final String BOOT_MSG = "bootMsg";
	public static final String BOOT_SUB_CODE = "bootSubCode";
	public static final String BOOT_SUB_MSG = "bootSubMsg";

    //操作成功-8个0-返回给上层消费者使用
    public static final String OK = "00000000";
    //操作成功
    public static final String OK_MSG = "success";

    //分号
  	public static final String SEMICOLON = ";";
  	//逗号
  	public static final String COMMOA = ",";
  	//点号
  	public static final String DOT = ".";

    /*----------------------------- boot系统统一错误编码 -----------------------------*/
    /**
     * 错误编码-系统错误
     */
    public static final String BOOT_SYSTEM_ERROR = "00000001";
    /**
     * 错误描述-系统错误
     */
    public static final String BOOT_SYSTEM_ERROR_MSG = "事务性异常";

    /**
     * 错误编码-数据库操作失败编码
     * 数据库操作失败通用型编码，如果需要返回详细错误，请使用详细错误编码
     */
    public static final String BOOT_DATABASE_ERROR = "00000002";
    /**
     * 错误描述-数据库操作失败
     */
    public static final String BOOT_DATABASE_ERROR_MSG = "数据库操作失败";
    /*----------------------------- boot系统统一错误编码 -----------------------------*/
    /*----------------------------- boot系统统一错误编码 -----------------------------*/

    /*----------------------------- 第三方平台boot错误编码(2开头) -----------------------------*/
    /*----------------------------- ipfs boot错误编码(2001开头) -----------------------------*/
    /**
     * 错误编码-ipfs传入参数为空
     */
    public static final String IPFS_FIELD_EMPTY = "20010001";
    /**
     * 错误描述-ipfs传入参数为空
     */
    public static final String IPFS_FIELD_EMPTY_MSG = "传入参数为空";
    /**
     * 错误编码-ipfs错误
     */
    public static final String IPFS_ERROR = "20010002";
    /**
     * 错误描述-ipfs错误
     */
    public static final String IPFS_ERROR_MSG = "ipfs错误";
    /*-----------------------------  ipfs boot错误编码(2001开头) -----------------------------*/

    /*-----------------------------  redis boot错误编码(2002开头) -----------------------------*/
    /**
     * 错误编码-redis传入参数为空
     */
    public static final String REDIS_FIELD_EMPTY = "20020001";
    /**
     * 错误描述-redis传入参数为空
     */
    public static final String REDIS_FIELD_EMPTY_MSG = "传入参数为空";
    /**
     * 错误编码-redis错误
     */
    public static final String REDIS_ERROR = "20020002";
    /**
     * 错误描述-redis错误
     */
    public static final String REDIS_ERROR_MSG = "redis错误";
    /**
     * 错误编码-redis空信息错误
     */
    public static final String REDIS_NULL_ERROR = "20020003";
    /**
     * 错误描述-redis空信息错误
     */
    public static final String REDIS_NULL_ERROR_MSG = "redis空信息错误";
    /*-----------------------------  redis boot错误编码(2002开头) -----------------------------*/

    /*-----------------------------  SMS boot错误编码(2003开头) -----------------------------*/
    /**
     * 错误编码-短信发送传入参数为空
     */
    public static final String SMS_FIELD_EMPTY = "20030001";
    /**
     * 错误描述-短信发送传入参数为空
     */
  	public static final String SMS_FIELD_EMPTY_MSG = "用户短信发送传入参数为空";

    /**
     * 错误编码-短信发送失败
     */
    public static final String SMS_ERROR = "20030002";
    /**
     * 错误描述-短信发送失败
     */
    public static final String SMS_ERROR_MSG = "短信发送失败";
    /*-----------------------------  SMS boot错误编码(2003开头) -----------------------------*/

    /*-----------------------------  mail boot错误编码(2004开头) -----------------------------*/
    /**
     * 错误编码-传入参数为空
     */
    public static final String MAIL_FIELD_EMPTY = "20040001";
    /**
     * 错误描述-传入参数为空
     */
    public static final String MAIL_FIELD_EMPTY_MSG = "传入参数为空";
    /**
     * 错误编码-邮件发送失败
     */
    public static final String MAIL_ERROR = "20040002";
    /**
     * 错误描述-邮件发送失败
     */
    public static final String MAIL_ERROR_MSG = "邮件发送失败";
    /*-----------------------------  mail boot错误编码(2004开头) -----------------------------*/
    /*----------------------------- 第三方平台boot错误编码(2开头) -----------------------------*/

}