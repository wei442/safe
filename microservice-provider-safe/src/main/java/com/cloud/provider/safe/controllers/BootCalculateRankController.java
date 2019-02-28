package com.ochain.provider.wheel.controllers;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
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

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.PageConstants;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.param.CalculateRankParam;
import com.ochain.provider.wheel.po.CalculateRank;
import com.ochain.provider.wheel.rest.request.calculate.CalculateRankRequest;
import com.ochain.provider.wheel.service.IBootCalculateRankService;
import com.ochain.provider.wheel.util.PageRankUtil;
import com.ochain.provider.wheel.vo.calculate.CalculateRankContentListVo;
import com.ochain.provider.wheel.vo.calculate.CalculateRankContentVo;

/**
 * 算力排名 BootCalculateRankController
 * @author wang.tongmeng
 */
@RestController
@RequestMapping(value="/boot/calculateRank")
public class BootCalculateRankController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//算力排名Service
	@Autowired
	private IBootCalculateRankService calculateRankService;

	/**
	 * 分页查询算力排名列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateRankContentListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCalculateRankContentListByPage(
		@RequestBody CalculateRankRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Date rankTime = req.getRankTime();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		Page<CalculateRankContentVo> page = new Page<CalculateRankContentVo>(pageNum, pageSize);
		String pageNumStr = PageRankUtil.getPageNumStr(page);
		CalculateRankParam param = new CalculateRankParam();
		param.setPageNumStr(pageNumStr);
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		CalculateRankContentListVo calculateRankContentListVo = null;
		try {
			calculateRankContentListVo = calculateRankService.selectCalculateRankContentVoListByPage(page, param);
			logger.info("===step2:【分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentListByPage)-分页查询算力排名列表, calculateRankContentList.size:{}", calculateRankContentListVo == null? null:(calculateRankContentListVo.getCalculateRankContentList() == null ? null: calculateRankContentListVo.getCalculateRankContentList().size()));
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentListByPage)-分页查询算力排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(calculateRankContentListVo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST_MSG);
		}
		List<CalculateRankContentVo> calculateRankContentList = calculateRankContentListVo.getCalculateRankContentList();
		Date nowRankTime = calculateRankContentListVo.getRankTime();

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		calculateRankResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		calculateRankResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		calculateRankResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		calculateRankResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		calculateRankResponse.put("rankTime", nowRankTime);
		calculateRankResponse.put(PageConstants.DATA_LIST, calculateRankContentList);
		logger.info("===step3:【分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentListByPage)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 查询算力排名列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateRankContentList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCalculateRankList(
		@RequestBody CalculateRankRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Date rankTime = req.getRankTime();
		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		CalculateRankParam param = new CalculateRankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<CalculateRankContentVo> list = null;
		try {
			list = calculateRankService.selectCalculateRankContentVoList(param);
			logger.info("===step2:【分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentList)-查询算力排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentList)-查询算力排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		calculateRankResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentList)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 据id查询算力排名列表
	 * @param calculateId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateRankContentListById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCalculateRankContentListById(
		@PathVariable(value="id",required=false) Integer calculateRankId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据id查询算力排名列表】(selectCalculateRankById-selectCalculateRankContentListById)-传入参数, calculateRankId:{}", calculateRankId);

		if(calculateRankId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "id为空");
		}

		List<CalculateRankContentVo> list = null;
		try {
			list = calculateRankService.selectCalculateRankContentVoListById(calculateRankId);
			logger.info("===step2:【据id查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentListById)-根据id查询算力排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据id查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentListById)-根据id查询算力排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		calculateRankResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【据id查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentListById)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 根据日期查询算力排名
	 * @param rankDate
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateRankContentListByRankTime/{rankTime}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCalculateRankContentListByRankTime(
		@PathVariable(value="rankTime",required=false) Date rankTime,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据日期rankTime查询算力排名】(BootCalculateRankController-selectCalculateRankContentListByRankTime)-传入参数, rankTime:{}", rankTime);
		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		List<CalculateRankContentVo> list = null;
		try {
			list = calculateRankService.selectCalculateRankContentVoListByRankTime(rankTimeStr);
			logger.info("===step2:【根据rankTime查询算力排名】(BootCalculateRankController-selectCalculateRankContentListByRankTime)-根据rankTime查询算力排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据rankTime查询算力排名】(BootCalculateRankController-selectCalculateRankContentListByRankTime)-根据rankTime查询算力排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		calculateRankResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【根据rankTime查询算力排名】(BootCalculateRankController-selectCalculateRankContentListByRankTime)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 添加算力排名空内容数组
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertCalculateRankContentNullArray",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertCalculateRankContentNullArray(
		@RequestBody CalculateRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加算力排名空内容数组】(BootCalculateRankController-insertCalculateRankContentNullArray)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Date rankTime = new Date();

		CalculateRank calculateRank = new CalculateRank();
		calculateRank.setContent(new JSONArray().toJSONString());
		calculateRank.setRankTime(rankTime);
		try {
			int i = calculateRankService.insertCalculateRankContentNullArray(calculateRank);
			logger.info("===step2:【【添加算力排名空内容数组】(BootCalculateRankController-insertCalculateRankContentNullArray)-插入算力排名空内容数组, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加算力排名空内容数组】(BootCalculateRankController-insertCalculateRankContentNullArray)-插入算力排名空内容数组-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		Integer calculateRankId = calculateRank.getCalculateRankId();

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		calculateRankResponse.put("calculateRankId", calculateRankId);
		logger.info("===step4:【添加算力排名】(BootCalculateRankController-insertCalculateRankContentNullArray)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 修改算力排名内容
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyCalculateRankContent",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyCalculateRankContent(
		@RequestBody CalculateRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改算力排名内容】(BootCalculateRankController-modifyCalculateRankContent)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String userAccount = req.getUserAccount();
	    Integer calculate = req.getCalculate();
	    Integer sort = req.getSort();
	    String sortTime = req.getSortTime();
	    Double percent = req.getPercent();
	    Integer calculateRankId = req.getCalculateRankId();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userId为空");
		} else if(calculateRankId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "calculateRankId为空");
		}

		CalculateRankContentVo calculateRankContentVo = new CalculateRankContentVo();
		calculateRankContentVo.setUserId(userId);
		calculateRankContentVo.setUserAccount(userAccount);
		calculateRankContentVo.setCalculate(calculate);
		calculateRankContentVo.setPercent(percent);
		calculateRankContentVo.setSort(sort);
		calculateRankContentVo.setSortTime(sortTime);
		int i = 0;
		try {
			i = calculateRankService.modifyCalculateRankContent(calculateRankId, calculateRankContentVo);
			logger.info("===step2:【【修改算力排名内容】(BootCalculateRankController-modifyCalculateRankContent)-修改算力排名内容, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改算力排名内容】(BootCalculateRankController-modifyCalculateRankContent)-修改算力排名内容-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		logger.info("===step4:【修改算力排名内容】(BootCalculateRankController-modifyCalculateRankContent)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 根据userAccount分页查询算力排名
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateRankContentListByUserAccount")
	@ResponseBody
	public BootRestMapResponse selectCalculateRankContentListByUserAccount(
		@RequestBody CalculateRankRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【根据userAccount分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentByUserAccount)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Date rankTime = req.getRankTime();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		String userAccount = req.getUserAccount();
		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		Page<CalculateRankContentVo> page = new Page<CalculateRankContentVo>(pageNum, pageSize);
		CalculateRankParam param = new CalculateRankParam();
		param.setUserAccount(userAccount);
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<CalculateRankContentVo> list = null;
		try {
			list = calculateRankService.selectCalculateRankContentVoListUserAccount(page, param);
			logger.info("===step2:【根据userAccount分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentByUserAccount)-分页查询 算力排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userAccount分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentByUserAccount)-分页查询 算力排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_RANK_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		calculateRankResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		calculateRankResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		calculateRankResponse.put(PageConstants.TOTAL_COUNT, 1);
		calculateRankResponse.put(PageConstants.TOTAL_PAGES, 1);
		calculateRankResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【根据userAccount分页查询算力排名列表】(BootCalculateRankController-selectCalculateRankContentByUserAccount)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 根据userAccount查询算力排名列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateRankListByPageUserAccount")
	@ResponseBody
	public BootRestMapResponse selectCalculateRankListByPageUserAccount(
		@RequestBody CalculateRankRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【根据userAccount查询算力排名列表】(BootCalculateRankController-selectCalculateRankListByUserAccount)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		Date rankTime = req.getRankTime();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();
		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		CalculateRankParam param = new CalculateRankParam();
		param.setUserAccount(userAccount);
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<CalculateRank> list = null;
		try {
			list = calculateRankService.selectCalculateRankListByUserAccount(param);
			logger.info("===step2:【根据userAccount查询算力排名列表】(BootCalculateRankController-selectCalculateRankListByUserAccount)-根据userAccount查询算力排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userAccount查询算力排名】(BootCalculateRankController-selectCalculateRankListByUserAccount)-根据userAccount查询算力排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RANK_LIST_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RANK_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		calculateRankResponse.put(PageConstants.PAGE_NUM, pageNum);
		calculateRankResponse.put(PageConstants.PAGE_SIZE, pageSize);
		calculateRankResponse.put(PageConstants.TOTAL_COUNT, 1);
		calculateRankResponse.put(PageConstants.TOTAL_PAGES, 1);
		calculateRankResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【根据userAccount查询算力排名】(BootCalculateRankController-selectCalculateRankListByUserAccount)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 根据userAccount查询算力排名
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateRankByUserAccount")
	@ResponseBody
	public BootRestMapResponse selectCalculateRankByUserAccount(
		@RequestBody CalculateRankRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【根据userAccount查询算力排名】(BootCalculateRankController-selectCalculateRankByUserAccount)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		Date rankTime = req.getRankTime();
		if(StringUtils.isBlank(userAccount)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userAccount为空");
		}
		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		CalculateRankParam param = new CalculateRankParam();
		param.setUserAccount(userAccount);
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		CalculateRank calculateRank = null;
		try {
			calculateRank = calculateRankService.selectCalculateRankByUserAccount(param);
			logger.info("===step2:【根据userAccount查询算力排名】(BootCalculateRankController-selectCalculateRankByUserAccount)-根据userAccount查询算力排名, calculateRank:{}", calculateRank);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userAccount查询算力排名】(BootCalculateRankController-selectCalculateRankByUserAccount)-根据userAccount查询算力排名-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(calculateRank == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RANK_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RANK_ENTITY_NOTEXIST_MSG);
		}
		String content = Objects.toString(calculateRank.getContent(), "");

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		if(StringUtils.isNotBlank(content)) {
			calculateRankResponse.putAll(JSONObject.parseObject(content));
		}
		logger.info("===step3:【根据userAccount查询算力排名】(BootCalculateRankController-selectCalculateRankByUserAccount)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 根据userId查询算力排名
	 * @param userId
	 * @param rankTime
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectCalculateRankContentByUserId",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectCalculateRankContentByUserId(
		@RequestBody CalculateRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userId查询算力排名】(BootCalculateRankController-selectCalculateRankContentByUserId)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		Date rankTime = req.getRankTime();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userId为空");
		}
		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		CalculateRankParam param = new CalculateRankParam();
		param.setUserId(userId);
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);

		CalculateRank calculateRank = null;
		try {
			calculateRank = calculateRankService.selectCalculateRankByUserId(param);
			logger.info("===step2:【根据userId查询算力排名】(BootCalculateRankController-selectCalculateRankContentByUserId)-根据userId查询算力排名, calculateRank:{}", calculateRank);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userId查询算力排名】(BootCalculateRankController-selectCalculateRankContentByUserId)-根据userId查询算力排名-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(calculateRank == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_CALCULATE_RANK_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_CALCULATE_RANK_ENTITY_NOTEXIST_MSG);
		}
		Object content = calculateRank.getContent();

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		calculateRankResponse.putAll((JSONObject) JSONObject.toJSON(content));
		logger.info("===step3:【根据userId查询算力排名】(BootCalculateRankController-selectCalculateRankContentByUserId)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

	/**
	 * 根据rankTimeStr删除算力排名
	 * @param rankTime
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/deleteCalculateRankByRankTime/{rankTimeStr}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse deleteCalculateRankByRankTime(
		@PathVariable(value="rankTimeStr",required=false) String rankTimeStr,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据rankTimeStr删除算力排名】(BootRankController-deleteCalculateRankByRankTime)-传入参数, rankTimeStr:{}", rankTimeStr);

		if(StringUtils.isBlank(rankTimeStr)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "rankTimeStr为空");
		}

		int i = 0;
		try {
			i = calculateRankService.deleteCalculateRankByRankTime(rankTimeStr);
			logger.info("===step2:【根据rankTimeStr删除算力排名】(BootRankController-deleteCalculateRankByRankTime)-根据rankTimeStr删除算力排名, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据rankTimeStr删除算力排名】(BootRankController-deleteCalculateRankByRankTime)-根据rankTimeStr删除算力排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}

		Date sevenDaysDateTime = new DateTime().minus(Period.days(7)).toDate();
		try {
			i = calculateRankService.deleteCalculateRankByBeforeRankTime(sevenDaysDateTime);
			logger.info("===step3:【根据rankTimeStr删除算力排名】(BootRankController-deleteCalculateRankByRankTime)-删除7天前的算力排名, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【根据rankTimeStr删除算力排名】(BootRankController-deleteCalculateRankByRankTime)-删除7天前的算力排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}

		BootRestMapResponse calculateRankResponse = new BootRestMapResponse();
		logger.info("===step6:【根据rankTimeStr删除算力排名】(BootRankController-deleteCalculateRankByRankTime)-返回信息, calculateRankResponse:{}", calculateRankResponse);
		return calculateRankResponse;
	}

}