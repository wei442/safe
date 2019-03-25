package com.cloud.provider.safe.service;

import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.UserInfo;

public interface IUserService {

    /**
     * 插入用户
     * @param userInfo
     * @param enterprise
     * @return Integer
     */
	public Integer insertUser(UserInfo userInfo,Enterprise enterprise);

}