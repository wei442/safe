package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserAdminPassword;
import com.cloud.provider.safe.po.UserAdminPasswordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAdminPasswordMapper {
    long countByExample(UserAdminPasswordExample example);

    int deleteByExample(UserAdminPasswordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAdminPassword record);

    int insertSelective(UserAdminPassword record);

    List<UserAdminPassword> selectByExample(UserAdminPasswordExample example);

    UserAdminPassword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAdminPassword record, @Param("example") UserAdminPasswordExample example);

    int updateByExample(@Param("record") UserAdminPassword record, @Param("example") UserAdminPasswordExample example);

    int updateByPrimaryKeySelective(UserAdminPassword record);

    int updateByPrimaryKey(UserAdminPassword record);
}