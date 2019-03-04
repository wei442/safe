package com.cloud.provider.safe.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.common.exception.SafeException;
import com.cloud.provider.safe.dao.TitleMapper;
import com.cloud.provider.safe.po.Title;
import com.cloud.provider.safe.po.TitleExample;
import com.cloud.provider.safe.service.IBootTitleService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * 职务 BootTitleService
 * @author wei.yong
 */
@Service
public class BootTitleServiceImpl implements IBootTitleService {

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
		logger.info("(BootTitleService-selectTitleListByPage)-分页查询-传入参数, page:{}, title:{}", page, title);
		PageHelper.startPage(page);
		TitleExample example = new TitleExample();
		example.setOrderByClause(" id desc ");
		TitleExample.Criteria criteria = example.createCriteria();
		if(title != null) {
		}
		List<Title> list = null;
		try {
			list = titleMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootTitleService-selectTitleListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param title
	 * @return List<Title>
	 */
	@Override
	public List<Title> selectTitleList(Title title) {
		logger.info("(BootTitleService-selectTitleList)-不分页查询-传入参数, title:{}", title);
		TitleExample example = new TitleExample();
		TitleExample.Criteria criteria = example.createCriteria();
		if(title != null) {
		}
		List<Title> list = null;
		try {
			list = titleMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootTitleService-selectTitleList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}
		return list;
	}

    /**
     * 根据id查询职务
     * @param id
     * @return Title
     */
	@Override
	public Title selectTitleById(Integer id) {
    	logger.info("(BootTitleService-selectTitleById)-根据id查询职务-传入参数, id:{}", id);
    	Title title = null;
    	try {
    		title = titleMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootTitleService-selectTitleById)-根据id查询职务-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
		}

		return title;
    }

    /**
     * 插入职务
     * @param title
     * @return Integer
     */
	@Override
	public Integer insertTitle(Title title) {
    	logger.info("(BootTitleService-insertTitle)-插入职务-传入参数, title:{}", title);
    	title.setCreateTime(new Date());
    	title.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = titleMapper.insertSelective(title);
    	} catch (Exception e) {
    		logger.error("(BootTitleService-insertTitle)-插入职务-事务性异常, Exception = {}, message = {}", e, e.getMessage());
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
     * 修改职务
     * @param title
     * @return Integer
     */
	@Override
	public Integer modifyTitle(Title title) {
    	logger.info("(BootTitleService-modifyTitle)-修改职务-传入参数, title:{}", title);
    	title.setUpdateTime(new Date());
    	int i = 0;
    	try {
    		i = titleMapper.updateByPrimaryKeySelective(title);
    	} catch (Exception e) {
    		logger.error("(BootTitleService-modifyTitle)-修改职务-事务性异常, Exception = {}, message = {}", e, e.getMessage());
    		throw new SafeException(SafeResultEnum.SYSTEM_ERROR);
    	}
    	if(i<=0) {
			throw new SafeException(SafeResultEnum.DATABASE_ERROR);
		}
    	return i;
    }

}