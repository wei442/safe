package com.cloud.common.constants.sql;

/**
 * (sms)短信数据库常量类 SqlSmsConstants
 * @author wei.yong
 */
public class SqlSmsConstants {

	/**********************************  短信数据库常量  **********************************/

    //用户短信状态 0-正常, 1-失败
    public static final Integer SQL_SMS_STATUS_SUCESS = 0;
    public static final Integer SQL_SMS_STATUS_FAIL = 1;

    //用户短信发送类型 1-单发, 2-群发, 3-定时发送
    public static final Integer SQL_SMS_TYPE_SINGLE = 1;
    public static final Integer SQL_SMS_TYPE_GROUP = 2;
    public static final Integer SQL_SMS_TYPE_TIME = 3;

	//短信来源 如IMI, ent(法人)等
	public static final String SQL_SMS_SOURCE_IMI = "IMI";
	public static final String SQL_SMS_SOURCE_ENT = "ENT";
	/**********************************  短信数据库常量  **********************************/

}
