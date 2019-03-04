package com.cloud.provider.safe.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
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

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.PageConstants;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.cloud.provider.safe.boot.BootRestMapResponse;
import com.cloud.provider.safe.po.CalculateConfig;
import com.cloud.provider.safe.po.CalculateConfigUpdate;
import com.cloud.provider.safe.rest.request.calculate.CalculateConfigRequest;
import com.cloud.provider.safe.rest.request.calculate.CalculateConfigUpdateRequest;
import com.cloud.provider.safe.service.IBootCalculateConfigService;
import com.cloud.provider.safe.vo.calculate.CalculateConfigVo;

/**
 *算力配置 BootCalculateController
 * @author wang.tongmeng
 */
@RestController
@RequestMapping(value="/boot/calculateConfig")
public class BootCalculateConfigController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//算力配置Service
	@Autowired
	private IBootCalculateConfigService calculateConfigService;

	/**
	 * 分页查询算力配置列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateConfigListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCalculateConfigListByPage(
		@RequestBody CalculateConfigRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询算力配置列表】(BootCalculateController-selectCalculateConfigListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		CalculateConfig calculateConfig = new CalculateConfig();
		calculateConfig.setCalculateCode(req.getCalculateCode());
		calculateConfig.setCalculateName(req.getCalculateName());
		calculateConfig.setCalculateType(req.getCalculateType());
		calculateConfig.setIsUse(req.getIsUse());
		Page<CalculateConfig> page = new Page<CalculateConfig>(pageNum, pageSize);
		List<CalculateConfig> list = null;
		try {
			list = calculateConfigService.selectCalculateConfigListByPage(page, calculateConfig);
			logger.info("===step2:【分页查询算力配置列表】(BootCalculateController-selectCalculateConfigListByPage)-分页查询算力配置列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询算力配置列表】(BootCalculateController-selectCalculateConfigListByPage)-分页查询算力配置列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_CONFIG_LIST_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_CONFIG_LIST_NOTEXIST_MSG);
		}
		List<JSONObject> calculateConfigVoList = null;
		CalculateConfigVo calculateConfigVo = null;
		JSONObject calculateConfigJSON = null;
		if(list != null && !list.isEmpty()) {
			ListIterator<CalculateConfig> it = list.listIterator();
			calculateConfigVoList = new ArrayList<JSONObject>();
			while(it.hasNext()) {
				CalculateConfig calculateConfigEntity = it.next();
				String content = Objects.toString(calculateConfigEntity.getContent());
				calculateConfigVo = new CalculateConfigVo();
				calculateConfigJSON = new JSONObject();
				BeanUtils.copyProperties(calculateConfigEntity, calculateConfigVo);

				calculateConfigJSON.putAll((JSONObject) JSONObject.toJSON(calculateConfigVo));
				calculateConfigJSON.putAll(JSONObject.parseObject(content));
				calculateConfigVoList.add(calculateConfigJSON);
			}
		}

		BootRestMapResponse calculateListPageResponse = new BootRestMapResponse();
		calculateListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		calculateListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		calculateListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		calculateListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		calculateListPageResponse.put(PageConstants.DATA_LIST, calculateConfigVoList);
		logger.info("===step3:【分页查询算力配置列表】(BootCalculateController-selectCalculateConfigListByPage)-返回信息, calculateListPageResponse:{}", calculateListPageResponse);
		return calculateListPageResponse;
	}

	/**
	 * 查询算力配置列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateConfigList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCalculateConfigList(
		@RequestBody CalculateConfigRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询算力配置列表】(BootCalculateController-selectCalculateConfigList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		CalculateConfig calculateConfig = new CalculateConfig();
		calculateConfig.setCalculateCode(req.getCalculateCode());
		calculateConfig.setCalculateName(req.getCalculateName());
		calculateConfig.setCalculateType(req.getCalculateType());
		calculateConfig.setIsUse(req.getIsUse());
		List<CalculateConfig> list = null;
		try {
			list = calculateConfigService.selectCalculateConfigList(calculateConfig);
			logger.info("===step2:【分页查询算力配置列表】(BootCalculateController-selectCalculateConfigList)-查询算力配置列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询算力配置列表】(BootCalculateController-selectCalculateConfigList)-查询算力配置列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_CONFIG_LIST_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_CONFIG_LIST_NOTEXIST_MSG);
		}
		List<JSONObject> calculateConfigVoList = null;
		CalculateConfigVo calculateConfigVo = null;
		JSONObject calculateConfigJSON = null;
		if(list != null && !list.isEmpty()) {
			ListIterator<CalculateConfig> it = list.listIterator();
			calculateConfigVoList = new ArrayList<JSONObject>();
			while(it.hasNext()) {
				CalculateConfig calculateConfigEntity = it.next();
				String content = Objects.toString(calculateConfigEntity.getContent());
				calculateConfigVo = new CalculateConfigVo();
				calculateConfigJSON = new JSONObject();
				BeanUtils.copyProperties(calculateConfigEntity, calculateConfigVo);

				calculateConfigJSON.putAll((JSONObject) JSONObject.toJSON(calculateConfigVo));
				calculateConfigJSON.putAll(JSONObject.parseObject(content));
				calculateConfigVoList.add(calculateConfigJSON);
			}
		}

		BootRestMapResponse calculateListResponse = new BootRestMapResponse();
		calculateListResponse.put(PageConstants.DATA_LIST, calculateConfigVoList);
		logger.info("===step3:【查询算力配置列表】(BootCalculateController-selectCalculateConfigList)-返回信息, calculateListResponse:{}", calculateListResponse);
		return calculateListResponse;
	}

	/**
	 * 据id查询算力配置
	 * @param calculateId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateConfigById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCalculateConfigById(
		@PathVariable(value="id",required=false) Integer calculateId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据id查询算力配置】(selectCalculateConfigById-selectCalculateConfigById)-传入参数, calculateId:{}", calculateId);
		if(calculateId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "calculateId为空");
		}
		CalculateConfig calculateConfig = null;
		try {
			calculateConfig = calculateConfigService.selectCalculateConfigById(calculateId);
			logger.info("===step2:【据id查询算力配置】(BootCalculateController-selectCalculateConfigById)-根据id查询算力配置, calculateConfig:{}", calculateConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据id查询算力配置】(BootCalculateController-selectCalculateConfigById)-根据id查询算力配置-异常, Exception = {}, message = {}",e,e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(calculateConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_CONFIG_ENTITY_NOTEXIST_MSG);
		}
		String content = Objects.toString(calculateConfig.getContent());
		CalculateConfigVo calculateConfigVo = new CalculateConfigVo();
		JSONObject calculateConfigJSON = new JSONObject();
		BeanUtils.copyProperties(calculateConfig, calculateConfigVo);
		calculateConfigJSON.putAll((JSONObject) JSONObject.toJSON(calculateConfigVo));
		calculateConfigJSON.putAll(JSONObject.parseObject(content));

		BootRestMapResponse calculateResponse = new BootRestMapResponse();
		calculateResponse.putAll(calculateConfigJSON);
		logger.info("===step3:【据id查询算力配置】(BootCalculateController-selectTemplateById)-返回信息, calculateResponse:{}", calculateResponse);
		return calculateResponse;
	}

	/**
	 * 根据code查询算力配置
	 * @param code
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateConfigByCode/{code}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCalculateConfigByCode(
		@PathVariable(value="code",required=false) String calculateCode,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据calculateCode查询算力配置】(BootCalculateController-selectCalculateConfigByCode)-传入参数, calculateCode:{}", calculateCode);

		if(StringUtils.isBlank(calculateCode)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "calculateCode为空");
		}

		CalculateConfig calculateConfig = null;
		try {
			calculateConfig = calculateConfigService.selectCalculateConfigByCode(calculateCode);
			logger.info("===step2:【根据calculateCode查询算力配置】(BootCalculateController-selectCalculateConfigByCode)-根据calculateCode查询算力配置, calculateConfig:{}", calculateConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据calculateCode查询算力配置】(BootCalculateController-selectCalculateConfigByCode)-根据calculateCode查询算力配置-异常, Exception = {}, message = {}",e,e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(calculateConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_CONFIG_ENTITY_NOTEXIST_MSG);
		}
		String content = Objects.toString(calculateConfig.getContent());
		CalculateConfigVo calculateConfigVo = new CalculateConfigVo();
		JSONObject calculateConfigJSON = new JSONObject();
		BeanUtils.copyProperties(calculateConfig, calculateConfigVo);
		calculateConfigJSON.putAll((JSONObject) JSONObject.toJSON(calculateConfigVo));
		calculateConfigJSON.putAll(JSONObject.parseObject(content));

		BootRestMapResponse calculateResponse = new BootRestMapResponse();
		calculateResponse.putAll(calculateConfigJSON);
		logger.info("===step3:【根据calculateCode查询算力配置】(BootCalculateController-selectCalculateConfigByCode)-返回信息, calculateResponse:{}", calculateResponse);
		return calculateResponse;
	}

	/**
	 * 添加算力配置
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertCalculateConfig",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertCalculateConfig(
		@RequestBody CalculateConfigRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加算力配置】(BootCalculateController-insertCalculateConfig)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String calculateName = req.getCalculateName();
		String content = req.getContent();
		Integer calculateType = req.getCalculateType();
		Integer isUse = req.getIsUse();
		Integer isSkip = req.getIsSkip();
		String toUrl = req.getUrl();
		String remark = req.getRemark();
		if(StringUtils.isBlank(calculateName)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "算力名称为空");
		} else if(StringUtils.isBlank(content)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "content为空");
		} else if(calculateType == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "类型为空");
		} else if(isUse == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "是否启用为空");
		} else if(isSkip == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "是否跳转为空");
		}

		try {
			JSONObject contentJson = JSONObject.parseObject(content);
			logger.info("===step2:【添加算力配置】(BootCalculateController-insertCalculateConfig)-content转换json, contentJson:{}", contentJson);
		} catch (JSONException e) {
			logger.error("===step2.1:【添加算力配置】(BootCalculateController-insertCalculateConfig)-content转换json失败, Exception:{}, message:{}", e, e.getMessage());
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CONTENT_NOTJSON, BootWheelConstants.WHEEL_CONTENT_NOTJSON_MSG);
		}

		CalculateConfig calculateConfig = new CalculateConfig();
		calculateConfig.setCalculateName(calculateName);
		calculateConfig.setCalculateType(calculateType);
		calculateConfig.setContent(content);
		calculateConfig.setIsDelete(SqlWheelConstants.SQL_CALCULATE_CONFIG_IS_DELETE_NO);
		calculateConfig.setIsUse(isUse);
		calculateConfig.setIsSkip(isSkip);
		calculateConfig.setUrl(toUrl);
		calculateConfig.setRemark(remark);

		try {
			int i = calculateConfigService.insertCalculateConfig(calculateConfig);
			logger.info("===step3:【添加算力配置】(BootCalculateController-insertCalculateConfig)-插入算力配置, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step4.1:【添加算力配置】(BootCalculateController-insertCalculateConfig)-插入算力配置-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse calculateResponse = new BootRestMapResponse();
		logger.info("===step5:【添加算力配置】(BootCalculateController-insertCalculateConfig)-返回信息, calculateResponse:{}", calculateResponse);
		return calculateResponse;
	}

	/**
	 * 修改算力配置
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyCalculateConfig",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyCalculateConfig(
		@RequestBody CalculateConfigUpdateRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改算力配置】(BootCalculateController-modifyCalculateConfig)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer calculateConfigId = req.getCalculateConfigId();
		Integer calculateType = req.getCalculateType();
		String calculateName = req.getCalculateName();
		Integer isDelete = req.getIsDelete();
		Integer period = req.getPeriod();
		Integer times = req.getTimes();
		Integer calculate = req.getCalculate();
		Double ratio = req.getRatio();
		Integer isSkip = req.getIsSkip();
		Integer isUse = req.getIsUse();
		String toUrl = req.getUrl();
		String remark = req.getRemark();
		if(calculateConfigId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "calculateConfigId为空");
		}

		CalculateConfig calculateConfig = null;
		try {
			calculateConfig = calculateConfigService.selectCalculateConfigById(calculateConfigId);
			logger.info("===step2:【修改算力配置】(BootCalculateController-modifyCalculateConfig)-根据calculateId查询算力配置, calculateConfig:{}", calculateConfig);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改算力配置】(BootCalculateController-modifyCalculateConfig)-根据calculateId查询算力配置-异常, Exception = {}, message = {}",e,e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(calculateConfig == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_CONFIG_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_CONFIG_ENTITY_NOTEXIST_MSG);
		}

		CalculateConfigUpdate calculateConfigUpdate = new CalculateConfigUpdate();
		BeanUtils.copyProperties(calculateConfig, calculateConfigUpdate);
		calculateConfigUpdate.setCalculateName(calculateName);
		calculateConfigUpdate.setCalculateType(calculateType);
		calculateConfigUpdate.setIsDelete(isDelete);
		calculateConfigUpdate.setIsSkip(isSkip);
		calculateConfigUpdate.setIsUse(isUse);
		calculateConfigUpdate.setUrl(toUrl);
		calculateConfigUpdate.setCalculate(calculate);
		calculateConfigUpdate.setPeriod(period);
		calculateConfigUpdate.setRatio(ratio);
		calculateConfigUpdate.setTimes(times);
		calculateConfigUpdate.setRemark(remark);
		try {
			int i = calculateConfigService.modifyCalculateConfig(calculateConfigUpdate);
			logger.info("===step3:【修改算力配置】(BootCalculateController-modifyCalculateConfig)-修改算力配置, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改算力配置】(BootCalculateController-modifyCalculateConfig)-修改算力配置-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse calculateResponse = new BootRestMapResponse();
		logger.info("===step4:【修改算力配置】(BootCalculateController-modifyCalculateConfig)-返回信息, calculateResponse:{}", calculateResponse);
		return calculateResponse;
	}

}