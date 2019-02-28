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
import com.ochain.provider.wheel.dao.CalculateRankMapper;
import com.ochain.provider.wheel.param.CalculateRankParam;
import com.ochain.provider.wheel.po.CalculateRank;
import com.ochain.provider.wheel.po.CalculateRankExample;
import com.ochain.provider.wheel.service.IBootCalculateRankService;
import com.ochain.provider.wheel.vo.calculate.CalculateRankContentListVo;
import com.ochain.provider.wheel.vo.calculate.CalculateRankContentVo;

@Service
public class BootCalculateRankServiceImpl implements IBootCalculateRankService {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//算力配置 Mapper
	@Autowired
	private CalculateRankMapper calculateRankMapper;

    /**
     * 根据排名时间查询算力排名
     * @param rankTimeStr
     * @return CalculateRank
     * @throws BootServiceException
     */
	@Override
	public CalculateRank selectCalculateRankByRankTime(String rankTimeStr) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankByRankTime)-根据排名时间查询算力排名-传入参数, rankTimeStr:{}", rankTimeStr);
		CalculateRankParam param = new CalculateRankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<CalculateRank> list = null;
		try {
			list = calculateRankMapper.selectCalculateRankList(param);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankByRankTime)-根据排名时间查询算力排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		CalculateRank calculateRank = null;
		if(list != null && !list.isEmpty()) {
			calculateRank = list.get(0);
		}
		return calculateRank;
	}

	/**
	 * 分页查询
	 * @param page
	 * @param param
	 * @return CalculateRankContentListVo
	 * @throws BootServiceException
	 */
	@Override
	public CalculateRankContentListVo selectCalculateRankContentVoListByPage(Page<CalculateRankContentVo> page, CalculateRankParam param) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankListByPage)-分页查询-传入参数, page:{}, param:{}", page, param);
		List<CalculateRank> list = null;
		try {
			list = calculateRankMapper.selectCalculateRankListByPage(param);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankContentVoListByPage)-分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		long rows = 0;
		CalculateRankContentListVo calculateRankContentListVo = null;
		//列表不为空则查询json长度（json为null时候会返回错误-attempted to return null from a method with a primitive return type (int)）
		if(list != null && !list.isEmpty()) {
			CalculateRank calculateRank = list.get(0);
			try {
				rows = calculateRankMapper.selectCalculateRankRows(param);
				logger.info("(BootCalculateRankService-selectCalculateRankContentVoListByPage)-分页查询条数-返回信息, rows:{}", rows);
			} catch (Exception e) {
				logger.error("(BootCalculateRankService-selectCalculateRankContentVoListByPage)-分页查询条数-事务性异常, Exception = {}, message = {}", e, e.getMessage());
				throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
			}

			Date rankTime = calculateRank.getRankTime();
			String content = Objects.toString(calculateRank.getContent());
			List<CalculateRankContentVo> calculateRankContentVoList = JSONObject.parseArray(content, CalculateRankContentVo.class);
			page.setResult(calculateRankContentVoList);
			page.setTotalCount(rows);

			calculateRankContentListVo = new CalculateRankContentListVo();
			calculateRankContentListVo.setCalculateRankContentList(calculateRankContentVoList);
			calculateRankContentListVo.setRankTime(rankTime);
		}
		return calculateRankContentListVo;
	}


	/**
	 * 不分页查询
	 * @param param
	 * @return List<CalculateRankContentVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<CalculateRankContentVo> selectCalculateRankContentVoList(CalculateRankParam param) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankContentVoList)-不分页查询-传入参数, param:{}", param);
		List<CalculateRank> list = null;
		try {
			list = calculateRankMapper.selectCalculateRankList(param);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankContentVoList)-不分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		List<CalculateRankContentVo> calculateRankContentVoList = null;
		if(list != null && !list.isEmpty()) {
			CalculateRank calculateRank = list.get(0);
			String content = Objects.toString(calculateRank.getContent());
			calculateRankContentVoList = JSONObject.parseObject(content, new TypeReference<List<CalculateRankContentVo>>(){});

		}
		return calculateRankContentVoList;
	}

	/**
	 * 根据id查询算力配置表信息
	 * @param id
	 * @return List<CalculateRankContentVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<CalculateRankContentVo> selectCalculateRankContentVoListById(Integer id) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankContentVoListById)-根据id查询算力排名列表-传入参数, id:{}", id);
		CalculateRank calculateRank = null;
		try {
			calculateRank = calculateRankMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankContentVoListById)-根据id查询算力排名列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		List<CalculateRankContentVo> calculateRankContentVoList = null;
		if(calculateRank != null) {
			String content = Objects.toString(calculateRank.getContent());
			calculateRankContentVoList = JSONObject.parseObject(content, new TypeReference<List<CalculateRankContentVo>>(){});
		}
		return calculateRankContentVoList;
	}

	/**
	 * 根据日期查询算力排名
	 * @param rankTimeStr
	 * @return List<CalculateRankContentVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<CalculateRankContentVo> selectCalculateRankContentVoListByRankTime(String rankTimeStr) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankContentVoListByRankTime)-根据rankTimeStr查询算力排名表列表-传入参数, rankTimeStr:{}", rankTimeStr);
		CalculateRankParam param = new CalculateRankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		List<CalculateRank> list = null;
		try {
			list = calculateRankMapper.selectCalculateRankList(param);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankContentVoListByRankTime)-根据rankTimeStr查询算力排名列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}

		List<CalculateRankContentVo> calculateRankContentVoList = null;
		if(list != null && !list.isEmpty()) {
			CalculateRank calculateRank = list.get(0);
			String content = Objects.toString(calculateRank.getContent());
			calculateRankContentVoList = JSONObject.parseObject(content, new TypeReference<List<CalculateRankContentVo>>(){});
		}
		return calculateRankContentVoList;
	}

	/**
	 * 根据id查询算力排名
	 * @param id
	 * @return CalculateRank
	 * @throws BootServiceException
	 */
	@Override
	public CalculateRank selectCalculateRankById(Integer id) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankById)-根据id查询算力排名-传入参数, id:{}", id);
		CalculateRank calculateRank = null;

		try {
			calculateRank = calculateRankMapper.selectByPrimaryKey(id);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankById)-根据id查询算力排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return calculateRank;
	}

//	/**
//	 * 插入算力排名
//	 * @return calculateRankId
//	 * @return calculateRankContentVo
//	 * @throws BootServiceException
//	 */
//	@Override
//	public Integer insertCalculateRank(Integer calculateRankId,CalculateRankContentVo calculateRankContentVo) throws BootServiceException {
//		logger.info("(BootCalculateRankService-insertCalculateRank)-传入参数, calculateRankId:{}, calculateRankContentVo:{}", calculateRankId, calculateRankContentVo);
//		//存储信息进行排序，null值转为空，
//		SerializerFeature[] serializerFeature = new SerializerFeature[]{
//			SerializerFeature.MapSortField, SerializerFeature.WriteNullStringAsEmpty
//		};
//		int i = 0;
//		if(calculateRankId == null) {
//			List<CalculateRankContentVo> list = new ArrayList<CalculateRankContentVo>();
//			list.add(calculateRankContentVo);
//			CalculateRank calculateRank = new CalculateRank();
//			calculateRank.setContent(JSONArray.toJSONString(list, serializerFeature));
//			calculateRank.setRankTime(new Date());
//			calculateRank.setCreateTime(new Date());
//			calculateRank.setUpdateTime(new Date());
//			i = calculateRankMapper.insertSelective(calculateRank);
//			logger.info("(BootCalculateRankService-insertCalculateRank)-插入算力排名-返回信息, i:{}", i);
//			calculateRankId = calculateRank.getCalculateRankId();
//		} else {
//			CalculateRankParam param = new CalculateRankParam();
//			param.setCalculateRankId(calculateRankId);
//			StringBuffer sb = new StringBuffer();
//			sb.append("'userId' ,").append(calculateRankContentVo.getUserId()).append(",");
//			sb.append("'userAccount' , '").append(calculateRankContentVo.getUserAccount()).append("',");
//			sb.append("'calculate' ,").append(calculateRankContentVo.getCalculate()).append(",");
//			sb.append("'percent' ,").append(calculateRankContentVo.getPercent()).append(",");
//			sb.append("'sort' ,").append(calculateRankContentVo.getSort()).append(",");
//			sb.append("'sortTime' , '").append(calculateRankContentVo.getSortTime()).append("'");
//			param.setRankStr(sb.toString());
////			int rows = calculateRankMapper.selectCalculateRankRowsById(param);
////			logger.info("(BootCalculateRankService-insertCalculateRank)-获取条数, rows:{}", rows);
////			param.setRows(rows);
//			logger.info("(BootDiamondRankService-insertCalculateRank)-修改算力排名, param:{}", param);
//			i = calculateRankMapper.updateCalculateRank(param);
//			logger.info("(BootCalculateRankService-insertCalculateRank)-修改算力排名-返回信息, i:{}", i);
//		}
//		return i;
//	}
//
//
//
//	/**
//	 * 插入或更新算力排名
//	 * @param calculateRankId
//	 * @param calculateRankContentVo
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	@Override
//	public Integer insertOrUpdateCalculateRank(Integer calculateRankId,CalculateRankContentVo calculateRankContentVo) throws BootServiceException {
//		logger.info("(BootCalculateRankService-insertOrUpdateCalculateRank)-传入参数, calculateRankId:{}, calculateRankContentVo:{}", calculateRankId, calculateRankContentVo);
//		//存储信息进行排序，null值转为空，
//		SerializerFeature[] serializerFeature = new SerializerFeature[]{
//			SerializerFeature.MapSortField, SerializerFeature.WriteNullStringAsEmpty
//		};
//		int i = 0;
//		if(calculateRankId == null) {
//			List<CalculateRankContentVo> list = new ArrayList<CalculateRankContentVo>();
//			list.add(calculateRankContentVo);
//			CalculateRank calculateRank = new CalculateRank();
//			calculateRank.setContent(JSONArray.toJSONString(list, serializerFeature));
//			calculateRank.setRankTime(new Date());
//			calculateRank.setCreateTime(new Date());
//			calculateRank.setUpdateTime(new Date());
//			i = calculateRankMapper.insertSelective(calculateRank);
//			logger.info("(BootCalculateRankService-insertOrUpdateCalculateRank)-插入算力排名-返回信息, i:{}", i);
//			calculateRankId = calculateRank.getCalculateRankId();
//		} else {
//			CalculateRankParam param = new CalculateRankParam();
//			param.setCalculateRankId(calculateRankId);
//			StringBuffer sb = new StringBuffer();
//			sb.append("'userId' ,").append(calculateRankContentVo.getUserId()).append(",");
//			sb.append("'userAccount' , '").append(calculateRankContentVo.getUserAccount()).append("',");
//			sb.append("'calculate' ,").append(calculateRankContentVo.getCalculate()).append(",");
//			sb.append("'percent' ,").append(calculateRankContentVo.getPercent()).append(",");
//			sb.append("'sort' ,").append(calculateRankContentVo.getSort()).append(",");
//			sb.append("'sortTime' , '").append(calculateRankContentVo.getSortTime()).append("'");
//			param.setRankStr(sb.toString());
//			logger.info("(BootCalculateRankService-insertOrUpdateCalculateRank)-修改算力排名, param:{}", param);
//			i = calculateRankMapper.updateCalculateRank(param);
//			logger.info("(BootCalculateRankService-insertOrUpdateCalculateRank)-修改算力排名-返回信息, i:{}", i);
//		}
//		return calculateRankId;
//	}
//
//	/**
//	 * 修改算力排名
//	 * @param calculateRank
//	 * @return Integer
//	 * @throws BootServiceException
//	 */
//	@Override
//	public Integer modifyCalculateRank(CalculateRank calculateRank) throws BootServiceException {
//		logger.info("(BootCalculateRankService-modifyCalculateRank)-修改算力排名-传入参数, calculateRank:{}", calculateRank);
//		calculateRank.setUpdateTime(new Date());
//		int i = 0;
//		try{
//			i = calculateRankMapper.updateByPrimaryKeySelective(calculateRank);
//		} catch (Exception e) {
//			logger.error("(BootCalculateRankService-modifyCalculateRank)-修改算力排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
//			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
//		}
//		if(i<=0) {
//			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
//		}
//		return i;
//	}

	/**
	 * 插入算力排名空内容数组
	 * @param calculateRank
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer insertCalculateRankContentNullArray(CalculateRank calculateRank) throws BootServiceException {
		logger.info("(BootCalculateRankService-insertCalculateRankContentNullArray)-传入参数, calculateRank:{}", calculateRank);
		calculateRank.setCreateTime(new Date());
		calculateRank.setUpdateTime(new Date());
  		int i = 0;
  		try{
  			i = calculateRankMapper.insertSelective(calculateRank);
  		} catch (Exception e) {
  			logger.error("(BootCalculateRankService-insertCalculateRankContentNullArray)-插入算力排名空内容数组-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
		return i;
	}

	/**
	 * 修改算力排名内容
	 * @param calculateRankId
	 * @param calculateRankContentVo
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer modifyCalculateRankContent(Integer calculateRankId,CalculateRankContentVo calculateRankContentVo) throws BootServiceException {
		logger.info("(BootCalculateRankService-modifyCalculateRankContent)-传入参数, calculateRankId:{}, calculateRankContentVo:{}", calculateRankId, calculateRankContentVo);
		CalculateRankParam param = new CalculateRankParam();
		param.setCalculateRankId(calculateRankId);
		StringBuffer sb = new StringBuffer();
		sb.append("'userId' ,").append(calculateRankContentVo.getUserId()).append(",");
		sb.append("'userAccount' , '").append(calculateRankContentVo.getUserAccount()).append("',");
		sb.append("'calculate' ,").append(calculateRankContentVo.getCalculate()).append(",");
		sb.append("'percent' ,").append(calculateRankContentVo.getPercent()).append(",");
		sb.append("'sort' ,").append(calculateRankContentVo.getSort()).append(",");
		sb.append("'sortTime' , '").append(calculateRankContentVo.getSortTime()).append("'");
		param.setRankStr(sb.toString());
		int i = 0;
  		try{
  			logger.info("(BootCalculateRankService-modifyCalculateRankContent)-修改算力排名内容, param:{}", param);
			i = calculateRankMapper.updateCalculateRank(param);
			logger.info("(BootCalculateRankService-modifyCalculateRankContent)修改算力排名内容-返回信息, i:{}", i);
  		} catch (Exception e) {
  			logger.error("(BootCalculateRankService-modifyCalculateRankContent)-修改算力排名内容-事务性异常, Exception = {}, message = {}", e, e.getMessage());
  			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
  		}
  		if(i<=0) {
  			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
  		}
		return i;
	}

	/**
	 * 根据userAccount分页查询算力排名
	 * @param page
	 * @param param
	 * @return List<CalculateRankContentVo>
	 * @throws BootServiceException
	 */
	@Override
	public List<CalculateRankContentVo> selectCalculateRankContentVoListUserAccount(Page<CalculateRankContentVo> page, CalculateRankParam param) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankListByPage)-根据userAccount分页查询-传入参数, page:{}, param:{}", page, param);
		List<CalculateRank> list = null;
		try {
			list = calculateRankMapper.selectCalculateRankListByUserAccount(param);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankContentVoListByPage)-根据userAccount分页查询-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		List<CalculateRankContentVo> calculateRankContentVoList = new ArrayList<CalculateRankContentVo>();
		if(list != null && !list.isEmpty()) {
			CalculateRank calculateRank = list.get(0);
			String content = Objects.toString(calculateRank.getContent());
			calculateRankContentVoList.add(JSONObject.parseObject(content, new TypeReference<CalculateRankContentVo>(){}));
		}
		return calculateRankContentVoList;
	}

	/**
	 * 根据userAccount查询算力排名列表
	 * @param param
	 * @return CalculateRank
	 * @throws BootServiceException
	 */
	@Override
	public List<CalculateRank> selectCalculateRankListByUserAccount(CalculateRankParam param) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankListByUserAccount)-传入参数, param:{}", param);
		List<CalculateRank> list = null;
		try {
			list = calculateRankMapper.selectCalculateRankListByUserAccount(param);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankListByUserAccount)-根据userAccount查询算力排名列表-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		return list;
	}

	/**
	 * 根据userAccount查询算力排名
	 * @param param
	 * @return CalculateRank
	 * @throws BootServiceException
	 */
	@Override
	public CalculateRank selectCalculateRankByUserAccount(CalculateRankParam param) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankByUserAccount)-传入参数, param:{}", param);
		List<CalculateRank> list = null;
		try {
			list = calculateRankMapper.selectCalculateRankListByUserAccount(param);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankByUserAccount)-根据userAccount查询算力排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		CalculateRank calculateRank = null;
		if(list != null && !list.isEmpty()) {
			calculateRank = list.get(0);
		}
		return calculateRank;
	}

	/**
	 * 根据userId查询算力排名
	 * @param param
	 * @return CalculateRank
	 * @throws BootServiceException
	 */
	@Override
	public CalculateRank selectCalculateRankByUserId(CalculateRankParam param) throws BootServiceException {
		logger.info("(BootCalculateRankService-selectCalculateRankByUserId)-传入参数, param:{}", param);
		List<CalculateRank> list = null;
		try {
			list = calculateRankMapper.selectCalculateRankListByUserId(param);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-selectCalculateRankByUserId)-根据userId查询算力排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		CalculateRank calculateRank = null;
		if(list != null && !list.isEmpty()) {
			calculateRank = list.get(0);
		}
		return calculateRank;
	}

	/**
	 * 根据排名时间删除算力排名
	 * @param rankTimeStr
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer deleteCalculateRankByRankTime(String rankTimeStr) throws BootServiceException {
		logger.info("(BootCalculateRankService-deleteCalculateRankByRankTime)-根据排名时间删除算力排名-传入参数, rankTimeStr:{}", rankTimeStr);
		CalculateRankParam param = new CalculateRankParam();
		param.setRankTimeStartStr(rankTimeStr+DateFormatConstants.TIME_START);
		param.setRankTimeEndStr(rankTimeStr+DateFormatConstants.TIME_END);
		int i = 0;
		try {
			i = calculateRankMapper.deleteCalculateRankByRankTime(param);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-deleteCalculateRankByRankTime)-根据排名时间删除算力排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

	/**
	 * 根据排名时间删除排名时间之前算力排名
	 * @param rankTime
	 * @return Integer
	 * @throws BootServiceException
	 */
	@Override
	public Integer deleteCalculateRankByBeforeRankTime(Date rankTime) throws BootServiceException {
		logger.info("(BootCalculateRankService-deleteCalculateRankByBeforeRankTime)-根据排名时间删除排名时间之前算力排名-传入参数, rankTime:{}", rankTime);

		CalculateRankExample example = new CalculateRankExample();
		CalculateRankExample.Criteria criteria = example.createCriteria();
		criteria.andRankTimeLessThanOrEqualTo(rankTime);
		int i = 0;
		try {
			i = calculateRankMapper.deleteByExample(example);
		} catch (Exception e) {
			logger.error("(BootCalculateRankService-deleteCalculateRankByBeforeRankTime)-根据排名时间删除排名时间之前算力排名-事务性异常, Exception = {}, message = {}", e, e.getMessage());
			throw new BootServiceException(BootWheelConstants.BOOT_SYSTEM_ERROR, BootWheelConstants.BOOT_SYSTEM_ERROR_MSG);
		}
		if(i<=0) {
			throw new BootServiceException(BootWheelConstants.BOOT_DATABASE_ERROR, BootWheelConstants.BOOT_DATABASE_ERROR_MSG);
		}
		return i;
	}

}