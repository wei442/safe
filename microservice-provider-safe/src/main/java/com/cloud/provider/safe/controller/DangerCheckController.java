package com.cloud.provider.safe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.PageConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.DangerCheck;
import com.cloud.provider.safe.rest.request.danger.DangerCheckIdsRequest;
import com.cloud.provider.safe.rest.request.danger.DangerCheckRequest;
import com.cloud.provider.safe.rest.request.page.danger.DangerCheckPageRequest;
import com.cloud.provider.safe.service.IDangerCheckService;
import com.cloud.provider.safe.util.Assert;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.danger.DangerCheckVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 隐患排查 DangerCheckController
 * @author wei.yong
 */
@Api(tags = "隐患排查")
@RestController
@RequestMapping(value="/danger/check")
public class DangerCheckController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//隐患排查Service
	@Autowired
	private IDangerCheckService dangerCheckService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询隐患排查列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody DangerCheckPageRequest req) {
		logger.info("===step1:【分页查询隐患排查列表】(DangerCheckController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<DangerCheck> list = dangerCheckService.selectListByPage(page, req);
		logger.info("===step2:【分页查询隐患排查列表】(DangerCheckController-selectListByPage)-分页查询隐患排查列表, list.size:{}", list == null ? null : list.size());
		List<DangerCheckVo> dangerCheckVoList = new DangerCheckVo().convertToDangerCheckVoList(list);

		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		dangerCheckResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		dangerCheckResponse.put(PageConstants.DATA_LIST, dangerCheckVoList);
		logger.info("===step3:【分页查询隐患排查列表】(DangerCheckController-selectListByPage)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询隐患排查")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody DangerCheckPageRequest req) {
		logger.info("===step1:【不分页查询隐患排查列表】(DangerCheckController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<DangerCheck> list = dangerCheckService.selectList(req);
		logger.info("===step2:【不分页查询隐患排查列表】(DangerCheckController-selectList)-不分页查询隐患排查列表, list.size:{}", list == null ? null : list.size());
		List<DangerCheckVo> dangerCheckVoList = new DangerCheckVo().convertToDangerCheckVoList(list);

		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		dangerCheckResponse.put(PageConstants.DATA_LIST, dangerCheckVoList);
		logger.info("===step3:【不分页查询隐患排查列表】(DangerCheckController-selectList)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

	/**
	 * 据id查询隐患排查
	 * @param dangerCheckId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询隐患排查")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer dangerCheckId) {
		logger.info("===step1:【据id查询隐患排查】(DangerCheckController-selectById)-传入参数, dangerCheckId:{}", dangerCheckId);

		if(dangerCheckId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "dangerCheckId不能为空");
		}

		DangerCheck dangerCheck = dangerCheckService.selectById(dangerCheckId);
		Assert.thanOrEqualZreo(dangerCheck, SafeResultEnum.DATABASE_NOTEXIST);
		logger.info("===step2:【据id查询隐患排查】(DangerCheckController-selectById)-根据id查询隐患排查, dangerCheck:{}", dangerCheck);
		DangerCheckVo dangerCheckVo = new DangerCheckVo().convertToDangerCheckVo(dangerCheck);

		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		dangerCheckResponse.putAll((JSONObject) JSONObject.toJSON(dangerCheckVo));
		logger.info("===step3:【据id查询隐患排查】(DangerCheckController-selectById)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

	/**
	 * 据userId查询隐患排查
	 * @param userId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询隐患排查")
	@RequestMapping(value="/selectByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserId(
		@PathVariable(value="userId",required=false) Integer userId) {
		logger.info("===step1:【据userId查询隐患排查】(DangerCheckController-selectByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userId不能为空");
		}

		DangerCheck dangerCheck = dangerCheckService.selectByUserId(userId);
		Assert.thanOrEqualZreo(dangerCheck, SafeResultEnum.DATABASE_NOTEXIST);
		logger.info("===step2:【据userId查询隐患排查】(DangerCheckController-selectByUserId)-根据userId查询隐患排查, dangerCheck:{}", dangerCheck);
		DangerCheckVo dangerCheckVo = new DangerCheckVo().convertToDangerCheckVo(dangerCheck);

		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		dangerCheckResponse.putAll((JSONObject) JSONObject.toJSON(dangerCheckVo));
		logger.info("===step3:【据userId查询隐患排查】(DangerCheckController-selectByUserId)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

	/**
	 * 添加隐患排查
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加隐患排查")
	@RequestMapping(value="/insertDangerCheck",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody DangerCheckRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加隐患排查】(DangerCheckController-insertDangerCheck)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		DangerCheck dangerCheck = req.convertToDangerCheck();
		int i = dangerCheckService.insert(dangerCheck);
		logger.info("===step2:【添加隐患排查】(DangerCheckController-insertDangerCheck)-插入隐患排查, i:{}", i);

		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加隐患排查】(DangerCheckController-insertDangerCheck)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

	/**
	 * 根据id删除隐患排查
	 * @param dangerCheckId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除隐患排查")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer dangerCheckId) {
		logger.info("===step1:【根据id删除隐患排查】(DangerCheckController-deleteById)-传入参数, dangerCheckId:{}", dangerCheckId);

		if(dangerCheckId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "dangerCheckId不能为空");
		}

		int i = dangerCheckService.deleteById(dangerCheckId);
		logger.info("===step2:【根据id删除隐患排查】(DangerCheckController-deleteById)-根据id删除隐患排查, i:{}", i);

		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除隐患排查】(DangerCheckController-deleteById)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

	/**
	 * 批量删除隐患排查
	 * @param dangerCheckIds
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除隐患排查")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody DangerCheckIdsRequest req) {
		logger.info("===step1:【批量删除隐患排查】(DangerCheckController-batchDelete)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		List<Integer> dangerCheckIds = req.getDangerCheckIds();
		int i = dangerCheckService.deleteByIds(dangerCheckIds);
		logger.info("===step2:【批量删除隐患排查】(DangerCheckController-batchDelete)-根据dangerCheckIds删除隐患排查, i:{}", i);

		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除隐患排查】(DangerCheckController-batchDelete)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

	/**
	 * 修改隐患排查
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改隐患排查")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody DangerCheckRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改隐患排查】(DangerCheckController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerCheckId = req.getDangerCheckId();
		DangerCheck dangerCheck = req.convertToDangerCheck();
		dangerCheck.setId(dangerCheckId);
		int i = dangerCheckService.modify(dangerCheck);
		logger.info("===step2:【修改隐患排查】(DangerCheckController-modify)-修改隐患排查, i:{}", i);

		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改隐患排查】(DangerCheckController-modify)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

}