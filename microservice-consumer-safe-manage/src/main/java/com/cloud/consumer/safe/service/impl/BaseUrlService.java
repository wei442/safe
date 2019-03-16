//package com.cloud.consumer.safe.service.impl;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Service;
//
///**
// * 基础url超类 BaseUrlService(boot的url)
// * @author wei.yong
// */
//@Service
//public class BaseUrlService {
//
//	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//	//用户
//	protected final String wheel_user = "/boot/user";
//	//用户算力配置
//	protected final String wheel_user_calculateConfig = "/boot/user/calculateConfig";
//	//用户签到
//	protected final String wheel_user_sign = "/boot/user/sign";
//	//用户登录日志
//	protected final String wheel_user_loginLog = "/boot/user/loginLog";
//	//用户操作日志
//	protected final String wheel_user_operateLog = "/boot/user/operateLog";
//
//	//账户
//	protected final String wheel_account = "/boot/account";
//	//账户算力
//	protected final String wheel_accountCalculate = "/boot/accountCalculate";
//	//账户日志
//	protected final String wheel_accountLog = "/boot/accountLog";
//	//账户算力日志
//	protected final String wheel_accountCalculateLog = "/boot/accountCalculateLog";
//
//	//算力配置
//	protected final String wheel_calculateConfig = "/boot/calculateConfig";
//	//算力排名
//	protected final String wheel_calculateRank = "/boot/calculateRank";
//
//	//能量配置
//	protected final String wheel_diamondConfig = "/boot/diamondConfig";
//	//能量记录
//	protected final String wheel_diamondRecord = "/boot/diamondRecord";
//	//能量排名
//	protected final String wheel_diamondRank = "/boot/diamondRank";
//
//	//优惠券
//	protected final String wheel_coupon = "/boot/coupon";
//	//优惠券日志
//	protected final String wheel_couponLog = "/boot/couponLog";
//	//gofun优惠券
//	protected final String wheel_gCoupon = "/boot/gCoupon";
//	//优惠券关联
//	protected final String wheel_couponGCoupon = "/boot/couponGCoupon";
//
//	//数据推送
//	protected final String wheel_dataPush = "/boot/dataPush";
//
//	//排名
//	protected final String wheel_rank = "/boot/rank";
//
//	//临时账户
//	protected final String wheel_tempAccount = "/boot/tempAccount";
//	//临时账户算力
//	protected final String wheel_tempAccountCalculate = "/boot/tempAccountCalculate";
//
//}