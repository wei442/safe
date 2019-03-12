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
import com.cloud.consumer.safe.rest.request.UserOrgIdRequest;
import com.cloud.consumer.safe.rest.request.UserOrgRequest;
import com.cloud.consumer.safe.rest.request.page.UserOrgPageRequest;
import com.cloud.consumer.safe.service.IUserOrgService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.UserOrgVo;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户机构管理 UserOrgController
 * @author wei.yong
 * @ClassName: UserOrgController
 */
@Api(tags = "用户机构")
@RestController
@RequestMapping("/user/userOrg")
public class UserOrgController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户机构 Service
	@Autowired
	private IUserOrgService userOrgService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户机构列表")
	@RequestMapping(value="/getUserOrgListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserOrgListByPage(
		@RequestBody UserOrgPageRequest req) {
		logger.info("===step1:【分页查询】(UserOrgController-getUserOrgListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserOrg = userOrgService.getUserOrgListByPage(req);
		logger.info("===step2:【分页查询】(UserOrgController-getUserOrgListByPage)-分页查询用户机构列表, jsonUserOrg:{}", jsonUserOrg);
		String dataListStr = JSONObject.toJSONString(jsonUserOrg.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserOrg.getJSONObject(PageConstants.PAGE));
		List<UserOrgVo> userOrgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserOrgVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userOrgVoList);
		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(RetSafeConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserOrgController-getUserOrgListByPage)-返回信息, userOrgResponse:{}", userOrgResponse);
	    return userOrgResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户机构列表")
	@RequestMapping(value="/getUserOrgList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserOrgList(
		@RequestBody UserOrgPageRequest req) {
		logger.info("===step1:【不分页查询】(UserOrgController-getUserOrgList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserOrg = userOrgService.getUserOrgListByPage(req);
		logger.info("===step2:【不分页查询】(UserOrgController-getUserOrgList)-不分页查询用户机构列表, jsonUserOrg:{}", jsonUserOrg);
		String dataListStr = JSONObject.toJSONString(jsonUserOrg.getJSONArray(PageConstants.DATA_LIST));
		List<UserOrgVo> userOrgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserOrgVo>>(){});

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(RetSafeConstants.RESULT, userOrgVoList);
		logger.info("===step3:【不分页查询】(UserOrgController-getUserOrgList)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 获取用户机构详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户机构详情")
	@RequestMapping(value="/getUserOrg",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getUserOrg(
		@Validated @RequestBody UserOrgIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户机构】(UserOrgController-getUserOrg)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userOrgId = req.getUserOrgId();
		JSONObject jsonUserOrg = userOrgService.getUserOrgById(userOrgId);
		logger.info("===step2:【获取用户机构】(UserOrgController-getUserOrg)-根据userOrgId获取用户机构, jsonUserOrg:{}", jsonUserOrg);
		UserOrgVo userOrgVo = JSONObject.toJavaObject(jsonUserOrg, UserOrgVo.class);

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(RetSafeConstants.RESULT, userOrgVo);
	    logger.info("===step3:【获取用户机构】(UserOrgController-getUserOrg)-返回信息, userOrgResponse:{}", userOrgResponse);
	    return userOrgResponse;
	}

	/**
	 * 新增用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户机构")
	@RequestMapping(value="/addUserOrg",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse addUserOrg(
		@Validated @RequestBody UserOrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户机构】(UserOrgController-addUserOrg)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonUserOrg = userOrgService.addUserOrg(req);
		logger.info("===step2:【新增用户机构】(UserOrgController-addUserOrg)-分页查询用户机构列表, jsonUserOrg:{}", jsonUserOrg);
		UserOrgVo userOrgVo = JSONObject.toJavaObject(jsonUserOrg, UserOrgVo.class);

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(RetSafeConstants.RESULT, userOrgVo);
	    logger.info("===step3:【新增用户机构】(UserOrgController-addUserOrg)-返回信息, userOrgResponse:{}", userOrgResponse);
	    return userOrgResponse;
	}

	/**
	 * 删除用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户机构")
	@RequestMapping(value="/deleteUserOrg",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteUserOrg(
		@Validated @RequestBody UserOrgIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户机构】(UserOrgController-deleteUserOrg)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		Integer userOrgId = req.getUserOrgId();
		JSONObject jsonUserOrg = userOrgService.deleteUserOrgById(userOrgId);
		logger.info("===step2:【删除用户机构】(UserOrgController-deleteUserOrg)-根据userOrgId删除用户机构, jsonUserOrg:{}", jsonUserOrg);
		UserOrgVo userOrgVo = JSONObject.toJavaObject(jsonUserOrg, UserOrgVo.class);

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(RetSafeConstants.RESULT, userOrgVo);
		logger.info("===step3:【删除用户机构】(UserOrgController-deleteUserOrg)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 修改用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户机构")
	@RequestMapping(value="/updateUserOrg",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse updateUserOrg(
		@Validated({ UpdateGroup.class }) @RequestBody UserOrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户机构】(UserOrgController-updateUserOrg)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		this.bindingResult(bindingResult);

		JSONObject jsonUserOrg = userOrgService.addUserOrg(req);
		logger.info("===step2:【修改用户机构】(UserOrgController-updateUserOrg)-修改用户机构, jsonUserOrg:{}", jsonUserOrg);
		UserOrgVo userOrgVo = JSONObject.toJavaObject(jsonUserOrg, UserOrgVo.class);

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(RetSafeConstants.RESULT, userOrgVo);
		logger.info("===step3:【修改用户机构】(UserOrgController-updateUserOrg)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

}