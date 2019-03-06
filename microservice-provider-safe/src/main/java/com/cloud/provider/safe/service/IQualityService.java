package com.cloud.provider.safe.service;

import java.util.List;

import com.cloud.provider.safe.po.Quality;
import com.github.pagehelper.Page;

public interface IQualityService {

    /**
	 * 分页查询
	 * @param page
	 * @param quality
	 * @return List<Quality>
	 */
	public List<Quality> selectQualityListByPage(Page<?> page, Quality quality);

	/**
	 * 不分页查询
	 * @param quality
	 * @return List<Quality>
	 */
	public List<Quality> selectQualityList(Quality quality);

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