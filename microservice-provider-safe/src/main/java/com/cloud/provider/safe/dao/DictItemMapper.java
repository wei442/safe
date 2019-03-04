package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.DictItem;
import com.cloud.provider.safe.po.DictItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DictItemMapper {
    long countByExample(DictItemExample example);

    int deleteByExample(DictItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DictItem record);

    int insertSelective(DictItem record);

    List<DictItem> selectByExample(DictItemExample example);

    DictItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DictItem record, @Param("example") DictItemExample example);

    int updateByExample(@Param("record") DictItem record, @Param("example") DictItemExample example);

    int updateByPrimaryKeySelective(DictItem record);

    int updateByPrimaryKey(DictItem record);
}