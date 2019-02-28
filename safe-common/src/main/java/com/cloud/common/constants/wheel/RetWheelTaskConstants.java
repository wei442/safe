package com.cloud.common.constants.wheel;

import com.cloud.common.constants.RetConstants;

/**
 * ret方向盘任务返回错误码
 * @author wei.yong
 * @2017年04月24日
 */
public class RetWheelTaskConstants extends RetConstants {

	//算力排名时间 172,800秒 48小时(36*60*60)
	public static final Integer CALCULATE_RANK_TIME = 172800;
	//能量排名时间 172,800秒 48小时(36*60*60)
	public static final Integer DIAMOND_RANK_TIME = 172800;

	//任务编码
	public static final String TASK_CODE = "taskCode";
	//能量编码
	public static final String DIAMOND_CODE = "diamondCode";

	//编码-算力排名
	public static final String TASK_CODE_CALCULATE_RANK = "calculateRank";
	//编码-能量排名
	public static final String TASK_CODE_DIAMOND_RANK = "diamondRank";
	//编码-能量发放
	public static final String TASK_CODE_DIAMONDSEND = "diamondSend";

	//编码-临时登录用户算力排名-临时使用
	public static final String TASK_CODE_TEMP_LOGIN_CALCULATE_RANK = "tempLoginCalculateRank";
	//编码-临时登录用户能量排名-临时使用
	public static final String TASK_CODE_TEMP_LOGIN_DIAMOND_RANK = "tempLoginDiamondRank";
	//编码-临时删除redis注销用户状态-临时使用
	public static final String TASK_CODE_TEMP_REDIS_CANCEL_USER_STATUS = "tempRedisCancelUserStatus";

	/*--------------------------- 返回方向盘任务接收错误码  -----------------------------*/

	/**
	 * 错误编码-服务不可用
	 */
	public static final String SYSTEM_ERROR = "0110001";
	/**
	 * 错误描述-服务不可用
	 */
	public static final String SYSTEM_ERROR_MSG = "服务暂不可用";


	/**
	 * 错误编码-非法请求
	 */
	public static final String NETWORK_ERROR = "0110002";
	public static final String NETWORK_FAIL = "network.error";
	public static final String NETWORK_ERROR_MSG = "非法请求";

	/**
	 * 错误编码-token错误
	 */
	public static final String TOKEN_ERROR = "0110003";
	public static final String TOKEN_ERROR_MSG = "token错误";
	public static final String TOKEN_SIGN_ERROR = "token.sign.error";
	public static final String TOKEN_SIGN_ERROR_MSG = "token签名错误";

	public static final String TOKEN_NULL_ERROR = "token.null";
	public static final String TOKEN_NULL_ERROR_MSG = "token为空";
	public static final String TOKEN_EXPIRE = "token.expire";
	public static final String TOKEN_EXPIRE_MSG = "token已过期";

	public static final String TOKEN_ISSURE_ERROR = "token.issure.error";
	public static final String TOKEN_ISSURE_ERROR_MSG = "token发行者错误";
	public static final String TOKEN_AUDIENCE_ERROR = "token.audience.error";
	public static final String TOKEN_AUDIENCE_ERROR_MSG = "token观众错误";
	public static final String TOKEN_NOTBEFORE_ERROR = "token.notberfore.error";
	public static final String TOKEN_NOTBEFORE_ERROR_MSG = "token生效时间错误";
	public static final String TOKEN_EXPIRATION_ERROR = "token.expiration.error";
	public static final String TOKEN_EXPIRATION_ERROR_MSG = "token过期时间错误";

	/**
	 * 错误编码-参数错误
	 */
	public static final String PARAMETER_ERROR = "0110004";
	public static final String PARAMETER_NULL_ERROR_MSG = "参数为空";
	public static final String PARAMETER_ERROR_MSG = "参数错误";

	/**
	 * 错误编码-能量编码已删除
	 */
	public static final String DIAMONDSEND_CODE_ERROR = "0110005";
	public static final String DIAMONDSEND_CODE_ERROR_MSG = "能量编码已删除";

	/*--------------------------- 返回方向盘任务错误码  -----------------------------*/

}