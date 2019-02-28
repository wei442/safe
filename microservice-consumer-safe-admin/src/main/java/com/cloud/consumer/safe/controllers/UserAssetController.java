package com.ochain.consumer.wheel.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
import com.alibaba.fastjson.TypeReference;
import com.ochain.common.constants.PageConstants;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.RetWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.consumer.wheel.base.BaseRestMapResponse;
import com.ochain.consumer.wheel.rest.request.user.AssetRequest;
import com.ochain.consumer.wheel.service.IAccountCalculateLogService;
import com.ochain.consumer.wheel.service.IAccountLogService;
import com.ochain.consumer.wheel.service.IUserService;
import com.ochain.consumer.wheel.vo.account.AccountCalculateLogVo;
import com.ochain.consumer.wheel.vo.account.AccountLogVo;
import com.ochain.consumer.wheel.vo.user.UserVo;

/**
 * 资产管理 UserAssetController
 * @author wei.yong
 * @ClassName: UserAssetControll
 * @Description:
 * @date 2016年10月12日 下午 14:30:56
 */
@RestController
@RequestMapping("/user/asset")
public class UserAssetController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户 Service
	@Autowired
	private IUserService userService;

	//账户日志 Service
	@Autowired
	private IAccountLogService accountLogService;

	//账户算力日志 Service
	@Autowired
	private IAccountCalculateLogService accountCalculateLogService;

	 /**
     * 5.1.3.1	获取资产信息接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/getAssetInfo",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getAssetInfo(
		@RequestBody AssetRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【获取资产信息接口】(UserAssetController-getAssetInfo)-获取资产信息接口，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

   		Integer userId = this.getTokenUserId();
		if (userId == null) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_ERROR_MSG, this.getRequestParameterEmpty()+".userId.empty", "userId为空");
		}

		//根据userId获得用户信息
		JSONObject jsonUser = userService.getUserById(userId);
		logger.info("===step2:【获取资产信息接口】(UserAssetController-getAssetInfo)-根据userId获取用户信息-返回信息, jsonUser:{}", jsonUser);
		String bootCode = Objects.toString(jsonUser.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		UserVo userVo = JSONObject.toJavaObject(jsonUser, UserVo.class);
		BigDecimal diamond = userVo.getDiamond();
		Integer calculate = userVo.getCalculate();

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("diamond", diamond);
		result.put("calculate", calculate);

		BaseRestMapResponse accountResponse = new BaseRestMapResponse();
		accountResponse.put(RetWheelConstants.RESULT, result);
    	logger.info("===step3:【获取资产信息接口】(UserAssetController-getAssetInfo)-返回信息, accountResponse:{}", accountResponse);
    	return accountResponse;
	}

	/**
     * 4.1.3.2	获取资产能量方块收支记录接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/getDiamondBalanceList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDiamondBalanceList(
		@RequestBody AssetRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【获取资产能量方块收支记录接口】(UserController-UserAssetController)-获取资产能量方块收支记录，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

   		Integer userId = this.getTokenUserId();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		if (userId == null) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_ERROR_MSG, this.getRequestParameterEmpty()+".userId.empty", "userId为空");
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put(PageConstants.PAGE_NUM, pageNum);
		params.put(PageConstants.PAGE_SIZE, pageSize);
		JSONObject jsonAccountLog = accountLogService.getAccountLogListByPage(params);
		logger.info("===step2:【获取资产能量方块收支记录接口】(UserController-UserAssetController)-根据userId和accountLogType获取资产能量方块收支记录-返回信息, jsonAccountLog:{}", jsonAccountLog);
		String bootCode = Objects.toString(jsonAccountLog.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		String dataListStr = JSONObject.toJSONString(jsonAccountLog.getJSONArray(PageConstants.DATA_LIST));
		List<AccountLogVo> accountLogVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<AccountLogVo>>(){});

		BaseRestMapResponse accountLogResponse = new BaseRestMapResponse();
		accountLogResponse.put(RetWheelConstants.RESULT, accountLogVoList);
    	logger.info("===step3:【获取资产能量方块收支记录接口】(UserController-UserAssetController)-返回信息, accountLogResponse:{}", accountLogResponse);
    	return accountLogResponse;
	}

	/**
     * 4.1.3.3	获取资产算力记录接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/getCalculateBalanceList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getCalculateBalanceList(
		@RequestBody AssetRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【获取资产算力记录接口】(UserAssetController-getCalculateBalanceList)-获取资产算力记录接口，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

   		Integer userId = this.getTokenUserId();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		if (userId == null) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_ERROR_MSG, this.getRequestParameterEmpty()+".userId.empty", "userId为空");
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("calculateType", SqlWheelConstants.SQL_ACCOUNT_CALCULATE_LOG_TYPE_TASK);
		params.put(PageConstants.PAGE_NUM, pageNum);
		params.put(PageConstants.PAGE_SIZE, pageSize);
		JSONObject jsonAccountLog = accountCalculateLogService.getAccountCalculateLogListByPage(params);
		logger.info("===step3:【获取资产算力记录接口】(UserAssetController-getCalculateBalanceList)-根据userId和accountLogType获取资产算力记录-返回信息, jsonAccountLog:{}", jsonAccountLog);
		String bootCode = Objects.toString(jsonAccountLog.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		String dataListStr = JSONObject.toJSONString(jsonAccountLog.getJSONArray(PageConstants.DATA_LIST));
		List<AccountCalculateLogVo> accountCalculateLogVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<AccountCalculateLogVo>>(){});

		BaseRestMapResponse accountLogResponse = new BaseRestMapResponse();
		accountLogResponse.put(RetWheelConstants.RESULT, accountCalculateLogVoList);
    	logger.info("===step4:【获取资产算力记录接口】(UserAssetController-getCalculateBalanceList)-返回信息, accountLogResponse:{}", accountLogResponse);
    	return accountLogResponse;
	}

}