package com.ochain.provider.wheel.controllers;

import java.math.BigDecimal;
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
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.constants.wheel.WheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.param.UserParam;
import com.ochain.provider.wheel.po.Account;
import com.ochain.provider.wheel.po.AccountCalculate;
import com.ochain.provider.wheel.po.UserInfo;
import com.ochain.provider.wheel.rest.request.user.UserAccountListRequest;
import com.ochain.provider.wheel.rest.request.user.UserRequest;
import com.ochain.provider.wheel.service.IBootAccountCalculateService;
import com.ochain.provider.wheel.service.IBootAccountService;
import com.ochain.provider.wheel.service.IBootUserService;
import com.ochain.provider.wheel.vo.user.UserAccountCalcluateVo;
import com.ochain.provider.wheel.vo.user.UserAccountVo;
import com.ochain.provider.wheel.vo.user.UserCalcluateListVo;
import com.ochain.provider.wheel.vo.user.UserVo;

/**
 * 用户信息 BootUserController
 * @author wei.yong
 */
@RestController
@RequestMapping(value="/boot/user")
public class BootUserController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户信息 Service
	@Autowired
	private IBootUserService userService;

	//账户 Service
	@Autowired
	private IBootAccountService accountService;

	//账户算力 Service
	@Autowired
	private IBootAccountCalculateService accountCalculateService;

	/**
	 * 分页查询用户信息列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserListByPage(
		@RequestBody UserRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询用户信息列表】(BootUserController-selectUserListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		String userName = req.getUserName();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserInfo userInfo = new UserInfo();
		userInfo.setUserAccount(userAccount);
		userInfo.setUserName(userName);

		Page<UserInfo> page = new Page<UserInfo>(pageNum, pageSize);
		List<UserInfo> list = null;
		try {
			list = userService.selectUserInfoListByPage(page, userInfo);
			logger.info("===step2:【分页查询用户信息列表】(BootUserController-selectUserListByPage)-分页查询用户信息列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户信息列表】(BootUserController-selectUserListByPage)-分页查询用户信息列表-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse userListPageResponse = new BootRestMapResponse();
		userListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		userListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		userListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		userListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		userListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询用户信息列表】(BootUserController-selectUserListByPage)-返回信息, userPageResponse:{}", userListPageResponse);
		return userListPageResponse;
	}

	/**
	 * 查询用户信息列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserList(
		@RequestBody UserRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询用户信息列表】(BootUserController-selectUserList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		String userName = req.getUserName();

		UserInfo userInfo = new UserInfo();
		userInfo.setUserAccount(userAccount);
		userInfo.setUserName(userName);

		List<UserInfo> list = null;
		try {
			list = userService.selectUserInfoList(userInfo);
			logger.info("===step2:【分页查询用户信息列表】(BootUserController-selectUserList)-查询用户信息列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户信息列表】(BootUserController-selectUserList)-查询用户信息列表-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse userListResponse = new BootRestMapResponse();
		userListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询用户信息列表】(BootUserController-selectUserList)-返回信息, userListResponse:{}", userListResponse);
		return userListResponse;
	}


	/**
	 * 根据status查询用户信息列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserListByStatus",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserByStatus(
		@RequestBody UserRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据status查询用户信息列表】(BootUserController-selectUserListByStatus)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer status = req.getStatus();
		if(status == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "status为空");
		}

		List<UserInfo> list = null;
		try {
			list = userService.selectUserInfoListByStatus(status);
			logger.info("===step2:【根据status查询用户信息列表】(BootUserController-selectUserListByStatus)-根据status查询用户信息列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据status查询用户信息列表】(BootUserController-selectUserListByStatus)-根据status查询用户信息列表-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse userListResponse = new BootRestMapResponse();
		userListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【根据status查询用户信息列表】(BootUserController-selectUserListByStatus)-返回信息, userListResponse:{}", userListResponse);
		return userListResponse;
	}


	/**
	 * 根据id查询用户信息
	 * @param userId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserById(
		@PathVariable(value="id",required=false) Integer userId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询用户信息】(BootUserController-selectUserById)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}

		UserInfo userInfo = null;
		try {
			userInfo = userService.selectUserInfoById(userId);
			logger.info("===step2:【根据id查询用户信息】(BootUserController-selectUserById)-根据id查询用户信息, userInfo:{}", userInfo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询用户信息】(BootUserController-selectUserById)-根据id查询用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userInfo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST_MSG);
		}

		Account account = null;
		try {
			account = accountService.selectAccountByUserId(userId);
			logger.info("===step3:【根据id查询用户信息】(BootUserController-selectUserById)-根据userId查询账户, account:{}", account);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【根据id查询用户信息】(BootUserController-selectUserById)-根据userId查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}

		AccountCalculate accountCalculate = null;
		try {
			accountCalculate = accountCalculateService.selectAccountCalculateByUserId(userId);
			logger.info("===step4:【根据id查询用户信息】(BootUserController-selectUserById)-根据userId查询账户算力, accountCalculate:{}", accountCalculate);
		} catch (BootServiceException e) {
			logger.error("===step4.1:【根据id查询用户信息】(BootUserController-selectUserById)-根据userId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}

		BootRestMapResponse userResponse = new BootRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
		if(account != null) {
			userResponse.putAll((JSONObject) JSONObject.toJSON(account));
		}
		if(accountCalculate != null) {
			userResponse.putAll((JSONObject) JSONObject.toJSON(accountCalculate));
		}
		logger.info("===step7:【根据id查询用户信息】(BootUserController-selectUserById)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 根据gId查询用户信息
	 * @param gId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserByGId/{gId}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserByGId(
		@PathVariable(value="gId",required=false) String gId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据gId查询用户信息】(BootUserController-selectUserByGId)-传入参数, gId:{}", gId);

		if(StringUtils.isBlank(gId)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "gId为空");
		}

		UserInfo userInfo = null;
		try {
			userInfo = userService.selectUserInfoByGId(gId);
			logger.info("===step2:【根据gId查询用户信息】(BootUserController-selectUserByGId)-根据gId查询用户信息, userInfo:{}", userInfo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据gId查询用户信息】(BootUserController-selectUserByGId)-根据gId查询用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userInfo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST_MSG);
		}
		Integer userId = userInfo.getUserId();

		Account account = null;
		try {
			account = accountService.selectAccountByUserId(userId);
			logger.info("===step3:【根据gId查询用户信息】(BootUserController-selectUserByGId)-根据userId查询账户, account:{}", account);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【根据gId查询用户信息】(BootUserController-selectUserByGId)-根据userId查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}

		AccountCalculate accountCalculate = null;
		try {
			accountCalculate = accountCalculateService.selectAccountCalculateByUserId(userId);
			logger.info("===step4:【根据gId查询用户信息】(BootUserController-selectUserByGId)-根据userId查询账户算力, accountCalculate:{}", accountCalculate);
		} catch (BootServiceException e) {
			logger.error("===step4.1:【根据gId查询用户信息】(BootUserController-selectUserByGId)-根据userId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}

		BootRestMapResponse userResponse = new BootRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
		if(account != null) {
			userResponse.putAll((JSONObject) JSONObject.toJSON(account));
		}
		if(accountCalculate != null) {
			userResponse.putAll((JSONObject) JSONObject.toJSON(accountCalculate));
		}
		logger.info("===step5:【根据gId查询用户信息】(BootUserController-selectUserByGId)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 根据userAccount查询用户信息
	 * @param userAccount
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserByUserAccount/{userAccount}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserByUserAccount(
		@PathVariable(value="userAccount",required=false) String userAccount,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userAccount查询用户信息】(BootUserController-selectUserByUserAccount)-传入参数, userAccount:{}", userAccount);

		if(StringUtils.isBlank(userAccount)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userAccount为空");
		}

		UserInfo userInfo = null;
		try {
			userInfo = userService.selectUserInfoByUserAccount(userAccount);
			logger.info("===step2:【根据userAccount查询用户信息】(BootUserController-selectUserByUserAccount)-根据userAccount查询用户信息, userInfo:{}", userInfo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userAccount查询用户信息】(BootUserController-selectUserByUserAccount)-根据userAccount查询用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userInfo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse userResponse = new BootRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
		logger.info("===step3:【根据userAccount查询用户信息】(BootUserController-selectUserByUserAccount)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 添加用户信息
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertUser",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertUser(
		@RequestBody UserRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加用户信息】(BootUserController-insertUser)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		BootRestMapResponse userResponse = new BootRestMapResponse();

		String gId = req.getgId();
		String userAccount = req.getUserAccount();
		String nickName = req.getNickName();
		String cityCode = req.getCityCode();
		String cityName = req.getCityName();
		Integer status = req.getStatus();
		String headImage = req.getHeadImage();
		Integer sourceType = req.getSourceType();
		if(StringUtils.isBlank(gId)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "gId为空");
		} else if(StringUtils.isBlank(userAccount)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userAccount为空");
		}

		UserInfo userInfo = null;
		try {
			userInfo = userService.selectUserInfoByGId(gId);
			logger.info("===step2:【添加用户信息】(BootUserController-insertUser)-根据gId查询用户信息, userInfo:{}", userInfo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加用户信息】(BootUserController-insertUser)-根据gId查询用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userInfo != null) {
			userInfo.setUserAccount(userAccount);
			userInfo.setNickName(nickName);
			userInfo.setCityCode(cityCode);
			userInfo.setCityName(cityName);
			userInfo.setStatus(status);
			userInfo.setHeadImage(headImage);
			Integer loginCount = userInfo.getLoginCount();
			//登录过来的
			if(WheelConstants.USER_ADD_SOURCE_TYPE_LOGIN.equals(sourceType)) {
				if(loginCount != null) {
					userInfo.setLoginCount(loginCount+1);
				}
			}
			try {
				int i = userService.modifyUserInfo(userInfo);
				logger.info("===step3:【添加用户信息】(BootUserController-insertUser)-修改用户信息, i:{}", i);
			} catch (BootServiceException e) {
				logger.error("===step3.1:【添加用户信息】(BootUserController-insertUser)-修改用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
	        	String errorCode = e.getErrorCode();
	        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
	        	}
	        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
	        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
	        	}
			}
			Integer userId = userInfo.getUserId();

			Account account = null;
			try {
				account = accountService.selectAccountByUserId(userId);
				logger.info("===step4:【添加用户信息】(BootUserController-insertUser)-根据userId查询账户, account:{}", account);
			} catch (BootServiceException e) {
				logger.error("===step4.1:【添加用户信息】(BootUserController-insertUser)-根据userId查询账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			}
			if(account == null) {
				int i = 0;
				account = new Account();
				account.setDiamond(new BigDecimal("0"));
				account.setUserId(userId);
				try {
					i = accountService.insertAccount(account);
					logger.info("===step5:【添加用户信息】(BootUserController-insertUser)-插入账户, i:{}", i);
				} catch (BootServiceException e) {
					logger.error("===step5.1:【添加用户信息】(BootUserController-insertUser)-插入账户-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				}
			}

			AccountCalculate accountCalculate = null;
			try {
				accountCalculate = accountCalculateService.selectAccountCalculateByUserId(userId);
				logger.info("===step6:【添加用户信息】(BootUserController-insertUser)-根据userId查询账户算力, accountCalculate:{}", accountCalculate);
			} catch (BootServiceException e) {
				logger.error("===step6.1:【添加用户信息】(BootUserController-insertUser)-根据userId查询账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			}
			if(accountCalculate == null) {
				accountCalculate = new AccountCalculate();
				accountCalculate.setUserId(userId);
				accountCalculate.setCalculate(0);
				accountCalculate.setCivilizeCalculate(0);
				int i = 0;
				accountCalculate.setTaskCalculate(0);
				try {
					i = accountCalculateService.insertAccountCalculate(accountCalculate);
					logger.info("===step7:【添加用户信息】(BootUserController-insertUser)-插入账户算力, i:{}", i);
				} catch (BootServiceException e) {
					logger.error("===step7.1:【添加用户信息】(BootUserController-insertUser)-插入账户算力-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				}
			}

			userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
			if(account != null) {
				userResponse.putAll((JSONObject) JSONObject.toJSON(account));
			}
			if(accountCalculate != null) {
				userResponse.putAll((JSONObject) JSONObject.toJSON(accountCalculate));
			}
			logger.info("===step8:【添加用户信息】(BootUserController-insertUser)-返回信息, userResponse:{}", userResponse);
			return userResponse;
		}

		userInfo = new UserInfo();
		userInfo.setgId(gId);
		userInfo.setUserAccount(userAccount);
		userInfo.setNickName(nickName);
		userInfo.setCityCode(cityCode);
		userInfo.setCityName(cityName);
		userInfo.setHeadImage(headImage);
		//登录过来的
		if(WheelConstants.USER_ADD_SOURCE_TYPE_LOGIN.equals(sourceType)) {
			userInfo.setLoginCount(1);
		}
		UserVo userVo = null;
		try {
			userVo = userService.insertUser(userInfo);
			logger.info("===step7:【添加用户信息】(BootUserController-insertUser)-插入用户信息, userVo:{}",userVo);
		} catch (BootServiceException e) {
			logger.error("===step7.1:【添加用户信息】(BootUserController-insertUser)-插入用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		userResponse.putAll((JSONObject) JSONObject.toJSON(userVo));
		logger.info("===step8:【添加用户信息】(BootUserController-insertUser)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 修改用户信息
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyUser",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyUser(
		@RequestBody UserRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改用户信息】(BootUserController-modifyUser)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String userAccount = req.getUserAccount();
		String nickName = req.getNickName();
		String cityCode = req.getCityCode();
		String cityName = req.getCityName();
		String headImage = req.getHeadImage();
		Integer status = req.getStatus();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(StringUtils.isBlank(userAccount)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userAccount为空");
		}

		UserInfo userInfo = null;
		try {
			userInfo = userService.selectUserInfoById(userId);
			logger.info("===step2:【修改用户信息】(BootUserController-modifyUser)-根据userId查询用户信息, userInfo:{}", userInfo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改用户信息】(BootUserController-modifyUser)-根据userId查询用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userInfo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST_MSG);
		}

		userInfo.setUserAccount(userAccount);
		userInfo.setNickName(nickName);
		userInfo.setCityCode(cityCode);
		userInfo.setCityName(cityName);
		userInfo.setHeadImage(headImage);
		userInfo.setStatus(status);
		try {
			int i = userService.modifyUserInfo(userInfo);
			logger.info("===step3:【修改用户信息】(BootUserController-modifyUser)-修改用户信息, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改用户信息】(BootUserController-modifyUser)-修改用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse userResponse = new BootRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
		logger.info("===step4:【修改用户信息】(BootUserController-modifyUser)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 修改用户状态
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyUserStatus",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyUserStatus(
		@RequestBody UserRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改用户状态】(BootUserController-modifyUserStatus)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String gId = req.getgId();
		Integer status = req.getStatus();
		if(StringUtils.isBlank(gId)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "gId为空");
		} else if(status == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "status为空");
		}

		UserInfo userInfo = null;
		try {
			userInfo = userService.selectUserInfoByGId(gId);
			logger.info("===step2:【修改用户状态】(BootUserController-modifyUserStatus)-根据gId查询用户信息, userInfo:{}", userInfo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改用户状态】(BootUserController-modifyUserStatus)-根据gId查询用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userInfo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST_MSG);
		}

		userInfo.setStatus(status);
		try {
			int i = userService.modifyUserInfo(userInfo);
			logger.info("===step3:【修改用户状态】(BootUserController-modifyUserStatus)-修改用户状态, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改用户状态】(BootUserController-modifyUserStatus)-修改用户状态-异常, Exception = {}, message = {}", e, e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse userResponse = new BootRestMapResponse();
		userResponse.putAll((JSONObject) JSONObject.toJSON(userInfo));
		logger.info("===step4:【修改用户状态】(BootUserController-modifyUserStatus)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}

	/**
	 * 根据id删除用户信息
	 * @param userId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/deleteUserById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse deleteUserById(
		@PathVariable(value="id",required=false) Integer userId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id删除用户信息】(BootUserController-deleteUserById)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}

		UserInfo userInfo = null;
		try {
			userInfo = userService.selectUserInfoById(userId);
			logger.info("===step2:【根据id删除用户信息】(BootUserController-deleteUserById)-根据userId查询用户信息, userInfo:{}", userInfo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id删除用户信息】(BootUserController-deleteUserById)-根据userCode查询用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userInfo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_ENTITY_NOTEXIST_MSG);
		}
		userInfo.setIsDelete(SqlWheelConstants.SQL_USER_IS_DELETE_YES);
		try {
			int i = userService.modifyUserInfo(userInfo);
			logger.info("===step3:【根据id删除用户信息】(BootUserController-deleteUserById)-修改用户信息, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【根据id删除用户信息】(BootUserController-deleteUserById)-修改用户信息-异常, Exception = {}, message = {}", e, e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse userResponse = new BootRestMapResponse();
		logger.info("===step5:【根据id删除用户信息】(BootUserController-deleteUserById)-返回信息, userResponse:{}", userResponse);
		return userResponse;
	}


	/**
	 * 分页查询用户账户列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserAccountListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserAccountListByPage(
		@RequestBody UserAccountListRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询用户账户列表】(BootUserController-selectUserAccountListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		String startTine = req.getStartTime();
		String endTime = req.getEndTime();
		Integer accountLogType = req.getAccountLogType();
		String userName = req.getUserName();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserInfo userInfo = new UserInfo();
		userInfo.setUserAccount(userAccount);
		userInfo.setUserName(userName);

		UserParam param = new UserParam();
		param.setUserAccount(userAccount);
		if(!StringUtils.isBlank(startTine) && !StringUtils.isBlank(endTime)) {
			param.setTimeStartStr(startTine+DateFormatConstants.TIME_START);
			param.setTimeEndStr(endTime+DateFormatConstants.TIME_END);
		}
		param.setAccountLogType(accountLogType);
		param.setOrderByClause(" t3.id desc ");
		Page<UserInfo> page = new Page<UserInfo>(pageNum, pageSize);
		List<UserAccountVo> list = null;
		try {
			list = userService.selectUserAccountVoListByPage(page, param);
			logger.info("===step2:【分页查询用户账户列表】(BootUserController-selectUserAccountListByPage)-分页查询用户账户列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户账户列表】(BootUserController-selectUserAccountListByPage)-分页查询用户账户列表-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse userListPageResponse = new BootRestMapResponse();
		userListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		userListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		userListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		userListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		userListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询用户账户列表】(BootUserController-selectUserAccountListByPage)-返回信息, userPageResponse:{}", userListPageResponse);
		return userListPageResponse;
	}

	/**
	 * 分页查询用户账户算力列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserAccountCalcluateListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserAccountCalcluateListByPage(
		@RequestBody UserAccountListRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询用户账户算力列表】(BootUserController-selectUserAccountCalcluateListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		String startTine = req.getStartTime();
		String endTime = req.getEndTime();
		String userName = req.getUserName();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserInfo userInfo = new UserInfo();
		userInfo.setUserAccount(userAccount);
		userInfo.setUserName(userName);

		UserParam param = new UserParam();
		param.setUserAccount(userAccount);
		if(!StringUtils.isBlank(startTine) && !StringUtils.isBlank(endTime)) {
			param.setTimeStartStr(startTine+DateFormatConstants.TIME_START);
			param.setTimeEndStr(endTime+DateFormatConstants.TIME_END);
		}
		param.setOrderByClause(" t3.id desc ");
		Page<UserInfo> page = new Page<UserInfo>(pageNum, pageSize);
		List<UserAccountCalcluateVo> list = null;
		try {
			list = userService.selectUserAccountCalcluateVoListByPage(page, param);
			logger.info("===step2:【分页查询用户账户算力列表】(BootUserController-selectUserAccountCalcluateListByPage)-分页查询用户账户列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户账户算力列表】(BootUserController-selectUserAccountCalcluateListByPage)-分页查询用户账户列表-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse userListPageResponse = new BootRestMapResponse();
		userListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		userListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		userListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		userListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		userListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询用户账户算力列表】(BootUserController-selectUserAccountCalcluateListByPage)-返回信息, userPageResponse:{}", userListPageResponse);
		return userListPageResponse;
	}

	/**
	 * 分页查询用户账户算力总值列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectUserCalcluateListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCalcluateListByPage(
		@RequestBody UserAccountListRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询用户账户算力列表】(BootUserController-selectUserCalcluateListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		String updateTime = req.getUpdateTime();
		String userName = req.getUserName();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		UserInfo userInfo = new UserInfo();
		userInfo.setUserAccount(userAccount);
		userInfo.setUserName(userName);

		UserParam param = new UserParam();
		param.setUserAccount(userAccount);
		if(!StringUtils.isBlank(updateTime)) {
			param.setTimeStartStr(updateTime+DateFormatConstants.TIME_START);
			param.setTimeEndStr(updateTime+DateFormatConstants.TIME_END);
		}
		param.setOrderByClause(" t2.update_time desc ");
		Page<UserInfo> page = new Page<UserInfo>(pageNum, pageSize);
		List<UserCalcluateListVo> list = null;
		try {
			list = userService.selectUserCalcluateListByPage(page, param);
			logger.info("===step2:【分页查询用户账户算力列表】(BootUserController-selectUserCalcluateListByPage)-分页查询用户账户列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户账户算力列表】(BootUserController-selectUserCalcluateListByPage)-分页查询用户账户列表-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse userListPageResponse = new BootRestMapResponse();
		userListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		userListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		userListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		userListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		userListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询用户账户算力列表】(BootUserController-selectUserCalcluateListByPage)-返回信息, userPageResponse:{}", userListPageResponse);
		return userListPageResponse;
	}
}