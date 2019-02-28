package com.ochain.provider.wheel.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.LocalDate;
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
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.WheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.po.UserSign;
import com.ochain.provider.wheel.rest.request.user.UserSignRequest;
import com.ochain.provider.wheel.service.IBootUserSignService;

/**
 * 用户签到 BootUserSignController
 * @author wei.yong
 */
@RestController
@RequestMapping(value="/boot/user/sign")
public class BootUserSignController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户签到 Service
	@Autowired
	private IBootUserSignService userSignService;

	/**
	 * 根据id查询用户签到
	 * @param userId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserSignById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserSignById(
		@PathVariable(value="id",required=false) Long userSignId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询用户签到】(BootUserSignController-selectUserSignById)-传入参数, userSignId:{}", userSignId);

		if(userSignId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userSignId为空");
		}

		UserSign userSign = null;
		try {
			userSign = userSignService.selectUserSignById(userSignId);
			logger.info("===step2:【根据id查询用户签到】(BootUserSignController-selectUserSignById)-根据id查询用户签到, userSign:{}", userSign);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询用户签到】(BootUserSignController-selectUserSignById)-根据id查询用户签到-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userSign == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_SIGN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_SIGN_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse userSignResponse = new BootRestMapResponse();
		userSignResponse.putAll((JSONObject) JSONObject.toJSON(userSign));
		logger.info("===step3:【根据id查询用户签到】(BootUserSignController-selectUserSignById)-返回信息, userSignResponse:{}", userSignResponse);
		return userSignResponse;
	}

	/**
	 * 根据userId查询用户签到
	 * @param userId
	 * @param signTimeStr
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserSignByUserId/{userId}/{signTimeStr}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserSignByUserId(
		@PathVariable(value="userId",required=false) Integer userId, @PathVariable(value="signTimeStr",required=false) String signTimeStr,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userId查询用户签到】(BootUserSignController-selectUserSignByUserId)-传入参数, userId:{}, signTimeStr:{}", userId, signTimeStr);

		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(StringUtils.isBlank(signTimeStr)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "signTimeStr为空");
		}

		UserSign userSign = null;
		try {
			userSign = userSignService.selectUserSignByUserId(userId, signTimeStr);
			logger.info("===step2:【根据userId查询用户签到】(BootUserSignController-selectUserSignByUserId)-根据userId和signTimeStr查询用户签到, userSign:{}", userSign);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userId查询用户签到】(BootUserSignController-selectUserSignByUserId)-根据userId和signTimeStr查询用户签到-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		int isSign = WheelConstants.USER_SIGN_NO;
		if(userSign != null) {
			isSign = WheelConstants.USER_SIGN_YES;
		}

		BootRestMapResponse userSignResponse = new BootRestMapResponse();
		userSignResponse.put("isSign", isSign);
		logger.info("===step3:【根据userId查询用户签到】(BootUserSignController-selectUserSignByUserId)-返回信息, userSignResponse:{}", userSignResponse);
		return userSignResponse;
	}

	/**
	 * 根据userId和signTimeStr查询用户签到
	 * @param userId
	 * @param signTimeStr
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserSignDaysByUserId/{userId}/{signTimeStr}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserSignDaysByUserId(
		@PathVariable(value="userId",required=false) Integer userId, @PathVariable(value="signTimeStr",required=false) String signTimeStr,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userId和signTimeStr查询用户签到】(BootUserSignController-selectUserSignDaysByUserId)-传入参数, userId:{}, signTimeStr:{}", userId, signTimeStr);

		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(StringUtils.isBlank(signTimeStr)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "signTimeStr为空");
		}

		UserSign userSign = null;
		try {
			userSign = userSignService.selectUserSignByUserId(userId, signTimeStr);
			logger.info("===step2:【根据userId和signTimeStr查询用户签到】(BootUserSignController-selectUserSignDaysByUserId)-根据userId查询用户签到, userSign:{}", userSign);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userId和signTimeStr查询用户签到】(BootUserSignController-selectUserSignDaysByUserId)-根据userId查询用户签到-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userSign == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_SIGN_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_SIGN_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse userSignResponse = new BootRestMapResponse();
		userSignResponse.putAll((JSONObject) JSONObject.toJSON(userSign));
		logger.info("===step3:【根据userId和signTimeStr查询用户签到】(BootUserSignController-selectUserSignDaysByUserId)-返回信息, userSignResponse:{}", userSignResponse);
		return userSignResponse;
	}


	/**
	 * 根据userId、signTimeStart和signTimeEnd查询条数
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectRowsByUserIdSignTime",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectRowsByUserIdSignTime(
		@RequestBody UserSignRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userId、signTimeStart和signTimeEnd查询条数】(BootUserSignController-selectRowsByUserIdSignTime)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		Date signTimeStart = req.getSignTimeStart();
		Date signTimeEnd = req.getSignTimeEnd();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}

		long rows = 0;
		try {
			rows = userSignService.selectRowsByUserIdSignTime(userId, signTimeStart, signTimeEnd);
			logger.info("===step2:【根据userId、signTimeStart和signTimeEnd查询条数】(BootUserSignController-selectRowsByUserIdSignTime)-根据userId、signTimeStart和signTimeEnd查询条数, rows:{}", rows);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userId、signTimeStart和signTimeEnd查询条数】(BootUserSignController-selectRowsByUserIdSignTime)-根据userId、signTimeStart和signTimeEnd查询条数-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse userSignResponse = new BootRestMapResponse();
		userSignResponse.put("rows", rows);
		logger.info("===step3:【根据userId、signTimeStart和signTimeEnd查询条数】(BootUserSignController-selectRowsByUserIdSignTime)-返回信息, userSignResponse:{}", userSignResponse);
		return userSignResponse;
	}

	/**
	 * 添加用户签到
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertUserSign",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertUserSign(
		@RequestBody UserSignRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加用户签到】(BootUserSignController-insertUserSign)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		BootRestMapResponse userSignResponse = new BootRestMapResponse();

		Integer userId = req.getUserId();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}

		String signTimeStr = new LocalDate().toString();
		UserSign userSign = null;
		try {
			userSign = userSignService.selectUserSignByUserId(userId, signTimeStr);
			logger.info("===step2:【添加用户签到】(BootUserSignController-insertUserSign)-根据userId和signTimeStr查询用户签到信息, userSign:{}", userSign);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加用户签到】(BootUserSignController-insertUserSign)-根据userId和signTimeStr查询用户签到信息-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		int isSign = WheelConstants.USER_SIGN_NO;
		if(userSign != null) {
			isSign = WheelConstants.USER_SIGN_YES;
			userSignResponse.put("isSign", isSign);
			userSignResponse.put("isFirst", WheelConstants.USER_SIGN_FIRST_NO);
			userSignResponse.putAll((JSONObject) JSONObject.toJSON(userSign));
			logger.info("===step3:【添加用户签到】(BootUserSignController-insertUserSign)-返回信息, userSignResponse:{}", userSignResponse);
			return userSignResponse;
		}

		userSign = new UserSign();
		userSign.setUserId(userId);
		try {
			int i = userSignService.insertUserSign(userSign);
			logger.info("===step4:【添加用户签到】(BootUserSignController-insertUserSign)-插入用户签到, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step4.1:【添加用户签到】(BootUserSignController-insertUserSign)-插入用户签到-异常, Exception = {}, message = {}", e, e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		userSignResponse.put("isSign", WheelConstants.USER_SIGN_YES);
		userSignResponse.put("isFirst", WheelConstants.USER_SIGN_FIRST_YES);
		userSignResponse.putAll((JSONObject) JSONObject.toJSON(userSign));
		logger.info("===step5:【添加用户签到】(BootUserSignController-insertUserSign)-返回信息, userSignResponse:{}", userSignResponse);
		return userSignResponse;
	}

}