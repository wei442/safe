package com.cloud.provider.safe.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.OrgMapper;
import com.cloud.provider.safe.dao.dao.OrgDao;
import com.cloud.provider.safe.dao.dao.UserInfoDao;
import com.cloud.provider.safe.param.OrgParam;
import com.cloud.provider.safe.param.UserParam;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.service.IOrgService;
import com.cloud.provider.safe.util.Assert;
import com.cloud.provider.safe.vo.OrgUserVo;
import com.cloud.provider.safe.vo.OrgVo;
import com.cloud.provider.safe.vo.UserInfoVo;

/**
 * 组织机构 OrgService
 * @author wei.yong
 */
@Service
public class OrgServiceImpl implements IOrgService {

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    //组织机构 Mapper
    @Autowired
    private OrgMapper orgMapper;

    //组织机构 Dao
    @Autowired
    private OrgDao orgDao;

    //用户信息 Dao
    @Autowired
    private UserInfoDao userInfoDao;

    /**
     * 查询组织机构树用户
     * @param param
     * @return List<OrgUserVo>
     */
	@Override
	public List<OrgUserVo> selectTreeUserList(OrgParam param) {
		logger.info("(OrgService-selectTreeUserList)-查询组织机构树用户-传入参数, param:{}", param);
		Integer enterpriseId = param.getEnterpriseId();

		List<OrgUserVo> orgUserVoList = null;
		OrgUserVo orgUserVo = null;
		List<OrgVo> list = orgDao.selectOrgTreeListByParentOrgIdId(param);
		if(list != null && !list.isEmpty()) {
			ListIterator<OrgVo> it = list.listIterator();
			orgUserVoList = new ArrayList<OrgUserVo>();
			while(it.hasNext()) {
				OrgVo orgVo = it.next();
				orgUserVo = new OrgUserVo();

				Integer orgId = orgVo.getOrgId();
				UserParam userParam = new UserParam();
				userParam.setOrgId(orgId);
				userParam.setEnterpriseId(enterpriseId);
				List<UserInfoVo> userList = userInfoDao.selectUserInfoListByOrgId(userParam);
				Integer size = userList == null ? 0 : userList.size();

				BeanUtils.copyProperties(orgVo, orgUserVo);
				orgUserVo.setCount(size);
				orgUserVo.setUserList(userList);
				orgUserVoList.add(orgUserVo);
			}
		}

		return orgUserVoList;
	}

    /**
     * 查询组织机构树
     * @param param
     * @return List<OrgVo>
     */
    @Override
	public List<OrgVo> selectTreeList(OrgParam param) {
    	logger.info("(OrgService-selectOrgTreeList)-查询组织机构树-传入参数, param:{}", param);
    	List<OrgVo> list = orgDao.selectOrgTreeListByParentOrgIdId(param);
    	return list;
    }

//    /**
//	 * 分页查询
//	 * @param page
//	 * @param param
//	 * @return List<Org>
//	 */
//	@Override
//	public List<Org> selectOrgListByPage(Page<?> page, OrgPageRequest param) {
//		logger.info("(OrgService-selectOrgListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
//		PageHelper.startPage(page.getPageNum(), page.getPageSize());
//		OrgExample example = new OrgExample();
//		example.setOrderByClause(" id desc ");
//		OrgExample.Criteria criteria = example.createCriteria();
//		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_ORG_IS_DELETE_NO);
//		if(param != null) {
//			if(param.getEnterpriseId() != null) {
//				criteria.andEnterpriseIdEqualTo(param.getEnterpriseId());
//			}
//		}
//		List<Org> list = orgMapper.selectByExample(example);
//		return list;
//	}
//
//	/**
//	 * 不分页查询
//	 * @param param
//	 * @return List<Org>
//	 */
//	@Override
//	public List<Org> selectOrgList(OrgPageRequest param) {
//		logger.info("(OrgService-selectOrgList)-不分页查询-传入参数, param:{}", param);
//		OrgExample example = new OrgExample();
//		example.setOrderByClause(" id desc ");
//		OrgExample.Criteria criteria = example.createCriteria();
//		criteria.andIsDeleteEqualTo(SqlSafeConstants.SQL_ORG_IS_DELETE_NO);
//		if(param != null) {
//		}
//		List<Org> list = orgMapper.selectByExample(example);
//		return list;
//	}

    /**
     * 根据id查询组织机构
     * @param id
     * @return Org
     */
	@Override
	public Org selectById(Integer id) {
    	logger.info("(OrgService-selectById)-根据id查询组织机构-传入参数, id:{}", id);
		Org org = orgMapper.selectByPrimaryKey(id);
		return org;
    }

    /**
     * 插入组织机构
     * @param org
     * @return Integer
     */
	@Override
	public Integer insert(Org org) {
    	logger.info("(OrgService-insertOrg)-插入组织机构-传入参数, org:{}", org);
    	org.setIsDelete(SqlSafeConstants.SQL_ORG_IS_DELETE_NO);
    	org.setCreateTime(new Date());
    	org.setUpdateTime(new Date());
    	int i = orgMapper.insertSelective(org);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

 	/**
  	 * 根据id删除组织机构
  	 * @param id
  	 * @return Integer
  	 */
	@Override
	public Integer deleteById(Integer id) {
  		logger.info("(OrgService-deleteById)-根据id删除组织机构-传入参数, id:{}", id);
  		int i = orgMapper.deleteByPrimaryKey(id);
  		Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
  		return i;
  	}

    /**
     * 修改组织机构
     * @param org
     * @return Integer
     */
	@Override
	public Integer modify(Org org) {
    	logger.info("(OrgService-modifyOrg)-修改组织机构-传入参数, org:{}", org);
    	org.setUpdateTime(new Date());
    	int i = orgMapper.updateByPrimaryKeySelective(org);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);
    	return i;
    }

}