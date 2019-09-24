package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.DangerCheck;
import com.cloud.provider.safe.po.DangerCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DangerCheckMapper {
    long countByExample(DangerCheckExample example);

    int deleteByExample(DangerCheckExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DangerCheck record);

    int insertSelective(DangerCheck record);

    List<DangerCheck> selectByExample(DangerCheckExample example);

    DangerCheck selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DangerCheck record, @Param("example") DangerCheckExample example);

    int updateByExample(@Param("record") DangerCheck record, @Param("example") DangerCheckExample example);

    int updateByPrimaryKeySelective(DangerCheck record);

    int updateByPrimaryKey(DangerCheck record);
}