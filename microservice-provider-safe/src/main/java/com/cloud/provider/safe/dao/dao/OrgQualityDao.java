package com.cloud.provider.safe.dao.dao;

import com.cloud.provider.safe.param.UserOrgParam;

public interface OrgQualityDao {

    /**
     * 根据orgId更新机构机构资质名称
     * @param param
     * @return int
     */
    public int updateOrgNameByOrgId(UserOrgParam param);

}