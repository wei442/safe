package com.cloud.provider.safe.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.cloud.common.constants.PageConstants;
import com.cloud.common.constants.safe.SqlSafeConstants;
import com.cloud.common.enums.safe.SafeResultEnum;
import com.cloud.provider.safe.base.BaseRestMapResponse;
import com.cloud.provider.safe.page.PageHelperUtil;
import com.cloud.provider.safe.po.UserAdminLogin;
import com.cloud.provider.safe.rest.request.page.user.UserAdminLoginPageRequest;
import com.cloud.provider.safe.rest.request.user.UserAdminLoginRequest;
import com.cloud.provider.safe.service.IUserAdminLoginService;
import com.cloud.provider.safe.validator.group.ModifyGroup;
import com.cloud.provider.safe.vo.user.UserAdminLoginVo;
import com.github.pagehelper.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户管理登录 UserAdminLoginController
 * @author wei.yong
 */
@Api(tags = "用户管理登录")
@RestController
@RequestMapping(value="/user/admin/login")
public class UserAdminLoginController extends BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	//用户管理登录Service
	@Autowired
	private IUserAdminLoginService userAdminLoginService;

	/**
	 * 分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "分页查询用户管理登录列表")
	@RequestMapping(value="/selectListByPage",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectListByPage(
		@RequestBody UserAdminLoginPageRequest req) {
		logger.info("===step1:【分页查询用户管理登录列表】(UserAdminLoginController-selectListByPage)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer pageNum = req.getPageNum();
		Integer pageSize = req.getPageSize();

		Page<?> page = new Page<>(pageNum, pageSize);
		List<UserAdminLogin> list = userAdminLoginService.selectListByPage(page, req);
		logger.info("===step2:【分页查询用户管理登录列表】(UserAdminLoginController-selectListByPage)-分页查询用户管理登录列表, list.size:{}", list == null ? null : list.size());
		List<UserAdminLoginVo> dataList = new UserAdminLoginVo().convertToUserAdminLoginVoList(list);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.put(PageConstants.PAGE, PageHelperUtil.INSTANCE.getPageVo(list));
		userAdminLoginResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【分页查询用户管理登录列表】(UserAdminLoginController-selectListByPage)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 不分页查询
	 * @param req
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "不分页查询用户管理登录列表")
	@RequestMapping(value="/selectList",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectList(
		@RequestBody UserAdminLoginPageRequest req) {
		logger.info("===step1:【不分页查询用户管理登录列表】(UserAdminLoginController-selectList)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));
		List<UserAdminLogin> list = userAdminLoginService.selectList(req);
		logger.info("===step2:【不分页查询用户管理登录列表】(UserAdminLoginController-selectList)-不分页查询用户管理登录列表, list.size:{}", list == null ? null : list.size());
		List<UserAdminLoginVo> dataList = new UserAdminLoginVo().convertToUserAdminLoginVoList(list);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.put(PageConstants.DATA_LIST, dataList);
		logger.info("===step3:【不分页查询用户管理登录列表】(UserAdminLoginController-selectList)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 据id查询用户管理登录
	 * @param userAdminLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id查询用户管理登录")
	@RequestMapping(value="/selectById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectById(
		@PathVariable(value="id",required=false) Integer userAdminLoginId) {
		logger.info("===step1:【据id查询用户管理登录】(UserAdminLoginController-selectById)-传入参数, userAdminLoginId:{}", userAdminLoginId);

		if(userAdminLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userAdminLoginId不能为空");
		}

		UserAdminLogin userAdminLogin = userAdminLoginService.selectById(userAdminLoginId);
		logger.info("===step2:【据id查询用户管理登录】(UserAdminLoginController-selectById)-根据id查询用户管理登录, userAdminLogin:{}", userAdminLogin);
		UserAdminLoginVo userAdminLoginVo = new UserAdminLoginVo().convertToUserAdminLoginVo(userAdminLogin);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.putAll((JSONObject) JSONObject.toJSON(userAdminLoginVo));
		logger.info("===step3:【据id查询用户管理登录】(UserAdminLoginController-selectById)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 据userId查询用户管理登录
	 * @param userId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据userId查询用户管理登录")
	@RequestMapping(value="/selectByUserId/{userId}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse selectByUserId(
		@PathVariable(value="userId",required=false) Integer userId) {
		logger.info("===step1:【据userId查询用户管理登录】(UserAdminLoginController-selectByUserId)-传入参数, userId:{}", userId);

		if(userId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userId不能为空");
		}

		UserAdminLogin userAdminLogin = userAdminLoginService.selectByUserId(userId);
		logger.info("===step2:【据userId查询用户管理登录】(UserAdminLoginController-selectByUserId)-根据id查询用户管理登录, userAdminLogin:{}", userAdminLogin);
		UserAdminLoginVo userAdminLoginVo = new UserAdminLoginVo().convertToUserAdminLoginVo(userAdminLogin);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		userAdminLoginResponse.putAll((JSONObject) JSONObject.toJSON(userAdminLoginVo));
		logger.info("===step3:【据userId查询用户管理登录】(UserAdminLoginController-selectByUserId)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 添加用户管理登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "添加用户管理登录")
	@RequestMapping(value="/insert",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse insert(
		@Validated @RequestBody UserAdminLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【添加用户管理登录】(UserAdminLoginController-insert)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		UserAdminLogin userAdminLogin = req.convertToUserAdminLogin();
		int i = userAdminLoginService.insert(userAdminLogin);
		logger.info("===step2:【添加用户管理登录】(UserAdminLoginController-insert)-插入用户管理登录, i:{}", i);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【添加用户管理登录】(UserAdminLoginController-insert)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 根据id删除用户管理登录
	 * @param userAdminLoginId
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "根据id删除用户管理登录")
	@RequestMapping(value="/deleteById/{id}",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse deleteById(
		@PathVariable(value="id",required=false) Integer userAdminLoginId) {
		logger.info("===step1:【根据id删除用户管理登录】(selectById-deleteById)-传入参数, userAdminLoginId:{}", userAdminLoginId);

		if(userAdminLoginId == null) {
			return new BaseRestMapResponse(SafeResultEnum.PARAMETER_EMPTY.getCode(), "userAdminLoginId不能为空");
		}

		int i = userAdminLoginService.deleteById(userAdminLoginId);
		logger.info("===step2:【根据id删除用户管理登录】(UserAdminLoginController-deleteById)-根据id查询用户管理登录, i:{}", i);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【根据id删除用户管理登录】(UserAdminLoginController-deleteById)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

	/**
	 * 修改用户管理登录
	 * @param req
	 * @param bindingResult
	 * @return BaseRestMapResponse
	 */
	@ApiOperation(value = "修改用户管理登录")
	@RequestMapping(value="/modify",method={RequestMethod.POST})
	@ResponseBody
	public BaseRestMapResponse modify(
		@Validated({ ModifyGroup.class }) @RequestBody UserAdminLoginRequest req,
		BindingResult bindingResult) {
		logger.info("===step1:【修改用户管理登录】(UserAdminLoginController-modify)-传入参数, req:{}, json:{}", req, JSONObject.toJSONString(req));

		Integer userAdminLoginId = req.getUserAdminLoginId();
		UserAdminLogin userAdminLogin = userAdminLoginService.selectById(userAdminLoginId);
		logger.info("===step2:【据id查询用户管理登录】(UserAdminLoginController-selectById)-根据id查询用户管理登录, userAdminLogin:{}", userAdminLogin);

		Long loginCount = userAdminLogin.getLoginCount();
		userAdminLogin.setFirstLogin(SqlSafeConstants.SQL_USER_ADMIN_LOGIN_FIRST_LOGIN_YES);
		userAdminLogin.setLoginCount(loginCount+1);
		int i = userAdminLoginService.modify(userAdminLogin);
		logger.info("===step2:【修改用户管理登录】(UserAdminLoginController-modify)-修改用户管理登录, i:{}", i);

		BaseRestMapResponse userAdminLoginResponse = new BaseRestMapResponse();
		logger.info("===step3:【修改用户管理登录】(UserAdminLoginController-modify)-返回信息, userAdminLoginResponse:{}", userAdminLoginResponse);
		return userAdminLoginResponse;
	}

}