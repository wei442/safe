package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.BaseUserInfo;
import com.cloud.provider.safe.po.BaseUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BaseUserInfoMapper {
    long countByExample(BaseUserInfoExample example);

    int deleteByExample(BaseUserInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BaseUserInfo record);

    int insertSelective(BaseUserInfo record);

    List<BaseUserInfo> selectByExample(BaseUserInfoExample example);

    BaseUserInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BaseUserInfo record, @Param("example") BaseUserInfoExample example);

    int updateByExample(@Param("record") BaseUserInfo record, @Param("example") BaseUserInfoExample example);

    int updateByPrimaryKeySelective(BaseUserInfo record);

    int updateByPrimaryKey(BaseUserInfo record);
}