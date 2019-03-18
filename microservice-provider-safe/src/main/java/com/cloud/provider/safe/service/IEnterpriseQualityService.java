package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.EnterpriseQuality;
import com.cloud.provider.safe.rest.request.page.EnterpriseQualityPageRequest;
import com.github.pagehelper.Page;

public interface IEnterpriseQualityService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<EnterpriseQuality>
	 */
	public List<EnterpriseQuality> selectListByPage(Page<?> page, EnterpriseQualityPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<EnterpriseQuality>
	 */
	public List<EnterpriseQuality> selectList(EnterpriseQualityPageRequest param);

    /**
     * 根据id查询企业资质
     * @param id
     * @return EnterpriseQuality
     */
	public EnterpriseQuality selectById(Integer id);

    /**
     * 插入企业资质
     * @param enterpriseQuality
     * @return Integer
     */
	public Integer insert(EnterpriseQuality enterpriseQuality);

	/**
  	 * 根据id删除企业资质
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改企业资质
     * @param enterpriseQuality
     * @return Integer
     */
	public Integer modify(EnterpriseQuality enterpriseQuality);

}