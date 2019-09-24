package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Risk;
import com.cloud.provider.safe.rest.request.page.risk.RiskPageRequest;
import com.github.pagehelper.Page;

public interface IRiskService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Risk>
	 */
	public List<Risk> selectListByPage(Page<?> page, RiskPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Risk>
	 */
	public List<Risk> selectList(RiskPageRequest param);

    /**
     * 根据id查询风险
     * @param id
     * @return Risk
     */
	public Risk selectById(Integer id);

    /**
     * 插入风险
     * @param risk
     * @return Integer
     */
	public Integer insert(Risk risk);

 	/**
  	 * 根据id删除风险
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除风险
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改风险
     * @param risk
     * @return Integer
     */
	public Integer modify(Risk risk);

}