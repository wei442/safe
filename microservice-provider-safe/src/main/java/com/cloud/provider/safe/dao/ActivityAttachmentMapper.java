package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.ActivityAttachment;
import com.cloud.provider.safe.po.ActivityAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ActivityAttachmentMapper {
    long countByExample(ActivityAttachmentExample example);

    int deleteByExample(ActivityAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ActivityAttachment record);

    int insertSelective(ActivityAttachment record);

    List<ActivityAttachment> selectByExample(ActivityAttachmentExample example);

    ActivityAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ActivityAttachment record, @Param("example") ActivityAttachmentExample example);

    int updateByExample(@Param("record") ActivityAttachment record, @Param("example") ActivityAttachmentExample example);

    int updateByPrimaryKeySelective(ActivityAttachment record);

    int updateByPrimaryKey(ActivityAttachment record);
}