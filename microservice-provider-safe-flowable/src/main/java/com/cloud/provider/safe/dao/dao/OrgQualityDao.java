package com.cloud.provider.safe.dao.dao;

import com.cloud.provider.safe.param.OrgQualityParam;

public interface OrgQualityDao {

    /**
     * 根据orgId更新机构资质机构名称
     * @param param
     * @return int
     */
    public int updateOrgNameByOrgId(OrgQualityParam param);

}