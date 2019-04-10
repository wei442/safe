package com.cloud.common.enums.safe;

import com.cloud.common.constants.CommConstants;
import com.cloud.common.enums.ResultEnum;

public enum RetSafeAdminResultEnum implements ResultEnum {

	UNKNOWN_ERROR("-1", "unknown exception"),
	SYSTEM_ERROR(CommConstants.SYSTEM_ERROR, CommConstants.SYSTEM_ERROR_MSG),
	DATABASE_ERROR(CommConstants.DATABASE_ERROR, CommConstants.DATABASE_ERROR_MSG),
	DATABASE_NOTEXIST(CommConstants.DATABASE_NOTEXIST, CommConstants.DATABASE_NOTEXIST_MSG),
	NETWORK_ERROR("0000004", "非法请求"),
	PARAMETER_NULL("0000005", "参数为空"),
	PARAMETER_ERROR("0000005", "参数错误"),

	TOKEN_NULL_ERROR("0000006", "token为空"),
	TOKEN_JWT_ERROR("0000006", "token格式错误"),
	TOKEN_VERIFY_FAIL_ERROR("0000006", "token校验失败"),
	TOKEN_ERROR("0000007", "token错误"),
	TOKEN_EXPIRE("0000007", "token已过期"),

	USER_FIRST_LOGIN_CHANGE_PASSWORD("0000008", "您好，这是你第一次登录该企业的管理后台，请先设置管理密码"),

	FASTDFS_FILE_INFO_ERROR("0000008", "文件信息失败"),
	FASTDFS_UPLOAD_FILE_ERROR("0000008", "上传文件失败"),
	FASTDFS_UPLOAD_IMAGE_ERROR("0000008", "上传图片失败"),
	FASTDFS_DELETE_FILE_ERROR("0000008", "删除文件失败"),
	FASTDFS_DOWNLOAD_ERROR("0000008", "文件下载失败"),



//	/**
//	 * 错误编码-token错误
//	 */
//	public static final String TOKEN_ERROR = "0000005";
//	public static final String TOKEN_ERROR_MSG = "token错误";
//	public static final String TOKEN_FAIL = "token.error";
//	public static final String TOKEN_FAIL_MSG = "token失败";
//	public static final String TOKEN_VERIFY_FAIL = "token.verify.error";
//	public static final String TOKEN_VERIFY_FAIL_MSG = "token失败";
//
//	public static final String TOKEN_NULL_ERROR = "token.null";
//	public static final String TOKEN_NULL_ERROR_MSG = "token为空";
//	public static final String TOKEN_EXPIRE = "token.expire";
//	public static final String TOKEN_EXPIRE_MSG = "token已过期";
//	public static final String TOKEN_JWT_ERROR = "token.jwt.error";
//	public static final String TOKEN_JWT_ERROR_MSG = "token格式错误";




	;

	private String code;

	private String msg;

	private RetSafeAdminResultEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	/**
	 * @return the code
	 */
	@Override
	public String getCode() {
		return this.code;
	}

	/**
	 * @return the msg
	 */
	@Override
	public String getMsg() {
		return this.msg;
	}

}