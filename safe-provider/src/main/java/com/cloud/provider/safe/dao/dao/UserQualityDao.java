package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.UserQualityParam;
import com.cloud.provider.safe.vo.user.UserQualityVo;

public interface UserQualityDao {

    /**
     * 查询用户资质列表
     * @param param
     * @return List<UserQualityVo>
     */
    public List<UserQualityVo> selectList(UserQualityParam param);

}