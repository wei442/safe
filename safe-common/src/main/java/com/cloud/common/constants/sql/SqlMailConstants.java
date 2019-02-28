package com.cloud.common.constants.sql;

/**
 * (mail)邮件数据库常量类 SqlMailConstants
 * @author luo.peipei
 */
public class SqlMailConstants {

	/**********************************  邮件数据库常量  **********************************/

    //用户邮件状态 0-成功, 1-失败
    public static final Integer SQL_MAIL_STATUS_SUCCESS = 0;
    public static final Integer SQL_MAIL_STATUS_FAIL = 1;

    //用户邮件发送类型 1-普通邮件, 2-附件
    public static final Integer SQL_MAIL_TYPE_COMMON = 1;
    public static final Integer SQL_MAIL_TYPE_ATTACHMENT = 2;

    //邮件来源，如IMI, ent(法人)等
    public static final String SQL_MAIL_SOURCE_IMI = "IMI";
    public static final String SQL_MAIL_SOURCE_ENT = "IMI";
    public static final String SQL_MAIL_SOURCE_DATASHARE = "DATASHARE";

	/**********************************  邮件数据库常量  **********************************/
}
