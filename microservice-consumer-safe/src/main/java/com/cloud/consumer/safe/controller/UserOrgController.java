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
import com.cloud.consumer.safe.rest.request.page.user.UserOrgPageRequest;
import com.cloud.consumer.safe.rest.request.user.UserOrgIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserOrgIdsRequest;
import com.cloud.consumer.safe.rest.request.user.UserOrgRequest;
import com.cloud.consumer.safe.service.IUserOrgService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.user.UserOrgVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户机构管理 UserOrgController
 * @author wei.yong
 * @ClassName: UserOrgController
 */
@Api(tags = "用户机构")
@RestController
@RequestMapping("/user/org")
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
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody UserOrgPageRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【分页查询】(UserOrgController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserOrg = userOrgService.getListByPage(req);
		logger.info("===step2:【分页查询】(UserOrgController-getListByPage)-分页查询用户机构列表, jsonUserOrg:{}", jsonUserOrg);
		String dataListStr = JSONObject.toJSONString(jsonUserOrg.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserOrg.getJSONObject(PageConstants.PAGE));
		List<UserOrgVo> userOrgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserOrgVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userOrgVoList);
		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserOrgController-getListByPage)-返回信息, userOrgResponse:{}", userOrgResponse);
	    return userOrgResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户机构列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody UserOrgPageRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【不分页查询】(UserOrgController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserOrg = userOrgService.getList(req);
		logger.info("===step2:【不分页查询】(UserOrgController-getList)-不分页查询用户机构列表, jsonUserOrg:{}", jsonUserOrg);
		String dataListStr = JSONObject.toJSONString(jsonUserOrg.getJSONArray(PageConstants.DATA_LIST));
		List<UserOrgVo> userOrgVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserOrgVo>>(){});

		BaseResultVo result = new BaseResultVo(userOrgVoList);
		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(UserOrgController-getList)-返回信息, userOrgResponse:{}", userOrgResponse);
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
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody UserOrgIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户机构】(UserOrgController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userOrgId = req.getUserOrgId();
		JSONObject jsonUserOrg = userOrgService.getById(userOrgId);
		logger.info("===step2:【获取用户机构】(UserOrgController-getDetail)-根据userOrgId获取用户机构, jsonUserOrg:{}", jsonUserOrg);
		UserOrgVo userOrgVo = JSONObject.toJavaObject(jsonUserOrg, UserOrgVo.class);

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		userOrgResponse.put(CommConstants.RESULT, userOrgVo);
	    logger.info("===step3:【获取用户机构】(UserOrgController-getDetail)-返回信息, userOrgResponse:{}", userOrgResponse);
	    return userOrgResponse;
	}

	/**
	 * 新增用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户机构")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserOrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户机构】(UserOrgController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserOrg = userOrgService.add(req);
		logger.info("===step2:【新增用户机构】(UserOrgController-add)-分页查询用户机构列表, jsonUserOrg:{}", jsonUserOrg);

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增用户机构】(UserOrgController-add)-返回信息, userOrgResponse:{}", userOrgResponse);
	    return userOrgResponse;
	}

	/**
	 * 删除用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除用户机构")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserOrgIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户机构】(UserOrgController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userOrgId = req.getUserOrgId();
		JSONObject jsonUserOrg = userOrgService.deleteById(userOrgId);
		logger.info("===step2:【删除用户机构】(UserOrgController-delete)-根据userOrgId删除用户机构, jsonUserOrg:{}", jsonUserOrg);

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除用户机构】(UserOrgController-delete)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 批量删除用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除用户机构")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody UserOrgIdsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【批量删除用户机构】(UserOrgController-batchDelete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserOrg = userOrgService.batchDelete(req);
		logger.info("===step2:【批量删除用户机构】(UserOrgController-batchDelete)-根据userOrgIds删除用户机构, jsonUserOrg:{}", jsonUserOrg);

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除用户机构】(UserOrgController-batchDelete)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

	/**
	 * 修改用户机构
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户机构")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserOrgRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户机构】(UserOrgController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserOrg = userOrgService.update(req);
		logger.info("===step2:【修改用户机构】(UserOrgController-update)-修改用户机构, jsonUserOrg:{}", jsonUserOrg);
		UserOrgVo userOrgVo = JSONObject.toJavaObject(jsonUserOrg, UserOrgVo.class);

		//返回信息
		BaseRestMapResponse userOrgResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户机构】(UserOrgController-update)-返回信息, userOrgResponse:{}", userOrgResponse);
		return userOrgResponse;
	}

}