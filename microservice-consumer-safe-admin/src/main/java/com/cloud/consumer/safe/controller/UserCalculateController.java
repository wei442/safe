package com.cloud.consumer.safe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
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
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.rest.request.calculate.CalculateRequest;
import com.cloud.consumer.safe.service.IUserCalculateConfigService;
import com.cloud.consumer.safe.util.PageUtil;
import com.cloud.consumer.safe.vo.calculate.CalculateRankContentVo;
import com.cloud.consumer.safe.vo.calculate.CalculateVo;
import com.cloud.consumer.safe.vo.calculate.CalculateYesterdayRankContentVo;

/**
 * 算力管理 UserCalculateController
 * @author wei.yong
 * @ClassName: UserCalculateController
 * @Description:
 * @date 2016年10月12日 下午 14:30:56
 */
@RestController
@RequestMapping("/user/calculate")
public class UserCalculateController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户算力配置 Service
	@Autowired
	private IUserCalculateConfigService userCalculateConfigService;

	 /**
     * 4.1.5.1	获取算力列表接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/getCalculateList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getCalculateList(
		@RequestBody CalculateRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【获取算力列表接口】(UserCalculateController-getCalculateList)-获取算力列表接口，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

   		Integer userId = this.getTokenUserId();
		if (userId == null) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_ERROR_MSG, this.getRequestParameterEmpty()+".userId.empty", "userId为空");
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("calculateType", SqlWheelConstants.SQL_CALCULATE_CONFIG_TYPE_TASK);
		//根据userId获得用户信息
		JSONObject jsonCalculate = userCalculateConfigService.getUserCalculateConfigList(params);
		logger.info("===step2:【获取算力列表接口】(UserCalculateController-getCalculateList))-根据userId获取算力列表-返回信息, jsonCalculate:{}", jsonCalculate);
		String bootCode = Objects.toString(jsonCalculate.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		String dataListStr = JSONObject.toJSONString(jsonCalculate.getJSONArray(PageConstants.DATA_LIST));
		List<CalculateVo> calculateList  = JSONObject.parseObject(dataListStr, new TypeReference<List<CalculateVo>>(){});

        //返回信息
		BaseRestMapResponse userCalculateResponse = new BaseRestMapResponse();
		userCalculateResponse.put(RetWheelConstants.RESULT, calculateList);
	    logger.info("===step3:【获取算力列表接口】(UserCalculateController-getCalculateList)-返回信息, userCalculateResponse:{}", userCalculateResponse);
	    return userCalculateResponse;
	}

	 /**
     * 4.1.5.2	获取算力排名接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/getRankList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getRankList(
		@RequestBody CalculateRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【获取算力排名接口】(UserCalculateController-getRankList)-获取算力排名接口，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		PageUtil pageUtil = new PageUtil(pageNum, pageSize);
		//因为redis下标是从0开始的，所以减1
		Integer start = pageUtil.getFirst() - 1;
		Integer end = pageNum * pageSize - 1;

		List<CalculateRankContentVo> calculateRankList = this.getCalculateYesterdayRankList(start, end);
		String sortTime = null;
		if(calculateRankList != null && !calculateRankList.isEmpty()) {
			CalculateRankContentVo oneCalculateRankContentVo = calculateRankList.get(0);
			sortTime = oneCalculateRankContentVo.getSortTime();

			ListIterator<CalculateRankContentVo> it = calculateRankList.listIterator();
			while(it.hasNext()) {
				CalculateRankContentVo calculateRankContentVo = it.next();
				int nextIndex = it.nextIndex();
				int sort = (pageNum -1) * pageSize + nextIndex;
				calculateRankContentVo.setSort(sort);
			}
		}

		long totalCount = redisService.zcard(this.calculateYesterdayRankKey);
		logger.info("===step2:【获取算力排名接口】(UserCalculateController-getRankList)-从redis里获取用户昨日算力排名总记录数, totalCount:{}", totalCount);
		pageUtil.setTotalCount(totalCount);
		Integer totalPages = pageUtil.getTotalPages();

		JSONObject payloadJSON = this.getTokenPayload();
   		Integer userId = new Integer(Objects.toString(payloadJSON.get(RetWheelConstants.USER_ID)));
   		String userAccount = Objects.toString(payloadJSON.get(RetWheelConstants.USER_ACCOUNT));

   		CalculateYesterdayRankContentVo calculateYesterdayRankContentVo = new CalculateYesterdayRankContentVo();
   		calculateYesterdayRankContentVo.setUserId(userId);
   		calculateYesterdayRankContentVo.setUserAccount(userAccount);
		String calculateYesterdayRankContentStr = JSONObject.toJSONString(calculateYesterdayRankContentVo);
		long rank = redisService.zrevrank(this.calculateYesterdayUserIdRankKey, calculateYesterdayRankContentStr);
		logger.info("===step2.1:【获取算力排名接口】(UserCalculateController-getRankList)-从redis里获取用户账户昨日算力能量排名, rank:{}", rank);
		double score = redisService.zscore(this.calculateYesterdayUserIdRankKey, calculateYesterdayRankContentStr);
		logger.info("===step2.2:【获取算力排名接口】(UserCalculateController-getRankList)-从redis里获取用户账户昨日算力能量排名数值, score:{}", score);
		Long sort = null;
		if(rank != -1 && rank < sortRank) {
			sort = rank + 1;
		}
		Double calculate = null;
		if(score != -1d) {
			calculate = score;
		}

		Map<String, Object> result = new HashMap<String, Object>();
		result.put(PageConstants.PAGE_NUM, pageNum);
		result.put(PageConstants.PAGE_SIZE, pageSize);
		result.put(PageConstants.TOTAL_COUNT, totalCount);
		result.put(PageConstants.TOTAL_PAGES, totalPages);
		result.put("calculate", calculate);
		result.put("sort", sort);
		result.put("rankTime", sortTime);
		result.put("calculateRankList", calculateRankList);

		BaseRestMapResponse userCalculateResponse = new BaseRestMapResponse();
		userCalculateResponse.put(RetWheelConstants.RESULT, result);
	    logger.info("===step3:【获取算力排名接口】(UserCalculateController-getRankList)-返回信息, userCalculateResponse:{}", userCalculateResponse);
	    return userCalculateResponse;
	}

}