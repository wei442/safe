package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.TitleMapper;
import com.cloud.provider.safe.po.Title;
import com.cloud.provider.safe.po.TitleExample;
import com.cloud.provider.safe.rest.request.page.post.TitlePageRequest;
import com.cloud.provider.safe.service.ITitleService;
import com.cloud.provider.safe.util.Assert;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 职务 TitleService
 * @author wei.yong
 */
@Service
public class TitleServiceImpl implements ITitleService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //职务 Mapper
    @Autowired
    private TitleMapper titleMapper;

    /**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return List<Title>
	 */
	@Override
	public List<Title> selectListByPage(Page<?> page, TitlePageRequest param) {
		logger.info("(TitleService-selectListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		TitleExample example = new TitleExample();
		example.setOrderByClause(" id desc ");
		TitleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_TITLE_IS_DELETE_NO);
		if(param != null) {
			if(param.getEnterpriseId() != null) {
				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
			}
		}
		List<Title> list = titleMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param param
	 * @return List<Title>
	 */
	@Override
	public List<Title> selectList(TitlePageRequest param) {
		logger.info("(TitleService-selectList)-不分页查询-传入参数, param:{}", param);
		TitleExample example = new TitleExample();
		example.setOrderByClause(" id desc ");
		TitleExample.Criteria criteria = example.createCriteria();
		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_TITLE_IS_DELETE_NO);
		if(param != null) {
		}
		List<Title> list = titleMapper.selectByExample(example);
		return list;
	}

    /**
     * 根据id查询职务
     * @param id
     * @return Title
     */
	@Override
	public Title selectById(Integer id) {
    	logger.info("(TitleService-selectById)-根据id查询职务-传入参数, id:{}", id);
		Title title = titleMapper.selectByPrimaryKey(id);
		return title;
    }

    /**
     * 插入职务
     * @param title
     * @return Integer
     */
	@Override
	public Integer insert(Title title) {
    	logger.info("(TitleService-insert)-插入职务-传入参数, title:{}", title);
    	title.setIsDelete(SqlSafeConstants.SQL_TITLE_IS_DELETE_NO);
    	title.setCreateTime(new Date());
    	title.setUpdateTime(new Date());
    	int i = titleMapper.insertSelective(title);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除职务
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(TitleService-deleteById)-根据id删除职务-传入参数, id:{}", id);
  		int i = titleMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改职务
     * @param title
     * @return Integer
     */
	@Override
	public Integer modify(Title title) {
    	logger.info("(TitleService-modify)-修改职务-传入参数, title:{}", title);
    	title.setUpdateTime(new Date());
    	int i = titleMapper.updateByPrimaryKeySelective(title);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}