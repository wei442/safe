package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.AccountParam;
import com.ochain.provider.wheel.po.Account;
import com.ochain.provider.wheel.vo.account.AccountUserVo;

public interface IBootAccountService {

    /**
	 * 分页查询
	 * @param page
	 * @param account
	 * @return List<Account>
	 * @throws BootServiceException
	 */
	public List<Account> selectAccountListByPage(Page<Account> page, Account account) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param account
	 * @return List<Account>
	 * @throws BootServiceException
	 */
	public List<Account> selectAccountList(Account account) throws BootServiceException;

	/**
	 * 分页查询倒序账户能量用户列表
	 * @param page
	 * @return List<AccountUserVo>
	 * @throws BootServiceException
	 */
	public List<AccountUserVo> selectAccountVoListSortDiamondByPage(Page<Account> page) throws BootServiceException;

	/**
	 * 分页查询账户能量用户列表
	 * @param param
	 * @return List<AccountUserVo>
	 * @throws BootServiceException
	 */
	public List<AccountUserVo> selectAccountVoListByPage(AccountParam param) throws BootServiceException;

	/**
	 * 查询倒序账户能量用户总条数
	 * @throws BootServiceException
	 */
	public Long selectAccountVoRowsByDiamond() throws BootServiceException;

	/**
     * 根据userId查询账户
     * @param userId
     * @return Account
     * @throws BootServiceException
     */
	public Account selectAccountByUserId(Integer userId) throws BootServiceException;

    /**
     * 根据id查询账户
     * @param id
     * @return Account
     * @throws BootServiceException
     */
	public Account selectAccountById(Integer id) throws BootServiceException;

    /**
     * 插入账户
     * @param account
     * @return Integer
     * @throws BootServiceException
     */
	public Integer insertAccount(Account account) throws BootServiceException;

    /**
     * 修改账户
     * @param account
     * @return Integer
     * @throws BootServiceException
     */
	public Integer modifyAccount(Account account) throws BootServiceException;

}