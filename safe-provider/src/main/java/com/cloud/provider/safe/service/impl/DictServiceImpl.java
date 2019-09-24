package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.DictItemMapper;
import com.cloud.provider.safe.dao.DictMapper;
import com.cloud.provider.safe.dao.dao.DictDao;
import com.cloud.provider.safe.po.Dict;
import com.cloud.provider.safe.po.DictExample;
import com.cloud.provider.safe.po.DictItemExample;
import com.cloud.provider.safe.rest.request.page.dict.DictPageRequest;
import com.cloud.provider.safe.service.IDictService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 字典 DictService
 * @author wei.yong
 */
@Service
public class DictServiceImpl implements IDictService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //字典 Mapper
    @Autowired
    private DictMapper dictMapper;

    //字典 Dao
    @Autowired
    private DictDao dictDao;

    //字典子项 Mapper
    @Autowired
    private DictItemMapper dictItemMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Dict>
	 */
	@Override
	public List<Dict> selectListByPage(Page<?> page, DictPageRequest param) {
		logger.info("(DictService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		DictExample example = new DictExample();
		example.setOrderByClause(" id desc ");
		DictExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_DICT_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null && param.getEnterpriseId() != -2) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
			if(StringUtils.isNotBlank(param.getDictName())) {
				criteria.andDictNameLike(param.getDictName()+"%");
			}
		}
		List<Dict> list = dictMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Dict>
	 */
	@Override
	public List<Dict> selectList(DictPageRequest param) {
		logger.info("(DictService-selectList)-不分页查询-传入参数, param:{}", param);
		DictExample example = new DictExample();
		example.setOrderByClause(" id desc ");
		DictExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_DICT_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null && param.getEnterpriseId() != -2) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
			if(StringUtils.isNotBlank(param.getDictName())) {
				criteria.andDictNameLike(param.getDictName()+"%");
			}
		}
		List<Dict> list = dictMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询字典
     * @param id
     * @return Dict
     */
	@Override
	public Dict selectById(Integer id) {
    	logger.info("(DictService-selectById)-根据id查询字典-传入参数, id:{}", id);
    	Dict dict = dictMapper.selectByPrimaryKey(id);
		return dict;
    }

	/**
	 * 根据enterpriseId和dictCode查询字典
	 * @param enterpriseId
	 * @param dictCode
	 * @return Dict
	 */
	@Override
	public Dict selectByEnterpriseIdDictCode(Integer enterpriseId,String dictCode) {
		logger.info("(DictService-selectByDictCode)-根据enterpriseId和dictCode查询字典-传入参数, enterpriseId:{}, dictCode:{}", enterpriseId, dictCode);
		DictExample example = new DictExample();
		DictExample.Criteria criteria = example.createCriteria();
		criteria.andEnterpriseIdEqualTo(enterpriseId);
		criteria.andDictCodeEqualTo(dictCode);
		List<Dict> list = dictMapper.selectByExample(example);
		Dict dict = null;
		if(list != null && !list.isEmpty()) {
			dict = list.get(0);
		}
		return dict;
	}

    /**
     * 插入字典
     * @param dict
     * @return Integer
     */
	@Override
	public Integer insert(Dict dict) {
    	logger.info("(DictService-insert)-插入字典-传入参数, dict:{}", dict);
    	dict.setIsDelete(SqlSafeConstants.SQL_DICT_IS_DELETE_NO);
    	dict.setCreateTime(new Date());
    	dict.setUpdateTime(new Date());
    	int i = dictMapper.insertSelective(dict);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

	/**
	 * 批量插入
	 * @param list
	 * @return Integer
	 */
	@Override
	public Integer insertList(List<Dict> list) {
    	logger.info("(DictService-insertList)-批量插入字典-传入参数, list:{}", list);
    	int i = dictDao.insertList(list);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除字典
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(DictService-deleteById)-根据id删除字典-传入参数, id:{}", id);
  		int i = dictMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

  		DictItemExample example = new DictItemExample();
		DictItemExample.Criteria criteria = example.createCriteria();
		criteria.andDictIdEqualTo(id);
		i = dictItemMapper.deleteByExample(example);
		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改字典
     * @param dict
     * @return Integer
     */
	@Override
	public Integer modify(Dict dict) {
    	logger.info("(DictService-modify)-修改字典-传入参数, dict:{}", dict);
    	dict.setUpdateTime(new Date());
    	int i = dictMapper.updateByPrimaryKeySelective(dict);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}