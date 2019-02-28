package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.FeeConfig;
import com.ochain.provider.wheel.po.FeeConfigExample;

public interface FeeConfigMapper {
	long countByExample(FeeConfigExample example);

    int deleteByExample(FeeConfigExample example);

    int deleteByPrimaryKey(Integer feeConfigId);

    int insert(FeeConfig record);

    int insertSelective(FeeConfig record);

    List<FeeConfig> selectByExample(FeeConfigExample example);

    FeeConfig selectByPrimaryKey(Integer feeConfigId);

    int updateByExampleSelective(@Param("record") FeeConfig record, @Param("example") FeeConfigExample example);

    int updateByExample(@Param("record") FeeConfig record, @Param("example") FeeConfigExample example);

    int updateByPrimaryKeySelective(FeeConfig record);

    int updateByPrimaryKey(FeeConfig record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<FeeConfig>
     */
    public List<FeeConfig> selectByExample(Page<?> page, FeeConfigExample example);

}