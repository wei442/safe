package com.ochain.provider.wheel.service;

import java.math.BigDecimal;
import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.Rank;

public interface IBootRankService {

  	/**
  	 * 分页查询
  	 * @param page
  	 * @param rank
  	 * @return List<Rank>
  	 * @throws BootServiceException
  	 */
  	public List<Rank> selectRankListByPage(Page<Rank> page, Rank rank) throws BootServiceException;

  	/**
  	 * 不分页查询
  	 * @param rank
  	 * @return List<Rank>
  	 * @throws BootServiceException
  	 */
  	public List<Rank> selectRankList(Rank rank) throws BootServiceException;

    /**
     * 根据id查询排名
     * @param id
     * @return Rank
     * @throws BootServiceException
     */
	public Rank selectRankById(Integer id) throws BootServiceException;

    /**
     * 根据rankTimeStr查询排名
     * @param userId
     * @return Rank
     * @throws BootServiceException
     */
	public Rank selectRankByRankTime(String rankTimeStr) throws BootServiceException;

    /**
     * 插入排名
     * @param realDiamond
     * @return Rank
     * @throws BootServiceException
     */
	public Rank insertRank(BigDecimal realDiamond) throws BootServiceException;

    /**
     * 修改排名
     * @param rank
     * @return Integer
     * @throws BootServiceException
     */
	public Integer modifyRank(Rank rank) throws BootServiceException;

	/**
	 * 根据排名时间删除排名
	 * @param rankTimeStr
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer deleteRankByRankTime(String rankTimeStr) throws BootServiceException;

}