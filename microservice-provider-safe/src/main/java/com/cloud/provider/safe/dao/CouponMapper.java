package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.CouponParam;
import com.ochain.provider.wheel.po.Coupon;
import com.ochain.provider.wheel.po.CouponExample;
import com.ochain.provider.wheel.vo.coupon.CouponAndGCouponVo;

public interface CouponMapper {
    int countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(Integer couponId);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(Integer couponId);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<Coupon>
     */
    public List<Coupon> selectByExample(Page<Coupon> page,CouponExample example);

    /**
     * 根据参数查询优惠券/优惠券关系/gofun优惠券表
     * @param page
     * @param param
     * @return
     */
    public List<CouponAndGCouponVo> selectCouponAndGCouponVoListByParam(Page<?> page, CouponParam param);

}