package com.ochain.provider.wheel.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.CarOrderRecordMapper;
import com.ochain.provider.wheel.param.CarOrderParam;
import com.ochain.provider.wheel.po.CarOrderRecord;
import com.ochain.provider.wheel.po.CarOrderRecordExample;
import com.ochain.provider.wheel.service.IBootCarOrderRecordService;
import com.ochain.provider.wheel.vo.gofun.CarOrderVo;

/**
 * 用车订单记录 BootCarOrderRecordService
 * @author wei.yong
 * @date 2017-08-28
 */
@Service
public class BootCarOrderRecordServiceImpl implements IBootCarOrderRecordService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //用车订单记录 Mapper
  	@Autowired
  	private CarOrderRecordMapper carOrderRecordMapper;

	/**
  	 * 分页查询
  	 * @param page
  	 * @param carOrderRecord
  	 * @return List<CarOrderRecord>
  	 * @throws BootServiceException
  	 */
  	@Override
  	public List<CarOrderRecord> selectCarOrderRecordListByPage(Page<CarOrderRecord> page, CarOrderRecord carOrderRecord) throws BootServiceException {
  		logger.info("(BootCarOrderRecordService-selectCarOrderRecordListByPage)-分页查询-传入参数, page:{}, carOrderRecord:{}", page, carOrderRecord);
  		CarOrderRecordExample example = new CarOrderRecordExample();
  		example.setOrderByClause(" id desc ");
  		CarOrderRecordExample.Criteria criteria = example.createCriteria();
  		if(carOrderRecord != null) {
  			if(carOrderRecord.getUserId() != null) {
  				criteria.andUserIdEqualTo(carOrderRecord.getUserId());
  			}
  		}

  		List<CarOrderRecord> list = null;
  		try {
  			list = carOrderRecordMapper.selectByExample(page, example);
  		} catch (Exception e) {
  			logger.error("(BootCarOrderRecordService-selectCarOrderRecordListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 不分页查询
  	 * @param carOrderRecord
  	 * @return List<CarOrderRecord>
  	 * @throws BootServiceException
  	 */
  	@Override
	public List<CarOrderRecord> selectCarOrderRecordList(CarOrderRecord carOrderRecord) throws BootServiceException {
  		logger.info("(BootCarOrderRecordService-selectCarOrderRecordList)-不分页查询-传入参数, carOrderRecord:{}", carOrderRecord);
  		CarOrderRecordExample example = new CarOrderRecordExample();
  		example.setOrderByClause(" id desc ");
  		CarOrderRecordExample.Criteria criteria = example.createCriteria();
  		if(carOrderRecord != null) {
  		}

  		List<CarOrderRecord> list = null;
  		try {
  			list = carOrderRecordMapper.selectByExample(example);
  		} catch (Exception e) {
  			logger.error("(BootCarOrderRecordService-selectCarOrderRecordList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return list;
  	}

  	/**
  	 * 根据id查询用车订单记录
  	 * @param id
  	 * @return CarOrderRecord
  	 * @throws BootServiceException
  	 */
  	@Override
	public CarOrderRecord selectCarOrderRecordById(Long id) throws BootServiceException {
  		logger.info("(BootCarOrderRecordService-selectCarOrderRecordById)-根据id查询用车订单记录-传入参数, id:{}", id);
  		CarOrderRecord carOrderRecord = null;
  		try {
  			carOrderRecord = carOrderRecordMapper.selectByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootCarOrderRecordService-selectCarOrderRecordById)-根据id查询用车订单记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		return carOrderRecord;
  	}

  	/**
  	 * 插入用车订单记录
  	 * @param carOrderRecord
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer insertCarOrderRecord(CarOrderRecord carOrderRecord) throws BootServiceException {
  		logger.info("(BootCarOrderRecordService-insertCarOrderRecord)-插入用车订单记录-传入参数, carOrderRecord:{}", carOrderRecord);
  		carOrderRecord.setOrderTime(new Date());
  		carOrderRecord.setCreateTime(new Date());
  		carOrderRecord.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = carOrderRecordMapper.insertSelective(carOrderRecord);
  		} catch (Exception e) {
  			logger.error("(BootCarOrderRecordService-insertCarOrderRecord)-插入用车订单记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 修改用车订单记录
  	 * @param carOrderRecord
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer modifyCarOrderRecord(CarOrderRecord carOrderRecord) throws BootServiceException {
  		logger.info("(BootCarOrderRecordService-modifyCarOrderRecord)-修改用车订单记录-传入参数, carOrderRecord:{}", carOrderRecord);
  		carOrderRecord.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = carOrderRecordMapper.updateByPrimaryKeySelective(carOrderRecord);
  		} catch (Exception e) {
  			logger.error("(BootCarOrderRecordService-modifyCarOrderRecord)-修改用车订单记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 根据id删除用车订单记录
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	@Override
	public Integer deleteCarOrderRecordById(Long id) throws BootServiceException {
  		logger.info("(BootCarOrderRecordService-deleteCarOrderRecordById)-根据id删除用车订单记录-传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = carOrderRecordMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootCarOrderRecordService-deleteCarOrderRecordById)-根据id删除用车订单记录-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
  		return i;
  	}

  	/**
  	 * 根据userId查询用户订单记录列表
  	 * @param userId
  	 * @param orderTimeStr
  	 * @return CarOrderVo
  	 * @throws BootServiceException
  	 */
  	@Override
  	public CarOrderVo selectCarOrderVoByUserId(Integer userId,String orderTimeStr) throws BootServiceException {
  		logger.info("(BootCarOrderRecordService-selectCarOrderVoByUserId)-根据userId查询用户订单记录列表-传入参数, userId:{}, orderTimeStr:{}", userId, orderTimeStr);
  		CarOrderParam param = new CarOrderParam();
  		param.setUserId(userId);
  		param.setOrderTimeStartStr(orderTimeStr+DateFormatConstants.TIME_START);
  		param.setOrderTimeEndStr(orderTimeStr+DateFormatConstants.TIME_END);
  		List<CarOrderRecord> list = null;
  		try {
  			list = carOrderRecordMapper.selectCarOrderRecordListByUserId(param);
  		} catch (Exception e) {
  			logger.error("(BootCarOrderRecordService-selectCarOrderVoByUserId)-根据userId查询用户订单记录列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		CarOrderVo carOrderVo = null;
  		if(list != null && !list.isEmpty()) {
  			int size = list.size();
  			int index = RandomUtils.nextInt(0, size);
  			CarOrderRecord carOrderRecord = (CarOrderRecord) CollectionUtils.get(list, index);

  			String content = carOrderRecord.getContent();
  			carOrderVo = JSONObject.parseObject(content, CarOrderVo.class);
  		}
  		return carOrderVo;
  	}

}