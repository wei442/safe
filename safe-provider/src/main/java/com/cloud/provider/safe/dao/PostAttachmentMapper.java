package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.PostAttachment;
import com.cloud.provider.safe.po.PostAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PostAttachmentMapper {
    long countByExample(PostAttachmentExample example);

    int deleteByExample(PostAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PostAttachment record);

    int insertSelective(PostAttachment record);

    List<PostAttachment> selectByExample(PostAttachmentExample example);

    PostAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PostAttachment record, @Param("example") PostAttachmentExample example);

    int updateByExample(@Param("record") PostAttachment record, @Param("example") PostAttachmentExample example);

    int updateByPrimaryKeySelective(PostAttachment record);

    int updateByPrimaryKey(PostAttachment record);
}