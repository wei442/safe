package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.Quality;
import com.cloud.provider.safe.po.QualityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QualityMapper {
    long countByExample(QualityExample example);

    int deleteByExample(QualityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Quality record);

    int insertSelective(Quality record);

    List<Quality> selectByExample(QualityExample example);

    Quality selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Quality record, @Param("example") QualityExample example);

    int updateByExample(@Param("record") Quality record, @Param("example") QualityExample example);

    int updateByPrimaryKeySelective(Quality record);

    int updateByPrimaryKey(Quality record);
}