package com.cloud.provider.safe.controller;

import java.math.BigDecimal;
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
import com.cloud.provider.safe.boot.BootRestMapResponse;
import com.cloud.provider.safe.po.Account;
import com.cloud.provider.safe.po.AccountLog;
import com.cloud.provider.safe.rest.request.account.AccountLogRequest;
import com.cloud.provider.safe.service.IBootAccountLogService;
import com.cloud.provider.safe.service.IBootAccountService;

/**
 * 账户日志 BootAccountLogController.java
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/accountLog")
public class BootAccountLogController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//账户 Service
	@Autowired
	private IBootAccountService accountService;

	//账户日志 Service
	@Autowired
	private IBootAccountLogService accountLogService;

	/**
	 * 分页查询账户日志列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectAccountLogListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountLogListByPage(
		@RequestBody AccountLogRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询账户日志列表】(BootAccountLogController-selectAccountLogListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		 Integer accountLogType = req.getAccountLogType();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}

		Account account = null;
		try {
			account = accountService.selectAccountByUserId(userId);
			logger.info("===step2:【分页查询账户日志列表】(BootAccountLogController-selectAccountLogListByPage)-根据userId查询账户, account:{}", account);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询账户日志列表】(BootAccountLogController-selectAccountLogListByPage)-根据userId查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(account == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_ENTITY_NOTEXIST_MSG);
		}
		Integer accountId = account.getAccountId();

		AccountLog accountLog = new AccountLog();
		accountLog.setAccountId(accountId);
		accountLog.setType(accountLogType);
		Page<?> page = new Page<>(pageNum, pageSize);
		List<AccountLog> list = null;
		try {
			list = accountLogService.selectAccountLogListByPage(page, accountLog);
			logger.info("===step3:【分页查询账户日志列表】(BootAccountLogController-selectAccountLogListByPage)-分页查询账户日志列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step3.1:【分页查询账户日志列表】(BootAccountLogController-selectAccountLogListByPage)-分页查询账户日志列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_LOG_LIST_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_LOG_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse accountLogResponse = new BootRestMapResponse();
		accountLogResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step4:【分页查询账户日志列表】(BootAccountLogController-selectAccountLogListByPage)-返回信息, accountLogResponse:{}", accountLogResponse);
		return accountLogResponse;
	}

	/**
	 * 插入账户日志
	 * @param req
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertAccountLog",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertAccountLog(
		@RequestBody AccountLogRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入账户日志】(BootAccountLogController-insertAccountLog)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer accountId = req.getAccountId();
	    BigDecimal diamond = req.getDiamond();
	    String content = req.getContent();
	    Integer accountLogType = req.getAccountLogType();
	    Integer accountLogStatus = req.getAccountLogStatus();
	    BigDecimal balance = req.getBalance();
	    String source = req.getSource();
		if(accountId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "accountId为空");
		}

		//创建账户日志表
		AccountLog accountLog = new AccountLog();
		accountLog.setAccountId(accountId);
		accountLog.setDiamond(diamond);
		accountLog.setContent(content);
		accountLog.setType(accountLogType);
		accountLog.setStatus(accountLogStatus);
		accountLog.setBalance(balance);
		accountLog.setSource(source);
		int i = 0;
		try {
			i = accountLogService.insertAccountLog(accountLog);
			logger.info("===step2:【插入账户日志】(BootAccountLogController-insertAccountLog)-插入账户日志-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【插入账户日志】(BootAccountLogController-insertAccountLog)-插入账户日志-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse accountLogResponse = new BootRestMapResponse();
		logger.info("===step4:【插入账户日志】(BootAccountLogController-insertAccountLog)-返回信息, accountLogResponse:{}", accountLogResponse);
		return accountLogResponse;
	}

}