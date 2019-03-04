package com.cloud.provider.safe.controller;

import java.util.Date;
import java.util.List;

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
import com.ochain.common.constants.PageConstants;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.cloud.provider.safe.boot.BootRestMapResponse;
import com.cloud.provider.safe.po.CarOrderRecord;
import com.cloud.provider.safe.rest.request.diamond.CarOrderRecordRequest;
import com.cloud.provider.safe.service.IBootCarOrderRecordService;
import com.cloud.provider.safe.vo.gofun.CarOrderVo;

/**
 * 用车订单记录 BootCarOrderRecordController
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/carOrderRecord")
public class BootCarOrderRecordController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用车订单记录 Service
	@Autowired
	private IBootCarOrderRecordService carOrderRecordService;

	/**
	 * 分页查询用车订单记录列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectCarOrderRecordListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCarOrderRecordListByPage(
		@RequestBody CarOrderRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询用车订单记录列表】(BootCarOrderRecordController-selectCarOrderRecordListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		CarOrderRecord carOrderRecord = new CarOrderRecord();
		carOrderRecord.setUserId(userId);

		Page<CarOrderRecord> page = new Page<CarOrderRecord>(pageNum, pageSize);
		List<CarOrderRecord> list = null;
		try {
			list = carOrderRecordService.selectCarOrderRecordListByPage(page, carOrderRecord);
			logger.info("===step2:【分页查询用车订单记录列表】(BootCarOrderRecordController-selectCarOrderRecordListByPage)-分页查询 用车订单记录列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询用车订单记录列表】(BootCarOrderRecordController-selectCarOrderRecordListByPage)-分页查询 用车订单记录列表-异常, Exception = {}, message = {}",e,e.getMessage());
	    	String errorCode = e.getErrorCode();
	    	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
	    		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
			}
	    	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_LIST_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse diamondListPageResponse = new BootRestMapResponse();
		diamondListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		diamondListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		diamondListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		diamondListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		diamondListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询用车订单记录列表】(BootCarOrderRecordController-selectCarOrderRecordListByPage)-返回信息, diamondListPageResponse:{}", diamondListPageResponse);
		return diamondListPageResponse;
	}

	/**
	 * 不分页查询用车订单记录列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @
	 */
	@RequestMapping(value="/selectCarOrderRecordList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCarOrderRecordList(
		@RequestBody CarOrderRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【不分页查询用车订单记录列表】(BootCarOrderRecordController-selectCarOrderRecordList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		CarOrderRecord carOrderRecord = new CarOrderRecord();
		List<CarOrderRecord> list = null;
		try {
			list = carOrderRecordService.selectCarOrderRecordList(carOrderRecord);
			logger.info("===step2:【不分页用车订单记录列表】(BootCarOrderRecordController-selectCarOrderRecordList)-不分页查询用车订单记录列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【不分页用车订单记录列表】(BootCarOrderRecordController-selectCarOrderRecordList)-不分页查询用车订单记录列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_LIST_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse diamondListResponse = new BootRestMapResponse();
		diamondListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【不分页查询用车订单记录列表】(BootCarOrderRecordController-selectCarOrderRecordList)-返回信息, diamondListResponse:{}", diamondListResponse);
		return diamondListResponse;
	}

	/**
	 * 根据id查询用车订单记录
	 * @param carOrderRecordId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectCarOrderRecordById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCarOrderRecordById(
		@PathVariable(value="id",required=false) Long carOrderRecordId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询用车订单记录】(BootCarOrderRecordController-selectCarOrderRecordById)-传入参数, carOrderRecordId:{}", carOrderRecordId);

		if(carOrderRecordId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "carOrderRecordId为空");
		}

		CarOrderRecord carOrderRecord = null;
		try {
			carOrderRecord = carOrderRecordService.selectCarOrderRecordById(carOrderRecordId);
			logger.info("===step2:【根据id查询用车订单记录】(BootCarOrderRecordController-selectCarOrderRecordById)-查询用车订单记录, carOrderRecord:{}", carOrderRecord);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询用车订单记录】(BootCarOrderRecordController-selectCarOrderRecordById)-查询用车订单记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(carOrderRecord == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST_MSG);
		}
		String content = carOrderRecord.getContent();

		BootRestMapResponse carOrderRecordResponse = new BootRestMapResponse();
		carOrderRecordResponse.putAll((JSONObject) JSONObject.toJSON(content));
		logger.info("===step3:【根据id查询用车订单记录】(BootCarOrderRecordController-selectCarOrderRecordById)-返回信息, carOrderRecordResponse:{}", carOrderRecordResponse);
		return carOrderRecordResponse;
	}

	/**
	 * 根据userId和orderTime查询用车订单记录
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectCarOrderRecordByUserId",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCarOrderRecordByUserId(
		@RequestBody CarOrderRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userId和orderTime查询用车订单记录】(BootCarOrderRecordController-selectCarOrderRecordByUserId)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		Date orderTime = req.getOrderTime();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}
		String orderTimeStr = "";
		 if(orderTime == null) {
			orderTimeStr = new LocalDate(orderTime).toString();
		} else {
			orderTimeStr = new LocalDate().toString();
		}

		CarOrderVo carOrderVo = null;
		try {
			carOrderVo = carOrderRecordService.selectCarOrderVoByUserId(userId, orderTimeStr);
			logger.info("===step2:【根据userId和orderTime查询用车订单记录】(BootCarOrderRecordController-selectCarOrderRecordByUserId)-根据userId和orderTime查询用车订单记录, carOrderVo:{}", carOrderVo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userId和orderTime查询用车订单记录】(BootCarOrderRecordController-selectCarOrderRecordByUserId)-根据userId和orderTime查询用车订单记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(carOrderVo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse carOrderRecordResponse = new BootRestMapResponse();
		carOrderRecordResponse.putAll((JSONObject) JSONObject.toJSON(carOrderVo));
		logger.info("===step3:【根据userId和orderTime查询用车订单记录】(BootCarOrderRecordController-selectCarOrderRecordByUserId)-返回信息, carOrderRecordResponse:{}", carOrderRecordResponse);
		return carOrderRecordResponse;
	}

	/**
	 * 插入用车订单记录
	 * @param req
 	 * @param request
	 * @param respons
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertCarOrderRecord",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertCarOrderRecord(
		@RequestBody CarOrderRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入用车订单记录】(BootCarOrderRecordController-insertCarOrderRecord)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String content = req.getContent();
		Long registryNo = req.getRegistryNo();
		Integer status = req.getStatus();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(StringUtils.isBlank(content)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "content为空");
		}

		CarOrderRecord carOrderRecord = new CarOrderRecord();
		carOrderRecord.setUserId(userId);
		carOrderRecord.setContent(content);
		carOrderRecord.setRegistryNo(registryNo);
		carOrderRecord.setStatus(status);
		int i = 0;
		try {
			i = carOrderRecordService.insertCarOrderRecord(carOrderRecord);
			logger.info("===step2:【插入用车订单记录】(BootCarOrderRecordController-insertCarOrderRecord)-插入用车订单记录-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【插入用车订单记录】(BootCarOrderRecordController-insertCarOrderRecord)-插入用车订单记录-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse carOrderRecordResponse = new BootRestMapResponse();
		carOrderRecordResponse.putAll((JSONObject) JSONObject.toJSON(carOrderRecord));
		logger.info("===step3:【插入用车订单记录】(BootCarOrderRecordController-insertCarOrderRecord)-返回信息, carOrderRecordResponse:{}", carOrderRecordResponse);
		return carOrderRecordResponse;
	}

	/**
	 * 修改用车订单记录
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyCarOrderRecord",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyCarOrderRecord(
		@RequestBody CarOrderRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改用车订单记录】(BootCarOrderRecordController-modifyCarOrderRecord)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Long carOrderRecordId = req.getCarOrderRecordId();
		String content = req.getContent();
		if(carOrderRecordId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "carOrderRecordId为空");
		}

		CarOrderRecord carOrderRecord = null;
		try {
			carOrderRecord = carOrderRecordService.selectCarOrderRecordById(carOrderRecordId);
			logger.info("===step2:【修改用车订单记录】(BootCarOrderRecordController-modifyCarOrderRecord)-根据carOrderRecordId查询用车订单记录, carOrderRecord:{}", carOrderRecord);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改用车订单记录】(BootCarOrderRecordController-modifyCarOrderRecord)-根据carOrderRecordId查询用车订单记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(carOrderRecord == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST_MSG);
		}

		carOrderRecord.setContent(content);
		int i = 0;
		try {
			i = carOrderRecordService.modifyCarOrderRecord(carOrderRecord);
			logger.info("===step3:【修改用车订单记录】(BootCarOrderRecordController-modifyCarOrderRecord)-修改用车订单记录-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改用车订单记录】(BootCarOrderRecordController-modifyCarOrderRecord)-修改用车订单记录-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse carOrderRecordResponse = new BootRestMapResponse();
		logger.info("===step4:【修改用车订单记录】(BootCarOrderRecordController-modifyCarOrderRecord)-返回信息, carOrderRecordResponse:{}", carOrderRecordResponse);
		return carOrderRecordResponse;
	}

	/**
	 * 修改用车订单记录状态失败
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyCarOrderRecordStatusFail",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyCarOrderRecordStatusFail(
		@RequestBody CarOrderRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改用车订单记录状态失败】(BootCarOrderRecordController-modifyCarOrderRecordSStatusFail)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Long carOrderRecordId = req.getCarOrderRecordId();
		if(carOrderRecordId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "carOrderRecordId为空");
		}

		CarOrderRecord carOrderRecord = null;
		try {
			carOrderRecord = carOrderRecordService.selectCarOrderRecordById(carOrderRecordId);
			logger.info("===step2:【修改用车订单记录状态失败】(BootCarOrderRecordController-modifyCarOrderRecordSStatusFail)-根据carOrderRecordId查询用车订单记录, carOrderRecord:{}", carOrderRecord);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改用车订单记录状态失败】(BootCarOrderRecordController-modifyCarOrderRecordSStatusFail)-根据carOrderRecordId查询用车订单记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(carOrderRecord == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST_MSG);
		}

		carOrderRecord.setStatus(SqlWheelConstants.SQL_CAR_ORDER_STATUS_FAIL);
		int i = 0;
		try {
			i = carOrderRecordService.modifyCarOrderRecord(carOrderRecord);
			logger.info("===step3:【修改用车订单记录状态失败】(BootCarOrderRecordController-modifyCarOrderRecordSStatusFail)-修改用车订单记录-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改用车订单记录状态失败】(BootCarOrderRecordController-modifyCarOrderRecordSStatusFail)-修改用车订单记录-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse carOrderRecordResponse = new BootRestMapResponse();
		logger.info("===step4:【修改用车订单记录状态失败】(BootCarOrderRecordController-modifyCarOrderRecord)-返回信息, carOrderRecordResponse:{}", carOrderRecordResponse);
		return carOrderRecordResponse;
	}

}