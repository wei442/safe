package com.cloud.provider.safe.service;

import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.UserInfo;

public interface IUserService {

    /**
     * 插入用户
     * @param enterprise
     * @param userInfo
     * @return Integer
     */
	public Integer insertUser(Enterprise enterprise,UserInfo userInfo);

}