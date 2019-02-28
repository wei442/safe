package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.OrderDrawCoinParam;
import com.ochain.provider.wheel.po.OrderDrawCoin;

public interface IBootOrderDrawCoinService {

	/**
  	 * 分页查询
  	 * @param page
  	 * @param orderDrawCoinParam
  	 * @return List<OrderDrawCoin>
  	 * @throws BootServiceException
  	 */
  	public List<OrderDrawCoin> selectOrderDrawCoinListByPage(Page<OrderDrawCoin> page, OrderDrawCoinParam orderDrawCoinParam) throws BootServiceException;

  	/**
  	 * 不分页查询
  	 * @param orderDrawCoinParam
  	 * @return List<OrderDrawCoin>
  	 * @throws BootServiceException
  	 */
	public List<OrderDrawCoin> selectOrderDrawCoinList(OrderDrawCoinParam orderDrawCoinParam) throws BootServiceException;

  	/**
  	 * 根据id查询提币订单
  	 * @param id
  	 * @return OrderDrawCoin
  	 * @throws BootServiceException
  	 */
  	public OrderDrawCoin selectOrderDrawCoinById(Long id) throws BootServiceException;

  	/**
  	 * 根据orderNo查询提币订单
  	 * @param orderNo
  	 * @return OrderDrawCoin
  	 * @throws BootServiceException
  	 */
	public OrderDrawCoin selectOrderDrawCoinByOrderNo(Long orderNo) throws BootServiceException;

  	/**
  	 * 插入提币订单
  	 * @param orderDrawCoin
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer insertOrderDrawCoin(OrderDrawCoin orderDrawCoin) throws BootServiceException;

  	/**
  	 * 修改提币订单
  	 * @param orderDrawCoin
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer modifyOrderDrawCoin(OrderDrawCoin orderDrawCoin) throws BootServiceException;

  	/**
  	 * 根据id删除提币订单
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer deleteOrderDrawCoinById(Long id) throws BootServiceException;

}