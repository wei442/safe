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
import com.ochain.provider.wheel.dao.OrderRechargeCoinMapper;
import com.ochain.provider.wheel.param.OrderRechargeCoinParam;
import com.ochain.provider.wheel.po.OrderRechargeCoin;
import com.ochain.provider.wheel.po.OrderRechargeCoinExample;
import com.ochain.provider.wheel.service.IBootOrderRechargeCoinService;

/**
 * 充币订单 BootOrderRechargeCoinService
 * @author wei.yong
 * @date 2017-10-13
 */
@Service
public class BootOrderRechargeCoinServiceImpl implements IBootOrderRechargeCoinService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //充币订单 Mapper
  	@Autowired
  	private OrderRechargeCoinMapper orderRechargeCoinMapper;

	/**
  	 * 分页查询
  	 * @param page
  	 * @param orderRechargeCoinParam
  	 * @return List<OrderRechargeCoin>
  	 * @throws BootServiceException
  	 */
	@Override
	public List<OrderRechargeCoin> selectOrderRechargeCoinListByPage(Page<OrderRechargeCoin> page, OrderRechargeCoinParam orderRechargeCoinParam) throws BootServiceException {
  		logger.info("(BootOrderRechargeCoinService-selectOrderRechargeCoinListByPage)-分页查询-传入参数, page:{}, orderRechargeCoinParam:{}", page, orderRechargeCoinParam);
  		OrderRechargeCoinExample example = new OrderRechargeCoinExample();
  		example.setOrderByClause(" id desc ");
  		OrderRechargeCoinExample.Criteria criteria = example.createCriteria();
  		if(orderRechargeCoinParam != null) {
  			if(orderRechargeCoinParam.getOrderNo() != null) {
  				criteria.andOrderNoEqualTo(orderRechargeCoinParam.getOrderNo());
  			}
  			if(StringUtils.isNotBlank(orderRechargeCoinParam.getUserAccount())) {
  				criteria.andUserAccountEqualTo(orderRechargeCoinParam.getUserAccount());
  			}
  			if(StringUtils.isNotBlank(orderRechargeCoinParam.getTransactionHash())) {
  				criteria.andTransactionHashEqualTo(orderRechargeCoinParam.getTransactionHash());
  			}
  			if(StringUtils.isNotBlank(orderRechargeCoinParam.getAccountAddrFrom())) {
  				criteria.andAccountAddrFromEqualTo(orderRechargeCoinParam.getAccountAddrFrom());
  			}
  			if(StringUtils.isNotBlank(orderRechargeCoinParam.getAccountAddrTo())) {
  				criteria.andAccountAddrToEqualTo(orderRechargeCoinParam.getAccountAddrTo());
  			}
  			if(orderRechargeCoinParam.getStatus() != null) {
  				criteria.andStatusEqualTo(orderRechargeCoinParam.getStatus());
  			}
  			if(orderRechargeCoinParam.getCompleteTimeStart() != null && orderRechargeCoinParam.getCompleteTimeEnd() == null) {
  				criteria.andCompleteTimeGreaterThanOrEqualTo(orderRechargeCoinParam.getCompleteTimeStart());
  			} else if(orderRechargeCoinParam.getCompleteTimeStart() == null && orderRechargeCoinParam.getCompleteTimeEnd() != null) {
  				criteria.andCompleteTimeLessThanOrEqualTo(orderRechargeCoinParam.getCompleteTimeEnd());
  			} else if(orderRechargeCoinParam.getCompleteTimeStart() != null && orderRechargeCoinParam.getCompleteTimeEnd() != null) {
  				criteria.andCompleteTimeBetween(orderRechargeCoinParam.getCompleteTimeStart(), orderRechargeCoinParam.getCompleteTimeEnd());
  			}
  			if(orderRechargeCoinParam.getCreateTimeStart() != null && orderRechargeCoinParam.getCreateTimeEnd() == null) {
  				criteria.andCreateTimeGreaterThanOrEqualTo(orderRechargeCoinParam.getCreateTimeStart());
  			} else if(orderRechargeCoinParam.getCreateTimeStart() == null && orderRechargeCoinParam.getCreateTimeEnd() != null) {
  				criteria.andCreateTimeLessThanOrEqualTo(orderRechargeCoinParam.getCreateTimeEnd());
  			} else if(orderRechargeCoinParam.getCreateTimeStart() != null && orderRechargeCoinParam.getCreateTimeEnd() != null) {
  				criteria.andCreateTimeBetween(orderRechargeCoinParam.getCreateTimeStart(), orderRechargeCoinParam.getCreateTimeEnd());
  			}
  		}

  		List<OrderRechargeCoin> list = null;
  		try {
  			list = orderRechargeCoinMapper.selectByExample(page, example);
  		} catch (Exception e) {
  			logger.error("(BootOrderRechargeCoinService-selectOrderRechargeCoinListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 不分页查询
  	 * @param orderRechargeCoinParam
  	 * @return List<OrderRechargeCoin>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<OrderRechargeCoin> selectOrderRechargeCoinList(OrderRechargeCoinParam orderRechargeCoinParam) throws BootServiceException {
  		logger.info("(BootOrderRechargeCoinService-selectOrderRechargeCoinList)-不分页查询-传入参数, orderRechargeCoinParam:{}", orderRechargeCoinParam);
  		OrderRechargeCoinExample example = new OrderRechargeCoinExample();
  		example.setOrderByClause(" id desc ");
  		OrderRechargeCoinExample.Criteria criteria = example.createCriteria();
  		if(orderRechargeCoinParam != null) {
  			if(orderRechargeCoinParam.getOrderNo() != null) {
  				criteria.andOrderNoEqualTo(orderRechargeCoinParam.getOrderNo());
  			}
  			if(StringUtils.isNotBlank(orderRechargeCoinParam.getUserAccount())) {
  				criteria.andUserAccountEqualTo(orderRechargeCoinParam.getUserAccount());
  			}
  			if(StringUtils.isNotBlank(orderRechargeCoinParam.getTransactionHash())) {
  				criteria.andTransactionHashEqualTo(orderRechargeCoinParam.getTransactionHash());
  			}
  			if(StringUtils.isNotBlank(orderRechargeCoinParam.getAccountAddrFrom())) {
  				criteria.andAccountAddrFromEqualTo(orderRechargeCoinParam.getAccountAddrFrom());
  			}
  			if(StringUtils.isNotBlank(orderRechargeCoinParam.getAccountAddrTo())) {
  				criteria.andAccountAddrToEqualTo(orderRechargeCoinParam.getAccountAddrTo());
  			}
  			if(orderRechargeCoinParam.getStatus() != null) {
  				criteria.andStatusEqualTo(orderRechargeCoinParam.getStatus());
  			}
  			if(orderRechargeCoinParam.getCompleteTimeStart() != null && orderRechargeCoinParam.getCompleteTimeEnd() == null) {
  				criteria.andCompleteTimeGreaterThanOrEqualTo(orderRechargeCoinParam.getCompleteTimeStart());
  			} else if(orderRechargeCoinParam.getCompleteTimeStart() == null && orderRechargeCoinParam.getCompleteTimeEnd() != null) {
  				criteria.andCompleteTimeLessThanOrEqualTo(orderRechargeCoinParam.getCompleteTimeEnd());
  			} else if(orderRechargeCoinParam.getCompleteTimeStart() != null && orderRechargeCoinParam.getCompleteTimeEnd() != null) {
  				criteria.andCompleteTimeBetween(orderRechargeCoinParam.getCompleteTimeStart(), orderRechargeCoinParam.getCompleteTimeEnd());
  			}
  			if(orderRechargeCoinParam.getCreateTimeStart() != null && orderRechargeCoinParam.getCreateTimeEnd() == null) {
  				criteria.andCreateTimeGreaterThanOrEqualTo(orderRechargeCoinParam.getCreateTimeStart());
  			} else if(orderRechargeCoinParam.getCreateTimeStart() == null && orderRechargeCoinParam.getCreateTimeEnd() != null) {
  				criteria.andCreateTimeLessThanOrEqualTo(orderRechargeCoinParam.getCreateTimeEnd());
  			} else if(orderRechargeCoinParam.getCreateTimeStart() != null && orderRechargeCoinParam.getCreateTimeEnd() != null) {
  				criteria.andCreateTimeBetween(orderRechargeCoinParam.getCreateTimeStart(), orderRechargeCoinParam.getCreateTimeEnd());
  			}
  		}


  		List<OrderRechargeCoin> list = null;
  		try {
  			list = orderRechargeCoinMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootOrderRechargeCoinService-selectOrderRechargeCoinList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 根据id查询充币订单
  	 * @param id
  	 * @return OrderRechargeCoin
  	 * @throws BootServiceException
  	 */
  	@Override
	public OrderRechargeCoin selectOrderRechargeCoinById(Long id) throws BootServiceException {
  		logger.info("(BootOrderRechargeCoinService-selectOrderRechargeCoinById)-根据id查询充币订单-传入参数, id:{}", id);
  		OrderRechargeCoin orderRechargeCoin = null;
  		try {
  			orderRechargeCoin = orderRechargeCoinMapper.selectByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootOrderRechargeCoinService-selectOrderRechargeCoinById)-根据id查询充币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return orderRechargeCoin;
  	}

  	/**
  	 * 根据orderNo查询充币订单
  	 * @param orderNo
  	 * @return OrderRechargeCoin
  	 * @throws BootServiceException
  	 */
  	@Override
	public OrderRechargeCoin selectOrderRechargeCoinByOrderNo(Long orderNo) throws BootServiceException {
  		logger.info("(BootOrderRechargeCoinService-selectOrderRechargeCoinByOrderNo)-根据orderNo查询充币订单-传入参数, orderNo:{}", orderNo);
  		OrderRechargeCoinExample example = new OrderRechargeCoinExample();
  		OrderRechargeCoinExample.Criteria criteria = example.createCriteria();
  		criteria.andOrderNoEqualTo(orderNo);
  		List<OrderRechargeCoin> list = null;
  		try {
  			list = orderRechargeCoinMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootOrderRechargeCoinService-selectOrderRechargeCoinByOrderNo)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		OrderRechargeCoin orderRechargeCoin = null;
  		if(list != null && !list.isEmpty()) {
  			orderRechargeCoin = list.get(0);
  		}
  		return orderRechargeCoin;
  	}

  	/**
  	 * 插入充币订单
  	 * @param orderRechargeCoin
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer insertOrderRechargeCoin(OrderRechargeCoin orderRechargeCoin) throws BootServiceException {
  		logger.info("(BootOrderRechargeCoinService-insertOrderRechargeCoin)-插入充币订单-传入参数, orderRechargeCoin:{}", orderRechargeCoin);
  		orderRechargeCoin.setStatus(SqlWheelConstants.SQL_ORDER_RECHARGE_COIN_STATUS_NO);
  		orderRechargeCoin.setCreateTime(new Date());
  		orderRechargeCoin.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = orderRechargeCoinMapper.insertSelective(orderRechargeCoin);
  		} catch (Exception e) {
  			logger.error("(BootOrderRechargeCoinService-insertOrderRechargeCoin)-插入充币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 修改充币订单
  	 * @param orderRechargeCoin
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer modifyOrderRechargeCoin(OrderRechargeCoin orderRechargeCoin) throws BootServiceException {
  		logger.info("(BootOrderRechargeCoinService-modifyOrderRechargeCoin)-修改充币订单-传入参数, orderRechargeCoin:{}", orderRechargeCoin);
  		orderRechargeCoin.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = orderRechargeCoinMapper.updateByPrimaryKeySelective(orderRechargeCoin);
  		} catch (Exception e) {
  			logger.error("(BootOrderRechargeCoinService-modifyOrderRechargeCoin)-修改充币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 根据id删除充币订单
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer deleteOrderRechargeCoinById(Long id) throws BootServiceException {
  		logger.info("(BootOrderRechargeCoinService-deleteOrderRechargeCoinById)-根据id删除充币订单-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = orderRechargeCoinMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootOrderRechargeCoinService-deleteOrderRechargeCoinById)-根据id删除充币订单-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

}