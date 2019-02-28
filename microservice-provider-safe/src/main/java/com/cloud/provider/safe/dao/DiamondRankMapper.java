package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.provider.wheel.param.DiamondRankParam;
import com.ochain.provider.wheel.po.DiamondRank;
import com.ochain.provider.wheel.po.DiamondRankExample;

public interface DiamondRankMapper {
    int countByExample(DiamondRankExample example);

    int deleteByExample(DiamondRankExample example);

    int deleteByPrimaryKey(Integer diamondRankId);

    int insert(DiamondRank record);

    int insertSelective(DiamondRank record);

    List<DiamondRank> selectByExample(DiamondRankExample example);

    DiamondRank selectByPrimaryKey(Integer diamondRankId);

    int updateByExampleSelective(@Param("record") DiamondRank record, @Param("example") DiamondRankExample example);

    int updateByExample(@Param("record") DiamondRank record, @Param("example") DiamondRankExample example);

    int updateByPrimaryKeySelective(DiamondRank record);

    int updateByPrimaryKey(DiamondRank record);

    /**
     * 分页查询能量排名列表
     * @param param
     * @return List<DiamondRank>
     */
    public List<DiamondRank> selectDiamondRankListByPage(DiamondRankParam param);

    /**
     * 不分页查询能量排名列表
     * @param param
     * @return List<DiamondRank>
     */
    public List<DiamondRank> selectDiamondRankList(DiamondRankParam param);

    /**
     * 查询能量排名条数
     * @param param
     * @return int
     */
    public int selectDiamondRankRows(DiamondRankParam param);

    /**
     * 根据userAccount获取能量排名列表
     * @param param
     * @return List<DiamondRank>
     */
    public List<DiamondRank> selectDiamondRankListByUserAccount(DiamondRankParam param);

    /**
     * 根据userId获取能量排名列表
     * @param param
     * @return List<DiamondRank>
     */
    public List<DiamondRank> selectDiamondRankListByUserId(DiamondRankParam param);

    /**
     * 根据id查询能量排名条数
     * @param param
     * @return int
     */
    public int selectDiamondRankRowsById(DiamondRankParam param);

    /**
     * 修改能量排名
     * @param param
     * @return int
     */
    public int updateDiamondRank(DiamondRankParam param);

    /**
     * 根据排名修改能量排名
     * @param param
     * @return int
     */
    public int updateDiamondRankByRankTime(DiamondRankParam param);

    /**
     * 根据排名时间删除能量排名
     * @param param
     * @return int
     */
    public int deleteDiamondRankByRankTime(DiamondRankParam param);

}