package com.ochain.provider.wheel.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
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
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.po.CalculateConfig;
import com.ochain.provider.wheel.po.UserCalculateConfig;
import com.ochain.provider.wheel.rest.request.user.UserCalculateConfigRequest;
import com.ochain.provider.wheel.service.IBootCalculateConfigService;
import com.ochain.provider.wheel.service.IBootUserCalculateConfigService;
import com.ochain.provider.wheel.vo.calculate.CalculateTaskVo;
import com.ochain.provider.wheel.vo.user.UserCalculateConfigVo;

/**
 * 用户算力配置 BootUserCalculateConfigController
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/user/calculateConfig")
public class BootUserCalculateConfigController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户算力配置 Service
	@Autowired
	private IBootUserCalculateConfigService userCalculateConfigService;

	//算力配置Service
	@Autowired
	private IBootCalculateConfigService calculateConfigService;

	/**
	 * 分页查询用户算力配置列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectUserCalculateConfigListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCalculateConfigListByPage(
		@RequestBody UserCalculateConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		UserCalculateConfig userCalculateConfig = new UserCalculateConfig();
		userCalculateConfig.setUserId(userId);

		Page<UserCalculateConfig> page = new Page<UserCalculateConfig>(pageNum, pageSize);
		List<UserCalculateConfig> list = null;
		try {
			list = userCalculateConfigService.selectUserCalculateConfigListByPage(page, userCalculateConfig);
			logger.info("===step2:【分页查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByPage)-分页查询 用户算力配置列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByPage)-分页查询 用户算力配置列表-异常, Exception = {}, message = {}",e,e.getMessage());
	    	String errorCode = e.getErrorCode();
	    	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	    		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
			}
	    	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse diamondListPageResponse = new BootRestMapResponse();
		diamondListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		diamondListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		diamondListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		diamondListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		diamondListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByPage)-返回信息, diamondListPageResponse:{}", diamondListPageResponse);
		return diamondListPageResponse;
	}

	/**
	 * 查询用户算力配置列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectUserCalculateConfigList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCalculateConfigList(
		@RequestBody UserCalculateConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserCalculateConfig userCalculateConfig = new UserCalculateConfig();
		List<UserCalculateConfig> list = null;
		try {
			list = userCalculateConfigService.selectUserCalculateConfigList(userCalculateConfig);
			logger.info("===step2:【分页查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigList)-查询 用户算力配置列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询 用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigList)-查询 用户算力配置列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_LIST_NOTEXIST, BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse diamondListResponse = new BootRestMapResponse();
		diamondListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigList)-返回信息, diamondListResponse:{}", diamondListResponse);
		return diamondListResponse;
	}

	/**
	 * 根据userId查询用户算力配置列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectUserCalculateConfigListByUserId",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCalculateConfigListByUserId(
		@RequestBody UserCalculateConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userId查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByUserId)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		Integer calculateType = req.getCalculateType();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(calculateType == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "calculateType为空");
		}

		List<CalculateConfig> list = null;
		try {
			list = calculateConfigService.selectCalculateConfigListByCalculateType(calculateType);
			logger.info("===step2:【根据userId查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByUserId)-根据calculateType查询算力配置列表, list", list);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userId查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByUserId)-根据calculateType查询算力配置列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		List<JSONObject> userCalculateConfigVoList = null;
		UserCalculateConfigVo userCalculateConfigVo = null;
		if(list != null && !list.isEmpty()) {
			ListIterator<CalculateConfig> it = list.listIterator();
			userCalculateConfigVoList = new ArrayList<JSONObject>();
			while(it.hasNext()) {
				CalculateConfig calculateConfig = it.next();
				String calculateCode = calculateConfig.getCalculateCode();
				String content = Objects.toString(calculateConfig.getContent());
				Integer period = null;
				Integer times = null;
				Integer calculate = null;
				if(StringUtils.isNotBlank(content)) {
					CalculateTaskVo calculateTaskVo = JSONObject.parseObject(content, CalculateTaskVo.class);
					period = calculateTaskVo.getPeriod();
					times = calculateTaskVo.getTimes();
					calculate = calculateTaskVo.getCalculate();
				}

				UserCalculateConfig userCalculateConfig = null;
				try {
					userCalculateConfig = userCalculateConfigService.selectUserCalculateConfigByUserId(userId, calculateCode);
					logger.info("===step3:【根据userId查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByUserId)-根据userId和calculateCode查询用户算力配置, userCalculateConfig:{}", userCalculateConfig);
				} catch (BootServiceException e) {
					logger.error("===step3.1:【根据userId查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByUserId)-根据userId和calculateCode查询用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
					String errorCode = e.getErrorCode();
		        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
		        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		        	}
		        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
		        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		        	}
				}
				Long userCalculateConfigId = null;
				Date completeTime = null;
				Integer isComplete = SqlWheelConstants.SQL_USER_CALCULATE_CONFIG_TYPE_COMPLETE_NO;
				if(userCalculateConfig != null) {
					isComplete = userCalculateConfig.getIsComplete();
					completeTime = userCalculateConfig.getCompleteTime();
					userCalculateConfigId = userCalculateConfig.getUserCalculateConfigId();
					Integer amount = userCalculateConfig.getAmount();
					//不限(邀请好友)
					if(SqlWheelConstants.SQL_CALCULATE_CONFIG_TASK_PERIOD_UNLIMIT.equals(period)) {
						if(times <= amount) {
							calculate = calculate * times;
						} else {
							calculate = calculate * amount;
						}
					}
					//每天(每日用车)
					if(SqlWheelConstants.SQL_CALCULATE_CONFIG_TASK_PERIOD_DAY.equals(period)) {
						if(DateUtils.isSameDay(completeTime, new LocalDate().toDate())) {
							isComplete = SqlWheelConstants.SQL_USER_CALCULATE_CONFIG_TYPE_COMPLETE_YES;
						} else {
							isComplete = SqlWheelConstants.SQL_USER_CALCULATE_CONFIG_TYPE_COMPLETE_NO;
						}
					}
				}

				userCalculateConfigVo = new UserCalculateConfigVo();
				BeanUtils.copyProperties(calculateConfig, userCalculateConfigVo);
				if(StringUtils.isNotBlank(content)) {
					CalculateTaskVo calculateTaskVo = JSONObject.parseObject(content, CalculateTaskVo.class);
					calculateTaskVo.setCalculate(calculate);
					BeanUtils.copyProperties(calculateTaskVo, userCalculateConfigVo);
				}

				userCalculateConfigVo.setIsComplete(isComplete);
				userCalculateConfigVo.setCompleteTime(completeTime);
				userCalculateConfigVo.setUserCalculateConfigId(userCalculateConfigId);
				userCalculateConfigVoList.add((JSONObject) JSONObject.toJSON(userCalculateConfigVo));
			}
		}

		BootRestMapResponse userCalculateConfigResponse = new BootRestMapResponse();
		userCalculateConfigResponse.put(PageConstants.DATA_LIST, userCalculateConfigVoList);
		logger.info("===step4:【根据userId查询用户算力配置列表】(BootUserCalculateConfigController-selectUserCalculateConfigListByUserId)-返回信息, userCalculateConfigResponse:{}", userCalculateConfigResponse);
		return userCalculateConfigResponse;
	}

	/**
	 * 根据id查询用户算力配置
	 * @param userCalculateConfigId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectUserCalculateConfigById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCalculateConfigById(
		@PathVariable(value="id",required=false) Long userCalculateConfigId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigById)-传入参数, userCalculateConfigId:{}", userCalculateConfigId);

		if(userCalculateConfigId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userCalculateConfigId为空");
		}

		UserCalculateConfig userCalculateConfig = null;
		try {
			userCalculateConfig = userCalculateConfigService.selectUserCalculateConfigById(userCalculateConfigId);
			logger.info("===step2:【根据id查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigById)-查询用户算力配置, userCalculateConfig:{}", userCalculateConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigById)-查询用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userCalculateConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse userCalculateConfigResponse = new BootRestMapResponse();
		userCalculateConfigResponse.putAll((JSONObject) JSONObject.toJSON(userCalculateConfig));
		logger.info("===step3:【根据id查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigById)-返回信息, userCalculateConfigResponse:{}", userCalculateConfigResponse);
		return userCalculateConfigResponse;
	}

	/**
	 * 根据userId和calculateCode查询用户算力配置
	 * @param userId
	 * @param calculateCode
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectUserCalculateConfigByUserId",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectUserCalculateConfigByUserId(
		@RequestBody UserCalculateConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【【根据userId和calculateCode查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigByUserId)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String calculateCode = req.getCalculateCode();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(StringUtils.isBlank(calculateCode)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "calculateCode为空");
		}

		UserCalculateConfig userCalculateConfig = null;
		try {
			userCalculateConfig = userCalculateConfigService.selectUserCalculateConfigByUserId(userId, calculateCode);
			logger.info("===step2:【根据userId和calculateCode查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigByUserId)-根据userId和calculateCode查询用户算力配置, userCalculateConfig:{}", userCalculateConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userId和calculateCode查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigByUserId)-根据userId和calculateCode查询用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userCalculateConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse userCalculateConfigResponse = new BootRestMapResponse();
		userCalculateConfigResponse.putAll((JSONObject) JSONObject.toJSON(userCalculateConfig));
		logger.info("===step3:【根据userId和calculateCode查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigByUserId)-返回信息, userCalculateConfigResponse:{}", userCalculateConfigResponse);
		return userCalculateConfigResponse;
	}


	/**
	 * 插入用户算力配置
	 * @param req
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertUserCalculateConfig",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertUserCalculateConfig(
		@RequestBody UserCalculateConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入用户算力配置】(BootUserCalculateConfigController-insertUserCalculateConfig)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
	    String calculateCode = req.getCalculateCode();
	    Integer isComplete = req.getIsComplete();
	    Integer isAdd = req.getIsAdd();
	    Integer amount = req.getAmount();
	    Integer sourceType = req.getSourceType();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(StringUtils.isBlank(calculateCode)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "calculateCode为空");
		}

		UserCalculateConfig userCalculateConfig = new UserCalculateConfig();
		userCalculateConfig.setUserId(userId);
		userCalculateConfig.setCalculateCode(calculateCode);
		userCalculateConfig.setIsComplete(isComplete);
		userCalculateConfig.setIsAdd(isAdd);
		userCalculateConfig.setAmount(amount);
		int i = 0;
		try {
			i = userCalculateConfigService.insertUserCalculateConfig(userCalculateConfig, sourceType);
			logger.info("===step2:【插入用户算力配置】(BootUserCalculateConfigController-insertUserCalculateConfig)-插入用户算力配置-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【插入用户算力配置】(BootUserCalculateConfigController-insertUserCalculateConfig)-插入用户算力配置-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse userCalculateConfigLogResponse = new BootRestMapResponse();
		logger.info("===step3:【插入用户算力配置】(BootUserCalculateConfigController-insertUserCalculateConfig)-返回信息, userCalculateConfigLogResponse:{}", userCalculateConfigLogResponse);
		return userCalculateConfigLogResponse;
	}

	/**
	 * 修改用户算力配置
	 * @param req
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyUserCalculateConfig",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyUserCalculateConfig(
		@RequestBody UserCalculateConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改用户算力配置】(BootUserCalculateConfigController-modifyUserCalculateConfig)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Long userCalculateConfigId = req.getUserCalculateConfigId();
		Integer userId = req.getUserId();
	    String calculateCode = req.getCalculateCode();
	    Integer isComplete = req.getIsComplete();
		if(userCalculateConfigId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userCalculateConfigId为空");
		}

		UserCalculateConfig userCalculateConfig = null;
		try {
			userCalculateConfig = userCalculateConfigService.selectUserCalculateConfigById(userCalculateConfigId);
			logger.info("===step2:【根据id查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigById)-查询用户算力配置, userCalculateConfig:{}", userCalculateConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询用户算力配置】(BootUserCalculateConfigController-selectUserCalculateConfigById)-查询用户算力配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(userCalculateConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_USER_CALCULATE_CONFIG_ENTITY_NOTEXIST_MSG);
		}

		userCalculateConfig.setUserCalculateConfigId(userCalculateConfigId);
		userCalculateConfig.setUserId(userId);
		userCalculateConfig.setCalculateCode(calculateCode);
		userCalculateConfig.setIsComplete(isComplete);
		int i = 0;
		try {
			i = userCalculateConfigService.modifyUserCalculateConfig(userCalculateConfig);
			logger.info("===step2:【修改用户算力配置】(BootUserCalculateConfigController-modifyUserCalculateConfig)-修改用户算力配置-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改用户算力配置】(BootUserCalculateConfigController-modifyUserCalculateConfig)-修改用户算力配置-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse userCalculateConfigLogResponse = new BootRestMapResponse();
		logger.info("===step3:【修改用户算力配置】(BootUserCalculateConfigController-modifyUserCalculateConfig)-返回信息, userCalculateConfigLogResponse:{}", userCalculateConfigLogResponse);
		return userCalculateConfigLogResponse;
	}

}