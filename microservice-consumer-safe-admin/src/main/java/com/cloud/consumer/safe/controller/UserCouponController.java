package com.cloud.consumer.safe.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ochain.common.constants.BootConstants;
import com.ochain.common.constants.PageConstants;
import com.ochain.common.constants.gofun.GoFunConstants;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.RetWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.redis.keys.RedisKeysUtil;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.coupon.CouponRequest;
import com.cloud.consumer.safe.service.ICouponGCouponService;
import com.cloud.consumer.safe.service.ICouponService;
import com.cloud.consumer.safe.service.IGCouponService;
import com.cloud.consumer.safe.service.IUserService;
import com.cloud.consumer.safe.service.third.IGoFunService;
import com.cloud.consumer.safe.vo.account.AccountDiamondVo;
import com.cloud.consumer.safe.vo.coupon.CouponGCouponVo;
import com.cloud.consumer.safe.vo.coupon.CouponVo;
import com.cloud.consumer.safe.vo.coupon.GCouponVo;
import com.cloud.consumer.safe.vo.user.UserVo;

/**
 * 优惠券管理 UserCouponController
 * @author wei.yong
 * @ClassName: UserCouponController
 * @Description:
 * @date 2016年10月12日 下午 14:30:56
 */
@RestController
@RequestMapping("/user/coupon")
public class UserCouponController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户 Service
	@Autowired
	private IUserService userService;

	//goFun Service
	@Autowired
	private IGoFunService goFunService;

	//优惠券 Service
	@Autowired
	private ICouponService couponService;

	//goFun Service
	@Autowired
	private ICouponGCouponService couponGCouponService;

	//goFun Service
	@Autowired
	private IGCouponService gCouponService;

	 /**
     * 4.1.6.1	获取优惠券列表接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/getCouponList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getCouponList(
		@RequestBody CouponRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【获取优惠券列表接口】(UserCouponController-getCouponList)-获取优惠券列表，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("isUse", SqlWheelConstants.SQL_COUPON_IS_USE_YES);
		JSONObject jsonCoupon = couponService.getCouponList(params);
		logger.info("===step2:【获取优惠券列表接口】(UserCouponController-getCouponList)-获取优惠券列表接口-返回信息, jsonCoupon:{}", jsonCoupon);
		String bootCode = Objects.toString(jsonCoupon.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		String dataListStr = JSONObject.toJSONString(jsonCoupon.getJSONArray(PageConstants.DATA_LIST));
		List<CouponVo> couponList  = JSONObject.parseObject(dataListStr, new TypeReference<List<CouponVo>>(){});

        //返回信息
		BaseRestMapResponse userCouponResponse = new BaseRestMapResponse();
		userCouponResponse.put(RetWheelConstants.RESULT, couponList);
	    logger.info("===step3:【获取优惠券列表接口】(UserCouponController-getCouponList)-返回信息, userCouponResponse:{}", userCouponResponse);
	    return userCouponResponse;
	}

	 /**
     * 4.1.6.2	兑换优惠券接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/exchange",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse exchange(
		@RequestBody CouponRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【兑换优惠券接口】(UserCouponController-exchange)-兑换优惠券，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

   		JSONObject payloadJSON = this.getTokenPayload();
   		Integer userId = new Integer(Objects.toString(payloadJSON.get(RetWheelConstants.USER_ID)));
   		String userAccount = Objects.toString(payloadJSON.get(RetWheelConstants.USER_ACCOUNT));
   		String gtoken = Objects.toString(payloadJSON.get(RetWheelConstants.GTOKEN));
   		Integer couponId = req.getCouponId();
		if(couponId == null) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_ERROR_MSG, this.getRequestParameterEmpty()+".couponId.empty", "couponId为空");
		}

		JSONObject jsonCoupon = couponService.getCouponById(couponId);
		logger.info("===step2:【兑换优惠券接口】(UserCouponController-exchange)-根据couponId获取优惠券信息, jsonCoupon:{}", jsonCoupon);
		String bootCode = Objects.toString(jsonCoupon.get(BootConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		CouponVo couponVo = JSONObject.toJavaObject(jsonCoupon, CouponVo.class);
		Integer payDiamond = couponVo.getDiamond();
		Integer isUse = couponVo.getIsUse();

		if(SqlWheelConstants.SQL_COUPON_IS_USE_NO.equals(isUse)) {
			return new BaseRestMapResponse(RetWheelConstants.COUPON_ERROR, RetWheelConstants.COUPON_NOT_USE_ERROR_MSG, RetWheelConstants.COUPON_NOT_USE_ERROR, RetWheelConstants.COUPON_NOT_USE_ERROR_MSG);
		}

		JSONObject jsonCouponGCoupon = couponGCouponService.getCouponGCouponByCouponId(couponId);
		logger.info("===step3:【兑换优惠券接口】(UserCouponController-exchange)-根据couponId获取优惠券关联-返回信息, jsonCouponGCoupon:{}", jsonCouponGCoupon);
		bootCode = Objects.toString(jsonCouponGCoupon.get(BootWheelConstants.BOOT_CODE), "");
       	if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
       		Integer status = SqlWheelConstants.SQL_COUPON_LOG_STATUS_FAIL;
       		String remark = "兑换优惠券失败:优惠券关联不存在";
       	 	this.addCouponLog(couponVo, userId, userAccount, status, remark);
			return new BaseRestMapResponse(RetWheelConstants.COUPON_ERROR, RetWheelConstants.COUPON_EXCHANGE_ERROR_MSG, RetWheelConstants.COUPON_EXCHANGE_ERROR, RetWheelConstants.COUPON_EXCHANGE_ERROR_MSG);
		}
       	CouponGCouponVo couponGCouponVo = JSONObject.toJavaObject(jsonCouponGCoupon, CouponGCouponVo.class);
       	String gCouponId = couponGCouponVo.getgCouponId();

       	JSONObject jsonGCoupon = gCouponService.getGCouponById(gCouponId);
		logger.info("===step4:【兑换优惠券接口】(UserCouponController-exchange)-根据gCouponId获取gofun优惠券-返回信息, jsonGCoupon:{}", jsonGCoupon);
		bootCode = Objects.toString(jsonCouponGCoupon.get(BootWheelConstants.BOOT_CODE), "");
       	if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
       		Integer status = SqlWheelConstants.SQL_COUPON_LOG_STATUS_FAIL;
       		String remark = "兑换优惠券失败:gofun优惠券不存在";
       	 	this.addCouponLog(couponVo, userId, userAccount, status, remark);
			return new BaseRestMapResponse(RetWheelConstants.COUPON_ERROR, RetWheelConstants.COUPON_EXCHANGE_ERROR_MSG, RetWheelConstants.COUPON_EXCHANGE_ERROR, RetWheelConstants.COUPON_EXCHANGE_ERROR_MSG);
		}
       	GCouponVo gCouponVo = JSONObject.toJavaObject(jsonGCoupon, GCouponVo.class);
       	Integer gPriceType = gCouponVo.getgPriceType();

		//根据userId获得用户信息
		JSONObject jsonUser = userService.getUserById(userId);
		logger.info("===step5:【兑换优惠券接口】(UserCouponController-exchange)-根据userId获取用户信息, jsonUser:{}", jsonUser);
		bootCode = Objects.toString(jsonUser.get(BootConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		UserVo userVo = JSONObject.toJavaObject(jsonUser, UserVo.class);
		String gId = userVo.getgId();
		BigDecimal balanceDiamond = userVo.getDiamond();
		Integer accountId= userVo.getAccountId();
		Integer loginCount = userVo.getLoginCount();

		if(balanceDiamond.compareTo(new BigDecimal(payDiamond)) < 0) {
			//返回能量方块余额不足
			return new BaseRestMapResponse(RetWheelConstants.ACCOUNT_ERROR, RetWheelConstants.ACCOUNT_BALANCE_NOT_ENOUGH_ERROR_MSG, RetWheelConstants.ACCOUNT_BALANCE_NOT_ENOUGH_ERROR, RetWheelConstants.ACCOUNT_BALANCE_NOT_ENOUGH_ERROR_MSG);
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("token", gtoken);
		params.put("userId", gId);
		params.put("couponId", gCouponId);
		params.put("priceType", gPriceType);
		//验证gToken
		JSONObject jsonBindCouponToUser = goFunService.bindCouponToUser(params);
		logger.info("===step6:【兑换优惠券接口】(UserCouponController-exchange)-gofun发放优惠券, jsonBindCouponToUser:{}", jsonBindCouponToUser);
		String goFunCode = Objects.toString(jsonBindCouponToUser.get(GoFunConstants.CODE), "");
		String goFunMsg = Objects.toString(jsonBindCouponToUser.get(GoFunConstants.MSG), "");
		if (!StringUtils.equals(goFunCode, GoFunConstants.OK)) {
			Integer status = SqlWheelConstants.SQL_COUPON_LOG_STATUS_FAIL;
       		String remark = "兑换优惠券失败(gofun返回错误):"+goFunCode+":"+goFunMsg;
           	this.addCouponLog(couponVo, userId, userAccount, status, remark);
       		return new BaseRestMapResponse(RetWheelConstants.COUPON_ERROR, RetWheelConstants.COUPON_EXCHANGE_ERROR_MSG, RetWheelConstants.COUPON_EXCHANGE_ERROR, RetWheelConstants.COUPON_EXCHANGE_ERROR_MSG);
		}

		Integer status = SqlWheelConstants.SQL_COUPON_LOG_STATUS_SUCCESS;
   		String remark = "兑换成功";
		//新增优惠券兑换记录
		this.addCouponLog(couponVo, userId, userAccount, status, remark);

		//兑换减能量
		AccountDiamondVo accountDiamondVo = new AccountDiamondVo();
       	accountDiamondVo.setUserId(userId);
       	accountDiamondVo.setUserAccount(userAccount);
       	accountDiamondVo.setAccountId(accountId);
       	accountDiamondVo.setDiamond(new BigDecimal(Objects.toString(-payDiamond)));
       	accountDiamondVo.setDiamondType(SqlWheelConstants.SQL_DIAMOND_RECORD_TYPE_COUPON);
       	accountDiamondVo.setLoginCount(loginCount);
		/** push数据推送(账户能量余额)队列-左进右出  **/
        String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_ACCOUNT_DIAMOND_BALANCE;
        String value = JSONObject.toJSONString(accountDiamondVo);
        logger.info("===step7:【兑换优惠券接口】(UserCouponController-exchange)-push数据推送(账户能量余额)-传入参数, queueKey:{}, value", queueKey, value);
        long l = redisService.lpush(queueKey, value);
        logger.info("===step7.1:【兑换优惠券接口】(UserCouponController-exchange)-push数据推送(账户能量余额)-返回信息, l:{}", l);

        //优惠券兑换放入队列，暂时注释
//		CouponPushVo couponPushVo = new CouponPushVo();
//		couponPushVo.setUserId(userId);
//		couponPushVo.setUserAccount(userAccount);
//		couponPushVo.setAccountId(accountId);
//		couponPushVo.setCouponId(couponId);
//		couponPushVo.setPayDiamond(payDiamond);
//		couponPushVo.setUrl(url);
//		couponPushVo.setPrice(price);
//		couponPushVo.setCouponType(couponType);
//		couponPushVo.setgId(gId);
//		couponPushVo.setgToken(gToken);
//        /** push数据推送(兑换优惠券)队列-左进右出  **/
//        String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_COUPON_EXCHANGE;
//        String value = JSONObject.toJSONString(couponPushVo);
//        logger.info("===step4:【兑换优惠券接口】(UserCouponController-exchange)-push数据推送(兑换优惠券)-传入参数, queueKey:{}, value", queueKey, value);
//        long l = redisService.lpush(queueKey, value);
//        logger.info("===step4.1:【兑换优惠券接口】(UserCouponController-exchange)-push数据推送(兑换优惠券)-返回信息, l:{}", l);

        //返回信息
		BaseRestMapResponse userCouponResponse = new BaseRestMapResponse();
	    logger.info("===step8:【兑换优惠券接口】(UserCouponController-exchange)-返回信息, userCouponResponse:{}", userCouponResponse);
	    return userCouponResponse;
	}


}