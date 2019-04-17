package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.BaseUserPassword;
import com.cloud.provider.safe.po.BaseUserPasswordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserPasswordMapper {
    long countByExample(BaseUserPasswordExample example);

    int deleteByExample(BaseUserPasswordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserPassword record);

    int insertSelective(BaseUserPassword record);

    List<BaseUserPassword> selectByExample(BaseUserPasswordExample example);

    BaseUserPassword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseUserPassword record, @Param("example") BaseUserPasswordExample example);

    int updateByExample(@Param("record") BaseUserPassword record, @Param("example") BaseUserPasswordExample example);

    int updateByPrimaryKeySelective(BaseUserPassword record);

    int updateByPrimaryKey(BaseUserPassword record);
}