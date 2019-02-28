package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.CouponLogParam;
import com.ochain.provider.wheel.po.CouponLog;
import com.ochain.provider.wheel.po.CouponLogExample;
import com.ochain.provider.wheel.vo.coupon.CouponLogAndGCouponVo;

public interface CouponLogMapper {
	long countByExample(CouponLogExample example);

    int deleteByExample(CouponLogExample example);

    int deleteByPrimaryKey(Long couponLogId);

    int insert(CouponLog record);

    int insertSelective(CouponLog record);

    List<CouponLog> selectByExample(CouponLogExample example);

    CouponLog selectByPrimaryKey(Long couponLogId);

    int updateByExampleSelective(@Param("record") CouponLog record, @Param("example") CouponLogExample example);

    int updateByExample(@Param("record") CouponLog record, @Param("example") CouponLogExample example);

    int updateByPrimaryKeySelective(CouponLog record);

    int updateByPrimaryKey(CouponLog record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<CouponLog>
     */
    public List<CouponLog> selectByExample(Page<CouponLog> page,CouponLogExample example);

    /**
     * 根据参数查询优惠券日志/优惠券关系/gofun优惠券表
     * @param page
     * @param example
     * @return List<CouponLogAndGCouponVo>
     */
    public List<CouponLogAndGCouponVo> selectCouponLogAndGCouponVoListByParam(Page<?> page, CouponLogParam param);

}