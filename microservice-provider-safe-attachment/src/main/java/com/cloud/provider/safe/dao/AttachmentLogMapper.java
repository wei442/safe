package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.AttachmentLog;
import com.cloud.provider.safe.po.AttachmentLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttachmentLogMapper {
    long countByExample(AttachmentLogExample example);

    int deleteByExample(AttachmentLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AttachmentLog record);

    int insertSelective(AttachmentLog record);

    List<AttachmentLog> selectByExample(AttachmentLogExample example);

    AttachmentLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AttachmentLog record, @Param("example") AttachmentLogExample example);

    int updateByExample(@Param("record") AttachmentLog record, @Param("example") AttachmentLogExample example);

    int updateByPrimaryKeySelective(AttachmentLog record);

    int updateByPrimaryKey(AttachmentLog record);
}