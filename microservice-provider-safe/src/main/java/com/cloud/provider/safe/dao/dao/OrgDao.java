package com.cloud.provider.safe.dao.dao;

import java.util.List;

import com.cloud.provider.safe.param.OrgParam;
import com.cloud.provider.safe.vo.OrgVo;

public interface OrgDao {

    /**
     * 根据parentOrgId查询当前组织机构列表(正向查询自上到下)
     * @param param
     * @return List<OrgVo>
     */
    public List<OrgVo> selectListByParentOrgId(OrgParam param);

    /**
     * 根据orgId查询当前组织机构列表(反向查询自下到上)
     * @param param
     * @return List<OrgVo>
     */
    public List<OrgVo> selectListByOrgId(OrgParam param);

}