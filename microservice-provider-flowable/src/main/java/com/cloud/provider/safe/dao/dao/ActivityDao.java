package com.cloud.provider.safe.dao.dao;

import com.cloud.provider.safe.param.ActivityParam;

public interface ActivityDao {

    /**
     * 根据orgId更新安全活动资质名称
     * @param param
     * @return int
     */
    public int updateOrgNameByOrgId(ActivityParam param);

}