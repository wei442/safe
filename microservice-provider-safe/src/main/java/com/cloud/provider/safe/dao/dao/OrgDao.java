package com.cloud.provider.safe.dao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.provider.safe.param.OrgParam;
import com.cloud.provider.safe.vo.OrgVo;

public interface OrgDao {

	/**
	 * 根据parentOrgId查出所有组织机构
	 * @param param
	 * @return List<OrgVo>
	 */
    public List<OrgVo> selectOrgTreeListByParentOrgIdId(OrgParam param);

    /**
     * 根据orgId再递归查询出一级组织机构下的所有子组织机构
     * @param param
     * @return List<OrgVo>
     */
    public List<OrgVo> selectOrgChildrenListByOrgId(@Param("param")OrgParam param);

}