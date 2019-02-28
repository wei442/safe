package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.UserLoginLog;
import com.ochain.provider.wheel.po.UserLoginLogExample;

public interface UserLoginLogMapper {
    long countByExample(UserLoginLogExample example);

    int deleteByExample(UserLoginLogExample example);

    int deleteByPrimaryKey(Long userLoginLogId);

    int insert(UserLoginLog record);

    int insertSelective(UserLoginLog record);

    List<UserLoginLog> selectByExample(UserLoginLogExample example);

    UserLoginLog selectByPrimaryKey(Long userLoginLogId);

    int updateByExampleSelective(@Param("record") UserLoginLog record, @Param("example") UserLoginLogExample example);

    int updateByExample(@Param("record") UserLoginLog record, @Param("example") UserLoginLogExample example);

    int updateByPrimaryKeySelective(UserLoginLog record);

    int updateByPrimaryKey(UserLoginLog record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<UserLoginLog>
     */
    public List<UserLoginLog> selectByExample(Page<UserLoginLog> page, UserLoginLogExample example);

}