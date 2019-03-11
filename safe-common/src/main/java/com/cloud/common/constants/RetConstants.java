package com.cloud.common.constants;

/**
 * ret返回错误码-返回给app
 * @author wei.yong
 * @2017年04月24日
 */
public class RetConstants {

	public static final String RET_CODE = "retCode";
	public static final String RET_MSG = "retMsg";
	public static final String SUB_CODE = "subCode";
	public static final String SUB_MSG = "subMsg";
	public static final String RESULT = "result";

	//操作成功-7个0-返回给app接口
	public static final String OK = "0000000";
	//操作成功
	public static final String OK_MSG = "success";

	//分号
	public static final String SEMICOLON = ";";
	//逗号
	public static final String COMMOA = ",";
	//点号
  	public static final String DOT = ".";

	//Content-Type
	public static final String CONTENT_TYPE = "Content-Type";

	//60秒 1分钟(60)
	public static final Integer ONE_MINUTE_SECONDS_TIME = 60;

	//300秒 5分钟(5*60)
	public static final Integer FIVE_MINUTE_SECONDS_TIME = 300;

	//3600秒 1小时(1*60*60)
	public static final Integer ONE_HOUR_SECONDS_TIME = 3600;
	//7200秒 2小时(2*60*60)
	public static final Integer TWO_HOUR_SECONDS_TIME = 7200;
	//86400秒 24小时(24*60*60)
	public static final Integer TWENTY_FOUR_HOUR_SECONDS_TIME = 86400;

	//token
	public static final String TOKEN = "token";
	//webtoken
	public static final String WEB_TOKEN = "webtoken";

	//claims
	public static final String CLAIMS = "claims";

//	/*----------------------------- 系统统一错误编码 -----------------------------*/
//    /**
//     * 错误编码-系统错误
//     */
//    public static final String SYSTEM_ERROR = "00000001";
//    /**
//     * 错误描述-系统错误
//     */
//    public static final String SYSTEM_ERROR_MSG = "事务性异常";
//
//    /**
//     * 错误编码-数据不存在(数据库操作失败)
//     * 数据库操作失败通用型编码，如果需要返回详细错误，请使用详细错误编码
//     */
//    public static final String DATABASE_ERROR = "00000002";
//    /**
//     * 错误描述-数据不存在(数据库操作失败)
//     */
//    public static final String DATABASE_ERROR_MSG = "数据操作失败";
//    /*----------------------------- 系统统一错误编码 -----------------------------*/

}