package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.UserTransactionPasswordParam;
import com.ochain.provider.wheel.po.UserTransactionPassword;
import com.ochain.provider.wheel.po.UserTransactionPasswordExample;

public interface UserTransactionPasswordMapper {
    int countByExample(UserTransactionPasswordExample example);

    int deleteByExample(UserTransactionPasswordExample example);

    int deleteByPrimaryKey(Integer userTransactionPasswordId);

    int insert(UserTransactionPassword record);

    int insertSelective(UserTransactionPassword record);

    List<UserTransactionPassword> selectByExample(UserTransactionPasswordExample example);

    UserTransactionPassword selectByPrimaryKey(Integer userTransactionPasswordId);

    int updateByExampleSelective(@Param("record") UserTransactionPassword record, @Param("example") UserTransactionPasswordExample example);

    int updateByExample(@Param("record") UserTransactionPassword record, @Param("example") UserTransactionPasswordExample example);

    int updateByPrimaryKeySelective(UserTransactionPassword record);

    int updateByPrimaryKey(UserTransactionPassword record);
    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<userCoinAddr>
     */
    public List<UserTransactionPassword> selectByExample(Page<UserTransactionPassword> page,UserTransactionPasswordExample example);

    /**
     * 根据userId更新用户交易密码正常状态为废弃
     * @param param
     * @return int
     */
    public int updateUserTransactionPasswordStatusByUserId(UserTransactionPasswordParam param);

}