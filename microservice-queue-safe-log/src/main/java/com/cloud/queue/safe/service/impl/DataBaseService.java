package com.cloud.queue.safe.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.queue.safe.service.IAttachmentLogService;
import com.cloud.queue.safe.service.IRedisLockService;
import com.cloud.queue.safe.service.IRedisService;

/**
 * 数据 DataBaseService
 * @author wei.yong
 */
@Service
public class DataBaseService extends BaseService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//附件日志 Service
	@Autowired
	private IAttachmentLogService attachmentLogService;

	//redis Service
	@Autowired
    private IRedisService redisService;

	//redis锁 Service
	@Autowired
	private IRedisLockService redisLockService;

//	public boolean insertAttachmentLog(UserLoginLogVo userLoginLogVo) {
//		Integer userId = couponPushVo.getUserId();
//		String userAccount = couponPushVo.getUserAccount();
//		Integer couponId = couponPushVo.getCouponId();
//		Integer payDiamond = couponPushVo.getPayDiamond();
//		String url = couponPushVo.getUrl();
//		Integer price = couponPushVo.getPrice();
//		Integer couponType = couponPushVo.getCouponType();
//
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("userId", userId);
//		params.put("userAccount", userAccount);
//		params.put("couponId", couponId);
//		params.put("diamond", payDiamond);
//		params.put("url", url);
//		params.put("price", price);
//		params.put("couponType", couponType);
//		params.put("status", status);
//		params.put("remark", remark);
//		JSONObject jsonCouponLog = attachmentLogService.add(params);
//		logger.info("(DataBaseService-insertCouponLog)-新增优惠券日志-返回信息, jsonCouponLog:{}", jsonCouponLog);
//		String bootCode = Objects.toString(jsonCouponLog.get(BootWheelConstants.BOOT_CODE), "");
//       	if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
//       		return false;
//		}
//       	return true;
//	}


}