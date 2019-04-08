package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.po.UserAdminLoginExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAdminLoginMapper {
    long countByExample(UserAdminLoginExample example);

    int deleteByExample(UserAdminLoginExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAdminLogin record);

    int insertSelective(UserAdminLogin record);

    List<UserAdminLogin> selectByExample(UserAdminLoginExample example);

    UserAdminLogin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAdminLogin record, @Param("example") UserAdminLoginExample example);

    int updateByExample(@Param("record") UserAdminLogin record, @Param("example") UserAdminLoginExample example);

    int updateByPrimaryKeySelective(UserAdminLogin record);

    int updateByPrimaryKey(UserAdminLogin record);
}