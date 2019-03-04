package com.cloud.provider.safe.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

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
import com.ochain.common.util.MathUtil;
import com.ochain.pagehepler.mybatis.Page;
import com.cloud.provider.safe.boot.BootRestMapResponse;
import com.cloud.provider.safe.param.AccountParam;
import com.cloud.provider.safe.po.Account;
import com.cloud.provider.safe.rest.request.account.AccountRequest;
import com.cloud.provider.safe.service.IBootAccountService;
import com.cloud.provider.safe.vo.account.AccountUserVo;

/**
 * 账户 BootAccountController
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/account")
public class BootAccountController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//账户 Service
	@Autowired
	private IBootAccountService accountService;

	/**
	 * 分页查询账户列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectAccountListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountListByPage(
		@RequestBody AccountRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询账户列表】(BootAccountController-selectAccountListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		Account account = new Account();
		Page<Account> page = new Page<Account>(pageNum, pageSize);
		List<Account> list = null;
		try {
			list = accountService.selectAccountListByPage(page, account);
			logger.info("===step2:【分页查询账户列表】(BootAccountController-selectAccountListByPage)-分页查询账户列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询账户列表】(BootAccountController-selectAccountListByPage)-分页查询账户列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_LIST_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse accountListPageResponse = new BootRestMapResponse();
		accountListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		accountListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		accountListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		accountListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		accountListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询账户列表】(BootAccountController-selectAccountListByPage)-返回信息, accountListPageResponse:{}", accountListPageResponse);
		return accountListPageResponse;
	}

	/**
	 * 查询账户列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectAccountList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountList(
		@RequestBody AccountRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【查询账户列表】(BootAccountController-selectAccountList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Account account = new Account();
		List<Account> list = null;
		try {
			list = accountService.selectAccountList(account);
			logger.info("===step2:【分页查询账户列表】(BootAccountController-selectAccountList)-查询账户列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询账户列表】(BootAccountController-selectAccountList)-查询账户列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_LIST_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse calculateListResponse = new BootRestMapResponse();
		calculateListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询账户列表】(BootAccountController-selectAccountList)-返回信息, calculateListResponse:{}", calculateListResponse);
		return calculateListResponse;
	}

	/**
	 * 分页查询倒序账户能量方块列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectAccountListSortDiamondByPage")
	@ResponseBody
	public BootRestMapResponse selectAccountListSortDiamondByPage(
		@RequestBody AccountRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询倒序账户能量方块列表】(BootAccountController-selectAccountListSortDiamondByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		Page<Account> page = new Page<Account>(pageNum, pageSize);
		AccountParam param = new AccountParam();
		param.setPage(page);
		List<AccountUserVo> list = null;
		try {
			list = accountService.selectAccountVoListByPage(param);
			logger.info("===step2:【分页查询倒序账户能量方块列表】(BootAccountController-selectAccountListSortDiamondByPage)-分页查询倒序账户能量方块列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询倒序账户能量方块列表】(BootAccountController-selectAccountListSortDiamondByPage)-分页查询倒序账户能量方块列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_LIST_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse accountListPageResponse = new BootRestMapResponse();
		accountListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		accountListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		accountListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		accountListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		accountListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询倒序账户能量方块列表】(BootAccountController-selectAccountListSortDiamondByPage)-返回信息, accountListPageResponse:{}", accountListPageResponse);
		return accountListPageResponse;
	}

	/**
	 * 分页查询账户总条数
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectAccountRowsByPage")
	@ResponseBody
	public BootRestMapResponse selectAccountRowsByPage(
		@RequestBody AccountRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询账户总条数】(BootAccountController-selectAccountRowsByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		Page<Account> page = new Page<Account>(pageNum, pageSize);
		long rows = 0l;
		try {
			rows = accountService.selectAccountVoRowsByDiamond();
			logger.info("===step2:【分页查询账户总条数】(BootAccountController-selectAccountRowsByPage)-查询账户总条数, rows:{}", rows);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询账户总条数】(BootAccountController-selectAccountRowsByPage)-查询账户总条数-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		page.setTotalCount(rows);

		BootRestMapResponse accountListPageResponse = new BootRestMapResponse();
		accountListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		accountListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		accountListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		accountListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		logger.info("===step3:【分页查询账户总条数】(BootAccountController-selectAccountRowsByPage)-返回信息, accountListPageResponse:{}", accountListPageResponse);
		return accountListPageResponse;
	}

	/**
	 * 根据id查询账户
	 * @param accountId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectAccountById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountById(
		@PathVariable(value="id",required=false) Integer accountId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询账户】(BootAccountController-selectAccountById)-传入参数, accountId:{}", accountId);

		if(accountId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "accountId为空");
		}

		Account account = null;
		try {
			account = accountService.selectAccountById(accountId);
			logger.info("===step2:【根据id查询账户】(BootAccountController-selectAccountById)-根据accountId查询账户, account:{}", account);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询账户】(BootAccountController-selectAccountById)-根据accountId查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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

		BootRestMapResponse accountResponse = new BootRestMapResponse();
		accountResponse.putAll((JSONObject) JSONObject.toJSON(account));
		logger.info("===step3:【根据id查询账户】(BootAccountController-selectAccountById)-返回信息, accountResponse:{}", accountResponse);
		return accountResponse;
	}

	/**
	 * 根据userId查询账户
	 * @param userId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectAccountByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountByUserId(
		@PathVariable(value="userId",required=false) Integer userId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userId查询账户】(BootAccountController-selectAccountByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}

		Account account = null;
		try {
			account = accountService.selectAccountByUserId(userId);
			logger.info("===step2:【根据userId查询账户】(BootAccountController-selectAccountByUserId)-根据userId查询账户, account:{}", account);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userId查询账户】(BootAccountController-selectAccountByUserId)-根据userId查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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

		BootRestMapResponse accountResponse = new BootRestMapResponse();
		accountResponse.putAll((JSONObject) JSONObject.toJSON(account));
		logger.info("===step3:【根据userId查询账户】(BootAccountController-selectAccountByUserId)-返回信息, accountResponse:{}", accountResponse);
		return accountResponse;
	}

	/**
	 * 修改账户余额
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyAccountBalance",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyAccountBalance(
		@RequestBody AccountRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改账户余额】(BootAccountController-modifyAccountBalance)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer accountId = req.getAccountId();
	    BigDecimal payDiamond = req.getPayDiamond();
		if(accountId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "accountId为空");
		} else if(payDiamond == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "payDiamond为空");
		}

		Account account = null;
		try {
			account = accountService.selectAccountById(accountId);
			logger.info("===step2:【修改账户余额】(BootAccountController-modifyAccountBalance)-根据accountId查询账户, account:{}", account);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改账户余额】(BootAccountController-modifyAccountBalance)-根据accountId查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
		BigDecimal oldDiamond = account.getDiamond();

		//账户余额
		BigDecimal balance = MathUtil.INSTANCE.add(Objects.toString(oldDiamond), Objects.toString(payDiamond));
		logger.info("===step3:【修改账户余额】(BootAccountController-modifyAccountBalance)-计算账户余额, balance = {}", balance);

		account.setDiamond(balance);
		int i = 0;
		try {
			i = accountService.modifyAccount(account);
			logger.info("=====step4:【修改账户余额】(BootAccountController-modifyAccountBalance)-修改账户-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step4.1:【修改账户余额】(BootAccountController-modifyAccountBalance)-修改账户-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse accountResponse = new BootRestMapResponse();
		accountResponse.putAll((JSONObject) JSONObject.toJSON(account));
		 logger.info("===step5:【修改账户余额】(BootAccountController-modifyAccountBalance)-返回信息, accountResponse:{}", accountResponse);
		return accountResponse;
	}

	/**
	 * 修改账户
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyAccount",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyAccount(
		@RequestBody AccountRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改账户余额】(BootAccountController-modifyAccount)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer accountId = req.getAccountId();
	    BigDecimal diamond = req.getDiamond();
		if(accountId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "accountId为空");
		} else if(diamond == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamond为空");
		}

		Account account = null;
		try {
			account = accountService.selectAccountById(accountId);
			logger.info("===step2:【修改账户】(BootAccountController-modifyAccount)-根据accountId查询账户, account:{}", account);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改账户】(BootAccountController-modifyAccount)-根据accountId查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
		account.setDiamond(diamond);
		int i = 0;
		try {
			i = accountService.modifyAccount(account);
			logger.info("=====step3:【修改账户】(BootAccountController-modifyAccount)-修改账户-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step3.1:【修改账户】(BootAccountController-modifyAccount)-修改账户-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse accountResponse = new BootRestMapResponse();
		accountResponse.putAll((JSONObject) JSONObject.toJSON(account));
		logger.info("===step4:【修改账户】(BootAccountController-modifyAccount)-返回信息, accountResponse:{}", accountResponse);
		return accountResponse;
	}

}