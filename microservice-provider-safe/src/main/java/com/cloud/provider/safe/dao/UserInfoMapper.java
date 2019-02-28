package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.UserParam;
import com.ochain.provider.wheel.po.UserInfo;
import com.ochain.provider.wheel.po.UserInfoExample;
import com.ochain.provider.wheel.vo.user.UserAccountCalcluateVo;
import com.ochain.provider.wheel.vo.user.UserAccountVo;
import com.ochain.provider.wheel.vo.user.UserCalcluateListVo;

public interface UserInfoMapper {
	long countByExample(UserInfoExample example);

    int deleteByExample(UserInfoExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    List<UserInfo> selectByExample(UserInfoExample example);

    UserInfo selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByExample(@Param("record") UserInfo record, @Param("example") UserInfoExample example);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);

    /**
     * 分页查询
     * @param page
     * @param example
     * @return List<UserInfo>
     */
    public List<UserInfo> selectByExample(Page<?> page, UserInfoExample example);

    /**
     * 分页查询用户信息/账户/账户日志列表
     * @param param
     * @return List<UserAccountVo>
     */
    public List<UserAccountVo> selectUserAccountVoListByParam(Page<?> page, UserParam param);

    /**
     * 分页查询用户信息/账户算力/账户算力日志列表
     * @param param
     * @return List<UserAccountCalcluateVo>
     */
    public List<UserAccountCalcluateVo> selectUserAccountCalcluateVoListByParam(Page<?> page, UserParam param);

    /**
     * 分页查询用户信息/账户算力列表
     * @param param
     * @return List<UserCalcluateListVo>
     */
    public List<UserCalcluateListVo> selectUserCalcluateListByParam(Page<?> page, UserParam param);
}