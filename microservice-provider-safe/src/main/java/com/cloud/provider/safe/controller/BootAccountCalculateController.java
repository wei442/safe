package com.cloud.provider.safe.controller;

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
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.common.util.MathUtil;
import com.ochain.pagehepler.mybatis.Page;
import com.cloud.provider.safe.boot.BootRestMapResponse;
import com.cloud.provider.safe.param.AccountCalculateParam;
import com.cloud.provider.safe.po.AccountCalculate;
import com.cloud.provider.safe.rest.request.account.AccountCalculateRequest;
import com.cloud.provider.safe.service.IBootAccountCalculateService;
import com.cloud.provider.safe.vo.account.AccountCalculateUserVo;

/**
 * 账户算力 BootAccountCalculateController
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/accountCalculate")
public class BootAccountCalculateController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//账户算力 Service
	@Autowired
	private IBootAccountCalculateService accountCalculateService;

	/**
	 * 分页查询账户算力列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectAccountCalculateListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountCalculateListByPage(
		@RequestBody AccountCalculateRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询账户算力列表】(BootAccountCalculateController-selectAccountCalculateListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		AccountCalculate accountCalculate = new AccountCalculate();
		Page<AccountCalculate> page = new Page<AccountCalculate>(pageNum, pageSize);
		List<AccountCalculate> list = null;
		try {
			list = accountCalculateService.selectAccountCalculateListByPage(page, accountCalculate);
			logger.info("===step2:【分页查询账户算力列表】(BootAccountCalculateController-selectAccountCalculateListByPage)-分页查询账户算力列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询账户算力列表】(BootAccountCalculateController-selectAccountCalculateListByPage)-分页查询账户算力列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_LIST_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse accountCalculateListPageResponse = new BootRestMapResponse();
		accountCalculateListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		accountCalculateListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		accountCalculateListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		accountCalculateListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		accountCalculateListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询账户算力列表】(BootAccountCalculateController-selectAccountCalculateListByPage)-返回信息, accountCalculateListPageResponse:{}", accountCalculateListPageResponse);
		return accountCalculateListPageResponse;
	}

	/**
	 * 查询账户算力列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectAccountCalculateList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountCalculateList(
		@RequestBody AccountCalculateRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【查询账户算力列表】(BootAccountCalculateController-selectAccountCalculateList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		AccountCalculate accountCalculate = new AccountCalculate();
		List<AccountCalculate> list = null;
		try {
			list = accountCalculateService.selectAccountCalculateList(accountCalculate);
			logger.info("===step2:【分页查询账户算力列表】(BootAccountCalculateController-selectAccountCalculateList)-查询账户算力列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询账户算力列表】(BootAccountCalculateController-selectAccountCalculateList)-查询账户算力列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_LIST_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse accountCalculateListResponse = new BootRestMapResponse();
		accountCalculateListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询 列表】(BootAccountCalculateController-selectAccountCalculateList)-返回信息, accountCalculateListResponse:{}", accountCalculateListResponse);
		return accountCalculateListResponse;
	}

	/**
	 * 分页查询倒序算力列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectAccountCalculateListSortCalculateByPage")
	@ResponseBody
	public BootRestMapResponse selectAccountCalculateListSortCalculateByPage(
		@RequestBody AccountCalculateRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询倒序算力列表】(BootAccountCalculateController-selectAccountCalculateListSortCalculateByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		Page<AccountCalculate> page = new Page<AccountCalculate>(pageNum, pageSize);

		AccountCalculateParam param = new AccountCalculateParam();
		param.setPage(page);
		List<AccountCalculateUserVo> list = null;
		try {
			list = accountCalculateService.selectAccountCalculateUserVoListByPage(param);
			logger.info("===step2:【分页查询倒序算力列表】(BootAccountCalculateController-selectAccountCalculateListSortCalculateByPage)-分页查询倒序算力列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询倒序算力列表】(BootAccountCalculateController-selectAccountCalculateListSortCalculateByPage)-分页查询倒序算力列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_LIST_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse accountCalculateListPageResponse = new BootRestMapResponse();
		accountCalculateListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		accountCalculateListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		accountCalculateListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		accountCalculateListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		accountCalculateListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询倒序算力列表】(BootAccountCalculateController-selectAccountCalculateListSortCalculateByPage)-返回信息, accountCalculateListPageResponse:{}", accountCalculateListPageResponse);
		return accountCalculateListPageResponse;
	}

	/**
	 * 分页查询总条数
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectAccountCalculateRowsByPage")
	@ResponseBody
	public BootRestMapResponse selectAccountCalculateRowsByPage(
		@RequestBody AccountCalculateRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询总条数】(BootAccountCalculateController-selectAccountCalculateRowsByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		Page<AccountCalculate> page = new Page<AccountCalculate>(pageNum, pageSize);
		long rows = 0l;
		try {
			rows = accountCalculateService.selectAccountCalculateUserVoRowsByCalculate();
			logger.info("===step2:【分页查询总条数】(BootAccountCalculateController-selectAccountCalculateRowsByPage)-查询总条数, rows:{}", rows);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询总条数】(BootAccountCalculateController-selectAccountCalculateRowsByPage)-查询总条数-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		page.setTotalCount(rows);

		BootRestMapResponse accountCalculateListPageResponse = new BootRestMapResponse();
		accountCalculateListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		accountCalculateListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		accountCalculateListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		accountCalculateListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		logger.info("===step3:【分页查询总条数】(BootAccountCalculateController-selectAccountCalculateRowsByPage)-返回信息, accountCalculateListPageResponse:{}", accountCalculateListPageResponse);
		return accountCalculateListPageResponse;
	}

	/**
	 * 根据id查询账户算力
	 * @param accountCalculateId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectAccountCalculateById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountCalculateById(
		@PathVariable(value="id",required=false) Integer accountCalculateId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询账户算力】(BootAccountCalculateController-selectAccountCalculateById)-传入参数, accountCalculateId:{}", accountCalculateId);

		if(accountCalculateId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "accountCalculateId为空");
		}

		AccountCalculate accountCalculate = null;
		try {
			accountCalculate = accountCalculateService.selectAccountCalculateById(accountCalculateId);
			logger.info("===step2:【根据id查询账户算力】(BootAccountCalculateController-selectAccountCalculateById)-根据accountCalculateId查询账户算力, accountCalculate:{}", accountCalculate);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询账户算力】(BootAccountCalculateController-selectAccountCalculateById)-根据accountCalculateId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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

		BootRestMapResponse accountCalculateResponse = new BootRestMapResponse();
		accountCalculateResponse.putAll((JSONObject) JSONObject.toJSON(accountCalculate));
		logger.info("===step3:【根据id查询账户算力】(BootAccountCalculateController-selectAccountCalculateById)-返回信息, accountCalculateResponse:{}", accountCalculateResponse);
		return accountCalculateResponse;
	}

	/**
	 * 根据userId查询账户算力
	 * @param userId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectAccountCalculateByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectAccountCalculateByUserId(
		@PathVariable(value="userId",required=false) Integer userId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userId查询账户算力】(BootAccountCalculateController-selectAccountCalculateByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}

		AccountCalculate accountCalculate = null;
		try {
			accountCalculate = accountCalculateService.selectAccountCalculateByUserId(userId);
			logger.info("===step2:【根据userId查询账户算力】(BootAccountCalculateController-selectAccountCalculateByUserId)-根据userId查询账户算力, accountCalculate:{}", accountCalculate);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userId查询账户算力】(BootAccountCalculateController-selectAccountCalculateByUserId)-根据userId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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

		BootRestMapResponse accountCalculateResponse = new BootRestMapResponse();
		accountCalculateResponse.putAll((JSONObject) JSONObject.toJSON(accountCalculate));
		logger.info("===step3:【根据userId查询账户算力】(BootAccountCalculateController-selectAccountCalculateByUserId)-返回信息, accountCalculateResponse:{}", accountCalculateResponse);
		return accountCalculateResponse;
	}

	/**
	 * 修改账户算力余额
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyAccountCalculateBalance",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyAccountCalculateBalance(
		@RequestBody AccountCalculateRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改账户算力余额】(BootAccountCalculateController-modifyAccountCalculateBalance)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer accountCalculateId = req.getAccountCalculateId();
		Integer payCalculate = req.getPayCalculate();
		Integer calculateType = req.getCalculateType();
		if(accountCalculateId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "accountCalculateId为空");
		} else if(payCalculate == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "payCalculate为空");
		} else if(calculateType == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "calculateType为空");
		}

		AccountCalculate accountCalculate = null;
		try {
			accountCalculate = accountCalculateService.selectAccountCalculateById(accountCalculateId);
			logger.info("===step2:【修改账户算力余额】(BootAccountCalculateController-modifyAccountCalculateBalance)-根据accountCalculateId查询账户算力, accountCalculate:{}", accountCalculate);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改账户算力余额】(BootAccountCalculateController-modifyAccountCalculateBalance)-根据accountCalculateId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
		Integer oldCalculate = accountCalculate.getCalculate();
		Integer oldCivilizeCalculate = accountCalculate.getCivilizeCalculate();
		Integer oldTaskCalculate = accountCalculate.getTaskCalculate();

		Integer balance = MathUtil.INSTANCE.add(Objects.toString(oldCalculate), Objects.toString(payCalculate)).intValue();
		logger.info("===step3:【修改账户算力余额】(BootAccountCalculateController-modifyAccountCalculateBalance)-计算账户算力余额, balance = {}", balance);
		if(SqlWheelConstants.SQL_CALCULATE_CONFIG_TYPE_CIVILIZE.equals(calculateType)) {
			Integer balanceCivilizeCalculate = MathUtil.INSTANCE.add(Objects.toString(oldCivilizeCalculate), Objects.toString(payCalculate)).intValue();
			logger.info("===step3.1:【修改账户算力余额】(BootAccountCalculateController-modifyAccountCalculateBalance))-计算账户算力余额, balanceCivilizeCalculate = {}", balanceCivilizeCalculate);
			accountCalculate.setCivilizeCalculate(balanceCivilizeCalculate);
		} else if(SqlWheelConstants.SQL_CALCULATE_CONFIG_TYPE_TASK.equals(calculateType)) {
			Integer balanceTaskCalculate = MathUtil.INSTANCE.add(Objects.toString(oldTaskCalculate), Objects.toString(payCalculate)).intValue();
			logger.info("===step3.1:【修改账户算力余额】(BootAccountCalculateController-modifyAccountCalculateBalance)-计算账户算力余额, balanceTaskCalculate = {}", balanceTaskCalculate);
			accountCalculate.setTaskCalculate(balanceTaskCalculate);
		}

		accountCalculate.setCalculate(balance);
		int i = 0;
		try {
			i = accountCalculateService.modifyAccountCalculate(accountCalculate);
			logger.info("===step4:【修改账户算力余额】(BootAccountCalculateController-modifyAccountCalculateBalance)-修改账户算力-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step4.1:【修改账户算力余额】(BootAccountCalculateController-modifyAccountCalculateBalance)-修改账户算力-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse accountResponse = new BootRestMapResponse();
		accountResponse.putAll((JSONObject) JSONObject.toJSON(accountCalculate));
		logger.info("===step5:【修改账户算力余额】(BootAccountCalculateController-modifyAccountBalance)-返回信息, accountResponse:{}", accountResponse);
		return accountResponse;
	}

	/**
	 * 修改账户算力文明分
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyAccountCalculateCivilize",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyAccountCalculateCivilize(
		@RequestBody AccountCalculateRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改账户算力文明分】(BootAccountCalculateController-modifyAccountCalculateCivilize)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer accountCalculateId = req.getAccountCalculateId();
		Integer civilizeCalculate = req.getCivilizeCalculate();
		if(accountCalculateId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "accountCalculateId为空");
		} else if(civilizeCalculate == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "civilizeCalculate为空");
		}

		AccountCalculate accountCalculate = null;
		try {
			accountCalculate = accountCalculateService.selectAccountCalculateById(accountCalculateId);
			logger.info("===step2:【修改账户算力文明分】(BootAccountCalculateController-modifyAccountCalculateCivilize)根据accountCalculateId查询账户算力, accountCalculate:{}", accountCalculate);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改账户算力文明分】(BootAccountCalculateController-modifyAccountCalculateCivilize)-根据accountCalculateId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
		Integer oldTaskCalculate = accountCalculate.getTaskCalculate();

		Integer balance = MathUtil.INSTANCE.add(Objects.toString(oldTaskCalculate), Objects.toString(civilizeCalculate)).intValue();
		logger.info("===step3:【修改账户算力文明分】(BootAccountCalculateController-modifyAccountCalculateCivilize)-计算账户算力余额, balance = {}", balance);

		accountCalculate.setCalculate(balance);
		accountCalculate.setCivilizeCalculate(civilizeCalculate);
		int i = 0;
		try {
			i = accountCalculateService.modifyAccountCalculate(accountCalculate);
			logger.info("===step4:【修改账户算力文明分】(BootAccountCalculateController-modifyAccountCalculateCivilize)-修改账户算力文明分-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step4.1:【修改账户算力文明分】(BootAccountCalculateController-modifyAccountCalculateCivilize)-修改账户算力文明分-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse accountResponse = new BootRestMapResponse();
		accountResponse.putAll((JSONObject) JSONObject.toJSON(accountCalculate));
		logger.info("===step5:【修改账户算力文明分】(BootAccountCalculateController-modifyAccountCalculateCivilize)-返回信息, accountResponse:{}", accountResponse);
		return accountResponse;
	}

	/**
	 * 修改账户算力
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyAccountCalculate",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyAccountCalculate(
		@RequestBody AccountCalculateRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改账户算力】(BootAccountCalculateController-modifyAccountCalculate)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer accountCalculateId = req.getAccountCalculateId();
		Integer civilizeCalculate = req.getCivilizeCalculate();
		if(accountCalculateId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "accountCalculateId为空");
		} else if(civilizeCalculate == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "civilizeCalculate为空");
		}

		AccountCalculate accountCalculate = null;
		try {
			accountCalculate = accountCalculateService.selectAccountCalculateById(accountCalculateId);
			logger.info("===step2:【修改账户算力】(BootAccountCalculateController-modifyAccountCalculate)根据accountCalculateId查询账户算力, accountCalculate:{}", accountCalculate);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改账户算力】(BootAccountCalculateController-modifyAccountCalculate)-根据accountCalculateId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(accountCalculate == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_ACCOUNT_CALCULATE_ENTITY_NOTEXIST_MSG);
		}

		accountCalculate.setCivilizeCalculate(civilizeCalculate);
		int i = 0;
		try {
			i = accountCalculateService.modifyAccountCalculate(accountCalculate);
			logger.info("===step3:【修改账户算力】(BootAccountCalculateController-modifyAccountCalculate)-修改账户算力-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改账户算力】(BootAccountCalculateController-modifyAccountCalculate)-修改账户算力-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse accountResponse = new BootRestMapResponse();
		accountResponse.putAll((JSONObject) JSONObject.toJSON(accountCalculate));
		logger.info("===step5:【修改账户算力】(BootAccountCalculateController-modifyAccountCalculate)-返回信息, accountResponse:{}", accountResponse);
		return accountResponse;
	}

}