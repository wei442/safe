package com.cloud.provider.safe.service;

import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.po.UserInfo;

public interface IUserService {

    /**
     * 插入用户企业
     * @param userInfo
     * @param enterprise
     * @return Integer
     */
	public Integer insertUserEnterprise(UserInfo userInfo,Enterprise enterprise);

}