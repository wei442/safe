package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.DiamondRecordParam;
import com.ochain.provider.wheel.po.DiamondRecord;
import com.ochain.provider.wheel.po.DiamondRecordExample;
import com.ochain.provider.wheel.vo.diamond.DiamondRecordVo;

public interface DiamondRecordMapper {
	long countByExample(DiamondRecordExample example);

    int deleteByExample(DiamondRecordExample example);

    int deleteByPrimaryKey(Long diamondRecordId);

    int insert(DiamondRecord record);

    int insertSelective(DiamondRecord record);

    List<DiamondRecord> selectByExample(DiamondRecordExample example);

    DiamondRecord selectByPrimaryKey(Long diamondRecordId);

    int updateByExampleSelective(@Param("record") DiamondRecord record, @Param("example") DiamondRecordExample example);

    int updateByExample(@Param("record") DiamondRecord record, @Param("example") DiamondRecordExample example);

    int updateByPrimaryKeySelective(DiamondRecord record);

    int updateByPrimaryKey(DiamondRecord record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<DiamondRecord>
     */
    public List<DiamondRecord> selectByExample(Page<?> page, DiamondRecordExample example);

    /**
     * 据领用时间查询已领取的能量数量
     * @param param
     * @return List<DiamondRecordVo>
     */
    public List<DiamondRecordVo> selectDrawDiamondListByUseTime(DiamondRecordParam param);

    /**
     * 根据创建时间查询未领取的能量数量
     * @param param
     * @return List<DiamondRecordVo>
     */
    public List<DiamondRecordVo> selectNotDrawDiamondListByCreateTime(DiamondRecordParam param);

}