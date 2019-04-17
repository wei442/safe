package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserAppLoginLog;
import com.cloud.provider.safe.po.UserAppLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAppLoginLogMapper {
    long countByExample(UserAppLoginLogExample example);

    int deleteByExample(UserAppLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserAppLoginLog record);

    int insertSelective(UserAppLoginLog record);

    List<UserAppLoginLog> selectByExample(UserAppLoginLogExample example);

    UserAppLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserAppLoginLog record, @Param("example") UserAppLoginLogExample example);

    int updateByExample(@Param("record") UserAppLoginLog record, @Param("example") UserAppLoginLogExample example);

    int updateByPrimaryKeySelective(UserAppLoginLog record);

    int updateByPrimaryKey(UserAppLoginLog record);
}