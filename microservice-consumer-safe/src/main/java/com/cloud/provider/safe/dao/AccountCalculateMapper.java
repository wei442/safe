package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.AccountCalculateParam;
import com.ochain.provider.wheel.po.AccountCalculate;
import com.ochain.provider.wheel.po.AccountCalculateExample;
import com.ochain.provider.wheel.vo.account.AccountCalculateUserVo;
import com.ochain.provider.wheel.vo.account.AccountCalculateVo;

public interface AccountCalculateMapper {
    long countByExample(AccountCalculateExample example);

    int deleteByExample(AccountCalculateExample example);

    int deleteByPrimaryKey(Integer accountCalculateId);

    int insert(AccountCalculate record);

    int insertSelective(AccountCalculate record);

    List<AccountCalculate> selectByExample(AccountCalculateExample example);

    AccountCalculate selectByPrimaryKey(Integer accountCalculateId);

    int updateByExampleSelective(@Param("record") AccountCalculate record, @Param("example") AccountCalculateExample example);

    int updateByExample(@Param("record") AccountCalculate record, @Param("example") AccountCalculateExample example);

    int updateByPrimaryKeySelective(AccountCalculate record);

    int updateByPrimaryKey(AccountCalculate record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<AccountCalculate>
     */
    public List<AccountCalculate> selectByExample(Page<?> page, AccountCalculateExample example);

    /**
     * 查询账户算力总数
     * @return List<AccountCalculateVo>
     */
    public List<AccountCalculateVo> selectAccountCalculateSumList();

    /**
     * 分页查询倒序账户算力用户列表
     * @param page
     * @return List<AccountCalculateUserVo>
     */
    public List<AccountCalculateUserVo> selectAccountCalculateUserVoListByCalculate(Page<?> page);

    /**
     * 分页查询账户算力用户列表
     * @param param
     * @return List<AccountCalculateUserVo>
     */
    public List<AccountCalculateUserVo> selectAccountCalculateUserVoListByPage(AccountCalculateParam param);

    /**
     * 查询倒序账户算力总条数
     * @return List<AccountCalculateUserVo>
     */
    public long selectAccountCalculateUserVoRowsByCalculate();

}