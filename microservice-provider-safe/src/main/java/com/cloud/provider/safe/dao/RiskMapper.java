package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.Risk;
import com.cloud.provider.safe.po.RiskExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskMapper {
    long countByExample(RiskExample example);

    int deleteByExample(RiskExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Risk record);

    int insertSelective(Risk record);

    List<Risk> selectByExample(RiskExample example);

    Risk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Risk record, @Param("example") RiskExample example);

    int updateByExample(@Param("record") Risk record, @Param("example") RiskExample example);

    int updateByPrimaryKeySelective(Risk record);

    int updateByPrimaryKey(Risk record);
}