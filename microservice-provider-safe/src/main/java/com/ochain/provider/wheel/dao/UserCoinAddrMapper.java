package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.UserCoinAddr;
import com.ochain.provider.wheel.po.UserCoinAddrExample;

public interface UserCoinAddrMapper {
    int countByExample(UserCoinAddrExample example);

    int deleteByExample(UserCoinAddrExample example);

    int deleteByPrimaryKey(Integer userCoinAddrId);

    int insert(UserCoinAddr record);

    int insertSelective(UserCoinAddr record);

    List<UserCoinAddr> selectByExample(UserCoinAddrExample example);

    UserCoinAddr selectByPrimaryKey(Integer userCoinAddrId);

    int updateByExampleSelective(@Param("record") UserCoinAddr record, @Param("example") UserCoinAddrExample example);

    int updateByExample(@Param("record") UserCoinAddr record, @Param("example") UserCoinAddrExample example);

    int updateByPrimaryKeySelective(UserCoinAddr record);

    int updateByPrimaryKey(UserCoinAddr record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<userCoinAddr>
     */
    public List<UserCoinAddr> selectByExample(Page<UserCoinAddr> page,UserCoinAddrExample example);

}