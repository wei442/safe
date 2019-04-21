package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.Danger;
import com.cloud.provider.safe.po.DangerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DangerMapper {
    long countByExample(DangerExample example);

    int deleteByExample(DangerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Danger record);

    int insertSelective(Danger record);

    List<Danger> selectByExample(DangerExample example);

    Danger selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Danger record, @Param("example") DangerExample example);

    int updateByExample(@Param("record") Danger record, @Param("example") DangerExample example);

    int updateByPrimaryKeySelective(Danger record);

    int updateByPrimaryKey(Danger record);
}