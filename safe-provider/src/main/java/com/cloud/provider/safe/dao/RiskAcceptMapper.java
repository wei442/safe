package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.RiskAccept;
import com.cloud.provider.safe.po.RiskAcceptExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RiskAcceptMapper {
    long countByExample(RiskAcceptExample example);

    int deleteByExample(RiskAcceptExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RiskAccept record);

    int insertSelective(RiskAccept record);

    List<RiskAccept> selectByExample(RiskAcceptExample example);

    RiskAccept selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RiskAccept record, @Param("example") RiskAcceptExample example);

    int updateByExample(@Param("record") RiskAccept record, @Param("example") RiskAcceptExample example);

    int updateByPrimaryKeySelective(RiskAccept record);

    int updateByPrimaryKey(RiskAccept record);
}