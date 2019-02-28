package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.CalculateConfig;
import com.ochain.provider.wheel.po.CalculateConfigExample;
import com.ochain.provider.wheel.po.CalculateConfigUpdate;
import com.ochain.provider.wheel.vo.calculate.CalculateConfigMaxCodeVo;

public interface CalculateConfigMapper {
    int countByExample(CalculateConfigExample example);

    int deleteByExample(CalculateConfigExample example);

    int deleteByPrimaryKey(Integer calculateConfigId);

    int insert(CalculateConfig record);

    int insertSelective(CalculateConfig record);

    List<CalculateConfig> selectByExample(CalculateConfigExample example);

    CalculateConfig selectByPrimaryKey(Integer calculateConfigId);

    int updateByExampleSelective(@Param("record") CalculateConfig record, @Param("example") CalculateConfigExample example);

    int updateByExample(@Param("record") CalculateConfig record, @Param("example") CalculateConfigExample example);

    int updateByPrimaryKeySelective(CalculateConfig record);

    int updateByPrimaryKey(CalculateConfig record);

    /**
     * 修改content内容
     * @param record
     * @return
     */
    int updateForContent(CalculateConfigUpdate record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<CalculateConfig>
     */
    public List<CalculateConfig> selectByExample(Page<CalculateConfig> page,CalculateConfigExample example);

    /**
     * 查询最新的code
     * @return CalculateConfigMaxCodeVo
     */
    public CalculateConfigMaxCodeVo selectMaxCalculateCode();
}