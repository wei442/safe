package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserTitle;
import com.cloud.provider.safe.po.UserTitleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTitleMapper {
    long countByExample(UserTitleExample example);

    int deleteByExample(UserTitleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTitle record);

    int insertSelective(UserTitle record);

    List<UserTitle> selectByExample(UserTitleExample example);

    UserTitle selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserTitle record, @Param("example") UserTitleExample example);

    int updateByExample(@Param("record") UserTitle record, @Param("example") UserTitleExample example);

    int updateByPrimaryKeySelective(UserTitle record);

    int updateByPrimaryKey(UserTitle record);
}