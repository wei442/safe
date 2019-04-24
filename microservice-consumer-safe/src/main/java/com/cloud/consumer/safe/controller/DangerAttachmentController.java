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
import com.cloud.consumer.safe.rest.request.dict.DangerAttachmentIdRequest;
import com.cloud.consumer.safe.rest.request.dict.DangerAttachmentRequest;
import com.cloud.consumer.safe.rest.request.page.dict.DangerAttachmentPageRequest;
import com.cloud.consumer.safe.service.IDangerAttachmentService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.dict.DangerAttachmentVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 字典子项管理 DangerAttachmentController
 * @author wei.yong
 * @ClassName: DangerAttachmentController
 */
@Api(tags = "字典子项")
@RestController
@RequestMapping("/danger/attachment")
public class DangerAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//字典子项 Service
	@Autowired
	private IDangerAttachmentService dangerAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询字典子项列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody DangerAttachmentPageRequest req) {
		logger.info("===step1:【分页查询】(DangerAttachmentController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDangerAttachment = dangerAttachmentService.getListByPage(req);
		logger.info("===step2:【分页查询】(DangerAttachmentController-getListByPage)-分页查询字典子项列表, jsonDangerAttachment:{}", jsonDangerAttachment);
		String dataListStr = JSONObject.toJSONString(jsonDangerAttachment.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonDangerAttachment.getJSONObject(PageConstants.PAGE));
		List<DangerAttachmentVo> dangerAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DangerAttachmentVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, dangerAttachmentVoList);
		//返回信息
		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		dangerAttachmentResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(DangerAttachmentController-getListByPage)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
	    return dangerAttachmentResponse;
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
		@RequestBody DangerAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询】(DangerAttachmentController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDangerAttachment = dangerAttachmentService.getList(req);
		logger.info("===step2:【不分页查询】(DangerAttachmentController-getList)-不分页查询字典子项列表, jsonDangerAttachment:{}", jsonDangerAttachment);
		String dataListStr = JSONObject.toJSONString(jsonDangerAttachment.getJSONArray(PageConstants.DATA_LIST));
		List<DangerAttachmentVo> dangerAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<DangerAttachmentVo>>(){});

		BaseResultVo result = new BaseResultVo(dangerAttachmentVoList);
		//返回信息
		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		dangerAttachmentResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(DangerAttachmentController-getList)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
		return dangerAttachmentResponse;
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
		@Validated @RequestBody DangerAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取字典子项】(DangerAttachmentController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerAttachmentId = req.getDangerAttachmentId();
		JSONObject jsonDangerAttachment = dangerAttachmentService.getById(dangerAttachmentId);
		logger.info("===step2:【获取字典子项】(DangerAttachmentController-getDetail)-根据dangerAttachmentId获取字典子项, jsonDangerAttachment:{}", jsonDangerAttachment);
		DangerAttachmentVo dangerAttachmentVo = JSONObject.toJavaObject(jsonDangerAttachment, DangerAttachmentVo.class);

		//返回信息
		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		dangerAttachmentResponse.put(CommConstants.RESULT, dangerAttachmentVo);
	    logger.info("===step3:【获取字典子项】(DangerAttachmentController-getDetail)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
	    return dangerAttachmentResponse;
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
		@Validated @RequestBody DangerAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增字典子项】(DangerAttachmentController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDangerAttachment = dangerAttachmentService.add(req);
		logger.info("===step2:【新增字典子项】(DangerAttachmentController-add)-分页查询字典子项列表, jsonDangerAttachment:{}", jsonDangerAttachment);

		//返回信息
		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增字典子项】(DangerAttachmentController-add)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
	    return dangerAttachmentResponse;
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
		@Validated @RequestBody DangerAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除字典子项】(DangerAttachmentController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer dangerAttachmentId = req.getDangerAttachmentId();
		JSONObject jsonDangerAttachment = dangerAttachmentService.deleteById(dangerAttachmentId);
		logger.info("===step2:【删除字典子项】(DangerAttachmentController-delete)-根据dangerAttachmentId删除字典子项, jsonDangerAttachment:{}", jsonDangerAttachment);

		//返回信息
		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除字典子项】(DangerAttachmentController-delete)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
		return dangerAttachmentResponse;
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
		@Validated({ UpdateGroup.class }) @RequestBody DangerAttachmentRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改字典子项】(DangerAttachmentController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonDangerAttachment = dangerAttachmentService.update(req);
		logger.info("===step2:【修改字典子项】(DangerAttachmentController-update)-修改字典子项, jsonDangerAttachment:{}", jsonDangerAttachment);

		//返回信息
		BaseRestMapResponse dangerAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改字典子项】(DangerAttachmentController-update)-返回信息, dangerAttachmentResponse:{}", dangerAttachmentResponse);
		return dangerAttachmentResponse;
	}

}