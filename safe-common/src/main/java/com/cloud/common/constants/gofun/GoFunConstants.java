package com.cloud.common.constants.gofun;

/**
 * gofun返回错误码 GoFunConstants
 * @author wei.yong
 * @2017年03月02日
 */
public class GoFunConstants {

	//gofun编码和信息
    public static final String CODE = "code";
	public static final String MSG = "message";
	public static final String DATA = "data";

    //200表示成功
    public static final String OK = "200";
    //操作成功
    public static final String OK_MSG = "success";

    //201	已处理，重复提交时
    public static final String ERROR_201 = "201";
    public static final String ERROR_201_MSG = "已处理，重复提交时";

    //103	不合法的请求参数
    public static final String ERROR_103 = "103";
    public static final String ERROR_103_MSG = "不合法的请求参数";
    //104	不支持的请求方法
    public static final String ERROR_104 = "104";
    public static final String ERROR_104_MSG = "不支持的请求方法";
    //105	不合法的请求包体,需要json格式
    public static final String ERROR_105 = "105";
    public static final String ERROR_105_MSG = "不合法的请求包体,需要json格式";
    //106	SQL异常
    public static final String ERROR_106 = "106";
    public static final String ERROR_106_MSG = "SQL异常";

    //500	未知的服务器异常
    public static final String ERROR_500 = "500";
    public static final String ERROR_500_MSG = "未知的服务器异常";
    //501	接口调用超过限制
    public static final String ERROR_501 = "501";
    public static final String ERROR_501_MSG = "接口调用超过限制";
    //502	api调用太频繁，请稍候再试
    public static final String ERROR_502 = "502";
    public static final String ERROR_502_MSG = "api调用太频繁，请稍候再试";

    //1001	用户手机号不正确
    public static final String ERROR_1001 = "1001";
    public static final String ERROR_1001_MSG = "用户手机号不正确";
    //1002	验证码错误
    public static final String ERROR_1002 = "1002";
    public static final String ERROR_1002_MSG = "验证码错误";
    //1003	用户名与密码不正确
    public static final String ERROR_1003 = "1003";
    public static final String ERROR_1003_MSG = "用户名与密码不正确";
    //1004	用户无权限
    public static final String ERROR_1004 = "1004";
    public static final String ERROR_1004_MSG = "用户无权限";
    // 1005	无用户信息
    public static final String ERROR_1005 = "1005";
    public static final String ERROR_1005_MSG = "无用户信息";
    //1006	验证码重复发送
    public static final String ERROR_1006 = "1006";
    public static final String ERROR_1006_MSG = "验证码重复发送";

    /**********************************  GoFun常量  **********************************/
    //押金  1已交或免交 0未交
    public static final String USER_VERIFYDEPOSIT_NO = "0";
    public static final String USER_VERIFYDEPOSIT_YES = "1";

    //驾驶证 1审核通过  0审核不通过
    public static final String USER_VERIFYLICENSE_NO = "0";
    public static final String USER_VERIFYLICENSE_YES = "1";

    //用户免密开关   1免密  0非免密
    public static final String USER_FREESWITCH_NO = "0";
    public static final String USER_FREESWITCH_YES = "1";

    //身份证 1 审核通过  0审核不通过
    public static final String USER_VERIFYCARD_NO = "0";
    public static final String USER_VERIFYCARD_YES = "1";

    //是否成功用车 1成功用车  0未成用车
    public static final String USER_CARTYPE_NO = "0";
    public static final String USER_CARTYPE_YES = "1";
    /**********************************  GoFun常量  **********************************/

}