package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.QualityMapper;
import com.cloud.provider.safe.po.Quality;
import com.cloud.provider.safe.po.QualityExample;
import com.cloud.provider.safe.service.IBootQualityService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 资质 BootQualityService
 * @author wei.yong
 */
@Service
public class BootQualityServiceImpl implements IBootQualityService {

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
		logger.info("(BootQualityService-selectQualityListByPage)-分页查询-传入参数, page:{}, quality:{}", page, quality);
		PageHelper.startPage(page);
		QualityExample example = new QualityExample();
		example.setOrderByClause(" id desc ");
		QualityExample.Criteria criteria = example.createCriteria();
		if(quality != null) {
		}
		List<Quality> list = null;
		try {
			list = qualityMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootQualityService-selectQualityListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param quality
	 * @return List<Quality>
	 */
	@Override
	public List<Quality> selectQualityList(Quality quality) {
		logger.info("(BootQualityService-selectQualityList)-不分页查询-传入参数, quality:{}", quality);
		QualityExample example = new QualityExample();
		QualityExample.Criteria criteria = example.createCriteria();
		if(quality != null) {
		}
		List<Quality> list = null;
		try {
			list = qualityMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootQualityService-selectQualityList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询资质
     * @param id
     * @return Quality
     */
	@Override
	public Quality selectQualityById(Integer id) {
    	logger.info("(BootQualityService-selectQualityById)-根据id查询资质-传入参数, id:{}", id);
    	Quality quality = null;
    	try {
    		quality = qualityMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootQualityService-selectQualityById)-根据id查询资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return quality;
    }

    /**
     * 插入资质
     * @param quality
     * @return Integer
     */
	@Override
	public Integer insertQuality(Quality quality) {
    	logger.info("(BootQualityService-insertQuality)-插入资质-传入参数, quality:{}", quality);
    	quality.setCreateTime(new Date());
    	quality.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = qualityMapper.insertSelective(quality);
    	} catch (Exception e) {
    		logger.error("(BootQualityService-insertQuality)-插入资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

 	/**
  	 * 根据id删除用户职务
  	 * @param id
  	 * @return Integer
  	 */
	public Integer deleteUserTitleById(Integer id) {
  		logger.info("(BootUserTitleService-deleteUserTitleById)-根据id删除用户职务--传入参数, id:{}", id);
  		int i = 0;
  		try {
  			i = userTitleMapper.deleteByPrimaryKey(id);
  		} catch (Exception e) {
  			logger.error("(BootUserTitleService-deleteUserTitleById)-根据id删除用户职务--事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
  		}
  		if(i<=0) {
  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
  		}
  		return i;
  	}

    /**
     * 修改资质
     * @param quality
     * @return Integer
     */
	@Override
	public Integer modifyQuality(Quality quality) {
    	logger.info("(BootQualityService-modifyQuality)-修改资质-传入参数, quality:{}", quality);
    	quality.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = qualityMapper.updateByPrimaryKeySelective(quality);
    	} catch (Exception e) {
    		logger.error("(BootQualityService-modifyQuality)-修改资质-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}