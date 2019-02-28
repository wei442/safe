package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.CouponGCoupon;
import com.ochain.provider.wheel.po.CouponGCouponExample;

public interface CouponGCouponMapper {
    int countByExample(CouponGCouponExample example);

    int deleteByExample(CouponGCouponExample example);

    int deleteByPrimaryKey(Integer couponGCouponId);

    int insert(CouponGCoupon record);

    int insertSelective(CouponGCoupon record);

    List<CouponGCoupon> selectByExample(CouponGCouponExample example);

    CouponGCoupon selectByPrimaryKey(Integer couponGCouponId);

    int updateByExampleSelective(@Param("record") CouponGCoupon record, @Param("example") CouponGCouponExample example);

    int updateByExample(@Param("record") CouponGCoupon record, @Param("example") CouponGCouponExample example);

    int updateByPrimaryKeySelective(CouponGCoupon record);

    int updateByPrimaryKey(CouponGCoupon record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<CouponGCoupon>
     */
    public List<CouponGCoupon> selectByExample(Page<CouponGCoupon> page, CouponGCouponExample example);

}