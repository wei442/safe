package com.ochain.provider.wheel.service;

import java.util.Date;
import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.DiamondRankParam;
import com.ochain.provider.wheel.po.DiamondRank;
import com.ochain.provider.wheel.vo.diamond.DiamondRankContentListVo;
import com.ochain.provider.wheel.vo.diamond.DiamondRankContentVo;

public interface IBootDiamondRankService {

	/**
     * 根据排名时间查询能量排名
     * @param rankTimeStr
     * @return DiamondRank
     * @throws BootServiceException
     */
	public DiamondRank selectDiamondRankByRankTime(String rankTimeStr) throws BootServiceException;

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return DiamondRankContentListVo
	 * @throws BootServiceException
	 */
	public DiamondRankContentListVo selectDiamondRankContentVoListByPage(Page<DiamondRankContentVo> page, DiamondRankParam param) throws BootServiceException;

	/**
	 * 不分页查询
	 * @param param
	 * @return List<DiamondRankContentVo>
	 * @throws BootServiceException
	 */
	public List<DiamondRankContentVo> selectDiamondRankContentVoList(DiamondRankParam param) throws BootServiceException;

	/**
	 * 根据id查询能量排名列表
	 * @param id
	 * @return List<DiamondRankContentVo>
	 * @throws BootServiceException
	 */
	public List<DiamondRankContentVo> selectDiamondRankContentVoListById(Integer id) throws BootServiceException;

	/**
	 * 根据rankTimeStr查询能量排名列表
	 * @param rankTimeStr
	 * @return List<DiamondRankContentVo>
	 * @throws BootServiceException
	 */
	public List<DiamondRankContentVo> selectDiamondRankContentVoListByRankTime(String rankTimeStr) throws BootServiceException;

	/**
	 * 根据id查询能量排名
	 * @param id
	 * @return DiamondRank
	 * @throws BootServiceException
	 */
	public DiamondRank selectDiamondRankById(Integer id) throws BootServiceException;

//	/**
//	 * 插入能量排名
//	 * @param diamondRankId
//	 * @param diamondRankContentVo
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	public Integer insertDiamondRank(Integer diamondRankId,DiamondRankContentVo diamondRankContentVo) throws BootServiceException;
//
//	/**
//	 * 插入或更新能量排名
//	 * @param diamondRankId
//	 * @param diamondRankContentVo
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	public Integer insertOrUpdateDiamondRank(Integer diamondRankId,DiamondRankContentVo diamondRankContentVo) throws BootServiceException;
//
//	/**
//	 * 修改能量排名
//	 * @param diamondRank
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	public Integer modifyDiamondRank(DiamondRank diamondRank) throws BootServiceException;

	/**
	 * 插入能量排名空内容数组
	 * @param diamondRank
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer insertDiamondRankContentNullArray(DiamondRank diamondRank) throws BootServiceException;

	/**
	 * 修改能量排名内容
	 * @param diamondRankId
	 * @param diamondRankContentVo
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer modifyDiamondRankContent(Integer diamondRankId,DiamondRankContentVo diamondRankContentVo) throws BootServiceException;

	/**
	 * 根据userAccount分页查询算力排名
	 * @param page
	 * @param param
	 * @return List<DiamondRankContentVo>
	 * @throws BootServiceException
	 */
	public List<DiamondRankContentVo>selectDiamondRankContentVoListUserAccount(Page<DiamondRankContentVo> page, DiamondRankParam param) throws BootServiceException;

	/**
	 * 根据userAccount查询能量排名列表
	 * @param param
	 * @return List<DiamondRank>
	 * @throws BootServiceException
	 */
	public List<DiamondRank> selectDiamondRankListByUserAccount(DiamondRankParam param) throws BootServiceException;

	/**
	 * 根据userAccount查询能量排名
	 * @param param
	 * @return DiamondRank
	 * @throws BootServiceException
	 */
	public DiamondRank selectDiamondRankByUserAccount(DiamondRankParam param) throws BootServiceException;

	/**
	 * 根据userId查询能量排名
	 * @param param
	 * @return DiamondRank
	 * @throws BootServiceException
	 */
	public DiamondRank selectDiamondRankByUserId(DiamondRankParam param) throws BootServiceException;

	/**
	 * 根据排名时间删除能量排名
	 * @param rankTimeStr
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer deleteDiamondRankByRankTime(String rankTimeStr) throws BootServiceException;

	/**
	 * 根据排名时间删除排名时间之前能量排名
	 * @param rankTime
	 * @return Integer
	 * @throws BootServiceException
	 */
	public Integer deleteDiamondRankByBeforeRankTime(Date rankTime) throws BootServiceException;

}