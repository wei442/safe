package com.ochain.provider.wheel.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.ochain.common.constants.wheel.BootWheelConstants;
import com.ochain.common.dateformat.DateFormatConstants;
import com.ochain.common.exception.BootServiceException;
import com.ochain.pagehepler.mybatis.Page;
import com.ochain.provider.wheel.dao.DiamondRankMapper;
import com.ochain.provider.wheel.param.DiamondRankParam;
import com.ochain.provider.wheel.po.DiamondRank;
import com.ochain.provider.wheel.po.DiamondRankExample;
import com.ochain.provider.wheel.service.IBootDiamondRankService;
import com.ochain.provider.wheel.vo.diamond.DiamondRankContentListVo;
import com.ochain.provider.wheel.vo.diamond.DiamondRankContentVo;


@Service
public class BootDiamondRankServiceImpl implements IBootDiamondRankService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//能量排名 Mapper
	@Autowired
	private DiamondRankMapper diamondRankMapper;

	/**
     * 根据排名时间查询能量排名
     * @param rankTimeStr
     * @return DiamondRank
     * @throws BootServiceException
     */
	@Override
	public DiamondRank selectDiamondRankByRankTime(String rankTimeStr) throws BootServiceException {
		logger.info("(BootDiamondRankService-selectDiamondRankByRankTime)-根据排名时间查询能量排名-传入参数, rankTimeStr:{}", rankTimeStr);
		DiamondRankParam param = new DiamondRankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<DiamondRank> list = null;
		try {
			list = diamondRankMapper.selectDiamondRankList(param);
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-selectDiamondRankByRankTime)-根据排名时间查询能量排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		DiamondRank diamondRank = null;
		if(list != null && !list.isEmpty()) {
			diamondRank = list.get(0);
		}
		return diamondRank;
	}

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return DiamondRankContentListVo
	 * @throws BootServiceException
	 */
	@Override
	public DiamondRankContentListVo selectDiamondRankContentVoListByPage(Page<DiamondRankContentVo> page, DiamondRankParam param) throws BootServiceException {
		logger.info("(BootDiamondRankServiceImpl-selectDiamondRankContentVoListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		List<DiamondRank> list = null;
		try {
			list = diamondRankMapper.selectDiamondRankListByPage(param);
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-selectDiamondRankContentVoListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		int rows = 0;
		DiamondRankContentListVo diamondRankContentListVo = null;
		//列表不为空则查询json长度（json为null时候会返回错误-attempted to return null from a method with a primitive return type (int)）
		if(list != null && !list.isEmpty()) {
			DiamondRank diamondRank = list.get(0);
			try {
				rows = diamondRankMapper.selectDiamondRankRows(param);
				logger.info("(BootDiamondRankService-selectDiamondRankContentVoListByPage)-分页查询条数-返回信息, rows:{}", rows);
			} catch (Exception e) {
				logger.error("(BootDiamondRankService-selectDiamondRankContentVoListByPage)-分页查询条数-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
			}
			Date rankTime = diamondRank.getRankTime();
			String content = Objects.toString(diamondRank.getContent());
			List<DiamondRankContentVo> diamondRankContentVoList = JSONObject.parseObject(content, new TypeReference<List<DiamondRankContentVo>>(){});
			page.setResult(diamondRankContentVoList);
			page.setTotalCount(rows);

			diamondRankContentListVo = new DiamondRankContentListVo();
			diamondRankContentListVo.setDiamondRankContentList(diamondRankContentVoList);
			diamondRankContentListVo.setRankTime(rankTime);
		}
		return diamondRankContentListVo;
	}



	/**
	 * 不分页查询
	 * @param param
	 * @return List<DiamondRankContentVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<DiamondRankContentVo> selectDiamondRankContentVoList(DiamondRankParam param) throws BootServiceException {
		logger.info("(BootDiamondRankService-selectDiamondRankContentVoList)-不分页查询-传入参数, param:{}", param);
		List<DiamondRank> list = null;
		try {
			list = diamondRankMapper.selectDiamondRankList(param);
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-selectDiamondRankContentVoList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		List<DiamondRankContentVo> diamondRankContentVoList = null;
		if(list != null && !list.isEmpty()) {
			DiamondRank diamondRank = list.get(0);
			String content = Objects.toString(diamondRank.getContent());
			diamondRankContentVoList = JSONObject.parseObject(content, new TypeReference<List<DiamondRankContentVo>>(){});
		}
		return diamondRankContentVoList;
	}

	/**
	 * 根据id查询能量排名列表
	 * @param id
	 * @return List<DiamondRankContentVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<DiamondRankContentVo> selectDiamondRankContentVoListById(Integer id) throws BootServiceException {
		logger.info("(BootDiamondRankService-selectDiamondRankContentVoListById)-根据id查询能量排名列表-传入参数, id:{}", id);
		DiamondRank diamondRank = null;
		try {
			diamondRank = diamondRankMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-selectDiamondRankContentVoListById)-根据id查询能量排名列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		List<DiamondRankContentVo> diamondRankContentVoList = null;
		if(diamondRank != null) {
			String content = Objects.toString(diamondRank.getContent());
			diamondRankContentVoList = JSONObject.parseObject(content, new TypeReference<List<DiamondRankContentVo>>(){});
		}
		return diamondRankContentVoList;
	}

	/**
	 * 根据rankTimeStr查询能量排名列表
	 * @param rankTimeStr
	 * @return List<DiamondRankContentVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<DiamondRankContentVo> selectDiamondRankContentVoListByRankTime(String rankTimeStr) throws BootServiceException {
		logger.info("(BootDiamondRankService-selectDiamondRankContentVoListByRankTime)-根据rankTimeStr查询能量排名列表-传入参数, rankTime:{}", rankTimeStr);
		DiamondRankParam param = new DiamondRankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<DiamondRank> list = null;
		try {
			list = diamondRankMapper.selectDiamondRankList(param);
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-selectDiamondRankContentVoListByRankTime)-根据rankTimeStr查询能量排名列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		List<DiamondRankContentVo> diamondRankContentVoList = null;
		if(list != null && !list.isEmpty()) {
			DiamondRank diamondRank = list.get(0);
			String content = Objects.toString(diamondRank.getContent());
			diamondRankContentVoList = JSONObject.parseObject(content, new TypeReference<List<DiamondRankContentVo>>(){});
		}
		return diamondRankContentVoList;
	}

	/**
	 * 根据id查询能量排名
	 * @param id
	 * @return DiamondRank
	 * @throws BootServiceException
	 */
	@Override
	public DiamondRank selectDiamondRankById(Integer id) throws BootServiceException {
		logger.info("(BootDiamondRankServiceImpl-selectDiamondRankById)-根据id查询能量排名-传入参数, id:{}", id);
		DiamondRank diamondRank = null;
		try {
			diamondRank = diamondRankMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootDiamondRankServiceImpl-selectDiamondRankById)-根据id查询能量排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return diamondRank;
	}

//	/**
//	 * 插入能量排名
//	 * @param diamondRankId
//	 * @param diamondRankContentVo
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	@Override
//	public Integer insertDiamondRank(Integer diamondRankId,DiamondRankContentVo diamondRankContentVo) throws BootServiceException {
//		logger.info("(BootDiamondRankService-insertDiamondRank)-传入参数, diamondRankId:{}, diamondRankContentVo:{}", diamondRankId, diamondRankContentVo);
//		//存储信息进行排序，null值转为空，
//		SerializerFeature[] serializerFeature = new SerializerFeature[]{
//			SerializerFeature.MapSortField, SerializerFeature.WriteNullStringAsEmpty
//		};
//		int i = 0;
//		if(diamondRankId == null) {
//			List<DiamondRankContentVo> list = new ArrayList<DiamondRankContentVo>();
//			list.add(diamondRankContentVo);
//			DiamondRank diamondRank = new DiamondRank();
//			diamondRank.setContent(JSONArray.toJSONString(list, serializerFeature));
//			diamondRank.setRankTime(new Date());
//			diamondRank.setCreateTime(new Date());
//			diamondRank.setUpdateTime(new Date());
//			i = diamondRankMapper.insertSelective(diamondRank);
//			logger.info("(BootDiamondRankService-insertDiamondRank)-插入能量排名-返回信息, i:{}", i);
//			diamondRankId = diamondRank.getDiamondRankId();
//		} else {
//			DiamondRankParam param = new DiamondRankParam();
//			param.setDiamondRankId(diamondRankId);
//			StringBuffer sb = new StringBuffer();
//			sb.append("'userId' ,").append(diamondRankContentVo.getUserId()).append(",");
//			sb.append("'userAccount' , '").append(diamondRankContentVo.getUserAccount()).append("',");
//			sb.append("'diamond' ,").append(diamondRankContentVo.getDiamond()).append(",");
//			sb.append("'sort' ,").append(diamondRankContentVo.getSort()).append(",");
//			sb.append("'sortTime' , '").append(diamondRankContentVo.getSortTime()).append("'");
//			param.setRankStr(sb.toString());
////			int rows = diamondRankMapper.selectDiamondRankRowsById(param);
////			logger.info("(BootDiamondRankService-insertDiamondRank)-获取条数, rows:{}", rows);
////			param.setRows(rows);
//			logger.info("(BootDiamondRankService-insertDiamondRank)-修改能量排名, param:{}", param);
//			i = diamondRankMapper.updateDiamondRank(param);
//			logger.info("(BootDiamondRankService-insertDiamondRank)-修改能量排名-返回信息, i:{}", i);
//		}
//		return i;
//	}
//
//
//	/**
//	 * 插入或更新能量排名
//	 * @param diamondRankId
//	 * @param diamondRankContentVo
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	@Override
//	public Integer insertOrUpdateDiamondRank(Integer diamondRankId,DiamondRankContentVo diamondRankContentVo) throws BootServiceException {
//		logger.info("(BootDiamondRankService-insertOrUpdateDiamondRank)-传入参数, diamondRankId:{}, diamondRankContentVo:{}", diamondRankId, diamondRankContentVo);
//		//存储信息进行排序，null值转为空，
//		SerializerFeature[] serializerFeature = new SerializerFeature[]{
//			SerializerFeature.MapSortField, SerializerFeature.WriteNullStringAsEmpty
//		};
//		int i = 0;
//		if(diamondRankId == null) {
//			List<DiamondRankContentVo> list = new ArrayList<DiamondRankContentVo>();
//			list.add(diamondRankContentVo);
//			DiamondRank diamondRank = new DiamondRank();
//			diamondRank.setContent(JSONArray.toJSONString(list, serializerFeature));
//			diamondRank.setRankTime(new Date());
//			diamondRank.setCreateTime(new Date());
//			diamondRank.setUpdateTime(new Date());
//			i = diamondRankMapper.insertSelective(diamondRank);
//			logger.info("(BootDiamondRankService-insertOrUpdateDiamondRank)-插入能量排名-返回信息, i:{}", i);
//			diamondRankId = diamondRank.getDiamondRankId();
//		} else {
//			DiamondRankParam param = new DiamondRankParam();
//			param.setDiamondRankId(diamondRankId);
//			StringBuffer sb = new StringBuffer();
//			sb.append("'userId' ,").append(diamondRankContentVo.getUserId()).append(",");
//			sb.append("'userAccount' , '").append(diamondRankContentVo.getUserAccount()).append("',");
//			sb.append("'diamond' ,").append(diamondRankContentVo.getDiamond()).append(",");
//			sb.append("'sort' ,").append(diamondRankContentVo.getSort()).append(",");
//			sb.append("'sortTime' , '").append(diamondRankContentVo.getSortTime()).append("'");
//			param.setRankStr(sb.toString());
//			logger.info("(BootDiamondRankService-insertOrUpdateDiamondRank)-修改能量排名, param:{}", param);
//			i = diamondRankMapper.updateDiamondRank(param);
//			logger.info("(BootDiamondRankService-insertOrUpdateDiamondRank)-修改能量排名-返回信息, i:{}", i);
//		}
//		return diamondRankId;
//	}
//
//	/**
//	 * 修改能量排名
//	 * @param diamondRank
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	@Override
//	public Integer modifyDiamondRank(DiamondRank diamondRank) throws BootServiceException {
//		logger.info("(BootDiamondRankService-modifyDiamondRank)-修改能量排名-传入参数, diamondRank:{}", diamondRank);
//		diamondRank.setUpdateTime(new Date());
//		int i = 0;
//		try{
//			i = diamondRankMapper.updateByPrimaryKeySelective(diamondRank);
//		} catch (Exception e) {
//			logger.error("(BootDiamondRankService-modifyDiamondRank)-修改能量排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
//			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
//		}
//		if(i<=0) {
//			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
//		}
//		return i;
//	}


	/**
	 * 插入能量排名空内容数组
	 * @param diamondRank
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertDiamondRankContentNullArray(DiamondRank diamondRank) throws BootServiceException {
		logger.info("(BootDiamondRankService-insertDiamondRankContentNullArray)-传入参数, diamondRank:{}", diamondRank);
		diamondRank.setCreateTime(new Date());
		diamondRank.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = diamondRankMapper.insertSelective(diamondRank);
  		} catch (Exception e) {
  			logger.error("(BootCalculateRankService-insertDiamondRankContentNullArray)-插入能量排名空内容数组-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
		return i;
	}


	/**
	 * 修改能量排名内容
	 * @param diamondRankId
	 * @param diamondRankContentVo
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyDiamondRankContent(Integer diamondRankId,DiamondRankContentVo diamondRankContentVo) throws BootServiceException {
		logger.info("(BootDiamondRankService-modifyDiamondRankContent)-传入参数, diamondRankId:{}, diamondRankContentVo:{}", diamondRankId, diamondRankContentVo);
		DiamondRankParam param = new DiamondRankParam();
		param.setDiamondRankId(diamondRankId);
		StringBuffer sb = new StringBuffer();
		sb.append("'userId' ,").append(diamondRankContentVo.getUserId()).append(",");
		sb.append("'userAccount' , '").append(diamondRankContentVo.getUserAccount()).append("',");
		sb.append("'diamond' ,").append(diamondRankContentVo.getDiamond()).append(",");
		sb.append("'sort' ,").append(diamondRankContentVo.getSort()).append(",");
		sb.append("'sortTime' , '").append(diamondRankContentVo.getSortTime()).append("'");
		param.setRankStr(sb.toString());
		int i = 0;
		try {
			i = diamondRankMapper.updateDiamondRank(param);
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-modifyDiamondRankContent)-修改能量排名内容-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return i;
	}



	/**
	 * 根据userAccount分页查询能量排名
	 * @param page
	 * @param param
	 * @return List<DiamondRankContentVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<DiamondRankContentVo> selectDiamondRankContentVoListUserAccount(Page<DiamondRankContentVo> page, DiamondRankParam param) throws BootServiceException {
		logger.info("(BootDiamondRankService-selectDiamondRankListByPage)-根据userAccount分页查询-传入参数, page:{}, param:{}", page, param);
		List<DiamondRank> list = null;
		try {
			list = diamondRankMapper.selectDiamondRankListByUserAccount(param);
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-selectDiamondRankContentVoListByPage)-根据userAccount分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		List<DiamondRankContentVo> diamondRankContentVoList = new ArrayList<DiamondRankContentVo>();
		if(list != null && !list.isEmpty()) {
			DiamondRank diamondRank = list.get(0);
			String content = Objects.toString(diamondRank.getContent());
			diamondRankContentVoList.add(JSONObject.parseObject(content, new TypeReference<DiamondRankContentVo>(){}));
		}
		return diamondRankContentVoList;
	}

	/**
	 * 根据userAccount查询能量排名列表
	 * @param param
	 * @return List<DiamondRank>
	 * @throws BootServiceException
	 */
	@Override
	public List<DiamondRank> selectDiamondRankListByUserAccount(DiamondRankParam param) throws BootServiceException {
		logger.info("(BootDiamondRankService-selectDiamondRankListByUserAccount)-传入参数, param:{}", param);
		List<DiamondRank> list = null;
		try {
			list = diamondRankMapper.selectDiamondRankListByUserAccount(param);
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-selectDiamondRankListByUserAccount)-根据userAccount查询能量排名列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据userAccount查询能量排名
	 * @param param
	 * @return DiamondRank
	 * @throws BootServiceException
	 */
	@Override
	public DiamondRank selectDiamondRankByUserAccount(DiamondRankParam param) throws BootServiceException {
		logger.info("(BootDiamondRankService-selectDiamondRankByUserAccount)-传入参数, param:{}", param);
		List<DiamondRank> list = null;
		try {
			list = diamondRankMapper.selectDiamondRankListByUserAccount(param);
			logger.info("(BootDiamondRankService-selectDiamondRankByUserAccount)-查根据userAccount查询能量排名-返回信息, list.size:{}", list == null ? 0 : list.size());
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-selectDiamondRankByUserAccount)-根据userAccount查询能量排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		DiamondRank diamondRank = null;
		if(list != null && !list.isEmpty()) {
			diamondRank = list.get(0);
		}
		return diamondRank;
	}

	/**
	 * 根据userId查询能量排名
	 * @param param
	 * @return DiamondRank
	 * @throws BootServiceException
	 */
	@Override
	public DiamondRank selectDiamondRankByUserId(DiamondRankParam param) throws BootServiceException {
		logger.info("(BootDiamondRankService-selectDiamondRankByUserId)-传入参数, param:{}", param);
		List<DiamondRank> list = null;
		try {
			list = diamondRankMapper.selectDiamondRankListByUserAccount(param);
		} catch (Exception e) {
			logger.error("(BootDiamondRankService-selectDiamondRankByUserId)-根据userId查询能量排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		DiamondRank diamondRank = null;
		if(list != null && !list.isEmpty()) {
			diamondRank = list.get(0);
		}
		return diamondRank;
	}

	/**
	 * 根据排名时间删除能量排名
	 * @param rankTimeStr
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer deleteDiamondRankByRankTime(String rankTimeStr) throws BootServiceException {
		logger.info("(BootRankService-deleteDiamondRankByRankTime)-根据排名时间删除能量排名-传入参数, rankTimeStr:{}", rankTimeStr);
		DiamondRankParam param = new DiamondRankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		int i = 0;
		try {
			i = diamondRankMapper.deleteDiamondRankByRankTime(param);
		} catch (Exception e) {
			logger.error("(BootRankService-deleteDiamondRankByRankTime)-根据排名时间删除能量排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 根据排名时间删除排名时间之前能量排名
	 * @param rankTime
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer deleteDiamondRankByBeforeRankTime(Date rankTime) throws BootServiceException {
		logger.info("(BootRankService-deleteDiamondRankByBeforeRankTime)-根据排名时间删除排名时间之前能量排名-传入参数, rankTime:{}", rankTime);

		DiamondRankExample example = new DiamondRankExample();
		DiamondRankExample.Criteria criteria = example.createCriteria();
		criteria.andRankTimeLessThanOrEqualTo(rankTime);
		int i = 0;
		try {
			i = diamondRankMapper.deleteByExample(example);
		} catch (Exception e) {
			logger.error("(BootRankService-deleteDiamondRankByBeforeRankTime)-根根据排名时间删除排名时间之前能量排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

}