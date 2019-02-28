package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.CarOrderParam;
import com.ochain.provider.wheel.po.CarOrderRecord;
import com.ochain.provider.wheel.po.CarOrderRecordExample;

public interface CarOrderRecordMapper {
	long countByExample(CarOrderRecordExample example);

    int deleteByExample(CarOrderRecordExample example);

    int deleteByPrimaryKey(Long carOrderRecordId);

    int insert(CarOrderRecord record);

    int insertSelective(CarOrderRecord record);

    List<CarOrderRecord> selectByExample(CarOrderRecordExample example);

    CarOrderRecord selectByPrimaryKey(Long carOrderRecordId);

    int updateByExampleSelective(@Param("record") CarOrderRecord record, @Param("example") CarOrderRecordExample example);

    int updateByExample(@Param("record") CarOrderRecord record, @Param("example") CarOrderRecordExample example);

    int updateByPrimaryKeySelective(CarOrderRecord record);

    int updateByPrimaryKey(CarOrderRecord record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<CarOrderRecord>
     */
    public List<CarOrderRecord> selectByExample(Page<?> page, CarOrderRecordExample example);

    /**
     * 根据订单时间查询用户订单记录列表
     * @param param
     * @return List<CarOrderRecord>
     */
    public List<CarOrderRecord> selectCarOrderRecordListByUserId(CarOrderParam param);

}