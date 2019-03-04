package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Org;
import com.github.pagehelper.Page;

public interface IBootOrgService {

    /**
	 * 分页查询
	 * @param page
	 * @param org
	 * @return List<Org>
	 */
	public List<Org> selectOrgListByPage(Page<?> page, Org org);

	/**
	 * 不分页查询
	 * @param org
	 * @return List<Org>
	 */
	public List<Org> selectOrgList(Org org);

    /**
     * 根据id查询组织机构表
     * @param id
     * @return Org
     */
	public Org selectOrgById(Integer id);

    /**
     * 插入组织机构表
     * @param org
     * @return Integer
     */
	public Integer insertOrg(Org org);

    /**
     * 修改组织机构表
     * @param org
     * @return Integer
     */
	public Integer modifyOrg(Org org);

}