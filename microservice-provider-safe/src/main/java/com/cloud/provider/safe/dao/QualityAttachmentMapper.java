package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.QualityAttachment;
import com.cloud.provider.safe.po.QualityAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QualityAttachmentMapper {
    long countByExample(QualityAttachmentExample example);

    int deleteByExample(QualityAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QualityAttachment record);

    int insertSelective(QualityAttachment record);

    List<QualityAttachment> selectByExample(QualityAttachmentExample example);

    QualityAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QualityAttachment record, @Param("example") QualityAttachmentExample example);

    int updateByExample(@Param("record") QualityAttachment record, @Param("example") QualityAttachmentExample example);

    int updateByPrimaryKeySelective(QualityAttachment record);

    int updateByPrimaryKey(QualityAttachment record);
}