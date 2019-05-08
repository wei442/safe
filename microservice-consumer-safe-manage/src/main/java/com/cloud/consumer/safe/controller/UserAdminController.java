package com.cloud.consumer.safe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.cloud.common.constants.safe.SafeConstants;
import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.consumer.safe.base.BaseRestMapResponse;
import com.cloud.consumer.safe.base.BaseRestRequest;
import com.cloud.consumer.safe.page.PageVo;
import com.cloud.consumer.safe.rest.request.page.user.UserAdminPageRequest;
import com.cloud.consumer.safe.rest.request.user.UserAdminIdRequest;
import com.cloud.consumer.safe.rest.request.user.UserAdminMasterRequest;
import com.cloud.consumer.safe.rest.request.user.UserAdminRequest;
import com.cloud.consumer.safe.service.IUserAdminService;
import com.cloud.consumer.safe.validator.group.UpdateGroup;
import com.cloud.consumer.safe.vo.base.BasePageResultVo;
import com.cloud.consumer.safe.vo.base.BaseResultVo;
import com.cloud.consumer.safe.vo.user.UserAdminVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理管理 UserAdminController
 * @author wei.yong
 * @ClassName: UserAdminController
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user/admin")
public class UserAdminController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理 Service
	@Autowired
	private IUserAdminService userAdminService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户管理列表")
	@RequestMapping(value="/getListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getListByPage(
		@RequestBody UserAdminPageRequest req) {
		logger.info("===step1:【分页查询】(UserAdminController-getListByPage)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);
		req.setAdminType(SqlSafeConstants.SQL_USER_ADMIN_TYPE_SLAVE);

		JSONObject jsonUserAdmin = userAdminService.getListByPage(req);
		logger.info("===step2:【分页查询】(UserAdminController-getListByPage)-分页查询用户管理列表, jsonUserAdmin:{}", jsonUserAdmin);
		String dataListStr = JSONObject.toJSONString(jsonUserAdmin.getJSONArray(PageConstants.DATA_LIST));
		String pageStr = JSONObject.toJSONString(jsonUserAdmin.getJSONObject(PageConstants.PAGE));
		List<UserAdminVo> userAdminVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserAdminVo>>(){});
		PageVo pageVo = JSONObject.parseObject(pageStr, PageVo.class);

		BasePageResultVo result = new BasePageResultVo(pageVo, userAdminVoList);
		//返回信息
		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.put(CommConstants.RESULT, result);
	    logger.info("===step3:【分页查询】(UserAdminController-getListByPage)-返回信息, userAdminResponse:{}", userAdminResponse);
	    return userAdminResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户管理列表")
	@RequestMapping(value="/getList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getList(
		@RequestBody UserAdminPageRequest req) {
		logger.info("===step1:【不分页查询】(UserAdminController-getList)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);
		req.setAdminType(SqlSafeConstants.SQL_USER_ADMIN_TYPE_SLAVE);

		JSONObject jsonUserAdmin = userAdminService.getList(req);
		logger.info("===step2:【不分页查询】(UserAdminController-getList)-不分页查询用户管理列表, jsonUserAdmin:{}", jsonUserAdmin);
		String dataListStr = JSONObject.toJSONString(jsonUserAdmin.getJSONArray(PageConstants.DATA_LIST));
		List<UserAdminVo> userAdminVoList  = JSONObject.parseObject(dataListStr, new TypeReference<List<UserAdminVo>>(){});

		BaseResultVo result = new BaseResultVo(userAdminVoList);
		//返回信息
		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.put(CommConstants.RESULT, result);
		logger.info("===step3:【不分页查询】(UserAdminController-getList)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 获取用户管理详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户管理详情")
	@RequestMapping(value="/getDetail",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getDetail(
		@Validated @RequestBody UserAdminIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户管理】(UserAdminController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAdminId = req.getUserAdminId();
		JSONObject jsonUserAdmin = userAdminService.getById(userAdminId);
		logger.info("===step2:【获取用户管理】(UserAdminController-getDetail)-根据userAdminId获取用户管理, jsonUserAdmin:{}", jsonUserAdmin);
		UserAdminVo userAdminVo = JSONObject.toJavaObject(jsonUserAdmin, UserAdminVo.class);

		//返回信息
		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.put(CommConstants.RESULT, userAdminVo);
	    logger.info("===step3:【获取用户管理】(UserAdminController-getDetail)-返回信息, userAdminResponse:{}", userAdminResponse);
	    return userAdminResponse;
	}

	/**
	 * 获取用户管理详情
	 * @param req
	 * @param request
	 * @param response
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "获取用户主管理员")
	@RequestMapping(value="/getMaster",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse getMaster(
		@Validated @RequestBody BaseRestRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【获取用户管理】(UserAdminController-getDetail)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer enterpriseId = this.getTokenEnterpriseId();
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("enterpriseId", enterpriseId);
		JSONObject jsonUserAdmin = userAdminService.getMaster(params);
		logger.info("===step2:【获取用户管理】(UserAdminController-getDetail)-根据userAdminId获取用户管理, jsonUserAdmin:{}", jsonUserAdmin);
		UserAdminVo userAdminVo = JSONObject.toJavaObject(jsonUserAdmin, UserAdminVo.class);

		//返回信息
		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		userAdminResponse.put(CommConstants.RESULT, userAdminVo);
	    logger.info("===step3:【获取用户管理】(UserAdminController-getDetail)-返回信息, userAdminResponse:{}", userAdminResponse);
	    return userAdminResponse;
	}

	/**
	 * 新增用户管理
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "新增用户管理")
	@RequestMapping(value="/add",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse add(
		@Validated @RequestBody UserAdminRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【新增用户管理】(UserAdminController-add)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);
		req.setAdminName(SafeConstants.ADMIN_NAME_SALVE);

		JSONObject jsonUserAdmin = userAdminService.add(req);
		logger.info("===step2:【新增用户管理】(UserAdminController-add)-分页查询用户管理列表, jsonUserAdmin:{}", jsonUserAdmin);

		//返回信息
		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
	    logger.info("===step3:【新增用户管理】(UserAdminController-add)-返回信息, userAdminResponse:{}", userAdminResponse);
	    return userAdminResponse;
	}

	/**
	 * 删除用户管理
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "删除用户管理")
	@RequestMapping(value="/delete",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse delete(
		@Validated @RequestBody UserAdminIdRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【删除用户管理】(UserAdminController-delete)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAdminId = req.getUserAdminId();
		JSONObject jsonUserAdmin = userAdminService.deleteById(userAdminId);
		logger.info("===step2:【删除用户管理】(UserAdminController-delete)-根据userAdminId删除用户管理, jsonUserAdmin:{}", jsonUserAdmin);

		//返回信息
		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【删除用户管理】(UserAdminController-delete)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 修改用户管理
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户管理")
	@RequestMapping(value="/update",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse update(
		@Validated({ UpdateGroup.class }) @RequestBody UserAdminRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户管理】(UserAdminController-update)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserAdmin = userAdminService.update(req);
		logger.info("===step2:【修改用户管理】(UserAdminController-update)-修改用户管理, jsonUserAdmin:{}", jsonUserAdmin);

		//返回信息
		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户管理】(UserAdminController-update)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

	/**
	 * 更改用户主管理员
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "更改用户主管理员")
	@RequestMapping(value="/changeMaster",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse changeMaster(
		@Validated @RequestBody UserAdminMasterRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【更改用户主管理员】(UserAdminController-changeMaster)-请求参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		Integer enterpriseId = this.getTokenEnterpriseId();
		req.setEnterpriseId(enterpriseId);

		JSONObject jsonUserAdmin = userAdminService.changeMaster(req);
		logger.info("===step2:【更改用户主管理员】(UserAdminController-changeMaster)-修改用户管理, jsonUserAdmin:{}", jsonUserAdmin);

		//返回信息
		BaseRestMapResponse userAdminResponse = new BaseRestMapResponse();
		logger.info("===step3:【更改用户主管理员】(UserAdminController-changeMaster)-返回信息, userAdminResponse:{}", userAdminResponse);
		return userAdminResponse;
	}

}