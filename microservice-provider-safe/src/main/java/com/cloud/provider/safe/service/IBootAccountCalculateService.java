package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.AccountCalculateParam;
import com.ochain.provider.wheel.po.AccountCalculate;
import com.ochain.provider.wheel.vo.account.AccountCalculateUserVo;

public interface IBootAccountCalculateService {

    /**
	 * 分页查询
	 * @param page
	 * @param accountCalculate
	 * @return List<AccountCalculate>
	 * @throws BootServiceException
	 */
	public List<AccountCalculate>selectAccountCalculateListByPage(Page<AccountCalculate> page, AccountCalculate accountCalculate) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param accountCalculate
	 * @return List<AccountCalculate>
	 * @throws BootServiceException
	 */
	public List<AccountCalculate> selectAccountCalculateList(AccountCalculate accountCalculate) throws BootServiceException;

	/**
	 * 分页查询倒序账户算力用户列表
	 * @param page
	 * @return List<AccountCalculateUserVo>
	 * @throws BootServiceException
	 */
	public List<AccountCalculateUserVo> selectAccountCalculateVoListSortCalculateByPage(Page<AccountCalculate> page) throws BootServiceException;

	/**
	 * 分页查询账户算力用户列表
	 * @param param
	 * @return List<AccountCalculateUserVo>
	 * @throws BootServiceException
	 */
	public List<AccountCalculateUserVo> selectAccountCalculateUserVoListByPage(AccountCalculateParam param) throws BootServiceException;

	/**
	 * 查询倒序账户算力用户总条数
	 * @return Long
	 * @throws BootServiceException
	 */
	public Long selectAccountCalculateUserVoRowsByCalculate() throws BootServiceException;

	/**
	 * 查询总条数
	 * @param accountCalculate
	 * @return Long
	 * @throws BootServiceException
	 */
//	public Long selectAccountCalculateRows(AccountCalculate accountCalculate) throws BootServiceException;

	 /**
     * 根据用userId查询账户算力
     * @param userId
     * @return AccountCalculate
     * @throws BootServiceException
     */
	public AccountCalculate selectAccountCalculateByUserId(Integer userId) throws BootServiceException;

    /**
     * 根据id查询账户算力
     * @param id
     * @return AccountCalculate
     * @throws BootServiceException
     */
	public AccountCalculate selectAccountCalculateById(Integer id) throws BootServiceException;

    /**
     * 插入账户算力
     * @param accountCalculate
     * @return Integer
     * @throws BootServiceException
     */
	public Integer insertAccountCalculate(AccountCalculate accountCalculate) throws BootServiceException;

    /**
     * 修改账户算力
     * @param accountCalculate
     * @return Integer
     * @throws BootServiceException
     */
	public Integer modifyAccountCalculate(AccountCalculate accountCalculate) throws BootServiceException;

}