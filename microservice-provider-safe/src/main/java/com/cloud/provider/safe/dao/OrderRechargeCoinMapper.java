package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.OrderRechargeCoin;
import com.ochain.provider.wheel.po.OrderRechargeCoinExample;

public interface OrderRechargeCoinMapper {
	long countByExample(OrderRechargeCoinExample example);

    int deleteByExample(OrderRechargeCoinExample example);

    int deleteByPrimaryKey(Long orderRechargeCoinId);

    int insert(OrderRechargeCoin record);

    int insertSelective(OrderRechargeCoin record);

    List<OrderRechargeCoin> selectByExample(OrderRechargeCoinExample example);

    OrderRechargeCoin selectByPrimaryKey(Long orderRechargeCoinId);

    int updateByExampleSelective(@Param("record") OrderRechargeCoin record, @Param("example") OrderRechargeCoinExample example);

    int updateByExample(@Param("record") OrderRechargeCoin record, @Param("example") OrderRechargeCoinExample example);

    int updateByPrimaryKeySelective(OrderRechargeCoin record);

    int updateByPrimaryKey(OrderRechargeCoin record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<OrderRechargeCoin>
     */
    public List<OrderRechargeCoin> selectByExample(Page<?> page, OrderRechargeCoinExample example);

}