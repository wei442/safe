package com.ochain.consumer.wheel.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
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
import com.ochain.common.constants.wheel.WheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.redis.keys.RedisKeysUtil;
import com.ochain.consumer.wheel.base.BaseRestMapResponse;
import com.ochain.consumer.wheel.rest.request.diamond.DiamondRequest;
import com.ochain.consumer.wheel.service.IAccountLogService;
import com.ochain.consumer.wheel.service.IAccountService;
import com.ochain.consumer.wheel.service.IDiamondRecordService;
import com.ochain.consumer.wheel.util.PageUtil;
import com.ochain.consumer.wheel.vo.account.AccountBalanceVo;
import com.ochain.consumer.wheel.vo.account.AccountVo;
import com.ochain.consumer.wheel.vo.diamond.DiamondRankContentVo;
import com.ochain.consumer.wheel.vo.diamond.DiamondRecordVo;
import com.ochain.consumer.wheel.vo.diamond.DiamondVo;
import com.ochain.consumer.wheel.vo.diamond.DiamondYesterdayRankContentVo;

/**
 * 能量管理 UserDiamondController
 * @author wei.yong
 * @ClassName: UserDiamondController
 * @Description:
 * @date 2016年10月12日 下午 14:30:56
 */
@RestController
@RequestMapping("/user/diamond")
public class UserDiamondController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//能量 Service
	@Autowired
	private IDiamondRecordService diamondRecordService;

	//账户 Service
	@Autowired
	private IAccountService accountService;

	//账户日志 Service
	@Autowired
	private IAccountLogService accountLogService;

	//账户能量锁
	private final String LOCK_ACCOUNT_DIAMOND_KEY = RedisKeysUtil.LOCK_OCHAIN_ACCOUNT_DIAMOND;

	 /**
     * 4.1.5.1	获取能量方块列表接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/getDiamondList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDiamondList(
		@RequestBody DiamondRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【获取能量方块列表接口】(UserDiamondController-getDiamondList)-获取能量列表接口，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

   		Integer userId = this.getTokenUserId();
		if (userId == null) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_ERROR_MSG, this.getRequestParameterEmpty()+".userId.empty", "userId为空");
		}

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		//根据userId获得用户信息
		JSONObject jsonDiamond = diamondRecordService.getDiamondRecordListByThreeDays(params);
		logger.info("===step2:【获取能量方块列表接口】(UserDiamondController-getDiamondList)-根据userId获取能量列表-返回信息, jsonDiamond:{}", jsonDiamond);
		String bootCode = Objects.toString(jsonDiamond.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		String dataListStr = JSONObject.toJSONString(jsonDiamond.getJSONArray(PageConstants.DATA_LIST));
		List<DiamondVo> diamondList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DiamondVo>>(){});

        //返回信息
		BaseRestMapResponse userDiamondResponse = new BaseRestMapResponse();
		userDiamondResponse.put(RetWheelConstants.RESULT, diamondList);
	    logger.info("===step3:【获取能量方块列表接口】(UserDiamondController-getDiamondList)-返回信息, userDiamondResponse:{}", userDiamondResponse);
	    return userDiamondResponse;
	}

	 /**
     * 4.1.4.2	领取能量方块接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/draw",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse draw(
		@RequestBody DiamondRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【领取能量方块接口】(UserDiamondController-draw)-领取能量方块接口，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

   		JSONObject payloadJSON = this.getTokenPayload();
   		Integer userId = new Integer(Objects.toString(payloadJSON.get(RetWheelConstants.USER_ID)));
   		String userAccount = Objects.toString(payloadJSON.get(RetWheelConstants.USER_ACCOUNT));
   		Long diamondRecordId = req.getDiamondRecordId();
   		if (diamondRecordId == null) {
			return new BaseRestMapResponse(RetWheelConstants.PARAMETER_ERROR, RetWheelConstants.PARAMETER_ERROR_MSG, this.getRequestParameterEmpty()+".diamondRecordId.empty", "diamondRecordId为空");
		}

   		//同步处理-领取能量方块
   		JSONObject jsonAccount = accountService.getAccountByUserId(userId);
		logger.info("===step2:【领取能量方块接口】(UserDiamondController-draw)-根据userId获取账户, jsonAccount:{}", jsonAccount);
		String bootCode = Objects.toString(jsonAccount.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
		AccountVo accountVo = JSONObject.toJavaObject(jsonAccount, AccountVo.class);
		Integer accountId = accountVo.getAccountId();

		JSONObject jsonDiamondRecord = diamondRecordService.getDiamondRecordById(diamondRecordId);
		logger.info("===step3:【领取能量方块接口】(UserDiamondController-draw)-根据diamondRecordId获取能量记录, jsonDiamondRecord:{}", jsonDiamondRecord);
		bootCode = Objects.toString(jsonDiamondRecord.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}
       	DiamondRecordVo diamondRecordVo = JSONObject.toJavaObject(jsonDiamondRecord, DiamondRecordVo.class);
       	BigDecimal payDiamond = diamondRecordVo.getDiamond();
       	Integer diamondType = diamondRecordVo.getDiamondType();
       	Integer isUse = diamondRecordVo.getIsUse();
       	//能量方块记录存储的userId
       	Integer userIdDiamondRecord = diamondRecordVo.getUserId();
       	if(!userId.equals(userIdDiamondRecord)) {
			return new BaseRestMapResponse(RetWheelConstants.DIAMOND_RECORD_ERROR, RetWheelConstants.DIAMOND_RECORD_ERROR_MSG, RetWheelConstants.DIAMOND_RECORD_NOT_EQUAL_ERROR, RetWheelConstants.DIAMOND_RECORD_NOT_EQUAL_ERROR_MSG);
       	} else if(SqlWheelConstants.SQL_DIAMOND_RECORD_IS_USE_YES.equals(isUse)) {
       		return new BaseRestMapResponse(RetWheelConstants.DIAMOND_RECORD_ERROR, RetWheelConstants.DIAMOND_RECORD_IS_USE_ERROR_MSG, RetWheelConstants.DIAMOND_RECORD_IS_USE_ERROR, RetWheelConstants.DIAMOND_RECORD_IS_USE_ERROR_MSG);
       	} else if(SqlWheelConstants.SQL_DIAMOND_RECORD_IS_USE_FAIL.equals(isUse)) {
       		return new BaseRestMapResponse(RetWheelConstants.DIAMOND_RECORD_ERROR, RetWheelConstants.DIAMOND_RECORD_ERROR_MSG, RetWheelConstants.DIAMOND_RECORD_FAIL_ERROR, RetWheelConstants.DIAMOND_RECORD_FAIL_ERROR_MSG);
       	}

       	//时间
	    DateTime dateTime = new DateTime();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("userId", userId);
		params.put("diamondRecordId", diamondRecordId);
		params.put("drawTime", dateTime.toDate());
		JSONObject jsonDrawDiamondRecord = diamondRecordService.drawDiamondRecord(params);
		logger.info("===step4:【领取能量方块接口】(UserDiamondController-draw)-领取能量记录, jsonDrawDiamondRecord:{}", jsonDrawDiamondRecord);
		bootCode = Objects.toString(jsonDiamondRecord.get(BootWheelConstants.BOOT_CODE), "");
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
			if (StringUtils.equals(bootCode, BootWheelConstants.WHEEL_DIAMOND_RECORD_DRAW_HAS)) {
	       		return new BaseRestMapResponse(RetWheelConstants.DIAMOND_RECORD_ERROR, RetWheelConstants.DIAMOND_RECORD_IS_USE_ERROR_MSG, RetWheelConstants.DIAMOND_RECORD_IS_USE_ERROR, RetWheelConstants.DIAMOND_RECORD_IS_USE_ERROR_MSG);
			}
			if (StringUtils.equals(bootCode, BootWheelConstants.WHEEL_DIAMOND_RECORD_DRAW_FAIL)) {
	       		return new BaseRestMapResponse(RetWheelConstants.DIAMOND_RECORD_ERROR, RetWheelConstants.DIAMOND_RECORD_FAIL_ERROR_MSG, RetWheelConstants.DIAMOND_RECORD_FAIL_ERROR, RetWheelConstants.DIAMOND_RECORD_FAIL_ERROR_MSG);
			}
		}

       	params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("payDiamond", payDiamond);
		JSONObject jsonAccountBalance = null;
		boolean lock = false;
		String lockKey = LOCK_ACCOUNT_DIAMOND_KEY + userId;
		try {
			//加锁
			lock = redisLockService.lock(lockKey);
			logger.info("===step5:【领取能量方块接口】(UserDiamondController-draw)-是否锁定, lock = {}", lock);
			jsonAccountBalance = accountService.updateAccountBalance(params);
			logger.info("===step5.1:【领取能量方块接口】(UserDiamondController-draw)-修改账户能量余额-返回信息, jsonAccountBalance:{}", jsonAccountBalance);
			bootCode = Objects.toString(jsonAccountBalance.get(BootWheelConstants.BOOT_CODE), "");
			if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
				if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
					return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
				}
			}
		} finally {
			redisLockService.unlock(lockKey);
			lock=false;
		}
		Integer accountLogStatus = SqlWheelConstants.SQL_ACCOUNT_LOG_STATUS_FAIL;
		accountLogStatus = SqlWheelConstants.SQL_ACCOUNT_LOG_STATUS_SUCESS;
		AccountBalanceVo accountBalanceVo = JSONObject.toJavaObject(jsonAccountBalance, AccountBalanceVo.class);
		BigDecimal balance = accountBalanceVo.getDiamond();

		//新增账户能量实时排名
		this.insertDiamondRealRank(userId, userAccount, balance, 100);

		String content = "";
		String source = "";
		Integer accountLogType = null;
		if(SqlWheelConstants.SQL_DIAMOND_RECORD_TYPE_COMMON.equals(diamondType)) {
			content = WheelConstants.SOURCE_DRAW;
			source = WheelConstants.SOURCE_GOFUN;
			accountLogType = SqlWheelConstants.SQL_ACCOUNT_LOG_TYPE_DRAW;
		} else if(SqlWheelConstants.SQL_DIAMOND_RECORD_TYPE_NEW_USER.equals(diamondType)) {
			content = WheelConstants.NEW_USER_GIFT_NAME;
			source = WheelConstants.NEW_USER_GIFT_NAME;
			accountLogType = SqlWheelConstants.SQL_ACCOUNT_LOG_TYPE_GIFT;
		} else if(SqlWheelConstants.SQL_DIAMOND_RECORD_TYPE_COUPON.equals(diamondType)) {
			content = WheelConstants.SOURCE_COUPON_EXCHANGE;
			source = WheelConstants.SOURCE_COUPON_EXCHANGE;
			accountLogType = SqlWheelConstants.SQL_ACCOUNT_LOG_TYPE_EXCHANGE;
		}

		params = new HashMap<String, Object>();
		params.put("accountId", accountId);
		params.put("diamond", payDiamond);
		params.put("content", content);
		params.put("balance", balance);
		params.put("accountLogType", accountLogType);
		params.put("accountLogStatus", accountLogStatus);
		params.put("source", source);
		JSONObject jsonAccountLog = accountLogService.addAccountLog(params);
		logger.info("===step6:【领取能量方块接口】(UserDiamondController-draw)-新增账户日志记录, jsonAccountLog:{}", jsonAccountLog);
		if (!StringUtils.equals(bootCode, BootWheelConstants.OK)) {
			if (StringUtils.equals(bootCode, BootWheelConstants.BOOT_SYSTEM_ERROR)) {
				return new BaseRestMapResponse(RetWheelConstants.SYSTEM_ERROR, RetWheelConstants.SYSTEM_ERROR_MSG, RetWheelConstants.LBP_SYSTEM_ERROR, RetWheelConstants.LBP_SYSTEM_ERROR_MSG);
			}
		}

		String diamondRecordKey = RedisKeysUtil.CN_OCHAIN_WHEEL_DRAW_DIAMOND_RECORD_TIME + dateTime.toString(DateFormatConstants.DF_YYYYMMDD);
		double d = redisService.incrByFloat(diamondRecordKey, payDiamond.doubleValue());
		long l = redisService.expire(diamondRecordKey, RetWheelConstants.TWENTY_FOUR_HOUR_SECONDS_TIME);
		logger.info("===step7:【领取能量方块接口】(UserDiamondController-draw)-今日领取能量方块, d:{}, l:{}", d, l);

		//异步处理-领取能量方块，放入队列-暂时注释
//   		DiamondDrawRecordVo diamondDrawRecordVo = new DiamondDrawRecordVo();
//   		diamondDrawRecordVo.setUserId(userId);
//   		diamondDrawRecordVo.setUserAccount(userAccount);
//   		diamondDrawRecordVo.setDiamondRecordId(diamondRecordId);
//   		diamondDrawRecordVo.setDrawTime(new Date());
//        /** push数据推送(领取能量方块)队列-左进右出  **/
//        String queueKey = RedisKeysUtil.QN_OCHAIN_WHEEL_DIAMOND_DRAW;
//        String value = JSONObject.toJSONString(diamondDrawRecordVo);
//        logger.info("===step2:【领取能量方块接口】(UserDiamondController-draw)-push数据推送(领取能量方块)-传入参数, queueKey:{}, value", queueKey, value);
//        long l = redisService.lpush(queueKey, value);
//        logger.info("===step2.1:【领取能量方块接口】(UserDiamondController-draw)-push数据推送(领取能量方块)-返回信息, l:{}", l);

        //返回信息
		BaseRestMapResponse userDiamondResponse = new BaseRestMapResponse();
	    logger.info("===step8:【领取能量方块接口】(UserDiamondController-draw)-返回信息, userDiamondResponse:{}", userDiamondResponse);
	    return userDiamondResponse;
	}

	 /**
     * 4.1.4.3	获取能量排名列表接口
     * @param req
     * @param request
     * @param response
     * @return BaseRestMapResponse
     */
	@RequestMapping(value="/getRankList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getRankList(
		@RequestBody DiamondRequest req,
		HttpServletRequest request, HttpServletResponse response){
   		logger.info("===step1:【获取能量排名接口】(UserDiamondController-getRankList)-获取能量排名列表，请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		PageUtil pageUtil = new PageUtil(pageNum, pageSize);
		//因为redis下标是从0开始的，所以减1
		Integer start = pageUtil.getFirst() - 1;
		Integer end = pageNum * pageSize - 1;

		//获取能量前**名昨日排名列表
		List<DiamondRankContentVo> diamondRankList = this.getDiamondYesterdayRankList(start, end);
		String sortTime = null;
		if(diamondRankList != null && !diamondRankList.isEmpty()) {
			DiamondRankContentVo oneDiamondRankContentVo = diamondRankList.get(0);
			sortTime = oneDiamondRankContentVo.getSortTime();

			ListIterator<DiamondRankContentVo> it = diamondRankList.listIterator();
			while(it.hasNext()) {
				DiamondRankContentVo diamondRankContentVo = it.next();
				int nextIndex = it.nextIndex();
				int sort = (pageNum -1) * pageSize + nextIndex;
				diamondRankContentVo.setSort(sort);
			}
		}

		long totalCount = redisService.zcard(this.diamondYesterdayRankKey);
		logger.info("===step2:【获取能量排名接口】(UserDiamondController-getRankList)-从redis里获取用户昨日能量排名总记录数, totalCount:{}", totalCount);
		pageUtil.setTotalCount(totalCount);
		Integer totalPages = pageUtil.getTotalPages();

		JSONObject payloadJSON = this.getTokenPayload();
   		Integer userId = new Integer(Objects.toString(payloadJSON.get(RetWheelConstants.USER_ID)));
   		String userAccount = Objects.toString(payloadJSON.get(RetWheelConstants.USER_ACCOUNT));

		DiamondYesterdayRankContentVo diamondYesterdayRankContentVo = new DiamondYesterdayRankContentVo();
		diamondYesterdayRankContentVo.setUserId(userId);
		diamondYesterdayRankContentVo.setUserAccount(userAccount);
		String diamondYesterdayRankContentStr = JSONObject.toJSONString(diamondYesterdayRankContentVo);
		long rank = redisService.zrevrank(this.diamondYesterdayUserIdRankKey, diamondYesterdayRankContentStr);
		logger.info("===step2.1:【获取能量排名接口】(UserDiamondController-getRankList)-从redis里获取用户账户昨日能量排名, rank:{}", rank);
		double score = redisService.zscore(this.diamondYesterdayUserIdRankKey, diamondYesterdayRankContentStr);
		logger.info("===step2.2:【获取能量排名接口】(UserDiamondController-getRankList)-从redis里获取用户账户昨日能量排名数值, score:{}", score);
		Long sort = null;
		if(rank != -1l && rank < sortRank) {
			sort = rank + 1;
		}
		Double diamond = null;
		if(score != -1d) {
			diamond = score;
		}

		Map<String, Object> result = new HashMap<String, Object>();
		result.put(PageConstants.PAGE_NUM, pageNum);
		result.put(PageConstants.PAGE_SIZE, pageSize);
		result.put(PageConstants.TOTAL_COUNT, totalCount);
		result.put(PageConstants.TOTAL_PAGES, totalPages);
		result.put("diamond", diamond);
		result.put("sort", sort);
		result.put("rankTime", sortTime);
		result.put("diamondRankList", diamondRankList);

		BaseRestMapResponse userDiamondResponse = new BaseRestMapResponse();
		userDiamondResponse.put(RetWheelConstants.RESULT, result);
	    logger.info("===step3:【获取能量排名接口】(UserDiamondController-getRankList)-返回信息, userDiamondResponse:{}", userDiamondResponse);
	    return userDiamondResponse;
	}

}