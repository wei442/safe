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
import com.cloud.consumer.safe.rest.request.page.user.UserMenuPageRequest;
import com.cloud.consumer.safe.rest.request.user.UserMenuIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserMenuIdsRequest;
import com.cloud.consumer.safe.rest.request.user.UserMenuRequest;
import com.cloud.consumer.safe.service.IUserMenuService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.user.UserMenuVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户菜单管理 UserMenuController
 * @author wei.yong
 * @ClassName: UserMenuController
 */
@Api(tags = "用户菜单")
@RestController
@RequestMapping("/user/menu")
public class UserMenuController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户菜单 Service
	@Autowired
	private IUserMenuService userMenuService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户菜单列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody UserMenuPageRequest req) {
		logger.info("===step1:【分页查询】(UserMenuController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserMenu = userMenuService.getListByPage(req);
		logger.info("===step2:【分页查询】(UserMenuController-getListByPage)-分页查询用户菜单列表, jsonUserMenu:{}", jsonUserMenu);
		String dataListStr = JSONObject.toJSONString(jsonUserMenu.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserMenu.getJSONObject(PageConstants.PAGE));
		List<UserMenuVo> userMenuVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserMenuVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userMenuVoList);
		//返回信息
		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		userMenuResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserMenuController-getListByPage)-返回信息, userMenuResponse:{}", userMenuResponse);
	    return userMenuResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户菜单列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody UserMenuPageRequest req) {
		logger.info("===step1:【不分页查询】(UserMenuController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserMenu = userMenuService.getList(req);
		logger.info("===step2:【不分页查询】(UserMenuController-getList)-不分页查询用户菜单列表, jsonUserMenu:{}", jsonUserMenu);
		String dataListStr = JSONObject.toJSONString(jsonUserMenu.getJSONArray(PageConstants.DATA_LIST));
		List<UserMenuVo> userMenuVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserMenuVo>>(){});

		BaseResultVo result = new BaseResultVo(userMenuVoList);
		//返回信息
		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		userMenuResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(UserMenuController-getList)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}

	/**
	 * 获取用户菜单详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户菜单详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody UserMenuIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户菜单】(UserMenuController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userMenuId = req.getUserMenuId();
		JSONObject jsonUserMenu = userMenuService.getById(userMenuId);
		logger.info("===step2:【获取用户菜单】(UserMenuController-getDetail)-根据userMenuId获取用户菜单, jsonUserMenu:{}", jsonUserMenu);
		UserMenuVo userMenuVo = JSONObject.toJavaObject(jsonUserMenu, UserMenuVo.class);

		//返回信息
		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		userMenuResponse.put(CommConstants.RESULT, userMenuVo);
	    logger.info("===step3:【获取用户菜单】(UserMenuController-getDetail)-返回信息, userMenuResponse:{}", userMenuResponse);
	    return userMenuResponse;
	}

	/**
	 * 新增用户菜单
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户菜单")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserMenuRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户菜单】(UserMenuController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserMenu = userMenuService.add(req);
		logger.info("===step2:【新增用户菜单】(UserMenuController-add)-分页查询用户菜单列表, jsonUserMenu:{}", jsonUserMenu);

		//返回信息
		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增用户菜单】(UserMenuController-add)-返回信息, userMenuResponse:{}", userMenuResponse);
	    return userMenuResponse;
	}

	/**
	 * 删除用户菜单
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除用户菜单")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserMenuIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户菜单】(UserMenuController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userMenuId = req.getUserMenuId();
		JSONObject jsonUserMenu = userMenuService.deleteById(userMenuId);
		logger.info("===step2:【删除用户菜单】(UserMenuController-delete)-根据userMenuId删除用户菜单, jsonUserMenu:{}", jsonUserMenu);

		//返回信息
		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除用户菜单】(UserMenuController-delete)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}

	/**
	 * 批量删除用户菜单
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "批量删除用户菜单")
	@RequestMapping(value="/batchDelete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse batchDelete(
		@Validated @RequestBody UserMenuIdsRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【批量删除用户菜单】(UserMenuController-batchDelete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		JSONObject jsonUserMenu = userMenuService.batchDelete(req);
		logger.info("===step2:【批量删除用户菜单】(UserMenuController-batchDelete)-根据userMenuIds删除用户菜单, jsonUserMenu:{}", jsonUserMenu);

		//返回信息
		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		logger.info("===step3:【批量删除用户菜单】(UserMenuController-batchDelete)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}

	/**
	 * 修改用户菜单
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户菜单")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserMenuRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户菜单】(UserMenuController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserMenu = userMenuService.update(req);
		logger.info("===step2:【修改用户菜单】(UserMenuController-update)-修改用户菜单, jsonUserMenu:{}", jsonUserMenu);

		//返回信息
		BaseRestMapResponse userMenuResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户菜单】(UserMenuController-update)-返回信息, userMenuResponse:{}", userMenuResponse);
		return userMenuResponse;
	}

}