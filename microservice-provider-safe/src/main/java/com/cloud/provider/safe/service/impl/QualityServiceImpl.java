package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.QualityMapper;
import com.cloud.provider.safe.po.Quality;
import com.cloud.provider.safe.po.QualityExample;
import com.cloud.provider.safe.service.IQualityService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 资质 QualityService
 * @author wei.yong
 */
@Service
public class QualityServiceImpl implements IQualityService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //资质 Mapper
    @Autowired
    private QualityMapper qualityMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param quality
	 * @return List<Quality>
	 */
	@Override
	public List<Quality> selectQualityListByPage(Page<?> page, Quality quality) {
		logger.info("(QualityService-selectQualityListByPage)-分页查询-传入参数, page:{}, quality:{}", page, quality);
		PageHelper.startPage(page);
		QualityExample example = new QualityExample();
		example.setOrderByClause(" id desc ");
		QualityExample.Criteria criteria = example.createCriteria();
		if(quality != null) {
		}
		List<Quality> list = qualityMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param quality
	 * @return List<Quality>
	 */
	@Override
	public List<Quality> selectQualityList(Quality quality) {
		logger.info("(QualityService-selectQualityList)-不分页查询-传入参数, quality:{}", quality);
		QualityExample example = new QualityExample();
		QualityExample.Criteria criteria = example.createCriteria();
		if(quality != null) {
		}
		List<Quality> list = qualityMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询资质
     * @param id
     * @return Quality
     */
	@Override
	public Quality selectQualityById(Integer id) {
    	logger.info("(QualityService-selectQualityById)-根据id查询资质-传入参数, id:{}", id);
		Quality quality = qualityMapper.selectByPrimaryKey(id);
		return quality;
    }

    /**
     * 插入资质
     * @param quality
     * @return Integer
     */
	@Override
	public Integer insertQuality(Quality quality) {
    	logger.info("(QualityService-insertQuality)-插入资质-传入参数, quality:{}", quality);
    	quality.setCreateTime(new Date());
    	quality.setUpdateTime(new Date());
    	int i = qualityMapper.insertSelective(quality);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除资质
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteQualityById(Integer id) {
  		logger.info("(QualityService-deleteQualityById)-根据id删除资质-传入参数, id:{}", id);
  		int i = qualityMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改资质
     * @param quality
     * @return Integer
     */
	@Override
	public Integer modifyQuality(Quality quality) {
    	logger.info("(QualityService-modifyQuality)-修改资质-传入参数, quality:{}", quality);
    	quality.setUpdateTime(new Date());
    	int i = qualityMapper.updateByPrimaryKeySelective(quality);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}