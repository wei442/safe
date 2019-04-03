package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.OrgQuality;
import com.cloud.provider.safe.rest.request.page.OrgQualityPageRequest;
import com.github.pagehelper.Page;

public interface IOrgQualityService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<OrgQuality>
	 */
	public List<OrgQuality> selectListByPage(Page<?> page, OrgQualityPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<OrgQuality>
	 */
	public List<OrgQuality> selectList(OrgQualityPageRequest param);

    /**
     * 根据id查询机构资质
     * @param id
     * @return OrgQuality
     */
	public OrgQuality selectById(Integer id);

    /**
     * 插入机构资质
     * @param orgQuality
     * @return Integer
     */
	public Integer insert(OrgQuality orgQuality);

	/**
  	 * 根据id删除机构资质
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改机构资质
     * @param orgQuality
     * @return Integer
     */
	public Integer modify(OrgQuality orgQuality);

}