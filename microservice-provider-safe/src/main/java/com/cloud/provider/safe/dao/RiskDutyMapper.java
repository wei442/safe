package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.RiskDuty;
import com.cloud.provider.safe.po.RiskDutyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskDutyMapper {
    long countByExample(RiskDutyExample example);

    int deleteByExample(RiskDutyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskDuty record);

    int insertSelective(RiskDuty record);

    List<RiskDuty> selectByExample(RiskDutyExample example);

    RiskDuty selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskDuty record, @Param("example") RiskDutyExample example);

    int updateByExample(@Param("record") RiskDuty record, @Param("example") RiskDutyExample example);

    int updateByPrimaryKeySelective(RiskDuty record);

    int updateByPrimaryKey(RiskDuty record);
}