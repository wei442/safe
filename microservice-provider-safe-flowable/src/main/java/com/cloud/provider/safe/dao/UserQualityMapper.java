package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserQuality;
import com.cloud.provider.safe.po.UserQualityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserQualityMapper {
    long countByExample(UserQualityExample example);

    int deleteByExample(UserQualityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserQuality record);

    int insertSelective(UserQuality record);

    List<UserQuality> selectByExample(UserQualityExample example);

    UserQuality selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserQuality record, @Param("example") UserQualityExample example);

    int updateByExample(@Param("record") UserQuality record, @Param("example") UserQualityExample example);

    int updateByPrimaryKeySelective(UserQuality record);

    int updateByPrimaryKey(UserQuality record);
}