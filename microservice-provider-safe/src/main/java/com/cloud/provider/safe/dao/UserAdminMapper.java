package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserAdmin;
import com.cloud.provider.safe.po.UserAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAdminMapper {
    long countByExample(UserAdminExample example);

    int deleteByExample(UserAdminExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAdmin record);

    int insertSelective(UserAdmin record);

    List<UserAdmin> selectByExample(UserAdminExample example);

    UserAdmin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAdmin record, @Param("example") UserAdminExample example);

    int updateByExample(@Param("record") UserAdmin record, @Param("example") UserAdminExample example);

    int updateByPrimaryKeySelective(UserAdmin record);

    int updateByPrimaryKey(UserAdmin record);
}