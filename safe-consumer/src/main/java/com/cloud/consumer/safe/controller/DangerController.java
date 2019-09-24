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
import com.cloud.consumer.safe.rest.request.danger.DangerIdRequest;
import com.cloud.consumer.safe.rest.request.danger.DangerRequest;
import com.cloud.consumer.safe.rest.request.page.danger.DangerPageRequest;
import com.cloud.consumer.safe.service.IDangerService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.danger.DangerVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 隐患管理 DangerController
 * @author wei.yong
 * @ClassName: DangerController
 */
@Api(tags = "隐患")
@RestController
@RequestMapping("/danger")
public class DangerController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//隐患 Service
	@Autowired
	private IDangerService dangerService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询隐患列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody DangerPageRequest req) {
		logger.info("===step1:【分页查询】(DangerController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDanger = dangerService.getListByPage(req);
		logger.info("===step2:【分页查询】(DangerController-getListByPage)-分页查询隐患列表, jsonDanger:{}", jsonDanger);
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
	@ApiOperation(value = "不分页查询隐患列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody DangerPageRequest req) {
		logger.info("===step1:【不分页查询】(DangerController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDanger = dangerService.getList(req);
		logger.info("===step2:【不分页查询】(DangerController-getList)-不分页查询隐患列表, jsonDanger:{}", jsonDanger);
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
	 * 获取隐患详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取隐患详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody DangerIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取隐患】(DangerController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerId = req.getDangerId();
		JSONObject jsonDanger = dangerService.getById(dangerId);
		logger.info("===step2:【获取隐患】(DangerController-getDetail)-根据dangerId获取隐患, jsonDanger:{}", jsonDanger);
		DangerVo dangerVo = JSONObject.toJavaObject(jsonDanger, DangerVo.class);

		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		dangerResponse.put(CommConstants.RESULT, dangerVo);
	    logger.info("===step3:【获取隐患】(DangerController-getDetail)-返回信息, dangerResponse:{}", dangerResponse);
	    return dangerResponse;
	}

	/**
	 * 新增隐患
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增隐患")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody DangerRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增隐患】(DangerController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDanger = dangerService.add(req);
		logger.info("===step2:【新增隐患】(DangerController-add)-分页查询隐患列表, jsonDanger:{}", jsonDanger);

		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增隐患】(DangerController-add)-返回信息, dangerResponse:{}", dangerResponse);
	    return dangerResponse;
	}

	/**
	 * 删除隐患
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除隐患")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody DangerIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除隐患】(DangerController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerId = req.getDangerId();
		JSONObject jsonDanger = dangerService.deleteById(dangerId);
		logger.info("===step2:【删除隐患】(DangerController-delete)-根据dangerId删除隐患, jsonDanger:{}", jsonDanger);

		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除隐患】(DangerController-delete)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
	}

	/**
	 * 修改隐患
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改隐患")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody DangerRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改隐患】(DangerController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDanger = dangerService.update(req);
		logger.info("===step2:【修改隐患】(DangerController-update)-修改隐患, jsonDanger:{}", jsonDanger);

		//返回信息
		BaseRestMapResponse dangerResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改隐患】(DangerController-update)-返回信息, dangerResponse:{}", dangerResponse);
		return dangerResponse;
	}

}