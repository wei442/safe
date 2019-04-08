package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.param.OrgParam;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.vo.enterprise.OrgVo;

public interface IOrgService {

    /**
     * 查询组织机构树(正向查询自上到下)
     * @param param
     * @return List<OrgVo>
     */
    public List<OrgVo> selectTreeList(OrgParam param);

    /**
     * 查询父组织机构树(反向查询自下到上)
     * @param param
     * @return List<OrgVo>
     */
	public List<OrgVo> selectParentTreeList(OrgParam param);

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