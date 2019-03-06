package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.TitleMapper;
import com.cloud.provider.safe.po.Title;
import com.cloud.provider.safe.po.TitleExample;
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
	 * @param title
	 * @return List<Title>
	 */
	@Override
	public List<Title> selectTitleListByPage(Page<?> page, Title title) {
		logger.info("(TitleService-selectTitleListByPage)-分页查询-传入参数, page:{}, title:{}", page, title);
		PageHelper.startPage(page);
		TitleExample example = new TitleExample();
		example.setOrderByClause(" id desc ");
		TitleExample.Criteria criteria = example.createCriteria();
		if(title != null) {
		}
		List<Title> list = titleMapper.selectByExample(example);
		return list;
	}

	/**
	 * 不分页查询
	 * @param title
	 * @return List<Title>
	 */
	@Override
	public List<Title> selectTitleList(Title title) {
		logger.info("(TitleService-selectTitleList)-不分页查询-传入参数, title:{}", title);
		TitleExample example = new TitleExample();
		TitleExample.Criteria criteria = example.createCriteria();
		if(title != null) {
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
	public Title selectTitleById(Integer id) {
    	logger.info("(TitleService-selectTitleById)-根据id查询职务-传入参数, id:{}", id);
		Title title = titleMapper.selectByPrimaryKey(id);
		return title;
    }

    /**
     * 插入职务
     * @param title
     * @return Integer
     */
	@Override
	public Integer insertTitle(Title title) {
    	logger.info("(TitleService-insertTitle)-插入职务-传入参数, title:{}", title);
    	title.setCreateTime(new Date());
    	title.setUpdateTime(new Date());
    	int i = titleMapper.insertSelective(title);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除职务
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteTitleById(Integer id) {
  		logger.info("(TitleService-deleteTitleById)-根据id删除职务-传入参数, id:{}", id);
  		int i = titleMapper.deleteByPrimaryKey(id);
//  		if(i<=0) {
//  			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//  		}
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改职务
     * @param title
     * @return Integer
     */
	@Override
	public Integer modifyTitle(Title title) {
    	logger.info("(TitleService-modifyTitle)-修改职务-传入参数, title:{}", title);
    	title.setUpdateTime(new Date());
    	int i = titleMapper.updateByPrimaryKeySelective(title);
//    	if(i<=0) {
//			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
//		}
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}