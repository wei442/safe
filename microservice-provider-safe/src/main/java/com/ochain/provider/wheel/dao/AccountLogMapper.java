package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.AccountLog;
import com.ochain.provider.wheel.po.AccountLogExample;

public interface AccountLogMapper {
    long countByExample(AccountLogExample example);

    int deleteByExample(AccountLogExample example);

    int deleteByPrimaryKey(Long accountLogId);

    int insert(AccountLog record);

    int insertSelective(AccountLog record);

    List<AccountLog> selectByExample(AccountLogExample example);

    AccountLog selectByPrimaryKey(Long accountLogId);

    int updateByExampleSelective(@Param("record") AccountLog record, @Param("example") AccountLogExample example);

    int updateByExample(@Param("record") AccountLog record, @Param("example") AccountLogExample example);

    int updateByPrimaryKeySelective(AccountLog record);

    int updateByPrimaryKey(AccountLog record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<AccountLog>
     */
    public List<AccountLog> selectByExample(Page<?> page, AccountLogExample example);

}