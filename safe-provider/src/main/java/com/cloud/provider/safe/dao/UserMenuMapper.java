package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserMenu;
import com.cloud.provider.safe.po.UserMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMenuMapper {
    long countByExample(UserMenuExample example);

    int deleteByExample(UserMenuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserMenu record);

    int insertSelective(UserMenu record);

    List<UserMenu> selectByExample(UserMenuExample example);

    UserMenu selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserMenu record, @Param("example") UserMenuExample example);

    int updateByExample(@Param("record") UserMenu record, @Param("example") UserMenuExample example);

    int updateByPrimaryKeySelective(UserMenu record);

    int updateByPrimaryKey(UserMenu record);
}