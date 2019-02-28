package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.AccountParam;
import com.ochain.provider.wheel.po.Account;
import com.ochain.provider.wheel.po.AccountExample;
import com.ochain.provider.wheel.vo.account.AccountDiamondVo;
import com.ochain.provider.wheel.vo.account.AccountUserVo;

public interface AccountMapper {
    long countByExample(AccountExample example);

    int deleteByExample(AccountExample example);

    int deleteByPrimaryKey(Integer accountId);

    int insert(Account record);

    int insertSelective(Account record);

    List<Account> selectByExample(AccountExample example);

    Account selectByPrimaryKey(Integer accountId);

    int updateByExampleSelective(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByExample(@Param("record") Account record, @Param("example") AccountExample example);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<Account>
     */
    public List<Account> selectByExample(Page<?> page, AccountExample example);

    /**
     * 查询账户能量总数
     * @return List<AccountDiamondVo>
     */
    public List<AccountDiamondVo> selectAccountDiamondSumList();

    /**
     * 分页查询倒序账户能量用户列表
     * @param page
     * @return List<AccountUserVo>
     */
    public List<AccountUserVo> selectAccountVoListByDiamond(Page<?> page);

    /**
     * 分页查询账户能量用户列表
     * @param param
     * @return List<AccountUserVo>
     */
    public List<AccountUserVo> selectAccountVoListByPage(AccountParam param);

    /**
     * 查询倒序账户能量用户总条数
     * @return List<AccountUserVo>
     */
    public long selectAccountVoRowsByDiamond();

}