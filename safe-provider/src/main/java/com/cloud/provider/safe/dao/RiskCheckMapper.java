package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.RiskCheck;
import com.cloud.provider.safe.po.RiskCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskCheckMapper {
    long countByExample(RiskCheckExample example);

    int deleteByExample(RiskCheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskCheck record);

    int insertSelective(RiskCheck record);

    List<RiskCheck> selectByExample(RiskCheckExample example);

    RiskCheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskCheck record, @Param("example") RiskCheckExample example);

    int updateByExample(@Param("record") RiskCheck record, @Param("example") RiskCheckExample example);

    int updateByPrimaryKeySelective(RiskCheck record);

    int updateByPrimaryKey(RiskCheck record);
}