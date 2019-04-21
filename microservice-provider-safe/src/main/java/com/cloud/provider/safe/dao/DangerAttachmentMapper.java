package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.DangerAttachment;
import com.cloud.provider.safe.po.DangerAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DangerAttachmentMapper {
    long countByExample(DangerAttachmentExample example);

    int deleteByExample(DangerAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DangerAttachment record);

    int insertSelective(DangerAttachment record);

    List<DangerAttachment> selectByExample(DangerAttachmentExample example);

    DangerAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DangerAttachment record, @Param("example") DangerAttachmentExample example);

    int updateByExample(@Param("record") DangerAttachment record, @Param("example") DangerAttachmentExample example);

    int updateByPrimaryKeySelective(DangerAttachment record);

    int updateByPrimaryKey(DangerAttachment record);
}