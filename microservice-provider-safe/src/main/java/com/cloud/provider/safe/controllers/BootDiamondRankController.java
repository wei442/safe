package com.ochain.provider.wheel.controllers;

import java.math.BigDecimal;
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
import com.ochain.provider.wheel.param.DiamondRankParam;
import com.ochain.provider.wheel.po.DiamondRank;
import com.ochain.provider.wheel.rest.request.diamond.DiamondRankRequest;
import com.ochain.provider.wheel.service.IBootDiamondRankService;
import com.ochain.provider.wheel.util.PageRankUtil;
import com.ochain.provider.wheel.vo.diamond.DiamondRankContentListVo;
import com.ochain.provider.wheel.vo.diamond.DiamondRankContentVo;


/**
 * 能量排名 BootDiamondRankController
 * @author wang.tongmeng
 */
@RestController
@RequestMapping(value="/boot/diamondRank")
public class BootDiamondRankController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//能量排名Service
	@Autowired
	private IBootDiamondRankService diamondRankService;

	/**
	 * 分页查询能量排名列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondRankContentListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondRankContentListByPage(
		@RequestBody DiamondRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Date rankTime = req.getRankTime();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		Page<DiamondRankContentVo> page = new Page<DiamondRankContentVo>(pageNum, pageSize);
		String pageNumStr = PageRankUtil.getPageNumStr(page);
		DiamondRankParam param = new DiamondRankParam();
		param.setPageNumStr(pageNumStr);
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		DiamondRankContentListVo diamondRankContentListVo = null;
		try {
			diamondRankContentListVo = diamondRankService.selectDiamondRankContentVoListByPage(page, param);
			logger.info("===step2:【分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentListByPage)-分页查询能量排名列表, diamondRankContentList.size:{}", diamondRankContentListVo == null? null:(diamondRankContentListVo.getDiamondRankContentList() == null ? null: diamondRankContentListVo.getDiamondRankContentList().size()));
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentListByPage)-分页查询能量排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(diamondRankContentListVo == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RANK_LIST_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RANK_LIST_NOTEXIST_MSG);
		}
		List<DiamondRankContentVo> diamondRankContentList = diamondRankContentListVo.getDiamondRankContentList();
		Date nowRankTime = diamondRankContentListVo.getRankTime();

		BootRestMapResponse diamondRankResponse = new BootRestMapResponse();
		diamondRankResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		diamondRankResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		diamondRankResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		diamondRankResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		diamondRankResponse.put("rankTime", nowRankTime);
		diamondRankResponse.put(PageConstants.DATA_LIST, diamondRankContentList);
		logger.info("===step3:【分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentListByPage)-返回信息, diamondRankResponse:{}", diamondRankResponse);
		return diamondRankResponse;
	}

	/**
	 * 查询能量排名列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondRankContentList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondRankContentList(
		@RequestBody DiamondRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Date rankTime = req.getRankTime();
		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		DiamondRankParam param = new DiamondRankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<DiamondRankContentVo> list = null;
		try {
			list = diamondRankService.selectDiamondRankContentVoList(param);
			logger.info("===step2:【分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentList)-查询能量排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentList)-查询能量排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
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

		BootRestMapResponse diamondRankResponse = new BootRestMapResponse();
		diamondRankResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentList)-返回信息, diamondRankResponse:{}", diamondRankResponse);
		return diamondRankResponse;
	}

	/**
	 * 根据rankTime查询能量排名列表
	 * @param rankTime
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondRankContentListByRankTime/{rankTime}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectDiamondRankByRankTime(
		@PathVariable(value="rankTime",required=false) Date rankTime,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据rankTime查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentListByRankTime)-传入参数, rankTime:{}", rankTime);

		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		List<DiamondRankContentVo> list = null;
		try {
			list = diamondRankService.selectDiamondRankContentVoListByRankTime(rankTimeStr);
			logger.info("===step2:【根据rankTime查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentListByRankTime)-根据rankTime查询能量排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据rankTime查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentListByRankTime)-根据rankTime查询能量排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
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

		BootRestMapResponse diamondRankResponse = new BootRestMapResponse();
		diamondRankResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【根据rankTime查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentListByRankTime)-返回信息, diamondRankResponse:{}", diamondRankResponse);
		return diamondRankResponse;
	}

	/**
	 * 添加能量排名空内容数组
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/insertDiamondRankContentNullArray",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertDiamondRankContentNullArray(
		@RequestBody DiamondRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【添加能量排名空内容数组】(BootDiamondRankController-insertDiamondRankContentNullArray)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		DiamondRank diamondRank = new DiamondRank();
		diamondRank.setContent(new JSONArray().toJSONString());
		diamondRank.setRankTime(new Date());
		try {
			int i = diamondRankService.insertDiamondRankContentNullArray(diamondRank);
			logger.info("===step2:【添加能量排名空内容数组】(BootDiamondRankController-insertDiamondRankContentNullArray)-插入能量排名空内容数组, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【添加能量排名空内容数组】(BootDiamondRankController-insertDiamondRankContentNullArray)-插入能量排名空内容数组-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		Integer diamondRankId = diamondRank.getDiamondRankId();

		BootRestMapResponse diamondRankResponse = new BootRestMapResponse();
		diamondRankResponse.put("diamondRankId", diamondRankId);
		logger.info("===step3:【添加能量排名空内容数组】(BootDiamondRankController-insertDiamondRankContentNullArray)-返回信息, diamondRankResponse:{}", diamondRankResponse);
		return diamondRankResponse;
	}

	/**
	 * 修改能量排名内容
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/modifyDiamondRankContent",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse modifyDiamondRankContent(
		@RequestBody DiamondRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【修改能量排名内容】(BootDiamondRankController-modifyDiamondRankContent)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userId = req.getUserId();
		String userAccount = req.getUserAccount();
		BigDecimal diamond = req.getDiamond();
	    Integer sort = req.getSort();
	    String sortTime = req.getSortTime();
	    Integer diamondRankId = req.getDiamondRankId();
		if(userId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "userId为空");
		}

		DiamondRankContentVo diamondRankContentVo = new DiamondRankContentVo();
		diamondRankContentVo.setUserId(userId);
		diamondRankContentVo.setUserAccount(userAccount);
		diamondRankContentVo.setDiamond(diamond);
		diamondRankContentVo.setSort(sort);
		diamondRankContentVo.setSortTime(sortTime);
		try {
			diamondRankId = diamondRankService.modifyDiamondRankContent(diamondRankId, diamondRankContentVo);
			logger.info("===step2:【修改能量排名内容】(BootDiamondRankController-modifyDiamondRankContent)-修改能量排名内容, diamondRankId:{}", diamondRankId);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【修改能量排名内容】(BootDiamondRankController-modifyDiamondRankContent)-修改能量排名内容-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse diamondRankResponse = new BootRestMapResponse();
		logger.info("===step3:【修改能量排名内容】(BootDiamondRankController-modifyDiamondRankContent)-返回信息, diamondRankResponse:{}", diamondRankResponse);
		return diamondRankResponse;
	}

	/**
	 * 根据userAccount分页查询能量排名
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondRankContentListByUserAccount")
	@ResponseBody
	public BootRestMapResponse selectDiamondRankContentListByUserAccount(
		@RequestBody DiamondRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userAccount分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentByUserAccount)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

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
		Page<DiamondRankContentVo> page = new Page<DiamondRankContentVo>(pageNum, pageSize);
		DiamondRankParam param = new DiamondRankParam();
		param.setUserAccount(userAccount);
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<DiamondRankContentVo> list = null;
		try {
			list = diamondRankService.selectDiamondRankContentVoListUserAccount(page, param);
			logger.info("===step2:【根据userAccount分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentByUserAccount)-分页查询 能量排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userAccount分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentByUserAccount)-分页查询 能量排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
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
		BootRestMapResponse diamondRankResponse = new BootRestMapResponse();
		diamondRankResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		diamondRankResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		diamondRankResponse.put(PageConstants.TOTAL_COUNT, 1);
		diamondRankResponse.put(PageConstants.TOTAL_PAGES, 1);
		diamondRankResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【根据userAccount分页查询能量排名列表】(BootDiamondRankController-selectDiamondRankContentByUserAccount)-返回信息, diamondRankResponse:{}", diamondRankResponse);
		return diamondRankResponse;
	}

	/**
	 * 根据userAccount查询能量排名
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondRankListByPageUserAccount")
	@ResponseBody
	public BootRestMapResponse selectDiamondRankListByPageUserAccount(
		@RequestBody DiamondRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userAccount查询能量排名】(BootDiamondRankController-selectDiamondRankByUserAccount)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

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

		DiamondRankParam param = new DiamondRankParam();
		param.setUserAccount(userAccount);
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<DiamondRank> list = null;
		try {
			list = diamondRankService.selectDiamondRankListByUserAccount(param);
			logger.info("===step2:【根据userAccount查询能量排名】(BootDiamondRankController-selectDiamondRankByUserAccount)-根据userAccount查询能量排名, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userAccount查询能量排名】(BootDiamondRankController-selectDiamondRankByUserAccount)-根据userAccount查询能量排名-异常, Exception = {}, message = {}",e,e.getMessage());
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

		BootRestMapResponse diamondRankResponse = new BootRestMapResponse();
		diamondRankResponse.put(PageConstants.PAGE_NUM, pageNum);
		diamondRankResponse.put(PageConstants.PAGE_SIZE, pageSize);
		diamondRankResponse.put(PageConstants.TOTAL_COUNT, 1);
		diamondRankResponse.put(PageConstants.TOTAL_PAGES, 1);
		diamondRankResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【根据userAccount查询能量排名】(BootDiamondRankController-selectDiamondRankByUserAccount)-返回信息, diamondRankResponse:{}", diamondRankResponse);
		return diamondRankResponse;
	}

	/**
	 * 根据userAccount查询能量排名
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectDiamondRankByUserAccount")
	@ResponseBody
	public BootRestMapResponse selectDiamondRankByUserAccount(
		@RequestBody DiamondRankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据userAccount查询能量排名】(BootDiamondRankController-selectDiamondRankByUserAccount)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String userAccount = req.getUserAccount();
		Date rankTime = req.getRankTime();
		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		DiamondRankParam param = new DiamondRankParam();
		param.setUserAccount(userAccount);
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		DiamondRank diamondRank = null;
		try {
			diamondRank = diamondRankService.selectDiamondRankByUserAccount(param);
			logger.info("===step2:【根据userAccount查询能量排名】(BootDiamondRankController-selectDiamondRankByUserAccount)-根据userAccount查询能量排名, diamondRank:{}", diamondRank);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据userAccount查询能量排名】(BootDiamondRankController-selectDiamondRankByUserAccount)-根据userAccount查询能量排名-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(diamondRank == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_DIAMOND_RANK_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_DIAMOND_RANK_ENTITY_NOTEXIST_MSG);
		}
		String content = Objects.toString(diamondRank.getContent(), "");

		BootRestMapResponse diamondRankResponse = new BootRestMapResponse();
		if(StringUtils.isNotBlank(content)) {
			diamondRankResponse.putAll(JSONObject.parseObject(content));
		}
		logger.info("===step3:【根据userAccount查询能量排名】(BootDiamondRankController-selectDiamondRankByUserAccount)-返回信息, diamondRankResponse:{}", diamondRankResponse);
		return diamondRankResponse;
	}

	/**
	 * 根据rankTimeStr删除能量排名
	 * @param rankTime
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/deleteDiamondRankByRankTime/{rankTimeStr}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse deleteDiamondRankByRankTime(
		@PathVariable(value="rankTimeStr",required=false) String rankTimeStr,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据rankTimeStr删除能量排名】(BootDiamondRankController-deleteDiamondRankByRankTime)-传入参数, rankTimeStr:{}", rankTimeStr);

		if(StringUtils.isBlank(rankTimeStr)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "rankTimeStr为空");
		}

		int i = 0;
		try {
			i = diamondRankService.deleteDiamondRankByRankTime(rankTimeStr);
			logger.info("===step2:【根据rankTimeStr删除能量排名】(BootDiamondRankController-deleteDiamondRankByRankTime)-根据rankTimeStr删除能量排名, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据rankTimeStr删除能量排名】(BootDiamondRankController-deleteDiamondRankByRankTime)-根据rankTimeStr删除能量排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}

		Date sevenDaysDateTime = new DateTime().minus(Period.days(7)).toDate();
		try {
			i = diamondRankService.deleteDiamondRankByBeforeRankTime(sevenDaysDateTime);
			logger.info("===step3:【根据rankTimeStr删除能量排名】(BootDiamondRankController-deleteDiamondRankByRankTime)-删除7天前的能量排名, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step3.1:【根据rankTimeStr删除能量排名】(BootDiamondRankController-deleteDiamondRankByRankTime)-删除7天前的能量排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
		}

		BootRestMapResponse rankResponse = new BootRestMapResponse();
		logger.info("===step4:【根据rankTimeStr删除能量排名】(BootDiamondRankController-deleteDiamondRankByRankTime)-返回信息, rankResponse:{}", rankResponse);
		return rankResponse;
	}

}