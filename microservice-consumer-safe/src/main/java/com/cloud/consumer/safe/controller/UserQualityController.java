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
import com.cloud.common.constants.CommConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.page.user.UserQualityPageRequest;
import com.cloud.consumer.safe.rest.request.user.UserQualityIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserQualityRequest;
import com.cloud.consumer.safe.service.IUserQualityService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.user.UserQualityVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户资质管理 UserQualityController
 * @author wei.yong
 * @ClassName: UserQualityController
 */
@Api(tags = "用户资质")
@RestController
@RequestMapping("/user/quality")
public class UserQualityController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户资质 Service
	@Autowired
	private IUserQualityService userQualityService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户资质列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody UserQualityPageRequest req) {
		logger.info("===step1:【分页查询】(UserQualityController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserQuality = userQualityService.getListByPage(req);
		logger.info("===step2:【分页查询】(UserQualityController-getListByPage)-分页查询用户资质列表, jsonUserQuality:{}", jsonUserQuality);
		String dataListStr = JSONObject.toJSONString(jsonUserQuality.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserQuality.getJSONObject(PageConstants.PAGE));
		List<UserQualityVo> userQualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserQualityVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userQualityVoList);
		//返回信息
		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserQualityController-getListByPage)-返回信息, userQualityResponse:{}", userQualityResponse);
	    return userQualityResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户资质列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody UserQualityPageRequest req) {
		logger.info("===step1:【不分页查询】(UserQualityController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserQuality = userQualityService.getListByPage(req);
		logger.info("===step2:【不分页查询】(UserQualityController-getList)-不分页查询用户资质列表, jsonUserQuality:{}", jsonUserQuality);
		String dataListStr = JSONObject.toJSONString(jsonUserQuality.getJSONArray(PageConstants.DATA_LIST));
		List<UserQualityVo> userQualityVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserQualityVo>>(){});

		BaseResultVo result = new BaseResultVo(userQualityVoList);
		//返回信息
		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(UserQualityController-getList)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 获取用户资质详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户资质详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse get(
		@Validated @RequestBody UserQualityIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户资质】(UserQualityController-get)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userQualityId = req.getUserQualityId();
		JSONObject jsonUserQuality = userQualityService.getById(userQualityId);
		logger.info("===step2:【获取用户资质】(UserQualityController-get)-根据userQualityId获取用户资质, jsonUserQuality:{}", jsonUserQuality);
		UserQualityVo userQualityVo = JSONObject.toJavaObject(jsonUserQuality, UserQualityVo.class);

		//返回信息
		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.put(CommConstants.RESULT, userQualityVo);
	    logger.info("===step3:【获取用户资质】(UserQualityController-get)-返回信息, userQualityResponse:{}", userQualityResponse);
	    return userQualityResponse;
	}

	/**
	 * 新增用户资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户资质")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户资质】(UserQualityController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserQuality = userQualityService.add(req);
		logger.info("===step2:【新增用户资质】(UserQualityController-add)-分页查询用户资质列表, jsonUserQuality:{}", jsonUserQuality);
		UserQualityVo userQualityVo = JSONObject.toJavaObject(jsonUserQuality, UserQualityVo.class);

		//返回信息
		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.put(CommConstants.RESULT, userQualityVo);
	    logger.info("===step3:【新增用户资质】(UserQualityController-add)-返回信息, userQualityResponse:{}", userQualityResponse);
	    return userQualityResponse;
	}

	/**
	 * 删除用户资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户资质")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserQualityIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户资质】(UserQualityController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userQualityId = req.getUserQualityId();
		JSONObject jsonUserQuality = userQualityService.deleteById(userQualityId);
		logger.info("===step2:【删除用户资质】(UserQualityController-delete)-根据userQualityId删除用户资质, jsonUserQuality:{}", jsonUserQuality);
		UserQualityVo userQualityVo = JSONObject.toJavaObject(jsonUserQuality, UserQualityVo.class);

		//返回信息
		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.put(CommConstants.RESULT, userQualityVo);
		logger.info("===step3:【删除用户资质】(UserQualityController-delete)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

	/**
	 * 修改用户资质
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户资质")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserQualityRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户资质】(UserQualityController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserQuality = userQualityService.update(req);
		logger.info("===step2:【修改用户资质】(UserQualityController-update)-修改用户资质, jsonUserQuality:{}", jsonUserQuality);
		UserQualityVo userQualityVo = JSONObject.toJavaObject(jsonUserQuality, UserQualityVo.class);

		//返回信息
		BaseRestMapResponse userQualityResponse = new BaseRestMapResponse();
		userQualityResponse.put(CommConstants.RESULT, userQualityVo);
		logger.info("===step3:【修改用户资质】(UserQualityController-update)-返回信息, userQualityResponse:{}", userQualityResponse);
		return userQualityResponse;
	}

}