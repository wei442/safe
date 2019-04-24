package com.cloud.consumer.safe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.PageConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.dict.DangerCheckIdRequest;
import com.cloud.consumer.safe.rest.request.dict.DangerCheckRequest;
import com.cloud.consumer.safe.rest.request.page.dict.DangerCheckPageRequest;
import com.cloud.consumer.safe.service.IDangerCheckService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.dict.DangerCheckVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 字典子项管理 DangerCheckController
 * @author wei.yong
 * @ClassName: DangerCheckController
 */
@Api(tags = "字典子项")
@RestController
@RequestMapping("/danger/check")
public class DangerCheckController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//字典子项 Service
	@Autowired
	private IDangerCheckService dangerCheckService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询字典子项列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody DangerCheckPageRequest req) {
		logger.info("===step1:【分页查询】(DangerCheckController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDangerCheck = dangerCheckService.getListByPage(req);
		logger.info("===step2:【分页查询】(DangerCheckController-getListByPage)-分页查询字典子项列表, jsonDangerCheck:{}", jsonDangerCheck);
		String dataListStr = JSONObject.toJSONString(jsonDangerCheck.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonDangerCheck.getJSONObject(PageConstants.PAGE));
		List<DangerCheckVo> dangerCheckVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DangerCheckVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, dangerCheckVoList);
		//返回信息
		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		dangerCheckResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(DangerCheckController-getListByPage)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
	    return dangerCheckResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询字典子项列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody DangerCheckPageRequest req) {
		logger.info("===step1:【不分页查询】(DangerCheckController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDangerCheck = dangerCheckService.getList(req);
		logger.info("===step2:【不分页查询】(DangerCheckController-getList)-不分页查询字典子项列表, jsonDangerCheck:{}", jsonDangerCheck);
		String dataListStr = JSONObject.toJSONString(jsonDangerCheck.getJSONArray(PageConstants.DATA_LIST));
		List<DangerCheckVo> dangerCheckVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DangerCheckVo>>(){});

		BaseResultVo result = new BaseResultVo(dangerCheckVoList);
		//返回信息
		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		dangerCheckResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(DangerCheckController-getList)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

	/**
	 * 获取字典子项详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取字典子项详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody DangerCheckIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取字典子项】(DangerCheckController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerCheckId = req.getDangerCheckId();
		JSONObject jsonDangerCheck = dangerCheckService.getById(dangerCheckId);
		logger.info("===step2:【获取字典子项】(DangerCheckController-getDetail)-根据dangerCheckId获取字典子项, jsonDangerCheck:{}", jsonDangerCheck);
		DangerCheckVo dangerCheckVo = JSONObject.toJavaObject(jsonDangerCheck, DangerCheckVo.class);

		//返回信息
		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		dangerCheckResponse.put(CommConstants.RESULT, dangerCheckVo);
	    logger.info("===step3:【获取字典子项】(DangerCheckController-getDetail)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
	    return dangerCheckResponse;
	}

	/**
	 * 新增字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增字典子项")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody DangerCheckRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增字典子项】(DangerCheckController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDangerCheck = dangerCheckService.add(req);
		logger.info("===step2:【新增字典子项】(DangerCheckController-add)-分页查询字典子项列表, jsonDangerCheck:{}", jsonDangerCheck);

		//返回信息
		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增字典子项】(DangerCheckController-add)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
	    return dangerCheckResponse;
	}

	/**
	 * 删除字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除字典子项")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody DangerCheckIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除字典子项】(DangerCheckController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerCheckId = req.getDangerCheckId();
		JSONObject jsonDangerCheck = dangerCheckService.deleteById(dangerCheckId);
		logger.info("===step2:【删除字典子项】(DangerCheckController-delete)-根据dangerCheckId删除字典子项, jsonDangerCheck:{}", jsonDangerCheck);

		//返回信息
		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除字典子项】(DangerCheckController-delete)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

	/**
	 * 修改字典子项
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改字典子项")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody DangerCheckRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典子项】(DangerCheckController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDangerCheck = dangerCheckService.update(req);
		logger.info("===step2:【修改字典子项】(DangerCheckController-update)-修改字典子项, jsonDangerCheck:{}", jsonDangerCheck);

		//返回信息
		BaseRestMapResponse dangerCheckResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改字典子项】(DangerCheckController-update)-返回信息, dangerCheckResponse:{}", dangerCheckResponse);
		return dangerCheckResponse;
	}

}