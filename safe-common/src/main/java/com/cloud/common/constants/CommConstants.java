package com.cloud.common.constants;

/**
 * 公共常量类
 *
 * @author S.J.
 * @date 2019/02/20
 */
public class CommConstants {

	public static final String RET_CODE = "retCode";
	public static final String RET_MSG = "retMsg";
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

	//600秒 10分钟(10*60)
	public static final Integer TEN_MINUTE_SECONDS_TIME = 300;

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
	//cloud
	public static final String CLOUD = "cloud";

	public static final String ENTERPRISE_ID = "enterpriseId";
	public static final String ENTERPRISE_NAME = "enterpriseName";
	public static final String USER_ID = "userId";
	public static final String USER_ACCOUNT = "userAccount";
	public static final String ORG_ID = "orgId";
	public static final String ORG_NAME = "orgName";
	public static final String BASE_USER_ID = "baseUserId";

  	/*----------------------------- 系统统一错误编码 -----------------------------*/
    /**
     * 错误编码-系统错误
     */
    public static final String SYSTEM_ERROR = "00000001";
    /**
     * 错误描述-系统错误
     */
    public static final String SYSTEM_ERROR_MSG = "当前系统繁忙，请稍后再试";

    /**
     * 错误编码-数据操作失败(数据不存在)
     */
    public static final String DATABASE_ERROR = "00000002";
    /**
     * 错误描述-数据操作失败(数据不存在)
     */
    public static final String DATABASE_ERROR_MSG = "数据操作失败";

    /**
     * 错误编码-数据不存在
     * 数据库操作失败通用型编码，如果需要返回详细错误，请使用详细错误编码
     */
    public static final String DATABASE_NOTEXIST = "00000003";
    /**
     * 错误描述-数据不存在
     */
    public static final String DATABASE_NOTEXIST_MSG = "数据不存在";

    /*----------------------------- 系统统一错误编码 -----------------------------*/

}
