package com.ochain.consumer.wheel.controllers;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.gofun.GoFunConstants;
import com.ochain.common.constants.gofun.PushConstants;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.RetWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.constants.wheel.WheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.redis.keys.RedisKeysUtil;
import com.ochain.common.security.KeyFactoryUtil;
import com.ochain.common.sign.security.AESUtils;
import com.ochain.common.util.IpUtil;
import com.ochain.consumer.wheel.service.ICouponLogService;
import com.ochain.consumer.wheel.service.IDiamondConfigService;
import com.ochain.consumer.wheel.service.IDiamondRecordService;
import com.ochain.consumer.wheel.service.IRedisLockService;
import com.ochain.consumer.wheel.service.IRedisService;
import com.ochain.consumer.wheel.util.TokenUtil;
import com.ochain.consumer.wheel.vo.account.AccountCalculateCivilizeTaskVo;
import com.ochain.consumer.wheel.vo.account.AccountCalculateTaskVo;
import com.ochain.consumer.wheel.vo.calculate.CalculateRankContentVo;
import com.ochain.consumer.wheel.vo.calculate.LoginCalculateRealRankVo;
import com.ochain.consumer.wheel.vo.coupon.CouponVo;
import com.ochain.consumer.wheel.vo.diamond.DiamondConfigVo;
import com.ochain.consumer.wheel.vo.diamond.DiamondRankContentVo;
import com.ochain.consumer.wheel.vo.diamond.LoginDiamondRealRankVo;
import com.ochain.consumer.wheel.vo.gofun.AreaVo;
import com.ochain.consumer.wheel.vo.gofun.CarOrderVo;
import com.ochain.consumer.wheel.vo.gofun.UserTaskVo;
import com.ochain.consumer.wheel.vo.user.UserCalculateConfigVo;
import com.ochain.consumer.wheel.vo.user.UserCarOrderVo;

import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 控制基类 BaseController
 * @author wei.yong
 */
@RestController
public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	protected HttpServletRequest request;

	@Autowired
	protected HttpServletResponse response;

	//redis Service
	@Autowired
	protected IRedisService redisService;

	//redis lock Service
	@Autowired
	protected IRedisLockService redisLockService;

	//能量配置日志 Service
	@Autowired
	private IDiamondConfigService diamondConfigService;

	//能量记录 Service
	@Autowired
	private IDiamondRecordService diamondRecordService;

	//优惠券日志 Service
	@Autowired
	private ICouponLogService couponLogService;

	//开发和线上环境配置
	@Value("${spring.profiles.active}")
	protected String springProfilesActive;

	//token的rsa的私钥
	@Value("${token.rsa.privateKey}")
	protected String rsaPrivateKeyStr;

	//token的aes的密钥
	@Value("${token.claims.aes.secretKey}")
	protected String aesSecretKeyStr;

	//gofun的portal
	@Value("${gofun.portal}")
	protected String gofunPortal;

	//登录用户算力实时排名key（存储用户id和用户账户）
	protected String loginCalculateRankRealKey = RedisKeysUtil.CN_OCHAIN_WHEEL_LOGIN_RANK_CALCULATE_REAL_TIME;
	//登录用户能量实时排名key（存储用户id和用户账户）
	protected String loginDiamondRankRealKey = RedisKeysUtil.CN_OCHAIN_WHEEL_LOGIN_RANK_DIAMOND_REAL_TIME;

	//登录用户算力实时排名key（存储用户账户）
	protected String calculateRankRealKey = RedisKeysUtil.CN_OCHAIN_WHEEL_RANK_CALCULATE_REAL_TIME;
	//登录用户能量实时排名key（存储用户账户）
	protected String diamondRankRealKey = RedisKeysUtil.CN_OCHAIN_WHEEL_RANK_DIAMOND_REAL_TIME;

	//算力昨日排名key
	protected String calculateYesterdayRankKey = RedisKeysUtil.CN_OCHAIN_WHEEL_RANK_CALCULATE_YESTERDAY;
	//能量昨日排名key
	protected String diamondYesterdayRankKey = RedisKeysUtil.CN_OCHAIN_WHEEL_RANK_DIAMOND_YESTERDAY;

	//算力昨日账户排名key
	protected String calculateYesterdayUserIdRankKey = RedisKeysUtil.CN_OCHAIN_WHEEL_RANK_CALCULATE_YESTERDAY_USERID;
	//能量昨日账户排名key
	protected String diamondYesterdayUserIdRankKey = RedisKeysUtil.CN_OCHAIN_WHEEL_RANK_DIAMOND_YESTERDAY_USERID;

	//实时排名100名，因为redis存储的下标是从0开始，所以是99
	protected final Integer realRank = 99;
	//昨日排名100名，因为redis存储的下标是从0开始，所以是99
	protected final Integer yesterdayRank = 99;

	//排名10000个
	protected final Integer sortRank = 10000;

	/**
	 * 设置token 在response header里面
	 * @param response
	 * @param token (proxyAddr作为token)
	 */
	protected void setResponseHeader(String token) {
		logger.info("(BaseController-setResponseHeader)-传入参数, token:{}", token);
		response.setCharacterEncoding(StandardCharsets.UTF_8.toString());
		response.setHeader(RetWheelConstants.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
		response.setHeader(RetWheelConstants.TOKEN, token);
		logger.info("(BaseController-setResponseHeader)-response设置header里token, token:{}", token);
	}

	/**
	 * 获取跨域header
	 * @param response
	 */
	protected void setCrossOriginHeader(HttpServletResponse response) {
		// 指定允许其他域名访问
        response.setHeader("Access-Control-Allow-Origin", "*");
        //是否发送cookie
        response.setHeader("Access-Control-Allow-Credentials", "true");
        // 响应类型
        response.setHeader("Access-Control-Allow-Methods", RequestMethod.POST.toString());
        // 响应头设置
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,Content-Type");
	}

	/**
	 * 设置token,过期时间为7*24小时
	 * @param userId
	 * @param userAccount
	 * @param gToken
	 * @return String
	 */
	protected String setToken(Integer userId,String userAccount,String gToken) {
		logger.info("(BaseController-setToken)-redis设置token-传入参数, userId:{}, userAccount:{}, gToken:{}", userId, userAccount, gToken);
		if(null == userId || StringUtils.isBlank(userAccount) || StringUtils.isBlank(gToken)) {
			return null;
		}

		String tokenkey = RedisKeysUtil.CN_OCHAIN_WHEEL_APP_H5_LOGIN_TOKEN + userId;

		PrivateKey privateKey = KeyFactoryUtil.INSTANCE.generateRSAPrivateKey(rsaPrivateKeyStr);
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS512;

		String issuer = RetWheelConstants.OCHAIN;
		String audience = RetWheelConstants.GOFUN;
		JSONObject claimsJson = new JSONObject();
		claimsJson.put(RetWheelConstants.USER_ID, userId);
		claimsJson.put(RetWheelConstants.USER_ACCOUNT, userAccount);
		claimsJson.put(RetWheelConstants.GTOKEN, gToken);
		logger.info("(BaseController-setToken)-声明(claims)json, claimsJson:{}", claimsJson);
		//使用aes密钥加密信息
		String claimsEncryptStr = null;
		try {
			claimsEncryptStr = AESUtils.encrypt(claimsJson.toJSONString(), aesSecretKeyStr, aesSecretKeyStr);
		} catch (Exception e) {
			logger.error("(BaseController-setToken)-声明(claims)加密-异常, Exception = {}, message = {}",e,e.getMessage());
		}
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(RetWheelConstants.CLAIMS, claimsEncryptStr);

		String token = TokenUtil.INSTANCE.createJWT(privateKey, signatureAlgorithm, claims, issuer, audience);
		String tokenResult = redisService.setex(tokenkey, RetWheelConstants.TOKEN_TIME, token);
		logger.info("(BaseController-setToken)-redis设置token-返回信息, tokenkey:{}, tokenResult:{}", tokenkey, tokenResult);
		return token;
	}

	/**
	 * 获取请求ip
	 * @return String
	 */
	protected String getRequestIp() {
		String ip = IpUtil.getIpAddr(request);
		return ip;
	}

	/**
	 * 获取请求加点URI参数为空，如：user.register.parameter.empty
	 * @return String
	 */
	protected String getRequestParameterEmpty() {
		String requestURI = request.getRequestURI();
		requestURI = StringUtils.substringAfter(requestURI, "/");
		requestURI = StringUtils.replace(requestURI, "/", ".");
		requestURI = Objects.toString(requestURI, "") + ".parameter.empty";
		return requestURI;
	}

	/**
	 * 获取请求加点URI参数错误，如：user.register.parameter.error
	 * @return String
	 */
	protected String getRequestParameterError() {
		String requestURI = request.getRequestURI();
		requestURI = StringUtils.substringAfter(requestURI, "/");
		requestURI = StringUtils.replace(requestURI, "/", ".");
		requestURI = Objects.toString(requestURI, "") + ".parameter.error";
		return requestURI;
	}

	/**
	 * 获取token(payload)
	 * @return JSONObject
	 */
	protected JSONObject getTokenPayload() {
		String token = request.getHeader(RetWheelConstants.TOKEN);
		logger.info("(BaseController-getTokenPayload)-获取token, token:{}", token);
		if(StringUtils.isBlank(token)) {
			return null;
		}

		String[] datas = StringUtils.split(token, ".");
//		String header = null;
		String payload = null;
//		String signature = null;
		try {
//			header = datas[0];
			payload = datas[1];
//			signature = datas[2];
			logger.info("(BaseController-getTokenPayload)-获取payload, payload:{}", payload);
		} catch (Exception e) {
			logger.error("(BaseController-getTokenPayload)-jwt(token)数组转换异常, Exception = {}, message = {}", e, e.getMessage());
		}
		String payloadStr = new String(Base64.decodeBase64(payload), StandardCharsets.UTF_8);
		JSONObject payloadJSON = JSONObject.parseObject(payloadStr);
		String claimsStr = Objects.toString(payloadJSON.get(RetWheelConstants.CLAIMS));

		String claimsDecryptStr = null;
		try {
			claimsDecryptStr = AESUtils.decrypt(claimsStr, aesSecretKeyStr, aesSecretKeyStr);
		} catch (Exception e) {
			logger.error("(BaseController-getTokenPayload)-声明(claims)解密-异常, Exception = {}, message = {}",e,e.getMessage());
		}
		JSONObject claimsJSON = JSONObject.parseObject(claimsDecryptStr);
		return claimsJSON;
	}

	/**
	 * 获取token(userId)
	 * @return Integer
	 */
	protected Integer getTokenUserId() {
		JSONObject payloadJSON = this.getTokenPayload();
		Integer userId = new Integer(Objects.toString(payloadJSON.get(RetWheelConstants.USER_ID)));
		logger.info("(BaseController-getTokenUserId)-返回信息, userId:{}", userId);
		return userId;
	}

	/**
	 * 获取token(userAccount)
	 * @return String
	 */
	protected String getTokenUserAccount() {
		JSONObject payloadJSON = this.getTokenPayload();
		String userAccount = Objects.toString(payloadJSON.get(RetWheelConstants.USER_ACCOUNT));
		logger.info("(BaseController-getTokenUserAccount)-返回信息, userAccount:{}", userAccount);
		return userAccount;
	}

	/**
	 * 获取token(gToken)
	 * @return String
	 */
	protected String getTokenGToken() {
		JSONObject payloadJSON = this.getTokenPayload();
		String gToken = Objects.toString(payloadJSON.get(RetWheelConstants.GTOKEN));
		logger.info("(BaseController-getTokenGToken)-返回信息, gToken:{}", gToken);
		return gToken;
	}

	/**
	 * 新增算力任务完成情况
	 * @param userTaskVo
	 * @param userId
	 * @param userAccount
	 * @param gId
	 */
	public void addUserTask(UserTaskVo userTaskVo,Integer userId,String userAccount,String gId) {
		String verifyDeposit = userTaskVo.getVerifyDeposit();
		String verifyLicense = userTaskVo.getVerifyLicense();
		String verifyCard = userTaskVo.getVerifyCard();
		String freeSwitch = userTaskVo.getFreeSwitch();
		//因为新增算力任务完成情况没有返回，所以新建时间
		Date date = new Date();
		Integer score = userTaskVo.getScore();
		Integer inviteUser = userTaskVo.getInviteUser();
		Integer order = userTaskVo.getOrder();
		List<AreaVo> areaList = userTaskVo.getArea();

		//员工基本信息
		if(GoFunConstants.USER_VERIFYDEPOSIT_YES.equals(verifyDeposit)) {
			this.addPushVerifyTask(gId, PushConstants.verifyDeposit, userAccount, verifyDeposit, "算力任务完成情况-押金状态", date);
		} else {
			this.addPushVerifyUserCalculateConfig(userId, PushConstants.verifyDeposit);
		}
		if(GoFunConstants.USER_VERIFYLICENSE_YES.equals(verifyLicense)) {
			this.addPushVerifyTask(gId, PushConstants.verifyLicense, userAccount, verifyLicense, "算力任务完成情况-驾照状态", date);
		} else {
			this.addPushVerifyUserCalculateConfig(userId, PushConstants.verifyLicense);
		}
		if(GoFunConstants.USER_VERIFYCARD_YES.equals(verifyCard)) {
			this.addPushVerifyTask(gId, PushConstants.verifyCard, userAccount, verifyCard, "算力任务完成情况-身份证状态", date);
		} else {
			this.addPushVerifyUserCalculateConfig(userId, PushConstants.verifyCard);
		}
		if(GoFunConstants.USER_FREESWITCH_YES.equals(freeSwitch)) {
			this.addPushVerifyTask(gId, PushConstants.freeSwitch, userAccount, freeSwitch, "算力任务完成情况-免密支付状态", date);
		} else {
			this.addPushVerifyUserCalculateConfig(userId, PushConstants.freeSwitch);
		}

		//邀请好友
		if(inviteUser >0) {
			this.addPushInviteUserTask(gId, PushConstants.finishTimes, userAccount, inviteUser, "算力任务完成情况-邀请好友信息", date);
		}
		//文明分
		if(score >0) {
			this.addPushCivilizeTask(gId, PushConstants.score, userAccount, score, "算力任务完成情况-文明分", date);
		}
		//员工用车订单
		if(order >0) {
			this.addPushCarOrder(gId, PushConstants.order, userAccount, order, areaList, "算力任务完成情况-员工用车订单", date);
		}

		String usertaskkey = RedisKeysUtil.CN_OCHAIN_WHEEL_APP_H5_LOGIN_USERTASK_USERID_TIME + userId + ":" + new LocalDate().toString(DateFormatConstants.DF_YYYYMMDD);
		String usertaskResult = redisService.setex(usertaskkey, RetWheelConstants.TWENTY_FOUR_HOUR_SECONDS_TIME, userAccount);
		logger.info("(BaseController-addUserTask)-redis设置用户任务-返回信息, usertaskkey:{}, usertaskResult:{}", usertaskkey, usertaskResult);
	}

	/**
	 * 新增推送员工基本信息
	 * @param gId
	 * @param gCode
	 * @param userAccount
	 * @param verifyStatus
	 * @param desc
	 * @param date
	 */
	private void addPushVerifyTask(String gId,String gCode,String userAccount,String verifyStatus,String desc,Date date) {
		AccountCalculateTaskVo accountCalculateTaskVo = new AccountCalculateTaskVo();
		accountCalculateTaskVo.setgId(gId);
		accountCalculateTaskVo.setgCode(gCode);
		accountCalculateTaskVo.setUserAccount(userAccount);
		accountCalculateTaskVo.setVerifyStatus(verifyStatus);
		accountCalculateTaskVo.setPushType(SqlWheelConstants.SQL_DATA_PUSH_TYPE_BASIC);
		accountCalculateTaskVo.setVerifyAmount(0);
		accountCalculateTaskVo.setRegistryNo(-1l);
		accountCalculateTaskVo.setDesc(desc);
		accountCalculateTaskVo.setDate(date);
		accountCalculateTaskVo.setSourceType(WheelConstants.SOURCE_TYPE_LOGIN);
        /** push数据推送(算力记录)队列-左进右出  **/
		String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_ACCOUNT_CALCULATE_TASK;
		String taskValue = JSONObject.toJSONString(accountCalculateTaskVo);
        logger.info("(BaseController-addPushVerifyTask)-新增推送员工基本信息("+desc+")-传入参数, queueKey:{}, value", queueKey, taskValue);
        long l = redisService.lpush(queueKey, taskValue);
        logger.info("(BaseController-addPushVerifyTask)-新增推送员工基本信息("+desc+")-返回信息], l:{}", l);
	}

	/**
	 * 新增推送邀请好友-暂时注释
	 * @param gId
	 * @param gCode
	 * @param userAccount
	 * @param verifyAmount
	 * @param desc
	 * @param date
	 */
	private void addPushInviteUserTask(String gId,String gCode,String userAccount,Integer verifyAmount,String desc,Date date) {
		AccountCalculateTaskVo accountCalculateTaskVo = new AccountCalculateTaskVo();
		accountCalculateTaskVo.setgId(gId);
		accountCalculateTaskVo.setgCode(gCode);
		accountCalculateTaskVo.setUserAccount(userAccount);
		accountCalculateTaskVo.setVerifyAmount(verifyAmount);
		accountCalculateTaskVo.setPushType(SqlWheelConstants.SQL_DATA_PUSH_TYPE_FRIEND);
		accountCalculateTaskVo.setRegistryNo(-1l);
		accountCalculateTaskVo.setDesc(desc);
		accountCalculateTaskVo.setDate(date);
		accountCalculateTaskVo.setSourceType(WheelConstants.SOURCE_TYPE_LOGIN);
        /** push数据推送(算力记录)队列-左进右出  **/
        String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_ACCOUNT_CALCULATE_TASK;
        String taskValue = JSONObject.toJSONString(accountCalculateTaskVo);
        logger.info("(BaseController-pushInviteUserAccountCalculateTask)-新增推送邀请好友("+desc+")-传入参数, queueKey:{}, value", queueKey, taskValue);
        long l = redisService.lpush(queueKey, taskValue);
        logger.info("(BaseController-pushInviteUserAccountCalculateTask)-新增推送邀请好友("+desc+")-返回信息], l:{}", l);
	}

	/**
	 * 新增推送文明分-暂时注释
	 * @param gId
	 * @param gCode
	 * @param userAccount
	 * @param score
	 * @param desc
	 * @param date
	 */
	private void addPushCivilizeTask(String gId,String gCode,String userAccount,Integer score,String desc,Date date) {
		AccountCalculateCivilizeTaskVo accountCalculateCivilizeTaskVo = new AccountCalculateCivilizeTaskVo();
		accountCalculateCivilizeTaskVo.setgId(gId);
		accountCalculateCivilizeTaskVo.setgCode(gCode);
		accountCalculateCivilizeTaskVo.setUserAccount(userAccount);
		accountCalculateCivilizeTaskVo.setScore(score);
		accountCalculateCivilizeTaskVo.setPushType(SqlWheelConstants.SQL_DATA_PUSH_TYPE_SCORE);
		accountCalculateCivilizeTaskVo.setRegistryNo(-1l);
		accountCalculateCivilizeTaskVo.setDesc(desc);
		accountCalculateCivilizeTaskVo.setDate(date);
		accountCalculateCivilizeTaskVo.setSourceType(WheelConstants.SOURCE_TYPE_LOGIN);
        /** push数据推送(算力记录)队列-左进右出  **/
        String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_ACCOUNT_CALCULATE_CIVILIZE;
        String taskValue = JSONObject.toJSONString(accountCalculateCivilizeTaskVo);
        logger.info("(BaseController-addPushCivilizeTask)-新增推送文明分("+desc+")-传入参数, queueKey:{}, value", queueKey, taskValue);
        long l = redisService.lpush(queueKey, taskValue);
        logger.info("(BaseController-addPushCivilizeTask)-新增推送文明分("+desc+")-返回信息], l:{}", l);
	}

	/**
	 * 新增推送用车订单-暂时注释
	 * @param gId
	 * @param gCode
	 * @param userAccount
	 * @param order
	 * @param desc
	 * @param date
	 */
	private void addPushCarOrder(String gId,String gCode,String userAccount,Integer order,List<AreaVo> areaList,String desc,Date date) {
        CarOrderVo carOrderVo = new CarOrderVo();
        carOrderVo.setgId(gId);
        carOrderVo.setUserAccount(userAccount);
        carOrderVo.setOrder(order);
        carOrderVo.setArea(areaList);
        if(areaList  != null && !areaList.isEmpty()) {
			UserCarOrderVo userCarOrderVo = new UserCarOrderVo();
			userCarOrderVo.setgId(gId);
			userCarOrderVo.setgCode(gCode);
			userCarOrderVo.setUserAccount(userAccount);
			userCarOrderVo.setPushType(SqlWheelConstants.SQL_DATA_PUSH_TYPE_CARORDER);
			userCarOrderVo.setContent(JSONObject.toJSONString(carOrderVo));
			userCarOrderVo.setRegistryNo(-1l);
			userCarOrderVo.setDesc(desc);
			userCarOrderVo.setDate(date);
			userCarOrderVo.setSourceType(WheelConstants.SOURCE_TYPE_LOGIN);
	        /** push数据推送(新增用车订单)队列-左进右出  **/
	        String queueOrderKey = RedisKeysUtil.QN_OCHAIN_WHEEL_CAR_ORDER;
	        String orderValue = JSONObject.toJSONString(userCarOrderVo);
	        logger.info("(BaseController-addPushCarOrderTask)-新增推送用车订单-传入参数, queueKey:{}, value", queueOrderKey, orderValue);
			long l = redisService.lpush(queueOrderKey, orderValue);
	        logger.info("(BaseController-addPushCarOrderTask)-新增推送用车订单-返回信息], l:{}", l);
        }
	}


	/**
	 * 新增验证未完成用户算力配置
	 * @param userId
	 * @param gCode
	 */
	private void addPushVerifyUserCalculateConfig(Integer userId,String gCode) {
		String calculateCode = PushConstants.resSendMap.get(gCode);
		Integer isComplete = SqlWheelConstants.SQL_USER_CALCULATE_CONFIG_TYPE_COMPLETE_NO;

       	UserCalculateConfigVo userCalculateConfigVo = new UserCalculateConfigVo();
       	userCalculateConfigVo.setUserId(userId);
       	userCalculateConfigVo.setCalculateCode(calculateCode);
       	userCalculateConfigVo.setIsComplete(isComplete);
       	userCalculateConfigVo.setVerifyAmount(0);
       	userCalculateConfigVo.setIsAdd(SqlWheelConstants.SQL_USER_CALCULATE_CONFIG_TYPE_IS_ADD_NO);
       	userCalculateConfigVo.setSourceType(WheelConstants.SOURCE_TYPE_LOGIN);
        /** push数据推送(用户算力配置)队列-左进右出  **/
       	String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_USER_CALCULATE_CONFIG;
       	String value = JSONObject.toJSONString(userCalculateConfigVo);
        logger.info(" (BaseController-addPushVerifyUserCalculateConfig):push数据推送(用户算力配置)-传入参数, queueKey:{}, value", queueKey, value);
        long l = redisService.lpush(queueKey, value);
        logger.info(" (BaseController-addPushVerifyUserCalculateConfig):push数据推送(用户算力配置)-返回信息, l:{}", l);
	}

	/**
	 * 插入账户算力实时排名
	 * @param userId
	 * @param userAccount
	 * @param balance
	 * @param loginCount
	 */
	protected void insertCalculateRealRank(Integer userId,String userAccount,Integer balance,Integer loginCount) {
		//插入登录用户账户算力实时排名
		if(loginCount != null && loginCount >0) {
			LoginCalculateRealRankVo loginCalculateRealRankVo = new LoginCalculateRealRankVo();
			loginCalculateRealRankVo.setUserId(userId);
			loginCalculateRealRankVo.setUserAccount(userAccount);
			long l = redisService.zadd(this.loginCalculateRankRealKey, balance, JSONObject.toJSONString(loginCalculateRealRankVo));
			logger.info("(BaseController-insertDiamondRealRank)-插入登录用户账户算力实时排名-返回信息, loginCalculateRankRealKey:{}, l:{}", loginCalculateRankRealKey, l);

			long ll = redisService.zadd(this.calculateRankRealKey, balance, userAccount);
			logger.info("(BaseController-insertDiamondRealRank)-插入登录用户账户算力账户实时排名-返回信息, calculateRankRealKey:{}, ll:{}", calculateRankRealKey, ll);
		}
	}

	/**
	 * 插入账户能量实时排名
	 * @param userId
	 * @param userAccount
	 * @param balance
	 * @param loginCount
	 */
	protected void insertDiamondRealRank(Integer userId,String userAccount,BigDecimal balance,Integer loginCount) {
		//插入登录用户账户算力实时排名
		if(loginCount != null && loginCount >0) {
			LoginDiamondRealRankVo loginDiamondRealRankVo = new LoginDiamondRealRankVo();
			loginDiamondRealRankVo.setUserId(userId);
			loginDiamondRealRankVo.setUserAccount(userAccount);
			long l = redisService.zadd(this.loginDiamondRankRealKey, balance.doubleValue(), JSONObject.toJSONString(loginDiamondRealRankVo));
			logger.info("(BaseController-insertDiamondRealRank)-插入登录用户账户能量实时排名-返回信息, loginDiamondRankRealKey:{}, l:{}", loginDiamondRankRealKey, l);

			long ll = redisService.zadd(this.diamondRankRealKey, balance.doubleValue(), userAccount);
			logger.info("(BaseController-insertDiamondRealRank)-插入登录用户账户能量账户实时排名-返回信息, diamondRankRealKey:{}, ll:{}", diamondRankRealKey, ll);
		}
	}

	/**
	 * 新增优惠券日志
	 * @param couponVo
	 * @param userId
	 * @param userAccount
	 * @param status
	 * @param remark
	 * @return boolean
	 */
	protected boolean addCouponLog(CouponVo couponVo,Integer userId,String userAccount,Integer status,String remark) {
		Integer couponId = couponVo.getCouponId();
		Integer payDiamond = couponVo.getDiamond();
		String url = couponVo.getUrl();
		Integer price = couponVo.getPrice();
		Integer couponType = couponVo.getCouponType();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("userAccount", userAccount);
		params.put("couponId", couponId);
		params.put("diamond", payDiamond);
		params.put("url", url);
		params.put("price", price);
		params.put("couponType", couponType);
		params.put("status", status);
		params.put("remark", remark);
		JSONObject jsonCouponLog = couponLogService.addCouponLog(params);
		logger.info("(BaseController-addCouponLog)-新增优惠券日志-返回信息, jsonCouponLog:{}", jsonCouponLog);
		String bootCode = Objects.toString(jsonCouponLog.get(BootWheelConstants.BOOT_CODE), "");
       	if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
       		return false;
		}
       	return true;
	}

	/**
	 * 新增新用户赠送固定能量记录
	 * @param userId
	 * @param diamondCode
	 * @return boolean
	 */
	protected boolean addNewUserGiftDiamondRecord(Integer userId,String diamondCode) {
		JSONObject jsonDiamondConfig = diamondConfigService.getDiamondConfigByCode(diamondCode);
   		logger.info("(BaseController-addNewUserGiftDiamondRecord)-根据diamondCode查询能量配置-返回信息, jsonDiamondConfig:{}", jsonDiamondConfig);
		String bootCode = Objects.toString(jsonDiamondConfig.get(BootWheelConstants.BOOT_CODE), "");
       	if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
       		return false;
		}
       	DiamondConfigVo diamondConfigVo = JSONObject.toJavaObject(jsonDiamondConfig, DiamondConfigVo.class);
       	Integer isDelete = diamondConfigVo.getIsDelete();
       	//已删除，返回false
       	if(SqlWheelConstants.SQL_DIAMOND_CONFIG_IS_DELETE_YES.equals(isDelete)) {
       		return false;
       	}
       	String diamondName = diamondConfigVo.getDiamondName();
//       	BigDecimal sendAmount = diamondConfigVo.getSendAmount();
		Integer isFix = diamondConfigVo.getIsFix();
		BigDecimal fixSendAmount = diamondConfigVo.getFixSendAmount();

		BigDecimal diamond = new BigDecimal("0");
		//非固定发放
//		if(SqlWheelConstants.SQL_DIAMOND_CONFIG_FIX_NO.equals(isFix)) {
//			//用户能量数量
//			diamond = MathUtil.INSTANCE.multiply(Objects.toString(sendAmount), "0", 4, BigDecimal.ROUND_DOWN);
//		} else
		//固定发放
		if(SqlWheelConstants.SQL_DIAMOND_CONFIG_FIX_YES.equals(isFix)) {
			diamond = fixSendAmount;
		}

		//能量大于0
		if(diamond.compareTo(new BigDecimal("0")) >0) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("userId", userId);
			params.put("diamondCode", diamondCode);
			params.put("diamondName", diamondName);
			params.put("diamondType", SqlWheelConstants.SQL_DIAMOND_RECORD_TYPE_NEW_USER);
			params.put("diamond", diamond);
			params.put("registryNo", -1);
			JSONObject jsonDiamondRecord = diamondRecordService.addFixDiamondRecord(params);
			logger.info("(BaseController-addNewUserGiftDiamondRecord)-插入固定能量记录-返回信息, jsonDiamondRecord:{}", jsonDiamondRecord);
			bootCode = Objects.toString(jsonDiamondRecord.get(BootWheelConstants.BOOT_CODE), "");
			if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 获取算力前**名昨日排名列表
	 * @param start
	 * @param end
	 * @return List<CalculateRankContentVo>
	 */
	protected List<CalculateRankContentVo> getCalculateYesterdayRankList(Integer start,Integer end) {
        List<Map<String, Object>> result = redisService.zrevrangeWithScores(this.calculateYesterdayRankKey, start, end);
        List<CalculateRankContentVo> calculateRankList = null;
        CalculateRankContentVo calculateRankContentVo = null;
        if(result != null && !result.isEmpty()) {
        	ListIterator<Map<String, Object>> it = result.listIterator();
        	calculateRankList = new ArrayList<CalculateRankContentVo>();
        	while(it.hasNext()) {
        		Map<String, Object> map = it.next();
        		String element = Objects.toString(map.get("element"), "");

        		calculateRankContentVo = JSONObject.parseObject(element, CalculateRankContentVo.class);
        		String userAccount = calculateRankContentVo.getUserAccount();
        		int length = StringUtils.length(userAccount);
    			if(length > 4) {
        			userAccount = StringUtils.substring(userAccount, length-4, length);
				}

        		calculateRankContentVo.setUserAccount("*"+userAccount);
        		calculateRankList.add(calculateRankContentVo);
        	}
        }

        logger.info("(BaseController-getCalculateYesterdayRankList)-获取前"+(start+1)+"-"+(end+1)+"名算力昨日排名列表, calculateRankList:{}", calculateRankList == null ? null :calculateRankList.size());
        return calculateRankList;
	}

	/**
	 * 获取能量前**名昨日排名列表
	 * @param start
	 * @param end
	 * @return List<DiamondRankContentVo>
	 */
	protected List<DiamondRankContentVo> getDiamondYesterdayRankList(Integer start,Integer end) {
		List<Map<String, Object>> result = redisService.zrevrangeWithScores(this.diamondYesterdayRankKey, start, end);
		List<DiamondRankContentVo> diamondRankList = null;
		DiamondRankContentVo diamondRankContentVo = null;
        if(result != null && !result.isEmpty()) {
        	ListIterator<Map<String, Object>> it = result.listIterator();
        	diamondRankList = new ArrayList<DiamondRankContentVo>();
        	while(it.hasNext()) {
        		Map<String, Object> map = it.next();
        		String element = Objects.toString(map.get("element"), "");

        		diamondRankContentVo = JSONObject.parseObject(element, DiamondRankContentVo.class);
        		String userAccount = diamondRankContentVo.getUserAccount();
        		int length = StringUtils.length(userAccount);
    			if(length > 4) {
        			userAccount = StringUtils.substring(userAccount, length-4, length);
				}

        		diamondRankContentVo.setUserAccount("*"+userAccount);
        		diamondRankList.add(diamondRankContentVo);
        	}
        }

		logger.info("(BaseController-getDiamondYesterdayRankList)-获取前"+(start+1)+"-"+(end+1)+"名能量昨日排名列表, diamondRankList:{}", diamondRankList == null ? null :diamondRankList.size());
		return diamondRankList;
	}

	//预留以后获取算力实时排名使用
	/**
	 * 获取算力前**名实时排名列表
	 * @param start
	 * @param end
	 * @return List<CalculateRankContentVo>
	 */
	protected List<CalculateRankContentVo> getCalculateRealRankList(Integer start,Integer end) {
        List<Map<String, Object>> result = redisService.zrevrangeWithScores(this.loginCalculateRankRealKey, start, end);
        List<CalculateRankContentVo> calculateRankList = null;
        CalculateRankContentVo calculateRankContentVo = null;
        LoginCalculateRealRankVo loginCalculateRealRankVo = null;
        if(result != null && !result.isEmpty()) {
        	ListIterator<Map<String, Object>> it = result.listIterator();
        	calculateRankList  = new ArrayList<CalculateRankContentVo>();
        	while(it.hasNext()) {
        		Map<String, Object> map = it.next();
        		String element = Objects.toString(map.get("element"), "");
        		String score = Objects.toString(map.get("score"), "");
        		int nextIndex = it.nextIndex();

        		loginCalculateRealRankVo = JSONObject.parseObject(element, LoginCalculateRealRankVo.class);
        		String userAccount = loginCalculateRealRankVo.getUserAccount();
        		if(StringUtils.length(userAccount) >=11) {
        			userAccount = StringUtils.replace(userAccount, StringUtils.substring(userAccount, 0, 7), "*");
				}

        		calculateRankContentVo = new CalculateRankContentVo();
        		calculateRankContentVo.setUserAccount(userAccount);
        		if(StringUtils.isNotBlank(score)) {
        			calculateRankContentVo.setCalculate(new BigDecimal(score).intValue());
        		}
        		calculateRankContentVo.setSort(nextIndex);
        		calculateRankList.add(calculateRankContentVo);
        	}
        }

        logger.info("(BaseController-getCalculateRealRankList)-获取前"+(start+1)+"-"+(end+1)+"名算力实时排名列表, calculateRankList:{}", calculateRankList == null ? null :calculateRankList.size());
        return calculateRankList;
	}

	//预留以后获取	能量实时排名使用
	/**
	 * 获取能量前**名实时排名列表
	 * @param start
	 * @param end
	 * @return List<DiamondRankContentVo>
	 */
	protected List<DiamondRankContentVo> getDiamondRealRankList(Integer start,Integer end) {
		List<Map<String, Object>> result = redisService.zrevrangeWithScores(this.loginDiamondRankRealKey, start, end);
		List<DiamondRankContentVo> diamondRankList = null;
		DiamondRankContentVo diamondRankContentVo = null;
		LoginDiamondRealRankVo loginDiamondRealRankVo = null;
        if(result != null && !result.isEmpty()) {
        	ListIterator<Map<String, Object>> it = result.listIterator();
        	diamondRankList = new ArrayList<DiamondRankContentVo>();
        	while(it.hasNext()) {
        		Map<String, Object> map = it.next();
        		String element = Objects.toString(map.get("element"), "");
        		String score = Objects.toString(map.get("score"), "");
        		int nextIndex = it.nextIndex();

        		loginDiamondRealRankVo = JSONObject.parseObject(element, LoginDiamondRealRankVo.class);
        		String userAccount = loginDiamondRealRankVo.getUserAccount();
        		if(StringUtils.length(userAccount) >=11) {
        			userAccount = StringUtils.replace(userAccount, StringUtils.substring(userAccount, 0, 7), "*");
				}

        		diamondRankContentVo = new DiamondRankContentVo();
        		diamondRankContentVo.setUserAccount(userAccount);
        		if(StringUtils.isNotBlank(score)) {
        			diamondRankContentVo.setDiamond(new BigDecimal(score));
        		}
        		diamondRankContentVo.setSort(nextIndex);
        		diamondRankList.add(diamondRankContentVo);
        	}
        }

		logger.info("(BaseController-getDiamondRealRankList)-获取前"+(start+1)+"-"+(end+1)+"名能量实时排名列表, diamondRankList:{}", diamondRankList == null ? null :diamondRankList.size());
		return diamondRankList;
	}

}