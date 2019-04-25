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
import com.cloud.consumer.safe.rest.request.base.user.BaseUserInfoIdRequest;
import com.cloud.consumer.safe.rest.request.base.user.BaseUserInfoRequest;
import com.cloud.consumer.safe.rest.request.page.base.user.BaseUserInfoPageRequest;
import com.cloud.consumer.safe.service.IBaseUserInfoService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.base.user.BaseUserInfoVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 基础用户信息管理 BaseUserInfoController
 * @author wei.yong
 * @ClassName: BaseUserInfoController
 */
@Api(tags = "基础用户信息")
@RestController
@RequestMapping("/base/user/info")
public class BaseUserInfoController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//基础用户信息 Service
	@Autowired
	private IBaseUserInfoService baseUserInfoService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询基础用户信息列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody BaseUserInfoPageRequest req) {
		logger.info("===step1:【分页查询】(BaseUserInfoController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserInfo = baseUserInfoService.getListByPage(req);
		logger.info("===step2:【分页查询】(BaseUserInfoController-getListByPage)-分页查询基础用户信息列表, jsonBaseUserInfo:{}", jsonBaseUserInfo);
		String dataListStr = JSONObject.toJSONString(jsonBaseUserInfo.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonBaseUserInfo.getJSONObject(PageConstants.PAGE));
		List<BaseUserInfoVo> baseUserInfoVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserInfoVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, baseUserInfoVoList);
		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(BaseUserInfoController-getListByPage)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
	    return baseUserInfoResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询基础用户信息列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody BaseUserInfoPageRequest req) {
		logger.info("===step1:【不分页查询】(BaseUserInfoController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserInfo = baseUserInfoService.getList(req);
		logger.info("===step2:【不分页查询】(BaseUserInfoController-getList)-不分页查询基础用户信息列表, jsonBaseUserInfo:{}", jsonBaseUserInfo);
		String dataListStr = JSONObject.toJSONString(jsonBaseUserInfo.getJSONArray(PageConstants.DATA_LIST));
		List<BaseUserInfoVo> baseUserInfoVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<BaseUserInfoVo>>(){});

		BaseResultVo result = new BaseResultVo(baseUserInfoVoList);
		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(BaseUserInfoController-getList)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 获取基础用户信息详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取基础用户信息详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody BaseUserInfoIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取基础用户信息】(BaseUserInfoController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer baseUserId = req.getBaseUserId();
		JSONObject jsonBaseUserInfo = baseUserInfoService.getById(baseUserId);
		logger.info("===step2:【获取基础用户信息】(BaseUserInfoController-getDetail)-根据baseUserInfoId获取基础用户信息, jsonBaseUserInfo:{}", jsonBaseUserInfo);
		BaseUserInfoVo baseUserInfoVo = JSONObject.toJavaObject(jsonBaseUserInfo, BaseUserInfoVo.class);

		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		baseUserInfoResponse.put(CommConstants.RESULT, baseUserInfoVo);
	    logger.info("===step3:【获取基础用户信息】(BaseUserInfoController-getDetail)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
	    return baseUserInfoResponse;
	}

	/**
	 * 新增基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增基础用户信息")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody BaseUserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增基础用户信息】(BaseUserInfoController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserInfo = baseUserInfoService.add(req);
		logger.info("===step2:【新增基础用户信息】(BaseUserInfoController-add)-分页查询基础用户信息列表, jsonBaseUserInfo:{}", jsonBaseUserInfo);

		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增基础用户信息】(BaseUserInfoController-add)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
	    return baseUserInfoResponse;
	}

	/**
	 * 删除基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除基础用户信息")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody BaseUserInfoIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除基础用户信息】(BaseUserInfoController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer baseUserId = req.getBaseUserId();
		JSONObject jsonBaseUserInfo = baseUserInfoService.deleteById(baseUserId);
		logger.info("===step2:【删除基础用户信息】(BaseUserInfoController-delete)-根据baseUserInfoId删除基础用户信息, jsonBaseUserInfo:{}", jsonBaseUserInfo);

		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除基础用户信息】(BaseUserInfoController-delete)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

	/**
	 * 修改基础用户信息
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改基础用户信息")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody BaseUserInfoRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改基础用户信息】(BaseUserInfoController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonBaseUserInfo = baseUserInfoService.update(req);
		logger.info("===step2:【修改基础用户信息】(BaseUserInfoController-update)-修改基础用户信息, jsonBaseUserInfo:{}", jsonBaseUserInfo);

		//返回信息
		BaseRestMapResponse baseUserInfoResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改基础用户信息】(BaseUserInfoController-update)-返回信息, baseUserInfoResponse:{}", baseUserInfoResponse);
		return baseUserInfoResponse;
	}

}