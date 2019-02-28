package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.OrderDrawCoinMapper;
import com.ochain.provider.wheel.param.OrderDrawCoinParam;
import com.ochain.provider.wheel.po.OrderDrawCoin;
import com.ochain.provider.wheel.po.OrderDrawCoinExample;
import com.ochain.provider.wheel.service.IBootOrderDrawCoinService;

/**
 * 提币订单 BootOrderDrawCoinService
 * @author wei.yong
 * @date 2017-10-13
 */
@Service
public class BootOrderDrawCoinServiceImpl implements IBootOrderDrawCoinService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //提币订单 Mapper
  	@Autowired
  	private OrderDrawCoinMapper orderDrawCoinMapper;

  	/**
  	 * 分页查询
  	 * @param page
  	 * @param orderDrawCoinParam
  	 * @return List<OrderDrawCoin>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<OrderDrawCoin> selectOrderDrawCoinListByPage(Page<OrderDrawCoin> page, OrderDrawCoinParam orderDrawCoinParam) throws BootServiceException {
  		logger.info("(BootOrderDrawCoinService-selectOrderDrawCoinListByPage)-分页查询-传入参数, page:{}, orderDrawCoinParam:{}", page, orderDrawCoinParam);
  		OrderDrawCoinExample example = new OrderDrawCoinExample();
  		example.setOrderByClause(" id desc ");
  		OrderDrawCoinExample.Criteria criteria = example.createCriteria();
  		if(orderDrawCoinParam != null) {
  			if(orderDrawCoinParam.getOrderNo() != null) {
  				criteria.andOrderNoEqualTo(orderDrawCoinParam.getOrderNo());
  			}
  			if(StringUtils.isNotBlank(orderDrawCoinParam.getUserAccount())) {
  				criteria.andUserAccountEqualTo(orderDrawCoinParam.getUserAccount());
  			}
  			if(StringUtils.isNotBlank(orderDrawCoinParam.getTransactionHash())) {
  				criteria.andTransactionHashEqualTo(orderDrawCoinParam.getTransactionHash());
  			}
  			if(StringUtils.isNotBlank(orderDrawCoinParam.getAccountAddrFrom())) {
  				criteria.andAccountAddrFromEqualTo(orderDrawCoinParam.getAccountAddrFrom());
  			}
  			if(StringUtils.isNotBlank(orderDrawCoinParam.getAccountAddrTo())) {
  				criteria.andAccountAddrToEqualTo(orderDrawCoinParam.getAccountAddrTo());
  			}
  			if(orderDrawCoinParam.getStatus() != null) {
  				criteria.andStatusEqualTo(orderDrawCoinParam.getStatus());
  			}
  			if(orderDrawCoinParam.getCompleteTimeStart() != null && orderDrawCoinParam.getCompleteTimeEnd() == null) {
  				criteria.andCompleteTimeGreaterThanOrEqualTo(orderDrawCoinParam.getCompleteTimeStart());
  			} else if(orderDrawCoinParam.getCompleteTimeStart() == null && orderDrawCoinParam.getCompleteTimeEnd() != null) {
  				criteria.andCompleteTimeLessThanOrEqualTo(orderDrawCoinParam.getCompleteTimeEnd());
  			} else if(orderDrawCoinParam.getCompleteTimeStart() != null && orderDrawCoinParam.getCompleteTimeEnd() != null) {
  				criteria.andCompleteTimeBetween(orderDrawCoinParam.getCompleteTimeStart(), orderDrawCoinParam.getCompleteTimeEnd());
  			}
  			if(orderDrawCoinParam.getCreateTimeStart() != null && orderDrawCoinParam.getCreateTimeEnd() == null) {
  				criteria.andCreateTimeGreaterThanOrEqualTo(orderDrawCoinParam.getCreateTimeStart());
  			} else if(orderDrawCoinParam.getCreateTimeStart() == null && orderDrawCoinParam.getCreateTimeEnd() != null) {
  				criteria.andCreateTimeLessThanOrEqualTo(orderDrawCoinParam.getCreateTimeEnd());
  			} else if(orderDrawCoinParam.getCreateTimeStart() != null && orderDrawCoinParam.getCreateTimeEnd() != null) {
  				criteria.andCreateTimeBetween(orderDrawCoinParam.getCreateTimeStart(), orderDrawCoinParam.getCreateTimeEnd());
  			}
  		}

  		List<OrderDrawCoin> list = null;
  		try {
  			list = orderDrawCoinMapper.selectByExample(page, example);
  		} catch (Exception e) {
  			logger.error("(BootOrderDrawCoinService-selectOrderDrawCoinListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 不分页查询
  	 * @param orderDrawCoinParam
  	 * @return List<OrderDrawCoin>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<OrderDrawCoin> selectOrderDrawCoinList(OrderDrawCoinParam orderDrawCoinParam) throws BootServiceException {
  		logger.info("(BootOrderDrawCoinService-selectOrderDrawCoinList)-不分页查询-传入参数, orderDrawCoinParam:{}", orderDrawCoinParam);
  		OrderDrawCoinExample example = new OrderDrawCoinExample();
  		example.setOrderByClause(" id desc ");
  		OrderDrawCoinExample.Criteria criteria = example.createCriteria();
  		if(orderDrawCoinParam != null) {
  			if(orderDrawCoinParam.getOrderNo() != null) {
  				criteria.andOrderNoEqualTo(orderDrawCoinParam.getOrderNo());
  			}
  			if(StringUtils.isNotBlank(orderDrawCoinParam.getUserAccount())) {
  				criteria.andUserAccountEqualTo(orderDrawCoinParam.getUserAccount());
  			}
  			if(StringUtils.isNotBlank(orderDrawCoinParam.getTransactionHash())) {
  				criteria.andTransactionHashEqualTo(orderDrawCoinParam.getTransactionHash());
  			}
  			if(StringUtils.isNotBlank(orderDrawCoinParam.getAccountAddrFrom())) {
  				criteria.andAccountAddrFromEqualTo(orderDrawCoinParam.getAccountAddrFrom());
  			}
  			if(StringUtils.isNotBlank(orderDrawCoinParam.getAccountAddrTo())) {
  				criteria.andAccountAddrToEqualTo(orderDrawCoinParam.getAccountAddrTo());
  			}
  			if(orderDrawCoinParam.getStatus() != null) {
  				criteria.andStatusEqualTo(orderDrawCoinParam.getStatus());
  			}
  			if(orderDrawCoinParam.getCompleteTimeStart() != null && orderDrawCoinParam.getCompleteTimeEnd() == null) {
  				criteria.andCompleteTimeGreaterThanOrEqualTo(orderDrawCoinParam.getCompleteTimeStart());
  			} else if(orderDrawCoinParam.getCompleteTimeStart() == null && orderDrawCoinParam.getCompleteTimeEnd() != null) {
  				criteria.andCompleteTimeLessThanOrEqualTo(orderDrawCoinParam.getCompleteTimeEnd());
  			} else if(orderDrawCoinParam.getCompleteTimeStart() != null && orderDrawCoinParam.getCompleteTimeEnd() != null) {
  				criteria.andCompleteTimeBetween(orderDrawCoinParam.getCompleteTimeStart(), orderDrawCoinParam.getCompleteTimeEnd());
  			}
  			if(orderDrawCoinParam.getCreateTimeStart() != null && orderDrawCoinParam.getCreateTimeEnd() == null) {
  				criteria.andCreateTimeGreaterThanOrEqualTo(orderDrawCoinParam.getCreateTimeStart());
  			} else if(orderDrawCoinParam.getCreateTimeStart() == null && orderDrawCoinParam.getCreateTimeEnd() != null) {
  				criteria.andCreateTimeLessThanOrEqualTo(orderDrawCoinParam.getCreateTimeEnd());
  			} else if(orderDrawCoinParam.getCreateTimeStart() != null && orderDrawCoinParam.getCreateTimeEnd() != null) {
  				criteria.andCreateTimeBetween(orderDrawCoinParam.getCreateTimeStart(), orderDrawCoinParam.getCreateTimeEnd());
  			}
  		}

  		List<OrderDrawCoin> list = null;
  		try {
  			list = orderDrawCoinMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootOrderDrawCoinService-selectOrderDrawCoinList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 根据id查询提币订单
  	 * @param id
  	 * @return OrderDrawCoin
  	 * @throws BootServiceException
  	 */
  	@Override
	public OrderDrawCoin selectOrderDrawCoinById(Long id) throws BootServiceException {
  		logger.info("(BootOrderDrawCoinService-selectOrderDrawCoinById)-根据id查询提币订单-传入参数, id:{}", id);
  		OrderDrawCoin orderDrawCoin = null;
  		try {
  			orderDrawCoin = orderDrawCoinMapper.selectByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootOrderDrawCoinService-selectOrderDrawCoinById)-根据id查询提币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return orderDrawCoin;
  	}

  	/**
  	 * 根据orderNo查询提币订单
  	 * @param orderNo
  	 * @return OrderDrawCoin
  	 * @throws BootServiceException
  	 */
	@Override
	public OrderDrawCoin selectOrderDrawCoinByOrderNo(Long orderNo) throws BootServiceException {
  		logger.info("(BootOrderDrawCoinService-selectOrderDrawCoinByOrderNo)-根据orderNo查询提币订单-传入参数, orderNo:{}", orderNo);
  		OrderDrawCoinExample example = new OrderDrawCoinExample();
  		OrderDrawCoinExample.Criteria criteria = example.createCriteria();
  		criteria.andOrderNoEqualTo(orderNo);
  		List<OrderDrawCoin> list = null;
  		try {
  			list = orderDrawCoinMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootOrderDrawCoinService-selectOrderDrawCoinByOrderNo)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		OrderDrawCoin orderDrawCoin = null;
  		if(list != null && !list.isEmpty()) {
  			orderDrawCoin = list.get(0);
  		}
  		return orderDrawCoin;
  	}

  	/**
  	 * 插入提币订单
  	 * @param orderDrawCoin
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer insertOrderDrawCoin(OrderDrawCoin orderDrawCoin) throws BootServiceException {
  		logger.info("(BootOrderDrawCoinService-insertOrderDrawCoin)-插入提币订单-传入参数, orderDrawCoin:{}", orderDrawCoin);
  		orderDrawCoin.setStatus(SqlWheelConstants.SQL_ORDER_RECHARGE_COIN_STATUS_NO);
  		orderDrawCoin.setCreateTime(new Date());
  		orderDrawCoin.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = orderDrawCoinMapper.insertSelective(orderDrawCoin);
  		} catch (Exception e) {
  			logger.error("(BootOrderDrawCoinService-insertOrderDrawCoin)-插入提币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 修改提币订单
  	 * @param orderDrawCoin
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer modifyOrderDrawCoin(OrderDrawCoin orderDrawCoin) throws BootServiceException {
  		logger.info("(BootOrderDrawCoinService-modifyOrderDrawCoin)-修改提币订单-传入参数, orderDrawCoin:{}", orderDrawCoin);
  		orderDrawCoin.setCompleteTime(new Date());
  		orderDrawCoin.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = orderDrawCoinMapper.updateByPrimaryKeySelective(orderDrawCoin);
  		} catch (Exception e) {
  			logger.error("(BootOrderDrawCoinService-modifyOrderDrawCoin)-修改提币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 根据id删除提币订单
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer deleteOrderDrawCoinById(Long id) throws BootServiceException {
  		logger.info("(BootOrderDrawCoinService-deleteOrderDrawCoinById)-根据id删除提币订单-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = orderDrawCoinMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootOrderDrawCoinService-deleteOrderDrawCoinById)-根据id删除提币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

}