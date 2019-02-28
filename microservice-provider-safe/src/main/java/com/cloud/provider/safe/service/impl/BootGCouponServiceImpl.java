package com.ochain.provider.wheel.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.constants.wheel.SqlWheelConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.CouponGCouponMapper;
import com.ochain.provider.wheel.dao.CouponMapper;
import com.ochain.provider.wheel.dao.GCouponMapper;
import com.ochain.provider.wheel.po.Coupon;
import com.ochain.provider.wheel.po.CouponGCoupon;
import com.ochain.provider.wheel.po.CouponGCouponExample;
import com.ochain.provider.wheel.po.GCoupon;
import com.ochain.provider.wheel.po.GCouponExample;
import com.ochain.provider.wheel.service.IBootGCouponService;
import com.ochain.provider.wheel.vo.coupon.GCouponRestVo;

@Service
public class BootGCouponServiceImpl implements IBootGCouponService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//gofun优惠券 Mapper
	@Autowired
	private GCouponMapper gCouponMapper;

	//优惠券关联表 Mapper
	@Autowired
	private CouponGCouponMapper couponGGcouponMapper;

	//优惠券 Mapper
	@Autowired
	private CouponMapper couponMapper;

	/**
	 * 分页查询
	 * @param page
	 * @param gCoupon
	 * @return List<GCoupon>
	 * @throws BootServiceException
	 */
	@Override
	public List<GCoupon> selectGCouponListByPage(Page<GCoupon> page, GCoupon gCoupon) throws BootServiceException {
		logger.info("(BootGCouponServiceImpl-selectGCouponListByPage)-分页查询-传入参数, page:{}, gCoupon:{}", page, gCoupon);

		GCouponExample example = new GCouponExample();
		GCouponExample.Criteria criteria = example.createCriteria();
		if(gCoupon != null) {
		}
		List<GCoupon> list = null;
		try {
			list = gCouponMapper.selectByExample(page, example);
		} catch (Exception e) {
			logger.error("(BootGCouponServiceImpl-selectGCouponListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 不分页查询
	 * @param GCouponExample
	 * @return List<GCoupon>
	 * @throws BootServiceException
	 */
	@Override
	public List<GCoupon> selectGCouponList(GCoupon gCoupon) throws BootServiceException {
		logger.info("(BootGCouponServiceImpl-selectGCouponList)-不分页查询-传入参数, gCoupon:{}", gCoupon);
		GCouponExample example = new GCouponExample();
		GCouponExample.Criteria criteria = example.createCriteria();
		if(gCoupon != null) {
		}
		List<GCoupon> list = null;
		try {
			list = gCouponMapper.selectByExample(example);
		} catch (Exception e) {
			logger.error("(BootGCouponServiceImpl-selectGCouponList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据id查询gofun优惠券表信息
	 * @param id
	 * @return GCoupon
	 * @throws BootServiceException
	 */
	@Override
	public GCoupon selectGCouponById(String id) throws BootServiceException {
		logger.info("(BootGCouponServiceImpl-selectGCouponById)-根据id查询gofun优惠券表信息-传入参数, id:{}", id);
		GCoupon gCoupon = null;
		try {
			gCoupon = gCouponMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootGCouponServiceImpl-selectGCouponById)-根据id查询gofun优惠券表信息-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return gCoupon;
	}

	/**
	 * 新增gofun优惠券数据
	 * @param GCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertGCoupon(GCoupon gCoupon) throws BootServiceException {
		logger.info("(BootGCouponServiceImpl-insertGCoupon)-插入gofun优惠券数据-传入参数, gCoupon:{}", gCoupon);
		gCoupon.setCreateTime(new Date());
		gCoupon.setUpdateTime(new Date());
		int i = 0;
		try{
			i = gCouponMapper.insertSelective(gCoupon);
		} catch (Exception e) {
			logger.error("(BootGCouponServiceImpl-insertGCoupon)-插入gofun优惠券数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 修改gofun优惠券数据
	 * @param GCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyGCoupon(GCoupon gCoupon) throws BootServiceException {
		logger.info("(BootGCouponServiceImpl-modifyGCoupon)-修改gofun优惠券数据-传入参数, gCoupon:{}", gCoupon);
		gCoupon.setUpdateTime(new Date());
		int i = 0;
		try{
			i = gCouponMapper.updateByPrimaryKeySelective(gCoupon);
		} catch (Exception e) {
			logger.error("(BootGCouponServiceImpl-modifyGCoupon)-修改gofun优惠券数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 同步gofun优惠券数据
	 * @param GCouponRequest
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Boolean resetGCoupon(String gCouponListStr) throws BootServiceException {
		List<GCouponRestVo> gCouponList  = JSONObject.parseObject(gCouponListStr, new TypeReference<List<GCouponRestVo>>(){});
		logger.info("(BootGCouponServiceImpl-resetGCoupon)-修改gofun优惠券数据-传入参数, gCouponList:{}", gCouponList);
		GCouponExample example = new GCouponExample();
		GCouponExample.Criteria criteria = example.createCriteria();
		List<GCoupon> oldList = null;
		try {
			oldList = gCouponMapper.selectByExample(example);
			logger.info("(BootGCouponServiceImpl-selectGCouponList)-修改gofun优惠券数据不分页查询-返回信息, oldList:{}", oldList);
		} catch (Exception e) {
			logger.error("(BootGCouponServiceImpl-selectGCouponList)-修改gofun优惠券数据不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		//都存在的
		Boolean addNew = false;
		if(oldList !=null && !oldList.isEmpty()) {
			List<GCouponRestVo> bothGCouponList = new ArrayList<>();
			Iterator<GCoupon> iterator = oldList.iterator();
			while (iterator.hasNext()) {
				GCoupon gCoupon = iterator.next();
				//gCouponRestVo g
				for(GCouponRestVo gCouponRestVo : gCouponList) {
					if(StringUtils.equals(gCoupon.getgCouponId(),gCouponRestVo.getCouponId())) {
						bothGCouponList.add(gCouponRestVo);
						iterator.remove();
					}
				}
			}

			logger.info("(BootGCouponServiceImpl-selectGCouponList)-修改gofun优惠券数据-返回信息, gCouponList.size:{},gCouponList:{}", gCouponList.size(), gCouponList);
			logger.info("(BootGCouponServiceImpl-selectGCouponList)-修改gofun优惠券数据-返回信息, bothGCouponList.size:{},bothGCouponList:{}", bothGCouponList.size(), bothGCouponList);
			logger.info("(BootGCouponServiceImpl-selectGCouponList)-修改gofun优惠券数据-返回信息, oldList.size:{},oldList:{}", oldList.size(),oldList);
			//删除过期的
			if(oldList != null && !oldList.isEmpty()) {
				try {
					this.delExpireGCoupon(oldList);
				} catch (Exception e) {
					logger.error("(BootGCouponServiceImpl-delExpireGCoupon)-修改gofun优惠券数据,删除过期数据异常-返回信息, Exception = {}, message = {}", e, e.getMessage());
					throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, "删除原同步数据事务异常");
				}
			}

			//新增的
			if(bothGCouponList != null && !bothGCouponList.isEmpty()) {
				gCouponList.removeAll(bothGCouponList);
			}
		}
		if(gCouponList != null && !gCouponList.isEmpty()) {
			addNew = this.addNewGCoupon(gCouponList);
		}
		return addNew;
	}

	@Transactional
	private void delExpireGCoupon(List<GCoupon> delList) throws Exception {

		Iterator<GCoupon> iterator = delList.iterator();
		int i = 0;
		while(iterator.hasNext()) {
			int j = 0;
			int g = 0;
			int n = 0;
			GCoupon gCoupon = iterator.next();
			//删除g_coupon表
			try {
				j = gCouponMapper.deleteByPrimaryKey(gCoupon.getgCouponId());
				logger.info("(BootGCouponServiceImpl-delExpireGCoupon)-修改gofun优惠券数据,删除g_coupon优惠券数据-返回信息, j:{}", j);
			} catch (Exception e) {
				logger.error("(BootGCouponServiceImpl-delExpireGCoupon)-修改gofun优惠券数据,删除g_coupon优惠券数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				throw new Exception("修改gofun优惠券数据,删除g_coupon优惠券数据异常");
			}

			//查询关系表
			CouponGCouponExample example = new CouponGCouponExample();
			CouponGCouponExample.Criteria criteria = example.createCriteria();
			criteria.andGCouponIdEqualTo(gCoupon.getgCouponId());
			List<CouponGCoupon> oldCGCList = couponGGcouponMapper.selectByExample(example);
			logger.info("(BootGCouponServiceImpl-delExpireGCoupon)-修改gofun优惠券数据,获取coupon_g_coupon优惠券数据-返回信息, oldCGCList:{}", oldCGCList);
			if(oldCGCList.isEmpty()) {
				break;
			}
			//删除coupon表
			Coupon coupon = new Coupon();
			coupon.setCouponId(oldCGCList.get(0).getCouponId());
			coupon.setIsDelete(SqlWheelConstants.SQL_COUPON_IS_DELETE_YES);
			coupon.setUpdateTime(new Date());
			try {
				g = couponMapper.updateByPrimaryKeySelective(coupon);
				logger.info("(BootGCouponServiceImpl-delExpireGCoupon)-修改gofun优惠券数,据修改coupon优惠券数据-返回信息, g:{}", g);
			} catch (Exception e) {
				logger.error("(BootGCouponServiceImpl-delExpireGCoupon)-修改gofun优惠券数据,删除coupon优惠券数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				throw new Exception("修改gofun优惠券数据,删除coupon优惠券数据异常");
			}

			//删除关系表
			try {
				n = couponGGcouponMapper.deleteByPrimaryKey(oldCGCList.get(0).getCouponGCouponId());
				logger.info("(BootGCouponServiceImpl-delExpireGCoupon)-修改gofun优惠券数据,删除coupon_g_coupon优惠券数据-返回信息, n:{}", n);
			} catch (Exception e) {
				logger.error("(BootGCouponServiceImpl-delExpireGCoupon)-修改gofun优惠券数据,删除coupon_g_coupon优惠券数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				throw new Exception("修改gofun优惠券数据,删除coupon_g_coupon优惠券数据异常");
			}
		}
	}

	private Boolean addNewGCoupon(List<GCouponRestVo> newGCouponList) {
		Iterator<GCouponRestVo> iterator = newGCouponList.iterator();
		int i = 0;
		int j = 1;
		while(iterator.hasNext()) {
			GCouponRestVo gCouponRestVo = iterator.next();
			GCoupon gCoupon = new GCoupon();
			gCoupon.setgCouponId(gCouponRestVo.getCouponId());
			gCoupon.setgName(gCouponRestVo.getName());
			gCoupon.setgMoney(gCouponRestVo.getAmount());
			gCoupon.setgCityName(gCouponRestVo.getCityName());
			gCoupon.setgPriceType(Integer.parseInt(gCouponRestVo.getPriceType()));
			gCoupon.setgAreaInfo(gCouponRestVo.getAreaInfo());
			gCoupon.setCreateTime(new Date());
			gCoupon.setUpdateTime(new Date());
			try {
				i = gCouponMapper.insert(gCoupon);
				logger.info("(BootGCouponServiceImpl-addNewGCoupon)-修改gofun优惠券数据,新增gofun优惠券数据-返回信息, i:{}", i);
				j++;
			} catch (Exception e) {
				logger.error("(BootGCouponServiceImpl-addNewGCoupon)-修改gofun优惠券数据,新增gofun优惠券数据-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				return false;
			}
		}
		logger.info("(BootGCouponServiceImpl-addNewGCoupon)-修改gofun优惠券数据,新增gofun优惠券数据-结果信息, 应该新增size:{},实际新增i:{}", newGCouponList.size(), --j);
		return true;
	}
}