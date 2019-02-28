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
import com.ochain.provider.wheel.po.UserCoinAddr;
import com.ochain.provider.wheel.rest.request.baseUser.UserCoinAddrRequest;
import com.ochain.provider.wheel.service.IBootUserCoinAddrService;

/**
 * 用户货币地址 BootUserCoinAddrController
 * @author wang.tongmeng
 */
@RestController
@RequestMapping(value="/boot/user/coinAddr")
public class BootUserCoinAddrController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户货币地址Service
	@Autowired
	private IBootUserCoinAddrService userCoinAddrService;

	/**
	 * 分页用户货币地址
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserCoinAddrListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCoinAddrListByPage(
		@RequestBody UserCoinAddrRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询用户货币地址列表】(BootUserCoinAddrController-selectUserCoinAddrListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserCoinAddr userCoinAddr = new UserCoinAddr();
		userCoinAddr.setCoinCode(req.getCoinCode());
		userCoinAddr.setCoinName(req.getCoinName());
		userCoinAddr.setUserId(req.getUserId());
		userCoinAddr.setType(req.getType());
		userCoinAddr.setStatus(req.getStatus());

		Page<UserCoinAddr> page = new Page<UserCoinAddr>(pageNum, pageSize);
		List<UserCoinAddr> list = null;
		try {
			list = userCoinAddrService.selectUserCoinAddrListByPage(page, userCoinAddr);
			logger.info("===step2:【分页查询用户货币地址列表】(BootUserCoinAddrController-selectUserCoinAddrListByPage)-分页查询用户货币地址列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户货币地址列表】(BootUserCoinAddrController-selectUserCoinAddrListByPage)-分页查询用户货币地址列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_COINADDR_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_COINADDR_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse listPageResponse = new BootRestMapResponse();
		listPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		listPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		listPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		listPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		listPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询用户货币地址列表】(BootUserCoinAddrController-selectUserCoinAddrListByPage)-返回信息, couponListPageResponse:{}", listPageResponse);
		return listPageResponse;
	}

	/**
	 * 查询用户货币地址列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserCoinAddrList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCoinAddrList(
		@RequestBody UserCoinAddrRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询用户货币地址列表】(BootUserCoinAddrController-selectCouponList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		UserCoinAddr userCoinAddr = new UserCoinAddr();
		userCoinAddr.setCoinCode(req.getCoinCode());
		userCoinAddr.setCoinName(req.getCoinName());
		userCoinAddr.setUserId(req.getUserId());
		userCoinAddr.setType(req.getType());
		userCoinAddr.setStatus(req.getStatus());
		List<UserCoinAddr> list = null;
		try {
			list = userCoinAddrService.selectUserCoinAddrList(userCoinAddr);
			logger.info("===step2:【分页查询用户货币地址列表】(BootUserCoinAddrController-selectCouponList)-查询用户货币地址列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户货币地址列表】(BootUserCoinAddrController-selectCouponList)-查询用户货币地址列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_COINADDR_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_COINADDR_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse couponListResponse = new BootRestMapResponse();
		couponListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询用户货币地址列表】(BootUserCoinAddrController-selectCouponList)-返回信息, couponListResponse:{}", couponListResponse);
		return couponListResponse;
	}

	/**
	 * 据id查询用户账户地址
	 * @param userCoinAddrId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserCoinAddrById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCoinAddrById(
		@PathVariable(value="id",required=false) Integer userCoinAddrId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据id查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrById)-传入参数, userCoinAddrId:{}", userCoinAddrId);

		if(userCoinAddrId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userCoinAddrId为空");
		}

		UserCoinAddr userCoinAddr = null;
		try {
			userCoinAddr = userCoinAddrService.selectUserCoinAddrById(userCoinAddrId);
			logger.info("===step2:【据id查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrById)-根据userCoinAddrId查询用户账户地址, userCoinAddr:{}", userCoinAddr);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据id查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrById)-根据userCoinAddrId查询用户账户地址-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userCoinAddr == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_COINADDR_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_COINADDR_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(userCoinAddr));
		logger.info("===step3:【据id查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrById)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 根据coinCode查询用户账户地址
	 * @param coinCode
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserCoinAddrByCoinCode/{code}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCoinAddrByCoinCode(
		@PathVariable(value="code",required=false) String coinCode,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据coinCode查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrByCoinCode)-传入参数, coinCode:{}", coinCode);

		if(StringUtils.isBlank(coinCode)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "coinCode为空");
		}

		UserCoinAddr userCoinAddr = null;
		try {
			userCoinAddr = userCoinAddrService.selectUserCoinAddrByCoinCode(coinCode);
			logger.info("===step2:【据coinCode查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrByCoinCode)-根据coinCode查询用户账户地址, userCoinAddr:{}", userCoinAddr);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据coinCode查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrByCoinCode)-根据coinCode查询用户账户地址-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userCoinAddr == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_COINADDR_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_COINADDR_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(userCoinAddr));
		logger.info("===step3:【据coinCode查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrByCoinCode)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 根据publicKey查询用户账户地址
	 * @param publicKey
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserCoinAddrByPublicKey/{publicKey}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCoinAddrByPublicKey(
		@PathVariable(value="publicKey",required=false) String publicKey,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据publicKey查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrByPublicKey)-传入参数, publicKey:{}", publicKey);

		if(StringUtils.isBlank(publicKey)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "publicKey为空");
		}

		UserCoinAddr userCoinAddr = null;
		try {
			userCoinAddr = userCoinAddrService.selectUserCoinAddrByPublicKey(publicKey);
			logger.info("===step2:【据publicKey查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrByPublicKey)-根据publicKey查询用户账户地址, userCoinAddr:{}", userCoinAddr);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据publicKey查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrByPublicKey)-根据publicKey查询用户账户地址-异常, Exception = {}, message = {}",e,e.getMessage());
			String errorCode = e.getErrorCode();
			if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
			}
			if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
				return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
			}
		}
		if(userCoinAddr == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_COINADDR_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_COINADDR_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(userCoinAddr));
		logger.info("===step3:【据publicKey查询用户账户地址】(BootUserCoinAddrController-selectUserCoinAddrByPublicKey)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 添加用户货币地址
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertUserCoinAddr",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertUserCoinAddr(
		@RequestBody UserCoinAddrRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加用户货币地址】(BootUserCoinAddrController-insertUserCoinAddr)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
	    String coinCode = req.getCoinCode();
		String coinName = req.getCoinName();
		String privateKey = req.getPrivateKey();
		String publicKey = req.getPublicKey();
		Integer type = req.getType();
		Integer status = req.getStatus();
		if(StringUtils.isBlank(coinCode)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "coinCode为空");
		} else if(StringUtils.isBlank(coinName)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "coinName为空");
		} else if(StringUtils.isBlank(privateKey)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "privateKey为空");
		} else if(StringUtils.isBlank(publicKey)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "publicKey为空");
		} else if(type == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "type为空");
		}

		UserCoinAddr userCoinAddr = new UserCoinAddr();
		userCoinAddr.setCoinCode(coinCode);
		userCoinAddr.setCoinName(coinName);
		userCoinAddr.setPrivateKey(privateKey);
		userCoinAddr.setPublicKey(publicKey);
		userCoinAddr.setType(type);
		userCoinAddr.setStatus(status);
		try {
			int i = userCoinAddrService.insertUserCoinAddr(userCoinAddr);
			logger.info("===step2:【添加用户货币地址】(BootUserCoinAddrController-insertUserCoinAddr)-插入用户货币地址, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加用户货币地址】(BootUserCoinAddrController-insertUserCoinAddr)-插入用户货币地址-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step5:【添加用户货币地址】(BootUserCoinAddrController-insertUserCoinAddr)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 修改用户货币地址
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyUserCoinAddr",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyUserCoinAddr(
		@RequestBody UserCoinAddrRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改用户货币地址】(BootUserCoinAddrController-modifyUserCoinAddr)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userCoinAddrId = req.getUserCoinAddrId();
	    Integer userId = req.getUserId();
	    String coinCode = req.getCoinCode();
		String coinName = req.getCoinName();
		String privateKey = req.getPrivateKey();
		String publicKey = req.getPublicKey();
		Integer type = req.getType();
		Integer status = req.getStatus();
		if(userCoinAddrId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userCoinAddrId为空");
		}

		UserCoinAddr userCoinAddr = null;
		try {
			userCoinAddr = userCoinAddrService.selectUserCoinAddrById(req.getUserCoinAddrId());
			logger.info("===step2:【修改用户货币地址】(BootUserCoinAddrController-modifyUserCoinAddr)-根据userCoinAddrId查询用户货币地址, userCoinAddr:{}", userCoinAddr);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改用户货币地址】(BootUserCoinAddrController-modifyUserCoinAddr)-根据userCoinAddrId查询用户货币地址-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(userCoinAddr == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_COINADDR_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_COINADDR_ENTITY_NOTEXIST_MSG);
		}

		userCoinAddr.setUserId(userId);
		userCoinAddr.setCoinCode(coinCode);
		userCoinAddr.setCoinName(coinName);
		userCoinAddr.setPrivateKey(privateKey);
		userCoinAddr.setPublicKey(publicKey);
		userCoinAddr.setType(type);
		userCoinAddr.setStatus(status);
		try {
			int i = userCoinAddrService.modifyUserCoinAddr(userCoinAddr);
			logger.info("===step3:【修改用户货币地址】(BootUserCoinAddrController-modifyUserCoinAddr)-修改用户货币地址, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改用户货币地址】(BootUserCoinAddrController-modifyUserCoinAddr)-修改用户货币地址-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step4:【修改用户货币地址】(BootUserCoinAddrController-modifyUserCoinAddr)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}


}