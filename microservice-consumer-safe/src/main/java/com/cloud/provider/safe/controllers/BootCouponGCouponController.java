package com.ochain.provider.wheel.controllers;

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
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.po.CouponGCoupon;
import com.ochain.provider.wheel.rest.request.coupon.CouponGCouponRequest;
import com.ochain.provider.wheel.service.IBootCouponGCouponService;

/**
 *优惠券关联 BootCouponGCouponController
 * @author wei.yong
 */
@RestController
@RequestMapping(value="/boot/couponGCoupon")
public class BootCouponGCouponController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//优惠券关联Service
	@Autowired
	private IBootCouponGCouponService couponGCouponService;

	/**
	 * 分页查询优惠券关联列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponGCouponListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponGCouponListByPage(
		@RequestBody CouponGCouponRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询优惠券关联列表】(BootCouponGCouponController-selectCouponGCouponListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		CouponGCoupon couponGCoupon = new CouponGCoupon();
		Page<CouponGCoupon> page = new Page<CouponGCoupon>(pageNum, pageSize);
		List<CouponGCoupon> list = null;
		try {
			list = couponGCouponService.selectCouponGCouponListByPage(page, couponGCoupon);
			logger.info("===step2:【分页查询优惠券关联列表】(BootCouponGCouponController-selectCouponGCouponListByPage)-分页查询优惠券关联列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询优惠券关联列表】(BootCouponGCouponController-selectCouponGCouponListByPage)-分页查询优惠券关联列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_GCOUPON_LIST_NOTEXIST, BootWheelConstants.WHEEL_COUPON_GCOUPON_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse couponGCouponListPageResponse = new BootRestMapResponse();
		couponGCouponListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		couponGCouponListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		couponGCouponListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		couponGCouponListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		couponGCouponListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询优惠券关联列表】(BootCouponGCouponController-selectCouponGCouponListByPage)-返回信息, couponGCouponListPageResponse:{}", couponGCouponListPageResponse);
		return couponGCouponListPageResponse;
	}

	/**
	 * 查询优惠券关联列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponGCouponList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponGCouponList(
		@RequestBody CouponGCouponRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询优惠券关联列表】(BootCouponGCouponController-selectCouponGCouponList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		CouponGCoupon couponGCoupon = new CouponGCoupon();
		List<CouponGCoupon> list = null;
		try {
			list = couponGCouponService.selectCouponGCouponList(couponGCoupon);
			logger.info("===step2:【分页查询优惠券关联列表】(BootCouponGCouponController-selectCouponGCouponList)-查询优惠券关联列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询优惠券关联列表】(BootCouponGCouponController-selectCouponGCouponList)-查询优惠券关联列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_GCOUPON_LIST_NOTEXIST, BootWheelConstants.WHEEL_COUPON_GCOUPON_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse couponGCouponListResponse = new BootRestMapResponse();
		couponGCouponListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询优惠券关联列表】(BootCouponGCouponController-selectCouponGCouponList)-返回信息, couponGCouponListResponse:{}", couponGCouponListResponse);
		return couponGCouponListResponse;
	}

	/**
	 * 据id查询优惠券关联
	 * @param couponGCouponId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponGCouponById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponGCouponById(
		@PathVariable(value="id",required=false) Integer couponGCouponId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据id查询优惠券关联】(selectCouponGCouponById-selectCouponGCouponById)-传入参数, couponGCouponId:{}", couponGCouponId);

		if(couponGCouponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponGCouponId为空");
		}

		CouponGCoupon couponGCoupon = null;
		try {
			couponGCoupon = couponGCouponService.selectCouponGCouponById(couponGCouponId);
			logger.info("===step2:【据id查询优惠券关联】(BootCouponGCouponController-selectCouponGCouponById)-根据id查询优惠券关联, couponGCoupon:{}", couponGCoupon);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据id查询优惠券关联】(BootCouponGCouponController-selectCouponGCouponById)-根据id查询优惠券关联-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(couponGCoupon == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(couponGCoupon));
		logger.info("===step3:【据id查询优惠券关联】(BootCouponGCouponController-selectTemplateById)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 据couponId查询优惠券关联
	 * @param couponGCouponId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponGCouponByCouponId/{couponId}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponGCouponByCouponId(
		@PathVariable(value="couponId",required=false) Integer couponId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据couponId查询优惠券关联】(selectCouponGCouponById-selectCouponGCouponByCouponId)-传入参数, couponId:{}", couponId);

		if(couponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponId为空");
		}

		CouponGCoupon couponGCoupon = null;
		try {
			couponGCoupon = couponGCouponService.selectCouponGCouponByCouponId(couponId);
			logger.info("===step2:【据couponId查询优惠券关联】(BootCouponGCouponController-selectCouponGCouponByCouponId)-根据couponId查询优惠券关联, couponGCoupon:{}", couponGCoupon);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据couponId查询优惠券关联】(BootCouponGCouponController-selectCouponGCouponByCouponId)-根据couponId查询优惠券关联-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(couponGCoupon == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(couponGCoupon));
		logger.info("===step3:【据couponId查询优惠券关联】(BootCouponGCouponController-selectCouponGCouponByCouponId)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 据gCouponId查询优惠券关联
	 * @param couponGCouponId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponGCouponByGCouponId/{gCouponId}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponGCouponByGCouponId(
		@PathVariable(value="gCouponId",required=false) String gCouponId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据gCouponId查询优惠券关联】(selectCouponGCouponById-selectCouponGCouponById)-传入参数, gCouponId:{}", gCouponId);

		if(StringUtils.isBlank(gCouponId)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "gCouponId为空");
		}

		CouponGCoupon couponGCoupon = null;
		try {
			couponGCoupon = couponGCouponService.selectCouponGCouponByGCouponId(gCouponId);
			logger.info("===step2:【据gCouponId查询优惠券关联】(BootCouponGCouponController-selectCouponGCouponByGCouponId)-根据gCouponId查询优惠券关联, couponGCoupon:{}", couponGCoupon);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据gCouponId查询优惠券关联】(BootCouponGCouponController-selectCouponGCouponByGCouponId)-根据gCouponId查询优惠券关联-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(couponGCoupon == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(couponGCoupon));
		logger.info("===step3:【据gCouponId查询优惠券关联】(BootCouponGCouponController-selectCouponGCouponByGCouponId)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 添加优惠券关联
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertCouponGCoupon",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertCouponGCoupon(
		@RequestBody CouponGCouponRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加优惠券关联】(BootCouponGCouponController-insertCouponGCoupon)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

	    Integer couponId = req.getCouponId();
	    String gCouponId = req.getgCouponId();
		if(couponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponId为空");
		} else if(gCouponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "gCouponId为空");
		}

		CouponGCoupon couponGCoupon = new CouponGCoupon();
		couponGCoupon.setCouponId(couponId);
		couponGCoupon.setgCouponId(gCouponId);
		try {
			int i = couponGCouponService.insertCouponGCoupon(couponGCoupon);
			logger.info("===step2:【添加优惠券关联】(BootCouponGCouponController-insertCouponGCoupon)-插入优惠券关联, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加优惠券关联】(BootCouponGCouponController-insertCouponGCoupon)-插入优惠券关联-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step5:【添加优惠券关联】(BootCouponGCouponController-insertCouponGCoupon)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 修改优惠券关联
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyCouponGCoupon",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyCouponGCoupon(
		@RequestBody CouponGCouponRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改优惠券关联】(BootCouponGCouponController-modifyCouponGCoupon)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer couponGCouponId = req.getCouponGCouponId();
	    Integer couponId = req.getCouponId();
	    String gCouponId = req.getgCouponId();
		if(couponGCouponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponGCouponId为空");
		} else if(couponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponId为空");
		} else if(gCouponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "gCouponId为空");
		}

		CouponGCoupon couponGCoupon = null;
		try {
			couponGCoupon = couponGCouponService.selectCouponGCouponById(couponGCouponId);
			logger.info("===step2:【修改优惠券关联】(BootCouponGCouponController-modifyCouponGCoupon)-根据couponGCouponId查询优惠券关联, couponGCoupon:{}", couponGCoupon);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改优惠券关联】(BootCouponGCouponController-modifyCouponGCoupon)-根据couponGCouponId查询优惠券关联-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(couponGCoupon == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_COUPON_GCOUPON_ENTITY_NOTEXIST_MSG);
		}
		couponGCoupon.setCouponId(couponId);
		couponGCoupon.setgCouponId(gCouponId);
		try {
			int i = couponGCouponService.modifyCouponGCoupon(couponGCoupon);
			logger.info("===step3:【修改优惠券关联】(BootCouponGCouponController-modifyCouponGCoupon)-修改优惠券关联, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改优惠券关联】(BootCouponGCouponController-modifyCouponGCoupon)-修改优惠券关联-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step4:【修改优惠券关联】(BootCouponGCouponController-modifyCouponGCoupon)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

}