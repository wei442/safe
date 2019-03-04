package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.EnterpriseQuality;
import com.cloud.provider.safe.po.EnterpriseQualityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EnterpriseQualityMapper {
    long countByExample(EnterpriseQualityExample example);

    int deleteByExample(EnterpriseQualityExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EnterpriseQuality record);

    int insertSelective(EnterpriseQuality record);

    List<EnterpriseQuality> selectByExample(EnterpriseQualityExample example);

    EnterpriseQuality selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EnterpriseQuality record, @Param("example") EnterpriseQualityExample example);

    int updateByExample(@Param("record") EnterpriseQuality record, @Param("example") EnterpriseQualityExample example);

    int updateByPrimaryKeySelective(EnterpriseQuality record);

    int updateByPrimaryKey(EnterpriseQuality record);
}