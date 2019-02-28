package com.ochain.provider.wheel.controllers;

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
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.param.OrderRechargeCoinParam;
import com.ochain.provider.wheel.po.OrderRechargeCoin;
import com.ochain.provider.wheel.rest.request.order.OrderRechargeCoinRequest;
import com.ochain.provider.wheel.service.IBootOrderRechargeCoinService;

/**
 * 充币订单 BootOrderRechargeCoinController
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/orderRechargeCoin")
public class BootOrderRechargeCoinController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//充币订单 Service
	@Autowired
	private IBootOrderRechargeCoinService orderRechargeCoinService;

	/**
	 * 分页查询充币订单列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectOrderRechargeCoinListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectOrderRechargeCoinListByPage(
		@RequestBody OrderRechargeCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询充币订单列表】(BootOrderRechargeCoinController-selectOrderRechargeCoinListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		Long orderNo = req.getOrderNo();
		String transactionHash = req.getTransactionHash();
		String accountAddrFrom = req.getAccountAddrFrom();
		String accountAddrTo = req.getAccountAddrTo();
		Integer status = req.getStatus();
		Date completeTimeStart = req.getCompleteTimeStart();
		Date completeTimeEnd = req.getCompleteTimeEnd();
		Date createTimeStart = req.getCreateTimeStart();
		Date createTimeEnd = req.getCreateTimeEnd();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		OrderRechargeCoinParam orderRechargeCoinParam = new OrderRechargeCoinParam();
		orderRechargeCoinParam.setUserAccount(userAccount);
		orderRechargeCoinParam.setOrderNo(orderNo);
		orderRechargeCoinParam.setTransactionHash(transactionHash);
		orderRechargeCoinParam.setAccountAddrFrom(accountAddrFrom);
		orderRechargeCoinParam.setAccountAddrTo(accountAddrTo);
		orderRechargeCoinParam.setStatus(status);
		orderRechargeCoinParam.setCompleteTimeStart(completeTimeStart);
		orderRechargeCoinParam.setCompleteTimeEnd(completeTimeEnd);
		orderRechargeCoinParam.setCreateTimeStart(createTimeStart);
		orderRechargeCoinParam.setCreateTimeEnd(createTimeEnd);

		Page<OrderRechargeCoin> page = new Page<OrderRechargeCoin>(pageNum, pageSize);
		List<OrderRechargeCoin> list = null;
		try {
			list = orderRechargeCoinService.selectOrderRechargeCoinListByPage(page, orderRechargeCoinParam);
			logger.info("===step2:【分页查询充币订单列表】(BootOrderRechargeCoinController-selectOrderRechargeCoinListByPage)-分页查询充币订单列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询充币订单列表】(BootOrderRechargeCoinController-selectOrderRechargeCoinListByPage)-分页查询充币订单列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_LIST_NOTEXIST, BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse orderRechargeCoinResponse = new BootRestMapResponse();
		orderRechargeCoinResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		orderRechargeCoinResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		orderRechargeCoinResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		orderRechargeCoinResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		orderRechargeCoinResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询充币订单列表】(BootOrderRechargeCoinController-selectOrderRechargeCoinListByPage)-返回信息, orderRechargeCoinResponse:{}", orderRechargeCoinResponse);
		return orderRechargeCoinResponse;
	}

	/**
	 * 查询充币订单列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectOrderRechargeCoinList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectOrderRechargeCoinList(
		@RequestBody OrderRechargeCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【查询充币订单列表】(BootOrderRechargeCoinController-selectOrderRechargeCoinList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		Long orderNo = req.getOrderNo();
		String transactionHash = req.getTransactionHash();
		String accountAddrFrom = req.getAccountAddrFrom();
		String accountAddrTo = req.getAccountAddrTo();
		Integer status = req.getStatus();
		Date completeTimeStart = req.getCompleteTimeStart();
		Date completeTimeEnd = req.getCompleteTimeEnd();
		Date createTimeStart = req.getCreateTimeStart();
		Date createTimeEnd = req.getCreateTimeEnd();

		OrderRechargeCoinParam orderRechargeCoinParam = new OrderRechargeCoinParam();
		orderRechargeCoinParam.setUserAccount(userAccount);
		orderRechargeCoinParam.setOrderNo(orderNo);
		orderRechargeCoinParam.setTransactionHash(transactionHash);
		orderRechargeCoinParam.setAccountAddrFrom(accountAddrFrom);
		orderRechargeCoinParam.setAccountAddrTo(accountAddrTo);
		orderRechargeCoinParam.setStatus(status);
		orderRechargeCoinParam.setCompleteTimeStart(completeTimeStart);
		orderRechargeCoinParam.setCompleteTimeEnd(completeTimeEnd);
		orderRechargeCoinParam.setCreateTimeStart(createTimeStart);
		orderRechargeCoinParam.setCreateTimeEnd(createTimeEnd);

		List<OrderRechargeCoin> list = null;
		try {
			list = orderRechargeCoinService.selectOrderRechargeCoinList(orderRechargeCoinParam);
			logger.info("===step2:【分页查询充币订单列表】(BootOrderRechargeCoinController-selectOrderRechargeCoinList)-查询充币订单列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询充币订单列表】(BootOrderRechargeCoinController-selectOrderRechargeCoinList)-查询充币订单列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_LIST_NOTEXIST, BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse orderRechargeCoinResponse = new BootRestMapResponse();
		orderRechargeCoinResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询充币订单列表】(BootOrderRechargeCoinController-selectOrderRechargeCoinList)-返回信息, orderRechargeCoinResponse:{}", orderRechargeCoinResponse);
		return orderRechargeCoinResponse;
	}


	/**
	 * 根据id查询充币订单
	 * @param orderRechargeCoinId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectOrderRechargeCoinById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectOrderRechargeCoinById(
		@PathVariable(value="id",required=false) Long orderRechargeCoinId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询充币订单】(BootOrderRechargeCoinController-selectOrderRechargeCoinById)-传入参数, orderRechargeCoinId:{}", orderRechargeCoinId);

		if(orderRechargeCoinId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderRechargeCoinId为空");
		}

		OrderRechargeCoin orderRechargeCoin = null;
		try {
			orderRechargeCoin = orderRechargeCoinService.selectOrderRechargeCoinById(orderRechargeCoinId);
			logger.info("===step2:【根据id查询充币订单】(BootOrderRechargeCoinController-selectOrderRechargeCoinById)-根据orderRechargeCoinId查询充币订单, orderRechargeCoin:{}", orderRechargeCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询充币订单】(BootOrderRechargeCoinController-selectOrderRechargeCoinById)-根据orderRechargeCoinId查询充币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(orderRechargeCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse orderRechargeCoinResponse = new BootRestMapResponse();
		orderRechargeCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderRechargeCoin));
		logger.info("===step3:【根据id查询充币订单】(BootOrderRechargeCoinController-selectOrderRechargeCoinById)-返回信息, orderRechargeCoinResponse:{}", orderRechargeCoinResponse);
		return orderRechargeCoinResponse;
	}

	/**
	 * 根据orderNo查询充币订单
	 * @param orderNo
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectOrderRechargeCoinByOrderNo/{orderNo}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectOrderRechargeCoinByOrderNo(
		@PathVariable(value="orderNo",required=false) Long orderNo,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据orderNo查询充币订单】(BootOrderRechargeCoinController-selectOrderRechargeCoinByOrderNo)-传入参数, orderNo:{}", orderNo);

		if(orderNo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderNo为空");
		}

		OrderRechargeCoin orderRechargeCoin = null;
		try {
			orderRechargeCoin = orderRechargeCoinService.selectOrderRechargeCoinByOrderNo(orderNo);
			logger.info("===step2:【根据orderNo查询充币订单】(BootOrderRechargeCoinController-selectOrderRechargeCoinByOrderNo)-根据orderNo查询充币订单, orderRechargeCoin:{}", orderRechargeCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据orderNo查询充币订单】(BootOrderRechargeCoinController-selectOrderRechargeCoinByOrderNo)-根据orderNo查询充币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(orderRechargeCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse orderRechargeCoinResponse = new BootRestMapResponse();
		orderRechargeCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderRechargeCoin));
		logger.info("===step3:【根据orderNo查询充币订单】(BootOrderRechargeCoinController-selectOrderRechargeCoinByOrderNo)-返回信息, orderRechargeCoinResponse:{}", orderRechargeCoinResponse);
		return orderRechargeCoinResponse;
	}

	/**
	 * 插入充币订单
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertOrderRechargeCoin",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertOrderRechargeCoin(
		@RequestBody OrderRechargeCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入充币订单】(BootOrderRechargeCoinController-insertOrderRechargeCoin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
	    String userAccount = req.getUserAccount();
	    Long orderNo = req.getOrderNo();
	    String accountAddrFrom = req.getAccountAddrFrom();
	    String accountAddrTo = req.getAccountAddrTo();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(StringUtils.isBlank(userAccount)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userAccount为空");
		} else if(orderNo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderNo为空");
		}

		OrderRechargeCoin orderRechargeCoin = new OrderRechargeCoin();
		orderRechargeCoin.setUserId(userId);
		orderRechargeCoin.setUserAccount(userAccount);
		orderRechargeCoin.setOrderNo(orderNo);
		orderRechargeCoin.setAccountAddrFrom(accountAddrFrom);
		orderRechargeCoin.setAccountAddrTo(accountAddrTo);
		int i = 0;
		try {
			i = orderRechargeCoinService.insertOrderRechargeCoin(orderRechargeCoin);
			logger.info("=====step2:【插入充币订单】(BootOrderRechargeCoinController-insertOrderRechargeCoin)-插入充币订单-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step2.1:【插入充币订单】(BootOrderRechargeCoinController-insertOrderRechargeCoin)-插入充币订单-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse orderRechargeCoinResponse = new BootRestMapResponse();
		orderRechargeCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderRechargeCoin));
		logger.info("===step3:【插入充币订单】(BootOrderRechargeCoinController-insertOrderRechargeCoin)--返回信息, orderRechargeCoinResponse:{}", orderRechargeCoinResponse);
		return orderRechargeCoinResponse;
	}

	/**
	 * 修改充币订单
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyOrderRechargeCoin",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyOrderRechargeCoin(
		@RequestBody OrderRechargeCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Long orderRechargeCoinId = req.getOrderRechargeCoinId();
//	    Integer userId = req.getUserId();
//	    String userAccount = req.getUserAccount();
//	    Long orderNo = req.getOrderNo();
	    String accountAddrFrom = req.getAccountAddrFrom();
	    String accountAddrTo = req.getAccountAddrTo();
	    String transactionHash = req.getTransactionHash();
	    String gfc = req.getGfc();
	    String fee = req.getFee();
	    Integer status = req.getStatus();
	    String remark = req.getRemark();
	    Date completeTime = req.getCompleteTime();
		if(orderRechargeCoinId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderRechargeCoinId为空");
//		} else if(userId == null) {
//			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
//		} else if(StringUtils.isBlank(userAccount)) {
//			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userAccount为空");
//		} else if(fee == null) {
//			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "fee为空");
		}

		OrderRechargeCoin orderRechargeCoin = null;
		try {
			orderRechargeCoin = orderRechargeCoinService.selectOrderRechargeCoinById(orderRechargeCoinId);
			logger.info("===step2:【修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoin)-根据orderRechargeCoinId查询充币订单, orderRechargeCoin:{}", orderRechargeCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoin)-根据orderRechargeCoinId查询充币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(orderRechargeCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST_MSG);
		}

		orderRechargeCoin.setAccountAddrFrom(accountAddrFrom);
		orderRechargeCoin.setAccountAddrTo(accountAddrTo);
		orderRechargeCoin.setTransactionHash(transactionHash);
		orderRechargeCoin.setGfc(gfc);
		orderRechargeCoin.setStatus(status);
		orderRechargeCoin.setRemark(remark);
		orderRechargeCoin.setFee(fee);
		orderRechargeCoin.setCompleteTime(completeTime);
		int i = 0;
		try {
			i = orderRechargeCoinService.modifyOrderRechargeCoin(orderRechargeCoin);
			logger.info("=====step3:【修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoin)-修改充币订单-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step3.1:【修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoin)-修改充币订单-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse orderRechargeCoinResponse = new BootRestMapResponse();
		orderRechargeCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderRechargeCoin));
		logger.info("===step4:【修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoin)-返回信息, orderRechargeCoinResponse:{}", orderRechargeCoinResponse);
		return orderRechargeCoinResponse;
	}

	/**
	 * 根据订单编号修改充币订单
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyOrderRechargeCoinByOrderNo",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyOrderRechargeCoinByOrderNo(
		@RequestBody OrderRechargeCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据订单编号修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoinByOrderNo)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

	    Long orderNo = req.getOrderNo();
	    String accountAddrFrom = req.getAccountAddrFrom();
	    String accountAddrTo = req.getAccountAddrTo();
	    String transactionHash = req.getTransactionHash();
	    String gfc = req.getGfc();
	    String fee = req.getFee();
	    Integer status = req.getStatus();
	    String remark = req.getRemark();
	    Date completeTime = req.getCompleteTime();
		if(orderNo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderNo为空");
//		} else if(status == null) {
//			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "status为空");
		}

		OrderRechargeCoin orderRechargeCoin = null;
		try {
			orderRechargeCoin = orderRechargeCoinService.selectOrderRechargeCoinByOrderNo(orderNo);
			logger.info("===step2:【根据订单编号修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoinByOrderNo)-根据orderNo查询充币订单, orderRechargeCoin:{}", orderRechargeCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据订单编号修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoinByOrderNo)-根据orderRechargeCoinId查询充币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(orderRechargeCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST_MSG);
		}

		orderRechargeCoin.setAccountAddrFrom(accountAddrFrom);
		orderRechargeCoin.setAccountAddrTo(accountAddrTo);
		orderRechargeCoin.setTransactionHash(transactionHash);
		orderRechargeCoin.setGfc(gfc);
		orderRechargeCoin.setFee(fee);
		orderRechargeCoin.setStatus(status);
		orderRechargeCoin.setRemark(remark);
		orderRechargeCoin.setCompleteTime(completeTime);
		int i = 0;
		try {
			i = orderRechargeCoinService.modifyOrderRechargeCoin(orderRechargeCoin);
			logger.info("=====step3:【根据订单编号修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoinByOrderNo)-修改充币订单-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step3.1:【根据订单编号修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoinByOrderNo)-修改充币订单-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse orderRechargeCoinResponse = new BootRestMapResponse();
		orderRechargeCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderRechargeCoin));
		logger.info("===step4:【根据订单编号修改充币订单】(BootOrderRechargeCoinController-modifyOrderRechargeCoinByOrderNo)-返回信息, orderRechargeCoinResponse:{}", orderRechargeCoinResponse);
		return orderRechargeCoinResponse;
	}

	/**
	 * 修改充币订单状态
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyOrderRechargeCoinStatus",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyOrderRechargeCoinStatus(
		@RequestBody OrderRechargeCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改充币订单状态】(BootOrderRechargeCoinController-modifyOrderRechargeCoinStatus)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Long orderRechargeCoinId = req.getOrderRechargeCoinId();
	    Integer status = req.getStatus();
		if(orderRechargeCoinId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderRechargeCoinId为空");
		} else if(status == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "status为空");
		}

		OrderRechargeCoin orderRechargeCoin = null;
		try {
			orderRechargeCoin = orderRechargeCoinService.selectOrderRechargeCoinById(orderRechargeCoinId);
			logger.info("===step2:【修改充币订单状态】(BootOrderRechargeCoinController-modifyOrderRechargeCoinStatus)-根据orderRechargeCoinId查询充币订单, orderRechargeCoin:{}", orderRechargeCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改充币订单状态】(BootOrderRechargeCoinController-modifyOrderRechargeCoinStatus)-根据orderRechargeCoinId查询充币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(orderRechargeCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_RECHARGECOIN_ENTITY_NOTEXIST_MSG);
		}

		orderRechargeCoin.setStatus(status);
		int i = 0;
		try {
			i = orderRechargeCoinService.modifyOrderRechargeCoin(orderRechargeCoin);
			logger.info("=====step3:【修改充币订单状态】(BootOrderRechargeCoinController-modifyOrderRechargeCoinStatus)-修改充币订单-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step3.1:【修改充币订单状态】(BootOrderRechargeCoinController-modifyOrderRechargeCoinStatus)-修改充币订单-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse orderRechargeCoinResponse = new BootRestMapResponse();
		orderRechargeCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderRechargeCoin));
		logger.info("===step4:【修改充币订单状态】(BootOrderRechargeCoinController-modifyOrderRechargeCoinStatus)-返回信息, orderRechargeCoinResponse:{}", orderRechargeCoinResponse);
		return orderRechargeCoinResponse;
	}

}