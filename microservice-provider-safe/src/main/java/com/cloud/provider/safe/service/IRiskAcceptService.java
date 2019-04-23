package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.RiskAccept;
import com.cloud.provider.safe.rest.request.page.risk.RiskAcceptPageRequest;
import com.github.pagehelper.Page;

public interface IRiskAcceptService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<RiskAccept>
	 */
	public List<RiskAccept> selectListByPage(Page<?> page, RiskAcceptPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<RiskAccept>
	 */
	public List<RiskAccept> selectList(RiskAcceptPageRequest param);

    /**
     * 根据id查询风险验收
     * @param id
     * @return RiskAccept
     */
	public RiskAccept selectById(Integer id);

    /**
     * 插入风险验收
     * @param riskAccept
     * @return Integer
     */
	public Integer insert(RiskAccept riskAccept);

 	/**
  	 * 根据id删除风险验收
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除风险验收
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改风险验收
     * @param riskAccept
     * @return Integer
     */
	public Integer modify(RiskAccept riskAccept);

}