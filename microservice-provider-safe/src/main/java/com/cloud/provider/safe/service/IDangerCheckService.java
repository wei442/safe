package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.DangerCheck;
import com.cloud.provider.safe.rest.request.page.danger.DangerCheckPageRequest;
import com.github.pagehelper.Page;

public interface IDangerCheckService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<DangerCheck>
	 */
	public List<DangerCheck> selectListByPage(Page<?> page, DangerCheckPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<DangerCheck>
	 */
	public List<DangerCheck> selectList(DangerCheckPageRequest param);

    /**
     * 根据id查询隐患抽查
     * @param id
     * @return DangerCheck
     */
	public DangerCheck selectById(Integer id);

	/**
	 * 根据userId查询隐患抽查
	 * @param userId
	 * @return DangerCheck
	 */
	public DangerCheck selectByUserId(Integer userId);

    /**
     * 插入隐患抽查
     * @param dangerCheck
     * @return Integer
     */
	public Integer insert(DangerCheck dangerCheck);

	/**
  	 * 根据id删除隐患抽查
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteById(Integer id);

 	/**
  	 * 根据ids删除隐患抽查
  	 * @param ids
  	 * @return Integer
  	 */
	public Integer deleteByIds(List<Integer> ids);

    /**
     * 修改隐患抽查
     * @param dangerCheck
     * @return Integer
     */
	public Integer modify(DangerCheck dangerCheck);

}