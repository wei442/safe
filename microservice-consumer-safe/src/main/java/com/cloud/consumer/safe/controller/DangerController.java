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
import com.cloud.consumer.safe.rest.request.dict.DangerIdRequest;
import com.cloud.consumer.safe.rest.request.dict.DangerRequest;
import com.cloud.consumer.safe.rest.request.page.dict.DangerPageRequest;
import com.cloud.consumer.safe.service.IDangerService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.dict.DangerVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 字典子项管理 DangerController
 * @author wei.yong
 * @ClassName: DangerController
 */
@Api(tags = "字典子项")
@RestController
@RequestMapping("/danger")
public class DangerController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//字典子项 Service
	@Autowired
	private IDangerService dangerService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询字典子项列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody DangerPageRequest req) {
		logger.info("===step1:【分页查询】(DangerController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDanger = dangerService.getListByPage(req);
		logger.info("===step2:【分页查询】(DangerController-getListByPage)-分页查询字典子项列表, jsonDanger:{}", jsonDanger);
		String dataListStr = JSONObject.toJSONString(jsonDanger.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonDanger.getJSONObject(PageConstants.PAGE));
		List<DangerVo> dangerVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DangerVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, dangerVoList);
		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		dangerResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(DangerController-getListByPage)-返回信息, dangerResponse:{}", dangerResponse);
	    return dangerResponse;
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
		@RequestBody DangerPageRequest req) {
		logger.info("===step1:【不分页查询】(DangerController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDanger = dangerService.getList(req);
		logger.info("===step2:【不分页查询】(DangerController-getList)-不分页查询字典子项列表, jsonDanger:{}", jsonDanger);
		String dataListStr = JSONObject.toJSONString(jsonDanger.getJSONArray(PageConstants.DATA_LIST));
		List<DangerVo> dangerVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DangerVo>>(){});

		BaseResultVo result = new BaseResultVo(dangerVoList);
		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		dangerResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(DangerController-getList)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
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
		@Validated @RequestBody DangerIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取字典子项】(DangerController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerId = req.getDangerId();
		JSONObject jsonDanger = dangerService.getById(dangerId);
		logger.info("===step2:【获取字典子项】(DangerController-getDetail)-根据dangerId获取字典子项, jsonDanger:{}", jsonDanger);
		DangerVo dangerVo = JSONObject.toJavaObject(jsonDanger, DangerVo.class);

		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		dangerResponse.put(CommConstants.RESULT, dangerVo);
	    logger.info("===step3:【获取字典子项】(DangerController-getDetail)-返回信息, dangerResponse:{}", dangerResponse);
	    return dangerResponse;
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
		@Validated @RequestBody DangerRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增字典子项】(DangerController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDanger = dangerService.add(req);
		logger.info("===step2:【新增字典子项】(DangerController-add)-分页查询字典子项列表, jsonDanger:{}", jsonDanger);

		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增字典子项】(DangerController-add)-返回信息, dangerResponse:{}", dangerResponse);
	    return dangerResponse;
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
		@Validated @RequestBody DangerIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除字典子项】(DangerController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerId = req.getDangerId();
		JSONObject jsonDanger = dangerService.deleteById(dangerId);
		logger.info("===step2:【删除字典子项】(DangerController-delete)-根据dangerId删除字典子项, jsonDanger:{}", jsonDanger);

		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除字典子项】(DangerController-delete)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
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
		@Validated({ UpdateGroup.class }) @RequestBody DangerRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典子项】(DangerController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDanger = dangerService.update(req);
		logger.info("===step2:【修改字典子项】(DangerController-update)-修改字典子项, jsonDanger:{}", jsonDanger);

		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改字典子项】(DangerController-update)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
	}

}