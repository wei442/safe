package com.cloud.consumer.safe.controller;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.RetWheelConstants;
import com.ochain.common.redis.keys.RedisKeysUtil;
import com.ochain.common.security.KeyFactoryUtil;
import com.ochain.common.sign.security.AESUtils;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.base.BaseRestRequest;
import com.cloud.consumer.safe.service.IUserService;
import com.cloud.consumer.safe.util.AccessTokenUtil;
import com.cloud.consumer.safe.vo.user.UserVo;

import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 区块链钱包管理 UserWalletController
 * @author wei.yong
 * @ClassName: UserWalletController
 * @Description:
 * @date 2016-10-16
 */
@RestController
@RequestMapping("/user/chain/wallet")
public class UserWalletController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户 Service
	@Autowired
	private IUserService userService;

	//区块链钱包accesstoken的rsa的私钥
	@Value("${chain.wallet.accesstoken.rsa.privateKey}")
	private String chainRsaPrivateKeyStr;

	//区块链钱包accesstoken的aes的密钥
	@Value("${chain.wallet.accesstoken.claims.aes.secretKey}")
	private String chainAesSecretKeyStr;

	 /**
     * 4.1.7.1	用户获取区块链钱包访问权限接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/getAccessToken",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getAccessToken(
		@RequestBody BaseRestRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【用户获取区块链钱包访问权限接口】(UserWalletController-getAccessToken)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject payloadJSON = this.getTokenPayload();
   		Integer userId = new Integer(Objects.toString(payloadJSON.get(RetWheelConstants.USER_ID)));
   		String userAccount = Objects.toString(payloadJSON.get(RetWheelConstants.USER_ACCOUNT));
   		String gtoken = Objects.toString(payloadJSON.get(RetWheelConstants.GTOKEN));

	   	//根据userId获得用户信息
		JSONObject jsonUser = userService.getUserById(userId);
		logger.info("===step2:【用户获取区块链钱包访问权限接口】(UserWalletController-getAccessToken)-根据userId获取用户信息-返回信息, jsonUser:{}", jsonUser);
		String bootCode = Objects.toString(jsonUser.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		UserVo userVo = JSONObject.toJavaObject(jsonUser, UserVo.class);
		String gId = userVo.getgId();

   		//获取accesstoken
		String accesstoken = this.setAccessToken(userId, userAccount, gId, gtoken);
		Integer expireTime = this.getAccessTokenExpireTime(userId);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("accesstoken", accesstoken);
		result.put("expireTime", expireTime);

        //返回信息
		BaseRestMapResponse walletResponse = new BaseRestMapResponse();
		walletResponse.put(RetWheelConstants.RESULT, result);
	    logger.info("===step3:【用户获取区块链钱包访问权限接口】(UserWalletController-getAccessToken)-返回信息, walletResponse:{}", walletResponse);
	    return walletResponse;
	}

	/**
	 * 设置区块链钱包的accesstoken
	 * @param userId
	 * @param userAccount
	 * @param gId
	 * @param gtoken
	 * @return String
	 */
	protected String setAccessToken(Integer userId,String userAccount,String gId,String gtoken) {
		logger.info("(UserWalletController-setAccessToken)-redis设置accesstoken-传入参数, userId:{}, userAccount:{}, gId:{}, gtoken:{}", userId, userAccount, gId, gtoken);
		if(null == userId || StringUtils.isBlank(userAccount)) {
			return null;
		}

		PrivateKey privateKey = KeyFactoryUtil.INSTANCE.generateRSAPrivateKey(chainRsaPrivateKeyStr);
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;

		String issuer = RetWheelConstants.OCHAIN;
		String audience = RetWheelConstants.GOFUN;
		JSONObject claimsJson = new JSONObject();
		claimsJson.put(RetWheelConstants.USER_ID, userId);
		claimsJson.put(RetWheelConstants.USER_ACCOUNT, userAccount);
		claimsJson.put(RetWheelConstants.GID, gId);
		claimsJson.put(RetWheelConstants.GTOKEN, gtoken);
		logger.info("(UserWalletController-setAccessToken)-声明(claims)json, claimsJson:{}", claimsJson);
		//使用aes密钥加密信息
		String claimsEncryptStr = null;
		try {
			claimsEncryptStr = AESUtils.encrypt(claimsJson.toJSONString(), chainAesSecretKeyStr, chainAesSecretKeyStr);
		} catch (Exception e) {
			logger.error("(UserWalletController-setAccessToken)-声明(claims)加密-异常, Exception = {}, message = {}",e,e.getMessage());
		}
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(RetWheelConstants.CLAIMS, claimsEncryptStr);

		String accesstoken = AccessTokenUtil.INSTANCE.createJWT(privateKey, signatureAlgorithm, claims, issuer, audience);
		String acesstokenkey = RedisKeysUtil.CN_OCHAIN_WHEEL_CHAIN_WALLET_ACCESSTOKEN + userId;
		//暂时注释，超时时间改为1天
		String accesstokenResult = redisService.setex(acesstokenkey, RetWheelConstants.TWENTY_FOUR_HOUR_SECONDS_TIME, accesstoken);
		logger.info("(UserWalletController-setAccessToken)-redis设置accesstoken-返回信息, acesstokenkey:{}, accesstokenResult:{}", acesstokenkey, accesstokenResult);
		return accesstoken;
	}

	/**
	 * 获取accessToken过期时间
	 * @param userId
	 * @return Integer
	 */
	protected Integer getAccessTokenExpireTime(Integer userId) {
		logger.info("(UserWalletController-getAccessTokenExpireTime)-获取accessToken过期时间-传入参数, userId:{}", userId);
		if(null == userId) {
			return null;
		}

		String acesstokenkey = RedisKeysUtil.CN_OCHAIN_WHEEL_CHAIN_WALLET_ACCESSTOKEN + userId;
		Integer expireTime = RetWheelConstants.TWO_HOUR_SECONDS_TIME;
		if(redisService.exists(acesstokenkey)) {
			Long l = redisService.ttl(acesstokenkey);
			if(l > -1) {
				expireTime = l.intValue();
			}
		}
		logger.info("(UserWalletController-getAccessTokenExpireTime)-获取accessToken过期时间-返回信息, expireTime:{}", expireTime);
		return expireTime;
	}

}