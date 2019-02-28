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
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.po.FeeConfig;
import com.ochain.provider.wheel.rest.request.feeConfig.FeeConfigRequest;
import com.ochain.provider.wheel.service.IBootFeeConfigService;

/**
 * 手续费配置 BootFeeConfigController
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/feeConfig")
public class BootFeeConfigController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//手续费配置 Service
	@Autowired
	private IBootFeeConfigService feeConfigService;

	/**
	 * 分页查询手续费配置列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectFeeConfigListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectFeeConfigListByPage(
		@RequestBody FeeConfigRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询手续费配置列表】(BootFeeConfigController-selectFeeConfigListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		FeeConfig feeConfig = new FeeConfig();
		Page<FeeConfig> page = new Page<FeeConfig>(pageNum, pageSize);
		List<FeeConfig> list = null;
		try {
			list = feeConfigService.selectFeeConfigListByPage(page, feeConfig);
			logger.info("===step2:【分页查询手续费配置列表】(BootFeeConfigController-selectFeeConfigListByPage)-分页查询手续费配置列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询手续费配置列表】(BootFeeConfigController-selectFeeConfigListByPage)-分页查询手续费配置列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FEE_CONFIG_LIST_NOTEXIST, BootWheelConstants.WHEEL_FEE_CONFIG_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse feeConfigListPageResponse = new BootRestMapResponse();
		feeConfigListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		feeConfigListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		feeConfigListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		feeConfigListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		feeConfigListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询手续费配置列表】(BootFeeConfigController-selectFeeConfigListByPage)-返回信息, feeConfigListPageResponse:{}", feeConfigListPageResponse);
		return feeConfigListPageResponse;
	}

	/**
	 * 查询手续费配置列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectFeeConfigList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectFeeConfigList(
		@RequestBody FeeConfigRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询手续费配置列表】(BootFeeConfigController-selectFeeConfigList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		FeeConfig feeConfig = new FeeConfig();
		List<FeeConfig> list = null;
		try {
			list = feeConfigService.selectFeeConfigList(feeConfig);
			logger.info("===step2:【分页查询手续费配置列表】(BootFeeConfigController-selectFeeConfigList)-查询手续费配置列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询手续费配置列表】(BootFeeConfigController-selectFeeConfigList)-查询手续费配置列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FEE_CONFIG_LIST_NOTEXIST, BootWheelConstants.WHEEL_FEE_CONFIG_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse calculateListResponse = new BootRestMapResponse();
		calculateListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询手续费配置列表】(BootFeeConfigController-selectFeeConfigList)-返回信息, calculateListResponse:{}", calculateListResponse);
		return calculateListResponse;
	}

	/**
	 * 根据id查询手续费配置
	 * @param feeConfigId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectFeeConfigById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectFeeConfigById(
		@PathVariable(value="id",required=false) Integer feeConfigId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询手续费配置】(BootFeeConfigController-selectFeeConfigById)-传入参数, feeConfigId:{}", feeConfigId);

		if(feeConfigId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "feeConfigId为空");
		}

		FeeConfig feeConfig = null;
		try {
			feeConfig = feeConfigService.selectFeeConfigById(feeConfigId);
			logger.info("===step2:【根据id查询手续费配置】(BootFeeConfigController-selectFeeConfigById)-根据feeConfigId查询手续费配置, feeConfig:{}", feeConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询手续费配置】(BootFeeConfigController-selectFeeConfigById)-根据feeConfigId查询手续费配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(feeConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FEE_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_FEE_CONFIG_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse feeConfigResponse = new BootRestMapResponse();
		feeConfigResponse.putAll((JSONObject) JSONObject.toJSON(feeConfig));
		logger.info("===step3:【根据id查询手续费配置】(BootFeeConfigController-selectFeeConfigById)-返回信息, feeConfigResponse:{}", feeConfigResponse);
		return feeConfigResponse;
	}

	/**
	 * 根据code查询手续费配置
	 * @param feeCode
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectFeeConfigByFeeCode/{code}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectFeeConfigByFeeCode(
		@PathVariable(value="code",required=false) String feeCode,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据code查询手续费配置】(BootFeeConfigController-selectFeeConfigByFeeCode)-传入参数, feeCode:{}", feeCode);

		if(StringUtils.isBlank(feeCode)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "feeCode为空");
		}

		FeeConfig feeConfig = null;
		try {
			feeConfig = feeConfigService.selectFeeConfigByFeeCode(feeCode);
			logger.info("===step2:【根据code查询手续费配置】(BootFeeConfigController-selectFeeConfigByFeeCode)-根据feeCode查询手续费配置, feeConfig:{}", feeConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据code查询手续费配置】(BootFeeConfigController-selectFeeConfigByFeeCode)-根据feeCode查询手续费配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(feeConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FEE_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_FEE_CONFIG_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse feeConfigResponse = new BootRestMapResponse();
		feeConfigResponse.putAll((JSONObject) JSONObject.toJSON(feeConfig));
		logger.info("===step3:【根据code查询手续费配置】(BootFeeConfigController-selectFeeConfigByFeeCode)-返回信息, feeConfigResponse:{}", feeConfigResponse);
		return feeConfigResponse;
	}

	/**
	 * 插入手续费配置
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertFeeConfig",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertFeeConfig(
		@RequestBody FeeConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入手续费配置】(BootFeeConfigController-insertFeeConfig)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

	    String feeCode = req.getFeeCode();
	    String feeName = req.getFeeName();
	    BigDecimal fee = req.getFee();
		if(StringUtils.isBlank(feeCode)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "feeCode为空");
		} else if(StringUtils.isBlank(feeName)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "feeName为空");
		} else if(fee == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "fee为空");
		}

		FeeConfig feeConfig = new FeeConfig();
		feeConfig.setFeeCode(feeCode);
		feeConfig.setFeeName(feeName);
		feeConfig.setFee(fee);
		int i = 0;
		try {
			i = feeConfigService.insertFeeConfig(feeConfig);
			logger.info("=====step2:【插入手续费配置】(BootFeeConfigController-insertFeeConfig)-插入手续费配置-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step2.1:【插入手续费配置】(BootFeeConfigController-insertFeeConfig)-插入手续费配置-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse feeConfigResponse = new BootRestMapResponse();
		feeConfigResponse.putAll((JSONObject) JSONObject.toJSON(feeConfig));
		logger.info("===step3:【插入手续费配置】(BootFeeConfigController-insertFeeConfig)--返回信息, feeConfigResponse:{}", feeConfigResponse);
		return feeConfigResponse;
	}

	/**
	 * 修改手续费配置
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyFeeConfig",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyFeeConfig(
		@RequestBody FeeConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改手续费配置】(BootFeeConfigController-modifyFeeConfig)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer feeConfigId = req.getFeeConfigId();
	    String feeCode = req.getFeeCode();
	    String feeName = req.getFeeName();
	    BigDecimal fee = req.getFee();
		if(feeConfigId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "feeConfigId为空");
		} else if(StringUtils.isBlank(feeCode)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "feeCode为空");
		} else if(StringUtils.isBlank(feeName)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "feeName为空");
		} else if(fee == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "fee为空");
		}

		FeeConfig feeConfig = null;
		try {
			feeConfig = feeConfigService.selectFeeConfigById(feeConfigId);
			logger.info("===step2:【修改手续费配置】(BootFeeConfigController-modifyFeeConfig)-根据feeConfigId查询手续费配置, feeConfig:{}", feeConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改手续费配置】(BootFeeConfigController-modifyFeeConfig)-根据feeConfigId查询手续费配置-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(feeConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FEE_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_FEE_CONFIG_ENTITY_NOTEXIST_MSG);
		}

		feeConfig.setFeeCode(feeCode);
		feeConfig.setFeeName(feeName);
		feeConfig.setFee(fee);
		int i = 0;
		try {
			i = feeConfigService.modifyFeeConfig(feeConfig);
			logger.info("=====step3:【修改手续费配置】(BootFeeConfigController-modifyFeeConfig)-修改手续费配置-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("=====step3.1:【修改手续费配置】(BootFeeConfigController-modifyFeeConfig)-修改手续费配置-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse feeConfigResponse = new BootRestMapResponse();
		feeConfigResponse.putAll((JSONObject) JSONObject.toJSON(feeConfig));
		logger.info("===step4:【修改手续费配置】(BootFeeConfigController-modifyFeeConfig)-返回信息, feeConfigResponse:{}", feeConfigResponse);
		return feeConfigResponse;
	}

}