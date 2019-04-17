package com.cloud.provider.safe.dao;

import com.cloud.provider.safe.po.RuleAttachment;
import com.cloud.provider.safe.po.RuleAttachmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RuleAttachmentMapper {
    long countByExample(RuleAttachmentExample example);

    int deleteByExample(RuleAttachmentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RuleAttachment record);

    int insertSelective(RuleAttachment record);

    List<RuleAttachment> selectByExample(RuleAttachmentExample example);

    RuleAttachment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RuleAttachment record, @Param("example") RuleAttachmentExample example);

    int updateByExample(@Param("record") RuleAttachment record, @Param("example") RuleAttachmentExample example);

    int updateByPrimaryKeySelective(RuleAttachment record);

    int updateByPrimaryKey(RuleAttachment record);
}