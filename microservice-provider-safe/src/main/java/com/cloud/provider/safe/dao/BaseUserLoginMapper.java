package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.BaseUserLogin;
import com.cloud.provider.safe.po.BaseUserLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserLoginMapper {
    long countByExample(BaseUserLoginExample example);

    int deleteByExample(BaseUserLoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserLogin record);

    int insertSelective(BaseUserLogin record);

    List<BaseUserLogin> selectByExample(BaseUserLoginExample example);

    BaseUserLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseUserLogin record, @Param("example") BaseUserLoginExample example);

    int updateByExample(@Param("record") BaseUserLogin record, @Param("example") BaseUserLoginExample example);

    int updateByPrimaryKeySelective(BaseUserLogin record);

    int updateByPrimaryKey(BaseUserLogin record);
}