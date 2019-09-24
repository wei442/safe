package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.OrgQualityAttachment;
import com.cloud.provider.safe.po.OrgQualityAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgQualityAttachmentMapper {
    long countByExample(OrgQualityAttachmentExample example);

    int deleteByExample(OrgQualityAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrgQualityAttachment record);

    int insertSelective(OrgQualityAttachment record);

    List<OrgQualityAttachment> selectByExample(OrgQualityAttachmentExample example);

    OrgQualityAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrgQualityAttachment record, @Param("example") OrgQualityAttachmentExample example);

    int updateByExample(@Param("record") OrgQualityAttachment record, @Param("example") OrgQualityAttachmentExample example);

    int updateByPrimaryKeySelective(OrgQualityAttachment record);

    int updateByPrimaryKey(OrgQualityAttachment record);
}