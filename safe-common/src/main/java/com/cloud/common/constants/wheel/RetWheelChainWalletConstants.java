package com.cloud.common.constants.wheel;

import com.cloud.common.constants.RetConstants;

/**
 * ret方向盘返回错误码-返回给app
 * @author wei.yong
 * @2017年04月24日
 */
public class RetWheelChainWalletConstants extends RetConstants {

	//token过期时间 2592000秒 30天(30*24*60*60)
	public static final Integer TOKEN_TIME = 2592000;
	//用户签到86400秒 24小时(24*60*60)
	public static final Integer USER_SIGN_TIME = 86400;

	public static final String USER_ID = "userId";
	public static final String USER_ACCOUNT = "userAccount";
	public static final String GID = "gId";

	//短信验证类型 draw-设置交易提取密码；resetDraw-重设交易提取密码
	public static final String SMS_VERIFY_TYPE_DRAW = "draw";
	public static final String SMS_VERIFY_TYPE_RESETDRAW = "resetDraw";

	//验证码过期时间 120秒(2分钟)
	public static final Integer SMS_VERIFY_CODE_TIME = 120;

	//密码访问时间 3000秒(5分钟)
	public static final Integer ACCESS_PASSWORD_TIME = 300;

	/*--------------------------- 返回app错误码  -----------------------------*/
	/**
	 * 错误编码-服务不可用
	 */
	public static final String SYSTEM_ERROR = "0000001";
	/**
	 * 错误描述-服务不可用
	 */
	public static final String SYSTEM_ERROR_MSG = "当前系统繁忙，请稍后再试";
	/**
	 * lbp-内部业务简称
	 */
	public static final String LBP_SYSTEM_ERROR = "lbp.system.error";
	public static final String LBP_SYSTEM_ERROR_MSG = "当前系统繁忙，请稍后再试";
	/**
	 * tdp-第三方简称
	 */
	public static final String TDP_BLOCKCHAIN_ERROR = "tdp.blockchain.error";
	public static final String TDP_BLOCKCHAIN_ERROR_MSG = "区块链服务繁忙，请稍后再试";
	public static final String TDP_GOFUN_ERROR = "tdp.gofun.error";
	public static final String TDP_GOFUN_ERROR_MSG = "gofun系统繁忙，请稍后再试";
	public static final String TDP_BANK_ERROR = "tdp.bank.error";
	public static final String TDP_BANK_ERROR_MSG = "bank服务繁忙，请稍后再试";

	/**
     * 错误编码-数据库操作失败编码
     * 数据库操作失败通用型编码，如果需要返回详细错误，请使用详细错误编码
     */
    public static final String DATABASE_ERROR = "00000002";
    public static final String DATABASE_FAIL = "database.error";
    public static final String DATABASE_ERROR_MSG = "操作失败";

	/**
	 * 错误编码-非法请求
	 */
	public static final String NETWORK_ERROR = "0000003";
	public static final String NETWORK_FAIL = "network.error";
	public static final String NETWORK_ERROR_MSG = "非法请求";

	/**
	 * 错误编码-参数错误
	 */
	public static final String PARAMETER_ERROR = "0000004";
	public static final String PARAMETER_NULL_ERROR_MSG = "参数为空";
	public static final String PARAMETER_ERROR_MSG = "参数错误";

	/**
	 * 错误编码-token错误
	 */
	public static final String TOKEN_ERROR = "0000005";
	public static final String TOKEN_ERROR_MSG = "token错误";
	public static final String TOKEN_FAIL = "token.error";
	public static final String TOKEN_FAIL_MSG = "token失败";
	public static final String TOKEN_VERIFY_FAIL = "token.verify.error";
	public static final String TOKEN_VERIFY_FAIL_MSG = "token失败";

	public static final String TOKEN_NULL_ERROR = "token.null";
	public static final String TOKEN_NULL_ERROR_MSG = "token为空";
	public static final String TOKEN_EXPIRE = "token.expire";
	public static final String TOKEN_EXPIRE_MSG = "token已过期";
	public static final String TOKEN_JWT_ERROR = "token.jwt.error";
	public static final String TOKEN_JWT_ERROR_MSG = "token格式错误";

	/**
	 * 错误编码-验证码输入错误，请重新输入
	 */
	public static final String VERIFY_CODE_ERROR = "0000006";
	public static final String VERIFY_CODE_TYPE_ERROR = "verifycode.type.error";
	public static final String VERIFY_CODE_TYPE_ERROR_MSG = "验证类型错误";
	public static final String VERIFY_CODE_FAIL = "verifycode.error";
	public static final String VERIFY_CODE_ERROR_MSG = "验证码输入错误，请重新输入";
	public static final String VERIFY_CODE_EXPIRE = "verifycode.expire";
	public static final String VERIFY_CODE_EXPIRE_MSG = "验证码已过期，请重新获取";

	/**
	 * 错误编码-身份证错误
	 */
	public static final String IDCARD_ERROR = "0000007";
	public static final String IDCARD_NOT_EXIST = "idcard.not.exist";
	public static final String IDCARD_NOT_EXIST_MSG = "身份证信息校验不一致";


	/**
	 * 错误编码-访问密码错误
	 */
	public static final String ACCESS_PASSWORD_ERROR = "0000008";
	public static final String ACCESS_PASSWORD_FAIL = "access.password.error";
	public static final String ACCESS_PASSWORD_ERROR_MSG = "访问密码错误";
	public static final String ACCESS_PASSWORD_DRAW_EXPIRE = "access.password.draw.expire";
	public static final String ACCESS_PASSWORD_DRAW_EXPIRE_MSG = "提取密码已过期";
	public static final String ACCESS_PASSWORD_RESETDRAW_EXPIRE = "access.password.resetdraw.expire";
	public static final String ACCESS_PASSWORD_RESETDRAW_EXPIRE_MSG = "重设提取密码已过期";

	/**
	 * 错误编码-提取密码错误
	 */
	public static final String DRAW_PASSWORD_ERROR = "0000009";
	public static final String DRAW_PASSWORD_FAIL = "draw.password.error";
	public static final String DRAW_PASSWORD_ERROR_MSG = "提取密码错误";

	/**
	 * 错误编码-预提取密码错误
	 */
	public static final String PRE_DRAW_PASSWORD_ERROR = "0000010";
	public static final String PRE_DRAW_PASSWORD_EXIST = "pre.draw.password.exist";
	public static final String PRE_DRAW_PASSWORD_EXIST_MSG = "提取密码已设置";

	/**
	 * 错误编码-账户地址错误
	 */
	public static final String ADDR_ERROR = "0000011";
	public static final String ADDR_FROM_NOTEXIST = "addr.from.notexist";
	public static final String ADDR_FROM_NOTEXIST_MSG = "无可用提取账户";
	public static final String ADDR_TO_NOTEXIST = "addr.to.notexist";
	public static final String ADDR_TO_NOTEXIST_MSG = "无可用充值账户";

	/**
	 * 错误编码-提取错误
	 */
	public static final String DRAW_ERROR = "0000012";
	public static final String DRAW_QUANTITY_NOTENOUGH = "draw.quantity.notenough";
	public static final String DRAW_QUANTITY_NOTENOUGH_MSG = "提取数量不足";

	public static final String DRAW_QUANTITY_GREATERTHAN_ZERO = "draw.quantity.greaterthan.zero";
	public static final String DRAW_QUANTITY_GREATERTHAN_ZERO_MSG = "提取数量必须大于0";

	public static final String DRAW_QUANTITY_TRANSFER_GREATERTHAN_ZERO = "draw.transfer.greaterthan.zero";
	public static final String DRAW_QUANTITY_TRANSFER_GREATERTHAN_ZERO_MSG = "转账数量必须大于0";

	public static final String DRAW_ORDER_NOTEXIST = "draw.order.notexist";
	public static final String DRAW_ORDER_NOTEXIST_MSG = "提币订单不存在";

	public static final String DRAW_ORDER_HAS_DRAW = "draw.order.has.draw";
	public static final String DRAW_ORDER_HAS_DRAW_MSG = "提币订单已提币";

	public static final String DRAW_ORDER_NOTCONTINUE_DRAW = "draw.order.not.continue.draw";
	public static final String DRAW_ORDER_NOTCONTINUE_DRAW_MSG = "请不要连续提币";

	/**
	 * 错误编码-充值错误
	 */
	public static final String RECHARGE_ERROR = "0000013";
	public static final String RECHARGE_ORDER_NOTEXIST = "recharge.order.notexist";
	public static final String RECHARGE_ORDER_NOTEXIST_MSG = "充币订单不存在";

	public static final String RECHARGE_ORDER_HAS_RECHARGE = "recharge.order.has.recharge";
	public static final String RECHARGE_ORDER_HAS_RECHARGE_MSG = "充币订单已充币";

	public static final String RECHARGE_ORDER_NOTCONTINUE_RECHARGE = "recharge.order.not.continue.recharge";
	public static final String RECHARGE_ORDER_NOTCONTINUE_RECHARGE_MSG = "请不要连续充币";
	/*--------------------------- 返回app错误码  -----------------------------*/

	/*--------------------------- 第三方错误码  -----------------------------*/
	/*--------------------------- GoFun错误码  -----------------------------*/
	/**
	 * 错误编码-GoFun错误
	 */
	public static final String GOFUN_ERROR = "0100001";
	/**
	 * 错误描述-GoFun错误
	 */
	public static final String GOFUN_ERROR_MSG = "oFun错误";
	public static final String GOFUN_NULL_ERROR = "gofun.null.error";
	public static final String GOFUN_NULL_ERROR_MSG = "传入参数为空";
	/*--------------------------- GoFun错误码  -----------------------------*/
	/*--------------------------- 第三方错误码  -----------------------------*/


}