package com.cloud.provider.safe.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.PageConstants;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.cloud.provider.safe.boot.BootRestMapResponse;
import com.cloud.provider.safe.param.CouponLogParam;
import com.cloud.provider.safe.po.CouponLog;
import com.cloud.provider.safe.rest.request.coupon.CouponLogListRequest;
import com.cloud.provider.safe.rest.request.coupon.CouponLogRequest;
import com.cloud.provider.safe.service.IBootCouponLogService;
import com.cloud.provider.safe.vo.coupon.CouponLogAndGCouponVo;

/**
 *优惠券日志 BootCouponLogController
 * @author wang.tongmeng
 */
@RestController
@RequestMapping(value="/boot/couponLog")
public class BootCouponLogController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//优惠券日志Service
	@Autowired
	private IBootCouponLogService couponLogService;

	/**
	 * 分页查询优惠券日志列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponLogListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponLogListByPage(
		@RequestBody CouponLogListRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询优惠券日志列表】(BootCouponLogController-selectCouponLogListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		CouponLogParam couponLogParam = new CouponLogParam();
		couponLogParam.setUserAccount(req.getUserAccount());
		couponLogParam.setCouponId(req.getCouponId());
		if(!StringUtils.isBlank(req.getStartTime()) && !StringUtils.isBlank(req.getEndTime())) {
			couponLogParam.setCouponTimeStartStr(req.getStartTime() + DateFormatConstants.TIME_START);
			couponLogParam.setCouponTimeEndStr(req.getEndTime() + DateFormatConstants.TIME_END);
		}
		couponLogParam.setgCouponId(req.getgCouponId());
		couponLogParam.setgName(req.getgName());
		couponLogParam.setStatus(req.getStatus());
		couponLogParam.setOrderByClause(" t1.id desc ");
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		Page<CouponLog> page = new Page<CouponLog>(pageNum, pageSize);
		List<CouponLogAndGCouponVo> list = null;
		try {
			list = couponLogService.selectCouponLogListByPage(page, couponLogParam);
			logger.info("===step2:【分页查询优惠券日志列表】(BootCouponLogController-selectCouponLogListByPage)-分页查询优惠券日志列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询优惠券日志列表】(BootCouponLogController-selectCouponLogListByPage)-分页查询优惠券日志列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_LOG_LIST_NOTEXIST, BootWheelConstants.WHEEL_COUPON_LOG_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse couponLogListPageResponse = new BootRestMapResponse();
		couponLogListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		couponLogListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		couponLogListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		couponLogListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		couponLogListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询优惠券日志列表】(BootCouponLogController-selectCouponLogListByPage)-返回信息, couponLogListPageResponse:{}", couponLogListPageResponse);
		return couponLogListPageResponse;
	}

	/**
	 * 查询优惠券日志列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponLogList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponLogList(
		@RequestBody CouponLogRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询优惠券日志列表】(BootCouponLogController-selectCouponLogList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		Date couponTime= req.getCouponTime();

		CouponLog couponLog = new CouponLog();
		couponLog.setUserAccount(userAccount);
		couponLog.setCouponTime(couponTime);
		List<CouponLog> list = null;
		try {
			list = couponLogService.selectCouponLogList(couponLog);
			logger.info("===step2:【查询优惠券日志列表】(BootCouponLogController-selectCouponLogList)-查询优惠券日志列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【查询优惠券日志列表】(BootCouponLogController-selectCouponLogList)-查询优惠券日志列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_LOG_LIST_NOTEXIST, BootWheelConstants.WHEEL_COUPON_LOG_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse couponLogListResponse = new BootRestMapResponse();
		couponLogListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询优惠券日志列表】(BootCouponLogController-selectCouponLogList)-返回信息, couponLogListResponse:{}", couponLogListResponse);
		return couponLogListResponse;
	}

	/**
	 * 据id查询优惠券日志
	 * @param couponLogId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponLogById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponLogById(
		@PathVariable(value="id",required=false) Long couponLogId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据id查询优惠券日志】(selectCouponLogById-selectCouponLogById)-传入参数, couponLogId:{}", couponLogId);

		if(couponLogId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponLogId为空");
		}

		CouponLog couponLog = null;
		try {
			couponLog = couponLogService.selectCouponLogById(couponLogId);
			logger.info("===step2:【据id查询优惠券日志】(BootCouponLogController-selectCouponLogById)-根据id查询优惠券日志, couponLog:{}", couponLog);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据id查询优惠券日志】(BootCouponLogController-selectCouponLogById)-根据id查询优惠券日志-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(couponLog == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_LOG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_COUPON_LOG_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(couponLog));
		logger.info("===step3:【据id查询优惠券日志】(BootCouponLogController-selectCouponLogById)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 添加优惠券日志
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertCouponLog",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertCouponLog(
		@RequestBody CouponLogRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加优惠券日志】(BootCouponLogController-insertCouponLog)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String userAccount = req.getUserAccount();
		Integer couponId = req.getCouponId();
		Integer diamond = req.getDiamond();
		String url = req.getUrl();
		Integer price = req.getPrice();
		Integer couponType = req.getCouponType();
		Integer status = req.getStatus();
		String remark = req.getRemark();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userId为空");
		} else if(couponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponId为空");
		}

		CouponLog couponLog = new CouponLog();
		couponLog.setUserId(userId);
		couponLog.setCouponId(couponId);
		couponLog.setUserAccount(userAccount);
		couponLog.setUrl(url);
		couponLog.setPrice(price);
		couponLog.setDiamond(diamond);
		couponLog.setCouponType(couponType);
		couponLog.setStatus(status);
		couponLog.setRemark(remark);
		try {
			int i = couponLogService.insertCouponLog(couponLog);
			logger.info("===step2:【添加优惠券日志】(BootCouponLogController-insertCouponLog)-插入优惠券日志, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加优惠券日志】(BootCouponLogController-insertCouponLog)-插入优惠券日志-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step3:【添加优惠券日志】(BootCouponLogController-insertCouponLog)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

}