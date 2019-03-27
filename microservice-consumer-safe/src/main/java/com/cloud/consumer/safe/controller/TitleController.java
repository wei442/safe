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
import com.cloud.common.constants.PageConstants;
import com.cloud.common.constants.safe.RetSafeConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.TitleIdRequest;
import com.cloud.consumer.safe.rest.request.TitleRequest;
import com.cloud.consumer.safe.rest.request.page.TitlePageRequest;
import com.cloud.consumer.safe.service.ITitleService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.TitleVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 职务管理 TitleController
 * @author wei.yong
 * @ClassName: TitleController
 */
@Api(tags = "职务")
@RestController
@RequestMapping("/title")
public class TitleController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//职务 Service
	@Autowired
	private ITitleService titleService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询职务列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody TitlePageRequest req) {
		logger.info("===step1:【分页查询】(TitleController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonTitle = titleService.getListByPage(req);
		logger.info("===step2:【分页查询】(TitleController-getListByPage)-分页查询职务列表, jsonTitle:{}", jsonTitle);
		String dataListStr = JSONObject.toJSONString(jsonTitle.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonTitle.getJSONObject(PageConstants.PAGE));
		List<TitleVo> titleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<TitleVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, titleVoList);
		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(TitleController-getListByPage)-返回信息, titleResponse:{}", titleResponse);
	    return titleResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询职务列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody TitlePageRequest req) {
		logger.info("===step1:【不分页查询】(TitleController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonTitle = titleService.getListByPage(req);
		logger.info("===step2:【不分页查询】(TitleController-getList)-不分页查询职务列表, jsonTitle:{}", jsonTitle);
		String dataListStr = JSONObject.toJSONString(jsonTitle.getJSONArray(PageConstants.DATA_LIST));
		List<TitleVo> titleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<TitleVo>>(){});

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVoList);
		logger.info("===step3:【不分页查询】(TitleController-getList)-返回信息, titleResponse:{}", titleResponse);
		return titleResponse;
	}

	/**
	 * 获取职务详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取职务详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse get(
		@Validated @RequestBody TitleIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取职务】(TitleController-get)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer titleId = req.getTitleId();
		JSONObject jsonTitle = titleService.getById(titleId);
		logger.info("===step2:【获取职务】(TitleController-get)-根据titleId获取职务, jsonTitle:{}", jsonTitle);
		TitleVo titleVo = JSONObject.toJavaObject(jsonTitle, TitleVo.class);

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVo);
	    logger.info("===step3:【获取职务】(TitleController-get)-返回信息, titleResponse:{}", titleResponse);
	    return titleResponse;
	}

	/**
	 * 新增职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增职务")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增职务】(TitleController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonTitle = titleService.add(req);
		logger.info("===step2:【新增职务】(TitleController-add)-分页查询职务列表, jsonTitle:{}", jsonTitle);
		TitleVo titleVo = JSONObject.toJavaObject(jsonTitle, TitleVo.class);

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVo);
	    logger.info("===step3:【新增职务】(TitleController-add)-返回信息, titleResponse:{}", titleResponse);
	    return titleResponse;
	}

	/**
	 * 删除职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除职务")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody TitleIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除职务】(TitleController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer titleId = req.getTitleId();
		JSONObject jsonTitle = titleService.deleteById(titleId);
		logger.info("===step2:【删除职务】(TitleController-delete)-根据titleId删除职务, jsonTitle:{}", jsonTitle);
		TitleVo titleVo = JSONObject.toJavaObject(jsonTitle, TitleVo.class);

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVo);
		logger.info("===step3:【删除职务】(TitleController-delete)-返回信息, titleResponse:{}", titleResponse);
		return titleResponse;
	}

	/**
	 * 修改职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改职务")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改职务】(TitleController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonTitle = titleService.update(req);
		logger.info("===step2:【修改职务】(TitleController-update)-修改职务, jsonTitle:{}", jsonTitle);
		TitleVo titleVo = JSONObject.toJavaObject(jsonTitle, TitleVo.class);

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVo);
		logger.info("===step3:【修改职务】(TitleController-update)-返回信息, titleResponse:{}", titleResponse);
		return titleResponse;
	}

}