package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.provider.wheel.param.CalculateRankParam;
import com.ochain.provider.wheel.po.CalculateRank;
import com.ochain.provider.wheel.po.CalculateRankExample;

public interface CalculateRankMapper {
    int countByExample(CalculateRankExample example);

    int deleteByExample(CalculateRankExample example);

    int deleteByPrimaryKey(Integer calculateRankId);

    int insert(CalculateRank record);

    int insertSelective(CalculateRank record);

    List<CalculateRank> selectByExample(CalculateRankExample example);

    CalculateRank selectByPrimaryKey(Integer calculateRankId);

    int updateByExampleSelective(@Param("record") CalculateRank record, @Param("example") CalculateRankExample example);

    int updateByExample(@Param("record") CalculateRank record, @Param("example") CalculateRankExample example);

    int updateByPrimaryKeySelective(CalculateRank record);

    int updateByPrimaryKey(CalculateRank record);

    /**
     * 分页查询萃取力排名列表
     * @param param
     * @return List<CalculateRank>
     */
    public List<CalculateRank> selectCalculateRankListByPage(CalculateRankParam param);

    /**
     * 不分页查询萃取力排名列表
     * @param param
     * @return List<CalculateRank>
     */
    public List<CalculateRank> selectCalculateRankList(CalculateRankParam param);

    /**
     * 查询萃取力排名条数
     * @param param
     * @return int
     */
    public int selectCalculateRankRows(CalculateRankParam param);

    /**
     * 根据userAccount获取算力排名列表
     * @param param
     * @return List<CalculateRank>
     */
    public List<CalculateRank> selectCalculateRankListByUserAccount(CalculateRankParam param);

    /**
     * 根据userId获取算力排名列表
     * @param param
     * @return List<CalculateRank>
     */
    public List<CalculateRank> selectCalculateRankListByUserId(CalculateRankParam param);

    /**
     * 根据id查询算力排名条数
     * @param param
     * @return int
     */
    public int selectCalculateRankRowsById(CalculateRankParam param);

    /**
     * 修改算力排名
     * @param param
     * @return int
     */
    public int updateCalculateRank(CalculateRankParam param);

    /**
     * 根据排名时间修改算力排名
     * @param param
     * @return int
     */
    public int updateCalculateRankByRankTime(CalculateRankParam param);

    /**
     * 根据排名时间删除算力排名
     * @param param
     * @return int
     */
    public int deleteCalculateRankByRankTime(CalculateRankParam param);

}