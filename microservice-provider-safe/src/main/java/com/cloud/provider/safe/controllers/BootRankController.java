package com.ochain.provider.wheel.controllers;

import java.math.BigDecimal;
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
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.boot.BootRestMapResponse;
import com.ochain.provider.wheel.po.Rank;
import com.ochain.provider.wheel.rest.request.rank.RankRequest;
import com.ochain.provider.wheel.service.IBootRankService;

/**
 * 排名 BootRankController
 * @author wei.yong
 * @date 2018-07-02
 */
@RestController
@RequestMapping("/boot/rank")
public class BootRankController extends BootBaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//排名 Service
	@Autowired
	private IBootRankService rankService;

	/**
	 * 分页查询排名列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectRankListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectRankListByPage(
		@RequestBody RankRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【分页查询排名列表】(BootRankController-selectRankListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Date rankTime = req.getRankTime();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Rank rank = new Rank();
		rank.setRankTime(rankTime);
		Page<Rank> page = new Page<Rank>(pageNum, pageSize);
		List<Rank> list = null;
		try {
			list = rankService.selectRankListByPage(page, rank);
			logger.info("===step2:【分页查询排名列表】(BootRankController-selectRankListByPage)-分页查询排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询排名列表】(BootRankController-selectRankListByPage)-分页查询排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_RANK_LIST_NOTEXIST, BootWheelConstants.WHEEL_RANK_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse rankListPageResponse = new BootRestMapResponse();
		rankListPageResponse.put(PageConstants.PAGE_NUM, page.getPageNum());
		rankListPageResponse.put(PageConstants.PAGE_SIZE, page.getPageSize());
		rankListPageResponse.put(PageConstants.TOTAL_COUNT, page.getTotalCount());
		rankListPageResponse.put(PageConstants.TOTAL_PAGES, page.getTotalPages());
		rankListPageResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【分页查询排名列表】(BootRankController-selectRankListByPage)-返回信息, rankListPageResponse:{}", rankListPageResponse);
		return rankListPageResponse;
	}

	/**
	 * 查询排名列表
	 * @param req
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectRankList",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectRankList(
		@RequestBody RankRequest req,
		HttpServletRequest request, HttpServletResponse response){
		logger.info("===step1:【查询排名列表】(BootRankController-selectRankList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Date rankTime = req.getRankTime();
		Rank rank = new Rank();
		rank.setRankTime(rankTime);
		List<Rank> list = null;
		try {
			list = rankService.selectRankList(rank);
			logger.info("===step2:【分页查询排名列表】(BootRankController-selectRankList)-查询排名列表, list.size:{}", list == null ? null : list.size());
		} catch (BootServiceException e) {
			logger.error("===step2.1:【分页查询排名列表】(BootRankController-selectRankList)-查询排名列表-异常, Exception = {}, message = {}",e,e.getMessage());
        	String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    		}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(list == null || list.isEmpty()) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_RANK_LIST_NOTEXIST, BootWheelConstants.WHEEL_RANK_LIST_NOTEXIST_MSG);
		}

		BootRestMapResponse rankListResponse = new BootRestMapResponse();
		rankListResponse.put(PageConstants.DATA_LIST, list);
		logger.info("===step3:【查询排名列表】(BootRankController-selectRankList)-返回信息, rankListResponse:{}", rankListResponse);
		return rankListResponse;
	}

	/**
	 * 据id查询排名
	 * @param rankId
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 * @throws BootServiceException
	 */
	@RequestMapping(value="/selectRankById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectRankById(
		@PathVariable(value="id",required=false) Integer rankId,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【据id查询排名】(selectRankById-selectRankById)-传入参数, rankId:{}", rankId);

		if(rankId == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY_MSG, "rankId为空");
		}

		Rank rank = null;
		try {
			rank = rankService.selectRankById(rankId);
			logger.info("===step2:【据id查询排名】(BootRankController-selectRankById)-根据id查询排名, rank:{}", rank);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【据id查询排名】(BootRankController-selectRankById)-根据id查询排名-异常, Exception = {}, message = {}",e,e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(rank == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_RANK_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_RANK_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse resResponse = new BootRestMapResponse();
		resResponse.putAll((JSONObject) JSONObject.toJSON(rank));
		logger.info("===step3:【据id查询排名】(BootRankController-selectRankById)-返回信息, resResponse:{}", resResponse);
		return resResponse;
	}

	/**
	 * 根据rankTime查询排名
	 * @param rankTime
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/selectRankByRankTime/{rankTime}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse selectRankByRankTime(
		@PathVariable(value="rankTime",required=false) Date rankTime,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据rankTime查询排名】(BootRankController-selectRankByRankTime)-传入参数, rankTime:{}", rankTime);

		String rankTimeStr = "";
		if(rankTime != null) {
			rankTimeStr = new LocalDate(rankTime).toString();
		} else {
			rankTimeStr = new LocalDate().toString();
		}

		Rank rank = null;
		try {
			rank = rankService.selectRankByRankTime(rankTimeStr);
			logger.info("===step2:【根据rankTime查询排名】(BootRankController-selectRankByRankTime)-根据rankTime查询排名, rank:{}", rank);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据rankTime查询排名】(BootRankController-selectRankByRankTime)-根据rankTime查询排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}
		if(rank == null) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_RANK_ENTITY_NOTEXIST, BootWheelConstants.WHEEL_RANK_ENTITY_NOTEXIST_MSG);
		}

		BootRestMapResponse rankResponse = new BootRestMapResponse();
		rankResponse.putAll((JSONObject) JSONObject.toJSON(rank));
		logger.info("===step3:【根据rankTime查询排名】(BootRankController-selectRankByRankTime)-返回信息, rankResponse:{}", rankResponse);
		return rankResponse;
	}

	/**
	 * 插入排名
	 * @param req
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/insertRank",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse insertRank(
		@RequestBody RankRequest req,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【插入排名】(BootRankController-insertRank)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		BigDecimal realDiamond = req.getRealDiamond();

		Rank rank = null;
		try {
			rank = rankService.insertRank(realDiamond);
			logger.info("===step2:【插入排名】(BootRankController-insertRank)-插入排名-返回, rank = {}", rank);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【插入排名】(BootRankController-insertRank)-插入排名-异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse rankResponse = new BootRestMapResponse();
		rankResponse.putAll((JSONObject) JSONObject.toJSON(rank));
		logger.info("===step3:【插入排名】(BootRankController-insertRank)-返回信息, rankResponse:{}", rankResponse);
		return rankResponse;
	}

	/**
	 * 根据rankTimeStr删除排名
	 * @param rankTime
	 * @param request
	 * @param response
	 * @return BootRestMapResponse
	 */
	@RequestMapping(value="/deleteRankByRankTime/{rankTimeStr}",method={RequestMethod.POST})
	@ResponseBody
	public BootRestMapResponse deleteRankByRankTime(
		@PathVariable(value="rankTimeStr",required=false) String rankTimeStr,
		HttpServletRequest request, HttpServletResponse response) {
		logger.info("===step1:【根据rankTimeStr删除排名】(BootRankController-deleteRankByRankTime)-传入参数, rankTimeStr:{}", rankTimeStr);

		if(StringUtils.isBlank(rankTimeStr)) {
			return new BootRestMapResponse(BootWheelConstants.WHEEL_FIELD_EMPTY, "rankTimeStr为空");
		}

		int i = 0;
		try {
			i = rankService.deleteRankByRankTime(rankTimeStr);
			logger.info("===step2:【根据rankTimeStr删除排名】(BootRankController-deleteRankByRankTime)-根据rankTimeStr删除排名, i:{}", i);
		} catch (BootServiceException e) {
			logger.error("===step2.1:【根据rankTimeStr删除排名】(BootRankController-deleteRankByRankTime)-根据rankTimeStr删除排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			String errorCode = e.getErrorCode();
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
        	}
        	if(StringUtils.equals(errorCode, BootWheelConstants.BOOT_DATABASE_ERROR)) {
        		return new BootRestMapResponse(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
        	}
		}

		BootRestMapResponse rankResponse = new BootRestMapResponse();
		logger.info("===step3:【根据rankTimeStr删除排名】(BootRankController-deleteRankByRankTime)-返回信息, rankResponse:{}", rankResponse);
		return rankResponse;
	}

}