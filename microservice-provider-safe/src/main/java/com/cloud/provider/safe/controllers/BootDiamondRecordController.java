package com.ochain.provider.wheel.controllers;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.LocalDate;
import org.joda.time.Period;
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
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.po.DiamondRecord;
import com.ochain.provider.wheel.pool.LocationPool;
import com.ochain.provider.wheel.rest.request.diamond.DiamondRecordRequest;
import com.ochain.provider.wheel.service.IBootCarOrderRecordService;
import com.ochain.provider.wheel.service.IBootDiamondRecordService;
import com.ochain.provider.wheel.vo.gofun.AreaVo;
import com.ochain.provider.wheel.vo.gofun.CarOrderVo;

/**
 * 能量记录 BootDiamondRecordController
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/diamondRecord")
public class BootDiamondRecordController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//能量记录 Service
	@Autowired
	private IBootDiamondRecordService diamondRecordService;

	//用车订单记录 Service
	@Autowired
	private IBootCarOrderRecordService carOrderRecordService;

	//地域连接池
	@Autowired
	private LocationPool locationPool;

	/**
	 * 分页查询能量记录列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondRecordListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondRecordListByPage(
		@RequestBody DiamondRecordRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询能量记录列表】(BootDiamondRecordController-selectDiamondRecordListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		DiamondRecord diamondRecord = new DiamondRecord();
		diamondRecord.setUserId(userId);

		Page<DiamondRecord> page = new Page<DiamondRecord>(pageNum, pageSize);
		List<DiamondRecord> list = null;
		try {
			list = diamondRecordService.selectDiamondRecordListByPage(page, diamondRecord);
			logger.info("===step2:【分页查询能量记录列表】(BootDiamondRecordController-selectDiamondRecordListByPage)-分页查询 能量记录列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询能量记录列表】(BootDiamondRecordController-selectDiamondRecordListByPage)-分页查询 能量记录列表-异常, Exception = {}, message = {}",e,e.getMessage());
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
		logger.info("===step3:【分页查询能量记录列表】(BootDiamondRecordController-selectDiamondRecordListByPage)-返回信息, diamondListPageResponse:{}", diamondListPageResponse);
		return diamondListPageResponse;
	}

	/**
	 * 不分页查询能量记录列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondRecordList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondRecordList(
		@RequestBody DiamondRecordRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【不分页查询能量记录列表】(BootDiamondRecordController-selectDiamondRecordList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		DiamondRecord diamondRecord = new DiamondRecord();
		List<DiamondRecord> list = null;
		try {
			list = diamondRecordService.selectDiamondRecordList(diamondRecord);
			logger.info("===step2:【不分页能量记录列表】(BootDiamondRecordController-selectDiamondRecordList)-不分页查询能量记录列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【不分页能量记录列表】(BootDiamondRecordController-selectDiamondRecordList)-不分页查询能量记录列表-异常, Exception = {}, message = {}",e,e.getMessage());
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
		logger.info("===step3:【不分页查询能量记录列表】(BootDiamondRecordController-selectDiamondRecordList)-返回信息, diamondListResponse:{}", diamondListResponse);
		return diamondListResponse;
	}

	/**
	 * 查询3天前未领取的能量方块数据列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondRecordListByThreeDays",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondRecordListByThreeDays(
		@RequestBody DiamondRecordRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询3天前未领取的能量方块数据列表】(BootDiamondRecordController-selectDiamondRecordListByThreeDays)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		}

		List<DiamondRecord> list = null;
		try {
			list = diamondRecordService.selectDiamondRecordListByThreeDays(userId);
			logger.info("===step2:【查询3天前未领取的能量方块数据列表】(BootDiamondRecordController-selectDiamondRecordListByThreeDays)-根据userId查询3天前未领取的能量方块数据列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【查询3天前未领取的能量方块数据列表】(BootDiamondRecordController-selectDiamondRecordListByThreeDays)-根据userId查询3天前未领取的能量方块数据列表-异常, Exception = {}, message = {}",e,e.getMessage());
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
		logger.info("===step3:【查询3天前未领取的能量方块数据列表】(BootDiamondRecordController-selectDiamondRecordListByThreeDays)-返回信息, diamondListResponse:{}", diamondListResponse);
		return diamondListResponse;
	}

	/**
	 * 根据id查询能量记录
	 * @param diamondRecordId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectDiamondRecordById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondRecordById(
		@PathVariable(value="id",required=false) Long diamondRecordId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据id查询能量记录】(BootDiamondRecordController-selectDiamondRecordById)-传入参数, diamondRecordId:{}", diamondRecordId);

		if(diamondRecordId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamondRecordId为空");
		}

		DiamondRecord diamondRecord = null;
		try {
			diamondRecord = diamondRecordService.selectDiamondRecordById(diamondRecordId);
			logger.info("===step2:【根据id查询能量记录】(BootDiamondRecordController-selectDiamondRecordById)-查询能量记录, diamondRecord:{}", diamondRecord);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据id查询能量记录】(BootDiamondRecordController-selectDiamondRecordById)-查询能量记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(diamondRecord == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse diamondRecordResponse = new BootRestMapResponse();
		diamondRecordResponse.putAll((JSONObject) JSONObject.toJSON(diamondRecord));
		logger.info("===step3:【根据id查询能量记录】(BootDiamondRecordController-selectDiamondRecordById)-返回信息, diamondRecordResponse:{}", diamondRecordResponse);
		return diamondRecordResponse;
	}

	/**
	 * 插入能量记录
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertDiamondRecord",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertDiamondRecord(
		@RequestBody DiamondRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入能量记录】(BootDiamondRecordController-insertDiamondRecord)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
	    String diamondCode = req.getDiamondCode();
	    String diamondName = req.getDiamondName();
		Integer diamondType = req.getDiamondType();
		BigDecimal diamond = req.getDiamond();
		Long registryNo = req.getRegistryNo();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(diamondCode == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamondCode为空");
		}
		//发放能量方块大于0才进行发币
		if(diamond.compareTo(new BigDecimal("0")) <=0) {
			logger.info("===step1.1:【插入能量记录】(BootDiamondRecordController-insertDiamondRecord)-发放能量方块小于等于0-直接返回");
			return new BootRestMapResponse();
		}

		CarOrderVo carOrderVo = null;
		LocalDate localDate = new LocalDate();
		String todayOrderTimeStr = localDate.toString();
		//今日
		try {
			carOrderVo = carOrderRecordService.selectCarOrderVoByUserId(userId, todayOrderTimeStr);
			logger.info("===step2:【插入能量记录】(BootDiamondRecordController-insertDiamondRecord)-根据userId和todayOrderTimeStr查询今天用户订单记录-返回, carOrderVo = {}", carOrderVo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【插入能量记录】(BootDiamondRecordController-insertDiamondRecord)-根据userId和todayOrderTimeStr查询今天用户订单记录-异常, Exception = {}, message = {}", e, e.getMessage());
		}

		//昨日
		if(carOrderVo == null) {
			String yesterdayOrderTimeStr = localDate.minus(Period.days(1)).toString();
			try {
				carOrderVo = carOrderRecordService.selectCarOrderVoByUserId(userId, yesterdayOrderTimeStr);
				logger.info("===step2.2:【插入能量记录】(BootDiamondRecordController-insertDiamondRecord)-根据userId和yesterdayOrderTimeStr查询昨日用户订单记录-返回, carOrderVo = {}", carOrderVo);
			} catch (BootServiceException e) {
				logger.error("===step2.3:【插入能量记录】(BootDiamondRecordController-insertDiamondRecord)-根据userId和yesterdayOrderTimeStr查询昨日用户订单记录-异常, Exception = {}, message = {}", e, e.getMessage());
			}
		}

		String location = "";
		if(carOrderVo != null) {
			List<AreaVo> areaList = carOrderVo.getArea();
			if(areaList != null && !areaList.isEmpty()) {
				int size = areaList.size();
				int index = RandomUtils.nextInt(0, size);
				AreaVo areaVo = (AreaVo) CollectionUtils.get(areaList, index);
				location = areaVo.getBusinessAreaName();
			} else {
				location = locationPool.get();
			}
		} else {
			location = locationPool.get();
		}

		DiamondRecord diamondRecord = new DiamondRecord();
		diamondRecord.setUserId(userId);
		diamondRecord.setDiamondCode(diamondCode);
		diamondRecord.setDiamondName(diamondName);
		diamondRecord.setDiamondType(diamondType);
		diamondRecord.setDiamond(diamond);
		diamondRecord.setLocation(location);
		diamondRecord.setRegistryNo(registryNo);
		int i = 0;
		try {
			i = diamondRecordService.insertDiamondRecord(diamondRecord);
			logger.info("===step3:【插入能量记录】(BootDiamondRecordController-insertDiamondRecord)-插入能量记录-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【插入能量记录】(BootDiamondRecordController-insertDiamondRecord)-插入能量记录-异常, Exception = {}, message = {}", e, e.getMessage());
		}

		BootRestMapResponse diamondRecordResponse = new BootRestMapResponse();
		diamondRecordResponse.putAll((JSONObject) JSONObject.toJSON(diamondRecord));
		logger.info("===step4:【插入能量记录】(BootDiamondRecordController-insertDiamondRecord)-返回信息, diamondRecordResponse:{}", diamondRecordResponse);
		return diamondRecordResponse;
	}

	/**
	 * 插入固定发放能量记录
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertFixDiamondRecord",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertFixDiamondRecord(
		@RequestBody DiamondRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入固定发放能量记录】(BootDiamondRecordController-insertFixDiamondRecord)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
	    String diamondCode = req.getDiamondCode();
	    String diamondName = req.getDiamondName();
		Integer diamondType = req.getDiamondType();
		BigDecimal diamond = req.getDiamond();
		Long registryNo = req.getRegistryNo();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "userId为空");
		} else if(diamondCode == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamondCode为空");
		}

		//发放能量方块大于0才进行发币
		if(diamond.compareTo(new BigDecimal("0")) <=0) {
			logger.info("===step1.1:【插入固定发放能量记录】(BootDiamondRecordController-insertFixDiamondRecord)-发放能量方块小于等于0-直接返回");
			return new BootRestMapResponse();
		}

		CarOrderVo carOrderVo = null;
		LocalDate localDate = new LocalDate();
		String todayOrderTimeStr = localDate.toString();
		//今日
		try {
			carOrderVo = carOrderRecordService.selectCarOrderVoByUserId(userId, todayOrderTimeStr);
			logger.info("===step2:【插入固定发放能量记录】(BootDiamondRecordController-insertFixDiamondRecord)-根据userId和todayOrderTimeStr查询用户订单记录-返回, carOrderVo = {}", carOrderVo);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【插入固定发放能量记录】(BootDiamondRecordController-insertFixDiamondRecord)-根据userId和todayOrderTimeStr查询用户订单记录-异常, Exception = {}, message = {}", e, e.getMessage());
		}

		if(carOrderVo == null) {
			//昨日
			String yesterdayOrderTimeStr = localDate.minus(Period.days(1)).toString();
			try {
				carOrderVo = carOrderRecordService.selectCarOrderVoByUserId(userId, yesterdayOrderTimeStr);
				logger.info("===step2.2:【插入固定发放能量记录】(BootDiamondRecordController-insertFixDiamondRecord)-根据userId和yesterdayOrderTimeStr查询用户订单记录-返回, carOrderVo = {}", carOrderVo);
			} catch (BootServiceException e) {
				logger.error("===step2.3:【插入固定发放能量记录】(BootDiamondRecordController-insertFixDiamondRecord)-根据userId和yesterdayOrderTimeStr查询用户订单记录-异常, Exception = {}, message = {}", e, e.getMessage());
			}
		}

		String location = "";
		if(carOrderVo != null) {
			List<AreaVo> areaList = carOrderVo.getArea();
			if(areaList != null && !areaList.isEmpty()) {
				int size = areaList.size();
				int index = RandomUtils.nextInt(0, size);
				AreaVo areaVo = (AreaVo) CollectionUtils.get(areaList, index);
				location = areaVo.getBusinessAreaName();
			} else {
				location = locationPool.get();
			}
		} else {
			location = locationPool.get();
		}

		DiamondRecord diamondRecord = new DiamondRecord();
		diamondRecord.setUserId(userId);
		diamondRecord.setDiamondCode(diamondCode);
		diamondRecord.setDiamondName(diamondName);
		diamondRecord.setDiamondType(diamondType);
		diamondRecord.setDiamond(diamond);
		diamondRecord.setLocation(location);
		diamondRecord.setRegistryNo(registryNo);
		int i = 0;
		try {
			i = diamondRecordService.insertDiamondRecord(diamondRecord);
			logger.info("===step3:【插入固定发放能量记录】(BootDiamondRecordController-insertFixDiamondRecord)-插入能量记录-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【插入固定发放能量记录】(BootDiamondRecordController-insertFixDiamondRecord)-插入能量记录-异常, Exception = {}, message = {}", e, e.getMessage());
		}

		BootRestMapResponse diamondRecordResponse = new BootRestMapResponse();
		diamondRecordResponse.putAll((JSONObject) JSONObject.toJSON(diamondRecord));
		logger.info("===step4:【插入固定发放能量记录】(BootDiamondRecordController-insertFixDiamondRecord)-返回信息, diamondRecordResponse:{}", diamondRecordResponse);
		return diamondRecordResponse;
	}


	/**
	 * 修改能量记录
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyDiamondRecord",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyDiamondRecord(
		@RequestBody DiamondRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改能量记录】(BootDiamondRecordController-modifyDiamondRecord)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Long diamondRecordId = req.getDiamondRecordId();
		Integer userId = req.getUserId();
	    String diamondCode = req.getDiamondCode();
	    String diamondName = req.getDiamondName();
	    Integer diamondType = req.getDiamondType();
	    BigDecimal diamond = req.getDiamond();
	    String location = req.getLocation();
		if(diamondRecordId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamondRecordId为空");
		}

		DiamondRecord diamondRecord = null;
		try {
			diamondRecord = diamondRecordService.selectDiamondRecordById(diamondRecordId);
			logger.info("===step2:【修改能量记录】(BootDiamondRecordController-modifyDiamondRecord)-根据diamondRecordId查询能量记录, diamondRecord:{}", diamondRecord);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改能量记录】(BootDiamondRecordController-modifyDiamondRecord)-根据diamondRecordId查询能量记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(diamondRecord == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST_MSG);
		}

		diamondRecord.setUserId(userId);
		diamondRecord.setDiamondCode(diamondCode);
		diamondRecord.setDiamondName(diamondName);
		diamondRecord.setDiamondType(diamondType);
		diamondRecord.setDiamond(diamond);
		diamondRecord.setLocation(location);
		int i = 0;
		try {
			i = diamondRecordService.modifyDiamondRecord(diamondRecord);
			logger.info("===step3:【修改能量记录】(BootDiamondRecordController-modifyDiamondRecord)-修改能量记录-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改能量记录】(BootDiamondRecordController-modifyDiamondRecord)-修改能量记录-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse diamondRecordResponse = new BootRestMapResponse();
		logger.info("===step4:【修改能量记录】(BootDiamondRecordController-modifyDiamondRecord)-返回信息, diamondRecordResponse:{}", diamondRecordResponse);
		return diamondRecordResponse;
	}

	/**
	 * 领取能量记录
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/drawDiamondRecord",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse drawDiamondRecord(
		@RequestBody DiamondRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【领取能量记录】(BootDiamondRecordController-drawDiamondRecord)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Long diamondRecordId = req.getDiamondRecordId();
		Date drawTime = req.getDrawTime();
		if(diamondRecordId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamondRecordId为空");
		}

		DiamondRecord diamondRecord = null;
		try {
			diamondRecord = diamondRecordService.selectDiamondRecordById(diamondRecordId);
			logger.info("===step2:【领取能量记录】(BootDiamondRecordController-drawDiamondRecord)-根据diamondRecordId查询能量记录, diamondRecord:{}", diamondRecord);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【领取能量记录】(BootDiamondRecordController-drawDiamondRecord)-根据diamondRecordId查询能量记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(diamondRecord == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST_MSG);
		}
		Date createTime = diamondRecord.getCreateTime();
		Integer isUse = diamondRecord.getIsUse();
		if(SqlWheelConstants.SQL_DIAMOND_RECORD_IS_USE_YES.equals(isUse)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_DRAW_HAS, BootWheelConstants.WHEEL_DIAMOND_RECORD_DRAW_HAS_MSG);
		}

		isUse = SqlWheelConstants.SQL_DIAMOND_RECORD_IS_USE_YES;
		if(drawTime != null && drawTime.compareTo(createTime) <0) {
			isUse = SqlWheelConstants.SQL_DIAMOND_RECORD_IS_USE_FAIL;
			StringBuffer str = new StringBuffer();
			str.append("领取时间("+DateFormatUtils.format(drawTime, DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)+")");
			str.append("小于3天前的创建时间("+DateFormatUtils.format(createTime, DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS)+")");
			diamondRecord.setRemark(str.toString());
		}

		diamondRecord.setIsUse(isUse);
		diamondRecord.setUseTime(new Date());
		int i = 0;
		try {
			i = diamondRecordService.modifyDiamondRecord(diamondRecord);
			logger.info("===step3:【领取能量记录】(BootDiamondRecordController-drawDiamondRecord)-领取能量记录-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【领取能量记录】(BootDiamondRecordController-drawDiamondRecord)-领取能量记录-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(SqlWheelConstants.SQL_DIAMOND_RECORD_IS_USE_FAIL.equals(isUse)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_DRAW_FAIL, BootWheelConstants.WHEEL_DIAMOND_RECORD_DRAW_FAIL_MSG);
		}

		BootRestMapResponse diamondRecordResponse = new BootRestMapResponse();
		logger.info("===step4:【领取能量记录】(BootDiamondRecordController-drawDiamondRecord)-返回信息, diamondRecordResponse:{}", diamondRecordResponse);
		return diamondRecordResponse;
	}

	/**
	 * 修改能量记录状态失败
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/modifyDiamondRecordStatusFail",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyDiamondRecordStatusFail(
		@RequestBody DiamondRecordRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改能量记录状态失败】(BootDiamondRecordController-modifyDiamondRecordStatusFail)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Long diamondRecordId = req.getDiamondRecordId();
		if(diamondRecordId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "diamondRecordId为空");
		}

		DiamondRecord diamondRecord = null;
		try {
			diamondRecord = diamondRecordService.selectDiamondRecordById(diamondRecordId);
			logger.info("===step2:【修改能量记录状态失败】(BootDiamondRecordController-modifyDiamondRecordStatusFail)-根据diamondRecordId查询能量记录, diamondRecord:{}", diamondRecord);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改能量记录状态失败】(BootDiamondRecordController-modifyDiamondRecordStatusFail)-根据diamondRecordId查询能量记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
		}
		if(diamondRecord == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RECORD_ENTITY_NOTEXIST_MSG);
		}

		diamondRecord.setStatus(SqlWheelConstants.SQL_DIAMOND_RECORD_STATUS_FAIL);
		int i = 0;
		try {
			i = diamondRecordService.modifyDiamondRecord(diamondRecord);
			logger.info("===step3:【修改能量记录状态失败】(BootDiamondRecordController-modifyDiamondRecordStatusFail)-修改能量记录-返回, i = {}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【修改能量记录状态失败】(BootDiamondRecordController-modifyDiamondRecordStatusFail)-修改能量记录-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse diamondRecordResponse = new BootRestMapResponse();
		logger.info("===step4:【修改能量记录状态失败】(BootDiamondRecordController-modifyDiamondRecord)-返回信息, diamondRecordResponse:{}", diamondRecordResponse);
		return diamondRecordResponse;
	}

}