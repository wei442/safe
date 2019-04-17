package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserPost;
import com.cloud.provider.safe.po.UserPostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserPostMapper {
    long countByExample(UserPostExample example);

    int deleteByExample(UserPostExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserPost record);

    int insertSelective(UserPost record);

    List<UserPost> selectByExample(UserPostExample example);

    UserPost selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserPost record, @Param("example") UserPostExample example);

    int updateByExample(@Param("record") UserPost record, @Param("example") UserPostExample example);

    int updateByPrimaryKeySelective(UserPost record);

    int updateByPrimaryKey(UserPost record);
}