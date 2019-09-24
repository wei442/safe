package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.OrgQualityParam;
import com.cloud.provider.safe.vo.enterprise.OrgQualityVo;

public interface OrgQualityDao {

    /**
     * 查询机构资质列表
     * @param param
     * @return List<UserAdminVo>
     */
    public List<OrgQualityVo> selectList(OrgQualityParam param);

    /**
     * 根据orgId更新机构资质机构名称
     * @param param
     * @return int
     */
    public int updateOrgNameByOrgId(OrgQualityParam param);

}