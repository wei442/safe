package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.GCoupon;
import com.ochain.provider.wheel.po.GCouponExample;

public interface GCouponMapper {
    int countByExample(GCouponExample example);

    int deleteByExample(GCouponExample example);

    int deleteByPrimaryKey(String gCouponId);

    int insert(GCoupon record);

    int insertSelective(GCoupon record);

    List<GCoupon> selectByExample(GCouponExample example);

    GCoupon selectByPrimaryKey(String gCouponId);

    int updateByExampleSelective(@Param("record") GCoupon record, @Param("example") GCouponExample example);

    int updateByExample(@Param("record") GCoupon record, @Param("example") GCouponExample example);

    int updateByPrimaryKeySelective(GCoupon record);

    int updateByPrimaryKey(GCoupon record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<GCoupon>
     */
    public List<GCoupon> selectByExample(Page<GCoupon> page, GCouponExample example);

}