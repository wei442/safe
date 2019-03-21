//package com.cloud.common.constants;
//
///**
// * boot第三方返回错误码 BootThirdConstants
// * @author wei.yong
// * @2017年03月02日
// */
//public class BootThirdConstants {
//
//    /*----------------------------- 第三方平台boot错误编码(2开头) -----------------------------*/
//    /*----------------------------- mappingserver boot错误编码(2001开头) -----------------------------*/
//    //ret返回值变量
//    public static final String RET_CODE = "retCode";
//    public static final String RET_MSG = "retMsg";
//    public static final String RET_RESULT = "result";
//    //boot返回值变量
//    public static final String BOOT_RESULT = "result";
//    //操作成功-8个0-返回给上层消费者使用
//    public static final String RET_OK = "00000000";
//    //操作成功
//    public static final String RET_OK_MSG = "success";
//    //系统错误编码
//    public static final String RET_ERROR_SYSTEM = "00000001";
//    //系统错误-详细描述
//    public static final String RET_ERROR_SYSTEM_MSG = "系统发生异常";
//    //错误编码-传入参数为空code
//    public static final String FLATFORM_FIELD_EMPTY = "20010001";
//    //只是显示message
//    public static final String FLATFORM_FIELD_EMPTY_MSG = "传入参数为空";
//    //错误编码-平台不存在code
//    public static final String PLATFORM_ENTITY_NOTEXIST = "20010002";
//    //平台不存在message
//    public static final String PLATFORM_ENTITY_NOTEXIST_MSG = "网站标识不正确";
//    //错误编码-平台未开通code
//    public static final String PLATFORM_ENTITY_NO_OPEN = "20010003";
//    //平台未开通message
//    public static final String PLATFORM_ENTITY_NO_OPEN_MSG = "网站标识未开通";
//    //错误编码-平台被冻结code
//    public static final String PLATFORM_ENTITY_FREEZE = "20010004";
//    //平台被冻结message
//    public static final String PLATFORM_ENTITY_FREEZE_MSG = "网站标识被冻结，请联系客服";
//    //错误编码-平台已失效code
//    public static final String PLATFORM_ENTITY_UNABLE = "20010005";
//    //平台已失效message
//    public static final String PLATFORM_ENTITY_UNABLE_MSG = "网站标识以失效";
//    //redis没有该数据code
//    public static final String PLATFORM_REDIS_LOGIN_NO = "20010006";
//    //redis没有该数据message
//    public static final String PLATFORM_REDIS_LGOIN_NO_MSG = "内存中暂无数据";
//    //redis没有该数据code
//    public static final String PLATFORM_REDIS_DATA_EXPIRED = "20010007";
//    //redis没有该数据message
//    public static final String PLATFORM_REDIS_DATA_EXPIRED_MSG = "内存数据已过期";
//    //错误编码-传入必要参数为空code
//    public static final String FLATFORM_TOPICID_EMPTY = "20010008";
//    //必要参数为空message
//    public static final String FLATFORM_TOPICID_EMPTY_MSG = "必要参数为空";
//    //错误编码-数据调用后已被删除code
//    public static final String FLATFORM_TOPICID_USED = "20010009";
//    //数据调用后已被删除message
//    public static final String FLATFORM_TOPICID_USED_MSG = "数据调用后已删除";
//    //错误编码-topicId已过期code
//    public static final String FLATFORM_TOPICID_TIMEOUT = "20010010";
//    //topicId已过期message
//    public static final String FLATFORM_TOPICID_TIMEOUT_MSG = "二维码已过期";
//    //错误编码-step传入必要参数为空code
//    public static final String FLATFORM_STEP_EMPTY = "20010011";
//    //必要参数为空message
//    public static final String FLATFORM_STEP_EMPTY_MSG = "STEP不能为空";
//    //错误编码-STEP传入必要参数错误code
//    public static final String FLATFORM_STEP_ERROR = "20010012";
//    //必要参数为空message
//    public static final String FLATFORM_STEP_ERROR_MSG = "STEP错误";
//    //错误编码-TYPE传入必要参数为空code
//    public static final String FLATFORM_TYPE_EMPTY = "20010013";
//    //必要参数为空message
//    public static final String FLATFORM_TYPE_EMPTY_MSG = "TYPE不能为空";
//    //错误编码-TYPE传入必要参数为空code
//    public static final String FLATFORM_TYPE_ERROR = "20010014";
//    //必要参数为空message
//    public static final String FLATFORM_TYPE_ERROR_MSG = "TYPE错误";
//    //错误编码-content传入必要参数为空code
//    public static final String FLATFORM_CONTENT_EMPTY = "20010015";
//    //必要参数为空message
//    public static final String FLATFORM_CONTENT_EMPTY_MSG = "CONTENT不能为空";
//    //错误编码-content传入必要参数为空code
//    public static final String JWT_DATA_ERROR = "20010016";
//    //必要参数为空message
//    public static final String JWT_DATA_ERROR_MSG = "JWT数据验签不能通过";
//    //错误编码-content传入必要参数为空code
//    public static final String URL_RETYPE_ERROR = "20010017";
//    //必要参数为空message
//    public static final String URL_RETYPE_ERROR_MSG = "接口名称错误";
//    /*----------------------------- mappingserver boot错误编码(2001开头) -----------------------------*/
//
//    /*----------------------------- web3j boot错误编码(2002开头) -----------------------------*/
//    /**
//     * 错误编码-web3j传入参数为空
//     */
//    public static final String WEB3J_FIELD_EMPTY = "20020001";
//    /**
//     * 错误描述-web3j传入参数为空
//     */
//    public static final String WEB3J_FIELD_EMPTY_MSG = "传入参数为空";
//    /**
//     * 错误编码-web3j错误
//     */
//    public static final String WEB3J_ERROR = "20020002";
//    /**
//     * 错误描述-web3j错误
//     */
//    public static final String WEB3J_ERROR_MSG = "web3j错误";
//    /*-----------------------------  web3j boot错误编码(2002开头) -----------------------------*/
//
//    /*----------------------------- ipfs boot错误编码(2003开头) -----------------------------*/
//    /**
//     * 错误编码-ipfs传入参数为空
//     */
//    public static final String IPFS_FIELD_EMPTY = "20030001";
//    /**
//     * 错误描述-ipfs传入参数为空
//     */
//    public static final String IPFS_FIELD_EMPTY_MSG = "传入参数为空";
//    /**
//     * 错误编码-ipfs错误
//     */
//    public static final String IPFS_ERROR = "20030002";
//    /**
//     * 错误描述-ipfs错误
//     */
//    public static final String IPFS_ERROR_MSG = "ipfs错误";
//    /*-----------------------------  ipfs boot错误编码(2003开头) -----------------------------*/
//
//    /*-----------------------------  redis boot错误编码(2004开头) -----------------------------*/
//    /**
//     * 错误编码-redis传入参数为空
//     */
//    public static final String REDIS_FIELD_EMPTY = "20040001";
//    /**
//     * 错误描述-redis传入参数为空
//     */
//    public static final String REDIS_FIELD_EMPTY_MSG = "传入参数为空";
//    /**
//     * 错误编码-redis错误
//     */
//    public static final String REDIS_ERROR = "20040002";
//    /**
//     * 错误描述-redis错误
//     */
//    public static final String REDIS_ERROR_MSG = "redis错误";
//    /*-----------------------------  redis boot错误编码(2004开头) -----------------------------*/
//
//    /*-----------------------------  SMS boot错误编码(2005开头) -----------------------------*/
//    /**
//     * 错误编码-短信发送传入参数为空
//     */
//    public static final String SMS_FIELD_EMPTY = "20050001";
//    /**
//     * 错误描述-短信发送传入参数为空
//     */
//  	public static final String SMS_FIELD_EMPTY_MSG = "用户短信发送传入参数为空";
//
//    /**
//     * 错误编码-短信发送失败
//     */
//    public static final String SMS_ERROR = "20050002";
//    /**
//     * 错误描述-短信发送失败
//     */
//    public static final String SMS_ERROR_MSG = "短信发送失败";
//    /*-----------------------------  SMS boot错误编码(2005开头) -----------------------------*/
//
//    /*-----------------------------  mail boot错误编码(2006开头) -----------------------------*/
//    /**
//     * 错误编码-传入参数为空
//     */
//    public static final String MAIL_FIELD_EMPTY = "20060001";
//    /**
//     * 错误描述-传入参数为空
//     */
//    public static final String MAIL_FIELD_EMPTY_MSG = "传入参数为空";
//    /**
//     * 错误编码-邮件发送失败
//     */
//    public static final String MAIL_ERROR = "20060002";
//    /**
//     * 错误描述-邮件发送失败
//     */
//    public static final String MAIL_ERROR_MSG = "邮件发送失败";
//    /*-----------------------------  mail boot错误编码(2006开头) -----------------------------*/
//    /*----------------------------- 第三方平台boot错误编码(2开头) -----------------------------*/
//
//}