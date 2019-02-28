package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.CarOrderRecord;
import com.ochain.provider.wheel.vo.gofun.CarOrderVo;

public interface IBootCarOrderRecordService {

	/**
  	 * 分页查询
  	 * @param page
  	 * @param carOrderRecord
  	 * @return List<CarOrderRecord>
  	 * @throws BootServiceException
  	 */
  	public List<CarOrderRecord> selectCarOrderRecordListByPage(Page<CarOrderRecord> page, CarOrderRecord carOrderRecord) throws BootServiceException;

  	/**
  	 * 不分页查询
  	 * @param carOrderRecord
  	 * @return List<CarOrderRecord>
  	 * @throws BootServiceException
  	 */
	public List<CarOrderRecord> selectCarOrderRecordList(CarOrderRecord carOrderRecord) throws BootServiceException;

  	/**
  	 * 根据id查询用车订单记录
  	 * @param id
  	 * @return CarOrderRecord
  	 * @throws BootServiceException
  	 */
	public CarOrderRecord selectCarOrderRecordById(Long id) throws BootServiceException;

  	/**
  	 * 插入用车订单记录
  	 * @param carOrderRecord
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
	public Integer insertCarOrderRecord(CarOrderRecord carOrderRecord) throws BootServiceException;

  	/**
  	 * 修改用车订单记录
  	 * @param carOrderRecord
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
	public Integer modifyCarOrderRecord(CarOrderRecord carOrderRecord) throws BootServiceException;

  	/**
  	 * 根据id删除用车订单记录
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
	public Integer deleteCarOrderRecordById(Long id) throws BootServiceException;

  	/**
  	 * 根据userId查询用户订单记录列表
  	 * @param userId
  	 * @param orderTimeStr
  	 * @return CarOrderVo
  	 * @throws BootServiceException
  	 */
  	public CarOrderVo selectCarOrderVoByUserId(Integer userId,String orderTimeStr) throws BootServiceException;

}