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
import com.ochain.provider.wheel.param.OrderDrawCoinParam;
import com.ochain.provider.wheel.po.OrderDrawCoin;
import com.ochain.provider.wheel.rest.request.order.OrderDrawCoinRequest;
import com.ochain.provider.wheel.service.IBootOrderDrawCoinService;

/**
 * 提币订单 BootOrderDrawCoinController
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/orderDrawCoin")
public class BootOrderDrawCoinController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//提币订单 Service
	@Autowired
	private IBootOrderDrawCoinService orderDrawCoinService;

	/**
	 * 分页查询提币订单列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectOrderDrawCoinListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectOrderDrawCoinListByPage(
		@RequestBody OrderDrawCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询提币订单列表】(BootOrderDrawCoinController-selectOrderDrawCoinListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

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

		OrderDrawCoinParam orderDrawCoinParam = new OrderDrawCoinParam();
		orderDrawCoinParam.setUserAccount(userAccount);
		orderDrawCoinParam.setOrderNo(orderNo);
		orderDrawCoinParam.setTransactionHash(transactionHash);
		orderDrawCoinParam.setAccountAddrFrom(accountAddrFrom);
		orderDrawCoinParam.setAccountAddrTo(accountAddrTo);
		orderDrawCoinParam.setStatus(status);
		orderDrawCoinParam.setCompleteTimeStart(completeTimeStart);
		orderDrawCoinParam.setCompleteTimeEnd(completeTimeEnd);
		orderDrawCoinParam.setCreateTimeStart(createTimeStart);
		orderDrawCoinParam.setCreateTimeEnd(createTimeEnd);

		Page<OrderDrawCoin> page = new Page<OrderDrawCoin>(pageNum, pageSize);
		List<OrderDrawCoin> list = null;
		try {
			list = orderDrawCoinService.selectOrderDrawCoinListByPage(page, orderDrawCoinParam);
			logger.info("===step2:【分页查询提币订单列表】(BootOrderDrawCoinController-selectOrderDrawCoinListByPage)-分页查询提币订单列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询提币订单列表】(BootOrderDrawCoinController-selectOrderDrawCoinListByPage)-分页查询提币订单列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_DRAWCOIN_LIST_NOTEXIST, BootWheelConstants.WHEEL_ORDER_DRAWCOIN_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse orderDrawCoinResponse = new BootRestMapResponse();
		orderDrawCoinResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		orderDrawCoinResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		orderDrawCoinResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		orderDrawCoinResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		orderDrawCoinResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询提币订单列表】(BootOrderDrawCoinController-selectOrderDrawCoinListByPage)-返回信息, orderDrawCoinResponse:{}", orderDrawCoinResponse);
		return orderDrawCoinResponse;
	}

	/**
	 * 查询提币订单列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectOrderDrawCoinList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectOrderDrawCoinList(
		@RequestBody OrderDrawCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【查询提币订单列表】(BootOrderDrawCoinController-selectOrderDrawCoinList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

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
		OrderDrawCoinParam orderDrawCoinParam = new OrderDrawCoinParam();
		orderDrawCoinParam.setUserAccount(userAccount);
		orderDrawCoinParam.setOrderNo(orderNo);
		orderDrawCoinParam.setTransactionHash(transactionHash);
		orderDrawCoinParam.setAccountAddrFrom(accountAddrFrom);
		orderDrawCoinParam.setAccountAddrTo(accountAddrTo);
		orderDrawCoinParam.setStatus(status);
		orderDrawCoinParam.setCompleteTimeStart(completeTimeStart);
		orderDrawCoinParam.setCompleteTimeEnd(completeTimeEnd);
		orderDrawCoinParam.setCreateTimeStart(createTimeStart);
		orderDrawCoinParam.setCreateTimeEnd(createTimeEnd);

		List<OrderDrawCoin> list = null;
		try {
			list = orderDrawCoinService.selectOrderDrawCoinList(orderDrawCoinParam);
			logger.info("===step2:【分页查询提币订单列表】(BootOrderDrawCoinController-selectOrderDrawCoinList)-查询提币订单列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询提币订单列表】(BootOrderDrawCoinController-selectOrderDrawCoinList)-查询提币订单列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_DRAWCOIN_LIST_NOTEXIST, BootWheelConstants.WHEEL_ORDER_DRAWCOIN_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse orderDrawCoinResponse = new BootRestMapResponse();
		orderDrawCoinResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询提币订单列表】(BootOrderDrawCoinController-selectOrderDrawCoinList)-返回信息, orderDrawCoinResponse:{}", orderDrawCoinResponse);
		return orderDrawCoinResponse;
	}


	/**
	 * 根据id查询提币订单
	 * @param orderDrawCoinId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectOrderDrawCoinById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectOrderDrawCoinById(
		@PathVariable(value="id",required=false) Long orderDrawCoinId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询提币订单】(BootOrderDrawCoinController-selectOrderDrawCoinById)-传入参数, orderDrawCoinId:{}", orderDrawCoinId);

		if(orderDrawCoinId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderDrawCoinId为空");
		}

		OrderDrawCoin orderDrawCoin = null;
		try {
			orderDrawCoin = orderDrawCoinService.selectOrderDrawCoinById(orderDrawCoinId);
			logger.info("===step2:【根据id查询提币订单】(BootOrderDrawCoinController-selectOrderDrawCoinById)-根据orderDrawCoinId查询提币订单, orderDrawCoin:{}", orderDrawCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询提币订单】(BootOrderDrawCoinController-selectOrderDrawCoinById)-根据orderDrawCoinId查询提币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(orderDrawCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse orderDrawCoinResponse = new BootRestMapResponse();
		orderDrawCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderDrawCoin));
		logger.info("===step3:【根据id查询提币订单】(BootOrderDrawCoinController-selectOrderDrawCoinById)-返回信息, orderDrawCoinResponse:{}", orderDrawCoinResponse);
		return orderDrawCoinResponse;
	}

	/**
	 * 根据id查询提币订单
	 * @param orderDrawCoinId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectOrderDrawCoinByOrderNo/{orderNo}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectOrderDrawCoinByOrderNo(
		@PathVariable(value="orderNo",required=false) Long orderNo,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询提币订单】(BootOrderDrawCoinController-selectOrderDrawCoinByOrderNo)-传入参数, orderNo:{}", orderNo);

		if(orderNo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderNo为空");
		}

		OrderDrawCoin orderDrawCoin = null;
		try {
			orderDrawCoin = orderDrawCoinService.selectOrderDrawCoinByOrderNo(orderNo);
			logger.info("===step2:【根据orderNo查询提币订单】(BootOrderDrawCoinController-selectOrderDrawCoinByOrderNo)-根据orderNo查询提币订单, orderDrawCoin:{}", orderDrawCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据orderNo查询提币订单】(BootOrderDrawCoinController-selectOrderDrawCoinByOrderNo)-根据orderNo查询提币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
			if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
			}
			if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
				return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
			}
		}
		if(orderDrawCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse orderDrawCoinResponse = new BootRestMapResponse();
		orderDrawCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderDrawCoin));
		logger.info("===step3:【根据orderNo查询提币订单】(BootOrderDrawCoinController-selectOrderDrawCoinByOrderNo)-返回信息, orderDrawCoinResponse:{}", orderDrawCoinResponse);
		return orderDrawCoinResponse;
	}

	/**
	 * 插入提币订单
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertOrderDrawCoin",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertOrderDrawCoin(
		@RequestBody OrderDrawCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入提币订单】(BootOrderDrawCoinController-insertOrderDrawCoin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

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

		OrderDrawCoin orderDrawCoin = new OrderDrawCoin();
		orderDrawCoin.setUserId(userId);
		orderDrawCoin.setUserAccount(userAccount);
		orderDrawCoin.setOrderNo(orderNo);
		orderDrawCoin.setAccountAddrFrom(accountAddrFrom);
		orderDrawCoin.setAccountAddrTo(accountAddrTo);
		int i = 0;
		try {
			i = orderDrawCoinService.insertOrderDrawCoin(orderDrawCoin);
			logger.info("=====step2:【插入提币订单】(BootOrderDrawCoinController-insertOrderDrawCoin)-插入提币订单-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step2.1:【插入提币订单】(BootOrderDrawCoinController-insertOrderDrawCoin)-插入提币订单-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse orderDrawCoinResponse = new BootRestMapResponse();
		orderDrawCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderDrawCoin));
		logger.info("===step3:【插入提币订单】(BootOrderDrawCoinController-insertOrderDrawCoin)--返回信息, orderDrawCoinResponse:{}", orderDrawCoinResponse);
		return orderDrawCoinResponse;
	}

	/**
	 * 修改提币订单
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyOrderDrawCoin",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyOrderDrawCoin(
		@RequestBody OrderDrawCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoin)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

	    Long orderDrawCoinId = req.getOrderDrawCoinId();
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
		if(orderDrawCoinId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderDrawCoinId为空");
//		} else if(userId == null) {
//			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
//		} else if(StringUtils.isBlank(userAccount)) {
//			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userAccount为空");
//		} else if(fee == null) {
//			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "fee为空");
		}

		OrderDrawCoin orderDrawCoin = null;
		try {
			orderDrawCoin = orderDrawCoinService.selectOrderDrawCoinById(orderDrawCoinId);
			logger.info("===step2:【修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoin)-根据orderDrawCoinId查询提币订单, orderDrawCoin:{}", orderDrawCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoin)-根据orderDrawCoinId查询提币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(orderDrawCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST_MSG);
		}

		orderDrawCoin.setAccountAddrFrom(accountAddrFrom);
		orderDrawCoin.setAccountAddrTo(accountAddrTo);
		orderDrawCoin.setTransactionHash(transactionHash);
		orderDrawCoin.setGfc(gfc);
		orderDrawCoin.setStatus(status);
		orderDrawCoin.setRemark(remark);
		orderDrawCoin.setFee(fee);
		orderDrawCoin.setCompleteTime(completeTime);
		int i = 0;
		try {
			i = orderDrawCoinService.modifyOrderDrawCoin(orderDrawCoin);
			logger.info("=====step3:【修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoin)-修改提币订单-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step3.1:【修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoin)-修改提币订单-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse orderDrawCoinResponse = new BootRestMapResponse();
		orderDrawCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderDrawCoin));
		logger.info("===step4:【修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoin)-返回信息, orderDrawCoinResponse:{}", orderDrawCoinResponse);
		return orderDrawCoinResponse;
	}

	/**
	 * 根据订单编号修改提币订单
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyOrderDrawCoinByOrderNo",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyOrderDrawCoinByOrderNo(
		@RequestBody OrderDrawCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据订单编号修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoinByOrderNo)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

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
		} else if(status == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "status为空");
		}

		OrderDrawCoin orderDrawCoin = null;
		try {
			orderDrawCoin = orderDrawCoinService.selectOrderDrawCoinByOrderNo(orderNo);
			logger.info("===step2:【根据订单编号修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoinByOrderNo)-根据orderNo查询提币订单, orderDrawCoin:{}", orderDrawCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据订单编号修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoinByOrderNo)-根据orderNo查询提币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(orderDrawCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST_MSG);
		}

		orderDrawCoin.setAccountAddrFrom(accountAddrFrom);
		orderDrawCoin.setAccountAddrTo(accountAddrTo);
		orderDrawCoin.setTransactionHash(transactionHash);
		orderDrawCoin.setGfc(gfc);
		orderDrawCoin.setStatus(status);
		orderDrawCoin.setRemark(remark);
		orderDrawCoin.setFee(fee);
		orderDrawCoin.setCompleteTime(completeTime);
		int i = 0;
		try {
			i = orderDrawCoinService.modifyOrderDrawCoin(orderDrawCoin);
			logger.info("=====step3:【根据订单编号修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoinByOrderNo)-修改提币订单-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step3.1:【根据订单编号修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoinByOrderNo)-修改提币订单-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse orderDrawCoinResponse = new BootRestMapResponse();
		orderDrawCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderDrawCoin));
		logger.info("===step4:【根据订单编号修改提币订单】(BootOrderDrawCoinController-modifyOrderDrawCoinByOrderNo)-返回信息, orderDrawCoinResponse:{}", orderDrawCoinResponse);
		return orderDrawCoinResponse;
	}

	/**
	 * 修改提币订单状态
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyOrderDrawCoinStatus",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyOrderDrawCoinStatus(
		@RequestBody OrderDrawCoinRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改提币订单状态】(BootOrderDrawCoinController-modifyOrderDrawCoinStatus)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

	    Long orderDrawCoinId = req.getOrderDrawCoinId();
	    Integer status = req.getStatus();
		if(orderDrawCoinId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "orderDrawCoinId为空");
		} else if(status == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "status为空");
		}

		OrderDrawCoin orderDrawCoin = null;
		try {
			orderDrawCoin = orderDrawCoinService.selectOrderDrawCoinById(orderDrawCoinId);
			logger.info("===step2:【修改提币订单状态】(BootOrderDrawCoinController-modifyOrderDrawCoinStatus)-根据orderDrawCoinId查询提币订单, orderDrawCoin:{}", orderDrawCoin);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改提币订单状态】(BootOrderDrawCoinController-modifyOrderDrawCoinStatus)-根据orderDrawCoinId查询提币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(orderDrawCoin == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ORDER_DRAWCOIN_ENTITY_NOTEXIST_MSG);
		}

		orderDrawCoin.setStatus(status);
		int i = 0;
		try {
			i = orderDrawCoinService.modifyOrderDrawCoin(orderDrawCoin);
			logger.info("=====step3:【修改提币订单状态】(BootOrderDrawCoinController-modifyOrderDrawCoinStatus)-修改提币订单-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step3.1:【修改提币订单状态】(BootOrderDrawCoinController-modifyOrderDrawCoinStatus)-修改提币订单-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse orderDrawCoinResponse = new BootRestMapResponse();
		orderDrawCoinResponse.putAll((JSONObject) JSONObject.toJSON(orderDrawCoin));
		logger.info("===step4:【修改提币订单状态】(BootOrderDrawCoinController-modifyOrderDrawCoinStatus)-返回信息, orderDrawCoinResponse:{}", orderDrawCoinResponse);
		return orderDrawCoinResponse;
	}


}