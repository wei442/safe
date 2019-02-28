package com.ochain.provider.wheel.service;

import java.util.List;

import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.po.DiamondRecord;
import com.ochain.provider.wheel.vo.diamond.DiamondRecordVo;

public interface IBootDiamondRecordService {

	/**
  	 * 分页查询
  	 * @param page
  	 * @param diamondRecord
  	 * @return List<DiamondRecord>
  	 * @throws BootServiceException
  	 */
  	public List<DiamondRecord> selectDiamondRecordListByPage(Page<DiamondRecord> page, DiamondRecord diamondRecord) throws BootServiceException;

  	/**
  	 * 不分页查询
  	 * @param diamondRecord
  	 * @return List<DiamondRecord>
  	 * @throws BootServiceException
  	 */
  	public List<DiamondRecord> selectDiamondRecordList(DiamondRecord diamondRecord) throws BootServiceException;

  	/**
  	 * 查询3天前未领取的能量方块数据列表
  	 * @param userId
  	 * @return List<DiamondRecord>
  	 * @throws BootServiceException
  	 */
	public List<DiamondRecord> selectDiamondRecordListByThreeDays(Integer userId) throws BootServiceException;

  	/**
  	 * 根据id查询能量记录
  	 * @param id
  	 * @return DiamondRecord
  	 * @throws BootServiceException
  	 */
  	public DiamondRecord selectDiamondRecordById(Long id) throws BootServiceException;

  	/**
  	 * 插入能量记录
  	 * @param diamondRecord
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
	public Integer insertDiamondRecord(DiamondRecord diamondRecord) throws BootServiceException;

  	/**
  	 * 修改能量记录
  	 * @param diamondRecord
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer modifyDiamondRecord(DiamondRecord diamondRecord) throws BootServiceException;

  	/**
  	 * 根据id删除能量记录
  	 * @param id
  	 * @return Integer
  	 * @throws BootServiceException
  	 */
  	public Integer deleteDiamondRecordById(Long id) throws BootServiceException;

  	/**
  	 * 根据领用时间查询已领取的能量数量
  	 * @param useTimeStr
  	 * @return DiamondRecordVo
  	 * @throws BootServiceException
  	 */
	public DiamondRecordVo selectDrawDiamondByUseTime(String useTimeStr) throws BootServiceException;

	/**
	 * 根据创建时间查询未领取的能量数量
	 * @param useTimeStr
	 * @return DiamondRecordVo
	 * @throws BootServiceException
	 */
	public DiamondRecordVo selectNotDrawDiamondByCreateTime(String createTimeStr) throws BootServiceException;

}