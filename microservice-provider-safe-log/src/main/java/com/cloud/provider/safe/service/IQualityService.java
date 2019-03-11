package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Quality;
import com.cloud.provider.safe.rest.request.page.QualityPageRequest;
import com.github.pagehelper.Page;

public interface IQualityService {

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Quality>
	 */
	public List<Quality> selectQualityListByPage(Page<?> page, QualityPageRequest param);

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Quality>
	 */
	public List<Quality> selectQualityList(QualityPageRequest param);

    /**
     * 根据id查询资质
     * @param id
     * @return Quality
     */
	public Quality selectQualityById(Integer id);

    /**
     * 插入资质
     * @param quality
     * @return Integer
     */
	public Integer insertQuality(Quality quality);

 	/**
  	 * 根据id删除资质
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteQualityById(Integer id);

    /**
     * 修改资质
     * @param quality
     * @return Integer
     */
	public Integer modifyQuality(Quality quality);

}