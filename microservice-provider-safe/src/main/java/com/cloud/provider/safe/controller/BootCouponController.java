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
import com.cloud.provider.safe.param.CouponParam;
import com.cloud.provider.safe.po.Coupon;
import com.cloud.provider.safe.po.CouponGCoupon;
import com.cloud.provider.safe.po.GCoupon;
import com.cloud.provider.safe.rest.request.coupon.CouponRequest;
import com.cloud.provider.safe.service.IBootCouponGCouponService;
import com.cloud.provider.safe.service.IBootCouponService;
import com.cloud.provider.safe.service.IBootGCouponService;
import com.cloud.provider.safe.vo.coupon.CouponAndGCouponVo;

/**
 *优惠券 BootCouponController
 * @author wang.tongmeng
 */
@RestController
@RequestMapping(value="/boot/coupon")
public class BootCouponController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//优惠券Service
	@Autowired
	private IBootCouponService couponService;

	//优惠券关联表Service
	@Autowired
	private IBootCouponGCouponService couponGCouponService;

	//优惠券关联表Service
	@Autowired
	private IBootGCouponService gCouponService;

	/**
	 * 分页查询优惠券列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponListByPage(
		@RequestBody CouponRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询优惠券列表】(BootCouponController-selectCouponListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer amount = req.getAmount();
		Integer isUse = req.getIsUse();
		Integer couponType = req.getCouponType();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		CouponParam param = new CouponParam();
		param.setAmount(amount);
		param.setCouponType(couponType);
		param.setIsUse(isUse);
		param.setOrderByClause(" t1.id desc ");

		Page<Coupon> page = new Page<Coupon>(pageNum, pageSize);
		List<CouponAndGCouponVo> list = null;
		try {
			list = couponService.selectCouponAndGCouponVoListByParam(page, param);
			logger.info("===step2:【分页查询优惠券列表】(BootCouponController-selectCouponListByPage)-分页查询优惠券列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询优惠券列表】(BootCouponController-selectCouponListByPage)-分页查询优惠券列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_LIST_NOTEXIST, BootWheelConstants.WHEEL_COUPON_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse couponListPageResponse = new BootRestMapResponse();
		couponListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		couponListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		couponListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		couponListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		couponListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询优惠券列表】(BootCouponController-selectCouponListByPage)-返回信息, couponListPageResponse:{}", couponListPageResponse);
		return couponListPageResponse;
	}

	/**
	 * 查询优惠券列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponList(
		@RequestBody CouponRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询优惠券列表】(BootCouponController-selectCouponList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Coupon coupon = new Coupon();
		coupon.setDiamond(req.getDiamond());
		coupon.setIsUse(req.getIsUse());
		List<Coupon> list = null;
		try {
			list = couponService.selectCouponList(coupon);
			logger.info("===step2:【分页查询优惠券列表】(BootCouponController-selectCouponList)-查询优惠券列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询优惠券列表】(BootCouponController-selectCouponList)-查询优惠券列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_LIST_NOTEXIST, BootWheelConstants.WHEEL_COUPON_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse couponListResponse = new BootRestMapResponse();
		couponListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询优惠券列表】(BootCouponController-selectCouponList)-返回信息, couponListResponse:{}", couponListResponse);
		return couponListResponse;
	}

	/**
	 * 据id查询优惠券
	 * @param couponId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCouponById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCouponById(
		@PathVariable(value="id",required=false) Integer couponId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据id查询优惠券】(selectCouponById-selectCouponById)-传入参数, couponId:{}", couponId);

		if(couponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponId为空");
		}

		Coupon coupon = null;
		try {
			coupon = couponService.selectCouponById(couponId);
			logger.info("===step2:【据id查询优惠券】(BootCouponController-selectCouponById)-根据id查询优惠券, coupon:{}", coupon);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据id查询优惠券】(BootCouponController-selectCouponById)-根据id查询优惠券-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(coupon == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_COUPON_ENTITY_NOTEXIST_MSG);
		}
		//查询gCouponId
		CouponGCoupon couponGCoupon = new CouponGCoupon();
		couponGCoupon.setCouponId(couponId);
		List<CouponGCoupon> list = null;
		try {
			list = couponGCouponService.selectCouponGCouponList(couponGCoupon);
			logger.info("===step2:【分页查询优惠券列表】(BootCouponController-selectCouponList)-查询优惠券列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			String errorCode = e.getErrorCode();
			if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
	        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, "没有关联表数据");
		}
		//查询gCoupon表数据
		GCoupon gCoupon = null;
		try {
			gCoupon = gCouponService.selectGCouponById(list.get(0).getgCouponId());
		} catch (BootServiceException e) {
			String errorCode = e.getErrorCode();
			if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
	        	}
		}
		if(gCoupon == null) {
			return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, "没有相关联的gofun优惠券数据");
		}
		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(coupon));
		resResponse.put("gCouponId", list.get(0).getgCouponId());
		resResponse.put("price", gCoupon.getgMoney());
		resResponse.put("couponType", gCoupon.getgPriceType());
		logger.info("===step3:【据id查询优惠券】(BootCouponController-selectCouponById)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 添加优惠券
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertCoupon",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertCoupon(
		@RequestBody CouponRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加优惠券】(BootCouponController-insertCoupon)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String url = req.getUrl();
		Integer price = req.getPrice();
		Integer couponType = req.getCouponType();
		Integer amount = req.getAmount();
		Integer diamond = req.getDiamond();
		Integer isUse = req.getIsUse();
		String gCouponId = req.getgCouponId();
		if(StringUtils.isBlank(url)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "url为空");
		} else if(price == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "price为空");
		} else if(diamond == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "diamond为空");
		} else if(couponType == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponType为空");
		} else if(isUse == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "isUse为空");
		} else if(StringUtils.isBlank(gCouponId)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "gCouponId为空");
		}

		Coupon coupon = new Coupon();
		coupon.setPrice(price);
		coupon.setCouponType(couponType);
		coupon.setAmount(amount);
		coupon.setDiamond(diamond);
		coupon.setIsUse(isUse);
		coupon.setUrl(url);
		CouponGCoupon couponGCoupon = new CouponGCoupon();
		couponGCoupon.setgCouponId(gCouponId);
		try {
			int i = couponService.insertCoupon(coupon, couponGCoupon);
			logger.info("===step2:【添加优惠券】(BootCouponController-insertCoupon)-插入优惠券, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加优惠券】(BootCouponController-insertCoupon)-插入优惠券-异常, Exception = {}, message = {}",e,e.getMessage());
	        	String errorCode = e.getErrorCode();
	        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
	        	}
	        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
	        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step5:【添加优惠券】(BootCouponController-insertCoupon)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 修改优惠券
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyCoupon",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyCoupon(
		@RequestBody CouponRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改优惠券】(BootCouponController-modifyCoupon)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer couponId = req.getCouponId();
		Integer price = req.getPrice();
		Integer amount = req.getAmount();
		Integer isDelete = req.getIsDelete();
		Integer diamond = req.getDiamond();
		Integer isUse = req.getIsUse();
		String toUrl = req.getUrl();
		String gCouponId = req.getgCouponId();
		if(couponId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "couponId为空");
		}

		Coupon coupon = null;
		try {
			coupon = couponService.selectCouponById(couponId);
			logger.info("===step2:【修改优惠券】(BootCouponController-modifyCoupon)-根据couponId查询优惠券, coupon:{}", coupon);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改优惠券】(BootCouponController-modifyCoupon)-根据couponId查询优惠券-异常, Exception = {}, message = {}",e,e.getMessage());
	        	String errorCode = e.getErrorCode();
	        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
	        	}
		}
		if(coupon == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_COUPON_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_COUPON_ENTITY_NOTEXIST_MSG);
		}
		coupon.setAmount(amount);
		coupon.setDiamond(diamond);
		coupon.setPrice(price);
		coupon.setIsDelete(isDelete);
		coupon.setUrl(toUrl);
		coupon.setIsUse(isUse);

		CouponGCoupon couponGCoupon = new CouponGCoupon();
		couponGCoupon.setgCouponId(gCouponId);
		try {
			int i = couponService.modifyCoupon(coupon, couponGCoupon);
			logger.info("===step3:【修改优惠券】(BootCouponController-modifyCoupon)-修改优惠券, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改优惠券】(BootCouponController-modifyCoupon)-修改优惠券-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step4:【修改优惠券】(BootCouponController-modifyCoupon)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}


}