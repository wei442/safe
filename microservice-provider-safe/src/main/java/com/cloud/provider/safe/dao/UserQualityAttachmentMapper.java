package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.UserQualityAttachment;
import com.cloud.provider.safe.po.UserQualityAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserQualityAttachmentMapper {
    long countByExample(UserQualityAttachmentExample example);

    int deleteByExample(UserQualityAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserQualityAttachment record);

    int insertSelective(UserQualityAttachment record);

    List<UserQualityAttachment> selectByExample(UserQualityAttachmentExample example);

    UserQualityAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserQualityAttachment record, @Param("example") UserQualityAttachmentExample example);

    int updateByExample(@Param("record") UserQualityAttachment record, @Param("example") UserQualityAttachmentExample example);

    int updateByPrimaryKeySelective(UserQualityAttachment record);

    int updateByPrimaryKey(UserQualityAttachment record);
}