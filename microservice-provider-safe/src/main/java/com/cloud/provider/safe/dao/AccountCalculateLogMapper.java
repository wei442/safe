package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.AccountCalculateLog;
import com.ochain.provider.wheel.po.AccountCalculateLogExample;

public interface AccountCalculateLogMapper {
    long countByExample(AccountCalculateLogExample example);

    int deleteByExample(AccountCalculateLogExample example);

    int deleteByPrimaryKey(Long accountCalculateLogId);

    int insert(AccountCalculateLog record);

    int insertSelective(AccountCalculateLog record);

    List<AccountCalculateLog> selectByExample(AccountCalculateLogExample example);

    AccountCalculateLog selectByPrimaryKey(Long accountCalculateLogId);

    int updateByExampleSelective(@Param("record") AccountCalculateLog record, @Param("example") AccountCalculateLogExample example);

    int updateByExample(@Param("record") AccountCalculateLog record, @Param("example") AccountCalculateLogExample example);

    int updateByPrimaryKeySelective(AccountCalculateLog record);

    int updateByPrimaryKey(AccountCalculateLog record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<AccountCalculateLog>
     */
    public List<AccountCalculateLog> selectByExample(Page<?> page, AccountCalculateLogExample example);

}