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
import com.ochain.provider.wheel.po.UserTransactionPassword;
import com.ochain.provider.wheel.rest.request.user.UserTransactionPasswordRequest;
import com.ochain.provider.wheel.service.IBootUserTransactionPasswordService;

/**
 * 用户交易密码 BootUserTransactionPasswordController
 * @author wang.tongmeng
 */
@RestController
@RequestMapping(value="/boot/user/transactionPassword")
public class BootUserTransactionPasswordController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户交易密码Service
	@Autowired
	private IBootUserTransactionPasswordService userTransactionPasswordService;

	/**
	 * 分页用户交易密码
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserTransactionPasswordListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserTransactionPasswordListByPage(
		@RequestBody UserTransactionPasswordRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询用户交易密码列表】(BootUserTransactionPasswordController-selectUserTransactionPasswordListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserTransactionPassword userTransactionPassword = new UserTransactionPassword();
		userTransactionPassword.setPassword(req.getPassword());
		userTransactionPassword.setUserId(req.getUserId());
		userTransactionPassword.setStatus(req.getStatus());
		Page<UserTransactionPassword> page = new Page<UserTransactionPassword>(pageNum, pageSize);
		List<UserTransactionPassword> list = null;
		try {
			list = userTransactionPasswordService.selectUserTransactionPasswordListByPage(page, userTransactionPassword);
			logger.info("===step2:【分页查询用户交易密码列表】(BootUserTransactionPasswordController-selectUserTransactionPasswordListByPage)-分页查询用户交易密码列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户交易密码列表】(BootUserTransactionPasswordController-selectUserTransactionPasswordListByPage)-分页查询用户交易密码列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse listPageResponse = new BootRestMapResponse();
		listPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		listPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		listPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		listPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		listPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询用户交易密码列表】(BootUserTransactionPasswordController-selectUserTransactionPasswordListByPage)-返回信息, couponListPageResponse:{}", listPageResponse);
		return listPageResponse;
	}

	/**
	 * 查询用户交易密码列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserTransactionPasswordList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserTransactionPasswordList(
		@RequestBody UserTransactionPasswordRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询用户交易密码列表】(BootUserTransactionPasswordController-selectCouponList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		UserTransactionPassword userTransactionPassword = new UserTransactionPassword();
		userTransactionPassword.setPassword(req.getPassword());
		userTransactionPassword.setUserId(req.getUserId());
		userTransactionPassword.setStatus(req.getStatus());
		List<UserTransactionPassword> list = null;
		try {
			list = userTransactionPasswordService.selectUserTransactionPasswordList(userTransactionPassword);
			logger.info("===step2:【分页查询用户交易密码列表】(BootUserTransactionPasswordController-selectCouponList)-查询用户交易密码列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户交易密码列表】(BootUserTransactionPasswordController-selectCouponList)-查询用户交易密码列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse couponListResponse = new BootRestMapResponse();
		couponListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询用户交易密码列表】(BootUserTransactionPasswordController-selectCouponList)-返回信息, couponListResponse:{}", couponListResponse);
		return couponListResponse;
	}

	/**
	 * 据id查询用户交易密码
	 * @param userTransactionPasswordId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserTransactionPasswordById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserTransactionPasswordById(
		@PathVariable(value="id",required=false) Integer userTransactionPasswordId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据id查询用户交易密码】(selectUserTransactionPasswordById-selectUserTransactionPasswordById)-传入参数, userTransactionPasswordId:{}", userTransactionPasswordId);

		if(userTransactionPasswordId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userTransactionPasswordId为空");
		}

		UserTransactionPassword userTransactionPassword = null;
		try {
			userTransactionPassword = userTransactionPasswordService.selectUserTransactionPasswordById(userTransactionPasswordId);
			logger.info("===step2:【据id查询用户交易密码】(BootUserTransactionPasswordController-selectUserTransactionPasswordById)-根据id查询用户交易密码, userTransactionPassword:{}", userTransactionPassword);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据id查询用户交易密码】(BootUserTransactionPasswordController-selectUserTransactionPasswordById)-根据id查询用户交易密码-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userTransactionPassword == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse userTransactionPasswordResponse = new BootRestMapResponse();
		userTransactionPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userTransactionPassword));
		logger.info("===step3:【据id查询用户交易密码】(BootUserTransactionPasswordController-selectUserTransactionPasswordById)-返回信息, userTransactionPasswordResponse:{}", userTransactionPasswordResponse);
		return userTransactionPasswordResponse;
	}

	/**
	 * 据userId查询用户交易密码
	 * @param userId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserTransactionPasswordByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserTransactionPasswordByUserId(
		@PathVariable(value="userId",required=false) Integer userId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据userId查询用户交易密码】(selectUserTransactionPasswordById-selectUserTransactionPasswordByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}

		UserTransactionPassword userTransactionPassword = null;
		try {
			userTransactionPassword = userTransactionPasswordService.selectUserTransactionPasswordByUserId(userId);
			logger.info("===step2:【据userId查询用户交易密码】(BootUserTransactionPasswordController-selectUserTransactionPasswordByUserId)-根据userId查询用户交易密码, userTransactionPassword:{}", userTransactionPassword);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据userId查询用户交易密码】(BootUserTransactionPasswordController-selectUserTransactionPasswordByUserId)-根据userId查询用户交易密码-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userTransactionPassword == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse userTransactionPasswordResponse = new BootRestMapResponse();
		userTransactionPasswordResponse.putAll((JSONObject) JSONObject.toJSON(userTransactionPassword));
		logger.info("===step3:【据userId查询用户交易密码】(BootUserTransactionPasswordController-selectUserTransactionPasswordByUserId)-返回信息, userTransactionPasswordResponse:{}", userTransactionPasswordResponse);
		return userTransactionPasswordResponse;
	}

	/**
	 * 添加用户交易密码
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertUserTransactionPassword",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertUserTransactionPassword(
		@RequestBody UserTransactionPasswordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加用户交易密码】(BootUserTransactionPasswordController-insertUserTransactionPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

	    Integer userId = req.getUserId();
		String password = req.getPassword();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userId为空");
		} else if(StringUtils.isBlank(password)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "password为空");
		}

		UserTransactionPassword userTransactionPassword = null;
		try {
			userTransactionPassword = userTransactionPasswordService.selectUserTransactionPasswordByUserId(userId);
			logger.info("===step2:【据userId查询用户交易密码】(BootUserTransactionPasswordController-selectUserTransactionPasswordByUserId)-根据userId查询用户交易密码, userTransactionPassword:{}", userTransactionPassword);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据userId查询用户交易密码】(BootUserTransactionPasswordController-selectUserTransactionPasswordByUserId)-根据userId查询用户交易密码-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userTransactionPassword != null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_EXIST, BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_EXIST_MSG);
		}

		userTransactionPassword = new UserTransactionPassword();
		userTransactionPassword.setUserId(userId);
		userTransactionPassword.setPassword(password);
		try {
			int i = userTransactionPasswordService.insertUserTransactionPassword(userTransactionPassword);
			logger.info("===step2:【添加用户交易密码】(BootUserTransactionPasswordController-insertUserTransactionPassword)-插入用户交易密码, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加用户交易密码】(BootUserTransactionPasswordController-insertUserTransactionPassword)-插入用户交易密码-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse userTransactionPasswordResponse = new BootRestMapResponse();
		logger.info("===step5:【添加用户交易密码】(BootUserTransactionPasswordController-insertUserTransactionPassword)-返回信息, userTransactionPasswordResponse:{}", userTransactionPasswordResponse);
		return userTransactionPasswordResponse;
	}

	/**
	 * 修改用户交易密码
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyUserTransactionPassword",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyUserTransactionPassword(
		@RequestBody UserTransactionPasswordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改用户交易密码】(BootUserTransactionPasswordController-modifyUserTransactionPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userTransactionPasswordId = req.getUserTransactionPasswordId();
		Integer userId = req.getUserId();
		String password = req.getPassword();
		if(userTransactionPasswordId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userTransactionPasswordId为空");
		} else if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userId为空");
		} else if(StringUtils.isBlank(password)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "password为空");
		}

		UserTransactionPassword userTransactionPassword = null;
		try {
			userTransactionPassword = userTransactionPasswordService.selectUserTransactionPasswordById(req.getUserTransactionPasswordId());
			logger.info("===step2:【修改用户交易密码】(BootUserTransactionPasswordController-modifyUserTransactionPassword)-根据userTransactionPasswordId查询用户交易密码, userTransactionPassword:{}", userTransactionPassword);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改用户交易密码】(BootUserTransactionPasswordController-modifyUserTransactionPassword)-根据userTransactionPasswordId查询用户交易密码-异常, Exception = {}, message = {}",e,e.getMessage());
	        	String errorCode = e.getErrorCode();
	        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
	        	}
		}
		if(userTransactionPassword == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_TRANSACTION_PASSWORD_ENTITY_NOTEXIST_MSG);
		}

		userTransactionPassword.setUserId(userId);
		userTransactionPassword.setPassword(password);
		try {
			int i = userTransactionPasswordService.modifyUserTransactionPassword(userTransactionPassword);
			logger.info("===step3:【修改用户交易密码】(BootUserTransactionPasswordController-modifyUserTransactionPassword)-修改用户交易密码, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改用户交易密码】(BootUserTransactionPasswordController-modifyUserTransactionPassword)-修改用户交易密码-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse userTransactionPasswordResponse = new BootRestMapResponse();
		logger.info("===step4:【修改用户交易密码】(BootUserTransactionPasswordController-modifyUserTransactionPassword)-返回信息, userTransactionPasswordResponse:{}", userTransactionPasswordResponse);
		return userTransactionPasswordResponse;
	}

	/**
	 * 重设用户交易密码
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/resetUserTransactionPassword",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse resetUserTransactionPassword(
		@RequestBody UserTransactionPasswordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【重设用户交易密码】(BootUserTransactionPasswordController-resetUserTransactionPassword)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String password = req.getPassword();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userId为空");
		} else if(StringUtils.isBlank(password)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "password为空");
		}

		try {
			int i = userTransactionPasswordService.resetUserTransactionPassword(userId, password);
			logger.info("===step2:【重设用户交易密码】(BootUserTransactionPasswordController-resetUserTransactionPassword)-重设用户交易密码, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【重设用户交易密码】(BootUserTransactionPasswordController-resetUserTransactionPassword)-重设用户交易密码-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse userTransactionPasswordResponse = new BootRestMapResponse();
		logger.info("===step3:【重设用户交易密码】(BootUserTransactionPasswordController-resetUserTransactionPassword)-返回信息, userTransactionPasswordResponse:{}", userTransactionPasswordResponse);
		return userTransactionPasswordResponse;
	}

}