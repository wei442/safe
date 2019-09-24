package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.RiskDuty;
import com.cloud.provider.safe.rest.request.page.risk.RiskDutyPageRequest;
import com.github.pagehelper.Page;

public interface IRiskDutyService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<RiskDuty>
	 */
	public List<RiskDuty> selectListByPage(Page<?> page, RiskDutyPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<RiskDuty>
	 */
	public List<RiskDuty> selectList(RiskDutyPageRequest param);

    /**
     * 根据id查询风险责任
     * @param id
     * @return RiskDuty
     */
	public RiskDuty selectById(Integer id);

    /**
     * 插入风险责任
     * @param riskDuty
     * @return Integer
     */
	public Integer insert(RiskDuty riskDuty);

 	/**
  	 * 根据id删除风险责任
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除风险责任
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改风险责任
     * @param riskDuty
     * @return Integer
     */
	public Integer modify(RiskDuty riskDuty);

}