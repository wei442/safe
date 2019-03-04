package com.cloud.provider.safe.controller;

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
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.cloud.provider.safe.boot.BootRestMapResponse;
import com.cloud.provider.safe.po.DiamondConfig;
import com.cloud.provider.safe.rest.request.diamond.DiamondConfigRequest;
import com.cloud.provider.safe.service.IBootDiamondConfigService;

/**
 * 能量配置 BootDiamondController
 * @author wang.tongmeng
 */
@RestController
@RequestMapping(value="/boot/diamondConfig")
public class BootDiamondConfigController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//能量配置Service
	@Autowired
	private IBootDiamondConfigService diamondConfigService;

	/**
	 * 分页查询 能量配置列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondConfigListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondConfigListByPage(
		@RequestBody DiamondConfigRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询能量配置列表】(BootDiamondController-selectDiamondConfigListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		DiamondConfig diamondConfig = new DiamondConfig();

		Page<DiamondConfig> page = new Page<DiamondConfig>(pageNum, pageSize);
		List<DiamondConfig> list = null;
		try {
			list = diamondConfigService.selectDiamondConfigListByPage(page, diamondConfig);
			logger.info("===step2:【分页查询能量配置列表】(BootDiamondController-selectDiamondConfigListByPage)-分页查询 能量配置列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询能量配置列表】(BootDiamondController-selectDiamondConfigListByPage)-分页查询 能量配置列表-异常, Exception = {}, message = {}",e,e.getMessage());
	    	String errorCode = e.getErrorCode();
	    	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	    		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
			}
	    	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
	}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_CONFIG_LIST_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_CONFIG_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse diamondListPageResponse = new BootRestMapResponse();
		diamondListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		diamondListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		diamondListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		diamondListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		diamondListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询能量配置列表】(BootDiamondController-selectDiamondConfigListByPage)-返回信息, diamondListPageResponse:{}", diamondListPageResponse);
		return diamondListPageResponse;
	}

	/**
	 * 查询能量配置列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondConfigList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondConfigList(
		@RequestBody DiamondConfigRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询能量配置列表】(BootDiamondController-selectDiamondConfigList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		DiamondConfig diamondConfig = new DiamondConfig();
		List<DiamondConfig> list = null;
		try {
			list = diamondConfigService.selectDiamondConfigList(diamondConfig);
			logger.info("===step2:【查询能量配置列表】(BootDiamondController-selectDiamondConfigList)-查询能量配置列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【查询能量配置列表】(BootDiamondController-selectDiamondConfigList)-查询能量配置列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_CONFIG_LIST_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_CONFIG_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse diamondListResponse = new BootRestMapResponse();
		diamondListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询能量配置列表】(BootDiamondController-selectDiamondConfigList)-返回信息, diamondListResponse:{}", diamondListResponse);
		return diamondListResponse;
	}

	/**
	 * 据id查询能量配置
	 * @param diamondId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondConfigById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondConfigById(
		@PathVariable(value="id",required=false) Integer diamondId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据id查询能量配置】(selectDiamondConfigById-selectDiamondConfigById)-传入参数, diamondId:{}", diamondId);

		if(diamondId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamondId为空");
		}

		DiamondConfig diamondConfig = null;
		try {
			diamondConfig = diamondConfigService.selectDiamondConfigById(diamondId);
			logger.info("===step2:【据id查询能量配置】(BootDiamondController-selectDiamondConfigById)-根据id查询能量配置, diamondConfig:{}", diamondConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据id查询能量配置】(BootDiamondController-selectDiamondConfigById)-根据id查询能量配置-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(diamondConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_CONFIG_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(diamondConfig));
		logger.info("===step3:【据id查询能量配置】(BootDiamondController-selectTemplateById)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 根据code查询能量配置
	 * @param code
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondConfigByCode/{code}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondConfigByCode(
		@PathVariable(value="code",required=false) String diamondCode,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据diamondCode查询能量配置】(BootDiamondController-selectDiamondConfigByCode)-传入参数, diamondCode:{}", diamondCode);

		if(StringUtils.isBlank(diamondCode)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamondCode为空");
		}

		DiamondConfig diamondConfig = null;
		try {
			diamondConfig = diamondConfigService.selectDiamondConfigByCode(diamondCode);
			logger.info("===step2:【根据diamondCode查询能量配置】(BootDiamondController-selectDiamondConfigByCode)-根据diamondCode查询能量配置, diamondConfig:{}", diamondConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据diamondCode查询能量配置】(BootDiamondController-selectDiamondConfigByCode)-根据diamondCode查询能量配置-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(diamondConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_CONFIG_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse diamondResponse = new BootRestMapResponse();
		diamondResponse.putAll((JSONObject) JSONObject.toJSON(diamondConfig));
		logger.info("===step3:【根据diamondCode查询能量配置】(BootDiamondController-selectDiamondConfigByCode)-返回信息, diamondResponse:{}", diamondResponse);
		return diamondResponse;
	}

	/**
	 * 添加能量配置
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertDiamondConfig",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertDiamondConfig(
		@RequestBody DiamondConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加能量配置】(BootDiamondController-insertDiamondConfig)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String diamondName = req.getDiamondName();
		Integer sendAmount = req.getSendAmount();
		Integer diamondType = req.getDiamondType();
		Integer isFix = req.getIsFix();
		BigDecimal fixSendAmount = req.getFixSendAmount();
		if(StringUtils.isBlank(diamondName)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "名称为空");
		} else if(sendAmount == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "发放数量为空");
		} else if(diamondType == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "能量类型为空");
		} else if(isFix == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "是否固定发放为空");
		}

		DiamondConfig diamondConfig = new DiamondConfig();
		diamondConfig.setDiamondName(diamondName);
		diamondConfig.setDiamondType(diamondType);
		diamondConfig.setSendAmount(sendAmount);
		diamondConfig.setIsFix(isFix);
		diamondConfig.setFixSendAmount(fixSendAmount);
		diamondConfig.setIsDelete(SqlWheelConstants.SQL_CALCULATE_CONFIG_IS_DELETE_NO);
		try {
			int i = diamondConfigService.insertDiamondConfig(diamondConfig);
			logger.info("===step4:【添加能量配置】(BootDiamondController-insertDiamondConfig)-插入能量配置, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step4.1:【添加能量配置】(BootDiamondController-insertDiamondConfig)-插入能量配置-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step5:【添加能量配置】(BootDiamondController-insertDiamondConfig)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 修改能量配置
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyDiamondConfig",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyDiamondConfig(
		@RequestBody DiamondConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改能量配置】(BootDiamondController-modifyDiamondConfig)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer diamondConfigId = req.getDiamondConfigId();
		Integer sendAmount = req.getSendAmount();
		Integer isFix = req.getIsFix();
		BigDecimal fixSendAmount = req.getFixSendAmount();
		Integer isDelete = req.getIsDelete();
		String diamondName = req.getDiamondName();
		if(diamondConfigId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamondConfigId为空");
		}

		DiamondConfig diamondConfig = null;
		try {
			diamondConfig = diamondConfigService.selectDiamondConfigById(diamondConfigId);
			logger.info("===step3:【修改能量配置】(BootDiamondController-modifyDiamondConfig)-根据diamondConfigId查询 能量配置, diamondConfig:{}", diamondConfig);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改能量配置】(BootDiamondController-modifyDiamondConfig)-根据diamondConfigId查询 能量配置-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(diamondConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_CONFIG_ENTITY_NOTEXIST_MSG);
		}
		diamondConfig.setSendAmount(sendAmount);
		diamondConfig.setIsFix(isFix);
		diamondConfig.setFixSendAmount(fixSendAmount);
		diamondConfig.setIsDelete(isDelete);
		diamondConfig.setDiamondName(diamondName);

		try {
			int i = diamondConfigService.modifyDiamondConfig(diamondConfig);
			logger.info("===step4:【修改能量配置】(BootDiamondController-modifyDiamondConfig)-修改能量配置, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step4.1:【修改能量配置】(BootDiamondController-modifyDiamondConfig)-修改能量配置-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		logger.info("===step5:【修改能量配置】(BootDiamondController-modifyDiamondConfig)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

}