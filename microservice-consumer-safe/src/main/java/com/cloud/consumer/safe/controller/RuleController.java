package com.cloud.consumer.safe.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.cloud.common.constants.CommConstants;
import com.cloud.common.constants.PageConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.activity.RuleIdRequest;
import com.cloud.consumer.safe.rest.request.activity.RuleRequest;
import com.cloud.consumer.safe.rest.request.page.activity.RulePageRequest;
import com.cloud.consumer.safe.service.IAttachmentService;
import com.cloud.consumer.safe.service.IRuleService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.activity.RuleAttachmentVo;
import com.cloud.consumer.safe.vo.activity.RuleVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.domain.upload.FastFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 规范文件管理 RuleController
 * @author wei.yong
 * @ClassName: RuleController
 */
@Api(tags = "规范文件")
@RestController
@RequestMapping("/rule")
public class RuleController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//规范文件 Service
	@Autowired
	private IRuleService ruleService;

	//附件 Service
	@Autowired
	private IAttachmentService attachmentService;


	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询规范文件列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody RulePageRequest req) {
		logger.info("===step1:【分页查询】(RuleController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonRule = ruleService.getListByPage(req);
		logger.info("===step2:【分页查询】(RuleController-getListByPage)-分页查询规范文件列表, jsonRule:{}", jsonRule);
		String dataListStr = JSONObject.toJSONString(jsonRule.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonRule.getJSONObject(PageConstants.PAGE));
		List<RuleVo> ruleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RuleVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, ruleVoList);
		//返回信息
		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		ruleResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(RuleController-getListByPage)-返回信息, ruleResponse:{}", ruleResponse);
	    return ruleResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询规范文件列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody RulePageRequest req) {
		logger.info("===step1:【不分页查询】(RuleController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonRule = ruleService.getListByPage(req);
		logger.info("===step2:【不分页查询】(RuleController-getList)-不分页查询规范文件列表, jsonRule:{}", jsonRule);
		String dataListStr = JSONObject.toJSONString(jsonRule.getJSONArray(PageConstants.DATA_LIST));
		List<RuleVo> ruleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<RuleVo>>(){});

		BaseResultVo result = new BaseResultVo(ruleVoList);
		//返回信息
		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		ruleResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(RuleController-getList)-返回信息, ruleResponse:{}", ruleResponse);
		return ruleResponse;
	}

	/**
	 * 获取规范文件详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取规范文件详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse get(
		@Validated @RequestBody RuleIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取规范文件】(RuleController-get)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer ruleId = req.getRuleId();
		JSONObject jsonRule = ruleService.getById(ruleId);
		logger.info("===step2:【获取规范文件】(RuleController-get)-根据ruleId获取规范文件, jsonRule:{}", jsonRule);
		RuleVo ruleVo = JSONObject.toJavaObject(jsonRule, RuleVo.class);

		//返回信息
		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		ruleResponse.put(CommConstants.RESULT, ruleVo);
	    logger.info("===step3:【获取规范文件】(RuleController-get)-返回信息, ruleResponse:{}", ruleResponse);
	    return ruleResponse;
	}

	/**
	 * 新增规范文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增规范文件")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody RuleRequest req, @RequestPart("fileList") MultipartFile[] multipartFiles,
		BindingResult bindingResult) {
		logger.info("===step1:【新增规范文件】(RuleController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		List<RuleAttachmentVo> ruleAttachments = new ArrayList<RuleAttachmentVo>();
		RuleAttachmentVo ruleAttachmentVo = null;
		if(multipartFiles != null && multipartFiles.length >0) {
			for (MultipartFile multipartFile : multipartFiles) {
				ruleAttachmentVo = new RuleAttachmentVo();
				long fileSize = multipartFile.getSize();
				String fileName = multipartFile.getOriginalFilename();
				InputStream inputStream = null;
				try {
					inputStream = multipartFile.getInputStream();
				} catch (IOException e) {
					e.printStackTrace();
				}
				FastFile fastImageFile = new FastFile(inputStream, fileSize, fileName, null);
				StorePath storePath = fastFileStorageClient.uploadFile(fastImageFile);
				String fullPath = storePath.getFullPath();

				ruleAttachmentVo.setAttachmentUrl(fullPath);
				ruleAttachments.add(ruleAttachmentVo);
			}
		}

		req.setRuleAttachments(ruleAttachments);
		JSONObject jsonRule = ruleService.add(req);
		logger.info("===step2:【新增规范文件】(RuleController-add)-分页查询规范文件列表, jsonRule:{}", jsonRule);
		RuleVo ruleVo = JSONObject.toJavaObject(jsonRule, RuleVo.class);

		//返回信息
		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		ruleResponse.put(CommConstants.RESULT, ruleVo);
	    logger.info("===step3:【新增规范文件】(RuleController-add)-返回信息, ruleResponse:{}", ruleResponse);
	    return ruleResponse;
	}

	/**
	 * 删除规范文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除规范文件")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody RuleIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除规范文件】(RuleController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer ruleId = req.getRuleId();
		JSONObject jsonRule = ruleService.deleteById(ruleId);
		logger.info("===step2:【删除规范文件】(RuleController-delete)-根据ruleId删除规范文件, jsonRule:{}", jsonRule);
		RuleVo ruleVo = JSONObject.toJavaObject(jsonRule, RuleVo.class);

		//返回信息
		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		ruleResponse.put(CommConstants.RESULT, ruleVo);
		logger.info("===step3:【删除规范文件】(RuleController-delete)-返回信息, ruleResponse:{}", ruleResponse);
		return ruleResponse;
	}

	/**
	 * 修改规范文件
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改规范文件")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody RuleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改规范文件】(RuleController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonRule = ruleService.update(req);
		logger.info("===step2:【修改规范文件】(RuleController-update)-修改规范文件, jsonRule:{}", jsonRule);
		RuleVo ruleVo = JSONObject.toJavaObject(jsonRule, RuleVo.class);

		//返回信息
		BaseRestMapResponse ruleResponse = new BaseRestMapResponse();
		ruleResponse.put(CommConstants.RESULT, ruleVo);
		logger.info("===step3:【修改规范文件】(RuleController-update)-返回信息, ruleResponse:{}", ruleResponse);
		return ruleResponse;
	}

}