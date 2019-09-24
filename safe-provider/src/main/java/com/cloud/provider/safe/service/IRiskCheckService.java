package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.RiskCheck;
import com.cloud.provider.safe.rest.request.page.risk.RiskCheckPageRequest;
import com.github.pagehelper.Page;

public interface IRiskCheckService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<RiskCheck>
	 */
	public List<RiskCheck> selectListByPage(Page<?> page, RiskCheckPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<RiskCheck>
	 */
	public List<RiskCheck> selectList(RiskCheckPageRequest param);

    /**
     * 根据id查询风险排查
     * @param id
     * @return RiskCheck
     */
	public RiskCheck selectById(Integer id);

    /**
     * 插入风险排查
     * @param riskCheck
     * @return Integer
     */
	public Integer insert(RiskCheck riskCheck);

 	/**
  	 * 根据id删除风险排查
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除风险排查
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改风险排查
     * @param riskCheck
     * @return Integer
     */
	public Integer modify(RiskCheck riskCheck);

}