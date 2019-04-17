package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.BaseUserLoginLog;
import com.cloud.provider.safe.po.BaseUserLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserLoginLogMapper {
    long countByExample(BaseUserLoginLogExample example);

    int deleteByExample(BaseUserLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BaseUserLoginLog record);

    int insertSelective(BaseUserLoginLog record);

    List<BaseUserLoginLog> selectByExample(BaseUserLoginLogExample example);

    BaseUserLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BaseUserLoginLog record, @Param("example") BaseUserLoginLogExample example);

    int updateByExample(@Param("record") BaseUserLoginLog record, @Param("example") BaseUserLoginLogExample example);

    int updateByPrimaryKeySelective(BaseUserLoginLog record);

    int updateByPrimaryKey(BaseUserLoginLog record);
}