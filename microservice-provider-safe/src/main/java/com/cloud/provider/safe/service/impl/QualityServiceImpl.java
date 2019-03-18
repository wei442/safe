package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.QualityMapper;
import com.cloud.provider.safe.po.Quality;
import com.cloud.provider.safe.po.QualityExample;
import com.cloud.provider.safe.rest.request.page.QualityPageRequest;
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
	 * @param param
	 * @return List<Quality>
	 */
	@Override
	public List<Quality> selectListByPage(Page<?> page, QualityPageRequest param) {
		logger.info("(QualityService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page);
		QualityExample example = new QualityExample();
		example.setOrderByClause(" id desc ");
		QualityExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_QUALITY_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}

		}
		List<Quality> list = qualityMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Quality>
	 */
	@Override
	public List<Quality> selectList(QualityPageRequest param) {
		logger.info("(QualityService-selectList)-不分页查询-传入参数, param:{}", param);
		QualityExample example = new QualityExample();
		example.setOrderByClause(" id desc ");
		QualityExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_QUALITY_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
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
	public Quality selectById(Integer id) {
    	logger.info("(QualityService-selectById)-根据id查询资质-传入参数, id:{}", id);
		Quality quality = qualityMapper.selectByPrimaryKey(id);
		Assert.thanOrEqualZreo(quality, SafeResultEnum.DATABASE_NOTEXIST);
		return quality;
    }

    /**
     * 插入资质
     * @param quality
     * @return Integer
     */
	@Override
	public Integer insert(Quality quality) {
    	logger.info("(QualityService-insertQuality)-插入资质-传入参数, quality:{}", quality);
    	quality.setIsDelete(SqlSafeConstants.SQL_QUALITY_IS_DELETE_NO);
    	quality.setCreateTime(new Date());
    	quality.setUpdateTime(new Date());
    	int i = qualityMapper.insertSelective(quality);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除资质
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(QualityService-deleteById)-根据id删除资质-传入参数, id:{}", id);
  		int i = qualityMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改资质
     * @param quality
     * @return Integer
     */
	@Override
	public Integer modify(Quality quality) {
    	logger.info("(QualityService-modifyQuality)-修改资质-传入参数, quality:{}", quality);
    	quality.setUpdateTime(new Date());
    	int i = qualityMapper.updateByPrimaryKeySelective(quality);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}