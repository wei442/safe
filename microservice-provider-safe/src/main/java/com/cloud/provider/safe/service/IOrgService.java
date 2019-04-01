package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.param.OrgParam;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.vo.UserInfoOrgVo;
import com.cloud.provider.safe.vo.OrgVo;

public interface IOrgService {

    /**
     * 查询组织机构树用户
     * @param param
     * @return List<OrgUserVo>
     */
	public List<UserInfoOrgVo> selectTreeUserList(OrgParam param);

    /**
     * 查询组织机构树
     * @param param
     * @return List<OrgVo>
     */
    public List<OrgVo> selectTreeList(OrgParam param);

    /**
     * 根据id查询组织机构
     * @param id
     * @return Org
     */
	public Org selectById(Integer id);

    /**
     * 插入组织机构
     * @param org
     * @return Integer
     */
	public Integer insert(Org org);

 	/**
  	 * 根据id删除组织机构
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改组织机构
     * @param org
     * @return Integer
     */
	public Integer modify(Org org);

}