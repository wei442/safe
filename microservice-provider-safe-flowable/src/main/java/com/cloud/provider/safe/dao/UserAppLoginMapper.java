package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserAppLogin;
import com.cloud.provider.safe.po.UserAppLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAppLoginMapper {
    long countByExample(UserAppLoginExample example);

    int deleteByExample(UserAppLoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAppLogin record);

    int insertSelective(UserAppLogin record);

    List<UserAppLogin> selectByExample(UserAppLoginExample example);

    UserAppLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAppLogin record, @Param("example") UserAppLoginExample example);

    int updateByExample(@Param("record") UserAppLogin record, @Param("example") UserAppLoginExample example);

    int updateByPrimaryKeySelective(UserAppLogin record);

    int updateByPrimaryKey(UserAppLogin record);
}