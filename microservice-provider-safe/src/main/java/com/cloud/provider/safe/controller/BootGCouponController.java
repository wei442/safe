package com.cloud.provider.safe.controller;

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
import com.cloud.provider.safe.boot.BootRestMapResponse;
import com.cloud.provider.safe.po.GCoupon;
import com.cloud.provider.safe.rest.request.coupon.GCouponRequest;
import com.cloud.provider.safe.rest.request.coupon.GCouponRestRequest;
import com.cloud.provider.safe.service.IBootGCouponService;

/**
 *gofun优惠券 BootGCouponController
 * @author wang.tongmeng
 */
@RestController
@RequestMapping(value="/boot/gCoupon")
public class BootGCouponController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//gofun优惠券Service
	@Autowired
	private IBootGCouponService gCouponService;

	/**
	 * 分页查询gofun优惠券列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectGCouponListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectGCouponListByPage(
		@RequestBody GCouponRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询gofun优惠券列表】(BootGCouponController-selectGCouponListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		GCoupon gCoupon = new GCoupon();
		Page<GCoupon> page = new Page<GCoupon>(pageNum, pageSize);
		List<GCoupon> list = null;
		try {
			list = gCouponService.selectGCouponListByPage(page, gCoupon);
			logger.info("===step2:【分页查询gofun优惠券列表】(BootGCouponController-selectGCouponListByPage)-分页查询gofun优惠券列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询gofun优惠券列表】(BootGCouponController-selectGCouponListByPage)-分页查询gofun优惠券列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_GCOUPON_LIST_NOTEXIST, BootWheelConstants.WHEEL_GCOUPON_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse gCouponListPageResponse = new BootRestMapResponse();
		gCouponListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		gCouponListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		gCouponListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		gCouponListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		gCouponListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询gofun优惠券列表】(BootGCouponController-selectGCouponListByPage)-返回信息, gCouponListPageResponse:{}", gCouponListPageResponse);
		return gCouponListPageResponse;
	}

	/**
	 * 查询gofun优惠券列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectGCouponList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectGCouponList(
		@RequestBody GCouponRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询gofun优惠券列表】(BootGCouponController-selectGCouponList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		GCoupon gCoupon = new GCoupon();
		List<GCoupon> list = null;
		try {
			list = gCouponService.selectGCouponList(gCoupon);
			logger.info("===step2:【分页查询gofun优惠券列表】(BootGCouponController-selectGCouponList)-查询gofun优惠券列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询gofun优惠券列表】(BootGCouponController-selectGCouponList)-查询gofun优惠券列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_GCOUPON_LIST_NOTEXIST, BootWheelConstants.WHEEL_GCOUPON_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse gCouponListResponse = new BootRestMapResponse();
		gCouponListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询gofun优惠券列表】(BootGCouponController-selectGCouponList)-返回信息, gCouponListResponse:{}", gCouponListResponse);
		return gCouponListResponse;
	}

	/**
	 * 据gCouponId查询gofun优惠券
	 * @param gCouponId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectGCouponById/{gCouponId}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectGCouponById(
		@PathVariable(value="gCouponId",required=false) String gCouponId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据gCouponId查询gofun优惠券】(selectGCouponById-selectGCouponById)-传入参数, gCouponId:{}", gCouponId);

		if(gCouponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "gCouponId为空");
		}

		GCoupon gCoupon = null;
		try {
			gCoupon = gCouponService.selectGCouponById(gCouponId);
			logger.info("===step2:【据gCouponId查询gofun优惠券】(BootGCouponController-selectGCouponById)-gCouponIdid查询gofun优惠券, gCoupon:{}", gCoupon);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据gCouponId查询gofun优惠券】(BootGCouponController-selectGCouponById)-根据gCouponId查询gofun优惠券-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(gCoupon == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_GCOUPON_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_GCOUPON_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(gCoupon));
		logger.info("===step3:【据gCouponId查询gofun优惠券】(BootGCouponController-selectGCouponById)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 添加gofun优惠券
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertGCoupon",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertGCoupon(
		@RequestBody GCouponRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加gofun优惠券】(BootGCouponController-insertGCoupon)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

	    String gName = req.getgName();
	    Integer gMoney = req.getgMoney();
	    String gCityName = req.getgCityName();
	    Integer gPriceType = req.getgPriceType();
	    String gAreaInfo = req.getgAreaInfo();

		GCoupon gCoupon = new GCoupon();
		gCoupon.setgName(gName);
		gCoupon.setgMoney(gMoney);
		gCoupon.setgCityName(gCityName);
		gCoupon.setgPriceType(gPriceType);
		gCoupon.setgAreaInfo(gAreaInfo);
		try {
			int i = gCouponService.insertGCoupon(gCoupon);
			logger.info("===step2:【添加gofun优惠券】(BootGCouponController-insertGCoupon)-插入gofun优惠券, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加gofun优惠券】(BootGCouponController-insertGCoupon)-插入gofun优惠券-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step5:【添加gofun优惠券】(BootGCouponController-insertGCoupon)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 修改gofun优惠券
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyGCoupon",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyGCoupon(
		@RequestBody GCouponRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改gofun优惠券】(BootGCouponController-modifyGCoupon)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String gCouponId = req.getgCouponId();
		String gName = req.getgName();
	    Integer gMoney = req.getgMoney();
	    String gCityName = req.getgCityName();
	    Integer gPriceType = req.getgPriceType();
	    String gAreaInfo = req.getgAreaInfo();
		if(gCouponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "gCouponId为空");
		}

		GCoupon gCoupon = null;
		try {
			gCoupon = gCouponService.selectGCouponById(gCouponId);
			logger.info("===step2:【修改gofun优惠券】(BootGCouponController-modifyGCoupon)-根据gCouponId查询gofun优惠券, gCoupon:{}", gCoupon);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改gofun优惠券】(BootGCouponController-modifyGCoupon)-根据gCouponId查询gofun优惠券-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(gCoupon == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_GCOUPON_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_GCOUPON_ENTITY_NOTEXIST_MSG);
		}
		gCoupon.setgName(gName);
		gCoupon.setgMoney(gMoney);
		gCoupon.setgCityName(gCityName);
		gCoupon.setgPriceType(gPriceType);
		gCoupon.setgAreaInfo(gAreaInfo);
		try {
			int i = gCouponService.modifyGCoupon(gCoupon);
			logger.info("===step3:【修改gofun优惠券】(BootGCouponController-modifyGCoupon)-修改gofun优惠券, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改gofun优惠券】(BootGCouponController-modifyGCoupon)-修改gofun优惠券-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step4:【修改gofun优惠券】(BootGCouponController-modifyGCoupon)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 同步gofun优惠券
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/resetGCoupon",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse resetGCoupon(
		@RequestBody GCouponRestRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【同步gofun优惠券】(BootGCouponController-resetGCoupon)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String gCouponList = req.getgCouponList();

		if(gCouponList == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "gCouponList为空");
		}
		//String dataListStr = JSONObject.toJSONString(gCouponList);

		Boolean isRest = null;
		try {
			isRest = gCouponService.resetGCoupon(gCouponList);
			logger.info("===step2:【同步gofun优惠券】(BootGCouponController-resetGCoupon)-同步gofun优惠券事务处理, isRest:{}", isRest);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【同步gofun优惠券】(BootGCouponController-resetGCoupon)-同步gofun优惠券事务处理-异常, Exception = {}, message = {}",e,e.getMessage());
	        	String errorCode = e.getErrorCode();
	        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
	        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step4:【同步gofun优惠券】(BootGCouponController-resetGCoupon)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

}