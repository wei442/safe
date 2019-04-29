package com.cloud.provider.safe.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.dao.OrgMapper;
import com.cloud.provider.safe.dao.dao.ActivityDao;
import com.cloud.provider.safe.dao.dao.OrgDao;
import com.cloud.provider.safe.dao.dao.OrgQualityDao;
import com.cloud.provider.safe.dao.dao.UserOrgDao;
import com.cloud.provider.safe.param.ActivityParam;
import com.cloud.provider.safe.param.OrgParam;
import com.cloud.provider.safe.param.OrgQualityParam;
import com.cloud.provider.safe.po.Org;
import com.cloud.provider.safe.service.IOrgService;
import com.cloud.provider.safe.util.Assert;
import com.cloud.provider.safe.vo.enterprise.OrgVo;

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

    //机构资质 Dao
    @Autowired
    private OrgQualityDao orgQualityDao;

    //用户机构 Dao
    @Autowired
    private UserOrgDao userOrgDao;

    //安全活动 Dao
    @Autowired
    private ActivityDao activityDao;

    /**
     * 查询组织机构树(正向查询自上到下)
     * @param param
     * @return List<OrgVo>
     */
	@Override
	public List<OrgVo> selectTreeList(OrgParam param) {
    	logger.info("(OrgService-selectTreeList)-查询组织机构树-传入参数, param:{}", param);
        List<OrgVo> orgList = new ArrayList<OrgVo>();
    	List<OrgVo> list = orgDao.selectListByParentOrgId(param);
    	if(list != null && !list.isEmpty()) {
    		List<OrgVo> orgChildList = this.selectChildTreeList(list);
    		orgList.addAll(orgChildList);
    	}
    	return orgList;
    }

	/**
	 * 查询子组织机构(正向查询自上到下)
	 * @param list
	 * @return List<OrgVo>
	 */
    public List<OrgVo> selectChildTreeList(List<OrgVo> list) {
    	List<OrgVo> orgList = new ArrayList<OrgVo>();
    	if(list != null && !list.isEmpty()) {
    		for (OrgVo orgVo : list) {
    			OrgParam param = new OrgParam();
    			param.setEnterpriseId(orgVo.getEnterpriseId());
    			param.setParentOrgId(orgVo.getOrgId());
    			List<OrgVo> childOrgList = orgDao.selectListByParentOrgId(param);
    			if(childOrgList != null && !childOrgList.isEmpty()) {
    				List<OrgVo> newChildOrgList = this.selectChildTreeList(childOrgList);
    				if(newChildOrgList != null && !newChildOrgList.isEmpty()) {
	    				orgVo.setOrgList(newChildOrgList);
    				}
    			}
    			orgList.add(orgVo);
			}
    	}
    	return orgList;
    }

    /**
     * 查询父组织机构树(反向查询自下到上)
     * @param param
     * @return List<OrgVo>
     */
	@Override
	public List<OrgVo> selectParentTreeList(OrgParam param) {
    	logger.info("(OrgService-selectParentTreeList)-查询父组织机构树-传入参数, param:{}", param);
        List<OrgVo> orgList = new ArrayList<OrgVo>();
    	List<OrgVo> list = orgDao.selectListByOrgId(param);
    	if(list != null && !list.isEmpty()) {
    		List<OrgVo> orgParentList = this.selectParentTreeList(list);
    		orgList.addAll(orgParentList);
    	}
    	return orgList;
    }

	/**
	 * 查询父组织机构(反向查询自下到上)
	 * @param list
	 * @return List<OrgVo>
	 */
    public List<OrgVo> selectParentTreeList(List<OrgVo> list) {
    	List<OrgVo> orgList = new ArrayList<OrgVo>();
    	if(list != null && !list.isEmpty()) {
    		for (OrgVo orgVo : list) {
    			OrgParam param = new OrgParam();
    			param.setEnterpriseId(orgVo.getEnterpriseId());
    			param.setOrgId(orgVo.getParentOrgId());
    			List<OrgVo> parentOrgList = orgDao.selectListByOrgId(param);
    			if(parentOrgList != null && !parentOrgList.isEmpty()) {
    				List<OrgVo> newParentOrgList = this.selectParentTreeList(parentOrgList);
    				if(newParentOrgList != null && !newParentOrgList.isEmpty()) {
	    				orgVo.setOrgList(newParentOrgList);
    				}
    			}
    			orgList.add(orgVo);
			}
    	}
    	return orgList;
    }



//    /**
//     * 查询组织机构树用户
//     * @param param
//     * @return List<OrgUserVo>
//     */
//	@Override
//	public List<UserInfoOrgVo> selectTreeUserList(OrgParam param) {
//		logger.info("(OrgService-selectTreeUserList)-查询组织机构树用户-传入参数, param:{}", param);
//		Integer enterpriseId = null;
//
//		List<UserInfoOrgVo> orgUserVoList = null;
//		UserInfoOrgVo orgUserVo = null;
//		List<OrgVo> list = orgDao.selectListByParentOrgId(param);
//		if(list != null && !list.isEmpty()) {
//			ListIterator<OrgVo> it = list.listIterator();
//			orgUserVoList = new ArrayList<UserInfoOrgVo>();
//			while(it.hasNext()) {
//				OrgVo orgVo = it.next();
//				orgUserVo = new UserInfoOrgVo();
//
//				Integer orgId = orgVo.getOrgId();
//				UserParam userParam = new UserParam();
//				userParam.setOrgId(orgId);
//				userParam.setEnterpriseId(enterpriseId);
//				List<UserInfoOrgVo> userList = userInfoDao.selectListByOrgId(userParam);
//				Integer size = userList == null ? 0 : userList.size();
//
//				BeanUtils.copyProperties(orgVo, orgUserVo);
//				orgUserVoList.add(orgUserVo);
//			}
//		}
//
//		return orgUserVoList;
//	}

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
    	logger.info("(OrgService-insert)-插入组织机构-传入参数, org:{}", org);
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
    	logger.info("(OrgService-modify)-修改组织机构-传入参数, org:{}", org);
    	org.setUpdateTime(new Date());
    	int i = orgMapper.updateByPrimaryKeySelective(org);
    	Assert.thanOrEqualZreo(i, SafeResultEnum.DATABASE_ERROR);

    	Integer orgId = org.getId();
    	String orgName = org.getOrgName();

//        UserOrgParam userOrgParam = new UserOrgParam();
//        userOrgParam.setOrgId(orgId);
//        userOrgParam.setOrgName(orgName);
//        i =userOrgDao.updateOrgNameByOrgId(userOrgParam);

        OrgQualityParam orgQualityParam = new OrgQualityParam();
        orgQualityParam.setOrgId(orgId);
        orgQualityParam.setOrgName(orgName);
        i =orgQualityDao.updateOrgNameByOrgId(orgQualityParam);

        ActivityParam activityParam = new ActivityParam();
        activityParam.setOrgId(orgId);
        activityParam.setOrgName(orgName);
        i =activityDao.updateOrgNameByOrgId(activityParam);

    	return i;
    }

}