package com.ochain.provider.wheel.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.AccountCalculateMapper;
import com.ochain.provider.wheel.dao.AccountMapper;
import com.ochain.provider.wheel.dao.DiamondConfigMapper;
import com.ochain.provider.wheel.dao.DiamondRecordMapper;
import com.ochain.provider.wheel.dao.RankMapper;
import com.ochain.provider.wheel.param.RankParam;
import com.ochain.provider.wheel.po.Rank;
import com.ochain.provider.wheel.po.RankExample;
import com.ochain.provider.wheel.service.IBootRankService;
import com.ochain.provider.wheel.vo.account.AccountCalculateVo;
import com.ochain.provider.wheel.vo.account.AccountDiamondVo;
import com.ochain.provider.wheel.vo.diamond.DiamondConfigMaxCodeVo;

/**
 * 排名接口 BootRankService
 * @author wei.yong
 * @date 2017-08-28
 */
@Service
public class BootRankServiceImpl implements IBootRankService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //排名 Mapper
    @Autowired
    private RankMapper rankMapper;

    //账户 Mapper
    @Autowired
    private AccountMapper accountMapper;

    //账户算力 Mapper
    @Autowired
    private AccountCalculateMapper accountCalculateMapper;

    //能量配置 Mapper
    @Autowired
    private DiamondConfigMapper diamondConfigMapper;

    //能量收取记录 Mapper
  	@Autowired
  	private DiamondRecordMapper diamondRecordMapper;

  	/**
  	 * 分页查询
  	 * @param page
  	 * @param rank
  	 * @return List<Rank>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<Rank> selectRankListByPage(Page<Rank> page, Rank rank) throws BootServiceException {
  		logger.info("(BootRankService-selectRankListByPage)-分页查询-传入参数, page:{}, rank:{}", page, rank);
  		RankExample example = new RankExample();
  		example.setOrderByClause(" id desc ");
  		RankExample.Criteria criteria = example.createCriteria();
  		if(rank != null) {
  			if(rank.getRankTime() != null) {
  				LocalDate localDate = new LocalDate(rank.getRankTime().getTime());
  				Date RankTimeStart = null;
  				Date RankTimeEnd = null;
  				try {
  					RankTimeStart = DateUtils.parseDate(localDate.toString() + DateFormatConstants.TIME_START, DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS);
					RankTimeEnd = DateUtils.parseDate(localDate.toString() + DateFormatConstants.TIME_END, DateFormatConstants.DF_YYYY_MM_DD_HH_MM_SS);
				} catch (ParseException e) {
					logger.error("(BootRankService-selectRankListByPage)-ranTime时间解析异常, Exception = {}, message = {}", e, e.getMessage());
				}
  				criteria.andRankTimeBetween(RankTimeStart, RankTimeEnd);
  			}
  		}

  		List<Rank> list = null;
  		try {
  			list = rankMapper.selectByExample(page, example);
  			logger.info("(BootRankService-selectRankListByPage)-分页查询-返回信息, list.size:{}", list == null ? 0 : list.size());
  		} catch (Exception e) {
  			logger.error("(BootRankService-selectRankListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 不分页查询
  	 * @param rank
  	 * @return List<Rank>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<Rank> selectRankList(Rank rank) throws BootServiceException {
  		logger.info("(BootRankService-selectRankList)-不分页查询-传入参数, rank:{}", rank);
  		RankExample example = new RankExample();
  		example.setOrderByClause(" id desc ");
  		RankExample.Criteria criteria = example.createCriteria();
  		if(rank != null) {
  		}

  		List<Rank> list = null;
  		try {
  			list = rankMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootRankService-selectRankList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}


    /**
     * 根据id查询排名
     * @param id
     * @return Rank
     * @throws BootServiceException
     */
	@Override
	public Rank selectRankById(Integer id) throws BootServiceException {
    	logger.info("(BootRankService-selectRankById)-根据id查询排名-传入参数, id:{}", id);
    	Rank rank = null;
    	try {
    		rank = rankMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootRankService-selectRankById)-根据id查询排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return rank;
    }

    /**
     * 根据rankTimeStr查询排名
     * @param userId
     * @return Rank
     * @throws BootServiceException
     */
	@Override
	public Rank selectRankByRankTime(String rankTimeStr) throws BootServiceException {
		logger.info("(BootRankService-selectRankByRankTime)-根据rankTimeStr查询排名-传入参数, rankTimeStr:{}", rankTimeStr);
		RankParam param = new RankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<Rank> list = null;
		try {
			list = rankMapper.selectRankListByRankTime(param);
		} catch (Exception e) {
			logger.error("(BootRankService-selectRankByRankTime)-根据rankTimeStr查询排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		Rank rank = null;
		if(list != null && !list.isEmpty()) {
			rank = list.get(0);
		}
		return rank;
	}

    /**
     * 插入排名
     * @param realDiamond
     * @return Rank
     * @throws BootServiceException
     */
	@Override
	public Rank insertRank(BigDecimal realDiamond) throws BootServiceException {
    	logger.info("(BootRankService-insertRank)-插入排名-传入参数, realDiamond:{}", realDiamond);

    	List<AccountDiamondVo> accountDiamondVoList = null;
    	try {
    		accountDiamondVoList = accountMapper.selectAccountDiamondSumList();
    	} catch (Exception e) {
    		logger.error("(BootRankService-insertRank)-查询账户能量总数-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    	}

    	BigDecimal totalDiamond = null;
    	if(accountDiamondVoList != null && !accountDiamondVoList.isEmpty()) {
    		AccountDiamondVo accountDiamondVo = accountDiamondVoList.get(0);
    		totalDiamond = accountDiamondVo.getTotalDiamond();
    	}

    	List<AccountCalculateVo> accountCalculateVoList = null;
    	try {
    		accountCalculateVoList = accountCalculateMapper.selectAccountCalculateSumList();
    	} catch (Exception e) {
    		logger.error("(BootRankService-insertRank)-查询账户算力总数-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    	}

        Long totalCalculate = null;
        Long totalCivilizeCalculate = null;
        Long totalTaskCalculate= null;
    	if(accountCalculateVoList != null && !accountCalculateVoList.isEmpty()) {
    		AccountCalculateVo accountCalculateVo = accountCalculateVoList.get(0);
    		totalCalculate = accountCalculateVo.getTotalCalculate();
    		totalCivilizeCalculate = accountCalculateVo.getTotalCivilizeCalculate();
    		totalTaskCalculate = accountCalculateVo.getTotalTaskCalculate();
    	}

    	List<DiamondConfigMaxCodeVo> list = null;
    	try {
    		list = diamondConfigMapper.selectSendDiamondSumList();
    	} catch (Exception e) {
    		logger.error("(BootRankService-insertRank)-查询固定发放的能量数量-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    	}
    	BigDecimal planDiamond = null;
    	if(list != null && !list.isEmpty()) {
    		DiamondConfigMaxCodeVo diamondConfigMaxCodeVo = list.get(0);
    		if(diamondConfigMaxCodeVo != null) {
    			planDiamond = diamondConfigMaxCodeVo.getTotalSendDiamond();
    		}
    	}

    	//如果null，赋值为0
    	if(realDiamond == null) {
    		realDiamond = new BigDecimal("0");
    	}

    	//暂时注释，因为数据太多效率太低
    	//前1天
//    	String useTimeStr = new LocalDate().minus(Period.days(1)).toString();
//    	DiamondRecordParam param = new DiamondRecordParam();
//  		param.setUseTimeStartStr(useTimeStr+DateFormatConstants.TIME_START);
//  		param.setUseTimeEndStr(useTimeStr+DateFormatConstants.TIME_END);
//  		List<DiamondRecordVo> diamondRecordList = null;
//  		try {
//  			diamondRecordList = diamondRecordMapper.selectDrawDiamondListByUseTime(param);
//  		} catch (Exception e) {
//  			logger.error("(BootRankService-insertRank)-根据领用时间查询已领取的能量数量-事务性异常, Exception = {}, message = {}", e, e.getMessage());
//  		}
//  		BigDecimal realDiamond = null;
//  		if(diamondRecordList != null && !diamondRecordList.isEmpty()) {
//  			DiamondRecordVo diamondRecordVo = diamondRecordList.get(0);
//  			if(diamondRecordVo != null) {
//  				realDiamond = diamondRecordVo.getTotalDrawDiamond();
//  			}
//  		}

    	Rank rank = new Rank();
    	rank.setTotalDiamond(totalDiamond);
    	rank.setTotalCalculate(totalCalculate);
    	rank.setTotalCivilizeCalculate(totalCivilizeCalculate);
    	rank.setTotalTaskCalculate(totalTaskCalculate);
    	rank.setPlanDiamond(planDiamond);
    	rank.setRealDiamond(realDiamond);
    	rank.setRankTime(new Date());
    	rank.setCreateTime(new Date());
    	rank.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = rankMapper.insertSelective(rank);
    	} catch (Exception e) {
    		logger.error("(BootRankService-insertRank)-插入排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    	}
    	if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
    	return rank;
    }

    /**
     * 修改排名
     * @param rank
     * @return Integer
     * @throws BootServiceException
     */
	@Override
	public Integer modifyRank(Rank rank) throws BootServiceException {
    	logger.info("(BootRankService-modifyRank)-修改排名-传入参数, rank:{}", rank);
    	rank.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = rankMapper.updateByPrimaryKeySelective(rank);
    	} catch (Exception e) {
    		logger.error("(BootRankService-modifyRank)-修改排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
    	}
    	if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
    	return i;
    }

	/**
	 * 根据排名时间删除排名
	 * @param rankTimeStr
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer deleteRankByRankTime(String rankTimeStr) throws BootServiceException {
		logger.info("(BootRankService-deleteRankByRankTime)-根据排名时间删除排名-传入参数, rankTimeStr:{}", rankTimeStr);
		RankParam param = new RankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		int i = 0;
		try {
			i = rankMapper.deleteRankByRankTime(param);
		} catch (Exception e) {
			logger.error("(BootRankService-deleteRankByRankTime)-根据排名时间删除排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

}