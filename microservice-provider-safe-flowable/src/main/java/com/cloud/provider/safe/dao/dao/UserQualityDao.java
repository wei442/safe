package com.cloud.provider.safe.dao.dao;

import com.cloud.provider.safe.param.UserQualityParam;

public interface UserQualityDao {

    /**
     * 根据userId更新用户名称
     * @param param
     * @return int
     */
    public int updateUserNameByUserId(UserQualityParam param);

}