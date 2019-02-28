package com.ochain.provider.wheel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.param.UserSignParam;
import com.ochain.provider.wheel.po.UserSign;
import com.ochain.provider.wheel.po.UserSignExample;

public interface UserSignMapper {
	long countByExample(UserSignExample example);

    int deleteByExample(UserSignExample example);

    int deleteByPrimaryKey(Long userSignId);

    int insert(UserSign record);

    int insertSelective(UserSign record);

    List<UserSign> selectByExample(UserSignExample example);

    UserSign selectByPrimaryKey(Long userSignId);

    int updateByExampleSelective(@Param("record") UserSign record, @Param("example") UserSignExample example);

    int updateByExample(@Param("record") UserSign record, @Param("example") UserSignExample example);

    int updateByPrimaryKeySelective(UserSign record);

    int updateByPrimaryKey(UserSign record);

    /**
     * 	分页查询
     * @param page
     * @param example
     * @return List<UserSign
     */
    List<UserSign> selectByExample(Page<UserSign> page, UserSignExample example);

    /**
     * 根据userId和signTimeStr(签到时间)查询用户签到列表
     * @param param
     * @return List<UserSign>
     */
    public List<UserSign> selectUserSignListByUserId(UserSignParam param);

}