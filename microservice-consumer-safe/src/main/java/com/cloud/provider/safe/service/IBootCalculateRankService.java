package com.ochain.provider.wheel.service;

import java.util.Date;
import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.CalculateRankParam;
import com.ochain.provider.wheel.po.CalculateRank;
import com.ochain.provider.wheel.vo.calculate.CalculateRankContentListVo;
import com.ochain.provider.wheel.vo.calculate.CalculateRankContentVo;

public interface IBootCalculateRankService {

	/**
     * 根据排名时间查询算力排名
     * @param rankTimeStr
     * @return CalculateRank
     * @throws BootServiceException
     */
	public CalculateRank selectCalculateRankByRankTime(String rankTimeStr) throws BootServiceException;

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return CalculateRankContentListVo
	 * @throws BootServiceException
	 */
	public CalculateRankContentListVo selectCalculateRankContentVoListByPage(Page<CalculateRankContentVo> page, CalculateRankParam param) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param param
	 * @return List<CalculateRankContentVo>
	 * @throws BootServiceException
	 */
	public List<CalculateRankContentVo> selectCalculateRankContentVoList(CalculateRankParam param) throws BootServiceException;

	/**
	 * 根据id查询能量配置表信息
	 * @param id
	 * @return List<CalculateRankContentVo>
	 * @throws BootServiceException
	 */
	public List<CalculateRankContentVo> selectCalculateRankContentVoListById(Integer id) throws BootServiceException;

	/**
	 * 根据日期查询算力排名
	 * @param rankTimeStr
	 * @return List<CalculateRankContentVo>
	 * @throws BootServiceException
	 */
	public List<CalculateRankContentVo> selectCalculateRankContentVoListByRankTime(String rankTimeStr) throws BootServiceException;

	/**
	 * 根据id查询算力排名
	 * @param id
	 * @return CalculateRank
	 * @throws BootServiceException
	 */
	public CalculateRank selectCalculateRankById(Integer id) throws BootServiceException;

//	/**
//	 * 插入算力排名
//	 * @return calculateRankId
//	 * @return calculateRankContentVo
//	 * @throws BootServiceException
//	 */
//	public Integer insertCalculateRank(Integer calculateRankId,CalculateRankContentVo calculateRankContentVo) throws BootServiceException;
//
//	/**
//	 * 插入或更新算力排名
//	 * @param calculateRankId
//	 * @param calculateRankContentVo
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	public Integer insertOrUpdateCalculateRank(Integer calculateRankId,CalculateRankContentVo calculateRankContentVo) throws BootServiceException;
//
//	/**
//	 * 修改算力排名
//	 * @param calculateRank
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	public Integer modifyCalculateRank(CalculateRank calculateRank) throws BootServiceException;

	/**
	 * 插入算力排名空内容数组
	 * @param calculateRank
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertCalculateRankContentNullArray(CalculateRank calculateRank) throws BootServiceException;

	/**
	 * 修改算力排名内容
	 * @param calculateRankId
	 * @param calculateRankContentVo
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyCalculateRankContent(Integer calculateRankId,CalculateRankContentVo calculateRankContentVo) throws BootServiceException;

	/**
	 * 根据userAccount分页查询算力排名
	 * @param page
	 * @param param
	 * @return List<CalculateRankContentVo>
	 * @throws BootServiceException
	 */
	public List<CalculateRankContentVo>selectCalculateRankContentVoListUserAccount(Page<CalculateRankContentVo> page, CalculateRankParam param) throws BootServiceException;

	/**
	 * 根据userAccount查询算力排名列表
	 * @param param
	 * @return List<CalculateRank>
	 * @throws BootServiceException
	 */
	public List<CalculateRank> selectCalculateRankListByUserAccount(CalculateRankParam param) throws BootServiceException;

	/**
	 * 根据userAccount查询算力排名
	 * @param param
	 * @return CalculateRank
	 * @throws BootServiceException
	 */
	public CalculateRank selectCalculateRankByUserAccount(CalculateRankParam param) throws BootServiceException;

	/**
	 * 根据userId查询算力排名
	 * @param param
	 * @return CalculateRank
	 * @throws BootServiceException
	 */
	public CalculateRank selectCalculateRankByUserId(CalculateRankParam param) throws BootServiceException;

	/**
	 * 根据排名时间删除算力排名
	 * @param rankTimeStr
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer deleteCalculateRankByRankTime(String rankTimeStr) throws BootServiceException;

	/**
	 * 根据排名时间删除排名时间之前算力排名
	 * @param rankTime
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer deleteCalculateRankByBeforeRankTime(Date rankTime) throws BootServiceException;

}