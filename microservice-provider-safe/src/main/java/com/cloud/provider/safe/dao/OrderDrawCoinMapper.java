package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.OrderDrawCoin;
import com.ochain.provider.wheel.po.OrderDrawCoinExample;

public interface OrderDrawCoinMapper {
	long countByExample(OrderDrawCoinExample example);

    int deleteByExample(OrderDrawCoinExample example);

    int deleteByPrimaryKey(Long orderDrawCoinId);

    int insert(OrderDrawCoin record);

    int insertSelective(OrderDrawCoin record);

    List<OrderDrawCoin> selectByExample(OrderDrawCoinExample example);

    OrderDrawCoin selectByPrimaryKey(Long orderDrawCoinId);

    int updateByExampleSelective(@Param("record") OrderDrawCoin record, @Param("example") OrderDrawCoinExample example);

    int updateByExample(@Param("record") OrderDrawCoin record, @Param("example") OrderDrawCoinExample example);

    int updateByPrimaryKeySelective(OrderDrawCoin record);

    int updateByPrimaryKey(OrderDrawCoin record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<OrderDrawCoin>
     */
    public List<OrderDrawCoin> selectByExample(Page<?> page, OrderDrawCoinExample example);

}