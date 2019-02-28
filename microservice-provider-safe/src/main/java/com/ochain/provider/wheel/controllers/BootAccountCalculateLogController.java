package com.ochain.provider.wheel.controllers;

import java.util.List;

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
import com.ochain.common.constants.PageConstants;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.po.AccountCalculate;
import com.ochain.provider.wheel.po.AccountCalculateLog;
import com.ochain.provider.wheel.rest.request.account.AccountCalculateLogRequest;
import com.ochain.provider.wheel.service.IBootAccountCalculateLogService;
import com.ochain.provider.wheel.service.IBootAccountCalculateService;

/**
 * 账户算力日志 BootAccountCalculateLogController.java
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/accountCalculateLog")
public class BootAccountCalculateLogController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//账户算力 Service
	@Autowired
	private IBootAccountCalculateService accountCalculateService;

	//账户算力日志 Service
	@Autowired
	private IBootAccountCalculateLogService accountCalculateLogService;

	/**
	 * 分页查询账户算力日志列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectAccountCalculateLogListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountCalculateLogListByPage(
		@RequestBody AccountCalculateLogRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询账户算力日志列表】(BootAccountCalculateLogController-selectAccountCalculateLogListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		Integer accountCalculateLogType = req.getAccountCalculateLogType();
		Integer calculateType = req.getCalculateType();
		Integer accountCalculateId = req.getAccountCalculateId();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(calculateType == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "calculateType为空");
		}
		if(null == accountCalculateId) {
			AccountCalculate accountCalculate = null;
			try {
				accountCalculate = accountCalculateService.selectAccountCalculateByUserId(userId);
				logger.info("===step2:【分页查询账户算力日志列表】(BootAccountCalculateController-selectAccountCalculateByUserId)-根据userId查询账户算力, accountCalculate:{}", accountCalculate);
			} catch (BootServiceException e) {
				logger.error("===step2.1:【分页查询账户算力日志列表】(BootAccountCalculateController-selectAccountCalculateByUserId)-根据userId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				String errorCode = e.getErrorCode();
	        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
	        	}
	        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
	        	}
			}
			if(accountCalculate == null) {
				return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_ENTITY_NOTEXIST_MSG);
			}
			accountCalculateId = accountCalculate.getAccountCalculateId();
		}

		AccountCalculateLog accountCalculateLog = new AccountCalculateLog();
		accountCalculateLog.setAccountCalculateId(accountCalculateId);
		accountCalculateLog.setType(accountCalculateLogType);
		accountCalculateLog.setCalculateType(calculateType);
		Page<?> page = new Page<>(pageNum, pageSize);
		List<AccountCalculateLog> list = null;
		try {
			list = accountCalculateLogService.selectAccountCalculateLogListByPage(page, accountCalculateLog);
			logger.info("===step3:【分页查询账户算力日志列表】(BootAccountCalculateLogController-selectAccountCalculateLogListByPage)-分页查询账户算力日志列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step3.1:【分页查询账户算力日志列表】(BootAccountCalculateLogController-selectAccountCalculateLogListByPage)-分页查询账户算力日志列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_LOG_LIST_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_LOG_LIST_NOTEXIST);
		}

		BootRestMapResponse accountCalculateLogResponse = new BootRestMapResponse();
		accountCalculateLogResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step4:【分页查询账户算力日志列表】(BootAccountCalculateLogController-selectAccountCalculateLogListByPage)-返回信息, accountCalculateLogResponse:{}", accountCalculateLogResponse);
		return accountCalculateLogResponse;
	}

	/**
	 * 插入账户算力日志
	 * @param req
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertAccountCalculateLog",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertAccountCalculateLog(
		@RequestBody AccountCalculateLogRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入账户算力日志】(BootAccountCalculateLogController-insertAccountCalculateLog)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer accountCalculateId = req.getAccountCalculateId();
	    String content = req.getContent();
	    Integer accountCalculateLogType = req.getAccountCalculateLogType();
	    Integer accountCalculateLogStatus = req.getAccountCalculateLogStatus();
	    Integer calculate = req.getCalculate();
	    Integer calculateType = req.getCalculateType();
	    Integer balance = req.getBalance();
	    String source = req.getSource();
		if(accountCalculateId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "accountCalculateId为空");
		}

		//创建账户算力日志表
		AccountCalculateLog accountCalculateLog = new AccountCalculateLog();
		accountCalculateLog.setAccountCalculateId(accountCalculateId);
		accountCalculateLog.setContent(content);
		accountCalculateLog.setType(accountCalculateLogType);
		accountCalculateLog.setStatus(accountCalculateLogStatus);
		accountCalculateLog.setCalculate(calculate);
		accountCalculateLog.setCalculateType(calculateType);
		accountCalculateLog.setBalance(balance);
		accountCalculateLog.setSource(source);
		int i = 0;
		try {
			i = accountCalculateLogService.insertAccountCalculateLog(accountCalculateLog);
			logger.info("===step2:【插入账户算力日志】(BootAccountCalculateLogController-insertAccountCalculateLog)-插入账户算力日志-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【插入账户算力日志】(BootAccountCalculateLogController-insertAccountCalculateLog)-插入账户算力日志-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse accountCalculateLogResponse = new BootRestMapResponse();
		accountCalculateLogResponse.putAll((JSONObject) JSONObject.toJSON(accountCalculateLog));
		logger.info("===step4:【插入账户算力日志】(BootAccountCalculateLogController-insertAccountCalculateLog)-返回信息, accountCalculateLogResponse:{}", accountCalculateLogResponse);
		return accountCalculateLogResponse;
	}

}