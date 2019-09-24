package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserAppPassword;
import com.cloud.provider.safe.po.UserAppPasswordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserAppPasswordMapper {
    long countByExample(UserAppPasswordExample example);

    int deleteByExample(UserAppPasswordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserAppPassword record);

    int insertSelective(UserAppPassword record);

    List<UserAppPassword> selectByExample(UserAppPasswordExample example);

    UserAppPassword selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserAppPassword record, @Param("example") UserAppPasswordExample example);

    int updateByExample(@Param("record") UserAppPassword record, @Param("example") UserAppPasswordExample example);

    int updateByPrimaryKeySelective(UserAppPassword record);

    int updateByPrimaryKey(UserAppPassword record);
}