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
import com.cloud.consumer.safe.rest.request.enterprise.OrgQualityAttachmentIdRequest;
import com.cloud.consumer.safe.rest.request.page.enterprise.OrgQualityAttachmentPageRequest;
import com.cloud.consumer.safe.service.IOrgQualityAttachmentService;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.enterprise.OrgQualityAttachmentVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 机构资质附件管理 OrgQualityAttachmentController
 * @author wei.yong
 * @ClassName: OrgQualityAttachmentController
 */
@Api(tags = "机构资质附件")
@RestController
@RequestMapping("/org/quality/attachment")
public class OrgQualityAttachmentController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//机构资质附件 Service
	@Autowired
	private IOrgQualityAttachmentService orgQualityAttachmentService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询机构资质附件列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody OrgQualityAttachmentPageRequest req) {
		logger.info("===step1:【分页查询】(OrgQualityAttachmentController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonOrgQualityAttachment = orgQualityAttachmentService.getListByPage(req);
		logger.info("===step2:【分页查询】(OrgQualityAttachmentController-getListByPage)-分页查询机构资质附件列表, jsonOrgQualityAttachment:{}", jsonOrgQualityAttachment);
		String dataListStr = JSONObject.toJSONString(jsonOrgQualityAttachment.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonOrgQualityAttachment.getJSONObject(PageConstants.PAGE));
		List<OrgQualityAttachmentVo> orgQualityAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<OrgQualityAttachmentVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, orgQualityAttachmentVoList);
		//返回信息
		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		orgQualityAttachmentResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(OrgQualityAttachmentController-getListByPage)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
	    return orgQualityAttachmentResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询机构资质附件列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody OrgQualityAttachmentPageRequest req) {
		logger.info("===step1:【不分页查询】(OrgQualityAttachmentController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonOrgQualityAttachment = orgQualityAttachmentService.getList(req);
		logger.info("===step2:【不分页查询】(OrgQualityAttachmentController-getList)-不分页查询机构资质附件列表, jsonOrgQualityAttachment:{}", jsonOrgQualityAttachment);
		String dataListStr = JSONObject.toJSONString(jsonOrgQualityAttachment.getJSONArray(PageConstants.DATA_LIST));
		List<OrgQualityAttachmentVo> orgQualityAttachmentVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<OrgQualityAttachmentVo>>(){});

		BaseResultVo result = new BaseResultVo(orgQualityAttachmentVoList);
		//返回信息
		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		orgQualityAttachmentResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(OrgQualityAttachmentController-getList)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
		return orgQualityAttachmentResponse;
	}

	/**
	 * 获取机构资质附件详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取机构资质附件详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody OrgQualityAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取机构资质附件】(OrgQualityAttachmentController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgQualityAttachmentId = req.getOrgQualityAttachmentId();
		JSONObject jsonOrgQualityAttachment = orgQualityAttachmentService.getById(orgQualityAttachmentId);
		logger.info("===step2:【获取机构资质附件】(OrgQualityAttachmentController-getDetail)-根据orgQualityAttachmentId获取机构资质附件, jsonOrgQualityAttachment:{}", jsonOrgQualityAttachment);
		OrgQualityAttachmentVo orgQualityAttachmentVo = JSONObject.toJavaObject(jsonOrgQualityAttachment, OrgQualityAttachmentVo.class);

		//返回信息
		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		orgQualityAttachmentResponse.put(CommConstants.RESULT, orgQualityAttachmentVo);
	    logger.info("===step3:【获取机构资质附件】(OrgQualityAttachmentController-getDetail)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
	    return orgQualityAttachmentResponse;
	}

	/**
	 * 新增机构资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增机构资质附件")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody OrgQualityAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增机构资质附件】(OrgQualityAttachmentController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonOrgQualityAttachment = orgQualityAttachmentService.add(req);
		logger.info("===step2:【新增机构资质附件】(OrgQualityAttachmentController-add)-分页查询机构资质附件列表, jsonOrgQualityAttachment:{}", jsonOrgQualityAttachment);

		//返回信息
		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增机构资质附件】(OrgQualityAttachmentController-add)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
	    return orgQualityAttachmentResponse;
	}

	/**
	 * 删除机构资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除机构资质附件")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody OrgQualityAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除机构资质附件】(OrgQualityAttachmentController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer orgQualityAttachmentId = req.getOrgQualityAttachmentId();
		JSONObject jsonOrgQualityAttachment = orgQualityAttachmentService.deleteById(orgQualityAttachmentId);
		logger.info("===step2:【删除机构资质附件】(OrgQualityAttachmentController-delete)-根据orgQualityAttachmentId删除机构资质附件, jsonOrgQualityAttachment:{}", jsonOrgQualityAttachment);

		//返回信息
		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除机构资质附件】(OrgQualityAttachmentController-delete)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
		return orgQualityAttachmentResponse;
	}

	/**
	 * 修改机构资质附件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改机构资质附件")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated @RequestBody OrgQualityAttachmentIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改机构资质附件】(OrgQualityAttachmentController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonOrgQualityAttachment = orgQualityAttachmentService.update(req);
		logger.info("===step2:【修改机构资质附件】(OrgQualityAttachmentController-update)-修改机构资质附件, jsonOrgQualityAttachment:{}", jsonOrgQualityAttachment);

		//返回信息
		BaseRestMapResponse orgQualityAttachmentResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改机构资质附件】(OrgQualityAttachmentController-update)-返回信息, orgQualityAttachmentResponse:{}", orgQualityAttachmentResponse);
		return orgQualityAttachmentResponse;
	}

}