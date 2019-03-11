package com.cloud.consumer.safe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
	@RequestMapping(value="/getTitleListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getTitleListByPage(
		@RequestBody TitlePageRequest req) {
		logger.info("===step1:【分页查询】(TitleController-getTitleListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String titleName = req.getTitleName();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titleName", titleName);
		params.put(PageConstants.PAGE_NUM, pageNum);
		params.put(PageConstants.PAGE_SIZE, pageSize);
		JSONObject jsonTitle = titleService.getTitleListByPage(params);
		logger.info("===step2:【分页查询】(TitleController-getTitleListByPage)-分页查询职务列表, jsonTitle:{}", jsonTitle);
		String dataListStr = JSONObject.toJSONString(jsonTitle.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonTitle.getJSONObject(PageConstants.PAGE));
		List<TitleVo> titleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<TitleVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, titleVoList);
		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(TitleController-getTitleListByPage)-返回信息, titleResponse:{}", titleResponse);
	    return titleResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询职务列表")
	@RequestMapping(value="/getTitleList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getTitleList(
		@RequestBody TitlePageRequest req) {
		logger.info("===step1:【不分页查询】(TitleController-getTitleList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		String titleName = req.getTitleName();
		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titleName", titleName);
		params.put(PageConstants.PAGE_NUM, pageNum);
		params.put(PageConstants.PAGE_SIZE, pageSize);
		JSONObject jsonTitle = titleService.getTitleListByPage(params);
		logger.info("===step2:【不分页查询】(TitleController-getTitleList)-不分页查询职务列表, jsonTitle:{}", jsonTitle);
		String dataListStr = JSONObject.toJSONString(jsonTitle.getJSONArray(PageConstants.DATA_LIST));
		List<TitleVo> titleVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<TitleVo>>(){});

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVoList);
		logger.info("===step3:【不分页查询】(TitleController-getTitleList)-返回信息, titleResponse:{}", titleResponse);
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
	@RequestMapping(value="/getTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getTitle(
		@RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取职务】(TitleController-getTitle)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer titleId = req.getTitleId();
		JSONObject jsonTitle = titleService.getTitleById(titleId);
		logger.info("===step2:【获取职务】(TitleController-getTitle)-根据titleId获取职务, jsonTitle:{}", jsonTitle);
		String retCode = Objects.toString(jsonTitle.get(RetSafeConstants.RET_CODE), "");
		TitleVo titleVo = JSONObject.toJavaObject(jsonTitle, TitleVo.class);

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVo);
	    logger.info("===step3:【获取职务】(TitleController-getTitle)-返回信息, titleResponse:{}", titleResponse);
	    return titleResponse;
	}

	/**
	 * 新增职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增职务")
	@RequestMapping(value="/addTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addTitle(
		@Validated @RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增职务】(TitleController-addTitle)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		String titleName = req.getTitleName();
		String remark = req.getRemark();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titleName", titleName);
		params.put("remark", remark);
		JSONObject jsonTitle = titleService.addTitle(params);
		logger.info("===step2:【新增职务】(TitleController-addTitle)-分页查询职务列表, jsonTitle:{}", jsonTitle);
		String retCode = Objects.toString(jsonTitle.get(RetSafeConstants.RET_CODE), "");
		TitleVo titleVo = JSONObject.toJavaObject(jsonTitle, TitleVo.class);

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVo);
	    logger.info("===step3:【新增职务】(TitleController-addTitle)-返回信息, titleResponse:{}", titleResponse);
	    return titleResponse;
	}

	/**
	 * 删除职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增职务")
	@RequestMapping(value="/deleteTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteTitle(
		@RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除职务】(TitleController-deleteTitle)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer titleId = req.getTitleId();
		JSONObject jsonTitle = titleService.deleteTitleById(titleId);
		logger.info("===step2:【删除职务】(TitleController-deleteTitle)-根据titleId删除职务, jsonTitle:{}", jsonTitle);
		TitleVo titleVo = JSONObject.toJavaObject(jsonTitle, TitleVo.class);

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVo);
		logger.info("===step3:【删除职务】(TitleController-deleteTitle)-返回信息, titleResponse:{}", titleResponse);
		return titleResponse;
	}

	/**
	 * 修改职务
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改职务")
	@RequestMapping(value="/updateTitle",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateTitle(
		@Validated({ UpdateGroup.class }) @RequestBody TitleRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改职务】(TitleController-updateTitle)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer titleId = req.getTitleId();
		String titleName = req.getTitleName();
		String remark = req.getRemark();

		Map<String, Object> params = new HashMap<String, Object>();
		params.put("titleId", titleId);
		params.put("titleName", titleName);
		params.put("remark", remark);
		JSONObject jsonTitle = titleService.addTitle(params);
		logger.info("===step2:【修改职务】(TitleController-updateTitle)-修改职务, jsonTitle:{}", jsonTitle);
		TitleVo titleVo = JSONObject.toJavaObject(jsonTitle, TitleVo.class);

		//返回信息
		BaseRestMapResponse titleResponse = new BaseRestMapResponse();
		titleResponse.put(RetSafeConstants.RESULT, titleVo);
		logger.info("===step3:【修改职务】(TitleController-updateTitle)-返回信息, titleResponse:{}", titleResponse);
		return titleResponse;
	}

}