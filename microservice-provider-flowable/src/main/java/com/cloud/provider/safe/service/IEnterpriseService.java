package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Enterprise;
import com.cloud.provider.safe.rest.request.page.enterprise.EnterprisePageRequest;
import com.github.pagehelper.Page;

public interface IEnterpriseService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Enterprise>
	 */
	public List<Enterprise> selectListByPage(Page<?> page, EnterprisePageRequest enterprise);

	/**
	 * 不分页查询
	 * @param enterprise
	 * @return List<Enterprise>
	 */
	public List<Enterprise> selectList(EnterprisePageRequest param);

    /**
     * 根据id查询企业
     * @param id
     * @return Enterprise
     */
	public Enterprise selectById(Integer id);

    /**
     * 插入企业
     * @param enterprise
     * @return Integer
     */
	public Integer insert(Enterprise enterprise);

 	/**
  	 * 根据id删除企业
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

    /**
     * 修改企业
     * @param enterprise
     * @return Integer
     */
	public Integer modify(Enterprise enterprise);

}