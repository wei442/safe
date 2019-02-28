package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.OrderRechargeCoinParam;
import com.ochain.provider.wheel.po.OrderRechargeCoin;

public interface IBootOrderRechargeCoinService {

	/**
  	 * 分页查询
  	 * @param page
  	 * @param orderRechargeCoinParam
  	 * @return List<OrderRechargeCoin>
  	 * @throws BootServiceException
  	 */
	public List<OrderRechargeCoin> selectOrderRechargeCoinListByPage(Page<OrderRechargeCoin> page, OrderRechargeCoinParam orderRechargeCoinParam) throws BootServiceException;

  	/**
  	 * 不分页查询
  	 * @param orderRechargeCoinParam
  	 * @return List<OrderRechargeCoin>
  	 * @throws BootServiceException
  	 */
	public List<OrderRechargeCoin> selectOrderRechargeCoinList(OrderRechargeCoinParam orderRechargeCoinParam) throws BootServiceException;

  	/**
  	 * 根据id查询充币订单
  	 * @param id
  	 * @return OrderRechargeCoin
  	 * @throws BootServiceException
  	 */
  	public OrderRechargeCoin selectOrderRechargeCoinById(Long id) throws BootServiceException;

  	/**
  	 * 根据orderNo查询充币订单
  	 * @param orderNo
  	 * @return OrderRechargeCoin
  	 * @throws BootServiceException
  	 */
  	public OrderRechargeCoin selectOrderRechargeCoinByOrderNo(Long orderNo) throws BootServiceException;

  	/**
  	 * 插入充币订单
  	 * @param orderRechargeCoin
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer insertOrderRechargeCoin(OrderRechargeCoin orderRechargeCoin) throws BootServiceException;

  	/**
  	 * 修改充币订单
  	 * @param orderRechargeCoin
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer modifyOrderRechargeCoin(OrderRechargeCoin orderRechargeCoin) throws BootServiceException;

  	/**
  	 * 根据id删除充币订单
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer deleteOrderRechargeCoinById(Long id) throws BootServiceException;

}