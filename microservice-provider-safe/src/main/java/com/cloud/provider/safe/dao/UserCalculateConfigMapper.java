package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.UserCalculateConfigParam;
import com.ochain.provider.wheel.po.UserCalculateConfig;
import com.ochain.provider.wheel.po.UserCalculateConfigExample;
import com.ochain.provider.wheel.vo.user.UserCalculateConfigContentVo;

public interface UserCalculateConfigMapper {
	long countByExample(UserCalculateConfigExample example);

    int deleteByExample(UserCalculateConfigExample example);

    int deleteByPrimaryKey(Long userCalculateConfigId);

    int insert(UserCalculateConfig record);

    int insertSelective(UserCalculateConfig record);

    List<UserCalculateConfig> selectByExample(UserCalculateConfigExample example);

    UserCalculateConfig selectByPrimaryKey(Long userCalculateConfigId);

    int updateByExampleSelective(@Param("record") UserCalculateConfig record, @Param("example") UserCalculateConfigExample example);

    int updateByExample(@Param("record") UserCalculateConfig record, @Param("example") UserCalculateConfigExample example);

    int updateByPrimaryKeySelective(UserCalculateConfig record);

    int updateByPrimaryKey(UserCalculateConfig record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<UserCalculateConfig>
     */
    public List<UserCalculateConfig> selectByExample(Page<?> page, UserCalculateConfigExample example);

    /**
     * 根据userId查询用户配置列表
     * @param param
     * @return List<UserCalculateConfigVo>
     */
    public List<UserCalculateConfigContentVo> selectUserCalculateConfigContentListByUserId(UserCalculateConfigParam param);

}