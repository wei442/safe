package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserOrg;
import com.cloud.provider.safe.po.UserOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOrgMapper {
    long countByExample(UserOrgExample example);

    int deleteByExample(UserOrgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserOrg record);

    int insertSelective(UserOrg record);

    List<UserOrg> selectByExample(UserOrgExample example);

    UserOrg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserOrg record, @Param("example") UserOrgExample example);

    int updateByExample(@Param("record") UserOrg record, @Param("example") UserOrgExample example);

    int updateByPrimaryKeySelective(UserOrg record);

    int updateByPrimaryKey(UserOrg record);
}