package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.OrgQuality;
import com.cloud.provider.safe.po.OrgQualityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgQualityMapper {
    long countByExample(OrgQualityExample example);

    int deleteByExample(OrgQualityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrgQuality record);

    int insertSelective(OrgQuality record);

    List<OrgQuality> selectByExample(OrgQualityExample example);

    OrgQuality selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrgQuality record, @Param("example") OrgQualityExample example);

    int updateByExample(@Param("record") OrgQuality record, @Param("example") OrgQualityExample example);

    int updateByPrimaryKeySelective(OrgQuality record);

    int updateByPrimaryKey(OrgQuality record);
}