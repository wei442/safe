package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.param.OrgParam;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.vo.OrgUserVo;
import com.cloud.provider.safe.vo.OrgVo;

public interface IOrgService {

    /**
     * 查询组织机构树用户
     * @param param
     * @return List<OrgUserVo>
     */
	public List<OrgUserVo> selectOrgTreeUserList(OrgParam param);

    /**
     * 查询组织机构树
     * @param param
     * @return List<OrgVo>
     */
    public List<OrgVo> selectOrgTreeList(OrgParam param);

    /**
     * 根据id查询组织机构
     * @param id
     * @return Org
     */
	public Org selectOrgById(Integer id);

    /**
     * 插入组织机构
     * @param org
     * @return Integer
     */
	public Integer insertOrg(Org org);

 	/**
  	 * 根据id删除组织机构
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteOrgById(Integer id);

    /**
     * 修改组织机构
     * @param org
     * @return Integer
     */
	public Integer modifyOrg(Org org);

}