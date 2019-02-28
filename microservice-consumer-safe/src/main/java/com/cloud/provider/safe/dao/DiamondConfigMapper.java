package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.DiamondConfig;
import com.ochain.provider.wheel.po.DiamondConfigExample;
import com.ochain.provider.wheel.vo.diamond.DiamondConfigMaxCodeVo;

public interface DiamondConfigMapper {
    int countByExample(DiamondConfigExample example);

    int deleteByExample(DiamondConfigExample example);

    int deleteByPrimaryKey(Integer diamondConfigId);

    int insert(DiamondConfig record);

    int insertSelective(DiamondConfig record);

    List<DiamondConfig> selectByExample(DiamondConfigExample example);

    DiamondConfig selectByPrimaryKey(Integer diamondConfigId);

    int updateByExampleSelective(@Param("record") DiamondConfig record, @Param("example") DiamondConfigExample example);

    int updateByExample(@Param("record") DiamondConfig record, @Param("example") DiamondConfigExample example);

    int updateByPrimaryKeySelective(DiamondConfig record);

    int updateByPrimaryKey(DiamondConfig record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<DiamondConfig>
     */
    public List<DiamondConfig> selectByExample(Page<DiamondConfig> page,DiamondConfigExample example);

    /**
     * 查询最新的code
     * @return DiamondConfigMaxCodeVo
     */
    public DiamondConfigMaxCodeVo selectMaxDiamondCode();

    /**
     * 查询发放能量总数
     * @return DiamondConfigMaxCodeVo
     */
    public List<DiamondConfigMaxCodeVo> selectSendDiamondSumList();

}