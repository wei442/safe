package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.RankParam;
import com.ochain.provider.wheel.po.Rank;
import com.ochain.provider.wheel.po.RankExample;

public interface RankMapper {
	long countByExample(RankExample example);

    int deleteByExample(RankExample example);

    int deleteByPrimaryKey(Integer rankId);

    int insert(Rank record);

    int insertSelective(Rank record);

    List<Rank> selectByExample(RankExample example);

    Rank selectByPrimaryKey(Integer rankId);

    int updateByExampleSelective(@Param("record") Rank record, @Param("example") RankExample example);

    int updateByExample(@Param("record") Rank record, @Param("example") RankExample example);

    int updateByPrimaryKeySelective(Rank record);

    int updateByPrimaryKey(Rank record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<Rank>
     */
    public List<Rank> selectByExample(Page<?> page, RankExample example);

    /**
     * 根据排名时间查询排名列表
     * @param param
     * @return List<Rank>
     */
    public List<Rank> selectRankListByRankTime(RankParam param);

    /**
     * 根据排名时间删除排名
     * @param param
     * @return int
     */
    public int deleteRankByRankTime(RankParam param);

}